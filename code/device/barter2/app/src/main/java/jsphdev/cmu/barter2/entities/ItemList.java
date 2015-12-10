package jsphdev.cmu.barter2.entities;

import java.util.List;

public class ItemList {
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private List<Item> items;
}
