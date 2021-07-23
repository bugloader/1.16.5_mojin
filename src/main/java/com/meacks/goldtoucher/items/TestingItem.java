package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TestingItem extends Item{


    public TestingItem(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("testing_item");
        ItemHandler.ITEMS.add(this);
    }

    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext){
        Hand usingHand = itemUseContext.getHand();
        PlayerEntity usingPlayer = itemUseContext.getPlayer();
        World level = itemUseContext.getLevel();
        assert usingPlayer != null;
        Vector3d position = usingPlayer.position();
        BlockPos blockPos = itemUseContext.getClickedPos();
        Block block = level.getBlockState(blockPos).getBlock();


        if(level.isClientSide) {
            usingPlayer.displayClientMessage(new TranslationTextComponent(itemUseContext.getLevel().getBlockState(
                    itemUseContext.getClickedPos()).getBlock().getName().getString()), true);
            System.out.println(itemUseContext.getLevel().getBlockState(itemUseContext.getClickedPos()).getBlock().getName());
        }
        return ActionResultType.PASS;
    }
}
