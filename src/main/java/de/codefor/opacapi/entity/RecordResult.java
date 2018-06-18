package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.Copy;
import de.geeksfactory.opacclient.objects.DetailedItem;

import java.util.ArrayList;
import java.util.List;

public class RecordResult {

    private RecordDetails details;


    public RecordResult(DetailedItem result) {


        int total_copies = 0;
        int available_copies = 0;
        List<String> branches = new ArrayList<>();

        for (Copy copy : result.getCopies()) {
            total_copies++;
            if (copy.getStatus().equalsIgnoreCase("available")) available_copies++; //TODO
            branches.add(copy.getBranch());
        }
        details = new RecordDetails(total_copies, available_copies, branches);


    }

    public RecordDetails getDetails() {
        return details;
    }
}
