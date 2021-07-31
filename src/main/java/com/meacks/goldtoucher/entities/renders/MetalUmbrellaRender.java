package com.meacks.goldtoucher.entities.renders;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.entities.MetalUmbrellaEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class MetalUmbrellaRender extends EntityRenderer<MetalUmbrellaEntity> {
    public MetalUmbrellaRender(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Override
    public ResourceLocation getTextureLocation(MetalUmbrellaEntity p_110775_1_) {
        return  new ResourceLocation(GoldToucher.MODID,"textures/entity/metal_umbrella.png");
    }
}
