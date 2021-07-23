package com.meacks.goldtoucher.handlers;

import com.meacks.goldtoucher.GoldToucher;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityHandler {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.ENTITIES, GoldToucher.MODID);


}
