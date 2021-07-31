package com.meacks.goldtoucher.entities;

import com.meacks.goldtoucher.effect.AncientPoison;
import com.meacks.goldtoucher.handlers.EffectHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;


public class AncientZombieEntity extends ZombieEntity {
    private static final DataParameter<Integer> freezingTimeData =
            EntityDataManager.defineId(AncientZombieEntity.class, DataSerializers.INT);


    public AncientZombieEntity(EntityType<? extends ZombieEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(freezingTimeData, 0);
    }

    public AncientZombieEntity(World p_i1745_1_) {
        super(p_i1745_1_);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean flag = super.doHurtTarget(entity);
        if (flag) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if (this.getMainHandItem().isEmpty() && this.isOnFire() && this.random.nextFloat() < f * 0.3F) {
                entity.setSecondsOnFire(2 * (int)f);
            }
            if(entity instanceof LivingEntity) {
                if (random.nextInt() % 3 == 0) {
                    LivingEntity livingEntity = ((LivingEntity) entity);
                    if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON_REGISTRY_OBJECT.get())){
                        livingEntity.removeEffect(EffectHandler.ANCIENT_POISON_REGISTRY_OBJECT.get());
                        livingEntity.addEffect(new EffectInstance(
                                EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get(),6000));
                    }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get())){
                        livingEntity.removeEffect(EffectHandler.ANCIENT_POISON2_REGISTRY_OBJECT.get());
                        livingEntity.addEffect(new EffectInstance(
                                EffectHandler.ANCIENT_POISON3_REGISTRY_OBJECT.get(),6000));
                    }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON3_REGISTRY_OBJECT.get())){
                        livingEntity.addEffect(new EffectInstance(
                                EffectHandler.ANCIENT_POISON4_REGISTRY_OBJECT.get(),6000));
                    }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON4_REGISTRY_OBJECT.get())){
                        livingEntity.addEffect(new EffectInstance(
                                EffectHandler.ANCIENT_POISON5_REGISTRY_OBJECT.get(),6000));
                    }else if(livingEntity.hasEffect(EffectHandler.ANCIENT_POISON5_REGISTRY_OBJECT.get())){
                        livingEntity.addEffect(new EffectInstance(
                                EffectHandler.ANCIENT_POISON5_REGISTRY_OBJECT.get(),6000));
                    }else{
                        livingEntity.addEffect(new EffectInstance(
                                EffectHandler.ANCIENT_POISON_REGISTRY_OBJECT.get(),6000));
                    }
                }
            }
        }

        return flag;
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("freeze time",this.entityData.get(freezingTimeData));
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        this.entityData.set(freezingTimeData, nbt.getInt("freeze time"));

    }

    public void freezeZombie(){
        this.entityData.set(freezingTimeData,40);
    }

    @Override
    public void tick() {
        int freezeTime = this.entityData.get(freezingTimeData);
        if(freezeTime>0){
            this.entityData.set(freezingTimeData,freezeTime-1);
        }else{
            BlockPos blockPos = new BlockPos((int)this.position().x,(int)this.position().y,(int)this.position().z);
            int light = level.getBlockState(blockPos).getLightValue(level,blockPos);
            if(light<8){
                this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,10,8-light));
                this.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE,10,8-light));
                this.addEffect(new EffectInstance(Effects.POISON,10,8-light));
            }
            super.tick();
        }
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 50D)
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.6F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 3D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);

    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
