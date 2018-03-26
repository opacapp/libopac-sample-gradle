package de.codefor.opacapi;

import de.geeksfactory.opacclient.searchfields.SearchField;

public class MySearchField {

    private String id;
    private String displayName;
    private boolean advanced;
    private boolean visible;

    private MySearchField(String id, String displayName, boolean advanced, boolean visible) {
        this.id = id;
        this.displayName = displayName;
        this.advanced = advanced;
        this.visible = visible;
    }


    public static MySearchField from(SearchField searchField) {
        return new MySearchField(searchField.getId(), searchField.getDisplayName(),
                searchField.isAdvanced(), searchField.isVisible());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isAdvanced() {
        return advanced;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
