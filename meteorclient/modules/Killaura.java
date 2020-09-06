package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.util.math.*;
import me.zero.alpine.listener.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import baritone.api.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.*;
import net.minecraft.util.*;
import minegame159.meteorclient.*;

public class Killaura extends Module
{
    private static final String[] f32801;
    private final Settings f32802;
    private final Settings f32803;
    private final Settings f32804;
    private final Settings f32805;
    private final Value<Double> f32806;
    private final Value<List<class_1299<?>>> f32807;
    private final Value<Boolean> f32808;
    private final Value<Boolean> f32809;
    private final Value<Boolean> f32810;
    private final Value<Integer> f32811;
    private final Value<Boolean> f32812;
    private final Value<Boolean> f32813;
    private final Value<c32769.Priority> f32814;
    private final Value<Boolean> f32815;
    private final Value<Boolean> f32816;
    private final Value<Boolean> f32817;
    private final Value<Boolean> f32818;
    private final Value<Integer> f32819;
    private final Value<Integer> f32820;
    private boolean f32821;
    private int f32822;
    private int f32823;
    private Entity f32824;
    private boolean f32825;
    private boolean f32826;
    private final Random f32827;
    private final Vec3d f32828;
    private final Vec3d f32829;
    @EventHandler
    private final Listener<c36575> f32830;
    
    public Killaura() {
        super(Category.Combat, "kill-aura", "Automatically attacks entities.");
        this.f32802 = this.f38675.m34572();
        this.f32803 = this.f38675.m34582("Delay", "smart-delay", "Smart delay.", true);
        this.f32804 = this.f32803.m33980();
        this.f32805 = this.f38675.m34582("Random Delay", "random-delay-enabled", "Adds a random delay to hits to try and bypass anti-cheats.", false);
        this.f32806 = this.f32802.addValue((Value<Double>)new c37033.c38947().m38959("range").m38962("Attack range.").m38965(5.5).m38974(0.0).m38988());
        this.f32807 = this.f32802.addValue((Value<List<class_1299<?>>>)new c33686.c38917().m38925("entities").m38928("Entities to attack.").m38931(new ArrayList<class_1299<?>>(0)).m38940().m38942());
        this.f32808 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("only-on-ground").m34667("Only attacks players that are on the ground (useful to bypass anti-cheats)").m34670(false).m34679());
        this.f32809 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("nametagged").m34667("Hit nametagged mobs.").m34670(false).m34679());
        this.f32810 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("babies").m34667("Hit baby animals.").m34670(true).m34679());
        this.f32811 = this.f32802.addValue((Value<Integer>)new c32369.c32370().m32381("hit-chance").m32384("The probability of your hits counting").m32387(100).m32396(0).m32399(100).m32405(100).m32408());
        this.f32812 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("friends").m34667("Attack friends, useful only if attack players is on.").m34670(false).m34679());
        this.f32813 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("ignore-walls").m34667("Attack through walls.").m34670(true).m34679());
        this.f32814 = this.f32802.addValue((Value<c32769.Priority>)new c36601.c36919<Enum>().m36926("priority").m36929("What entities to target.").m36932((Enum)c32769.Priority.LowestHealth).m36941());
        this.f32815 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("rotate").m34667("Rotates you towards the target.").m34670(false).m34679());
        this.f32816 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("insta-kill").m34667("If your sharpness is enough to kill then just swing").m34670(true).m34679());
        this.f32817 = this.f32802.addValue((Value<Boolean>)new c34427.c34657().m34664("pause-on-combat").m34667("Pauses baritone when you get near a target").m34670(false).m34679());
        this.f32818 = this.f32803.addValue((Value<Boolean>)new c34427.c34657().m34664("one-tick-delay").m34667("Adds one tick delay.").m34670(true).m34679());
        this.f32819 = this.f32804.addValue((Value<Integer>)new c32369.c32370().m32381("hit-delay").m32384("Hit delay in ticks. 20 ticks = 1 second.").m32387(0).m32396(0).m32405(60).m32408());
        this.f32820 = this.f32805.addValue((Value<Integer>)new c32369.c32370().m32381("random-delay-max").m32384("Maximum random value for random delay.").m32387(4).m32396(0).m32405(20).m32408());
        this.f32825 = false;
        this.f32826 = false;
        this.f32827 = new Random(System.currentTimeMillis());
        this.f32828 = new Vec3d(0.0, 0.0, 0.0);
        this.f32829 = new Vec3d(0.0, 0.0, 0.0);
        this.f32830 = (Listener<c36575>)new Listener(this::m32859, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f32822 = 0;
        this.f32823 = 0;
    }
    
    private boolean m32831(final Entity entity) {
        return entity.distanceTo((Entity)this.mc.player) <= this.f32806.m33466();
    }
    
    private boolean m32834(final Entity entity) {
        if (entity == this.mc.player || entity == this.mc.cameraEntity || entity.getUuid().equals(this.mc.player.getUuid()) || !this.f32807.m33466().contains(entity.getType())) {
            return false;
        }
        if (entity instanceof PlayerEntity) {
            return this.f32812.m33466() || c39017.f39019.m39041((PlayerEntity)entity);
        }
        return !(entity instanceof AnimalEntity) || this.f32810.m33466() || !((AnimalEntity)entity).isBaby();
    }
    
    private boolean m32837(final Entity entity) {
        return !this.f32808.m33466() || (this.f32808.m33466() && entity instanceof PlayerEntity && entity.onGround) || ((!this.f32808.m33466() || !(entity instanceof PlayerEntity) || entity.onGround) && this.f32808.m33466() && !(entity instanceof PlayerEntity));
    }
    
    private boolean m32840(final Entity entity) {
        if (this.f32813.m33466()) {
            return true;
        }
        ((c37143)this.f32828).m37144(this.mc.player.x, this.mc.player.y + this.mc.player.getStandingEyeHeight(), this.mc.player.z);
        ((c37143)this.f32829).m37144(entity.x, entity.y, entity.z);
        final boolean b = this.mc.world.rayTrace(new RayTraceContext(this.f32828, this.f32829, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (Entity)this.mc.player)).getType() == class_239.class_240.field_1333;
        ((c37143)this.f32829).m37144(entity.x, entity.y + entity.getStandingEyeHeight(), entity.z);
        final boolean b2 = this.mc.world.rayTrace(new RayTraceContext(this.f32828, this.f32829, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (Entity)this.mc.player)).getType() == class_239.class_240.field_1333;
        return b || b2;
    }
    
    private int m32845(final int n) {
        if (n == 0) {
            return 0;
        }
        return (n > 0) ? -1 : 1;
    }
    
    private int m32848(final Entity entity, final Entity entity2) {
        switch (c32769.c32770.f32771[this.f32814.m33466().ordinal()]) {
            case 1: {
                return Double.compare(entity.distanceTo((Entity)this.mc.player), entity2.distanceTo((Entity)this.mc.player));
            }
            case 2: {
                return this.m32845(Double.compare(entity.distanceTo((Entity)this.mc.player), entity2.distanceTo((Entity)this.mc.player)));
            }
            case 3: {
                return Float.compare((entity instanceof LivingEntity) ? ((LivingEntity)entity).getHealth() : 0.0f, (entity2 instanceof LivingEntity) ? ((LivingEntity)entity2).getHealth() : 0.0f);
            }
            case 4: {
                return this.m32845(Float.compare((entity instanceof LivingEntity) ? ((LivingEntity)entity).getHealth() : 0.0f, (entity2 instanceof LivingEntity) ? ((LivingEntity)entity2).getHealth() : 0.0f));
            }
            default: {
                return 0;
            }
        }
    }
    
    private boolean m32856(final Entity entity) {
        return (!entity.hasCustomName() || this.f32809.m33466()) && (!entity.hasCustomName() || !this.f32809.m33466() || true);
    }
    
    private /* synthetic */ void m32859(final c36575 c36575) {
        if (this.mc.player.getHealth() <= 0.0f) {
            return;
        }
        if (this.f32824 == null && this.f32826) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("resume");
            this.f32826 = false;
        }
        this.f32824 = null;
        this.f32825 = false;
        Streams.stream(this.mc.world.getEntities()).filter(this::m32831).filter(this::m32834).filter(this::m32840).filter(class_1297::method_5805).filter(this::m32837).filter(this::m32856).min(this::m32848).ifPresent(this::m32862);
        if (this.f32825) {
            return;
        }
        if (this.f32803.m33970()) {
            if (this.mc.player.getAttackCooldownProgress(0.5f) < 1.0f) {
                return;
            }
            if (this.f32818.m33466()) {
                if (!this.f32821) {
                    this.f32821 = true;
                    return;
                }
                this.f32821 = false;
            }
        }
        else {
            if (this.f32822 >= 0) {
                --this.f32822;
                return;
            }
            this.f32822 = this.f32819.m33466();
        }
        if (this.f32805.m33970() && this.f32823 > 0) {
            --this.f32823;
            return;
        }
        if (this.f32824 != null && this.f32827.nextInt(100) < this.f32811.m33466()) {
            if (this.f32815.m33466()) {
                ((c37143)this.f32828).m37144(this.f32824.x, this.f32824.y + this.f32824.getHeight() / 2.0f, this.f32824.z);
                this.mc.player.lookAt(class_2183.class_2184.field_9851, this.f32828);
            }
            this.mc.interactionManager.attackEntity((PlayerEntity)this.mc.player, this.f32824);
            this.mc.player.swingHand(Hand.field_5808);
            if (this.f32805.m33970()) {
                this.f32823 = (int)Math.round(Math.random() * this.f32820.m33466());
            }
        }
    }
    
    private /* synthetic */ void m32862(final Entity f32824) {
        this.f32824 = f32824;
        if (this.f32827.nextInt(100) > this.f32811.m33466()) {
            return;
        }
        if (this.f32824 instanceof PlayerEntity && this.f32816.m33466() && c36537.m36553((PlayerEntity)this.f32824, false) >= ((PlayerEntity)this.f32824).getHealth() + ((PlayerEntity)this.f32824).getAbsorptionAmount()) {
            if (this.f32815.m33466()) {
                ((c37143)this.f32828).m37144(this.f32824.x, this.f32824.y + this.f32824.getHeight() / 2.0f, this.f32824.z);
                this.mc.player.lookAt(class_2183.class_2184.field_9851, this.f32828);
            }
            this.mc.interactionManager.attackEntity((PlayerEntity)this.mc.player, this.f32824);
            this.mc.player.swingHand(Hand.field_5808);
            this.f32825 = true;
        }
        if (this.f32817.m33466() && BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing() && !this.f32826) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("pause");
            this.f32826 = true;
        }
    }
    
    static {
        f32801 = new String[] { "kill-aura", "Automatically attacks entities.", "Delay", "smart-delay", "Smart delay.", "Random Delay", "random-delay-enabled", "Adds a random delay to hits to try and bypass anti-cheats.", "range", "Attack range.", "entities", "Entities to attack.", "only-on-ground", "Only attacks players that are on the ground (useful to bypass anti-cheats)", "nametagged", "Hit nametagged mobs.", "babies", "Hit baby animals.", "hit-chance", "The probability of your hits counting", "friends", "Attack friends, useful only if attack players is on.", "ignore-walls", "Attack through walls.", "priority", "What entities to target.", "rotate", "Rotates you towards the target.", "insta-kill", "If your sharpness is enough to kill then just swing", "pause-on-combat", "Pauses baritone when you get near a target", "one-tick-delay", "Adds one tick delay.", "hit-delay", "Hit delay in ticks. 20 ticks = 1 second.", "random-delay-max", "Maximum random value for random delay.", "resume", "pause" };
    }
}
