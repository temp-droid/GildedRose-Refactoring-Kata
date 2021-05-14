package com.gildedrose.model;

public class ItemFactory
{
    public static BasicItem createItem(final Item item)
    {
        final String name = item.name;
        final int sellIn = item.sellIn;
        final int quality = item.quality;

        switch (name)
        {
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn, quality);
            default:
                return new BasicItem(name, sellIn, quality);
        }
    }
}