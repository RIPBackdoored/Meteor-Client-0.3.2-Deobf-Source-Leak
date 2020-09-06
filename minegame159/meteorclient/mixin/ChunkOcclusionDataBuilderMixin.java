package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.util.math.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_852.class })
public class ChunkOcclusionDataBuilderMixin
{
    public ChunkOcclusionDataBuilderMixin() {
        super();
    }
    
    @Inject(method = { "markClosed" }, at = { @At("HEAD") }, cancellable = true)
    private void onMarkClosed(final BlockPos blockPos, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34049(Xray.class)) {
            callbackInfo.cancel();
        }
    }
}
