package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.entities.MetalUmbrellaEntity;
import com.meacks.goldtoucher.handlers.EntityHandler;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class MetalUmbrella extends Item{

    public MetalUmbrella(){
        super(new Properties().tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("metal_umbrella");
        ItemHandler.ITEMS.add(this);
    }

    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext) {
        BlockPos blockPos = itemUseContext.getClickedPos();
        MetalUmbrellaEntity metalUmbrellaEntity =
                new MetalUmbrellaEntity(EntityHandler.METAL_UMBRELLA_REGISTRY_OBJECT.get(),itemUseContext.getLevel());
        metalUmbrellaEntity.setPosRaw(blockPos.getX(),blockPos.getY(),blockPos.getZ());
        itemUseContext.getLevel().addFreshEntity(metalUmbrellaEntity);

        Objects.requireNonNull(itemUseContext.getPlayer()).setItemInHand(itemUseContext.getHand(),
                Items.AIR.getDefaultInstance());
        return ActionResultType.PASS;
    }

}
