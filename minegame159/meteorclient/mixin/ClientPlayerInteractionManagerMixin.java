package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.util.math.*;
import minegame159.meteorclient.*;
import meteorclient.*;
import net.minecraft.client.network.*;
import meteorclient.modules.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_636.class })
public abstract class ClientPlayerInteractionManagerMixin implements c39918
{
    @Shadow
    private int field_3716;
    @Shadow
    private float field_3715;
    @Shadow
    private BlockPos field_3714;
    
    public ClientPlayerInteractionManagerMixin() {
        super();
    }
    
    @Shadow
    protected abstract void method_2911();
    
    @Inject(method = { "attackEntity" }, at = { @At("HEAD") }, cancellable = true)
    private void onAttackEntity(final PlayerEntity playerEntity, final Entity entity, final CallbackInfo callbackInfo) {
        final c33360 m34517 = c34429.m34517(entity);
        MeteorClient.eventBus.post((Object)m34517);
        if (m34517.m32676()) {
            callbackInfo.cancel();
        }
        if (entity instanceof PlayerEntity && c34030.f34033.m34042(Antifriendhit.class).m35315() && !c39017.f39019.m39041((PlayerEntity)entity)) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "method_2902" }, at = { @At("HEAD") }, cancellable = true)
    private void onAttackBlock(final class_2338 class_2338, final class_2350 class_2339, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        final c32772 m34519 = c34429.m34519((BlockPos)class_2338, (Direction)class_2339);
        MeteorClient.eventBus.post((Object)m34519);
        if (m34519.m32676()) {
            callbackInfoReturnable.cancel();
        }
    }
    
    @Inject(method = { "getReachDistance" }, at = { @At("HEAD") }, cancellable = true)
    private void onGetReachDistance(final CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (c34030.f34033.m34049(Reach.class)) {
            callbackInfoReturnable.setReturnValue((Object)c34030.f34033.m34042(Reach.class).m31919());
        }
    }
    
    @Redirect(method = { "method_2902" }, at = @At(value = "FIELD", target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;field_3716:I", opcode = 181))
    private void onMethod_2902SetField_3716Proxy(final ClientPlayerInteractionManager clientPlayerInteractionManager, int field_3716) {
        if (c34030.f34033.m34049(Nuker.class)) {
            field_3716 = 0;
        }
        this.field_3716 = field_3716;
    }
    
    @Redirect(method = { "attackBlock" }, at = @At(value = "FIELD", target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;field_3716:I", opcode = 181))
    private void onAttackBlockSetField_3719Proxy(final ClientPlayerInteractionManager clientPlayerInteractionManager, int field_3716) {
        if (c34030.f34033.m34049(Nuker.class)) {
            field_3716 = 0;
        }
        this.field_3716 = field_3716;
    }
    
    @Inject(method = { "breakBlock" }, at = { @At("HEAD") })
    private void onBreakBlock(final class_2338 class_2338, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        MeteorClient.eventBus.post((Object)c34429.m34537((BlockPos)class_2338));
    }
    
    @Override
    public void m39919() {
        this.syncSelectedSlot();
    }
    
    @Override
    public double m39920() {
        return this.currentBreakingProgress;
    }
    
    @Override
    public BlockPos m39921() {
        return this.currentBreakingPos;
    }
}
