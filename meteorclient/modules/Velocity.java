package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Velocity extends Module
{
    private static final String[] f35280;
    private final Settings f35281;
    private final Value<Double> f35282;
    private final Value<Double> f35283;
    
    public Velocity() {
        super(Category.Movement, "velocity", "Prevents you from getting pushed by mobs, taking damage, etc.");
        this.f35281 = this.f38675.m34572();
        this.f35282 = this.f35281.addValue((Value<Double>)new c37033.c38947().m38959("horizontal-multiplier").m38962("How much velocity to apply horizontally.").m38965(0.0).m38974(0.0).m38977(1.0).m38980(0.0).m38983(1.0).m38988());
        this.f35283 = this.f35281.addValue((Value<Double>)new c37033.c38947().m38959("vertical-multiplier").m38962("How much velocity to apply vertically.").m38965(0.0).m38974(0.0).m38977(1.0).m38980(0.0).m38983(1.0).m38988());
    }
    
    public double m35284() {
        return this.m35315() ? this.f35282.m33466() : 1.0;
    }
    
    public double m35286() {
        return this.m35315() ? this.f35283.m33466() : 1.0;
    }
    
    static {
        f35280 = new String[] { "velocity", "Prevents you from getting pushed by mobs, taking damage, etc.", "horizontal-multiplier", "How much velocity to apply horizontally.", "vertical-multiplier", "How much velocity to apply vertically." };
    }
}
