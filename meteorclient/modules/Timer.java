package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Timer extends Module
{
    private static final String[] f38249;
    private final Settings f38250;
    private final Value<Double> f38251;
    
    public Timer() {
        super(Category.Misc, "timer", "Changes speed of everything. WARNING: Lowering it will slow down your game dramatically.");
        this.f38250 = this.f38675.m34572();
        this.f38251 = this.f38250.addValue((Value<Double>)new c37033.c38947().m38959("speed").m38962("Speed multiplier.").m38965(1.0).m38974(0.1).m38980(0.1).m38983(10.0).m38988());
    }
    
    public double m38252() {
        return this.m35315() ? this.f38251.m33466() : 1.0;
    }
    
    static {
        f38249 = new String[] { "timer", "Changes speed of everything. WARNING: Lowering it will slow down your game dramatically.", "speed", "Speed multiplier." };
    }
}
