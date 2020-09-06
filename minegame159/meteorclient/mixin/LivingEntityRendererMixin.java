package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_922.class })
public class LivingEntityRendererMixin<T extends class_1309>
{
    public LivingEntityRendererMixin() {
        super();
    }
    
    @Inject(method = { "render(Lnet/minecraft/entity/LivingEntity;DDDFF)V" }, at = { @At("HEAD") })
    private void onRenderHead(final T t, final double n, final double n2, final double n3, final float n4, final float n5, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Chams.class).m32477((LivingEntity)t)) {
            GL11.glEnable(32823);
            GL11.glPolygonOffset(1.0f, -1000000.0f);
        }
    }
    
    @Inject(method = { "render(Lnet/minecraft/entity/LivingEntity;DDDFF)V" }, at = { @At("TAIL") })
    private void onRenderTail(final T t, final double n, final double n2, final double n3, final float n4, final float n5, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Chams.class).m32477((LivingEntity)t)) {
            GL11.glPolygonOffset(1.0f, 1000000.0f);
            GL11.glDisable(32823);
        }
    }
}
