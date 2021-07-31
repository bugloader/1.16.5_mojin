package com.meacks.goldtoucher.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

public class AncientPoison4 extends Effect {

    public AncientPoison4(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
    }

    public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_) {
        return true;
    }
    int i=0;
    public void applyEffectTick(LivingEntity livingEntity, int p_76394_2_) {
        if(i++==10) {
            i = 0;
            livingEntity.addEffect(new EffectInstance(Effects.WEAKNESS, 20,2));
            livingEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20,2));
            livingEntity.addEffect(new EffectInstance(Effects.HUNGER, 20,2));
            livingEntity.addEffect(new EffectInstance(Effects.BLINDNESS, 20,2));
            ItemStack stack = livingEntity.getMainHandItem();
            if (stack.getItem().equals(Items.MILK_BUCKET)) {
                livingEntity.setItemInHand(Hand.MAIN_HAND, Items.BUCKET.getDefaultInstance());
            }
            livingEntity.hurt(DamageSource.MAGIC, 1f);
        }
    }
}
