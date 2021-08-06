package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.effect.AncientPoison2;
import com.meacks.goldtoucher.handlers.EffectHandler;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;


public class Mask extends ArmorItem {
    public Mask(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("mask");
        ItemHandler.ITEMS.add(this);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.hasEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get())){
            int t = player.getEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get()).getDuration();
            player.removeEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get());
            player.addEffect(new EffectInstance(EffectHandler.ANCIENT_POISON_REGISTRY_OBJECT.get(),t));
        }
    }
}
