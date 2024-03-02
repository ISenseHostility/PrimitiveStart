package isensehostility.primitivestart.event;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.config.PrimitiveStartConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = PrimitiveStart.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommon {
    public static final Item boneItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(PrimitiveStartConfig.boneItem.get()));
    public static final Item featherItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(PrimitiveStartConfig.featherItem.get()));
    public static final boolean pluckingEnabled = PrimitiveStartConfig.pluckingEnabled.get();
    public static final boolean boneDropsEnabled = PrimitiveStartConfig.boneDropsEnabled.get();
    public static final boolean noTreePunchingEnabled = PrimitiveStartConfig.noTreePunchingEnabled.get();
    public static final boolean extraStickDropsEnabled = PrimitiveStartConfig.extraStickDropsEnabled.get();
    public static final int extraStickChance = PrimitiveStartConfig.extraStickChance.get();

    @SubscribeEvent
    public static void onEntityKilled(final LivingDropsEvent event) {
        if (!boneDropsEnabled) return;

        if (event.getEntity() instanceof Animal animal && animal.getRandom().nextBoolean()) {
            ItemEntity item = new ItemEntity(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(boneItem));
            event.getDrops().add(item);
        }
    }

    @SubscribeEvent
    public static void onBlockHit(final PlayerInteractEvent.LeftClickBlock event) {
        if (!noTreePunchingEnabled) return;

        if (!event.getEntity().isCreative() && !event.getItemStack().isCorrectToolForDrops(Blocks.OAK_LOG.defaultBlockState()) && event.getLevel().getBlockState(event.getPos()).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onEntityInteraction(PlayerInteractEvent.EntityInteract event) {
        if (!pluckingEnabled) return;

        TagKey<Item> shearsTag = ItemTags.create(new ResourceLocation("primitivestart:feather_plucker"));
        ItemStack stack = event.getItemStack();

        if (event.getTarget() instanceof Chicken chicken && (stack.getItem() instanceof ShearsItem || stack.is(shearsTag)) && chicken.hurtTime == 0 && chicken.isAlive()) {
            chicken.spawnAtLocation(new ItemStack(featherItem));
            chicken.hurt(DamageSource.GENERIC, 1);
            stack.setDamageValue(stack.getDamageValue() + 1);
        }
    }

    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event) {
        if (!extraStickDropsEnabled) return;

        if (event.getState().is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
            Player player = event.getPlayer();
            Level level = player.getLevel();

            if (player.getRandom().nextInt(100) < extraStickChance) {
                ItemEntity item = new ItemEntity(EntityType.ITEM, level);
                item.setItem(new ItemStack(Items.STICK));
                item.setPos(Vec3.atCenterOf(event.getPos()));

                level.addFreshEntity(item);
            }
        }
    }
}
