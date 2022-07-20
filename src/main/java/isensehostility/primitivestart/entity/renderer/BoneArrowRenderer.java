package isensehostility.primitivestart.entity.renderer;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.entity.BoneArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BoneArrowRenderer extends ArrowRenderer<BoneArrow> {

    public BoneArrowRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(BoneArrow p_114482_) {
        return new ResourceLocation(PrimitiveStart.MODID, "textures/entity/bone_arrow.png");
    }
}
