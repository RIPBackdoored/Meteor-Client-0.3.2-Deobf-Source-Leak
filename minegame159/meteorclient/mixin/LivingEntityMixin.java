package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.*;
import minegame159.meteorclient.*;
import meteorclient.*;
import net.minecraft.entity.effect.*;
import meteorclient.modules.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_1309.class })
public abstract class LivingEntityMixin extends class_1297
{
    public LivingEntityMixin(final class_1299<?> class_1299, final class_1937 class_1300) {
        super((EntityType)class_1299, (World)class_1300);
    }
    
    @Inject(method = { "damage" }, at = { @At("HEAD") })
    private void onDamageHead(final class_1282 class_1282, final float n, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (EnchantUtil.m35613()) {
            MeteorClient.eventBus.post((Object)c34429.m34524((LivingEntity)this, (DamageSource)class_1282));
        }
    }
    
    @Inject(method = { "damage" }, at = { @At("TAIL") })
    private void onDamageTail(final class_1282 class_1282, final float n, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (EnchantUtil.m35613()) {
            MeteorClient.eventBus.post((Object)c34429.m34497((LivingEntity)this, (DamageSource)class_1282));
        }
    }
    
    @Inject(method = { "getJumpVelocity" }, at = { @At("HEAD") }, cancellable = true)
    private void onGetJumpVelocity(final CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (c34030.f34033.m34049(Highjump.class)) {
            callbackInfoReturnable.setReturnValue((Object)(0.42f * c34030.f34033.m34042(Highjump.class).m37401()));
        }
    }
    
    @Redirect(method = { "travel" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"))
    private boolean travelHasStatusEffectProxy(final LivingEntity livingEntity, final StatusEffect statusEffect) {
        return (statusEffect != StatusEffects.field_5902 || !c34030.f34033.m34049(Antilevitation.class)) && livingEntity.hasStatusEffect(statusEffect);
    }
    
    @Redirect(method = { "travel" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;hasNoGravity()Z"))
    private boolean travelHasNoGravityProxy(final LivingEntity livingEntity) {
        if (livingEntity.hasStatusEffect(StatusEffects.field_5902) && c34030.f34033.m34049(Antilevitation.class)) {
            return !c34030.f34033.m34042(Antilevitation.class).m33682();
        }
        return livingEntity.hasNoGravity();
    }
}
