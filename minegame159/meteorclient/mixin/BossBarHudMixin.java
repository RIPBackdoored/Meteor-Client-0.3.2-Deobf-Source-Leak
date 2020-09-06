package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_337.class })
public class BossBarHudMixin
{
    public BossBarHudMixin() {
        super();
    }
    
    @Inject(method = { "render" }, at = { @At("HEAD") }, cancellable = true)
    private void onRender(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31732()) {
            callbackInfo.cancel();
        }
    }
}
