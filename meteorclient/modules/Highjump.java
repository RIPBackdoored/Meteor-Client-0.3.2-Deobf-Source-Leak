package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Highjump extends Module
{
    private static final String[] f37398;
    private final Settings f37399;
    private final Value<Double> f37400;
    
    public Highjump() {
        super(Category.Movement, "high-jump", "Jump higher.");
        this.f37399 = this.f38675.m34572();
        this.f37400 = this.f37399.addValue((Value<Double>)new c37033.c38947().m38959("multiplier").m38962("Jump height multiplier.").m38965(1.0).m38974(0.0).m38988());
    }
    
    public float m37401() {
        return this.f37400.m33466().floatValue();
    }
    
    static {
        f37398 = new String[] { "high-jump", "Jump higher.", "multiplier", "Jump height multiplier." };
    }
}
