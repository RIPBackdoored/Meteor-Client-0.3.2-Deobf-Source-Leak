package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.mojang.blaze3d.platform.*;
import org.lwjgl.opengl.*;
import org.spongepowered.asm.mixin.injection.*;
import minegame159.meteorclient.*;
import meteorclient.*;
import meteorclient.modules.*;
import net.minecraft.entity.*;
import net.minecraft.scoreboard.*;

@Mixin({ class_329.class })
public abstract class InGameHudMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    private int field_2011;
    @Shadow
    private int field_2029;
    @Shadow
    @Final
    private MinecraftClient field_2035;
    
    public InGameHudMixin() {
        super();
    }
    
    @Inject(at = { @At("TAIL") }, method = { "render" })
    private void onRender(final float n, final CallbackInfo callbackInfo) {
        this.client.getProfiler().swap("meteor-client_render");
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.lineWidth(1.0f);
        GL11.glEnable(2848);
        MeteorClient.eventBus.post((Object)c34429.m34487(this.scaledWidth, this.scaledHeight, n));
        GL11.glDisable(2848);
        GlStateManager.lineWidth(1.0f);
        GlStateManager.disableBlend();
        GlStateManager.disableBlend();
    }
    
    @Inject(method = { "renderStatusEffectOverlay" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderStatusEffectOverlay(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34049(HUD.class) && c34030.f34033.m34042(HUD.class).f35968.m33466()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderPortalOverlay" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderPortalOverlay(final float n, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31722()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderPumpkinOverlay" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderPumpkinOverlay(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31724()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderVignetteOverlay" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderVignetteOverlay(final Entity entity, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31730()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderScoreboardSidebar" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderScoreboardSidebar(final ScoreboardObjective scoreboardObjective, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31734()) {
            callbackInfo.cancel();
        }
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "meteor-client_render" };
    }
}
