package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.client.network.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.*;
import minegame159.meteorclient.*;

public class Autoreconnect extends Module
{
    private static final String[] f33524;
    private final Settings f33525;
    private final Value<Double> f33526;
    private ServerInfo f33527;
    @EventHandler
    private Listener<c31559> f33528;
    
    public Autoreconnect() {
        super(Category.Misc, "auto-reconnect", "Automatically reconnects when kicked from server.");
        this.f33525 = this.f38675.m34572();
        this.f33526 = this.f33525.addValue((Value<Double>)new c37033.c38947().m38959("time").m38962("Time to wait before connecting.").m38965(2.0).m38974(0.0).m38988());
        this.f33528 = (Listener<c31559>)new Listener(this::m33529, new Predicate[0]);
        MeteorClient.eventBus.subscribe(new Listener(this::m33532, new Predicate[0]));
    }
    
    private /* synthetic */ void m33529(final c31559 c31559) {
        if (this.f33527 == null) {
            return;
        }
        if (!(c31559.f31560 instanceof DisconnectedScreen)) {
            return;
        }
        if (c31559.f31560 instanceof c33523.c39534) {
            return;
        }
        this.mc.openScreen((Screen)new c33523.c39534(this, (DisconnectedScreen)c31559.f31560));
        c31559.m32674();
    }
    
    private /* synthetic */ void m33532(final c33675 c33675) {
        this.f33527 = (this.mc.isInSingleplayer() ? null : this.mc.getCurrentServerEntry());
    }
    
    static /* synthetic */ Value m33535(final Autoreconnect autoreconnect) {
        return autoreconnect.f33526;
    }
    
    static /* synthetic */ ServerInfo m33537(final Autoreconnect autoreconnect) {
        return autoreconnect.f33527;
    }
    
    static {
        f33524 = new String[] { "auto-reconnect", "Automatically reconnects when kicked from server.", "time", "Time to wait before connecting." };
    }
}
