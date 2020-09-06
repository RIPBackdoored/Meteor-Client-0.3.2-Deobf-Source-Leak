package minegame159.meteorclient;

import meteorclient.setting.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import net.minecraft.entity.effect.*;
import java.util.function.*;
import org.apache.commons.lang3.*;
import java.util.*;

public class c34391 extends c39130
{
    private static final String[] f34392;
    private final Value<Object2IntMap<class_1291>> f34393;
    private final c31399 f34394;
    
    public c34391(final Value<Object2IntMap<class_1291>> f34393) {
        super("Select Potions", true);
        this.f34393 = f34393;
        (this.f34394 = new c31399("", 200.0)).m31416(true);
        this.f34394.f31401 = (p0 -> {
            this.clear();
            this.m34395();
            return;
        });
        this.m34395();
    }
    
    private void m34395() {
        this.add(this.f34394).m39587().m39583();
        this.m39132();
        final ArrayList<StatusEffect> list = new ArrayList<StatusEffect>((Collection<? extends StatusEffect>)this.f34393.m33466().keySet());
        list.sort(Comparator.comparing((Function<? super Object, ? extends Comparable>)c34391::m34405));
        final c36715 c36715 = this.add(new c36715()).m39583().m39587().m39632();
        for (final StatusEffect statusEffect : list) {
            final String string = statusEffect.method_5560().asString();
            if (!StringUtils.containsIgnoreCase(string, this.f34394.f31403)) {
                continue;
            }
            c36715.m31937(new c39081(string));
            c36715.m31937(new c36453(this.f34393.m33466().getInt((Object)statusEffect), 50.0)).m39587().m39589().m39632().f36454 = this::m34401;
            c36715.m36739();
        }
    }
    
    private /* synthetic */ void m34401(final StatusEffect statusEffect, final c36453 c36453) {
        this.f34393.m33466().put((Object)statusEffect, c36453.f36455);
        this.f34393.m33480();
    }
    
    private static /* synthetic */ String m34405(final StatusEffect statusEffect) {
        return statusEffect.method_5560().asString();
    }
    
    private /* synthetic */ void m34407(final c31399 c31399) {
        this.clear();
        this.m34395();
    }
    
    static {
        f34392 = new String[] { "Select Potions", "" };
    }
}
