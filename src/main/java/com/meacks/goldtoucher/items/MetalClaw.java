package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.item.Item;

public class MetalClaw extends Item{

    public MetalClaw(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("metal_claw");
        ItemHandler.ITEMS.add(this);
    }

}
