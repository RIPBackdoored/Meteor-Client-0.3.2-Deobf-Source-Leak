package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;

public class Middleclickfriend extends Module
{
    private static final String[] f39279;
    @EventHandler
    private final Listener<c39097> f39280;
    
    public Middleclickfriend() {
        super(Category.Misc, "middle-click-friend", "Adds/removes player as friend.");
        this.f39280 = (Listener<c39097>)new Listener(this::m39281, new Predicate[0]);
    }
    
    private /* synthetic */ void m39281(final c39097 c39097) {
        if (this.mc.currentScreen != null) {
            return;
        }
        if (this.mc.targetedEntity instanceof PlayerEntity) {
            c39017.f39019.m39050(new c31543((PlayerEntity)this.mc.targetedEntity));
        }
    }
    
    static {
        f39279 = new String[] { "middle-click-friend", "Adds/removes player as friend." };
    }
}
