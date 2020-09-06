package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import java.text.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import java.util.*;
import net.minecraft.world.dimension.*;
import minegame159.meteorclient.*;

public class Deathposition extends Module
{
    private static final String[] f31828;
    private final Settings f31829;
    private final Value<Boolean> f31830;
    private final SimpleDateFormat f31831;
    private final c39081 f31832;
    @EventHandler
    private final Listener<c31561> f31833;
    
    public Deathposition() {
        super(Category.Player, "death-position", "Sends to your chat where you died.");
        this.f31829 = this.f38675.m34572();
        this.f31830 = this.f31829.addValue((Value<Boolean>)new c34427.c34657().m34664("create-waypoint").m34667("Creates waypoint when you die.").m34670(true).m34679());
        this.f31831 = new SimpleDateFormat("HH:mm:ss");
        this.f31832 = new c39081("No latest death");
        this.f31833 = (Listener<c31561>)new Listener(this::m31834, new Predicate[0]);
    }
    
    @Override
    public c31923 m38680() {
        return this.f31832;
    }
    
    private /* synthetic */ void m31834(final c31561 c31561) {
        if (c31561.f31562.getUuid() != null && c31561.f31562.getUuid().equals(this.mc.player.getUuid()) && c31561.f31562.getHealth() <= 0.0f) {
            this.f31832.m39087(String.format("Latest death: %.1f, %.1f, %.1f", this.mc.player.x, this.mc.player.y, this.mc.player.z));
            final String format = this.f31831.format(new Date());
            c31351.m31353(this, "Died at (highlight)%.0f(default), (highlight)%.0f(default), (highlight)%.0f (default)on (highlight)%s(default).", this.mc.player.x, this.mc.player.y, this.mc.player.z, format);
            if (this.f31830.m33466()) {
                final c33820 c31562 = new c33820();
                c31562.f33823 = "Death " + format;
                c31562.f33826 = (int)this.mc.player.x;
                c31562.f33827 = (int)this.mc.player.y + 2;
                c31562.f33828 = (int)this.mc.player.z;
                c31562.f33830 = 0;
                if (this.mc.player.dimension == DimensionType.field_13072) {
                    c31562.f33832 = true;
                }
                else if (this.mc.player.dimension == DimensionType.field_13076) {
                    c31562.f33833 = true;
                }
                else if (this.mc.player.dimension == DimensionType.field_13078) {
                    c31562.f33834 = true;
                }
                c34924.f34927.m34935(c31562);
            }
        }
    }
    
    static {
        f31828 = new String[] { "death-position", "Sends to your chat where you died.", "create-waypoint", "Creates waypoint when you die.", "HH:mm:ss", "No latest death", "Latest death: %.1f, %.1f, %.1f", "Died at (highlight)%.0f(default), (highlight)%.0f(default), (highlight)%.0f (default)on (highlight)%s(default).", "Death " };
    }
}
