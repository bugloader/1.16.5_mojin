package com.meacks.goldtoucher.entities.renders;

import com.meacks.goldtoucher.entities.MetalClawEntity;
import com.meacks.goldtoucher.entities.models.MetalClawModel;
import com.meacks.goldtoucher.items.MetalClaw;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MetalClawRender extends EntityRenderer<MetalClawEntity> {
    public MetalClawRender(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }


    @Override
    public ResourceLocation getTextureLocation(MetalClawEntity p_110775_1_) {
        return null;
    }
}
