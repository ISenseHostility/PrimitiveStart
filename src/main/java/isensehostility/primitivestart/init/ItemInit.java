package isensehostility.primitivestart.init;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.item.BoneArrowItem;
import isensehostility.primitivestart.item.ReinforcedBoneArrowItem;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PrimitiveStart.MODID);

    public static void initialize() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> BONE_SWORD = ITEMS.register("bone_sword", () -> new SwordItem(Tiers.WOOD, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(95)));
    public static final RegistryObject<Item> BONE_PICKAXE = ITEMS.register("bone_pickaxe", () -> new PickaxeItem(Tiers.WOOD, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(95)));
    public static final RegistryObject<Item> BONE_AXE = ITEMS.register("bone_axe", () -> new AxeItem(Tiers.WOOD, 7, -3.2F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(95)));
    public static final RegistryObject<Item> BONE_SHOVEL = ITEMS.register("bone_shovel", () -> new ShovelItem(Tiers.WOOD, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(95)));
    public static final RegistryObject<Item> BONE_HOE = ITEMS.register("bone_hoe", () -> new HoeItem(Tiers.WOOD, -1, -2.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(95)));

    public static final RegistryObject<Item> BONE_SHEARS = ITEMS.register("bone_shears", () -> new ShearsItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(95)));
    public static final RegistryObject<Item> BONE_ARROW = ITEMS.register("bone_arrow", () -> new BoneArrowItem(1.0F));

    public static final RegistryObject<Item> REINFORCED_BONE_SWORD = ITEMS.register("reinforced_bone_sword", () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(190)));
    public static final RegistryObject<Item> REINFORCED_BONE_PICKAXE = ITEMS.register("reinforced_bone_pickaxe", () -> new PickaxeItem(Tiers.IRON, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(190)));
    public static final RegistryObject<Item> REINFORCED_BONE_AXE = ITEMS.register("reinforced_bone_axe", () -> new AxeItem(Tiers.IRON, 6, -3.1F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(190)));
    public static final RegistryObject<Item> REINFORCED_BONE_SHOVEL = ITEMS.register("reinforced_bone_shovel", () -> new ShovelItem(Tiers.IRON, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(190)));
    public static final RegistryObject<Item> REINFORCED_BONE_HOE = ITEMS.register("reinforced_bone_hoe", () -> new HoeItem(Tiers.IRON, -2, -1.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(190)));

    public static final RegistryObject<Item> REINFORCED_BONE_SHEARS = ITEMS.register("reinforced_bone_shears", () -> new ShearsItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(190)));

    public static final RegistryObject<Item> REINFORCED_BONE_ARROW = ITEMS.register("reinforced_bone_arrow", () -> new ReinforcedBoneArrowItem(1.5F));


}
