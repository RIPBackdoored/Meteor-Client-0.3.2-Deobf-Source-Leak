package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import baritone.api.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.effect.*;
import minegame159.meteorclient.*;

public class Speed extends Module
{
    private static final String[] f39500;
    private final Settings f39501;
    private final Value<Double> f39502;
    private final Value<Boolean> f39503;
    private final Value<Boolean> f39504;
    private final Value<Boolean> f39505;
    private final Value<Boolean> f39506;
    @EventHandler
    private Listener<c37294> f39507;
    
    public Speed() {
        super(Category.Movement, "speed", "Speeeeeed.");
        this.f39501 = this.f38675.m34572();
        this.f39502 = this.f39501.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("How fast you want to go in blocks per second.").m38965(5.6).m38974(0.0).m38983(50.0).m38988());
        this.f39503 = this.f39501.addValue((Value<Boolean>)new c34427.c34657().m34664("only-on-ground").m34667("Use speed only when on ground.").m34670(false).m34679());
        this.f39504 = this.f39501.addValue((Value<Boolean>)new c34427.c34657().m34664("in-water").m34667("Use speed when in water.").m34670(false).m34679());
        this.f39505 = this.f39501.addValue((Value<Boolean>)new c34427.c34657().m34664("when-sneaking").m34667("Use speed when sneaking.").m34670(false).m34679());
        this.f39506 = this.f39501.addValue((Value<Boolean>)new c34427.c34657().m34664("apply-speed-potions").m34667("Apply speed potion effect.").m34670(true).m34679());
        this.f39507 = (Listener<c37294>)new Listener(this::m39508, new Predicate[0]);
    }
    
    private /* synthetic */ void m39508(final c37294 c37294) {
        if (c37294.f37295 != MovementType.field_6308 || this.mc.player.isFallFlying() || this.mc.player.isClimbing() || this.mc.player.getVehicle() != null) {
            return;
        }
        if (!this.f39505.m33466() && this.mc.player.isSneaking()) {
            return;
        }
        if (this.f39503.m33466() && !this.mc.player.onGround) {
            return;
        }
        if (!this.f39504.m33466() && this.mc.player.isTouchingWater()) {
            return;
        }
        float n = this.mc.player.yaw;
        if (BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing() && ((c34922)BaritoneAPI.getProvider().getPrimaryBaritone().getLookBehavior()).m34923() != null) {
            n = ((c34922)BaritoneAPI.getProvider().getPrimaryBaritone().getLookBehavior()).m34923().getYaw();
        }
        final Vec3d fromPolar = Vec3d.fromPolar(0.0f, n);
        final Vec3d fromPolar2 = Vec3d.fromPolar(0.0f, n + 90.0f);
        double n2 = 0.0;
        double n3 = 0.0;
        boolean b = false;
        if (this.mc.player.input.pressingForward) {
            n2 += fromPolar.x / 20.0 * this.f39502.m33466();
            n3 += fromPolar.z / 20.0 * this.f39502.m33466();
            b = true;
        }
        if (this.mc.player.input.pressingBack) {
            n2 -= fromPolar.x / 20.0 * this.f39502.m33466();
            n3 -= fromPolar.z / 20.0 * this.f39502.m33466();
            b = true;
        }
        boolean b2 = false;
        if (this.mc.player.input.pressingRight) {
            n2 += fromPolar2.x / 20.0 * this.f39502.m33466();
            n3 += fromPolar2.z / 20.0 * this.f39502.m33466();
            b2 = true;
        }
        if (this.mc.player.input.pressingLeft) {
            n2 -= fromPolar2.x / 20.0 * this.f39502.m33466();
            n3 -= fromPolar2.z / 20.0 * this.f39502.m33466();
            b2 = true;
        }
        if (b && b2) {
            final double n4 = 1.0 / Math.sqrt(2.0);
            n2 *= n4;
            n3 *= n4;
        }
        if (this.f39506.m33466() && this.mc.player.hasStatusEffect(StatusEffects.field_5904)) {
            final double n5 = (this.mc.player.getStatusEffect(StatusEffects.field_5904).getAmplifier() + 1) * 0.205;
            n2 += n2 * n5;
            n3 += n3 * n5;
        }
        ((c37143)c37294.f37296).m37144(n2, c37294.f37296.y, n3);
    }
    
    static {
        f39500 = new String[] { "speed", "Speeeeeed.", "speed", "How fast you want to go in blocks per second.", "only-on-ground", "Use speed only when on ground.", "in-water", "Use speed when in water.", "when-sneaking", "Use speed when sneaking.", "apply-speed-potions", "Apply speed potion effect." };
    }
}
