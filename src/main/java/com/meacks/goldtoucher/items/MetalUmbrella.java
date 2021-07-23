package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.item.Item;

public class MetalUmbrella extends Item{

    public MetalUmbrella(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("metal_umbrella");
        ItemHandler.ITEMS.add(this);
    }

}
