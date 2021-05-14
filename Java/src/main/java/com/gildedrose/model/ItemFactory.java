package com.gildedrose.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ItemFactory
{
    private static final Map<String, Function<Item, BasicItem>> builder = new HashMap<>();

    static
    {
        builder.put(
                "Aged Brie",
                item -> new AgedBrie(item.sellIn, item.quality)
        );
        builder.put(
                "Backstage passes to a TAFKAL80ETC concert",
                item -> new BackstagePass(item.sellIn, item.quality)
        );
        builder.put(
                "Sulfuras, Hand of Ragnaros",
                item -> new Sulfuras(item.sellIn, item.quality)
        );
    }

    public static BasicItem createItem(final Item item)
    {
        return builder.getOrDefault(item.name, ItemFactory::createBasicItem).apply(item);
    }

    private static BasicItem createBasicItem(final Item item)
    {
        return new BasicItem(item.name, item.sellIn, item.quality);
    }
}