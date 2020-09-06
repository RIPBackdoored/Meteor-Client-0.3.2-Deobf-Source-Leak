package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_759.class })
public class HeldItemRendererMixin
{
    public HeldItemRendererMixin() {
        super();
    }
    
    @Inject(method = { "renderFireOverlay" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderFireOverlay(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31726()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderWaterOverlay" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderWaterOverlay(final float n, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31728()) {
            callbackInfo.cancel();
        }
    }
}
