package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.entity.player.*;
import meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import net.minecraft.entity.*;

@Mixin({ class_897.class })
public abstract class EntityRendererMixin<T extends class_1297>
{
    public EntityRendererMixin() {
        super();
    }
    
    @Inject(method = { "renderLabel(Lnet/minecraft/entity/Entity;Ljava/lang/String;DDDI)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderLabel(final T t, final String s, final double n, final double n2, final double n3, final int n4, final CallbackInfo callbackInfo) {
        if (!(t instanceof PlayerEntity)) {
            return;
        }
        if (c34030.f34033.m34049(Nametags.class)) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "getOutlineColor" }, at = { @At("HEAD") }, cancellable = true)
    private void onGetOutlineColor(final T t, final CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (c38335.f38339) {
            callbackInfoReturnable.setReturnValue((Object)c34030.f34033.m34042(Esp.class).m31493((Entity)t).m37056());
        }
    }
}
