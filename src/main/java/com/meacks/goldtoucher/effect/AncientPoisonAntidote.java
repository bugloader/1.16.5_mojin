package com.meacks.goldtoucher.effect;

import com.meacks.goldtoucher.handlers.EffectHandler;
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

public class AncientPoisonAntidote  extends Effect {

    public AncientPoisonAntidote(EffectType p_i50391_1_, int p_i50391_2_) {
        super(p_i50391_1_, p_i50391_2_);
    }

    public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_) {
        return true;
    }

    public void applyEffectTick(LivingEntity livingEntity, int p_76394_2_) {
        if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON_REGISTRY_OBJECT.get())){
            livingEntity.removeEffect(EffectHandler.ANCIENT_POISON_REGISTRY_OBJECT.get());
        }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get())){
            livingEntity.removeEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get());
        }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON3_REGISTRY_OBJECT.get())){
            livingEntity.removeEffect(EffectHandler.ANCIENT_POISON3_REGISTRY_OBJECT.get());
        }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON4_REGISTRY_OBJECT.get())){
            livingEntity.removeEffect(EffectHandler.ANCIENT_POISON4_REGISTRY_OBJECT.get());
        }
    }
}