package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.util.math.*;

public class Spider extends Module
{
    private static final String[] f33261;
    private final Settings f33262;
    private final Value<Double> f33263;
    @EventHandler
    private Listener<c36575> f33264;
    
    public Spider() {
        super(Category.Movement, "spider", "Allows you to climb walls.");
        this.f33262 = this.f38675.m34572();
        this.f33263 = this.f33262.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("Speed.").m38965(0.2).m38974(0.0).m38988());
        this.f33264 = (Listener<c36575>)new Listener(this::m33265, new Predicate[0]);
    }
    
    private /* synthetic */ void m33265(final c36575 c36575) {
        if (!this.mc.player.horizontalCollision) {
            return;
        }
        final Vec3d velocity = this.mc.player.getVelocity();
        if (velocity.y >= 0.2) {
            return;
        }
        this.mc.player.setVelocity(velocity.x, (double)this.f33263.m33466(), velocity.z);
    }
    
    static {
        f33261 = new String[] { "spider", "Allows you to climb walls.", "speed", "Speed." };
    }
}
