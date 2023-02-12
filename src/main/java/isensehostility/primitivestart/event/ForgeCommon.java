package isensehostility.primitivestart.event;

import isensehostility.primitivestart.PrimitiveStart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
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

@Mod.EventBusSubscriber(modid = PrimitiveStart.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommon {

    @SubscribeEvent
    public static void onEntityKilled(final LivingDropsEvent event) {
        if (event.getEntity() instanceof Animal animal && animal.getRandom().nextBoolean()) {
            ItemEntity item = new ItemEntity(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.BONE));
            event.getDrops().add(item);
        }
    }

    @SubscribeEvent
    public static void onBlockHit(final PlayerInteractEvent.LeftClickBlock event) {
        if (!event.getEntity().isCreative() && !event.getItemStack().isCorrectToolForDrops(Blocks.OAK_LOG.defaultBlockState()) && event.getLevel().getBlockState(event.getPos()).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onEntityInteraction(PlayerInteractEvent.EntityInteract event) {
        ItemStack stack = event.getItemStack();
        if (event.getTarget() instanceof Chicken chicken && stack.getItem() instanceof ShearsItem && chicken.hurtTime == 0 && chicken.isAlive()) {
            chicken.spawnAtLocation(new ItemStack(Items.FEATHER));
            chicken.hurt(DamageSource.GENERIC, 1);
            stack.setDamageValue(stack.getDamageValue() + 1);
        }
    }

    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event) {
        if (event.getState().is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
            Player player = event.getPlayer();
            Level level = player.getLevel();

            if (player.getRandom().nextInt(100) + 1 < 15) {
                ItemEntity item = new ItemEntity(EntityType.ITEM, level);
                item.setItem(new ItemStack(Items.STICK));
                item.setPos(Vec3.atCenterOf(event.getPos()));

                level.addFreshEntity(item);
            }
        }
    }
}
