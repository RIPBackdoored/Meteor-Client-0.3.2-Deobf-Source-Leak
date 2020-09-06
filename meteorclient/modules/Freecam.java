package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.client.network.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import minegame159.meteorclient.*;
import net.minecraft.util.math.*;
import net.minecraft.network.packet.c2s.play.*;

public class Freecam extends Module
{
    private static final String[] f38363;
    private final Settings f38364;
    private final Value<Double> f38365;
    private OtherClientPlayerEntity f38366;
    private OtherClientPlayerEntity f38367;
    @EventHandler
    private final Listener<c32410> f38368;
    @EventHandler
    private final Listener<c36575> f38369;
    
    public Freecam() {
        super(Category.Render, "freecam", "You know what it does.");
        this.f38364 = this.f38675.m34572();
        this.f38365 = this.f38364.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("Speed").m38965(1.0).m38974(0.0).m38988());
        this.f38368 = (Listener<c32410>)new Listener(c38362::m38379, new Predicate[0]);
        this.f38369 = (Listener<c36575>)new Listener(this::m38372, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        (this.f38366 = new OtherClientPlayerEntity(this.mc.world, this.mc.player.getGameProfile())).copyPositionAndRotation((Entity)this.mc.player);
        this.f38366.horizontalCollision = false;
        this.f38366.verticalCollision = false;
        ((c31839)this.f38366).m31840(this.mc.player.inventory);
        (this.f38367 = new OtherClientPlayerEntity(this.mc.world, this.mc.player.getGameProfile())).copyPositionAndRotation((Entity)this.mc.player);
        this.f38367.setBoundingBox(this.f38367.getBoundingBox().expand(0.1));
        ((c31839)this.f38367).m31840(this.mc.player.inventory);
        this.mc.world.addEntity(this.f38366.getEntityId(), (Entity)this.f38366);
        this.mc.world.addEntity(this.f38367.getEntityId(), (Entity)this.f38367);
        this.mc.cameraEntity = (Entity)this.f38366;
    }
    
    @Override
    public void m35294() {
        if (this.mc.world == null) {
            return;
        }
        this.mc.cameraEntity = (Entity)this.mc.player;
        this.mc.world.removeEntity(this.f38366.getEntityId());
        this.mc.world.removeEntity(this.f38367.getEntityId());
    }
    
    private /* synthetic */ void m38372(final c36575 c36575) {
        if (this.mc.player.deathTime > 0 || this.mc.player.getHealth() <= 0.0f) {
            this.m35300();
            return;
        }
        this.f38366.setVelocity(0.0, 0.0, 0.0);
        this.f38366.yaw = this.mc.player.yaw;
        this.f38366.headYaw = this.mc.player.headYaw;
        this.f38366.elytraYaw = this.mc.player.elytraYaw;
        this.f38366.pitch = this.mc.player.pitch;
        this.f38366.elytraPitch = this.mc.player.elytraPitch;
        this.f38366.setHealth(this.mc.player.getHealth());
        this.f38366.setAbsorptionAmount(this.mc.player.getAbsorptionAmount());
        this.f38366.getActiveStatusEffects().putAll(this.mc.player.getActiveStatusEffects());
        final double n = this.f38365.m33466() / 2.0;
        Vec3d vec3d = this.f38366.getVelocity();
        final Vec3d rotateY = new Vec3d(0.0, 0.0, n).rotateY(-(float)Math.toRadians(this.f38366.headYaw));
        final Vec3d rotateY2 = rotateY.rotateY((float)Math.toRadians(90.0));
        if (this.mc.options.keyForward.isPressed()) {
            vec3d = vec3d.add(rotateY.x, 0.0, rotateY.z);
        }
        if (this.mc.options.keyBack.isPressed()) {
            vec3d = vec3d.subtract(rotateY.x, 0.0, rotateY.z);
        }
        if (this.mc.options.keyLeft.isPressed()) {
            vec3d = vec3d.add(rotateY2.x, 0.0, rotateY2.z);
        }
        if (this.mc.options.keyRight.isPressed()) {
            vec3d = vec3d.subtract(rotateY2.x, 0.0, rotateY2.z);
        }
        if (this.mc.options.keyJump.isPressed()) {
            vec3d = vec3d.add(0.0, n, 0.0);
        }
        if (this.mc.options.keySneak.isPressed()) {
            vec3d = vec3d.subtract(0.0, n, 0.0);
        }
        final OtherClientPlayerEntity f38366 = this.f38366;
        f38366.x += vec3d.x;
        final OtherClientPlayerEntity f38367 = this.f38366;
        f38367.y += vec3d.y;
        final OtherClientPlayerEntity f38368 = this.f38366;
        f38368.z += vec3d.z;
    }
    
    private static /* synthetic */ void m38379(final c32410 c32410) {
        if (c32410.f32411 instanceof ClientCommandC2SPacket || c32410.f32411 instanceof PlayerMoveC2SPacket || c32410.f32411 instanceof PlayerInputC2SPacket) {
            c32410.m32674();
        }
    }
    
    static {
        f38363 = new String[] { "freecam", "You know what it does.", "speed", "Speed" };
    }
}
