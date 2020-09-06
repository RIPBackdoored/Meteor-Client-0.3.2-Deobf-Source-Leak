package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.client.world.*;
import java.net.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.util.*;
import net.minecraft.client.network.*;
import net.minecraft.client.gui.screen.*;
import javax.annotation.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.util.*;
import net.minecraft.client.*;
import net.minecraft.util.hit.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_310.class })
public abstract class MinecraftClientMixin implements c37135
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    public ClientWorld field_1687;
    @Shadow
    private int field_1752;
    @Shadow
    public Mouse field_1729;
    @Shadow
    public Window field_1704;
    @Shadow
    @Final
    private Proxy field_1739;
    @Shadow
    private Session field_1726;
    @Shadow
    public ClientPlayerEntity field_1724;
    @Shadow
    @Nullable
    public Screen field_1755;
    
    public MinecraftClientMixin() {
        super();
    }
    
    @Shadow
    protected abstract void method_1583();
    
    @Shadow
    protected abstract void method_1536();
    
    @Shadow
    protected abstract void method_1503();
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        MeteorClient.INSTANCE.onInitializeClient();
    }
    
    @Inject(at = { @At("TAIL") }, method = { "tick" })
    private void onTick(final CallbackInfo callbackInfo) {
        if (EnchantUtil.m35613()) {
            this.world.getProfiler().swap("meteor-client_update");
            MeteorClient.eventBus.post((Object)c34429.m34496());
        }
    }
    
    @Inject(method = { "openScreen" }, at = { @At("HEAD") }, cancellable = true)
    private void onOpenScreen(final Screen screen, final CallbackInfo callbackInfo) {
        if (screen instanceof c32480) {
            screen.mouseMoved(this.mouse.getX() * this.window.getScaleFactor(), this.mouse.getY() * this.window.getScaleFactor());
        }
        final c31559 m34485 = c34429.m34485(screen);
        MeteorClient.eventBus.post((Object)m34485);
        if (m34485.m32676()) {
            callbackInfo.cancel();
            return;
        }
        if (this.currentScreen instanceof c32480 && !(screen instanceof c32480)) {
            c34739.m34744();
        }
    }
    
    @Redirect(method = { "doItemUse" }, at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;crosshairTarget:Lnet/minecraft/util/hit/HitResult;", ordinal = 1))
    private HitResult doItemUseMinecraftClientCrosshairTargetProxy(final MinecraftClient minecraftClient) {
        if (c34030.f34033.m34042(Autoeat.class).m32518() && c34030.f34033.m34042(Autogap.class).m32239()) {
            return minecraftClient.crosshairTarget;
        }
        return null;
    }
    
    @Override
    public void m37136() {
        this.doAttack();
    }
    
    @Override
    public void m37137() {
        this.doItemUse();
    }
    
    @Override
    public void m37138(final int itemUseCooldown) {
        this.itemUseCooldown = itemUseCooldown;
    }
    
    @Override
    public Proxy m37139() {
        return this.netProxy;
    }
    
    @Override
    public void m37140(final Session session) {
        this.session = session;
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "meteor-client_update" };
    }
}
