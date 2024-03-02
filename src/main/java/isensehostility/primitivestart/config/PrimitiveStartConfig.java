package isensehostility.primitivestart.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class PrimitiveStartConfig {
    public static ForgeConfigSpec.ConfigValue<String> boneItem;
    public static ForgeConfigSpec.ConfigValue<String> featherItem;

    public static ForgeConfigSpec.BooleanValue pluckingEnabled;
    public static ForgeConfigSpec.BooleanValue boneDropsEnabled;
    public static ForgeConfigSpec.BooleanValue extraStickDropsEnabled;
    public static ForgeConfigSpec.BooleanValue noTreePunchingEnabled;

    public static ForgeConfigSpec.IntValue extraStickChance;

    private static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec config;

    static {
        initialize(builder);
        config = builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

    public static void initialize(ForgeConfigSpec.Builder config) {
        boneItem = config
                .comment("Determines what item is dropped as a bone from animals.")
                .define("items.boneItem", "minecraft:bone");
        featherItem = config
                .comment("Determines what item is dropped as a feather from chickens when they are plucked.")
                .define("items.featherItem", "minecraft:feather");

        pluckingEnabled = config
                .comment("Determines if right-clicking on a chicken with shears drops a feather.")
                .define("enabled.plucking", true);
        boneDropsEnabled = config
                .comment("Determines if animals can drop bones on death.")
                .define("enabled.boneDrops", true);
        extraStickDropsEnabled = config
                .comment("Determines if extra sticks are dropped from leaves.")
                .define("enabled.extraStickDrops", true);
        noTreePunchingEnabled = config
                .comment("Determines if logs can't be gathered with fists.")
                .define("enabled.noTreePunching", true);

        extraStickChance = config
                .comment("Determines the % chance to get an extra stick from leaves.")
                .defineInRange("values.extraSticksChance", 15, 1, 100);

    }
}
