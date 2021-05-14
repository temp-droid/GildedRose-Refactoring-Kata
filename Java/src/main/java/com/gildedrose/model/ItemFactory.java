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
                ItemFactory::createAgedBrie
        );
        builder.put(
                "Backstage passes to a TAFKAL80ETC concert",
                ItemFactory::createBackstagePass
        );
        builder.put(
                "Sulfuras, Hand of Ragnaros",
                ItemFactory::createSulfuras
        );
    }

    public static BasicItem createItem(final Item item)
    {
        return builder.getOrDefault(item.name, ItemFactory::createBasicItem).apply(item);
    }

    private static AgedBrie createAgedBrie(final Item item)
    {
        return new AgedBrie(item.sellIn, item.quality);
    }

    private static BackstagePass createBackstagePass(final Item item)
    {
        return new BackstagePass(item.sellIn, item.quality);
    }

    private static Sulfuras createSulfuras(final Item item)
    {
        return new Sulfuras(item.sellIn, item.quality);
    }

    private static BasicItem createBasicItem(final Item item)
    {
        return new BasicItem(item.name, item.sellIn, item.quality);
    }
}