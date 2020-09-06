package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;

public class Entitylogger extends Module
{
    private static final String[] f31859;
    private final Settings f31860;
    private final Value<List<class_1299<?>>> f31861;
    private final Value<Boolean> f31862;
    private final Value<Boolean> f31863;
    @EventHandler
    private final Listener<c34242> f31864;
    
    public Entitylogger() {
        super(Category.Misc, "entity-logger", "Sends chat message when selected entities appear.");
        this.f31860 = this.f38675.m34572();
        this.f31861 = this.f31860.addValue((Value<List<class_1299<?>>>)new c33686.c38917().m38925("entites").m38928("Select specific entities.").m38931(new ArrayList<class_1299<?>>(0)).m38942());
        this.f31862 = this.f31860.addValue((Value<Boolean>)new c34427.c34657().m34664("player-names").m34667("Show player names.").m34670(true).m34679());
        this.f31863 = this.f31860.addValue((Value<Boolean>)new c34427.c34657().m34664("friends").m34667("Log friends.").m34670(true).m34679());
        this.f31864 = (Listener<c34242>)new Listener(this::m31865, new Predicate[0]);
    }
    
    private /* synthetic */ void m31865(final c34242 c34242) {
        if (c34242.f34243.getUuid().equals(this.mc.player.getUuid())) {
            return;
        }
        if (this.f31861.m33466().contains(c34242.f34243.getType())) {
            if (c34242.f34243 instanceof PlayerEntity && !this.f31863.m33466() && c39017.f39019.m39034((PlayerEntity)c34242.f34243) != null) {
                return;
            }
            String s;
            if (this.f31862.m33466() && c34242.f34243 instanceof PlayerEntity) {
                s = ((PlayerEntity)c34242.f34243).getGameProfile().getName() + " (Player)";
            }
            else {
                s = c34242.f34243.getType().getName().asString();
            }
            c31351.m31353(this, "(highlight)%s (default)spawned at (highlight)%.0f(default), (highlight)%.0f(default), (highlight)%.0f(default).", s, c34242.f34243.x, c34242.f34243.y, c34242.f34243.z);
        }
    }
    
    static {
        f31859 = new String[] { "entity-logger", "Sends chat message when selected entities appear.", "entites", "Select specific entities.", "player-names", "Show player names.", "friends", "Log friends.", " (Player)", "(highlight)%s (default)spawned at (highlight)%.0f(default), (highlight)%.0f(default), (highlight)%.0f(default)." };
    }
}
