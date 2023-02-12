package isensehostility.primitivestart.entity.renderer;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.entity.BoneArrow;
import isensehostility.primitivestart.entity.ReinforcedBoneArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ReinforcedBoneArrowRenderer extends ArrowRenderer<ReinforcedBoneArrow> {

    public ReinforcedBoneArrowRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(ReinforcedBoneArrow p_114482_) {
        return new ResourceLocation(PrimitiveStart.MODID, "textures/entity/reinforced_bone_arrow.png");
    }
}
