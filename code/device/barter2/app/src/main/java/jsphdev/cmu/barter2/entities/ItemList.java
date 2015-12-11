package jsphdev.cmu.barter2.entities;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    public ItemList() {
        items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        this.items.add(item);
    }

    private List<Item> items;
}
