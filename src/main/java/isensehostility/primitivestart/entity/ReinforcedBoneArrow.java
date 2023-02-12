package isensehostility.primitivestart.entity;

import isensehostility.primitivestart.init.EntityInit;
import isensehostility.primitivestart.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ReinforcedBoneArrow extends AbstractArrow {

    public ReinforcedBoneArrow(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public ReinforcedBoneArrow(LivingEntity p_36718_, Level p_36719_) {
        super(EntityInit.REINFORCED_BONE_ARROW.get(), p_36718_, p_36719_);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.REINFORCED_BONE_ARROW.get());
    }
}
