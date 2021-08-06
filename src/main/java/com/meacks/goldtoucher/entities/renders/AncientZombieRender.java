package com.meacks.goldtoucher.entities.renders;

import com.meacks.goldtoucher.GoldToucher;
import com.meacks.goldtoucher.entities.AncientZombieEntity;
import com.meacks.goldtoucher.entities.models.AncientZombieModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AncientZombieRender extends MobRenderer<AncientZombieEntity, AncientZombieModel<AncientZombieEntity>> {

    private static final ResourceLocation ZOMBIE_LOCATION = new ResourceLocation(GoldToucher.MODID,"textures/entity/ancient_zombie.png");
    public final AncientZombieModel<AncientZombieEntity> ancientZombieModel;

    public AncientZombieRender(EntityRendererManager rendererManager) {
        super(rendererManager,new AncientZombieModel<>(),0.7F);
        ancientZombieModel = this.getModel();
    }
    @Override
    public ResourceLocation getTextureLocation(AncientZombieEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    protected void setupRotations(AncientZombieEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupRotations(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
        if(p_225621_1_.getEntityData().get(AncientZombieEntity.lyingData)){
            p_225621_2_.mulPose(Vector3f.XP.rotationDegrees(90));
        }else{
            if (!((double)p_225621_1_.animationSpeed < 0.01D)) {
                float f = 13.0F;
                float f1 = p_225621_1_.animationPosition - p_225621_1_.animationSpeed * (1.0F - p_225621_5_) + 6.0F;
                float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
                p_225621_2_.mulPose(Vector3f.ZP.rotationDegrees(6.5F * f2));
            }
        }
    }

}
