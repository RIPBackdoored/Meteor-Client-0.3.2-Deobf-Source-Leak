package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Norender extends Module
{
    private static final String[] f31696;
    private final Settings f31697;
    private final Value<Boolean> f31698;
    private final Value<Boolean> f31699;
    private final Value<Boolean> f31700;
    private final Value<Boolean> f31701;
    private final Value<Boolean> f31702;
    private final Value<Boolean> f31703;
    private final Value<Boolean> f31704;
    private final Value<Boolean> f31705;
    private final Value<Boolean> f31706;
    private final Value<Boolean> f31707;
    private final Value<Boolean> f31708;
    private final Value<Boolean> f31709;
    private final Value<Boolean> f31710;
    private final Value<Boolean> f31711;
    private final Value<Boolean> f31712;
    private final Value<Boolean> f31713;
    private final Value<Boolean> f31714;
    private final Value<Boolean> f31715;
    
    public Norender() {
        super(Category.Render, "no-render", "Disables some things from rendering.");
        this.f31697 = this.f38675.m34572();
        this.f31698 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-bubbles").m34667("Disables rendering of bubbles in water.").m34670(true).m34679());
        this.f31699 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-hurt-cam").m34667("Disables hurt camera effect.").m34670(true).m34679());
        this.f31700 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-weather").m34667("Disables weather.").m34670(true).m34679());
        this.f31701 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-portal-overlay").m34667("Disables portal overlay.").m34670(true).m34679());
        this.f31702 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-pumpkin-overlay").m34667("Disables pumpkin overlay.").m34670(true).m34679());
        this.f31703 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-fire-overlay").m34667("Disables fire overlay.").m34670(true).m34679());
        this.f31704 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-water-overlay").m34667("Disables water overlay.").m34670(true).m34679());
        this.f31705 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-vignette").m34667("Disables vignette effect.").m34670(true).m34679());
        this.f31706 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-boss-bar").m34667("Disables boss bars.").m34670(true).m34679());
        this.f31707 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-scoreboard").m34667("Disable scoreboard.").m34670(true).m34679());
        this.f31708 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-fog").m34667("Disables fog.").m34670(true).m34679());
        this.f31709 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-explosion").m34667("Disables explosion particles.").m34670(true).m34679());
        this.f31710 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-totem").m34667("Disables totem particles.").m34670(true).m34679());
        this.f31711 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-armor").m34667("Disables player armor.").m34670(false).m34679());
        this.f31712 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-nausea").m34667("Disables nausea effect.").m34670(true).m34679());
        this.f31713 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-item").m34667("Disables item entities.").m34670(false).m34679());
        this.f31714 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-ench-table-book").m34667("Disables book above enchanting table.").m34670(false).m34679());
        this.f31715 = this.f31697.addValue((Value<Boolean>)new c34427.c34657().m34664("no-sign-text").m34667("Disables text on signs.").m34670(false).m34679());
    }
    
    public boolean m31716() {
        return this.m35315() && this.f31698.m33466();
    }
    
    public boolean m31718() {
        return this.m35315() && this.f31699.m33466();
    }
    
    public boolean m31720() {
        return this.m35315() && this.f31700.m33466();
    }
    
    public boolean m31722() {
        return this.m35315() && this.f31701.m33466();
    }
    
    public boolean m31724() {
        return this.m35315() && this.f31702.m33466();
    }
    
    public boolean m31726() {
        return this.m35315() && this.f31703.m33466();
    }
    
    public boolean m31728() {
        return this.m35315() && this.f31704.m33466();
    }
    
    public boolean m31730() {
        return this.m35315() && this.f31705.m33466();
    }
    
    public boolean m31732() {
        return this.m35315() && this.f31706.m33466();
    }
    
    public boolean m31734() {
        return this.m35315() && this.f31707.m33466();
    }
    
    public boolean m31736() {
        return this.m35315() && this.f31708.m33466();
    }
    
    public boolean m31738() {
        return this.m35315() && this.f31709.m33466();
    }
    
    public boolean m31740() {
        return this.m35315() && this.f31710.m33466();
    }
    
    public boolean m31742() {
        return this.m35315() && this.f31711.m33466();
    }
    
    public boolean m31744() {
        return this.m35315() && this.f31712.m33466();
    }
    
    public boolean m31746() {
        return this.m35315() && this.f31713.m33466();
    }
    
    public boolean m31748() {
        return this.m35315() && this.f31714.m33466();
    }
    
    public boolean m31750() {
        return this.m35315() && this.f31715.m33466();
    }
    
    static {
        f31696 = new String[] { "no-render", "Disables some things from rendering.", "no-bubbles", "Disables rendering of bubbles in water.", "no-hurt-cam", "Disables hurt camera effect.", "no-weather", "Disables weather.", "no-portal-overlay", "Disables portal overlay.", "no-pumpkin-overlay", "Disables pumpkin overlay.", "no-fire-overlay", "Disables fire overlay.", "no-water-overlay", "Disables water overlay.", "no-vignette", "Disables vignette effect.", "no-boss-bar", "Disables boss bars.", "no-scoreboard", "Disable scoreboard.", "no-fog", "Disables fog.", "no-explosion", "Disables explosion particles.", "no-totem", "Disables totem particles.", "no-armor", "Disables player armor.", "no-nausea", "Disables nausea effect.", "no-item", "Disables item entities.", "no-ench-table-book", "Disables book above enchanting table.", "no-sign-text", "Disables text on signs." };
    }
}
