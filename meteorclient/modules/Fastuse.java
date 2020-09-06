package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import minegame159.meteorclient.*;

public class Fastuse extends Module
{
    private static final String[] f38662;
    @EventHandler
    private Listener<c36575> f38663;
    
    public Fastuse() {
        super(Category.Player, "fast-use", "Fast item use.");
        this.f38663 = (Listener<c36575>)new Listener(this::m38664, new Predicate[0]);
    }
    
    private /* synthetic */ void m38664(final c36575 c36575) {
        ((c37135)this.mc).m37138(0);
    }
    
    static {
        f38662 = new String[] { "fast-use", "Fast item use." };
    }
}
