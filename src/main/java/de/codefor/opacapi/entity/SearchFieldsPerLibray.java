package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.Library;
import de.geeksfactory.opacclient.searchfields.SearchField;

import java.util.List;

public class SearchFieldsPerLibray {


    private final Library library;
    private final List<SearchField> searchFields;
    private boolean free;
    private boolean title;
    private boolean author;
    private boolean digital;
    private boolean available;
    private boolean isbn;
    private boolean barcode;
    private boolean year;
    private boolean branch;
    private boolean home_branch;
    private boolean category;
    private boolean publisher;
    private boolean keyword;
    private boolean system;
    private boolean audience;
    private boolean location;
    private boolean order;
    private boolean database;


    public SearchFieldsPerLibray(Library library, List<SearchField> searchFields) {
        this.library = library;
        this.searchFields = searchFields;
        for (SearchField searchField : searchFields) {
            switch (searchField.getMeaning()) {
                case FREE:
                    free = true;
                    break;
                case ISBN:
                    isbn = true;
                    break;
                case YEAR:
                    year = true;
                    break;
                case ORDER:
                    order = true;
                    break;
                case TITLE:
                    title = true;
                    break;
                case AUTHOR:
                    author = true;
                    break;
                case BRANCH:
                    branch = true;
                    break;
                case SYSTEM:
                    system = true;
                    break;
                case BARCODE:
                    barcode = true;
                    break;
                case DIGITAL:
                    digital = true;
                    break;
                case AUDIENCE:
                    audience = true;
                    break;
                case KEYWORD:
                    keyword = true;
                    break;
                case CATEGORY:
                    category = true;
                    break;
                case DATABASE:
                    database = true;
                    break;
                case LOCATION:
                    location = true;
                    break;
                case AVAILABLE:
                    available = true;
                    break;
                case PUBLISHER:
                    publisher = true;
                    break;
                case HOME_BRANCH:
                    home_branch = true;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String result = library.getIdent() + "\t" + library.getApi();
        result += "\t" + free;
        result += "\t" + title;
        result += "\t" + author;
        result += "\t" + digital;
        result += "\t" + available;
        result += "\t" + isbn;
        result += "\t" + barcode;
        result += "\t" + year;
        result += "\t" + branch;
        result += "\t" + home_branch;
        result += "\t" + category;
        result += "\t" + publisher;
        result += "\t" + keyword;
        result += "\t" + system;
        result += "\t" + audience;
        result += "\t" + location;
        result += "\t" + order;
        result += "\t" + database;
        result += "\n";
        return result;
    }
}
