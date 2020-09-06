package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.block.*;
import me.zero.alpine.listener.*;
import meteorclient.modules.*;
import java.util.function.*;

private class c31501 extends c31500.c37403
{
    private static final String[] f31502;
    private final Value<String> f31503;
    private Block f31504;
    private int f31505;
    private double f31506;
    @EventHandler
    private final Listener<c34622> f31507;
    final /* synthetic */ Announcer f31508;
    
    c31501(final Announcer f31508) {
        super(this.f31508 = f31508, "Placing", "placing-enabled", "Send msg how much blocks you placed.");
        this.f31503 = this.f37404.addValue((Value<Object>)new c36225.c36674().m36681("placing-msg").m36684("Placing message.").m36687("I just placed {count} {block}!").m36696());
        this.f31507 = new Listener(this::m31511, new Predicate[0]);
    }
    
    void m37406() {
        this.f31504 = null;
        this.f31505 = 0;
        this.f31506 = 0.0;
    }
    
    void m37407() {
        if (this.f31506 >= 2.0) {
            this.m31509();
        }
        else {
            this.f31506 += 0.05;
        }
    }
    
    void m31509() {
        if (this.f31505 > 0) {
            Announcer.m33171(this.f31508).player.sendChatMessage(this.f31503.m33466().replace("{count}", Integer.toString(this.f31505)).replace("{block}", this.f31504.getName().getString()));
            this.f31505 = 0;
        }
    }
    
    private /* bridge */ void m31511(final c34622 c34622) {
        if (this.f31504 != null && this.f31504 != c34622.f34624) {
            this.m31509();
        }
        this.f31504 = c34622.f34624;
        ++this.f31505;
        this.f31506 = 0.0;
    }
    
    static {
        c31501.f31502 = new String[] { "Placing", "placing-enabled", "Send msg how much blocks you placed.", "placing-msg", "Placing message.", "I just placed {count} {block}!", "{count}", "{block}" };
    }
}
