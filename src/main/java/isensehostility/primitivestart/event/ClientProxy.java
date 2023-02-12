package isensehostility.primitivestart.event;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.entity.renderer.BoneArrowRenderer;
import isensehostility.primitivestart.entity.renderer.ReinforcedBoneArrowRenderer;
import isensehostility.primitivestart.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PrimitiveStart.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.BONE_ARROW.get(), BoneArrowRenderer::new);
        event.registerEntityRenderer(EntityInit.REINFORCED_BONE_ARROW.get(), ReinforcedBoneArrowRenderer::new);
    }
}
