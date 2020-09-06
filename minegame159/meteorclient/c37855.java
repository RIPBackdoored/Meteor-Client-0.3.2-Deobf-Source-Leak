package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import net.minecraft.enchantment.*;
import java.util.function.*;
import java.util.*;
import meteorclient.util.*;

public class c37855 extends c39130
{
    private static final String[] f37856;
    private final Value<List<class_1887>> f37857;
    private final c31399 f37858;
    
    public c37855(final Value<List<class_1887>> f37857) {
        super("Select Enchantments", true);
        this.f37857 = f37857;
        (this.f37858 = new c31399("", 0.0)).m31416(true);
        this.f37858.f31401 = (p0 -> {
            this.clear();
            this.m37859();
            return;
        });
        this.m37859();
    }
    
    private void m37859() {
        this.add(this.f37858).m39587().m39583();
        this.m39132();
        final c36715 c36715 = this.add(new c36715()).m39595().m39632();
        final Consumer consumer = this::m37882;
        if (this.f37858.f31403.isEmpty()) {
            Registry.ENCHANTMENT.forEach(consumer);
        }
        else {
            final ArrayList<Pair> list = new ArrayList<Pair>();
            Registry.ENCHANTMENT.forEach(this::m37877);
            list.sort(Comparator.comparingInt((ToIntFunction<? super Object>)c37855::m37875));
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                consumer.accept(iterator.next().getLeft());
            }
        }
        if (c36715.m32007().size() > 0) {
            this.add(new c38091()).m39585();
        }
        final c36715 c36716 = this.add(new c36715()).m39595().m39632();
        for (final Enchantment enchantment : this.f37857.m33466()) {
            c36716.m31937(new c39081(enchantment.getName(1).asString()));
            c36716.m31937(new c36419()).m39632().f36420 = this::m37871;
            c36716.m36739();
        }
    }
    
    private void m37868() {
        final double f36732 = this.f39131.f36732;
        this.f37857.m33480();
        this.clear();
        this.m37859();
        this.f39131.m32005().m31962();
        this.f39131.m36792(0.0, f36732);
    }
    
    private /* synthetic */ void m37871(final Enchantment enchantment, final c36419 c36419) {
        if (this.f37857.m33466().remove(enchantment)) {
            this.m37868();
        }
    }
    
    private static /* synthetic */ int m37875(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private /* synthetic */ void m37877(final List list, final Enchantment enchantment) {
        final int m35551 = EnchantUtil.m35551(enchantment.getName(1).asString(), this.f37858.f31403);
        if (m35551 > 0) {
            list.add(new Pair((Object)enchantment, (Object)m35551));
        }
    }
    
    private /* synthetic */ void m37882(final c36715 c36715, final Enchantment enchantment) {
        if (this.f37857.m33466().contains(enchantment)) {
            return;
        }
        c36715.m31937(new c39081(enchantment.getName(1).asString()));
        c36715.m31937(new c35036()).m39632().f35037 = this::m37887;
        c36715.m36739();
    }
    
    private /* synthetic */ void m37887(final Enchantment enchantment, final c35036 c35036) {
        if (!this.f37857.m33466().contains(enchantment)) {
            this.f37857.m33466().add((class_1887)enchantment);
            this.m37868();
        }
    }
    
    private /* synthetic */ void m37891(final c31399 c31399) {
        this.clear();
        this.m37859();
    }
    
    static {
        f37856 = new String[] { "Select Enchantments", "" };
    }
}
