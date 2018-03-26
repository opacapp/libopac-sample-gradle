package de.codefor.opacapi;

import de.geeksfactory.opacclient.OpacApiFactory;
import de.geeksfactory.opacclient.apis.OpacApi;
import de.geeksfactory.opacclient.i18n.DummyStringProvider;
import de.geeksfactory.opacclient.networking.HttpClientFactory;
import de.geeksfactory.opacclient.objects.Library;
import de.geeksfactory.opacclient.searchfields.SearchField;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAPI {


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

    @RequestMapping(value = "/library/{libraryName}/searchFields",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.ALL_VALUE)
    public List<MySearchField> searchFields(@PathVariable String libraryName) throws IOException, JSONException, OpacApi.OpacErrorException {

        Security.addProvider(new BouncyCastleProvider());

        File file = new File("../opacapp-config-files/bibs/" + libraryName + ".json");
        Library library = Library.fromJSON(libraryName, new JSONObject(readFile(file.getAbsolutePath())));

        OpacApi api = OpacApiFactory.create(library, new DummyStringProvider(),
                new HttpClientFactory("HelloOpac/1.0.0", new OpacAPI().pathToTrustStore()), null, null);

        List<MySearchField> searchFields = new ArrayList<>();

        for (SearchField searchField : api.getSearchFields()) {
            searchFields.add(MySearchField.from(searchField));
        }

        return searchFields;
    }

    @RequestMapping(value = "/libraries",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.ALL_VALUE)
    public List<String> libraries() throws IOException, JSONException, OpacApi.OpacErrorException {

        Security.addProvider(new BouncyCastleProvider());

        List<String> libraries = new ArrayList<>();

        File[] listOfFiles = new File("../opacapp-config-files/bibs").listFiles();
        for (File file : listOfFiles) {
            libraries.add(file.getName().replace(".json", ""));
        }

        return libraries;
    }


}
