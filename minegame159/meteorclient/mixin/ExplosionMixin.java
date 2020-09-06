package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.util.math.*;
import net.minecraft.client.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;

@Mixin({ class_1927.class })
public class ExplosionMixin
{
    private Entity entity;
    
    public ExplosionMixin() {
        super();
    }
    
    @Redirect(method = { "collectBlocksAndDamageEntities" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isImmuneToExplosion()Z"))
    private boolean collectBlocksAndDamageEntitiesEntityIsImmuneToExplosionProxy(final Entity entity) {
        this.entity = entity;
        return entity.isImmuneToExplosion();
    }
    
    @Redirect(method = { "collectBlocksAndDamageEntities" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;add(DDD)Lnet/minecraft/util/math/Vec3d;"))
    private Vec3d collectBlocksAndDamageEntitiesVec3dAddProxy(final Vec3d vec3d, final double n, final double n2, final double n3) {
        if (!this.entity.getUuid().equals(MinecraftClient.getInstance().player.getUuid())) {
            return vec3d.add(n, n2, n3);
        }
        final Velocity velocity = c34030.f34033.m34042(Velocity.class);
        final Vec3d add = vec3d.add(n * velocity.m35284(), n2 * velocity.m35286(), n3 * velocity.m35284());
        this.entity = null;
        return add;
    }
}
