package isensehostility.primitivestart;

import isensehostility.primitivestart.init.EntityInit;
import isensehostility.primitivestart.init.ItemInit;
import net.minecraftforge.fml.common.Mod;

@Mod("primitivestart")
public class PrimitiveStart {

    public static final String MODID = "primitivestart";

    public PrimitiveStart() {
        ItemInit.initialize();
        EntityInit.initialize();
    }
}
