package com.gildedrose;

import com.gildedrose.model.BasicItem;
import com.gildedrose.model.Item;
import com.gildedrose.model.ItemFactory;

class GildedRose
{
    private final Item[] items;

    public GildedRose(final Item[] items)
    {
        this.items = items;
    }

    public void updateQuality()
    {
        for (final Item item : items)
        {
            updateQuality(item);
        }
    }

    private void updateQuality(final Item item)
    {
        BasicItem basicItem = ItemFactory.createItem(item);
        basicItem.doUpdate();

        item.sellIn = basicItem.toItem().sellIn;
        item.quality = basicItem.toItem().quality;
    }

    protected Item[] items()
    {
        return items;
    }
}