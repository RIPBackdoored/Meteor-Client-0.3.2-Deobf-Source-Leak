package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Rotation extends Module
{
    private static final String[] f32194;
    private final Settings f32195;
    private final Value<Double> f32196;
    private final Value<Boolean> f32197;
    private final Settings f32198;
    private final Value<Double> f32199;
    @EventHandler
    private final Listener<c36575> f32200;
    
    public Rotation() {
        super(Category.Player, "rotation", "Allows you to lock your yaw and pitch.");
        this.f32195 = this.f38675.m34582("Yaw", "lock-yaw", "Locks your yaw.", false);
        this.f32196 = this.f32195.addValue((Value<Double>)new c37033.c38947().m38959("yaw-angle").m38962("Yaw angle in degrees.").m38965(0.0).m38988());
        this.f32197 = this.f32195.addValue((Value<Boolean>)new c34427.c34657().m34664("yaw-auuto-angle").m34667("Automatically uses the best angle.").m34670(true).m34679());
        this.f32198 = this.f38675.m34582("Pitch", "lock-pitch", "Locks your pitch.", false);
        this.f32199 = this.f32198.addValue((Value<Double>)new c37033.c38947().m38959("pitch-angle").m38962("Pitch angle in degrees.").m38965(0.0).m38974(-90.0).m38977(90.0).m38988());
        this.f32200 = (Listener<c36575>)new Listener(this::m32203, new Predicate[0]);
    }
    
    private float m32201() {
        return Math.round((this.mc.player.yaw + 1.0f) / 45.0f) * 45.0f;
    }
    
    private /* synthetic */ void m32203(final c36575 c36575) {
        if (this.f32195.m33970()) {
            if (this.f32197.m33466()) {
                this.mc.player.yaw = this.m32201();
            }
            else {
                this.mc.player.yaw = this.f32196.m33466().floatValue();
            }
        }
        if (this.f32198.m33970()) {
            this.mc.player.pitch = this.f32199.m33466().floatValue();
        }
    }
    
    static {
        f32194 = new String[] { "rotation", "Allows you to lock your yaw and pitch.", "Yaw", "lock-yaw", "Locks your yaw.", "yaw-angle", "Yaw angle in degrees.", "yaw-auuto-angle", "Automatically uses the best angle.", "Pitch", "lock-pitch", "Locks your pitch.", "pitch-angle", "Pitch angle in degrees." };
    }
}
