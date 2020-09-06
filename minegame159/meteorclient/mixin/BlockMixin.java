package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.*;
import net.minecraft.block.*;

@Mixin({ class_2248.class })
public class BlockMixin
{
    public BlockMixin() {
        super();
    }
    
    @Inject(method = { "getAmbientOcclusionLightLevel" }, at = { @At("HEAD") }, cancellable = true)
    private void onGetAmbientOcclusionLightLevel(final class_2680 class_2680, final class_1922 class_2681, final class_2338 class_2682, final CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (c34030.f34033.m34049(Xray.class)) {
            callbackInfoReturnable.setReturnValue((Object)1.0f);
        }
    }
    
    @Inject(at = { @At("HEAD") }, method = { "shouldDrawSide" }, cancellable = true)
    private static void onShouldDrawSide(final class_2680 class_2680, final class_1922 class_2681, final class_2338 class_2682, final class_2350 class_2683, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final Xray xray = c34030.f34033.m34042(Xray.class);
        if (xray.m35315()) {
            callbackInfoReturnable.setReturnValue((Object)!xray.m38231(((BlockState)class_2680).getBlock()));
        }
    }
}
