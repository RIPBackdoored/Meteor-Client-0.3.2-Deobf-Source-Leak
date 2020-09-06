package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class Trigger extends Module
{
    private static final String[] f37126;
    private final Settings f37127;
    private final Value<Boolean> f37128;
    @EventHandler
    private Listener<c36575> f37129;
    
    public Trigger() {
        super(Category.Combat, "trigger", "Automatically attacks when you look at entities.");
        this.f37127 = this.f38675.m34572();
        this.f37128 = this.f37127.addValue((Value<Boolean>)new c34427.c34657().m34664("only-when-holding-attack").m34667("Attacks only when you are holding left click.").m34670(false).m34679());
        this.f37129 = (Listener<c36575>)new Listener(this::m37132, new Predicate[0]);
    }
    
    private void m37130() {
        this.mc.interactionManager.attackEntity((PlayerEntity)this.mc.player, this.mc.targetedEntity);
        this.mc.player.swingHand(Hand.field_5808);
    }
    
    private /* synthetic */ void m37132(final c36575 c36575) {
        if (this.mc.player.getHealth() <= 0.0f || this.mc.player.getAttackCooldownProgress(0.5f) < 1.0f) {
            return;
        }
        if (!(this.mc.targetedEntity instanceof LivingEntity)) {
            return;
        }
        if (((LivingEntity)this.mc.targetedEntity).getHealth() <= 0.0f) {
            return;
        }
        if (this.f37128.m33466()) {
            if (this.mc.options.keyAttack.isPressed()) {
                this.m37130();
            }
        }
        else {
            this.m37130();
        }
    }
    
    static {
        f37126 = new String[] { "trigger", "Automatically attacks when you look at entities.", "only-when-holding-attack", "Attacks only when you are holding left click." };
    }
}
