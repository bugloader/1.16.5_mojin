package com.meacks.goldtoucher.entities.models;

import com.google.common.collect.ImmutableList;
import com.meacks.goldtoucher.entities.MetalUmbrellaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.function.Consumer;

public class MetalUmbrellaModel<T extends MetalUmbrellaEntity> extends SegmentedModel<T> {

    private final ModelRenderer bb_main = new ModelRenderer(this).setTexSize(32,32);;
    public MetalUmbrellaModel(){
        bb_main.setPos(0.0F, 24.0F, 0.0F);
        bb_main.addBox(-31.0F, 0.0F, 30, 31, 1, 0.0F, false);
        bb_main.addBox( -16.0F, 1.0F, 1, 1, 26, 0.0F, false);

    }

    @Override
    public void setupAnim(MetalUmbrellaEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(bb_main);
    }

    @Override
    public Consumer<ModelRenderer> andThen(Consumer<? super ModelRenderer> after) {
        return super.andThen(after);
    }
}
