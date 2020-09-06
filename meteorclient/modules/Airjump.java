package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Airjump extends Module
{
    private static final String[] f39757;
    @EventHandler
    private Listener<c38944> f39758;
    
    public Airjump() {
        super(Category.Movement, "air-jump", "Lets you jump in air.");
        this.f39758 = (Listener<c38944>)new Listener(this::m39759, new Predicate[0]);
    }
    
    private /* synthetic */ void m39759(final c38944 c38944) {
        if (c38944.f38946 && this.mc.options.keyJump.matchesKey(c38944.f38945, 0)) {
            this.mc.player.jump();
        }
    }
    
    static {
        f39757 = new String[] { "air-jump", "Lets you jump in air." };
    }
}
