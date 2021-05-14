package com.gildedrose.model;

public class BackstagePass extends BasicItem
{
    BackstagePass(final int sellIn, final int quality)
    {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void doUpdate()
    {
        if (qualityInRange())
        {
            quality++;

            if (sellIn <= 10 && qualityInRange())
            {
                quality++;
            }

            if (sellIn <= 5 && qualityInRange())
            {
                quality++;
            }
        }

        sellIn--;

        if (negativeSellIn())
        {
            quality = 0;
        }
    }

    private boolean qualityInRange()
    {
        return quality < MAX_QUALITY;
    }
}
