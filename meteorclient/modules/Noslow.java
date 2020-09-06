package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Noslow extends Module
{
    private static final String[] f34413;
    private final Settings f34414;
    private final Value<Boolean> f34415;
    private final Value<Boolean> f34416;
    private final Value<Boolean> f34417;
    private final Value<Boolean> f34418;
    
    public Noslow() {
        super(Category.Movement, "no-slow", "Allows you to move normally while eating, using items, etc.");
        this.f34414 = this.f38675.m34572();
        this.f34415 = this.f34414.addValue((Value<Boolean>)new c34427.c34657().m34664("items").m34667("No slow from using items.").m34670(true).m34679());
        this.f34416 = this.f34414.addValue((Value<Boolean>)new c34427.c34657().m34664("web").m34667("No slow from cob webs.").m34670(true).m34679());
        this.f34417 = this.f34414.addValue((Value<Boolean>)new c34427.c34657().m34664("soul-sand").m34667("No slow from soul sand.").m34670(true).m34679());
        this.f34418 = this.f34414.addValue((Value<Boolean>)new c34427.c34657().m34664("slime-block").m34667("No slow from slime blocks.").m34670(true).m34679());
    }
    
    public boolean m34419() {
        return this.m35315() && this.f34415.m33466();
    }
    
    public boolean m34421() {
        return this.m35315() && this.f34416.m33466();
    }
    
    public boolean m34423() {
        return this.m35315() && this.f34417.m33466();
    }
    
    public boolean m34425() {
        return this.m35315() && this.f34418.m33466();
    }
    
    static {
        f34413 = new String[] { "no-slow", "Allows you to move normally while eating, using items, etc.", "items", "No slow from using items.", "web", "No slow from cob webs.", "soul-sand", "No slow from soul sand.", "slime-block", "No slow from slime blocks." };
    }
}
