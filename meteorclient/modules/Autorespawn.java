package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.*;

public class Autorespawn extends Module
{
    private static final String[] f31554;
    @EventHandler
    private Listener<c31559> f31555;
    
    public Autorespawn() {
        super(Category.Player, "auto-respawn", "Automatically respawns.");
        this.f31555 = (Listener<c31559>)new Listener(this::m31556, new Predicate[0]);
    }
    
    private /* synthetic */ void m31556(final c31559 c31559) {
        if (!(c31559.f31560 instanceof DeathScreen)) {
            return;
        }
        this.mc.player.requestRespawn();
        c31559.m32674();
    }
    
    static {
        f31554 = new String[] { "auto-respawn", "Automatically respawns." };
    }
}
