package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class Autoshearer extends Module
{
    private static final String[] f31753;
    private final Settings f31754;
    private final Value<Double> f31755;
    private final Value<Boolean> f31756;
    @EventHandler
    private Listener<c36575> f31757;
    
    public Autoshearer() {
        super(Category.Misc, "auto-shearer", "Automatically shears sheeps.");
        this.f31754 = this.f38675.m34572();
        this.f31755 = this.f31754.addValue((Value<Double>)new c37033.c38947().m38959("distance").m38962("Maximum distance.").m38974(0.0).m38965(5.0).m38988());
        this.f31756 = this.f31754.addValue((Value<Boolean>)new c34427.c34657().m34664("preserve-broken-shears").m34667("Will not break shears.").m34670(false).m34679());
        this.f31757 = (Listener<c36575>)new Listener(this::m31758, new Predicate[0]);
    }
    
    private /* synthetic */ void m31758(final c36575 c36575) {
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity instanceof SheepEntity && !((SheepEntity)entity).isSheared() && !((SheepEntity)entity).isBaby()) {
                if (this.mc.player.distanceTo(entity) > this.f31755.m33466()) {
                    continue;
                }
                boolean b = false;
                boolean b2 = false;
                if (this.mc.player.inventory.getMainHandStack().getItem() instanceof ShearsItem) {
                    if (this.f31756.m33466() && this.mc.player.inventory.getMainHandStack().getDamage() >= this.mc.player.inventory.getMainHandStack().getMaxDamage() - 1) {
                        b = true;
                    }
                }
                else if (((ItemStack)this.mc.player.inventory.offHand.get(0)).getItem() instanceof ShearsItem) {
                    if (this.f31756.m33466() && ((ItemStack)this.mc.player.inventory.offHand.get(0)).getDamage() >= ((ItemStack)this.mc.player.inventory.offHand.get(0)).getMaxDamage() - 1) {
                        b = true;
                    }
                    else {
                        b2 = true;
                    }
                }
                else {
                    b = true;
                }
                boolean b3 = !b;
                if (b) {
                    final int m31688 = c31671.m31688(Items.field_8868, (Predicate)this::m31766);
                    if (m31688 != 1) {
                        this.mc.player.inventory.selectedSlot = m31688;
                        b3 = true;
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
    
    private /* synthetic */ boolean m31766(final ItemStack itemStack) {
        return !this.f31756.m33466() || (this.f31756.m33466() && itemStack.getDamage() < itemStack.getMaxDamage() - 1);
    }
    
    static {
        f31753 = new String[] { "auto-shearer", "Automatically shears sheeps.", "distance", "Maximum distance.", "preserve-broken-shears", "Will not break shears." };
    }
}
