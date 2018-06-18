package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.SearchResult;

public class CatalogSearchResult {

    //  id​: a unique identifier for which detailed record results can be requested
    private String id;
    private String infoHtml;
    //format​: the format or binding,  Examples including hardcover, ebook, kindle, audiobook, etc.
    private String format;

    public CatalogSearchResult(String libraryName, SearchResult searchResult) {
        this.id = searchResult.getId();
        this.infoHtml = searchResult.getInnerhtml();
        this.format = searchResult.getType().name();
    }


    public String getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public String getInfoHtml() {
        return infoHtml;
    }
}
