package de.codefor.opacapi.result;

import de.codefor.opacapi.entity.MySearchResultItem;
import de.geeksfactory.opacclient.objects.SearchRequestResult;
import de.geeksfactory.opacclient.objects.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class MySearchResult extends MyResult {


    public List<MySearchResultItem> getItems() {
        return items;
    }

    private List<MySearchResultItem> items;

    public MySearchResult(SearchRequestResult searchRequestResult) {

        items = new ArrayList<>();

        for (SearchResult searchResult : searchRequestResult.getResults()) {
            items.add(MySearchResultItem.from(searchResult));
        }
    }
}
