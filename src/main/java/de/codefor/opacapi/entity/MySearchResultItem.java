package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.SearchResult;

public class MySearchResultItem {


    private String description;
    private Availability availability;

    public static MySearchResultItem from(SearchResult searchResult) {
        MySearchResultItem mySearchResultItem = new MySearchResultItem();
        mySearchResultItem.setDescription(searchResult.getInnerhtml());
        mySearchResultItem.setAvailability(Availability.from(searchResult.getStatus()));
        return mySearchResultItem;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Availability getAvailability() {
        return availability;
    }

    public String getDescription() {
        return description;
    }
}
