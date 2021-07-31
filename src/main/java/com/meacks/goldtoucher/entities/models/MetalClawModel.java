package com.meacks.goldtoucher.entities.models;

import com.meacks.goldtoucher.entities.MetalUmbrellaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.function.Consumer;

public class MetalClawModel extends EntityModel<MetalUmbrellaEntity> {

    @Override
    public void setupAnim(MetalUmbrellaEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {

    }

    @Override
    public Consumer<ModelRenderer> andThen(Consumer<? super ModelRenderer> after) {
        return super.andThen(after);
    }
}
