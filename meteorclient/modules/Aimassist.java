package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import net.minecraft.util.math.*;
import net.minecraft.client.network.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.*;
import java.util.*;
import java.util.function.*;

public class Aimassist extends Module
{
    private static final String[] f34263;
    private final Settings f34264;
    private final Settings f34265;
    private final Settings f34266;
    private final Value<Double> f34267;
    private final Value<List<class_1299<?>>> f34268;
    private final Value<Boolean> f34269;
    private final Value<Boolean> f34270;
    private final Value<c34262.Priority> f34271;
    private final Value<c34262.Target> f34272;
    private final Value<Double> f34273;
    private final Vec3d f34274;
    private final Vec3d f34275;
    private Entity f34276;
    @EventHandler
    private final Listener<c36575> f34277;
    @EventHandler
    private final Listener<c36846> f34278;
    
    public Aimassist() {
        super(Category.Combat, "aim-assist", "Automatically aims at entities.");
        this.f34264 = this.f38675.m34572();
        this.f34265 = this.f38675.m34582("Speed", "speed-instant", "Instantly looks at the entity.", false);
        this.f34266 = this.f34265.m33980();
        this.f34267 = this.f34264.addValue((Value<Double>)new c37033.c38947().m38959("range").m38962("Aim range.").m38965(5.0).m38974(0.0).m38988());
        this.f34268 = this.f34264.addValue((Value<List<class_1299<?>>>)new c33686.c38917().m38925("entities").m38928("Entities to aim at.").m38931(new ArrayList<class_1299<?>>(0)).m38942());
        this.f34269 = this.f34264.addValue((Value<Boolean>)new c34427.c34657().m34664("friends").m34667("Aim at friends, useful only if attack players is on.").m34670(false).m34679());
        this.f34270 = this.f34264.addValue((Value<Boolean>)new c34427.c34657().m34664("ignore-walls").m34667("Aim through walls.").m34670(false).m34679());
        this.f34271 = this.f34264.addValue((Value<c34262.Priority>)new c36601.c36919<Enum>().m36926("priority").m36929("What entities to target.").m36932((Enum)c34262.Priority.LowestHealth).m36941());
        this.f34272 = this.f34264.addValue((Value<c34262.Target>)new c36601.c36919<Enum>().m36926("target").m36929("Where to aim.").m36932((Enum)c34262.Target.Body).m36941());
        this.f34273 = this.f34266.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("How fast to aim at the entity.").m38965(5.0).m38974(0.0).m38988());
        this.f34274 = new Vec3d(0.0, 0.0, 0.0);
        this.f34275 = new Vec3d(0.0, 0.0, 0.0);
        this.f34277 = (Listener<c36575>)new Listener(this::m34322, new Predicate[0]);
        this.f34278 = (Listener<c36846>)new Listener(this::m34319, new Predicate[0]);
    }
    
    private void m34279() {
        this.m34296(this.f34274, this.f34276);
        final double n = this.f34274.x - this.mc.player.x;
        final double n2 = this.f34274.z - this.mc.player.z;
        final double n3 = this.f34274.y - (this.mc.player.y + this.mc.player.getEyeHeight(this.mc.player.getPose()));
        this.mc.player.yaw = (float)(Math.toDegrees(Math.atan2(n2, n)) - 90.0);
        this.mc.player.pitch = (float)(-Math.toDegrees(Math.atan2(n3, Math.sqrt(n * n + n2 * n2))));
    }
    
    private void m34286(final double n) {
        this.m34296(this.f34274, this.f34276);
        final double n2 = this.f34274.x - this.mc.player.x;
        final double n3 = this.f34274.z - this.mc.player.z;
        final double n4 = this.f34274.y - (this.mc.player.y + this.mc.player.getEyeHeight(this.mc.player.getPose()));
        final double wrapDegrees = MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(n3, n2)) - 90.0 - this.mc.player.yaw);
        double n5 = this.f34273.m33466() * ((wrapDegrees >= 0.0) ? 1 : -1) * n;
        if ((n5 >= 0.0 && n5 > wrapDegrees) || (n5 < 0.0 && n5 < wrapDegrees)) {
            n5 = wrapDegrees;
        }
        final ClientPlayerEntity player = this.mc.player;
        player.yaw += (float)n5;
        final double wrapDegrees2 = MathHelper.wrapDegrees(-Math.toDegrees(Math.atan2(n4, Math.sqrt(n2 * n2 + n3 * n3))) - this.mc.player.pitch);
        double n6 = this.f34273.m33466() * ((wrapDegrees2 >= 0.0) ? 1 : -1) * n;
        if ((n6 >= 0.0 && n6 > wrapDegrees2) || (n6 < 0.0 && n6 < wrapDegrees2)) {
            n6 = wrapDegrees2;
        }
        final ClientPlayerEntity player2 = this.mc.player;
        player2.pitch += (float)n6;
    }
    
    private void m34296(final Vec3d vec3d, final Entity entity) {
        switch (c34262.c39334.f39335[this.f34272.m33466().ordinal()]) {
            case 1: {
                ((c37143)vec3d).m37144(entity.x, entity.y + entity.getEyeHeight(entity.getPose()), entity.z);
                break;
            }
            case 2: {
                ((c37143)vec3d).m37144(entity.x, entity.y + entity.getEyeHeight(entity.getPose()) / 2.0f, entity.z);
                break;
            }
            case 3: {
                ((c37143)vec3d).m37144(entity.x, entity.y, entity.z);
                break;
            }
        }
    }
    
    private boolean m34300(final Entity entity) {
        return entity != this.mc.player && this.f34268.m33466().contains(entity.getType()) && (!(entity instanceof PlayerEntity) || this.f34269.m33466() || c39017.f39019.m39041((PlayerEntity)entity));
    }
    
    private boolean m34303(final Entity entity) {
        if (this.f34270.m33466()) {
            return true;
        }
        ((c37143)this.f34274).m37144(this.mc.player.x, this.mc.player.y + this.mc.player.getStandingEyeHeight(), this.mc.player.z);
        ((c37143)this.f34275).m37144(entity.x, entity.y, entity.z);
        final boolean b = this.mc.world.rayTrace(new RayTraceContext(this.f34274, this.f34275, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (Entity)this.mc.player)).getType() == class_239.class_240.field_1333;
        ((c37143)this.f34275).m37144(entity.x, entity.y + entity.getStandingEyeHeight(), entity.z);
        final boolean b2 = this.mc.world.rayTrace(new RayTraceContext(this.f34274, this.f34275, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (Entity)this.mc.player)).getType() == class_239.class_240.field_1333;
        return b || b2;
    }
    
    private int m34308(final Entity entity, final Entity entity2) {
        switch (c34262.c39334.f39336[this.f34271.m33466().ordinal()]) {
            case 1: {
                return Double.compare(entity.distanceTo((Entity)this.mc.player), entity2.distanceTo((Entity)this.mc.player));
            }
            case 2: {
                return this.m34316(Double.compare(entity.distanceTo((Entity)this.mc.player), entity2.distanceTo((Entity)this.mc.player)));
            }
            case 3: {
                return Float.compare((entity instanceof LivingEntity) ? ((LivingEntity)entity).getHealth() : 0.0f, (entity2 instanceof LivingEntity) ? ((LivingEntity)entity2).getHealth() : 0.0f);
            }
            case 4: {
                return this.m34316(Float.compare((entity instanceof LivingEntity) ? ((LivingEntity)entity).getHealth() : 0.0f, (entity2 instanceof LivingEntity) ? ((LivingEntity)entity2).getHealth() : 0.0f));
            }
            default: {
                return 0;
            }
        }
    }
    
    private int m34316(final int n) {
        if (n == 0) {
            return 0;
        }
        return (n > 0) ? -1 : 1;
    }
    
    private /* synthetic */ void m34319(final c36846 c36846) {
        if (this.f34276 == null) {
            return;
        }
        if (this.f34265.m33970()) {
            this.m34279();
        }
        else {
            this.m34286(c36846.f36847);
        }
    }
    
    private /* synthetic */ void m34322(final c36575 c36575) {
        this.f34276 = null;
        Streams.stream(this.mc.world.getEntities()).filter(this::m34328).filter(this::m34300).filter(this::m34303).filter(class_1297::method_5805).min(this::m34308).ifPresent(this::m34325);
    }
    
    private /* synthetic */ void m34325(final Entity f34276) {
        this.f34276 = f34276;
    }
    
    private /* synthetic */ boolean m34328(final Entity entity) {
        return this.mc.player.distanceTo(entity) <= this.f34267.m33466();
    }
    
    static {
        f34263 = new String[] { "aim-assist", "Automatically aims at entities.", "Speed", "speed-instant", "Instantly looks at the entity.", "range", "Aim range.", "entities", "Entities to aim at.", "friends", "Aim at friends, useful only if attack players is on.", "ignore-walls", "Aim through walls.", "priority", "What entities to target.", "target", "Where to aim.", "speed", "How fast to aim at the entity." };
    }
}
