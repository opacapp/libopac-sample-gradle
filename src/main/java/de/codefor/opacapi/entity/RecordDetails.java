package de.codefor.opacapi.entity;

import java.util.List;

public class RecordDetails {

    private int total_copies;
    private int available_copies;
    private List<String> branches;

    public RecordDetails(int total_copies, int available_copies, List<String> branches) {
        this.total_copies = total_copies;
        this.available_copies = available_copies;
        this.branches = branches;
    }

    public int getTotal_copies() {
        return total_copies;
    }

    public int getAvailable_copies() {
        return available_copies;
    }

    public List<String> getBranches() {
        return branches;
    }
}
