package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Antifire extends Module
{
    private static final String[] f38255;
    @EventHandler
    private Listener<c36575> f38256;
    
    public Antifire() {
        super(Category.Player, "anti-fire", "Removes fire.");
        this.f38256 = (Listener<c36575>)new Listener(this::m38257, new Predicate[0]);
    }
    
    private /* synthetic */ void m38257(final c36575 c36575) {
        this.mc.player.extinguish();
    }
    
    static {
        f38255 = new String[] { "anti-fire", "Removes fire." };
    }
}
