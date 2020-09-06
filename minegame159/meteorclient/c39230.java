package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import java.util.function.*;
import java.util.*;
import meteorclient.util.*;
import net.minecraft.block.*;

public class c39230 extends c39130
{
    private static final String[] f39231;
    private final Value<List<class_2248>> f39232;
    private final c31399 f39233;
    
    public c39230(final Value<List<class_2248>> f39232) {
        super("Select blocks", true);
        this.f39232 = f39232;
        (this.f39233 = new c31399("", 0.0)).m31416(true);
        this.f39233.f31401 = (p0 -> {
            this.clear();
            this.m39234();
            return;
        });
        this.m39234();
    }
    
    private void m39234() {
        this.add(this.f39233).m39587().m39583();
        this.m39132();
        final c36715 c36715 = this.add(new c36715()).m39595().m39632();
        final Consumer consumer = this::m39257;
        if (this.f39233.f31403.isEmpty()) {
            Registry.BLOCK.forEach(consumer);
        }
        else {
            final ArrayList<Pair> list = new ArrayList<Pair>();
            Registry.BLOCK.forEach(this::m39252);
            list.sort(Comparator.comparingInt((ToIntFunction<? super Object>)c39230::m39250));
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                consumer.accept(iterator.next().getLeft());
            }
        }
        if (c36715.m32007().size() > 0) {
            this.add(new c38091()).m39585();
        }
        final c36715 c36716 = this.add(new c36715()).m39595().m39632();
        for (final Block block : this.f39232.m33466()) {
            c36716.m31937(new c34625(block.asItem().getStackForRender(), block.getName().asString()));
            c36716.m31937(new c36419()).m39632().f36420 = this::m39246;
            c36716.m36739();
        }
    }
    
    private void m39243() {
        final double f36732 = this.f39131.f36732;
        this.f39232.m33480();
        this.clear();
        this.m39234();
        this.f39131.m32005().m31962();
        this.f39131.m36792(0.0, f36732);
    }
    
    private /* synthetic */ void m39246(final Block block, final c36419 c36419) {
        if (this.f39232.m33466().remove(block)) {
            this.m39243();
        }
    }
    
    private static /* synthetic */ int m39250(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private /* synthetic */ void m39252(final List list, final Block block) {
        final int m35551 = EnchantUtil.m35551(block.getName().asFormattedString(), this.f39233.f31403);
        if (m35551 > 0) {
            list.add(new Pair((Object)block, (Object)m35551));
        }
    }
    
    private /* synthetic */ void m39257(final c36715 c36715, final Block block) {
        if (block == Blocks.field_10124 || this.f39232.m33466().contains(block)) {
            return;
        }
        c36715.m31937(new c34625(block.asItem().getStackForRender(), block.getName().asString()));
        c36715.m31937(new c35036()).m39632().f35037 = this::m39262;
        c36715.m36739();
    }
    
    private /* synthetic */ void m39262(final Block block, final c35036 c35036) {
        if (!this.f39232.m33466().contains(block)) {
            this.f39232.m33466().add((class_2248)block);
            this.m39243();
        }
    }
    
    private /* synthetic */ void m39266(final c31399 c31399) {
        this.clear();
        this.m39234();
    }
    
    static {
        f39231 = new String[] { "Select blocks", "" };
    }
}
