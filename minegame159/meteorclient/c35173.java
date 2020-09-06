package minegame159.meteorclient;

import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import java.util.function.*;
import org.apache.commons.lang3.*;
import java.util.*;
import meteorclient.setting.*;

public class c35173 extends c39130
{
    private static final String[] f35174;
    private final c36576 f35175;
    private final c31399 f35176;
    
    public c35173(final c36576 f35175) {
        super("Select Packets", true);
        this.f35175 = f35175;
        (this.f35176 = new c31399("", 200.0)).m31416(true);
        this.f35176.f31401 = (p0 -> {
            this.clear();
            this.m35177();
            return;
        });
        this.m35177();
    }
    
    private void m35177() {
        this.add(this.f35176).m39587().m39583();
        this.m39132();
        final ArrayList<Class<? extends class_2596<?>>> list = new ArrayList<Class<? extends class_2596<?>>>((Collection<? extends Class<? extends class_2596<?>>>)((Value<Object2BooleanMap>)this.f35175).m33466().keySet());
        list.sort(Comparator.comparing((Function<? super Object, ? extends Comparable>)c34333::m34339));
        final c36715 c36715 = this.add(new c36715()).m39583().m39587().m39595().m39632();
        this.add(new c38091()).m39585();
        final c36715 c36716 = this.add(new c36715()).m39583().m39587().m39595().m39632();
        for (final Class<? extends class_2596<?>> clazz : list) {
            final String m34339 = c34333.m34339(clazz);
            if (!StringUtils.containsIgnoreCase(m34339, this.f35176.f31403)) {
                continue;
            }
            if (((Value<Object2BooleanMap>)this.f35175).m33466().getBoolean((Object)clazz)) {
                c36716.m31937(new c39081(m34339));
                c36716.m31937(new c36419()).m39632().f36420 = (p1 -> {
                    ((Value<Object2BooleanMap>)this.f35175).m33466().put((Object)clazz, false);
                    this.f35175.m33480();
                    this.clear();
                    this.m35177();
                    return;
                });
                c36716.m36739();
            }
            else {
                c36715.m31937(new c39081(m34339));
                c36715.m31937(new c35036()).m39632().f35037 = (p1 -> {
                    ((Value<Object2BooleanMap>)this.f35175).m33466().put((Object)clazz, true);
                    this.f35175.m33480();
                    this.clear();
                    this.m35177();
                    return;
                });
                c36715.m36739();
            }
        }
    }
    
    private /* synthetic */ void m35184(final Class clazz, final c35036 c35036) {
        ((Value<Object2BooleanMap>)this.f35175).m33466().put((Object)clazz, true);
        this.f35175.m33480();
        this.clear();
        this.m35177();
    }
    
    private /* synthetic */ void m35188(final Class clazz, final c36419 c36419) {
        ((Value<Object2BooleanMap>)this.f35175).m33466().put((Object)clazz, false);
        this.f35175.m33480();
        this.clear();
        this.m35177();
    }
    
    private /* synthetic */ void m35192(final c31399 c31399) {
        this.clear();
        this.m35177();
    }
    
    static {
        f35174 = new String[] { "Select Packets", "" };
    }
}
