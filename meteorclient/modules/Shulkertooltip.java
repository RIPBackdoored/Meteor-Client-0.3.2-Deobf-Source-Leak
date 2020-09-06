package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Shulkertooltip extends Module
{
    private static final String[] f37824;
    private final Settings f37825;
    private final Value<Integer> f37826;
    
    public Shulkertooltip() {
        super(Category.Misc, "shulker-tooltip", "Better shulker item tooltip.");
        this.f37825 = this.f38675.m34572();
        this.f37826 = this.f37825.addValue((Value<Integer>)new c32369.c32370().m32381("lines").m32384("Number of lines.").m32387(8).m32396(0).m32408());
    }
    
    public int m37827() {
        return this.f37826.m33466();
    }
    
    static {
        f37824 = new String[] { "shulker-tooltip", "Better shulker item tooltip.", "lines", "Number of lines." };
    }
}
