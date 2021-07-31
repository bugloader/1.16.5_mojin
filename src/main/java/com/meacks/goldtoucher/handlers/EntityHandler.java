package com.meacks.goldtoucher.handlers;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.entities.AncientZombieEntity;
import com.meacks.goldtoucher.entities.MetalUmbrellaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityHandler {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.ENTITIES, GoldToucher.MODID);


    public static final RegistryObject<EntityType<AncientZombieEntity>> ANCIENT_ZOMBIE_REGISTRY_OBJECT =
            ENTITY_TYPE_DEFERRED_REGISTER.register("ancient_zombie",
                    () -> EntityType.Builder.<AncientZombieEntity>of(AncientZombieEntity::new,
                    EntityClassification.MISC).sized(1f, 2f).build("ancient_zombie"));

    public static final RegistryObject<EntityType<MetalUmbrellaEntity>> METAL_UMBRELLA_REGISTRY_OBJECT =
            ENTITY_TYPE_DEFERRED_REGISTER.register("metal_umbrella",
                    () -> EntityType.Builder.<MetalUmbrellaEntity>of(MetalUmbrellaEntity::new,
                    EntityClassification.MISC).sized(3f, 3f).build("metal_umbrella"));
}
