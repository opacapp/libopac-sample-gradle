package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.searchfields.SearchField;
import de.geeksfactory.opacclient.searchfields.SearchQuery;

import java.util.ArrayList;
import java.util.List;

public class SearchQueries {

    private List<SearchQuery> searchQueries;
    private Iterable<? extends SearchField> searchFields;



    private SearchQueries(Iterable<? extends SearchField> searchFields){
        searchQueries  = new ArrayList<>();
        this.searchFields = searchFields;
    }

    public static SearchQueries builder(Iterable<? extends SearchField> searchFields) {
        return new SearchQueries(searchFields);
    }

    public SearchQueries isbn(String isbn) {
        for (SearchField searchField : searchFields) {
            if (SearchField.Meaning.ISBN.equals(searchField.getMeaning())) {
                searchQueries.add(new SearchQuery(searchField, isbn));
            }
        }
        return this;
    }

    public List<SearchQuery> build() {
        return searchQueries;
    }
}
