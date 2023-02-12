package isensehostility.primitivestart.item;

import isensehostility.primitivestart.entity.BoneArrow;
import isensehostility.primitivestart.entity.ReinforcedBoneArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ReinforcedBoneArrowItem extends ArrowItem {
    public final float damage;

    public ReinforcedBoneArrowItem(float damage) {
        super(new Properties().tab(CreativeModeTab.TAB_COMBAT));
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
        ReinforcedBoneArrow arrow = new ReinforcedBoneArrow(p_40515_, p_40513_);
        arrow.setBaseDamage(damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ReinforcedBoneArrowItem.class;
    }
}
