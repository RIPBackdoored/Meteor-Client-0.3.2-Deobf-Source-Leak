package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;
import java.util.*;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class Totempopnotifier extends Module
{
    private static final String[] f31528;
    private final Map<UUID, Integer> f31529;
    @EventHandler
    private final Listener<c39306> f31530;
    @EventHandler
    private final Listener<c36575> f31531;
    
    public Totempopnotifier() {
        super(Category.Combat, "totem-pop-notifier", "Send chat message when someone pops a totem or dies.");
        this.f31529 = new HashMap<UUID, Integer>();
        this.f31530 = (Listener<c39306>)new Listener(this::m31537, new Predicate[0]);
        this.f31531 = (Listener<c36575>)new Listener(this::m31532, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f31529.clear();
    }
    
    private /* synthetic */ void m31532(final c36575 c36575) {
        synchronized (this.f31529) {
            for (final PlayerEntity playerEntity : this.mc.world.getPlayers()) {
                if (!this.f31529.containsKey(playerEntity.getUuid())) {
                    continue;
                }
                if (playerEntity.deathTime <= 0 && playerEntity.getHealth() > 0.0f) {
                    continue;
                }
                final int intValue = this.f31529.remove(playerEntity.getUuid());
                c31351.m31357("(highlight)%s (default)died after popping (highlight)%d (default)%s.", playerEntity.getName().getString(), intValue, (intValue == 1) ? "totem" : "totems");
            }
        }
    }
    
    private /* synthetic */ void m31537(final c39306 c39306) {
        if (!(c39306.f39307 instanceof EntityStatusS2CPacket)) {
            return;
        }
        final EntityStatusS2CPacket entityStatusS2CPacket = (EntityStatusS2CPacket)c39306.f39307;
        if (entityStatusS2CPacket.getStatus() != 35) {
            return;
        }
        final Entity entity = entityStatusS2CPacket.getEntity((World)this.mc.world);
        if (entity == null) {
            return;
        }
        synchronized (this.f31529) {
            int intValue = this.f31529.getOrDefault(entity.getUuid(), 0);
            ++intValue;
            this.f31529.put(entity.getUuid(), intValue);
            c31351.m31357("(highlight)%s (default)popped (highlight)%d (default)%s.", entity.getName().getString(), intValue, (intValue == 1) ? "totem" : "totems");
        }
    }
    
    static {
        f31528 = new String[] { "totem-pop-notifier", "Send chat message when someone pops a totem or dies.", "(highlight)%s (default)died after popping (highlight)%d (default)%s.", "totem", "totems", "(highlight)%s (default)popped (highlight)%d (default)%s.", "totem", "totems" };
    }
}
