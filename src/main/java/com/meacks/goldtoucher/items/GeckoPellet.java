package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.effect.AncientPoisonAntidote;
import com.meacks.goldtoucher.handlers.EffectHandler;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class GeckoPellet extends Item{
    public static final Food food = (new Food.Builder()).nutrition(1).saturationMod(0.8F)
            .effect(new EffectInstance(Effects.REGENERATION, 20, 1), 1.0F)
            .effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
            .effect(new EffectInstance(Effects.ABSORPTION, 2400, 3), 1.0F)
            .effect(()-> new EffectInstance(EffectHandler.ANCIENT_POISON_ANTIDOTE_REGISTRY_OBJECT.get(),6000),1.0f)
            .alwaysEat().build();

    public GeckoPellet(){
        super(new Properties().food(food).tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("gecko_pellet");
        ItemHandler.ITEMS.add(this);
    }



}
