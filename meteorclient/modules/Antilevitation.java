package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Antilevitation extends Module
{
    private static final String[] f33679;
    private final Settings f33680;
    private final Value<Boolean> f33681;
    
    public Antilevitation() {
        super(Category.Movement, "anti-levitation", "Removes levitation effect.");
        this.f33680 = this.f38675.m34572();
        this.f33681 = this.f33680.addValue((Value<Boolean>)new c34427.c34657().m34664("apply-gravity").m34667("Apply gravity.").m34670(false).m34679());
    }
    
    public boolean m33682() {
        return this.f33681.m33466();
    }
    
    static {
        f33679 = new String[] { "anti-levitation", "Removes levitation effect.", "apply-gravity", "Apply gravity." };
    }
}
