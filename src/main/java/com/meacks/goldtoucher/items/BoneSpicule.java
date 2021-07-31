package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.EffectHandler;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BoneSpicule extends Item{
    public static final Food food = (new Food.Builder()).nutrition(0).saturationMod(0.8F)
            .effect(new EffectInstance(Effects.POISON, 20, 10), 0.76F)
            .effect(()-> new EffectInstance(EffectHandler.ANCIENT_POISON_ANTIDOTE_REGISTRY_OBJECT.get(),1),0.33f)
                    .build();
    public BoneSpicule(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM).food(food));
        this.setRegistryName("bone_spicule");
        ItemHandler.ITEMS.add(this);
    }


}
