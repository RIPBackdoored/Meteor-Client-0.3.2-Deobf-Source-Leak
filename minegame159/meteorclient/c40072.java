package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.*;
import net.minecraft.*;
import net.minecraft.block.entity.*;

public class c40072 extends c39130
{
    private static final String[] f40073;
    
    public c40072(final Value<List<class_2591<?>>> value) {
        super("Select storage blocks", true);
        for (int i = 0; i < c32920.f35246.length; ++i) {
            final class_2591<?> class_2591 = c32920.f35246[i];
            this.add(new c39081(c32920.f35247[i]));
            this.add(new c38264(value.m33466().contains(class_2591))).m39587().m39589().m39632().f38265 = c40072::m40074;
            this.m39132();
        }
    }
    
    private static /* synthetic */ void m40074(final Value value, final BlockEntityType blockEntityType, final c38264 c38264) {
        if (c38264.f38266 && !value.m33466().contains(blockEntityType)) {
            value.m33466().add(blockEntityType);
            value.m33480();
        }
        else if (!c38264.f38266 && value.m33466().remove(blockEntityType)) {
            value.m33480();
        }
    }
    
    static {
        f40073 = new String[] { "Select storage blocks" };
    }
}
