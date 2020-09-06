package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.container.*;
import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import java.util.*;

public class Autoexp extends Module
{
    private static final String[] f32413;
    private final Settings f32414;
    private final Value<Boolean> f32415;
    private final Value<Integer> f32416;
    private final Value<Boolean> f32417;
    private final Value<Boolean> f32418;
    private final Value<Boolean> f32419;
    private boolean f32420;
    private boolean f32421;
    private boolean f32422;
    private float f32423;
    @EventHandler
    private final Listener<c36575> f32424;
    
    public Autoexp() {
        super(Category.Combat, "auto-exp", "Throws exp to mend your armour (only works with diamond)");
        this.f32414 = this.f38675.m34572();
        this.f32415 = this.f32414.addValue((Value<Boolean>)new c34427.c34657().m34664("replenish").m34667("Replenishes your hotbar with Exp Bottles").m34670(true).m34679());
        this.f32416 = this.f32414.addValue((Value<Integer>)new c32369.c32370().m32381("items-left").m32384("The number of items before the stack gets replenished").m32387(32).m32396(1).m32405(63).m32408());
        this.f32417 = this.f32414.addValue((Value<Boolean>)new c34427.c34657().m34664("disable-auras").m34667("Disable all auras").m34670(false).m34679());
        this.f32418 = this.f32414.addValue((Value<Boolean>)new c34427.c34657().m34664("look-down").m34667("Looks down when throwing exp bottles").m34670(true).m34679());
        this.f32419 = this.f32414.addValue((Value<Boolean>)new c34427.c34657().m34664("disable-on-damage").m34667("Disables this when you take damage").m34670(true).m34679());
        this.f32420 = false;
        this.f32421 = false;
        this.f32422 = false;
        this.f32424 = (Listener<c36575>)new Listener(this::m32438, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        if (c34030.f34033.m34042(Autoarmor.class).m35315()) {
            this.f32420 = true;
            c34030.f34033.m34042(Autoarmor.class).m35300();
        }
        if (this.f32417.m33466()) {
            if (c34030.f34033.m34042(Killaura.class).m35315()) {
                this.f32421 = true;
                c34030.f34033.m34042(Killaura.class).m35300();
            }
            if (c34030.f34033.m34042(Crystalaura.class).m35315()) {
                this.f32422 = true;
                c34030.f34033.m34042(Crystalaura.class).m35300();
            }
        }
        this.f32423 = this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount();
    }
    
    @Override
    public void m35294() {
        if (this.f32420) {
            c34030.f34033.m34042(Autoarmor.class).m35300();
            this.f32420 = false;
        }
        if (this.f32421) {
            c34030.f34033.m34042(Killaura.class).m35300();
            this.f32421 = false;
        }
        if (this.f32422) {
            c34030.f34033.m34042(Crystalaura.class).m35300();
            this.f32422 = false;
        }
    }
    
    private int m32425(final Item item) {
        for (int i = 0; i < this.mc.player.inventory.getInvSize(); ++i) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
            if (invStack.isDamaged() && invStack.getItem() == item && EnchantmentHelper.getLevel(Enchantments.field_9101, invStack) >= 1) {
                return i;
            }
        }
        return -1;
    }
    
    private int m32430() {
        int n = -1;
        for (int i = 0; i < 9; ++i) {
            if (this.mc.player.inventory.getInvStack(i).getItem() == Items.field_8287) {
                n = i;
            }
        }
        return n;
    }
    
    private int m32434() {
        int n = -1;
        for (int i = 0; i < 5; ++i) {
            c31671.m31675(i, 0, SlotActionType.field_7790);
            if (this.mc.player.inventory.getCursorStack().isEmpty()) {
                n = i;
            }
            else {
                c31671.m31675(i, 0, SlotActionType.field_7790);
            }
        }
        return n;
    }
    
    private /* synthetic */ void m32438(final c36575 c36575) {
        if (this.f32423 > this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount() && this.f32419.m33466()) {
            this.m35294();
        }
        else if (this.f32419.m33466()) {
            this.f32423 = this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount();
        }
        final Iterator<ItemStack> iterator = this.mc.player.getArmorItems().iterator();
        final ItemStack itemStack = iterator.next();
        final ItemStack itemStack2 = iterator.next();
        final ItemStack itemStack3 = iterator.next();
        final ItemStack itemStack4 = iterator.next();
        if (!itemStack.isDamaged() && !itemStack2.isDamaged() && !itemStack3.isDamaged() && !itemStack4.isDamaged() && this.m32425(Items.field_8285) == -1 && this.m32425(Items.field_8348) == -1 && this.m32425(Items.field_8058) == -1 && this.m32425(Items.field_8805) == -1) {
            this.m35300();
            c31351.m31360(this, "No broken armor with mending. Disabling!", new Object[0]);
            return;
        }
        final int m32430 = this.m32430();
        if (m32430 == -1) {
            c31351.m31360(this, "No Exp in hotbar. Disabling!", new Object[0]);
            this.m35300();
        }
        else if (this.mc.player.inventory.getInvStack(m32430).getCount() < this.f32416.m33466() && this.f32415.m33466()) {
            for (int i = 9; i < 36; ++i) {
                if (this.mc.player.inventory.getInvStack(i).getItem() == Items.field_8287) {
                    c31671.m31675(c31671.m31693(i), 0, SlotActionType.field_7790);
                    c31671.m31675(c31671.m31693(m32430), 0, SlotActionType.field_7790);
                    c31671.m31675(c31671.m31693(i), 0, SlotActionType.field_7790);
                }
            }
        }
        else {
            this.mc.player.inventory.selectedSlot = m32430;
        }
        final int m32431 = this.m32425(Items.field_8285);
        final boolean empty = itemStack.isEmpty();
        if (!itemStack.isDamaged() && m32431 != -1) {
            c31671.m31675(8, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(m32431), 0, SlotActionType.field_7790);
            if (!empty) {
                c31671.m31675(8, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack.isDamaged() && m32431 == -1 && this.mc.player.inventory.getEmptySlot() != -1) {
            c31671.m31675(8, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
            if (!empty) {
                c31671.m31675(8, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack.isDamaged() && m32431 == -1 && this.mc.player.inventory.getEmptySlot() == -1) {
            c31671.m31675(8, 0, SlotActionType.field_7790);
            c31671.m31675(this.m32434(), 0, SlotActionType.field_7790);
        }
        final int m32432 = this.m32425(Items.field_8348);
        final boolean empty2 = itemStack2.isEmpty();
        if (!itemStack2.isDamaged() && m32432 != -1) {
            c31671.m31675(7, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(m32432), 0, SlotActionType.field_7790);
            if (!empty2) {
                c31671.m31675(7, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack2.isDamaged() && m32432 == -1 && this.mc.player.inventory.getEmptySlot() != -1) {
            c31671.m31675(7, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
            if (!empty2) {
                c31671.m31675(7, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack2.isDamaged() && m32432 == -1 && this.mc.player.inventory.getEmptySlot() == -1) {
            c31671.m31675(7, 0, SlotActionType.field_7790);
            c31671.m31675(this.m32434(), 0, SlotActionType.field_7790);
        }
        final int m32433 = this.m32425(Items.field_8058);
        final boolean empty3 = itemStack3.isEmpty();
        if (!itemStack3.isDamaged() && m32433 != -1) {
            c31671.m31675(6, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(m32433), 0, SlotActionType.field_7790);
            if (!empty3) {
                c31671.m31675(6, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack3.isDamaged() && m32433 == -1 && this.mc.player.inventory.getEmptySlot() != -1) {
            c31671.m31675(6, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
            if (!empty3) {
                c31671.m31675(6, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack3.isDamaged() && m32433 == -1 && this.mc.player.inventory.getEmptySlot() == -1) {
            c31671.m31675(6, 0, SlotActionType.field_7790);
            c31671.m31675(this.m32434(), 0, SlotActionType.field_7790);
        }
        final int m32434 = this.m32425(Items.field_8805);
        final boolean empty4 = itemStack4.isEmpty();
        if (!itemStack4.isDamaged() && m32434 != -1) {
            c31671.m31675(5, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(m32434), 0, SlotActionType.field_7790);
            if (!empty4) {
                c31671.m31675(5, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack4.isDamaged() && m32434 == -1 && this.mc.player.inventory.getEmptySlot() != -1) {
            c31671.m31675(5, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
            if (!empty4) {
                c31671.m31675(5, 0, SlotActionType.field_7790);
            }
        }
        else if (!itemStack4.isDamaged() && m32434 == -1 && this.mc.player.inventory.getEmptySlot() == -1) {
            c31671.m31675(5, 0, SlotActionType.field_7790);
            c31671.m31675(this.m32434(), 0, SlotActionType.field_7790);
        }
        if (this.f32418.m33466()) {
            this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(this.mc.player.yaw, 90.0f, this.mc.player.onGround));
        }
        this.mc.interactionManager.interactItem((PlayerEntity)this.mc.player, (World)this.mc.world, Hand.field_5808);
    }
    
    static {
        f32413 = new String[] { "auto-exp", "Throws exp to mend your armour (only works with diamond)", "replenish", "Replenishes your hotbar with Exp Bottles", "items-left", "The number of items before the stack gets replenished", "disable-auras", "Disable all auras", "look-down", "Looks down when throwing exp bottles", "disable-on-damage", "Disables this when you take damage", "No broken armor with mending. Disabling!", "No Exp in hotbar. Disabling!" };
    }
}
