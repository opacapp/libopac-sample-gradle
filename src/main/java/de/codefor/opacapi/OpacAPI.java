package de.codefor.opacapi;

import de.geeksfactory.opacclient.OpacApiFactory;
import de.geeksfactory.opacclient.apis.OpacApi;
import de.geeksfactory.opacclient.i18n.DummyStringProvider;
import de.geeksfactory.opacclient.networking.HttpClientFactory;
import de.geeksfactory.opacclient.networking.NotReachableException;
import de.geeksfactory.opacclient.objects.DetailedItem;
import de.geeksfactory.opacclient.objects.Library;
import de.geeksfactory.opacclient.objects.SearchRequestResult;
import de.geeksfactory.opacclient.searchfields.SearchField;
import de.geeksfactory.opacclient.searchfields.SearchQuery;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.SSLException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

public class OpacAPI {

    // public static String LIBRARY_NAME = "Bremen";
    // public static String LIBRARY_CONFIG = "{\"account_supported\":true,\"api\":\"sisis\",\"city\":\"Bremen\",\"country\":\"Deutschland\",\"data\":{\"baseurl\":\"https://opac.stadtbibliothek-bremen.de/webOPACClient\"},\"geo\":[53.07929619999999,8.8016937],\"information\":\"http://www.stadtbibliothek-bremen.de/bibliotheken.php\",\"replacedby\":\"de.opacapp.bremen\",\"state\":\"Bremen\",\"title\":\"Stadtbibliothek\"}";

    public static String LIBRARY_NAME = "Erlangen";
    public static String LIBRARY_JSON = "../opacapp-config-files/bibs/Erlangen.json";


    public static void main(final String[] args) throws JSONException, OpacApi.OpacErrorException, IOException {

        Security.addProvider(new BouncyCastleProvider());

        System.out.println("Hello OPAC!");

        File[] listOfFiles = new File("../opacapp-config-files/bibs").listFiles();

        int counter = 0;

        for (File file : listOfFiles) {
            //file = new File("../opacapp-config-files/bibs/Cottbus_Uni.json");
            //file = new File("../opacapp-config-files/bibs/Hausen_am_Albis.json");
            //file = new File("../opacapp-config-files/bibs/Princeton_U.json");
            //file = new File("../opacapp-config-files/bibs/Bad_Koenigshofen.json"); // GEO null


            String libraryName = file.getName().replace(".json", "");
            System.out.println(counter++ + "\tAccessing library " + libraryName);


            try {

                // Create a library object
                Library library = Library.fromJSON(libraryName, new JSONObject(readFile(file.getAbsolutePath())));

                // Instantiate the appropriate API class
                OpacApi api = OpacApiFactory.create(library, new DummyStringProvider(),
                        new HttpClientFactory("HelloOpac/1.0.0", new OpacAPI().pathToTrustStore()), null, null);

                System.out.println("Obtaining search fields...");

                List<SearchField> searchFields = api.getSearchFields();
                System.out.println("Found a first search field: " + searchFields.get(0).getDisplayName());

                List<SearchQuery> query = new ArrayList<>();
                query.add(new SearchQuery(searchFields.get(0), "Hello"));
                System.out.println("Searching for 'hello' in this field...");

                SearchRequestResult searchRequestResult = api.search(query);
                System.out.println("Found " + searchRequestResult.getTotal_result_count() + " matches.");
                if (searchRequestResult.getTotal_result_count() > 0) {
                    System.out.println("First match: " + searchRequestResult.getResults().get(0).toString());

                    System.out.println("Fetching details for the first result...");
                    // if (Arrays.asList(new String[]{"open", "winbiap", "webopac.net", "adis", "littera", "biber1992"}).contains(library.getApi())) {
                    //   System.out.println("detailedItem item not supported:-(");
                    //} else {

                    DetailedItem detailedItem;
                    if (searchRequestResult.getResults().get(0).getId() != null)
                        detailedItem = api.getResultById(searchRequestResult.getResults().get(0).getId(), null);
                    else detailedItem = api.getResult(0);
                    System.out.println("Got details: " + detailedItem.toString());
                }
            } catch (NotReachableException | NoRouteToHostException e) {
                System.out.println(libraryName + " is not reachable." + e.getMessage());
            } catch (ConnectException e) {
                System.out.println(libraryName + " can't be connected." + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(libraryName + " has a severe problem." + e.getMessage());
            } catch (SSLException e) {
                System.out.println(libraryName + " has a certificate problem with their website." + e.getMessage());
            } catch (OpacApi.OpacErrorException e) {
                System.out.println(libraryName + " might have a wrong link: . \n" + e.getMessage()); // library.getData().get("baseurl")
            } catch (MalformedURLException e) {
                System.out.println(libraryName + " problem finding ajax url. \n" + e.getCause());
            } catch (JSONException e) {
                System.out.println(libraryName + " does not support the service. \n" + e.getCause());
            }
        }
    }


    private static String readFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    String pathToTrustStore() {
        return new File(getClass().getClassLoader().getResource("ssl_trust_store.bks").getFile()).getAbsolutePath();
    }
}
