package de.codefor.opacapi.entity;

import de.geeksfactory.opacclient.objects.Copy;
import de.geeksfactory.opacclient.objects.DetailedItem;

import java.util.ArrayList;
import java.util.List;

public class RecordAvailability {
    private final List<String> branches;


    public RecordAvailability(DetailedItem result) {
        List<String> branches = new ArrayList<>();

        for (Copy copy : result.getCopies()) {
            if (copy.getStatus().equalsIgnoreCase("available"))  //TODO
                branches.add(copy.getBranch());
        }
        this.branches = branches;
    }

    public List<String> getBranches() {
        return branches;
    }
}
