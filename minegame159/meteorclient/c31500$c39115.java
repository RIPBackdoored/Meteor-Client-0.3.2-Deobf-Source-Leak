package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.item.*;
import me.zero.alpine.listener.*;
import meteorclient.modules.*;
import java.util.function.*;

private class c39115 extends c31500.c37403
{
    private static final String[] f39116;
    private final Value<String> f39117;
    private Item f39118;
    private int f39119;
    private double f39120;
    @EventHandler
    private final Listener<c32191> f39121;
    final /* synthetic */ Announcer f39122;
    
    c39115(final Announcer f39122) {
        super(this.f39122 = f39122, "Drop Items", "drop-items-enabled", "Send msg how much items you dropped.");
        this.f39117 = this.f37404.addValue((Value<Object>)new c36225.c36674().m36681("drop-items-msg").m36684("Drop items message.").m36687("I just dropped {count} {item}!").m36696());
        this.f39121 = new Listener(this::m39127, new Predicate[0]);
    }
    
    void m37406() {
        this.f39118 = null;
        this.f39119 = 0;
        this.f39120 = 0.0;
    }
    
    void m37407() {
        if (this.f39120 >= 1.0) {
            this.m39125();
        }
        else {
            this.f39120 += 0.05;
        }
    }
    
    void m39125() {
        if (this.f39119 > 0) {
            Announcer.m33173(this.f39122).player.sendChatMessage(this.f39117.m33466().replace("{count}", Integer.toString(this.f39119)).replace("{item}", this.f39118.getName().getString()));
            this.f39119 = 0;
        }
    }
    
    private /* synthetic */ void m39127(final c32191 c32191) {
        if (this.f39118 != null && this.f39118 != c32191.f32192.getItem()) {
            this.m39125();
        }
        this.f39118 = c32191.f32192.getItem();
        this.f39119 += c32191.f32192.getCount();
        this.f39120 = 0.0;
    }
    
    static {
        c39115.f39116 = new String[] { "Drop Items", "drop-items-enabled", "Send msg how much items you dropped.", "drop-items-msg", "Drop items message.", "I just dropped {count} {item}!", "{count}", "{item}" };
    }
}
