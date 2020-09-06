package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;
import meteorclient.modules.*;
import meteorclient.*;
import minegame159.meteorclient.*;
import net.minecraft.util.*;
import net.minecraft.text.*;
import java.io.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin({ class_1799.class })
public abstract class ItemStackMixin
{
    @Shadow
    private int field_8031;
    
    public ItemStackMixin() {
        super();
    }
    
    @Shadow
    public abstract CompoundTag method_7953(final CompoundTag p0);
    
    @Inject(method = { "getTooltip" }, at = { @At("TAIL") }, locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onGetTooltip(final class_1657 class_1657, final class_1836 class_1658, final CallbackInfoReturnable<List<class_2561>> callbackInfoReturnable, final List<class_2561> list) {
        if (class_1657 != null && c34030.f34033.m34049(Itembytesize.class)) {
            try {
                this.toTag(new CompoundTag()).write((DataOutput)c38826.f38827);
                final int m38829 = c38826.f38827.m38829();
                c38826.f38827.m38831();
                list.add((class_2561)new LiteralText(Formatting.field_1080 + c34030.f34033.m34042(Itembytesize.class).m34648(m38829)));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
