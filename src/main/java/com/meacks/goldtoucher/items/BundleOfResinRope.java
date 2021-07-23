package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.item.Item;

public class BundleOfResinRope extends Item{

    public BundleOfResinRope(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("bundle_of_resin_rope");
        ItemHandler.ITEMS.add(this);
    }

}
