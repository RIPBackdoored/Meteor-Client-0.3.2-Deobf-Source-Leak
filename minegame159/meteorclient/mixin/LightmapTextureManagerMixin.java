package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.client.network.*;
import net.minecraft.entity.effect.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.client.render.*;
import net.minecraft.entity.*;

@Mixin({ class_765.class })
public class LightmapTextureManagerMixin
{
    public LightmapTextureManagerMixin() {
        super();
    }
    
    @Redirect(method = { "update" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z", ordinal = 0))
    private boolean updateHasStatusEffectProxy(final ClientPlayerEntity clientPlayerEntity, final StatusEffect statusEffect) {
        return c34030.f34033.m34049(Fullbright.class) || clientPlayerEntity.hasStatusEffect(statusEffect);
    }
    
    @Redirect(method = { "update" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;getNightVisionStrength(Lnet/minecraft/entity/LivingEntity;F)F"))
    private float updateGetNightVisionStrengthProxy(final GameRenderer gameRenderer, final LivingEntity livingEntity, final float n) {
        return c34030.f34033.m34049(Fullbright.class) ? 1.0f : gameRenderer.getNightVisionStrength(livingEntity, n);
    }
}
