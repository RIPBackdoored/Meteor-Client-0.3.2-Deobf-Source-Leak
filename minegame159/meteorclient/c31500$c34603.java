package minegame159.meteorclient;

import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import meteorclient.modules.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.ingame.*;

private class c34603 extends c31500.c37403
{
    private static final String[] f34604;
    private final Value<String> f34605;
    @EventHandler
    private final Listener<c31559> f34606;
    final /* synthetic */ Announcer f34607;
    
    public c34603(final Announcer f34607) {
        super(this.f34607 = f34607, "Open Container", "open-container-enabled", "Sends msg when you oopen containers.");
        this.f34605 = this.f37404.addValue((Value<Object>)new c36225.c36674().m36681("open-container-msg").m36684("Open container message.").m36687("I just opened {name}!").m36696());
        this.f34606 = new Listener(this::m34611, new Predicate[0]);
    }
    
    void m37406() {
    }
    
    void m37407() {
    }
    
    void m34608(final String s) {
        Announcer.m33177(this.f34607).player.sendChatMessage(this.f34605.m33466().replace("{name}", s));
    }
    
    private /* synthetic */ void m34611(final c31559 c31559) {
        if (c31559.f31560 instanceof ContainerScreen) {
            final String string = c31559.f31560.getTitle().getString();
            if (!string.isEmpty()) {
                this.m34608(string);
            }
        }
    }
    
    static {
        c34603.f34604 = new String[] { "Open Container", "open-container-enabled", "Sends msg when you oopen containers.", "open-container-msg", "Open container message.", "I just opened {name}!", "{name}" };
    }
}
