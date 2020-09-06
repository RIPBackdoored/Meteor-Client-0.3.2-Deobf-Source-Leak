package minegame159.meteorclient.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import minegame159.meteorclient.*;
import meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.client.network.*;
import meteorclient.modules.*;

@Mixin({ class_746.class })
public abstract class ClientPlayerEntityMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    @Final
    public ClientPlayNetworkHandler field_3944;
    private boolean ignoreChatMessage;
    
    public ClientPlayerEntityMixin() {
        super();
    }
    
    @Shadow
    public abstract void method_3142(final String p0);
    
    @Inject(at = { @At("HEAD") }, method = { "sendChatMessage" }, cancellable = true)
    private void onSendChatMessage(final String s, final CallbackInfo callbackInfo) {
        if (this.ignoreChatMessage) {
            return;
        }
        if (!s.startsWith(c33436.f34122.m34133()) && !s.startsWith("/")) {
            final c37172 m34532 = c34429.m34532(s);
            MeteorClient.eventBus.post((Object)m34532);
            this.ignoreChatMessage = true;
            this.sendChatMessage(m34532.f37173);
            this.ignoreChatMessage = false;
            callbackInfo.cancel();
            return;
        }
        if (s.startsWith(c33436.f34122.m34133())) {
            c32790.m32792(s.substring(c33436.f34122.m34133().length()));
            callbackInfo.cancel();
        }
    }
    
    @Redirect(method = { "updateNausea" }, at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;"))
    private Screen updateNauseaGetCurrentScreenProxy(final MinecraftClient minecraftClient) {
        if (c34030.f34033.m34049(Portals.class)) {
            return null;
        }
        return minecraftClient.currentScreen;
    }
    
    @Redirect(method = { "tickMovement" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"))
    private boolean proxy_tickMovement_isUsingItem(final ClientPlayerEntity clientPlayerEntity) {
        return !c34030.f34033.m34042(Noslow.class).m34419() && clientPlayerEntity.isUsingItem();
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "/" };
    }
}
