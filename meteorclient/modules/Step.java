package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Step extends Module
{
    private static final String[] f33352;
    private final Settings f33353;
    private final Value<Double> f33354;
    private float f33355;
    @EventHandler
    private Listener<c36575> f33356;
    
    public Step() {
        super(Category.Movement, "step", "Allows you to step up full blocks.");
        this.f33353 = this.f38675.m34572();
        this.f33354 = this.f33353.addValue((Value<Double>)new c37033.c38947().m38959("height").m38962("Step height.").m38965(1.0).m38974(0.0).m38988());
        this.f33356 = (Listener<c36575>)new Listener(this::m33357, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f33355 = this.mc.player.stepHeight;
    }
    
    @Override
    public void m35294() {
        this.mc.player.stepHeight = this.f33355;
    }
    
    private /* synthetic */ void m33357(final c36575 c36575) {
        this.mc.player.stepHeight = this.f33354.m33466().floatValue();
    }
    
    static {
        f33352 = new String[] { "step", "Allows you to step up full blocks.", "height", "Step height." };
    }
}
