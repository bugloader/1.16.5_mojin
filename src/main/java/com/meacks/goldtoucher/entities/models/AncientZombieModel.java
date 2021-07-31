package com.meacks.goldtoucher.entities.models;

import net.minecraft.client.renderer.entity.model.AbstractZombieModel;
import net.minecraft.entity.monster.ZombieEntity;

public class AncientZombieModel <T extends ZombieEntity> extends AbstractZombieModel<T> {

    public AncientZombieModel(float p_i1168_1_, boolean p_i1168_2_) {
        this(p_i1168_1_, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    protected AncientZombieModel(float p_i48914_1_, float p_i48914_2_, int p_i48914_3_, int p_i48914_4_) {
        super(p_i48914_1_, p_i48914_2_, p_i48914_3_, p_i48914_4_);
    }

    public AncientZombieModel() {
        this(0.5F, true);
    }

    public boolean isAggressive(T p_212850_1_) {
        return p_212850_1_.isAggressive();
    }
}