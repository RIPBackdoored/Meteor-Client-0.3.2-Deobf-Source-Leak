package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class Autoweapon extends Module
{
    private static final String[] f37152;
    private final Settings f37153;
    private final Value<c37151.Weapon> f37154;
    private final Value<Integer> f37155;
    private final Value<Boolean> f37156;
    @EventHandler
    private Listener<c33360> f37157;
    
    public Autoweapon() {
        super(Category.Combat, "auto-weapon", "Finds the best weapon in your hotbar.");
        this.f37153 = this.f38675.m34572();
        this.f37154 = this.f37153.addValue((Value<c37151.Weapon>)new c36601.c36919<Enum>().m36926("Weapon").m36929("Which weapon to use for AutoWeapon").m36932((Enum)c37151.Weapon.Sword).m36941());
        this.f37155 = this.f37153.addValue((Value<Integer>)new c32369.c32370().m32381("threshold").m32384("If the non-prefered weapon does this much damage more then it will chose that over the prefered").m32387(4).m32408());
        this.f37156 = this.f37153.addValue((Value<Boolean>)new c34427.c34657().m34664("anti-break").m34667("Stops you from breaking your weapon.").m34670(false).m34679());
        this.f37157 = (Listener<c33360>)new Listener(this::m37169, new Predicate[0]);
    }
    
    private int m37158() {
        int selectedSlot = this.mc.player.inventory.selectedSlot;
        int selectedSlot2 = this.mc.player.inventory.selectedSlot;
        int selectedSlot3 = this.mc.player.inventory.selectedSlot;
        double n = 0.0;
        double n2 = 0.0;
        for (int i = 0; i < 9; ++i) {
            if (this.mc.player.inventory.getInvStack(i).getItem() instanceof SwordItem && (!this.f37156.m33466() || this.mc.player.inventory.getInvStack(i).getMaxDamage() - this.mc.player.inventory.getInvStack(i).getDamage() > 10)) {
                final double n3 = ((SwordItem)this.mc.player.inventory.getInvStack(i).getItem()).getMaterial().getAttackDamage() + EnchantmentHelper.getAttackDamage(this.mc.player.inventory.getInvStack(i), EntityGroup.DEFAULT) + 2.0f;
                if (n3 > n) {
                    n = n3;
                    selectedSlot = i;
                }
            }
        }
        for (int j = 0; j < 9; ++j) {
            if (this.mc.player.inventory.getInvStack(j).getItem() instanceof AxeItem && (!this.f37156.m33466() || this.mc.player.inventory.getInvStack(j).getMaxDamage() - this.mc.player.inventory.getInvStack(j).getDamage() > 10)) {
                final double n4 = ((AxeItem)this.mc.player.inventory.getInvStack(j).getItem()).getMaterial().getAttackDamage() + EnchantmentHelper.getAttackDamage(this.mc.player.inventory.getInvStack(j), EntityGroup.DEFAULT) + 2.0f;
                if (n4 > n2) {
                    n2 = n4;
                    selectedSlot2 = j;
                }
            }
        }
        if (this.f37154.m33466() == c37151.Weapon.Sword && this.f37155.m33466() > n2 - n) {
            selectedSlot3 = selectedSlot;
        }
        else if (this.f37154.m33466() == c37151.Weapon.Axe && this.f37155.m33466() > n - n2) {
            selectedSlot3 = selectedSlot2;
        }
        else if (this.f37154.m33466() == c37151.Weapon.Sword && this.f37155.m33466() < n2 - n) {
            selectedSlot3 = selectedSlot2;
        }
        else if (this.f37154.m33466() == c37151.Weapon.Axe && this.f37155.m33466() < n - n2) {
            selectedSlot3 = selectedSlot;
        }
        return selectedSlot3;
    }
    
    private /* bridge */ void m37169(final c33360 c33360) {
        this.mc.player.inventory.selectedSlot = this.m37158();
    }
    
    static {
        f37152 = new String[] { "auto-weapon", "Finds the best weapon in your hotbar.", "Weapon", "Which weapon to use for AutoWeapon", "threshold", "If the non-prefered weapon does this much damage more then it will chose that over the prefered", "anti-break", "Stops you from breaking your weapon." };
    }
}
