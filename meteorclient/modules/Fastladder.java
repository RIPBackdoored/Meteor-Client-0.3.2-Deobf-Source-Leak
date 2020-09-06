package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.util.math.*;

public class Fastladder extends Module
{
    private static final String[] f38054;
    private final Settings f38055;
    private final Value<Double> f38056;
    @EventHandler
    private Listener<c36575> f38057;
    
    public Fastladder() {
        super(Category.Movement, "fast-ladder", "Climb ladders faster.");
        this.f38055 = this.f38675.m34572();
        this.f38056 = this.f38055.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("Speed.").m38965(0.2872).m38974(0.0).m38988());
        this.f38057 = (Listener<c36575>)new Listener(this::m38058, new Predicate[0]);
    }
    
    private /* synthetic */ void m38058(final c36575 c36575) {
        if (!this.mc.player.isClimbing() || !this.mc.player.horizontalCollision) {
            return;
        }
        if (this.mc.player.input.movementForward == 0.0f && this.mc.player.input.movementSideways == 0.0f) {
            return;
        }
        final Vec3d velocity = this.mc.player.getVelocity();
        this.mc.player.setVelocity(velocity.x, (double)this.f38056.m33466(), velocity.z);
    }
    
    static {
        f38054 = new String[] { "fast-ladder", "Climb ladders faster.", "speed", "Speed." };
    }
}
