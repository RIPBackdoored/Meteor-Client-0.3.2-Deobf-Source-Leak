package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.*;
import minegame159.meteorclient.*;

public class Antihunger extends Module
{
    private static final String[] f33375;
    private final Settings f33376;
    private final Value<Boolean> f33377;
    private final Value<Boolean> f33378;
    private boolean f33379;
    private boolean f33380;
    private boolean f33381;
    @EventHandler
    private final Listener<c32410> f33382;
    @EventHandler
    private final Listener<c36575> f33383;
    
    public Antihunger() {
        super(Category.Player, "anti-hunger", "Reduces hunger consumption.");
        this.f33376 = this.f38675.m34572();
        this.f33377 = this.f33376.addValue((Value<Boolean>)new c34427.c34657().m34664("sprint").m34667("Spoof's sprinting packets.").m34670(true).m34679());
        this.f33378 = this.f33376.addValue((Value<Boolean>)new c34427.c34657().m34664("on-ground").m34667("Spoof's onGround flag.").m34670(true).m34679());
        this.f33382 = (Listener<c32410>)new Listener(this::m33387, new Predicate[0]);
        this.f33383 = (Listener<c36575>)new Listener(this::m33384, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f33379 = this.mc.player.onGround;
        this.f33380 = true;
    }
    
    private /* synthetic */ void m33384(final c36575 c36575) {
        if (this.mc.player.onGround && !this.f33379 && !this.f33380) {
            this.f33380 = true;
        }
        if (this.mc.player.onGround && this.f33380 && this.f33378.m33466()) {
            this.f33381 = true;
            this.mc.getNetworkHandler().sendPacket((Packet)new PlayerMoveC2SPacket(true));
            this.f33381 = false;
            this.f33380 = false;
        }
        this.f33379 = this.mc.player.onGround;
    }
    
    private /* synthetic */ void m33387(final c32410 c32410) {
        if (this.f33381) {
            return;
        }
        if (c32410.f32411 instanceof ClientCommandC2SPacket && this.f33377.m33466()) {
            final class_2848.class_2849 mode = ((ClientCommandC2SPacket)c32410.f32411).getMode();
            if (mode == class_2848.class_2849.field_12981 || mode == class_2848.class_2849.field_12985) {
                c32410.m32674();
            }
        }
        if (c32410.f32411 instanceof PlayerMoveC2SPacket && this.f33378.m33466() && this.mc.player.onGround && this.mc.player.fallDistance <= 0.0 && !this.mc.interactionManager.isBreakingBlock()) {
            ((c34907)c32410.f32411).m34908(false);
        }
    }
    
    static {
        f33375 = new String[] { "anti-hunger", "Reduces hunger consumption.", "sprint", "Spoof's sprinting packets.", "on-ground", "Spoof's onGround flag." };
    }
}
