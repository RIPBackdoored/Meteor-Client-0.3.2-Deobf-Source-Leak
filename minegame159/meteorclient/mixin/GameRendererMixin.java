package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.render.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.*;
import meteorclient.util.*;
import minegame159.meteorclient.*;
import net.minecraft.entity.*;
import net.minecraft.util.hit.*;
import org.spongepowered.asm.mixin.injection.*;
import meteorclient.modules.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;

@Mixin({ class_757.class })
public abstract class GameRendererMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    @Final
    private MinecraftClient field_4015;
    @Shadow
    @Final
    private Camera field_18765;
    
    public GameRendererMixin() {
        super();
    }
    
    @Inject(method = { "render" }, at = { @At("HEAD") }, cancellable = true)
    private void onRender(final float n, final long n2, final boolean b, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34049(UnfocusedCPU.class) && !this.client.isWindowFocused()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(at = { @At(value = "INVOKE_STRING", target = "Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V", args = { "ldc=hand" }) }, method = { "renderCenter" })
    public void onRenderCenter(final float n, final long n2, final CallbackInfo callbackInfo) {
        if (!EnchantUtil.m35613()) {
            return;
        }
        this.client.getProfiler().swap("meteor-client_render");
        c39098.m39099();
        final c36846 m34491 = c34429.m34491(n, this.camera.getPos().x, this.camera.getPos().y, this.camera.getPos().z);
        c36524.m36528(m34491);
        MeteorClient.eventBus.post((Object)m34491);
        c36524.m36533();
    }
    
    @Redirect(method = { "updateTargetedEntity" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;rayTrace(DFZ)Lnet/minecraft/util/hit/HitResult;"))
    private HitResult updateTargetedEntityEntityRayTraceProxy(final Entity entity, final double n, final float n2, final boolean b) {
        if (c34030.f34033.m34049(Liquidinteract.class)) {
            return entity.rayTrace(n, n2, true);
        }
        return entity.rayTrace(n, n2, b);
    }
    
    @Inject(method = { "bobViewWhenHurt" }, at = { @At("HEAD") }, cancellable = true)
    private void onBobViewWhenHurt(final float n, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31718()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderWeather" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderWeather(final float n, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31720()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderRain" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderRain(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31720()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "showFloatingItem" }, at = { @At("HEAD") }, cancellable = true)
    private void onShowFloatingItem(final ItemStack itemStack, final CallbackInfo callbackInfo) {
        if (itemStack.getItem() == Items.field_8288 && c34030.f34033.m34042(Norender.class).m31740()) {
            callbackInfo.cancel();
        }
    }
    
    @Redirect(method = { "applyCameraTransformations" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerp(FFF)F"))
    private float applyCameraTransformationsMathHelperLerpProxy(final float n, final float n2, final float n3) {
        if (c34030.f34033.m34042(Norender.class).m31744()) {
            return 0.0f;
        }
        return MathHelper.lerp(n, n2, n3);
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "meteor-client_render" };
    }
}
