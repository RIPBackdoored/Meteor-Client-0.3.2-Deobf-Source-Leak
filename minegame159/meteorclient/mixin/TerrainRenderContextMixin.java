package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.block.*;

@Mixin({ TerrainRenderContext.class })
public class TerrainRenderContextMixin
{
    public TerrainRenderContextMixin() {
        super();
    }
    
    @Inject(method = { "tesselateBlock" }, at = { @At("HEAD") }, cancellable = true, remap = false)
    private void onTesselateBlock(final class_2680 class_2680, final class_2338 class_2681, final class_1087 class_2682, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (c34030.f34033.m34042(Xray.class).m38231(((BlockState)class_2680).getBlock())) {
            callbackInfoReturnable.cancel();
        }
    }
}
