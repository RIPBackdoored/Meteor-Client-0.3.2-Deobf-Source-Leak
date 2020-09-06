package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Autojump extends Module
{
    private static final String[] f39269;
    private final Settings f39270;
    private final Value<c36416.JumpIf> f39271;
    @EventHandler
    private Listener<c36575> f39272;
    
    public Autojump() {
        super(Category.Movement, "auto-jump", "Automatically jumps.");
        this.f39270 = this.f38675.m34572();
        this.f39271 = this.f39270.addValue((Value<c36416.JumpIf>)new c36601.c36919<Enum>().m36926("jump-if").m36929("Jump if.").m36932((Enum)c36416.JumpIf.Always).m36941());
        this.f39272 = (Listener<c36575>)new Listener(this::m39275, new Predicate[0]);
    }
    
    private boolean m39273() {
        switch (c36416.c36417.f36418[this.f39271.m33466().ordinal()]) {
            case 1: {
                return this.mc.player.isSprinting() && (this.mc.player.forwardSpeed != 0.0f || this.mc.player.sidewaysSpeed != 0.0f);
            }
            case 2: {
                return this.mc.player.forwardSpeed != 0.0f || this.mc.player.sidewaysSpeed != 0.0f;
            }
            case 3: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    private /* synthetic */ void m39275(final c36575 c36575) {
        if (!this.mc.player.onGround || this.mc.player.isSneaking()) {
            return;
        }
        if (this.m39273()) {
            this.mc.player.jump();
        }
    }
    
    static {
        f39269 = new String[] { "auto-jump", "Automatically jumps.", "jump-if", "Jump if." };
    }
}
