package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Antispam extends Module
{
    private static final String[] f33579;
    private final Settings f33580;
    private final Value<Integer> f33581;
    private final Value<Boolean> f33582;
    
    public Antispam() {
        super(Category.Misc, "anti-spam", "Repeated messages not shown.");
        this.f33580 = this.f38675.m34572();
        this.f33581 = this.f33580.addValue((Value<Integer>)new c32369.c32370().m32381("depth").m32384("How many messages to check for duplicates.").m32387(4).m32396(1).m32402(1).m32408());
        this.f33582 = this.f33580.addValue((Value<Boolean>)new c34427.c34657().m34664("move-to-bottom").m34667("Move duplicate messages to bottom.").m34670(true).m34679());
    }
    
    public int m33583() {
        return this.m35315() ? this.f33581.m33466() : 0;
    }
    
    public boolean m33585() {
        return this.f33582.m33466();
    }
    
    static {
        f33579 = new String[] { "anti-spam", "Repeated messages not shown.", "depth", "How many messages to check for duplicates.", "move-to-bottom", "Move duplicate messages to bottom." };
    }
}
