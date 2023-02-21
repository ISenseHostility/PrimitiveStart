package isensehostility.primitivestart.init;

import isensehostility.primitivestart.PrimitiveStart;
import isensehostility.primitivestart.entity.BoneArrow;
import isensehostility.primitivestart.entity.ReinforcedBoneArrow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, PrimitiveStart.MODID);

    public static void initialize() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<EntityType<BoneArrow>> BONE_ARROW = ENTITIES.register("bone_arrow",
            () -> EntityType.Builder
                    .<BoneArrow>of(BoneArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(PrimitiveStart.MODID, "bone_arrow").toString())
    );
    public static final RegistryObject<EntityType<ReinforcedBoneArrow>> REINFORCED_BONE_ARROW = ENTITIES.register("reinforced_bone_arrow",
            () -> EntityType.Builder
                    .<ReinforcedBoneArrow>of(ReinforcedBoneArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(PrimitiveStart.MODID, "reinforced_bone_arrow").toString())
    );
    public static final RegistryObject<EntityType<PlatedBoneArrow>> PLATED_BONE_ARROW = ENTITIES.register("plated_bone_arrow",
            () -> EntityType.Builder
                    .<PlatedBoneArrow>of(PlatedBoneArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(PrimitiveStart.MODID, "plated_bone_arrow").toString())
    );
}
