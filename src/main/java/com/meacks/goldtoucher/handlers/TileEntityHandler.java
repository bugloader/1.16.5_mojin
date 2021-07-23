package com.meacks.goldtoucher.handlers;

import com.meacks.goldtoucher.GoldToucher;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TileEntityHandler {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GoldToucher.MODID);

    public static <T extends TileEntity>TileEntityType<T> sampleRegistry(
            String blockName, Supplier<T> supplier, Block block){
        TileEntityType<T> tileEntityType = TileEntityType.Builder.of(supplier,block).build(null);
        TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(blockName+"_tileentity", () -> tileEntityType);
        return tileEntityType;
    }

}
