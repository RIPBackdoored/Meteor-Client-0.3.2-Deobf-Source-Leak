package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.container.*;
import minegame159.meteorclient.*;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.item.*;

public class Autoreplenish extends Module
{
    private static final String[] f33207;
    private final Settings f33208;
    private final Value<Integer> f33209;
    private final Value<Boolean> f33210;
    private final Value<Boolean> f33211;
    private final Value<Boolean> f33212;
    private final Value<Boolean> f33213;
    private final Value<List<class_1792>> f33214;
    private final List<class_1792> f33215;
    private Item f33216;
    private Item f33217;
    private int f33218;
    @EventHandler
    private final Listener<c36575> f33219;
    @EventHandler
    private final Listener<c31559> f33220;
    
    public Autoreplenish() {
        super(Category.Player, "auto-replenish", "Automatically fills your hotbar and offhand items");
        this.f33208 = this.f38675.m34572();
        this.f33209 = this.f33208.addValue((Value<Integer>)new c32369.c32370().m32381("amount").m32384("The amount this actives at").m32387(8).m32396(1).m32405(63).m32408());
        this.f33210 = this.f33208.addValue((Value<Boolean>)new c34427.c34657().m34664("offhand").m34667("Whether to re-fill your offhand").m34670(true).m34679());
        this.f33211 = this.f33208.addValue((Value<Boolean>)new c34427.c34657().m34664("alert").m34667("Send messages in chat when you run out of items").m34670(false).m34679());
        this.f33212 = this.f33208.addValue((Value<Boolean>)new c34427.c34657().m34664("unstackable").m34667("Replenishes unstackable items (only works for main hand and offhand)").m34670(true).m34679());
        this.f33213 = this.f33208.addValue((Value<Boolean>)new c34427.c34657().m34664("search-hotbar").m34667("Refills items if they are in your hotbar.").m34670(true).m34679());
        this.f33214 = this.f33208.addValue((Value<List<class_1792>>)new c32527.c37373().m37380("excluded-items").m37383("Items to not replenish.").m37386(new ArrayList<class_1792>(0)).m37395());
        this.f33215 = new ArrayList<class_1792>();
        this.f33219 = (Listener<c36575>)new Listener(this::m33243, new Predicate[0]);
        this.f33220 = (Listener<c31559>)new Listener(this::m33240, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f33218 = this.mc.player.inventory.selectedSlot;
    }
    
    @Override
    public void m35294() {
        final Item item = null;
        this.f33217 = item;
        this.f33216 = item;
    }
    
    private void m33221(final int n, final int n2, final boolean b) {
        c31671.m31675(c31671.m31693(n), 0, SlotActionType.field_7790);
        c31671.m31675(c31671.m31693(n2), 0, SlotActionType.field_7790);
        if (b) {
            c31671.m31675(c31671.m31693(n), 0, SlotActionType.field_7790);
        }
    }
    
    private int m33226(final Item item, final int n) {
        final int m33231 = this.m33231(item, n);
        if (m33231 == -1 && !this.f33215.contains(item)) {
            if (this.f33211.m33466()) {
                c31351.m31360(this, "You are out of (highlight)%s(default). Cannot refill.", item.toString());
            }
            this.f33215.add((class_1792)item);
        }
        return m33231;
    }
    
    private int m33231(final Item item, final int n) {
        final int n2 = -1;
        for (int i = this.f33213.m33466() ? 0 : 9; i < this.mc.player.inventory.main.size(); ++i) {
            if (i != n && ((ItemStack)this.mc.player.inventory.main.get(i)).getItem() == item && (!this.f33213.m33466() || i != this.mc.player.inventory.selectedSlot)) {
                return i;
            }
        }
        return n2;
    }
    
    private boolean m33237(final Item item) {
        return item.getMaxCount() <= 1;
    }
    
    private /* bridge */ void m33240(final c31559 c31559) {
        if (this.mc.currentScreen instanceof ContainerScreen) {
            if (!(this.mc.currentScreen instanceof AbstractInventoryScreen)) {
                this.f33215.clear();
            }
            final Item item = null;
            this.f33217 = item;
            this.f33216 = item;
        }
    }
    
    private /* synthetic */ void m33243(final c36575 c36575) {
        if (this.mc.currentScreen instanceof ContainerScreen) {
            return;
        }
        for (int i = 0; i < 9; ++i) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
            if (c31671.m31679(invStack.getItem()).f32664 >= i || i == this.mc.player.inventory.selectedSlot) {
                if (!this.m33237(invStack.getItem())) {
                    if (invStack.getItem() != Items.AIR) {
                        if (invStack.getCount() < this.f33209.m33466() && (invStack.getMaxCount() > this.f33209.m33466() || invStack.getCount() < invStack.getMaxCount())) {
                            int n = -1;
                            if (this.f33213.m33466()) {
                                for (int j = 0; j < 9; ++j) {
                                    if (this.mc.player.inventory.getInvStack(j).getItem() == invStack.getItem() && this.mc.player.inventory.selectedSlot != j && i != j) {
                                        n = j;
                                        break;
                                    }
                                }
                            }
                            if (n == -1) {
                                for (int k = 9; k < this.mc.player.inventory.main.size(); ++k) {
                                    if (this.mc.player.inventory.getInvStack(k).getItem() == invStack.getItem()) {
                                        n = k;
                                        break;
                                    }
                                }
                            }
                            if (n != -1) {
                                this.m33221(n, i, true);
                            }
                        }
                    }
                }
            }
        }
        if (this.f33210.m33466()) {
            final ItemStack offHandStack = this.mc.player.getOffHandStack();
            if (offHandStack.getItem() != Items.AIR && offHandStack.getCount() < this.f33209.m33466() && (offHandStack.getMaxCount() > this.f33209.m33466() || offHandStack.getCount() < offHandStack.getMaxCount())) {
                int n2 = -1;
                for (int l = 9; l < this.mc.player.inventory.main.size(); ++l) {
                    if (this.mc.player.inventory.getInvStack(l).getItem() == offHandStack.getItem()) {
                        n2 = l;
                        break;
                    }
                }
                if (this.f33213.m33466() && n2 == -1) {
                    for (int n3 = 0; n3 < 9; ++n3) {
                        if (this.mc.player.inventory.getInvStack(n3).getItem() == offHandStack.getItem()) {
                            n2 = n3;
                            break;
                        }
                    }
                }
                if (n2 != -1) {
                    this.m33221(n2, 45, true);
                }
            }
        }
        if (this.f33212.m33466()) {
            final ItemStack mainHandStack = this.mc.player.getMainHandStack();
            if (mainHandStack.getItem() != this.f33216 && !this.f33214.m33466().contains(this.f33216) && mainHandStack.isEmpty() && this.f33216 != null && this.f33216 != Items.AIR && this.m33237(this.f33216) && this.mc.player.inventory.selectedSlot == this.f33218) {
                final int m33226 = this.m33226(this.f33216, this.f33218);
                if (m33226 != -1) {
                    this.m33221(m33226, this.f33218, false);
                }
            }
            this.f33216 = this.mc.player.getMainHandStack().getItem();
            this.f33218 = this.mc.player.inventory.selectedSlot;
            if (this.f33210.m33466()) {
                final ItemStack offHandStack2 = this.mc.player.getOffHandStack();
                if (offHandStack2.getItem() != this.f33217 && !this.f33214.m33466().contains(this.f33217) && offHandStack2.isEmpty() && this.f33217 != null && this.f33217 != Items.AIR && this.m33237(this.f33217)) {
                    final int m33227 = this.m33226(this.f33217, 45);
                    if (m33227 != -1) {
                        this.m33221(m33227, 45, false);
                    }
                }
                this.f33217 = this.mc.player.getOffHandStack().getItem();
            }
        }
    }
    
    static {
        f33207 = new String[] { "auto-replenish", "Automatically fills your hotbar and offhand items", "amount", "The amount this actives at", "offhand", "Whether to re-fill your offhand", "alert", "Send messages in chat when you run out of items", "unstackable", "Replenishes unstackable items (only works for main hand and offhand)", "search-hotbar", "Refills items if they are in your hotbar.", "excluded-items", "Items to not replenish.", "You are out of (highlight)%s(default). Cannot refill." };
    }
}
