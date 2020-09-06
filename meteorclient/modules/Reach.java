package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Reach extends Module
{
    private static final String[] f31916;
    private final Settings f31917;
    private final Value<Double> f31918;
    
    public Reach() {
        super(Category.Player, "reach", "Modifies your reach.");
        this.f31917 = this.f38675.m34572();
        this.f31918 = this.f31917.addValue((Value<Double>)new c37033.c38947().m38959("reach").m38962("Reach.").m38965(5.0).m38974(0.0).m38983(6.0).m38988());
    }
    
    public float m31919() {
        return this.f31918.m33466().floatValue();
    }
    
    static {
        f31916 = new String[] { "reach", "Modifies your reach.", "reach", "Reach." };
    }
}
