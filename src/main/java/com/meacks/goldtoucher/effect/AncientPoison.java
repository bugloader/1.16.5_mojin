package com.meacks.goldtoucher.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class AncientPoison extends Effect {

    public AncientPoison(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
    }

    public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_) {
        return true;
    }

    int i=0;
    public void applyEffectTick(LivingEntity livingEntity, int p_76394_2_) {
        if(i++==10) {
            i=0;
            ItemStack stack = livingEntity.getMainHandItem();
            if (stack.getItem().equals(Items.MILK_BUCKET)) {
                livingEntity.setItemInHand(Hand.MAIN_HAND, Items.BUCKET.getDefaultInstance());
            }
            livingEntity.addEffect(new EffectInstance(Effects.HUNGER, 20));
            livingEntity.hurt(DamageSource.MAGIC, 0.15f);
        }
    }
}
