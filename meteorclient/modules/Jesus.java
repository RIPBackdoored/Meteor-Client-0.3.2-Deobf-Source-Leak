package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import net.minecraft.entity.*;
import java.util.function.*;
import java.util.stream.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.*;
import net.minecraft.network.*;
import minegame159.meteorclient.*;
import net.minecraft.util.math.*;

public class Jesus extends Module
{
    private static final String[] f32068;
    private int f32069;
    private int f32070;
    private class_2338.class_2339 f32071;
    @EventHandler
    private Listener<c36575> f32072;
    @EventHandler
    private Listener<c32410> f32073;
    
    public Jesus() {
        super(Category.Movement, "jesus", "Walk on water, be like jesus.");
        this.f32069 = 10;
        this.f32070 = 0;
        this.f32071 = new class_2338.class_2339();
        this.f32072 = (Listener<c36575>)new Listener(this::m32092, new Predicate[0]);
        this.f32073 = (Listener<c32410>)new Listener(this::m32083, new Predicate[0]);
    }
    
    public boolean m32074() {
        boolean b = false;
        boolean b2 = false;
        for (final Box box : this.mc.world.method_20812((Entity)this.mc.player, this.mc.player.getBoundingBox().offset(0.0, -0.5, 0.0)).map(class_265::method_1107).collect(Collectors.toCollection(ArrayList::new))) {
            this.f32071.method_10102(MathHelper.lerp(0.5, box.x1, box.x2), MathHelper.lerp(0.5, box.y1, box.y2), MathHelper.lerp(0.5, box.z1, box.z2));
            final Material material = this.mc.world.getBlockState((BlockPos)this.f32071).getMaterial();
            if (material == Material.WATER || material == Material.LAVA) {
                b = true;
            }
            else {
                if (material == Material.AIR) {
                    continue;
                }
                b2 = true;
            }
        }
        return b && !b2;
    }
    
    public boolean m32081() {
        return this.m35315() && this.mc.player != null && this.mc.player.fallDistance <= 3.0f && !this.mc.options.keySneak.isPressed() && !this.mc.player.isTouchingWater();
    }
    
    private /* synthetic */ void m32083(final c32410 c32410) {
        if (!(c32410.f32411 instanceof PlayerMoveC2SPacket)) {
            return;
        }
        final PlayerMoveC2SPacket playerMoveC2SPacket = (PlayerMoveC2SPacket)c32410.f32411;
        if (!(playerMoveC2SPacket instanceof class_2828.class_2829) && !(playerMoveC2SPacket instanceof class_2828.class_2830)) {
            return;
        }
        if (this.mc.player.isTouchingWater() || this.mc.player.fallDistance > 3.0f || !this.m32074()) {
            return;
        }
        if (this.mc.player.input.movementForward == 0.0f && this.mc.player.input.movementSideways == 0.0f) {
            c32410.m32674();
            return;
        }
        ++this.f32070;
        if (this.f32070 < 4) {
            return;
        }
        c32410.m32674();
        final double x = playerMoveC2SPacket.getX(0.0);
        final double n = playerMoveC2SPacket.getY(0.0) + 0.05;
        final double z = playerMoveC2SPacket.getZ(0.0);
        Object o;
        if (playerMoveC2SPacket instanceof class_2828.class_2829) {
            o = new class_2828.class_2829(x, n, z, true);
        }
        else {
            o = new class_2828.class_2830(x, n, z, playerMoveC2SPacket.getYaw(0.0f), playerMoveC2SPacket.getPitch(0.0f), true);
        }
        this.mc.getNetworkHandler().getConnection().send((Packet)o);
    }
    
    private /* synthetic */ void m32092(final c36575 c36575) {
        if (this.mc.options.keySneak.isPressed()) {
            return;
        }
        if (this.mc.player.isTouchingWater()) {
            final Vec3d velocity = this.mc.player.getVelocity();
            ((c37143)velocity).m37144(velocity.x, 0.11, velocity.z);
            this.f32069 = 0;
            return;
        }
        final Vec3d velocity2 = this.mc.player.getVelocity();
        if (this.f32069 == 0) {
            ((c37143)velocity2).m37144(velocity2.x, 0.3, velocity2.z);
        }
        else if (this.f32069 == 1) {
            ((c37143)velocity2).m37144(velocity2.x, 0.0, velocity2.z);
        }
        ++this.f32069;
    }
    
    static {
        f32068 = new String[] { "jesus", "Walk on water, be like jesus." };
    }
}
