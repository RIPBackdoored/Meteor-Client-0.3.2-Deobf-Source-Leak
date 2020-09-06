package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.util.math.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import meteorclient.util.*;
import net.minecraft.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;
import net.minecraft.container.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import minegame159.meteorclient.*;

public class Elytra extends Module
{
    private static final String[] f32550;
    private final Settings f32551;
    private final Settings f32552;
    private final Value<Boolean> f32553;
    private final Value<Boolean> f32554;
    private final Value<Integer> f32555;
    private final Value<Double> f32556;
    private final Value<Double> f32557;
    private final Value<Double> f32558;
    private final Value<Boolean> f32559;
    private final Value<Boolean> f32560;
    private final Value<Double> f32561;
    private boolean f32562;
    private boolean f32563;
    private int f32564;
    private double f32565;
    private double f32566;
    private double f32567;
    private Vec3d f32568;
    private Vec3d f32569;
    private boolean f32570;
    private int f32571;
    private boolean f32572;
    @EventHandler
    private Listener<c37294> f32573;
    @EventHandler
    private Listener<c36575> f32574;
    
    public Elytra() {
        super(Category.Movement, "Elytra+", "Makes elytra better.");
        this.f32551 = this.f38675.m34572();
        this.f32552 = this.f38675.m34574("Autopilot", "autopilot", "Automatically flies forward maintaining minimum height.", false, this::m32603);
        this.f32553 = this.f32551.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-take-off").m34667("Automatically takes off when you hold jump without needing to double jump.").m34670(false).m34679());
        this.f32554 = this.f32551.addValue((Value<Boolean>)new c34427.c34657().m34664("elytra-replace").m34667("Replaces your broken elytra with new ones").m34670(false).m34679());
        this.f32555 = this.f32551.addValue((Value<Integer>)new c32369.c32370().m32381("replace-durability").m32384("The durability to replace your elytra at").m32387(2).m32396(1).m32399(Items.field_8833.getMaxDamage() - 1).m32405(20).m32408());
        this.f32556 = this.f32551.addValue((Value<Double>)new c37033.c38947().m38959("fall-multiplier").m38962("Controls how fast will you go down naturally.").m38965(0.01).m38974(0.0).m38988());
        this.f32557 = this.f32551.addValue((Value<Double>)new c37033.c38947().m38959("horizontal-speed").m38962("How fast will you go forward and backward.").m38965(1.0).m38974(0.0).m38988());
        this.f32558 = this.f32551.addValue((Value<Double>)new c37033.c38947().m38959("vertical-speed").m38962("How fast will u go up and down.").m38965(1.0).m38974(0.0).m38988());
        this.f32559 = this.f32551.addValue((Value<Boolean>)new c34427.c34657().m34664("stop-in-water").m34667("Stops flying in water.").m34670(true).m34679());
        this.f32560 = this.f32551.addValue((Value<Boolean>)new c34427.c34657().m34664("don't-go-into-unloaded-chunks").m34667("Don't go into unloaded chunks.").m34670(true).m34679());
        this.f32561 = this.f32552.addValue((Value<Double>)new c37033.c38947().m38959("minimum-height").m38962("Autopilot minimum height.").m38965(160.0).m38974(0.0).m38983(260.0).m38988());
        this.f32573 = (Listener<c37294>)new Listener(this::m32598, new Predicate[0]);
        this.f32574 = (Listener<c36575>)new Listener(this::m32592, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f32562 = false;
        this.f32564 = 0;
    }
    
    @Override
    public void m35294() {
        if (this.f32552.m33970()) {
            ((c39520)this.mc.options.keyForward).m39521(false);
        }
    }
    
    private void m32575() {
        if (this.f32552.m33970()) {
            ((c39520)this.mc.options.keyForward).m39521(true);
            if (this.mc.player.y < this.f32561.m33466() && !this.f32570) {
                final int m31688 = c31671.m31688(Items.field_8639, (Predicate)c32549::m32590);
                if (m31688 != -1) {
                    this.mc.player.inventory.selectedSlot = m31688;
                    EnchantUtil.m35624();
                    this.f32570 = true;
                    this.f32571 = 20;
                }
                else {
                    c31351.m31360(this, "Disabled autopilot because you don't have any fireworks left in your hotbar.", new Object[0]);
                    this.f32552.m33972(false);
                }
            }
            if (this.f32571 > 0) {
                this.f32566 = 2.0;
            }
            this.f32572 = true;
        }
    }
    
    private void m32578() {
        boolean b = false;
        boolean b2 = false;
        if (this.mc.options.keyForward.isPressed()) {
            this.f32565 += this.f32568.x * this.f32557.m33466() * 10.0;
            this.f32567 += this.f32568.z * this.f32557.m33466() * 10.0;
            b = true;
        }
        else if (this.mc.options.keyBack.isPressed()) {
            this.f32565 -= this.f32568.x * this.f32557.m33466() * 10.0;
            this.f32567 -= this.f32568.z * this.f32557.m33466() * 10.0;
            b = true;
        }
        if (this.mc.options.keyRight.isPressed()) {
            this.f32565 += this.f32569.x * this.f32557.m33466() * 10.0;
            this.f32567 += this.f32569.z * this.f32557.m33466() * 10.0;
            b2 = true;
        }
        else if (this.mc.options.keyLeft.isPressed()) {
            this.f32565 -= this.f32569.x * this.f32557.m33466() * 10.0;
            this.f32567 -= this.f32569.z * this.f32557.m33466() * 10.0;
            b2 = true;
        }
        if (b && b2) {
            final double n = 1.0 / Math.sqrt(2.0);
            this.f32565 *= n;
            this.f32567 *= n;
        }
    }
    
    private void m32583() {
        if (this.mc.options.keyJump.isPressed()) {
            this.f32566 += 0.5 * this.f32558.m33466();
        }
        else if (this.mc.options.keySneak.isPressed()) {
            this.f32566 -= 0.5 * this.f32558.m33466();
        }
    }
    
    private void m32585() {
        if (this.f32566 < 0.0) {
            this.f32566 *= this.f32556.m33466();
        }
        else if (this.f32566 > 0.0) {
            this.f32566 = 0.0;
        }
    }
    
    private void m32587() {
        if (this.f32563) {
            ++this.f32564;
        }
        final boolean pressed = this.mc.options.keyJump.isPressed();
        if (this.f32553.m33466() && pressed) {
            if (!this.f32562 && !this.mc.player.isFallFlying()) {
                this.f32564 = 0;
                this.f32563 = true;
            }
            if (this.f32564 >= 8) {
                this.f32564 = 0;
                this.f32563 = false;
                this.mc.player.setJumping(false);
                this.mc.player.setSprinting(true);
                this.mc.player.jump();
                this.mc.getNetworkHandler().sendPacket((Packet)new ClientCommandC2SPacket((Entity)this.mc.player, class_2848.class_2849.field_12982));
            }
        }
        this.f32562 = pressed;
    }
    
    private static /* synthetic */ boolean m32590(final ItemStack itemStack) {
        return true;
    }
    
    private /* synthetic */ void m32592(final c36575 c36575) {
        if (this.f32570) {
            if (this.f32571 <= 0) {
                this.f32570 = false;
            }
            --this.f32571;
        }
        if (this.f32554.m33466() && this.mc.player.inventory.getArmorStack(2).getItem() == Items.field_8833 && this.mc.player.inventory.getArmorStack(2).getMaxDamage() - this.mc.player.inventory.getArmorStack(2).getDamage() <= this.f32555.m33466()) {
            int n = -1;
            for (int i = 9; i < 45; ++i) {
                final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
                if (invStack.getItem() == Items.field_8833 && invStack.getMaxDamage() - invStack.getDamage() > this.f32555.m33466()) {
                    n = i;
                }
            }
            if (n != -1) {
                c31671.m31675(n, 0, SlotActionType.field_7790);
                c31671.m31675(6, 0, SlotActionType.field_7790);
                c31671.m31675(n, 0, SlotActionType.field_7790);
            }
        }
    }
    
    private /* synthetic */ void m32598(final c37294 c37294) {
        if (!(this.mc.player.getEquippedStack(EquipmentSlot.field_6174).getItem() instanceof ElytraItem)) {
            return;
        }
        this.m32587();
        if (this.mc.player.isFallFlying()) {
            this.f32565 = 0.0;
            this.f32566 = c37294.f37296.y;
            this.f32567 = 0.0;
            this.f32568 = Vec3d.fromPolar(0.0f, this.mc.player.yaw).multiply(0.1);
            this.f32569 = Vec3d.fromPolar(0.0f, this.mc.player.yaw + 90.0f).multiply(0.1);
            if (this.mc.player.isTouchingWater() && this.f32559.m33466()) {
                this.mc.getNetworkHandler().sendPacket((Packet)new ClientCommandC2SPacket((Entity)this.mc.player, class_2848.class_2849.field_12982));
                return;
            }
            this.m32585();
            this.m32575();
            this.m32578();
            this.m32583();
            final int n = (int)((this.mc.player.x + this.f32565) / 16.0);
            final int n2 = (int)((this.mc.player.z + this.f32567) / 16.0);
            if (this.f32560.m33466()) {
                if (this.mc.world.method_2935().isChunkLoaded(n, n2)) {
                    ((c37143)c37294.f37296).m37144(this.f32565, this.f32566, this.f32567);
                }
                else {
                    ((c37143)c37294.f37296).m37144(0.0, this.f32566, 0.0);
                }
            }
            else {
                ((c37143)c37294.f37296).m37144(this.f32565, this.f32566, this.f32567);
            }
        }
        else if (this.f32572) {
            ((c39520)this.mc.options.keyForward).m39521(false);
            this.f32572 = false;
        }
    }
    
    private /* synthetic */ void m32603(final Settings settings) {
        if (this.m35315() && !settings.m33970()) {
            ((c39520)this.mc.options.keyForward).m39521(false);
        }
    }
    
    static {
        f32550 = new String[] { "Elytra+", "Makes elytra better.", "Autopilot", "autopilot", "Automatically flies forward maintaining minimum height.", "auto-take-off", "Automatically takes off when you hold jump without needing to double jump.", "elytra-replace", "Replaces your broken elytra with new ones", "replace-durability", "The durability to replace your elytra at", "fall-multiplier", "Controls how fast will you go down naturally.", "horizontal-speed", "How fast will you go forward and backward.", "vertical-speed", "How fast will u go up and down.", "stop-in-water", "Stops flying in water.", "don't-go-into-unloaded-chunks", "Don't go into unloaded chunks.", "minimum-height", "Autopilot minimum height.", "Disabled autopilot because you don't have any fireworks left in your hotbar." };
    }
}
