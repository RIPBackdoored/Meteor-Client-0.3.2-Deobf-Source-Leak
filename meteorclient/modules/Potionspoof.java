package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import meteorclient.util.*;
import java.util.function.*;
import minegame159.meteorclient.*;
import net.minecraft.entity.effect.*;
import it.unimi.dsi.fastutil.objects.*;

public class Potionspoof extends Module
{
    private static final String[] f37109;
    private final Settings f37110;
    private final Value<Object2IntMap<class_1291>> f37111;
    @EventHandler
    private final Listener<c36575> f37112;
    
    public Potionspoof() {
        super(Category.Player, "potion-spoof", "Adds you potion effects.");
        this.f37110 = this.f38675.m34572();
        this.f37111 = this.f37110.addValue((Value<Object2IntMap<class_1291>>)new c38064.c38065().m38072("potions").m38075("Potions to add.").m38078(EnchantUtil.m35547()).m38087());
        this.f37112 = (Listener<c36575>)new Listener(this::m37113, new Predicate[0]);
    }
    
    private /* synthetic */ void m37113(final c36575 c36575) {
        for (final StatusEffect statusEffect : this.f37111.m33466().keySet()) {
            final int int1 = this.f37111.m33466().getInt((Object)statusEffect);
            if (int1 <= 0) {
                continue;
            }
            if (this.mc.player.hasStatusEffect(statusEffect)) {
                final StatusEffectInstance statusEffect2 = this.mc.player.getStatusEffect(statusEffect);
                ((c33716)statusEffect2).m33718(int1 - 1);
                if (statusEffect2.getDuration() >= 20) {
                    continue;
                }
                ((c33716)statusEffect2).m33717(20);
            }
            else {
                this.mc.player.addStatusEffect(new StatusEffectInstance(statusEffect, 20, int1 - 1));
            }
        }
    }
    
    static {
        f37109 = new String[] { "potion-spoof", "Adds you potion effects.", "potions", "Potions to add." };
    }
}
