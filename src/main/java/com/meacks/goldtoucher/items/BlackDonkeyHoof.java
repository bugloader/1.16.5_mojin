package com.meacks.goldtoucher.items;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.entities.AncientZombieEntity;
import com.meacks.goldtoucher.handlers.EntityHandler;
import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlackDonkeyHoof extends Item{
    public static final Food food = (new Food.Builder()).nutrition(4).saturationMod(0.8F).meat().build();

    public BlackDonkeyHoof(){
        super(new Properties().food(food).tab(GoldToucher.TOMB_ITEM));
        this.setRegistryName("black_donkey_hoof");
        ItemHandler.ITEMS.add(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity)
    {
        if(entity instanceof AncientZombieEntity){
            ((AncientZombieEntity)entity).freezeZombie();
        }
        return false;
    }

}
