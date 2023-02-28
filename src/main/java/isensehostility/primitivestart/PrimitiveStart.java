package isensehostility.primitivestart;

import isensehostility.primitivestart.init.BlockInit;
import isensehostility.primitivestart.init.EntityInit;
import isensehostility.primitivestart.init.ItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod("primitivestart")
public class PrimitiveStart {

    public static final String MODID = "primitivestart";

    public PrimitiveStart() {
        ItemInit.initialize();
        EntityInit.initialize();
        BlockInit.initialize();
    }

    public static final TagKey<Block> COPPER_TAG = BlockTags.create(new ResourceLocation(MODID, "needs_copper_tool"));
    public static final TagKey<Block> PLATED_TAG = BlockTags.create(new ResourceLocation(MODID, "needs_plated_tool"));

    public static final Tier COPPER = TierSortingRegistry.registerTier(
            new ForgeTier(2, 190, 5.0F, 2.0F, 14, COPPER_TAG, () -> Ingredient.of(Items.RAW_COPPER)),
            new ResourceLocation(MODID, "copper"),
            List.of(Tiers.STONE), List.of(Tiers.IRON));

    public static final Tier PLATED = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 6.0F, 2.0F, 25, PLATED_TAG, () -> Ingredient.of(Items.GOLD_INGOT)),
            new ResourceLocation(MODID, "plated"),
            List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
