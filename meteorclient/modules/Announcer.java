package meteorclient.modules;

import meteorclient.*;
import java.util.function.*;
import minegame159.meteorclient.*;
import me.zero.alpine.listener.*;
import net.minecraft.client.*;

public class Announcer extends Module
{
    private static final String[] f33149;
    private static final double f33150 = 0.05;
    private final c31500.c37403[] f33151;
    @EventHandler
    private final Listener<c36575> f33152;
    
    public Announcer() {
        super(Category.Misc, "announcer", "Announces events into chat.");
        this.f33151 = new c31500.c37403[] { (c31500.c37403)new c31500.c33720(this), (c31500.c37403)new c31500.c32355(this), (c31500.c37403)new c31500.c31501(this), (c31500.c37403)new c31500.c39115(this), (c31500.c37403)new c31500.c33737(this), (c31500.c37403)new c31500.c34603(this) };
        this.f33152 = (Listener<c36575>)new Listener(this::m33153, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        for (final c31500.c37403 c37403 : this.f33151) {
            if (c37403.m37408()) {
                MeteorClient.eventBus.subscribe((Listenable)c37403);
                c37403.m37406();
            }
        }
    }
    
    @Override
    public void m35294() {
        for (final c31500.c37403 c37403 : this.f33151) {
            if (c37403.m37408()) {
                MeteorClient.eventBus.unsubscribe((Listenable)c37403);
            }
        }
    }
    
    private /* synthetic */ void m33153(final c36575 c36575) {
        for (final c31500.c37403 c36576 : this.f33151) {
            if (c36576.m37408()) {
                c36576.m37407();
            }
        }
    }
    
    static /* synthetic */ MinecraftClient m33157(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33159(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33161(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33163(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33165(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33167(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33169(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33171(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33173(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33175(final Announcer announcer) {
        return announcer.mc;
    }
    
    static /* synthetic */ MinecraftClient m33177(final Announcer announcer) {
        return announcer.mc;
    }
    
    static {
        f33149 = new String[] { "announcer", "Announces events into chat." };
    }
}
