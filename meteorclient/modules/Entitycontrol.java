package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class Entitycontrol extends Module
{
    private static final String[] f33637;
    @EventHandler
    private final Listener<c36575> f33638;
    
    public Entitycontrol() {
        super(Category.Movement, "entity-control", "Lets you control horses, donkeys and mules without a saddle.");
        this.f33638 = (Listener<c36575>)new Listener(this::m33639, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.mc.world.getEntities().forEach(c33636::m33645);
    }
    
    private /* synthetic */ void m33639(final c36575 c36575) {
        this.mc.world.getEntities().forEach(c33636::m33643);
        if (!this.mc.player.hasVehicle()) {
            return;
        }
        final Entity vehicle = this.mc.player.getVehicle();
        if (vehicle instanceof HorseBaseEntity) {
            ((HorseBaseEntity)vehicle).setAiDisabled(true);
            ((HorseBaseEntity)vehicle).setTame(true);
        }
    }
    
    private static /* synthetic */ void m33643(final Entity entity) {
        if (entity instanceof HorseBaseEntity) {
            ((HorseBaseEntity)entity).setSaddled(true);
        }
    }
    
    private static /* synthetic */ void m33645(final Entity entity) {
        if (entity instanceof HorseBaseEntity) {
            ((HorseBaseEntity)entity).setSaddled(false);
        }
    }
    
    static {
        f33637 = new String[] { "entity-control", "Lets you control horses, donkeys and mules without a saddle." };
    }
}
