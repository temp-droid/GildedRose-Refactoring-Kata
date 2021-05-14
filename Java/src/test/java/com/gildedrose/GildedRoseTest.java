package com.gildedrose;

import com.gildedrose.model.Item;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest
{
    @Test
    void update_quality()
    {
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
                new String[]{ "foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros" },
                new Integer[]{ -1, 0, 3, 6, 11 },
                new Integer[]{ 0, 1, 50 });
    }

    private Item doUpdateQuality(final String name, final int sellIn, final int quality)
    {
        // given
        Item item = new Item(name, sellIn, quality);
        Item[] items = new Item[]{ item };
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        // then
        return app.items()[0];
    }
}
