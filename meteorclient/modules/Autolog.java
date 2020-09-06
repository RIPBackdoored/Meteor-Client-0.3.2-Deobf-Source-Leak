package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.decoration.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.world.dimension.*;
import net.minecraft.block.entity.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.text.*;

public class Autolog extends Module
{
    private static final String[] f33277;
    private final Settings f33278;
    private final Value<Integer> f33279;
    private final Value<Boolean> f33280;
    private final Value<Boolean> f33281;
    private final Value<Boolean> f33282;
    private final Value<Boolean> f33283;
    private final Value<Integer> f33284;
    @EventHandler
    private final Listener<c36575> f33285;
    
    public Autolog() {
        super(Category.Combat, "auto-log", "Automatically disconnects when low on health.");
        this.f33278 = this.f38675.m34572();
        this.f33279 = this.f33278.addValue((Value<Integer>)new c32369.c32370().m32381("health").m32384("Disconnects when health is lower or equal to this value.").m32387(6).m32396(0).m32399(20).m32405(20).m32408());
        this.f33280 = this.f33278.addValue((Value<Boolean>)new c34427.c34657().m34664("smart").m34667("Disconnects when you are about to take too much damage.").m34670(true).m34679());
        this.f33281 = this.f33278.addValue((Value<Boolean>)new c34427.c34657().m34664("only-trusted").m34667("Disconnects when non-trusted player appears in your render distance.").m34670(false).m34679());
        this.f33282 = this.f33278.addValue((Value<Boolean>)new c34427.c34657().m34664("32k").m34667("Logs out out if someone near you can insta kill you").m34670(false).m34679());
        this.f33283 = this.f33278.addValue((Value<Boolean>)new c34427.c34657().m34664("crystal-log").m34667("Log you out when there is a crystal nearby.").m34670(false).m34679());
        this.f33284 = this.f33278.addValue((Value<Integer>)new c32369.c32370().m32381("range").m32384("How close a crystal has to be to log.").m32387(4).m32396(1).m32399(10).m32405(5).m32408());
        this.f33285 = (Listener<c36575>)new Listener(this::m33292, new Predicate[0]);
    }
    
    private double m33286() {
        double n = 0.0;
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity instanceof EnderCrystalEntity && n < c36537.m36539((LivingEntity)this.mc.player, entity.getPos())) {
                n = c36537.m36539((LivingEntity)this.mc.player, entity.getPos());
            }
            else {
                if (!(entity instanceof PlayerEntity) || n >= c36537.m36553((PlayerEntity)entity, true) || c39017.f39019.m39037((PlayerEntity)entity) || this.mc.player.getPos().distanceTo(entity.getPos()) >= 5.0 || !(((PlayerEntity)entity).getActiveItem().getItem() instanceof SwordItem)) {
                    continue;
                }
                n = c36537.m36553((PlayerEntity)entity, true);
            }
        }
        if (!c34030.f34033.m34042(Nofall.class).m35315() && this.mc.player.fallDistance > 3.0f) {
            final double n2 = this.mc.player.fallDistance * 0.5;
            if (n2 > n) {
                n = n2;
            }
        }
        if (this.mc.world.dimension.getType() != DimensionType.field_13072) {
            for (final BlockEntity blockEntity : this.mc.world.blockEntities) {
                if (blockEntity instanceof BedBlockEntity && n < c36537.m36546((LivingEntity)this.mc.player, new Vec3d((Vec3i)blockEntity.getPos()))) {
                    n = c36537.m36546((LivingEntity)this.mc.player, new Vec3d((Vec3i)blockEntity.getPos()));
                }
            }
        }
        return n;
    }
    
    private /* synthetic */ void m33292(final c36575 c36575) {
        if (this.mc.player.getHealth() <= 0.0f) {
            this.m35300();
            return;
        }
        if (this.mc.player.getHealth() <= this.f33279.m33466()) {
            this.mc.player.networkHandler.onDisconnect(new DisconnectS2CPacket((Text)new LiteralText("Health was lower than " + this.f33279.m33466())));
        }
        if (this.f33280.m33466() && this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount() - this.m33286() < this.f33279.m33466()) {
            this.mc.player.networkHandler.onDisconnect(new DisconnectS2CPacket((Text)new LiteralText("Health was going to be lower than " + this.f33279.m33466())));
        }
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity instanceof PlayerEntity && entity.getUuid() != this.mc.player.getUuid()) {
                if (this.f33281.m33466() && entity != this.mc.player && !c39017.f39019.m39037((PlayerEntity)entity)) {
                    this.mc.player.networkHandler.onDisconnect(new DisconnectS2CPacket((Text)new LiteralText("Non-trusted player appeared in your render distance")));
                    break;
                }
                if (this.mc.player.distanceTo(entity) < 8.0f && this.f33282.m33466() && c36537.m36553((PlayerEntity)entity, true) > this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount()) {
                    this.mc.player.networkHandler.onDisconnect(new DisconnectS2CPacket((Text)new LiteralText("Anti-32k measures.")));
                    break;
                }
            }
            if (entity instanceof EnderCrystalEntity && this.mc.player.distanceTo(entity) < this.f33284.m33466() && this.f33283.m33466()) {
                this.mc.player.networkHandler.onDisconnect(new DisconnectS2CPacket((Text)new LiteralText("Crystal within specified range.")));
            }
        }
    }
    
    static {
        f33277 = new String[] { "auto-log", "Automatically disconnects when low on health.", "health", "Disconnects when health is lower or equal to this value.", "smart", "Disconnects when you are about to take too much damage.", "only-trusted", "Disconnects when non-trusted player appears in your render distance.", "32k", "Logs out out if someone near you can insta kill you", "crystal-log", "Log you out when there is a crystal nearby.", "range", "How close a crystal has to be to log.", "Health was lower than ", "Health was going to be lower than ", "Non-trusted player appeared in your render distance", "Anti-32k measures.", "Crystal within specified range." };
    }
}
