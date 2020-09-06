package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Antiweather extends Module
{
    private static final String[] f37120;
    @EventHandler
    private Listener<c36575> f37121;
    
    public Antiweather() {
        super(Category.Misc, "anti-weather", "Disables weather.");
        this.f37121 = (Listener<c36575>)new Listener(this::m37122, new Predicate[0]);
    }
    
    private /* synthetic */ void m37122(final c36575 c36575) {
        if (this.mc.world.isRaining()) {
            this.mc.world.setRainGradient(0.0f);
        }
    }
    
    static {
        f37120 = new String[] { "anti-weather", "Disables weather." };
    }
}
