package com.meacks.goldtoucher.entities;

import com.meacks.goldtoucher.handlers.ItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.network.NetworkHooks;

public class MetalUmbrellaEntity extends Entity implements IForgeEntity {
    public MetalUmbrellaEntity(EntityType<?> p_i48580_1_, World p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_);
    }

    @Override
    public void playerTouch(PlayerEntity playerEntity) {
        if(playerEntity.getMainHandItem()== ItemStack.EMPTY){
            //playerEntity.setItemInHand(Hand.MAIN_HAND, ItemHandler.metalUmbrella.getDefaultInstance());
            this.remove();
        }
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return !(entity instanceof PlayerEntity);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {

    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
