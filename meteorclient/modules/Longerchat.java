package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Longerchat extends Module
{
    private static final String[] f34245;
    private final Settings f34246;
    private final Value<Integer> f34247;
    
    public Longerchat() {
        super(Category.Misc, "longer-chat", "Makes chat longer.");
        this.f34246 = this.f38675.m34572();
        this.f34247 = this.f34246.addValue((Value<Integer>)new c32369.c32370().m32381("lines").m32384("Chat lines.").m32387(1000).m32396(1).m32405(1000).m32408());
    }
    
    public int m34248() {
        return this.m35315() ? this.f34247.m33466() : 100;
    }
    
    static {
        f34245 = new String[] { "longer-chat", "Makes chat longer.", "lines", "Chat lines." };
    }
}
