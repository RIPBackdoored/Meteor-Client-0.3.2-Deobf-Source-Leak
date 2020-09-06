package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_743.class })
public class KeyboardInputMixin
{
    public KeyboardInputMixin() {
        super();
    }
    
    @Inject(method = { "tick" }, at = { @At("TAIL") })
    private void onTick(final boolean b, final boolean b2, final CallbackInfo callbackInfo) {
        c34030.f34033.m34042(Invmove.class).m33514();
    }
}
