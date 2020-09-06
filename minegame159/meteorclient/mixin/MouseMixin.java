package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_312.class })
public class MouseMixin
{
    public MouseMixin() {
        super();
    }
    
    @Inject(method = { "onMouseButton" }, at = { @At("TAIL") })
    private void onMouseButton(final long n, final int n2, final int n3, final int n4, final CallbackInfo callbackInfo) {
        if (n2 == 2 && n3 == 1) {
            MeteorClient.eventBus.post((Object)c34429.m34503());
        }
        else if (n2 == 1 && n3 == 1) {
            MeteorClient.eventBus.post((Object)c34429.m34527());
        }
    }
}
