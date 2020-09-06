package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import minegame159.meteorclient.*;

public class Middleclickextra extends Module
{
    private static final String[] f31842;
    private final Settings f31843;
    private final Value<c31841.Mode> f31844;
    private final Value<Boolean> f31845;
    private boolean f31846;
    private int f31847;
    private int f31848;
    private c31671.c32663 f31849;
    @EventHandler
    private final Listener<c39097> f31850;
    @EventHandler
    private final Listener<c36575> f31851;
    
    public Middleclickextra() {
        super(Category.Player, "middle-click-extra", "Lets you use items on middle click (works at the same time as Middle Click Friend).");
        this.f31843 = this.f38675.m34572();
        this.f31844 = this.f31843.addValue((Value<c31841.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("What to do when you middle click.").m36932((Enum)c31841.Mode.Pearl).m36941());
        this.f31845 = this.f31843.addValue((Value<Boolean>)new c34427.c34657().m34664("notify").m34667("Notify you when you don't have the selected item in your hotbar").m34670(true).m34679());
        this.f31846 = false;
        this.f31850 = (Listener<c39097>)new Listener(this::m31855, new Predicate[0]);
        this.f31851 = (Listener<c36575>)new Listener(this::m31852, new Predicate[0]);
    }
    
    private /* synthetic */ void m31852(final c36575 c36575) {
        if (!this.f31846) {
            return;
        }
        if (this.f31848 > c31671.m31679(c31841.Mode.access$000((c31841.Mode)this.f31844.m33466())).f32665 || (this.mc.player.getMainHandStack().getItem() != c31841.Mode.access$000((c31841.Mode)this.f31844.m33466()) && this.f31844.m33466() == c31841.Mode.Bow && this.mc.player.getMainHandStack().getItem() != Items.field_8102)) {
            ((c39520)this.mc.options.keyUse).m39521(false);
            this.mc.player.inventory.selectedSlot = this.f31847;
            this.f31846 = false;
        }
        else {
            ((c39520)this.mc.options.keyUse).m39521(true);
        }
    }
    
    private /* synthetic */ void m31855(final c39097 c39097) {
        switch (c31841.c36159.f36160[this.f31844.m33466().ordinal()]) {
            case 1: {
                this.f31849 = c31671.m31679(Items.field_8634);
                if (this.f31849.f32664 <= 8 && this.f31849.f32664 != -1) {
                    this.f31847 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = this.f31849.f32664;
                    this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, (World)this.mc.world, Hand.field_5808);
                    this.mc.player.inventory.selectedSlot = this.f31847;
                    break;
                }
                if (this.f31845.m33466()) {
                    c31351.m31367(this, "Unable to find selected item.", new Object[0]);
                    break;
                }
                break;
            }
            case 2: {
                this.f31849 = c31671.m31679(Items.field_8463);
                if (this.f31849.f32664 <= 8 && this.f31849.f32664 != -1) {
                    this.f31847 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = this.f31849.f32664;
                    this.f31848 = this.f31849.f32665;
                    ((c39520)this.mc.options.keyUse).m39521(true);
                    this.f31846 = true;
                    break;
                }
                if (this.f31845.m33466()) {
                    c31351.m31367(this, "Unable to find selected item.", new Object[0]);
                    break;
                }
                break;
            }
            case 3: {
                this.f31849 = c31671.m31679(Items.field_8367);
                if (this.f31849.f32664 <= 8 && this.f31849.f32664 != -1) {
                    this.f31847 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = this.f31849.f32664;
                    this.f31848 = this.f31849.f32665;
                    ((c39520)this.mc.options.keyUse).m39521(true);
                    this.f31846 = true;
                    break;
                }
                if (this.f31845.m33466()) {
                    c31351.m31367(this, "Unable to find selected item.", new Object[0]);
                    break;
                }
                break;
            }
            case 4: {
                this.f31849 = c31671.m31679(Items.field_8102);
                if (this.f31849.f32664 <= 8 && this.f31849.f32664 != -1) {
                    this.f31847 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = this.f31849.f32664;
                    this.f31849 = c31671.m31679(Items.field_8107);
                    this.f31848 = this.f31849.f32665;
                    this.f31846 = true;
                    break;
                }
                if (this.f31845.m33466()) {
                    c31351.m31367(this, "Unable to find selected item.", new Object[0]);
                    break;
                }
                break;
            }
            case 5: {
                this.f31849 = c31671.m31679(Items.field_8378);
                if (this.f31849.f32664 <= 8 && this.f31849.f32664 != -1) {
                    this.f31847 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = this.f31849.f32664;
                    this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, (World)this.mc.world, Hand.field_5808);
                    break;
                }
                if (this.f31845.m33466()) {
                    c31351.m31367(this, "Unable to find selected item.", new Object[0]);
                    break;
                }
                break;
            }
        }
    }
    
    static {
        f31842 = new String[] { "middle-click-extra", "Lets you use items on middle click (works at the same time as Middle Click Friend).", "mode", "What to do when you middle click.", "notify", "Notify you when you don't have the selected item in your hotbar", "Unable to find selected item.", "Unable to find selected item.", "Unable to find selected item.", "Unable to find selected item.", "Unable to find selected item." };
    }
}
