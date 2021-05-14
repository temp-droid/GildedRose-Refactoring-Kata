package com.gildedrose.model;

public class AgedBrie extends BasicItem
{
    AgedBrie(final int sellIn, final int quality)
    {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void doUpdate()
    {
        if (quality < MAX_QUALITY)
        {
            quality++;
        }

        sellIn--;

        if (negativeSellIn() && quality < MAX_QUALITY)
        {
            quality++;
        }
    }
}
