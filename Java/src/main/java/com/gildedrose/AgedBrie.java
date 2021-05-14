package com.gildedrose;

public class AgedBrie extends Item
{
    AgedBrie(final int sellIn, final int quality)
    {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void doUpdate()
    {
        if (quality < 50)
        {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0)
        {
            if (quality < 50)
            {
                quality = quality + 1;
            }
        }
    }
}
