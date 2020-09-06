package minegame159.meteorclient.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_317.class })
public class RenderTickCounterMixin
{
    @Shadow
    public float field_1969;
    
    public RenderTickCounterMixin() {
        super();
    }
    
    @Inject(method = { "beginRenderTick" }, at = { @At(value = "FIELD", target = "Lnet/minecraft/client/render/RenderTickCounter;prevTimeMillis:J", opcode = 181) })
    private void onBeingRenderTick(final long n, final CallbackInfo callbackInfo) {
        this.lastFrameDuration *= (float)c34030.f34033.m34042(Timer.class).m38252();
    }
}
