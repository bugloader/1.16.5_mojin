package com.meacks.goldtoucher.handlers;

import com.meacks.goldtoucher.GoldToucher;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.ArrayList;
import java.util.List;

public class BlockHandler {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block tombBricks = createBlockWithItem(AbstractBlock.Properties.of(Material.STONE).strength(10),"tomb_bricks", GoldToucher.TOMB_Block_GROUP);

    public static Block createBlockWithItem(Material properties, String registryName, ItemGroup tab){
        Block block = new Block(AbstractBlock.Properties.of(properties));
        block.setRegistryName(registryName);
        BlockHandler.BLOCKS.add(block);
        ItemHandler.ITEMS.add(new BlockItem(block,new Item.Properties().tab(tab)).setRegistryName(registryName));
        return block;
    }

    public static Block createBlockWithItem(AbstractBlock.Properties properties, String registryName, ItemGroup tab){
        Block block = new Block(properties);
        block.setRegistryName(registryName);
        BlockHandler.BLOCKS.add(block);
        ItemHandler.ITEMS.add(new BlockItem(block,new Item.Properties().tab(tab)).setRegistryName(registryName));
        return block;
    }

    public static Block createOreWithItem(Material properties, String registryName, ItemGroup tab){
        Block block = new OreBlock(Block.Properties.of(properties));
        block.setRegistryName(registryName);
        BlockHandler.BLOCKS.add(block);
        ItemHandler.ITEMS.add(new BlockItem(block,new Item.Properties().tab(tab)).setRegistryName(registryName));
        return block;
    }



    public static boolean areSameBlockType(Block block1,Block block2){
        return block1==block2;
    }

}
