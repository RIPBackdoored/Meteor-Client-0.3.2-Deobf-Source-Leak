package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.client.sound.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_1140.class })
public class SoundSystemMixin
{
    public SoundSystemMixin() {
        super();
    }
    
    @Inject(method = { "play(Lnet/minecraft/client/sound/SoundInstance;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onPlay(final SoundInstance soundInstance, final CallbackInfo callbackInfo) {
        final c38846 m34534 = c34429.m34534(soundInstance);
        MeteorClient.eventBus.post((Object)m34534);
        if (m34534.m32676()) {
            callbackInfo.cancel();
        }
    }
}
