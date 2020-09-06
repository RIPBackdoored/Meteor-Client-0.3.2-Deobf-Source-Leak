package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.world.dimension.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import java.util.*;
import net.minecraft.client.*;

public class Breadcrumbs extends Module
{
    private static final String[] f33109;
    private final Settings f33110;
    private final Value<c37042> f33111;
    private final Value<Integer> f33112;
    private final Value<Double> f33113;
    private final c32900<c33098.c38568> f33114;
    private final Queue<c33098.c38568> f33115;
    private c33098.c38568 f33116;
    private DimensionType f33117;
    @EventHandler
    private final Listener<c36575> f33118;
    @EventHandler
    private final Listener<c36846> f33119;
    
    public Breadcrumbs() {
        super(Category.Render, "breadcrumbs", "Displays a line where you walked.");
        this.f33110 = this.f38675.m34572();
        this.f33111 = this.f33110.addValue((Value<c37042>)new c33179.c33180().m33187("color").m33190("Color of the line.").m33193(new c37042(225, 25, 25)).m33202());
        this.f33112 = this.f33110.addValue((Value<Integer>)new c32369.c32370().m32381("max-sections").m32384("Maximum number of sections.").m32387(1000).m32396(0).m32405(5000).m32408());
        this.f33113 = this.f33110.addValue((Value<Double>)new c37033.c38947().m38959("section-length").m38962("Section length, 1 is equal to 1 block.").m38965(0.5).m38974(0.0).m38980(0.0).m38983(1.0).m38988());
        this.f33114 = new c32900<c33098.c38568>(this::m33133);
        this.f33115 = new ArrayDeque<c33098.c38568>();
        this.f33118 = (Listener<c36575>)new Listener(this::m33129, new Predicate[0]);
        this.f33119 = (Listener<c36846>)new Listener(this::m33125, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        (this.f33116 = this.f33114.m32903()).m38576();
        this.f33117 = this.mc.player.dimension;
    }
    
    @Override
    public void m35294() {
        final Iterator<c33098.c38568> iterator = this.f33115.iterator();
        while (iterator.hasNext()) {
            this.f33114.m32905(iterator.next());
        }
        this.f33115.clear();
    }
    
    private boolean m33120(final double n, final double n2, final double n3) {
        return Math.abs(this.mc.player.x - n) >= this.f33113.m33466() || Math.abs(this.mc.player.y - n2) >= this.f33113.m33466() || Math.abs(this.mc.player.z - n3) >= this.f33113.m33466();
    }
    
    private /* synthetic */ void m33125(final c36846 c36846) {
        final Iterator<c33098.c38568> iterator = this.f33115.iterator();
        while (iterator.hasNext()) {
            iterator.next().m38580();
        }
    }
    
    private /* synthetic */ void m33129(final c36575 c36575) {
        if (this.f33117 != this.mc.player.dimension) {
            final Iterator<c33098.c38568> iterator = this.f33115.iterator();
            while (iterator.hasNext()) {
                this.f33114.m32905(iterator.next());
            }
            this.f33115.clear();
        }
        if (this.m33120(this.f33116.f38569, this.f33116.f38570, this.f33116.f38571)) {
            this.f33116.m38578();
            if (this.f33115.size() >= this.f33112.m33466()) {
                this.f33114.m32905(this.f33115.poll());
            }
            this.f33115.add(this.f33116);
            (this.f33116 = this.f33114.m32903()).m38576();
        }
        this.f33117 = this.mc.player.dimension;
    }
    
    private /* synthetic */ c33098.c38568 m33133() {
        return new c33098.c38568(this, (c33098.c33099)null);
    }
    
    static /* synthetic */ MinecraftClient m33135(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.mc;
    }
    
    static /* synthetic */ MinecraftClient m33137(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.mc;
    }
    
    static /* synthetic */ MinecraftClient m33139(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.mc;
    }
    
    static /* synthetic */ MinecraftClient m33141(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.mc;
    }
    
    static /* synthetic */ MinecraftClient m33143(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.mc;
    }
    
    static /* synthetic */ MinecraftClient m33145(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.mc;
    }
    
    static /* synthetic */ Value m33147(final Breadcrumbs breadcrumbs) {
        return breadcrumbs.f33111;
    }
    
    static {
        f33109 = new String[] { "breadcrumbs", "Displays a line where you walked.", "color", "Color of the line.", "max-sections", "Maximum number of sections.", "section-length", "Section length, 1 is equal to 1 block." };
    }
}
