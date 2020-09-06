package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.client.render.entity.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.client.render.*;
import meteorclient.util.*;
import net.minecraft.util.hit.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;

@Mixin({ class_761.class })
public class WorldRendererMixin
{
    @Shadow
    @Final
    private EntityRenderDispatcher field_4109;
    
    public WorldRendererMixin() {
        super();
    }
    
    @Inject(method = { "loadEntityOutlineShader" }, at = { @At("TAIL") })
    private void onLoadEntityOutlineShader(final CallbackInfo callbackInfo) {
        c38335.m38342();
    }
    
    @Inject(method = { "renderEntities" }, at = { @At("HEAD") })
    private void onRenderEntitiesHead(final Camera camera, final VisibleRegion visibleRegion, final float n, final CallbackInfo callbackInfo) {
        EnchantUtil.f35531 = true;
    }
    
    @Inject(method = { "renderEntities" }, at = { @At("TAIL") })
    private void onRenderEntitiesTail(final Camera camera, final VisibleRegion visibleRegion, final float n, final CallbackInfo callbackInfo) {
        EnchantUtil.f35531 = false;
    }
    
    @Inject(method = { "renderEntities" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;canDrawEntityOutlines()Z") })
    private void onRenderEntitiesOutlines(final Camera camera, final VisibleRegion visibleRegion, final float n, final CallbackInfo callbackInfo) {
        c38335.m38345(this.entityRenderDispatcher, visibleRegion, camera, n);
    }
    
    @Inject(method = { "drawEntityOutlinesFramebuffer" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/gl/Framebuffer;drawInternal(IIZ)V") })
    private void onDrawEntityOutlinesFramebuffer(final CallbackInfo callbackInfo) {
        c38335.m38352();
    }
    
    @Inject(method = { "onResized" }, at = { @At("HEAD") })
    private void onResized(final int n, final int n2, final CallbackInfo callbackInfo) {
        c38335.m38354(n, n2);
    }
    
    @Inject(method = { "drawHighlightedBlockOutline" }, at = { @At("HEAD") }, cancellable = true)
    private void onDrawHighlightedBlockOutline(final Camera camera, final HitResult hitResult, final int n, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34049(Blockselection.class)) {
            callbackInfo.cancel();
        }
    }
}
