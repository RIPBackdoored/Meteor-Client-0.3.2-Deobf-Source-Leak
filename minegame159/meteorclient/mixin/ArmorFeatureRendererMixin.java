package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.player.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_970.class })
public class ArmorFeatureRendererMixin<T extends class_1309, M extends class_572<T>, A extends class_572<T>>
{
    public ArmorFeatureRendererMixin() {
        super();
    }
    
    @Inject(method = { "renderArmor" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderArmor(final T t, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final class_1304 class_1304, final CallbackInfo callbackInfo) {
        if (t instanceof PlayerEntity && c34030.f34033.m34042(Norender.class).m31742()) {
            callbackInfo.cancel();
        }
    }
}
