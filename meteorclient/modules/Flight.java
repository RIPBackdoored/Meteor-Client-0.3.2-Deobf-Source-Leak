package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Flight extends Module
{
    private static final String[] f34885;
    private final Settings f34886;
    private final Value<c34884.Mode> f34887;
    private final Value<Double> f34888;
    private final Value<Boolean> f34889;
    private final Value<Integer> f34890;
    private final Value<Integer> f34891;
    private int f34892;
    private int f34893;
    @EventHandler
    private final Listener<c36575> f34894;
    
    public Flight() {
        super(Category.Movement, "flight", "FLYYYY! You will take fall damage so enable no fall.");
        this.f34886 = this.f38675.m34572();
        this.f34887 = this.f34886.addValue((Value<c34884.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Mode.").m36932((Enum)c34884.Mode.Vanilla).m36941());
        this.f34888 = this.f34886.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("Speed.").m38965(0.1).m38974(0.0).m38988());
        this.f34889 = this.f34886.addValue((Value<Boolean>)new c34427.c34657().m34664("anti-kick").m34667("Toggles flight to try and stop you getting kicked.").m34670(false).m34679());
        this.f34890 = this.f34886.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("The time in between toggles.(20 ticks = 1 second)").m32387(60).m32396(1).m32399(5000).m32405(200).m32408());
        this.f34891 = this.f34886.addValue((Value<Integer>)new c32369.c32370().m32381("off-time").m32384("The time the flight is toggled off.(20 ticks = 1 second)").m32387(5).m32396(1).m32399(20).m32405(10).m32408());
        this.f34892 = this.f34890.m33466();
        this.f34893 = this.f34891.m33466();
        this.f34894 = (Listener<c36575>)new Listener(this::m34895, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        if (this.f34887.m33466() == c34884.Mode.Vanilla && !this.mc.player.isSpectator()) {
            this.mc.player.abilities.flying = true;
            if (this.mc.player.abilities.creativeMode) {
                return;
            }
            this.mc.player.abilities.allowFlying = true;
        }
    }
    
    @Override
    public void m35294() {
        if (this.f34887.m33466() == c34884.Mode.Vanilla && !this.mc.player.isSpectator()) {
            this.mc.player.abilities.flying = false;
            this.mc.player.abilities.setFlySpeed(0.05f);
            if (this.mc.player.abilities.creativeMode) {
                return;
            }
            this.mc.player.abilities.allowFlying = false;
        }
    }
    
    private /* synthetic */ void m34895(final c36575 c36575) {
        if (this.f34889.m33466() && this.f34892 > 0) {
            --this.f34892;
        }
        else if (this.f34889.m33466() && this.f34892 <= 0 && this.f34893 > 0) {
            --this.f34893;
            this.mc.player.abilities.flying = false;
            this.mc.player.abilities.setFlySpeed(0.05f);
            if (this.mc.player.abilities.creativeMode) {
                return;
            }
            this.mc.player.abilities.allowFlying = false;
            return;
        }
        else if (this.f34889.m33466() && this.f34892 <= 0 && this.f34893 <= 0) {
            this.f34892 = this.f34890.m33466();
            this.f34893 = this.f34891.m33466();
        }
        if (this.f34887.m33466() == c34884.Mode.Vanilla && !this.mc.player.isSpectator()) {
            this.mc.player.abilities.setFlySpeed(this.f34888.m33466().floatValue());
            this.mc.player.abilities.flying = true;
            if (this.mc.player.abilities.creativeMode) {
                return;
            }
            this.mc.player.abilities.allowFlying = true;
        }
    }
    
    static {
        f34885 = new String[] { "flight", "FLYYYY! You will take fall damage so enable no fall.", "mode", "Mode.", "speed", "Speed.", "anti-kick", "Toggles flight to try and stop you getting kicked.", "delay", "The time in between toggles.(20 ticks = 1 second)", "off-time", "The time the flight is toggled off.(20 ticks = 1 second)" };
    }
}
