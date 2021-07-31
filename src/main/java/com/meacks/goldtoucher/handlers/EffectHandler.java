package com.meacks.goldtoucher.handlers;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.effect.*;
import com.meacks.goldtoucher.entities.AncientZombieEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectHandler {

    public static final DeferredRegister<Effect> EFFECT_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.POTIONS, GoldToucher.MODID);

    public static final RegistryObject<Effect> ANCIENT_POISON_REGISTRY_OBJECT =
            EFFECT_TYPE_DEFERRED_REGISTER.register("ancient_poison",
            () -> new AncientPoison(EffectType.HARMFUL, 5149489));

    public static final RegistryObject<Effect> ANCIENT_POISON2_REGISTRY_OBJECT =
            EFFECT_TYPE_DEFERRED_REGISTER.register("ancient_poison2",
                    () -> new AncientPoison2(EffectType.HARMFUL, 5149489));

    public static final RegistryObject<Effect> ANCIENT_POISON3_REGISTRY_OBJECT =
            EFFECT_TYPE_DEFERRED_REGISTER.register("ancient_poison3",
                    () -> new AncientPoison3(EffectType.HARMFUL, 5149489));

    public static final RegistryObject<Effect> ANCIENT_POISON4_REGISTRY_OBJECT =
            EFFECT_TYPE_DEFERRED_REGISTER.register("ancient_poison4",
                    () -> new AncientPoison4(EffectType.HARMFUL, 5149489));

    public static final RegistryObject<Effect> ANCIENT_POISON5_REGISTRY_OBJECT =
            EFFECT_TYPE_DEFERRED_REGISTER.register("ancient_poison5",
                    () -> new AncientPoison5(EffectType.HARMFUL, 0));

    public static final RegistryObject<Effect> ANCIENT_POISON_ANTIDOTE_REGISTRY_OBJECT =
            EFFECT_TYPE_DEFERRED_REGISTER.register("ancient_poison_antidote",
                    () -> new AncientPoisonAntidote(EffectType.BENEFICIAL, 5149489));
}
