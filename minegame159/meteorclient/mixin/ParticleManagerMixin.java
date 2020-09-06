package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import net.minecraft.client.particle.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.block.*;
import meteorclient.modules.*;
import net.minecraft.util.math.*;

@Mixin({ class_702.class })
public class ParticleManagerMixin
{
    public ParticleManagerMixin() {
        super();
    }
    
    @Inject(method = { "addParticle(Lnet/minecraft/client/particle/Particle;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onAddParticle(final Particle particle, final CallbackInfo callbackInfo) {
        final Norender norender = c34030.f34033.m34042(Norender.class);
        if (norender.m31716() && (particle instanceof BubbleColumnUpParticle || particle instanceof BubblePopParticle || particle instanceof WaterBubbleParticle)) {
            callbackInfo.cancel();
        }
        else if (norender.m31738() && (particle instanceof ExplosionSmokeParticle || particle instanceof ExplosionLargeParticle || particle instanceof ExplosionEmitterParticle)) {
            callbackInfo.cancel();
        }
        else if (norender.m31740() && particle instanceof TotemParticle) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "addBlockBreakParticles" }, at = { @At("HEAD") }, cancellable = true)
    private void onAddBlockBreakParticles(final BlockPos blockPos, final BlockState blockState, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Nuker.class).m39726()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "addBlockBreakingParticles" }, at = { @At("HEAD") }, cancellable = true)
    private void onAddBlockBreakingParticles(final BlockPos blockPos, final Direction direction, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Nuker.class).m39726()) {
            callbackInfo.cancel();
        }
    }
}
