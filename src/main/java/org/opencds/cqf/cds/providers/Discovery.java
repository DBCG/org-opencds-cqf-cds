package org.opencds.cqf.cds.providers;

import java.util.ArrayList;
import java.util.List;

public class Discovery<P> {

    private P planDefinition;
    private List<DiscoveryItem> items;
    private int count;

    public Discovery() {
        items = new ArrayList<>();
        count = 0;
    }

    public P getPlanDefinition() {
        return planDefinition;
    }
    public List<DiscoveryItem> getItems() {
        return items;
    }

    public Discovery setPlanDefinition(P planDefinition) {
        this.planDefinition = planDefinition;
        return this;
    }

    public void addItem(DiscoveryItem item) {
        items.add(item);
    }
    public DiscoveryItem newItem() {
        return new DiscoveryItem().setItemNo(++count);
    }
}
