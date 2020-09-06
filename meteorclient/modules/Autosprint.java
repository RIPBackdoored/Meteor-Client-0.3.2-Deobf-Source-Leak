package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import minegame159.meteorclient.*;

public class Autosprint extends Module
{
    private static final String[] f34020;
    private final Settings f34021;
    private final Value<c34019.Mode> f34022;
    @EventHandler
    private Listener<c36575> f34023;
    
    public Autosprint() {
        super(Category.Movement, "auto-sprint", "Automatically sprints.");
        this.f34021 = this.f38675.m34572();
        this.f34022 = this.f34021.addValue((Value<c34019.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Mode.").m36932((Enum)c34019.Mode.Always).m36941());
        this.f34023 = (Listener<c36575>)new Listener(this::m34027, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.m34024(false);
    }
    
    private void m34024(final boolean sprinting) {
        if (this.f34022.m33466() == c34019.Mode.Always) {
            this.mc.player.setSprinting(sprinting);
        }
        else {
            ((c39520)this.mc.options.keySprint).m39521(sprinting);
        }
    }
    
    private /* synthetic */ void m34027(final c36575 c36575) {
        if (this.mc.player.forwardSpeed > 0.0f && !this.mc.player.horizontalCollision && !this.mc.player.isSneaking()) {
            this.m34024(true);
        }
        else {
            this.m34024(false);
        }
    }
    
    static {
        f34020 = new String[] { "auto-sprint", "Automatically sprints.", "mode", "Mode." };
    }
}
