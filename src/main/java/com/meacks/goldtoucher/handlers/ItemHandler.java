package com.meacks.goldtoucher.handlers;

import com.meacks.goldtoucher.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item blackDonkeyHoof = new BlackDonkeyHoof();
    public static final Item boneSpicule = new BoneSpicule();
    public static final Item bundleOfResinRope = new BundleOfResinRope();
    public static final Item gasMask = new GasMask();
    public static final Item metalClaw = new MetalClaw();
    public static final Item metalUmbrella = new MetalUmbrella();
    public static final Item ptomaineAntidote = new PtomaineAntidote();
    public static final Item testingItem = new TestingItem();

    public static void createBlockItem(Block block, String registryName, ItemGroup tab){
        ItemHandler.ITEMS.add(new BlockItem(block,new Item.Properties().tab(tab)).setRegistryName(registryName));
    }
}
