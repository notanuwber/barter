package jsphdev.cmu.barter2.adapter.itemProxy;

import jsphdev.cmu.barter2.entities.Item;

public class AbstractItemProxy implements ItemBuilder {

    @Override
    public Item build() {
        return new Item();
    }
}
