package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import baritone.api.*;
import baritone.api.pathing.goals.*;
import minegame159.meteorclient.*;

public class Autowalk extends Module
{
    private static final String[] f33666;
    private final Settings f33667;
    private final Value<c33665.Mode> f33668;
    private int f33669;
    private c37413 f33670;
    @EventHandler
    private Listener<c36575> f33671;
    
    public Autowalk() {
        super(Category.Movement, "auto-walk", "Automatically walks forward.");
        this.f33667 = this.f38675.m34572();
        this.f33668 = this.f33667.addValue((Value<c33665.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Walking mode.").m36932((Enum)c33665.Mode.Smart).m36941());
        this.f33669 = 0;
        this.f33671 = (Listener<c36575>)new Listener(this::m33672, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        if (this.f33668.m33466() == c33665.Mode.Smart) {
            this.f33669 = 0;
            this.f33670 = new c37413(this.mc.player.getPos(), this.mc.player.yaw);
            BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)this.f33670);
        }
    }
    
    @Override
    public void m35294() {
        if (this.f33668.m33466() == c33665.Mode.Simple) {
            ((c39520)this.mc.options.keyForward).m39521(false);
        }
        else {
            BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().cancelEverything();
        }
    }
    
    private /* synthetic */ void m33672(final c36575 c36575) {
        if (this.f33668.m33466() == c33665.Mode.Simple) {
            ((c39520)this.mc.options.keyForward).m39521(true);
        }
        else {
            if (this.f33669 > 20) {
                this.f33669 = 0;
                this.f33670.m37419(this.mc.player.getPos());
            }
            ++this.f33669;
        }
    }
    
    static {
        f33666 = new String[] { "auto-walk", "Automatically walks forward.", "mode", "Walking mode." };
    }
}
