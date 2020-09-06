package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.util.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.*;
import net.minecraft.network.*;
import minegame159.meteorclient.*;

@Mixin({ class_2535.class })
public class ClientConnectionMixin
{
    public ClientConnectionMixin() {
        super();
    }
    
    @Inject(method = { "disconnect" }, at = { @At("HEAD") })
    private void onDisconnect(final Text text, final CallbackInfo callbackInfo) {
        if (EnchantUtil.m35613() && !MeteorClient.f32301) {
            MeteorClient.f32301 = true;
            MeteorClient.eventBus.post((Object)c34429.m34501(text));
        }
    }
    
    @Inject(method = { "handlePacket" }, at = { @At("HEAD") }, cancellable = true)
    private static <T extends java.lang.Object> void onHandlePacket(final class_2596<T> class_2596, final class_2547 class_2597, final CallbackInfo callbackInfo) {
        final c39306 m34506 = c34429.m34506((Packet)class_2596);
        MeteorClient.eventBus.post((Object)m34506);
        if (m34506.m32676()) {
            callbackInfo.cancel();
        }
    }
}
