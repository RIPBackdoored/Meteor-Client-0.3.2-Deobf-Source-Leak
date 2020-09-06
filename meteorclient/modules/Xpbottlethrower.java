package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.item.*;
import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class Xpbottlethrower extends Module
{
    private static final String[] f34548;
    private final Settings f34549;
    private final Value<Boolean> f34550;
    @EventHandler
    private final Listener<c36575> f34551;
    
    public Xpbottlethrower() {
        super(Category.Player, "xp-bottle-thrower", "Automatically throws xp bottles in your hotbar.");
        this.f34549 = this.f38675.m34572();
        this.f34550 = this.f34549.addValue((Value<Boolean>)new c34427.c34657().m34664("look-down").m34667("Makes you look down when throwing bottles").m34670(true).m34679());
        this.f34551 = (Listener<c36575>)new Listener(this::m34552, new Predicate[0]);
    }
    
    private /* synthetic */ void m34552(final c36575 c36575) {
        int selectedSlot = -1;
        for (int i = 0; i < 9; ++i) {
            if (this.mc.player.inventory.getInvStack(i).getItem() == Items.field_8287) {
                selectedSlot = i;
                break;
            }
        }
        if (selectedSlot != -1) {
            if (this.f34550.m33466()) {
                this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(this.mc.player.yaw, 90.0f, this.mc.player.onGround));
            }
            final int selectedSlot2 = this.mc.player.inventory.selectedSlot;
            this.mc.player.inventory.selectedSlot = selectedSlot;
            this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, (World)this.mc.world, Hand.field_5808);
            this.mc.player.inventory.selectedSlot = selectedSlot2;
        }
    }
    
    static {
        f34548 = new String[] { "xp-bottle-thrower", "Automatically throws xp bottles in your hotbar.", "look-down", "Makes you look down when throwing bottles" };
    }
}
