package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.enchantment.*;
import net.minecraft.container.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.screen.ingame.*;
import minegame159.meteorclient.*;

public class Automend extends Module
{
    private static final String[] f35319;
    private final Settings f35320;
    private final Value<Boolean> f35321;
    private final Value<Boolean> f35322;
    private final Value<Boolean> f35323;
    @EventHandler
    private final Listener<c36575> f35324;
    
    public Automend() {
        super(Category.Player, "auto-mend", "Automatically replaces equipped items and items in offhand with mending when fully repaired.");
        this.f35320 = this.f38675.m34572();
        this.f35321 = this.f35320.addValue((Value<Boolean>)new c34427.c34657().m34664("swords").m34667("Move swords.").m34670(true).m34679());
        this.f35322 = this.f35320.addValue((Value<Boolean>)new c34427.c34657().m34664("use-armour-slots").m34667("Whether to use armour slots to mend items faster").m34670(true).m34679());
        this.f35323 = this.f35320.addValue((Value<Boolean>)new c34427.c34657().m34664("remove-finished").m34667("If there are no items to replace but space in your inventory, the items will be moved out of active slots").m34670(true).m34679());
        this.f35324 = (Listener<c36575>)new Listener(this::m35341, new Predicate[0]);
    }
    
    private void m35325(final boolean b) {
        for (int i = 0; i < this.mc.player.inventory.main.size(); ++i) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
            if (EnchantmentHelper.getLevel(Enchantments.field_9101, invStack) != 0) {
                if (invStack.isDamaged()) {
                    if (this.f35321.m33466() || !(invStack.getItem() instanceof SwordItem)) {
                        c31671.m31675(c31671.m31693(i), 0, SlotActionType.field_7790);
                        c31671.m31675(45, 0, SlotActionType.field_7790);
                        if (!b) {
                            c31671.m31675(c31671.m31693(i), 0, SlotActionType.field_7790);
                            break;
                        }
                        break;
                    }
                }
            }
        }
        if (!this.mc.player.getOffHandStack().isDamaged() && this.f35323.m33466() && this.mc.player.inventory.getEmptySlot() != -1) {
            c31671.m31675(45, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
        }
    }
    
    private boolean m35330(final ItemStack itemStack, final int n) {
        boolean b = false;
        if (n == 5 && ((ArmorItem)itemStack.getItem()).getSlotType() == EquipmentSlot.field_6169) {
            b = true;
        }
        else if (n == 6 && ((ArmorItem)itemStack.getItem()).getSlotType() == EquipmentSlot.field_6174) {
            b = true;
        }
        else if (n == 7 && ((ArmorItem)itemStack.getItem()).getSlotType() == EquipmentSlot.field_6172) {
            b = true;
        }
        else if (n == 8 && ((ArmorItem)itemStack.getItem()).getSlotType() == EquipmentSlot.field_6166) {
            b = true;
        }
        return b;
    }
    
    private void m35335(final int n, final boolean b) {
        for (int i = 0; i < this.mc.player.inventory.main.size(); ++i) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
            if (invStack.getItem() instanceof ArmorItem) {
                if (this.m35330(this.mc.player.inventory.getInvStack(i), n)) {
                    if (EnchantmentHelper.getLevel(Enchantments.field_9101, invStack) != 0) {
                        if (invStack.isDamaged()) {
                            c31671.m31675(c31671.m31693(i), 0, SlotActionType.field_7790);
                            c31671.m31675(n, 0, SlotActionType.field_7790);
                            if (!b) {
                                c31671.m31675(c31671.m31693(i), 0, SlotActionType.field_7790);
                                break;
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (!this.mc.player.inventory.getInvStack(39 - (n - 5)).isDamaged() && this.f35323.m33466() && this.mc.player.inventory.getEmptySlot() != -1) {
            c31671.m31675(n, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
        }
    }
    
    private /* synthetic */ void m35341(final c36575 c36575) {
        if (this.mc.currentScreen instanceof ContainerScreen) {
            return;
        }
        if (this.mc.player.getOffHandStack().isEmpty()) {
            this.m35325(true);
        }
        else if (!this.mc.player.getOffHandStack().isDamaged()) {
            this.m35325(false);
        }
        else if (EnchantmentHelper.getLevel(Enchantments.field_9101, this.mc.player.getOffHandStack()) == 0) {
            this.m35325(false);
        }
        if (this.f35322.m33466()) {
            if (c34030.f34033.m34042(Autoarmor.class).m35315()) {
                c31351.m31360(this, "Cannot use armor slots while AutoArmor is active. Please disable AutoArmor and try again. Disabling Use Armor Slots.", new Object[0]);
                this.f35322.m33468(false);
            }
            for (int i = 5; i < 9; ++i) {
                if (this.mc.player.inventory.getInvStack(39 - (i - 5)).isEmpty()) {
                    this.m35335(i, true);
                }
                else if (!this.mc.player.inventory.getInvStack(39 - (i - 5)).isDamaged()) {
                    this.m35335(i, false);
                }
                else if (EnchantmentHelper.getLevel(Enchantments.field_9101, this.mc.player.inventory.getInvStack(39 - (i - 5))) == 0) {
                    this.m35335(i, false);
                }
            }
        }
    }
    
    static {
        f35319 = new String[] { "auto-mend", "Automatically replaces equipped items and items in offhand with mending when fully repaired.", "swords", "Move swords.", "use-armour-slots", "Whether to use armour slots to mend items faster", "remove-finished", "If there are no items to replace but space in your inventory, the items will be moved out of active slots", "Cannot use armor slots while AutoArmor is active. Please disable AutoArmor and try again. Disabling Use Armor Slots." };
    }
}
