package isensehostility.primitivestart.event;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.init.BlockInit;
import isensehostility.primitivestart.init.ItemInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PrimitiveStart.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabs {

    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.BONE_PICKAXE);
            event.accept(ItemInit.BONE_AXE);
            event.accept(ItemInit.BONE_SHOVEL);
            event.accept(ItemInit.BONE_HOE);
            event.accept(ItemInit.BONE_SHEARS);
            event.accept(ItemInit.REINFORCED_BONE_PICKAXE);
            event.accept(ItemInit.REINFORCED_BONE_AXE);
            event.accept(ItemInit.REINFORCED_BONE_SHOVEL);
            event.accept(ItemInit.REINFORCED_BONE_HOE);
            event.accept(ItemInit.REINFORCED_BONE_SHEARS);
            event.accept(ItemInit.PLATED_BONE_PICKAXE);
            event.accept(ItemInit.PLATED_BONE_AXE);
            event.accept(ItemInit.PLATED_BONE_SHOVEL);
            event.accept(ItemInit.PLATED_BONE_HOE);
            event.accept(ItemInit.PLATED_BONE_SHEARS);
        }
        if (event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ItemInit.BONE_SWORD);
            event.accept(ItemInit.BONE_ARROW);
            event.accept(ItemInit.REINFORCED_BONE_SWORD);
            event.accept(ItemInit.REINFORCED_BONE_ARROW);
            event.accept(ItemInit.PLATED_BONE_SWORD);
            event.accept(ItemInit.PLATED_BONE_ARROW);
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlockInit.IMPROVISED_PLANKS);
        }
    }
}
