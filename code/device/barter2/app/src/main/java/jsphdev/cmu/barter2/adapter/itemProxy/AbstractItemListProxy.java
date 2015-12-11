package jsphdev.cmu.barter2.adapter.itemProxy;

import jsphdev.cmu.barter2.entities.Item;
import jsphdev.cmu.barter2.entities.ItemList;

public class AbstractItemListProxy implements ItemListBuilder {

    @Override
    public ItemList build() {
        list = new ItemList();
        return list;
    }

    public ItemList add(Item item) {
        list.add(item);
        return list;
    }

    private ItemList list;
}
