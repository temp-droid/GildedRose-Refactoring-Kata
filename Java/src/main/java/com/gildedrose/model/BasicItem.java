package com.gildedrose.model;

public class BasicItem
{
    protected static final int MAX_QUALITY = 50;

    protected final String name;
    protected int sellIn;
    protected int quality;

    public BasicItem(final String name, final int sellIn, final int quality)
    {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void doUpdate()
    {
        if (positiveQuality())
        {
            quality--;
        }

        sellIn--;

        if (negativeSellIn() && positiveQuality())
        {
            quality--;
        }
    }

    protected boolean negativeSellIn()
    {
        return sellIn < 0;
    }

    protected boolean positiveQuality()
    {
        return quality > 0;
    }

    public Item toItem()
    {
        return new Item(name, sellIn, quality);
    }
}
