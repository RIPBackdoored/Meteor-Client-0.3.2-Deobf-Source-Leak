package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import baritone.api.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.item.*;

public class Autoeat extends Module
{
    private static final String[] f32501;
    private final Settings f32502;
    private final Settings f32503;
    private final Settings f32504;
    private final Value<Boolean> f32505;
    private final Value<Boolean> f32506;
    private final Value<Boolean> f32507;
    private final Value<Boolean> f32508;
    private final Value<Boolean> f32509;
    private final Value<Integer> f32510;
    private boolean f32511;
    private boolean f32512;
    private boolean f32513;
    private int f32514;
    private int f32515;
    private int f32516;
    @EventHandler
    private final Listener<c36575> f32517;
    
    public Autoeat() {
        super(Category.Player, "auto-eat", "Automatically eats food.");
        this.f32502 = this.f38675.m34572();
        this.f32503 = this.f38675.m34582("HungerManagement", "manual-hunger-management", "Allows you to choose the hunger to eat at", true);
        this.f32504 = this.f32503.m33980();
        this.f32505 = this.f32502.addValue((Value<Boolean>)new c34427.c34657().m34664("egaps").m34667("Eat enchanted golden apples.").m34670(false).m34679());
        this.f32506 = this.f32502.addValue((Value<Boolean>)new c34427.c34657().m34664("gaps").m34667("Eat golden apples.").m34670(false).m34679());
        this.f32507 = this.f32502.addValue((Value<Boolean>)new c34427.c34657().m34664("chorus").m34667("Eat chorus fruit.").m34670(false).m34679());
        this.f32508 = this.f32502.addValue((Value<Boolean>)new c34427.c34657().m34664("filter-negative-effects").m34667("Filters out food items that give you negative potion effects.").m34670(true).m34679());
        this.f32509 = this.f32502.addValue((Value<Boolean>)new c34427.c34657().m34664("disable-auras").m34667("disable all auras").m34670(false).m34679());
        this.f32510 = this.f32503.addValue((Value<Integer>)new c32369.c32370().m32381("hunger").m32384("The hunger you eat at.").m32387(17).m32396(1).m32399(19).m32405(19).m32408());
        this.f32511 = false;
        this.f32512 = false;
        this.f32517 = (Listener<c36575>)new Listener(this::m32520, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        if (this.f32513) {
            ((c39520)this.mc.options.keyUse).m39521(false);
            this.f32513 = false;
            if (this.f32514 != -1) {
                this.mc.player.inventory.selectedSlot = this.f32514;
            }
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("resume");
        }
    }
    
    public boolean m32518() {
        return !this.m35315() || !this.f32513;
    }
    
    private /* synthetic */ void m32520(final c36575 c36575) {
        if (this.mc.player.abilities.creativeMode) {
            return;
        }
        if (this.f32513 && !this.mc.player.getMainHandStack().getItem().isFood()) {
            ((c39520)this.mc.options.keyUse).m39521(false);
        }
        int selectedSlot = -1;
        int n = -1;
        for (int i = 0; i < 9; ++i) {
            final Item item = this.mc.player.inventory.getInvStack(i).getItem();
            if (item.isFood()) {
                if (this.f32508.m33466()) {
                    if (item == Items.field_8635 || item == Items.field_8323 || item == Items.field_8726 || item == Items.field_8511 || item == Items.field_8680) {
                        continue;
                    }
                    if (item == Items.field_8766) {
                        continue;
                    }
                }
                if (item == Items.field_8367 && item.getFoodComponent().getHunger() > n) {
                    if (this.f32505.m33466()) {
                        n = item.getFoodComponent().getHunger();
                        selectedSlot = i;
                    }
                }
                else if (item == Items.field_8463 && item.getFoodComponent().getHunger() > n) {
                    if (this.f32506.m33466()) {
                        n = item.getFoodComponent().getHunger();
                        selectedSlot = i;
                    }
                }
                else if (item == Items.field_8233 && item.getFoodComponent().getHunger() > n) {
                    if (this.f32507.m33466()) {
                        n = item.getFoodComponent().getHunger();
                        selectedSlot = i;
                    }
                }
                else if (item.getFoodComponent().getHunger() > n) {
                    n = item.getFoodComponent().getHunger();
                    selectedSlot = i;
                }
            }
        }
        if (this.mc.player.getOffHandStack().isFood() && this.mc.player.getOffHandStack().getItem().getFoodComponent().getHunger() > n) {
            n = this.mc.player.getOffHandStack().getItem().getFoodComponent().getHunger();
            selectedSlot = 45;
        }
        if (!this.f32513) {
            if ((selectedSlot != -1 && 20 - this.mc.player.getHungerManager().getFoodLevel() >= n && this.f32504.m33970()) || (20 - this.mc.player.getHungerManager().getFoodLevel() >= this.f32510.m33466() && this.f32503.m33970())) {
                this.f32514 = this.mc.player.inventory.selectedSlot;
                this.f32516 = selectedSlot;
                if (selectedSlot != 45 && selectedSlot != -1) {
                    this.mc.player.inventory.selectedSlot = selectedSlot;
                }
                this.f32513 = true;
                this.f32515 = this.mc.player.getHungerManager().getFoodLevel();
                BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("pause");
            }
            return;
        }
        if (this.mc.player.getHungerManager().getFoodLevel() > this.f32515 || selectedSlot == -1) {
            this.f32513 = false;
            this.mc.interactionManager.stopUsingItem((PlayerEntity)this.mc.player);
            ((c39520)this.mc.options.keyUse).m39521(false);
            if (this.f32511) {
                c34030.f34033.m34042(Killaura.class).m35300();
                this.f32511 = false;
            }
            if (this.f32512) {
                c34030.f34033.m34042(Crystalaura.class).m35300();
                this.f32512 = false;
            }
            if (this.f32514 != -1) {
                this.mc.player.inventory.selectedSlot = this.f32514;
            }
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("resume");
            return;
        }
        if (selectedSlot != 45 && selectedSlot != -1) {
            this.mc.player.inventory.selectedSlot = selectedSlot;
        }
        if (!this.mc.player.isUsingItem()) {
            if (this.f32509.m33466()) {
                if (c34030.f34033.m34042(Killaura.class).m35315()) {
                    this.f32511 = true;
                    c34030.f34033.m34042(Killaura.class).m35300();
                }
                if (c34030.f34033.m34042(Crystalaura.class).m35315()) {
                    this.f32512 = true;
                }
            }
            ((c39520)this.mc.options.keyUse).m39521(true);
            if (selectedSlot == 45) {
                this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, (World)this.mc.world, Hand.field_5810);
            }
            else {
                this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, (World)this.mc.world, Hand.field_5808);
            }
        }
    }
    
    static {
        f32501 = new String[] { "auto-eat", "Automatically eats food.", "HungerManagement", "manual-hunger-management", "Allows you to choose the hunger to eat at", "egaps", "Eat enchanted golden apples.", "gaps", "Eat golden apples.", "chorus", "Eat chorus fruit.", "filter-negative-effects", "Filters out food items that give you negative potion effects.", "disable-auras", "disable all auras", "hunger", "The hunger you eat at.", "resume", "resume", "pause" };
    }
}
