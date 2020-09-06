package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.vehicle.*;
import minegame159.meteorclient.*;
import net.minecraft.util.math.*;

public class Boatfly extends Module
{
    private static final String[] f31905;
    private final Settings f31906;
    private final Value<Boolean> f31907;
    private final Value<Double> f31908;
    private final Value<Boolean> f31909;
    @EventHandler
    private final Listener<c36575> f31910;
    
    public Boatfly() {
        super(Category.Movement, "boat-fly", "Transforms your boat into a plane.");
        this.f31906 = this.f38675.m34572();
        this.f31907 = this.f31906.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-steer").m34667("Automatically steer in the direction you are facing.").m34670(true).m34679());
        this.f31908 = this.f31906.addValue((Value<Double>)new c37033.c38947().m38959("upwards-speed").m38962("How fast you fly upwards.").m38965(0.3).m38974(0.0).m38988());
        this.f31909 = this.f31906.addValue((Value<Boolean>)new c34427.c34657().m34664("slow-falling").m34667("Makes you fall slower.").m34670(true).m34679());
        this.f31910 = (Listener<c36575>)new Listener(this::m31911, new Predicate[0]);
    }
    
    private /* synthetic */ void m31911(final c36575 c36575) {
        if (!(this.mc.player.getVehicle() instanceof BoatEntity)) {
            return;
        }
        if (this.f31907.m33466()) {
            this.mc.player.getVehicle().yaw = this.mc.player.yaw;
        }
        final Vec3d velocity = this.mc.player.getVehicle().getVelocity();
        if (this.mc.options.keyJump.isPressed()) {
            ((c37143)velocity).m37144(velocity.x, this.f31908.m33466(), velocity.z);
        }
        else if (this.f31909.m33466()) {
            ((c37143)velocity).m37144(velocity.x, 0.0, velocity.z);
        }
    }
    
    static {
        f31905 = new String[] { "boat-fly", "Transforms your boat into a plane.", "auto-steer", "Automatically steer in the direction you are facing.", "upwards-speed", "How fast you fly upwards.", "slow-falling", "Makes you fall slower." };
    }
}
