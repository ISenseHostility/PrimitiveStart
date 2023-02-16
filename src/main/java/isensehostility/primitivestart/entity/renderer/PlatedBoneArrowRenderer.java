package isensehostility.primitivestart.entity.renderer;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.entity.PlatedBoneArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PlatedBoneArrowRenderer extends ArrowRenderer<PlatedBoneArrow> {

    public PlatedBoneArrowRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(PlatedBoneArrow p_114482_) {
        return new ResourceLocation(PrimitiveStart.MODID, "textures/entity/plated_bone_arrow.png");
    }
}
