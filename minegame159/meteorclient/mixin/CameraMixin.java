package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_4184.class })
public class CameraMixin
{
    public CameraMixin() {
        super();
    }
    
    @Inject(method = { "clipToSpace" }, at = { @At("HEAD") }, cancellable = true)
    private void onClipToSpace(final double n, final CallbackInfoReturnable<Double> callbackInfoReturnable) {
        if (c34030.f34033.m34049(Cameraclip.class)) {
            callbackInfoReturnable.setReturnValue((Object)n);
        }
    }
}
