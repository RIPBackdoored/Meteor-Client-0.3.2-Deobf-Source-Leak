package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import meteorclient.modules.*;
import meteorclient.*;

@Mixin({ class_1297.class })
public abstract class EntityMixin
{
    public EntityMixin() {
        super();
    }
    
    @Redirect(method = { "setVelocityClient" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setVelocity(DDD)V"))
    private void setVelocityClientEntiySetVelocityProxy(final Entity entity, final double n, final double n2, final double n3) {
        if (this != MinecraftClient.getInstance().player) {
            entity.setVelocity(n, n2, n3);
            return;
        }
        final Velocity velocity = c34030.f34033.m34042(Velocity.class);
        System.out.println(entity.getVelocity());
        entity.setVelocity(entity.getVelocity().x + n * velocity.m35284(), entity.getVelocity().y + n2 * velocity.m35286(), entity.getVelocity().z + n3 * velocity.m35284());
    }
    
    @Redirect(method = { "addVelocity" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;add(DDD)Lnet/minecraft/util/math/Vec3d;"))
    private Vec3d addVelocityVec3dAddProxy(final Vec3d vec3d, final double n, final double n2, final double n3) {
        if (this != MinecraftClient.getInstance().player) {
            return vec3d.add(n, n2, n3);
        }
        final Velocity velocity = c34030.f34033.m34042(Velocity.class);
        return vec3d.add(n * velocity.m35284(), n2 * velocity.m35286(), n3 * velocity.m35284());
    }
    
    @Inject(method = { "move" }, at = { @At("HEAD") })
    private void onMove(final MovementType movementType, final Vec3d vec3d, final CallbackInfo callbackInfo) {
        if (this != MinecraftClient.getInstance().player) {
            return;
        }
        MeteorClient.eventBus.post((Object)c34429.m34508(movementType, vec3d));
    }
    
    @Redirect(method = { "adjustMovementForSneaking" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isSneaking()Z"))
    private boolean isSafeWalkSneaking(final Entity entity) {
        final Scaffold scaffold = c34030.f34033.m34042(Scaffold.class);
        return entity.isSneaking() || c34030.f34033.m34049(Safewalk.class) || (scaffold.m35315() && scaffold.m35084());
    }
}
