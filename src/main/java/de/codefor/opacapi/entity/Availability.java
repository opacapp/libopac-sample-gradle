package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.SearchResult;

public enum Availability {
    AVAILABLE, RESTRICTED, NOT_AVAILABLE, UNKNOWN;

    public static Availability from(SearchResult.Status status) {
        switch (status) {
            case GREEN:
                return AVAILABLE;
            case YELLOW:
                return RESTRICTED;
            case RED:
                return NOT_AVAILABLE;
            case UNKNOWN:
            default:
                return UNKNOWN;
        }
    }
}
