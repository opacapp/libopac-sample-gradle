package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.SearchRequestResult;
import de.geeksfactory.opacclient.objects.SearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CatalogSearchResults {

    private List<CatalogSearchResult> results= new ArrayList<>();

    public CatalogSearchResults(Map<String,SearchRequestResult> searchResults) {
        for(Map.Entry<String, SearchRequestResult> entrySet : searchResults.entrySet()){
            String libraryName = entrySet.getKey();
           for(SearchResult searchResult : entrySet.getValue().getResults()){
               results.add(new CatalogSearchResult(libraryName, searchResult));
           }

        }
    }

    public List<CatalogSearchResult> getResults() {
        return results;
    }
}
