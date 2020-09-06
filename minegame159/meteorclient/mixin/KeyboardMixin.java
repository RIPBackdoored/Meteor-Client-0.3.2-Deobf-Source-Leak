package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.util.*;
import net.fabricmc.fabric.api.client.keybinding.*;
import org.spongepowered.asm.mixin.injection.*;
import minegame159.meteorclient.*;
import net.minecraft.client.options.*;

@Mixin({ class_309.class })
public abstract class KeyboardMixin
{
    @Shadow
    @Final
    private MinecraftClient field_1678;
    
    public KeyboardMixin() {
        super();
    }
    
    @Inject(method = { "onKey" }, at = { @At("HEAD") }, cancellable = true)
    public void onKey(final long n, final int n2, final int n3, final int n4, final int n5, final CallbackInfo callbackInfo) {
        if (n2 != -1 && c34739.m34743()) {
            c38412.m38414(n2, n4 != 0);
            final FabricKeyBinding shulkerPeek = MeteorClient.INSTANCE.shulkerPeek;
            if (((KeyBinding)shulkerPeek).matchesKey(n2, n3) && (n4 == 1 || n4 == 2)) {
                ((c39520)shulkerPeek).m39521(true);
            }
            else {
                ((c39520)shulkerPeek).m39521(false);
            }
            if (this.client.currentScreen instanceof c32480 && n4 == 2) {
                ((c32480)this.client.currentScreen).keyRepeated(n2, n5);
            }
            if (!EnchantUtil.m35613() && n4 == 1) {
                MeteorClient.INSTANCE.m32329(n2);
                if (this.client.currentScreen instanceof c32480 && c34739.m34743()) {
                    c34030.f34033.f34038 = true;
                    c34030.f34033.f34039.invoke((Object)c34429.m34478(n2, true));
                    c34030.f34033.f34038 = false;
                }
                return;
            }
            if (!this.client.isPaused() && (this.client.currentScreen == null || (this.client.currentScreen instanceof c32480 && c34739.m34743()))) {
                final c38944 m34478 = c34429.m34478(n2, n4 == 1);
                MeteorClient.eventBus.post((Object)m34478);
                if (m34478.m32676()) {
                    callbackInfo.cancel();
                }
            }
        }
    }
    
    @Inject(method = { "onChar" }, at = { @At("HEAD") }, cancellable = true)
    private void onChar(final long n, final int n2, final int n3, final CallbackInfo callbackInfo) {
        if (EnchantUtil.m35613() && !this.client.isPaused() && (this.client.currentScreen == null || this.client.currentScreen instanceof c32480)) {
            final c32918 m34472 = c34429.m34472((char)n2);
            MeteorClient.eventBus.post((Object)m34472);
            if (m34472.m32676()) {
                callbackInfo.cancel();
            }
        }
    }
}
