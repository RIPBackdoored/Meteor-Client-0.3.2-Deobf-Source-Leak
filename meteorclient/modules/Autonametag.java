package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import java.util.*;

public class Autonametag extends Module
{
    private static final String[] f35232;
    private final Settings f35233;
    private final Value<Double> f35234;
    @EventHandler
    private Listener<c36575> f35235;
    
    public Autonametag() {
        super(Category.Misc, "auto-nametag", "Automatically uses nametags in hotbar on unnamed entites. WARNING: will name all entities in specified distance.");
        this.f35233 = this.f38675.m34572();
        this.f35234 = this.f35233.addValue((Value<Double>)new c37033.c38947().m38959("distance").m38962("Maximum distance.").m38974(0.0).m38965(5.0).m38988());
        this.f35235 = (Listener<c36575>)new Listener(this::m35236, new Predicate[0]);
    }
    
    private /* synthetic */ void m35236(final c36575 c36575) {
        for (final Entity entity : this.mc.world.getEntities()) {
            if (!(entity instanceof PlayerEntity) && !entity.hasCustomName()) {
                if (this.mc.player.distanceTo(entity) > this.f35234.m33466()) {
                    continue;
                }
                boolean b = true;
                boolean b2 = false;
                if (this.mc.player.inventory.getMainHandStack().getItem() instanceof NameTagItem) {
                    b = false;
                }
                else if (((ItemStack)this.mc.player.inventory.offHand.get(0)).getItem() instanceof NameTagItem) {
                    b = false;
                    b2 = true;
                }
                boolean b3 = !b;
                if (b) {
                    for (int i = 0; i < 9; ++i) {
                        if (this.mc.player.inventory.getInvStack(i).getItem() instanceof NameTagItem) {
                            this.mc.player.inventory.selectedSlot = i;
                            b3 = true;
                            break;
                        }
                    }
                }
                if (b3) {
                    this.mc.interactionManager.interactEntity((PlayerEntity)this.mc.player, entity, b2 ? Hand.field_5810 : Hand.field_5808);
                    return;
                }
                continue;
            }
        }
    }
    
    static {
        f35232 = new String[] { "auto-nametag", "Automatically uses nametags in hotbar on unnamed entites. WARNING: will name all entities in specified distance.", "distance", "Maximum distance." };
    }
}
