package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.client.render.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import com.mojang.blaze3d.platform.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_758.class })
public class BackgroundRendererMixin
{
    public BackgroundRendererMixin() {
        super();
    }
    
    @Inject(method = { "applyFog" }, at = { @At("TAIL") })
    private void onApplyFog(final Camera camera, final int n, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31736() || c34030.f34033.m34049(Xray.class)) {
            GlStateManager.disableFog();
        }
    }
}
