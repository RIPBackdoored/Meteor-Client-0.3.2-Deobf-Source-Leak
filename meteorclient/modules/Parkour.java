package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.*;

public class Parkour extends Module
{
    private static final String[] f33363;
    @EventHandler
    private Listener<c36575> f33364;
    
    public Parkour() {
        super(Category.Movement, "parkour", "Automatically jumps at the edges of blocks.");
        this.f33364 = (Listener<c36575>)new Listener(this::m33365, new Predicate[0]);
    }
    
    private /* synthetic */ void m33365(final c36575 c36575) {
        if (!this.mc.player.onGround || this.mc.options.keyJump.isPressed()) {
            return;
        }
        if (this.mc.player.isSneaking() || this.mc.options.keySneak.isPressed()) {
            return;
        }
        if (this.mc.world.method_20812((Entity)this.mc.player, this.mc.player.getBoundingBox().offset(0.0, -0.5, 0.0).expand(-0.001, 0.0, -0.001)).findAny().isPresent()) {
            return;
        }
        this.mc.player.jump();
    }
    
    static {
        f33363 = new String[] { "parkour", "Automatically jumps at the edges of blocks." };
    }
}
