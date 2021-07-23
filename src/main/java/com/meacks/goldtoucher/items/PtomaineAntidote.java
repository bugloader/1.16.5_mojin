package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class PtomaineAntidote extends Item{
    public static final Food food = (new Food.Builder()).nutrition(1).saturationMod(0.8F).meat().build();

    public PtomaineAntidote(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("ptomaine_antidote");
        ItemHandler.ITEMS.add(this);
    }

}
