package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import minegame159.meteorclient.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.block.*;

public class Holeesp extends Module
{
    private static final String[] f35345;
    private final Settings f35346;
    private final Settings f35347;
    private final Value<Integer> f35348;
    private final Value<Integer> f35349;
    private final Value<Boolean> f35350;
    private final Value<Integer> f35351;
    private final Value<c37042> f35352;
    private final Value<c37042> f35353;
    private final Value<c37042> f35354;
    private final c32900<c33408.c39179> f35355;
    private final class_2338.class_2339 f35356;
    private final List<c33408.c39179> f35357;
    @EventHandler
    private Listener<c36575> f35358;
    @EventHandler
    private final Listener<c36846> f35359;
    
    public Holeesp() {
        super(Category.Render, "hole-esp", "Displays holes that you can be in so you don't take explosion damage.");
        this.f35346 = this.f38675.m34572();
        this.f35347 = this.f38675.m34588("Colors");
        this.f35348 = this.f35346.addValue((Value<Integer>)new c32369.c32370().m32381("horizontal-radius").m32384("Horizontal radius in which to search for holes.").m32387(10).m32396(0).m32405(32).m32408());
        this.f35349 = this.f35346.addValue((Value<Integer>)new c32369.c32370().m32381("vertical-radius").m32384("Vertical radius in which to search for holes.").m32387(10).m32396(0).m32405(32).m32408());
        this.f35350 = this.f35346.addValue((Value<Boolean>)new c34427.c34657().m34664("render-box").m34667("Renders box instead of a quad.").m34670(false).m34679());
        this.f35351 = this.f35346.addValue((Value<Integer>)new c32369.c32370().m32381("hole-height").m32384("Minimum hole height required to be rendered.").m32387(3).m32396(1).m32408());
        this.f35352 = this.f35347.addValue((Value<c37042>)new c33179.c33180().m33187("all-bedrock").m33190("All blocks are bedrock.").m33193(new c37042(25, 225, 25)).m33202());
        this.f35353 = this.f35347.addValue((Value<c37042>)new c33179.c33180().m33187("some-obsidian").m33190("Some blocks are obsidian.").m33193(new c37042(225, 145, 25)).m33202());
        this.f35354 = this.f35347.addValue((Value<c37042>)new c33179.c33180().m33187("all-obsidian").m33190("All blocks are obsidian.").m33193(new c37042(225, 25, 25)).m33202());
        this.f35355 = new c32900<c33408.c39179>(c33408::m35388);
        this.f35356 = new class_2338.class_2339();
        this.f35357 = new ArrayList<c33408.c39179>();
        this.f35358 = (Listener<c36575>)new Listener(this::m35375, new Predicate[0]);
        this.f35359 = (Listener<c36846>)new Listener(this::m35368, new Predicate[0]);
    }
    
    private boolean m35360() {
        if (this.mc.world.getBlockState((BlockPos)this.f35356).getBlock() != Blocks.field_10124) {
            return false;
        }
        for (int i = 0; i < this.f35351.m33466() - 1; ++i) {
            if (this.mc.world.getBlockState((BlockPos)this.m35363(0, 1, 0)).getBlock() != Blocks.field_10124) {
                return false;
            }
        }
        this.m35363(0, -this.f35351.m33466() + 1, 0);
        return true;
    }
    
    private class_2338.class_2339 m35363(final int n, final int n2, final int n3) {
        this.f35356.method_20787(this.f35356.getX() + n);
        this.f35356.method_10099(this.f35356.getY() + n2);
        this.f35356.method_20788(this.f35356.getZ() + n3);
        return this.f35356;
    }
    
    private /* synthetic */ void m35368(final c36846 c36846) {
        for (final c33408.c39179 c36847 : this.f35357) {
            final int x = c36847.f39180.getX();
            final int y = c36847.f39180.getY();
            final int z = c36847.f39180.getZ();
            if (this.f35350.m33466()) {
                c39337.m39461(x, y - 1, z, c36847.f39181, null);
                c39337.m39435(x, y - 1, z, c36847.f39182, null);
            }
            else {
                c39337.m39484(x, y, z, c36847.f39181, c36847.f39182);
            }
        }
    }
    
    private /* synthetic */ void m35375(final c36575 c36575) {
        final Iterator<c33408.c39179> iterator = this.f35357.iterator();
        while (iterator.hasNext()) {
            this.f35355.m32905(iterator.next());
        }
        this.f35357.clear();
        for (int i = (int)this.mc.player.x - this.f35348.m33466(); i <= (int)this.mc.player.x + this.f35348.m33466(); ++i) {
            for (int j = (int)this.mc.player.y - this.f35349.m33466(); j <= (int)this.mc.player.y + this.f35349.m33466(); ++j) {
                for (int k = (int)this.mc.player.z - this.f35348.m33466(); k <= (int)this.mc.player.z + this.f35348.m33466(); ++k) {
                    this.f35356.method_10103(i, j, k);
                    if (this.m35360()) {
                        final Block block = this.mc.world.getBlockState((BlockPos)this.m35363(0, -1, 0)).getBlock();
                        if (block == Blocks.field_9987 || block == Blocks.field_10540) {
                            final Block block2 = this.mc.world.getBlockState((BlockPos)this.m35363(0, 1, 1)).getBlock();
                            if (block2 == Blocks.field_9987 || block2 == Blocks.field_10540) {
                                final Block block3 = this.mc.world.getBlockState((BlockPos)this.m35363(0, 0, -2)).getBlock();
                                if (block3 == Blocks.field_9987 || block3 == Blocks.field_10540) {
                                    final Block block4 = this.mc.world.getBlockState((BlockPos)this.m35363(1, 0, 1)).getBlock();
                                    if (block4 == Blocks.field_9987 || block4 == Blocks.field_10540) {
                                        final Block block5 = this.mc.world.getBlockState((BlockPos)this.m35363(-2, 0, 0)).getBlock();
                                        if (block5 == Blocks.field_9987 || block5 == Blocks.field_10540) {
                                            this.m35363(1, 0, 0);
                                            if (block == Blocks.field_9987 && block2 == Blocks.field_9987 && block3 == Blocks.field_9987 && block4 == Blocks.field_9987 && block5 == Blocks.field_9987) {
                                                this.f35357.add(this.f35355.m32903().m39183((BlockPos)this.f35356, (c37042)this.f35352.m33466()));
                                            }
                                            else {
                                                int n = 0;
                                                if (block == Blocks.field_10540) {
                                                    ++n;
                                                }
                                                if (block2 == Blocks.field_10540) {
                                                    ++n;
                                                }
                                                if (block3 == Blocks.field_10540) {
                                                    ++n;
                                                }
                                                if (block4 == Blocks.field_10540) {
                                                    ++n;
                                                }
                                                if (block5 == Blocks.field_10540) {
                                                    ++n;
                                                }
                                                if (n == 5) {
                                                    this.f35357.add(this.f35355.m32903().m39183((BlockPos)this.f35356, (c37042)this.f35354.m33466()));
                                                }
                                                else {
                                                    this.f35357.add(this.f35355.m32903().m39183((BlockPos)this.f35356, (c37042)this.f35353.m33466()));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static /* synthetic */ c33408.c39179 m35388() {
        return new c33408.c39179((c33408.c33409)null);
    }
    
    static {
        f35345 = new String[] { "hole-esp", "Displays holes that you can be in so you don't take explosion damage.", "Colors", "horizontal-radius", "Horizontal radius in which to search for holes.", "vertical-radius", "Vertical radius in which to search for holes.", "render-box", "Renders box instead of a quad.", "hole-height", "Minimum hole height required to be rendered.", "all-bedrock", "All blocks are bedrock.", "some-obsidian", "Some blocks are obsidian.", "all-obsidian", "All blocks are obsidian." };
    }
}
