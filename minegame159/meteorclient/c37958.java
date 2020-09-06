package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import java.util.function.*;
import java.util.*;
import meteorclient.util.*;
import net.minecraft.item.*;

public class c37958 extends c39130
{
    private static final String[] f37959;
    private final Value<List<class_1792>> f37960;
    private final c31399 f37961;
    
    public c37958(final Value<List<class_1792>> f37960) {
        super("Select items", true);
        this.f37960 = f37960;
        (this.f37961 = new c31399("", 0.0)).m31416(true);
        this.f37961.f31401 = (p0 -> {
            this.clear();
            this.m37962();
            return;
        });
        this.m37962();
    }
    
    private void m37962() {
        this.add(this.f37961).m39587().m39583();
        this.m39132();
        final c36715 c36715 = this.add(new c36715()).m39595().m39632();
        final Consumer consumer = this::m37985;
        if (this.f37961.f31403.isEmpty()) {
            Registry.ITEM.forEach(consumer);
        }
        else {
            final ArrayList<Pair> list = new ArrayList<Pair>();
            Registry.ITEM.forEach(this::m37980);
            list.sort(Comparator.comparingInt((ToIntFunction<? super Object>)c37958::m37978));
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                consumer.accept(iterator.next().getLeft());
            }
        }
        if (c36715.m32007().size() > 0) {
            this.add(new c38091()).m39585();
        }
        final c36715 c36716 = this.add(new c36715()).m39595().m39632();
        for (final Item item : this.f37960.m33466()) {
            c36716.m31937(new c34625(item.getStackForRender()));
            c36716.m31937(new c36419()).m39632().f36420 = this::m37974;
            c36716.m36739();
        }
    }
    
    private void m37971() {
        final double f36732 = this.f39131.f36732;
        this.f37960.m33480();
        this.clear();
        this.m37962();
        this.f39131.m32005().m31962();
        this.f39131.m36792(0.0, f36732);
    }
    
    private /* synthetic */ void m37974(final Item item, final c36419 c36419) {
        if (this.f37960.m33466().remove(item)) {
            this.m37971();
        }
    }
    
    private static /* synthetic */ int m37978(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private /* synthetic */ void m37980(final List list, final Item item) {
        final int m35551 = EnchantUtil.m35551(item.getName().asFormattedString(), this.f37961.f31403);
        if (m35551 > 0) {
            list.add(new Pair((Object)item, (Object)m35551));
        }
    }
    
    private /* synthetic */ void m37985(final c36715 c36715, final Item item) {
        if (item == Items.AIR || this.f37960.m33466().contains(item)) {
            return;
        }
        c36715.m31937(new c34625(item.getStackForRender()));
        c36715.m31937(new c35036()).m39632().f35037 = this::m37990;
        c36715.m36739();
    }
    
    private /* synthetic */ void m37990(final Item item, final c35036 c35036) {
        if (!this.f37960.m33466().contains(item)) {
            this.f37960.m33466().add((class_1792)item);
            this.m37971();
        }
    }
    
    private /* synthetic */ void m37994(final c31399 c31399) {
        this.clear();
        this.m37962();
    }
    
    static {
        f37959 = new String[] { "Select items", "" };
    }
}
