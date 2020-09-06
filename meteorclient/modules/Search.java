package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.world.dimension.*;
import me.zero.alpine.listener.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import it.unimi.dsi.fastutil.longs.*;
import java.util.function.*;
import net.minecraft.*;
import minegame159.meteorclient.*;
import meteorclient.util.*;
import net.minecraft.client.*;
import java.util.*;

public class Search extends Module
{
    private static final String[] f38098;
    private final Settings f38099;
    private final Settings f38100;
    private final Long2ObjectArrayMap<c34640.c34844> f38101;
    private final Value<List<class_2248>> f38102;
    private final Value<c37042> f38103;
    private final Value<Boolean> f38104;
    private final Value<c37042> f38105;
    private final c32900<c34640.c38708> f38106;
    private final LongList f38107;
    private final LongList f38108;
    private final class_2338.class_2339 f38109;
    private Vec3d f38110;
    private DimensionType f38111;
    @EventHandler
    private final Listener<c33296> f38112;
    @EventHandler
    private final Listener<c36575> f38113;
    @EventHandler
    private final Listener<c36846> f38114;
    private static final class_2338.class_2339 f38115;
    
    public Search() {
        super(Category.Render, "search", "Searches for specified blocks.");
        this.f38099 = this.f38675.m34572();
        this.f38100 = this.f38675.m34582("Tracers", "tracers", "Draw lines to the blocks.", false);
        this.f38101 = (Long2ObjectArrayMap<c34640.c34844>)new Long2ObjectArrayMap();
        this.f38102 = this.f38099.addValue((Value<List<class_2248>>)new c31769.c36992().m36999("blocks").m37002("Blocks to search for.").m37005(new ArrayList<class_2248>(0)).m37008(this::m38177).m37014());
        this.f38103 = this.f38099.addValue((Value<c37042>)new c33179.c33180().m33187("color").m33190("Color.").m33193(new c37042(0, 255, 200)).m33202());
        this.f38104 = this.f38099.addValue((Value<Boolean>)new c34427.c34657().m34664("full-block").m34667("Outlines are rendered as full blocks.").m34670(false).m34679());
        this.f38105 = this.f38100.addValue((Value<c37042>)new c33179.c33180().m33187("tracers-color").m33190("Tracers color.").m33193(new c37042(225, 225, 225)).m33202());
        this.f38106 = new c32900<c34640.c38708>(this::m38175);
        this.f38107 = (LongList)new LongArrayList();
        this.f38108 = (LongList)new LongArrayList();
        this.f38109 = new class_2338.class_2339();
        this.f38110 = new Vec3d(0.0, 0.0, 0.0);
        this.f38112 = (Listener<c33296>)new Listener(this::m38172, new Predicate[0]);
        this.f38113 = (Listener<c36575>)new Listener(this::m38143, new Predicate[0]);
        this.f38114 = (Listener<c36846>)new Listener(this::m38137, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        c31516.m31520();
        this.f38111 = this.mc.player.dimension;
        this.m38119();
    }
    
    @Override
    public void m35294() {
        c31516.m31522();
        final ObjectIterator iterator = this.f38101.values().iterator();
        while (((Iterator)iterator).hasNext()) {
            ((Iterator<c34640.c34844>)iterator).next().m34875();
        }
        this.f38101.clear();
    }
    
    private void m38119() {
        for (int viewDistance = this.mc.options.viewDistance, i = this.mc.player.chunkX - viewDistance; i <= this.mc.player.chunkX + viewDistance; ++i) {
            for (int j = this.mc.player.chunkZ - viewDistance; j <= this.mc.player.chunkZ + viewDistance; ++j) {
                if (this.mc.world.method_2935().isChunkLoaded(i, j)) {
                    this.m38124((Chunk)this.mc.world.method_8497(i, j), null);
                }
            }
        }
    }
    
    private void m38124(final Chunk chunk, final c33296 c33296) {
        c31516.m31524(this::m38162);
    }
    
    public void m38128(final BlockPos blockPos, final BlockState blockState) {
        c31516.m31524(this::m38149);
    }
    
    private void m38132(final int n, final int n2) {
        final long long1 = ChunkPos.toLong(n, n2);
        if (this.f38101.containsKey(long1) && !this.f38108.contains(long1)) {
            this.f38108.add(long1);
        }
    }
    
    private /* synthetic */ void m38137(final c36846 c36846) {
        this.f38110 = new Vec3d(0.0, 0.0, 1.0).rotateX(-(float)Math.toRadians(this.mc.cameraEntity.pitch)).rotateY(-(float)Math.toRadians(this.mc.cameraEntity.yaw)).add(this.mc.cameraEntity.getPos());
        synchronized (this.f38101) {
            this.f38107.clear();
            for (final long longValue : this.f38101.keySet()) {
                final c34640.c34844 c36847 = (c34640.c34844)this.f38101.get(longValue);
                if (c36847.m34865()) {
                    this.f38107.add(longValue);
                }
                else {
                    c36847.m34871(c36846);
                }
            }
            final LongListIterator iterator2 = this.f38107.iterator();
            while (((Iterator)iterator2).hasNext()) {
                this.f38101.remove((long)((Iterator<Long>)iterator2).next());
            }
        }
    }
    
    private /* synthetic */ void m38143(final c36575 c36575) {
        if (this.f38111 != this.mc.player.dimension) {
            synchronized (this.f38101) {
                final ObjectIterator iterator = this.f38101.values().iterator();
                while (((Iterator)iterator).hasNext()) {
                    ((Iterator<c34640.c34844>)iterator).next().m34875();
                }
                this.f38101.clear();
            }
        }
        synchronized (this.f38101) {
            final LongListIterator iterator2 = this.f38108.iterator();
            while (((Iterator)iterator2).hasNext()) {
                final c34640.c34844 c36576 = (c34640.c34844)this.f38101.get((long)((Iterator<Long>)iterator2).next());
                if (c36576 != null) {
                    c36576.m34868();
                }
            }
            this.f38108.clear();
        }
        this.f38111 = this.mc.player.dimension;
    }
    
    private /* synthetic */ void m38149(final BlockPos blockPos, final BlockState blockState) {
        final int n = blockPos.getX() >> 4;
        final int n2 = blockPos.getZ() >> 4;
        final long long1 = ChunkPos.toLong(n, n2);
        synchronized (this.f38101) {
            if (this.f38102.m33466().contains(blockState.getBlock())) {
                ((c34640.c34844)this.f38101.computeIfAbsent(long1, (LongFunction)this::m38157)).m34849(blockPos, true);
            }
            else {
                final c34640.c34844 c34844 = (c34640.c34844)this.f38101.get(long1);
                if (c34844 != null) {
                    c34844.m34855(blockPos);
                }
            }
        }
    }
    
    private /* synthetic */ c34640.c34844 m38157(final int n, final int n2, final long n3) {
        return new c34640.c34844(this, n, n2);
    }
    
    private /* synthetic */ void m38162(final Chunk chunk, final c33296 c33296) {
        final c34640.c34844 c33297 = new c34640.c34844(this, chunk.getPos().x, chunk.getPos().z);
        for (int i = chunk.getPos().getStartX(); i <= chunk.getPos().getEndX(); ++i) {
            for (int j = chunk.getPos().getStartZ(); j <= chunk.getPos().getEndZ(); ++j) {
                for (int value = chunk.getHeightmap(class_2902.class_2903.field_13202).get(i - chunk.getPos().getStartX(), j - chunk.getPos().getStartZ()), k = 0; k < value; ++k) {
                    this.f38109.method_10103(i, k, j);
                    if (this.f38102.m33466().contains(chunk.getBlockState((BlockPos)this.f38109).getBlock())) {
                        c33297.m34849((BlockPos)this.f38109, false);
                    }
                }
            }
        }
        synchronized (this.f38101) {
            if (c34640.c34844.m34878(c33297).size() > 0) {
                this.f38101.put(chunk.getPos().toLong(), (Object)c33297);
            }
        }
        if (c33296 != null) {
            c34429.m34515(c33296);
        }
    }
    
    private /* bridge */ void m38172(final c33296 c33296) {
        this.m38124((Chunk)c33296.f33297, c33296);
    }
    
    private /* synthetic */ c34640.c38708 m38175() {
        return new c34640.c38708(this, (c34640.c34641)null);
    }
    
    private /* synthetic */ void m38177(final List list) {
        if (EnchantUtil.m35613() && this.m35315()) {
            synchronized (this.f38101) {
                final ObjectIterator iterator = this.f38101.values().iterator();
                while (((Iterator)iterator).hasNext()) {
                    ((Iterator<c34640.c34844>)iterator).next().m34875();
                }
                this.f38101.clear();
            }
            this.m38119();
        }
    }
    
    static /* synthetic */ c32900 m38181(final Search search) {
        return search.f38106;
    }
    
    static /* bridge */ void m38183(final Search search, final int n, final int n2) {
        search.m38132(n, n2);
    }
    
    static /* synthetic */ MinecraftClient m38187(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38189(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38191(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38193(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38195(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38197(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ class_2338.class_2339 m38199() {
        return Search.f38115;
    }
    
    static /* synthetic */ MinecraftClient m38200(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ Value m38202(final Search search) {
        return search.f38104;
    }
    
    static /* synthetic */ MinecraftClient m38204(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ class_2338.class_2339 m38206(final Search search) {
        return search.f38109;
    }
    
    static /* synthetic */ Value m38208(final Search search) {
        return search.f38103;
    }
    
    static /* synthetic */ Settings m38210(final Search search) {
        return search.f38100;
    }
    
    static /* synthetic */ Vec3d m38212(final Search search) {
        return search.f38110;
    }
    
    static /* synthetic */ MinecraftClient m38214(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38216(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ MinecraftClient m38218(final Search search) {
        return search.mc;
    }
    
    static /* synthetic */ Value m38220(final Search search) {
        return search.f38105;
    }
    
    static {
        f38098 = new String[] { "search", "Searches for specified blocks.", "Tracers", "tracers", "Draw lines to the blocks.", "blocks", "Blocks to search for.", "color", "Color.", "full-block", "Outlines are rendered as full blocks.", "tracers-color", "Tracers color." };
        f38115 = new class_2338.class_2339();
    }
}
