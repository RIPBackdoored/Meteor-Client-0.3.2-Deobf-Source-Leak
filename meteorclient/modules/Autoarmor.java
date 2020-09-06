package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.entity.decoration.*;
import net.minecraft.entity.*;
import net.minecraft.world.dimension.*;
import net.minecraft.block.entity.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.client.gui.screen.ingame.*;
import minegame159.meteorclient.*;
import net.minecraft.container.*;

public class Autoarmor extends Module
{
    private static final String[] f36948;
    private final Settings f36949;
    private final Value<c36947.Prot> f36950;
    private final Value<Boolean> f36951;
    private final Value<Boolean> f36952;
    private final Value<Boolean> f36953;
    private final Value<Integer> f36954;
    private final Value<List<class_1887>> f36955;
    private final Value<Boolean> f36956;
    private final Value<Boolean> f36957;
    private final Value<Integer> f36958;
    private final Value<Boolean> f36959;
    private final Value<Integer> f36960;
    private final Value<Boolean> f36961;
    private final Value<Integer> f36962;
    private final Value<Integer> f36963;
    private int f36964;
    private boolean f36965;
    @EventHandler
    private final Listener<c36575> f36966;
    
    public Autoarmor() {
        super(Category.Combat, "auto-armor", "Manages your armor for you.");
        this.f36949 = this.f38675.m34572();
        this.f36950 = this.f36949.addValue((Value<c36947.Prot>)new c36601.c36919<Enum>().m36926("prioritize").m36929("Which protection to prioritize.").m36932((Enum)c36947.Prot.Protection).m36941());
        this.f36951 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("pause-in-inventory").m34667("Stops moving armour when you are in an inventory").m34670(false).m34679());
        this.f36952 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("blast-protection-leggings").m34667("Prioritizes blast protection on leggings").m34670(true).m34679());
        this.f36953 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("prefer-mending").m34667("Prefers to equip mending than non mending.").m34670(true).m34679());
        this.f36954 = this.f36949.addValue((Value<Integer>)new c32369.c32370().m32381("weight").m32384("How preferred mending is.").m32387(2).m32396(1).m32399(10).m32405(4).m32408());
        this.f36955 = this.f36949.addValue((Value<List<class_1887>>)new c38020.c38993().m39000("avoided-enchantments").m39003("Enchantments that will only be equipped as a last resort.").m39006(this.m36977()).m39015());
        this.f36956 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("ban-binding").m34667("Stops you from putting on any item with Curse of Binding").m34670(false).m34679());
        this.f36957 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("anti-break").m34667("Tries to stop your armor getting broken.").m34670(true).m34679());
        this.f36958 = this.f36949.addValue((Value<Integer>)new c32369.c32370().m32381("break-durability").m32384("The durability damaged armor is swapped.").m32387(10).m32399(50).m32396(2).m32405(20).m32408());
        this.f36959 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("pause-between-pieces").m34667("Pauses between each individual piece being moved.(helps prevent desync)").m34670(true).m34679());
        this.f36960 = this.f36949.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("The delay between pieces being moved.(helps prevent desync)").m32387(1).m32396(0).m32399(20).m32405(5).m32408());
        this.f36961 = this.f36949.addValue((Value<Boolean>)new c34427.c34657().m34664("switch-for-explosion").m34667("Switches to Blast Protection automatically if you're going to get hit by an explosion").m34670(false).m34679());
        this.f36962 = this.f36949.addValue((Value<Integer>)new c32369.c32370().m32381("max-explosion-damage").m32384("The maximum damage you will take before switching to Blast Protection.").m32387(5).m32396(1).m32399(18).m32405(10).m32408());
        this.f36963 = this.f36949.addValue((Value<Integer>)new c32369.c32370().m32381("switch-cooldown").m32384("A cooldown before switching from an automatically switched protection to your chosen protection.").m32387(20).m32396(0).m32399(60).m32405(40).m32408());
        this.f36964 = this.f36960.m33466();
        this.f36965 = false;
        this.f36966 = (Listener<c36575>)new Listener(this::m36980, new Predicate[0]);
    }
    
    private int m36967(final ItemStack itemStack) {
        final int n = 0;
        if (this.f36957.m33466() && itemStack.getMaxDamage() - itemStack.getDamage() <= this.f36958.m33466()) {
            return 0;
        }
        if (this.f36956.m33466() && EnchantmentHelper.hasBindingCurse(itemStack)) {
            return -10;
        }
        final Iterator<class_1887> iterator = this.f36955.m33466().iterator();
        Enchantment enchantment = (Enchantment)iterator.next();
        while (iterator.hasNext()) {
            if (EnchantmentHelper.getLevel(enchantment, itemStack) > 0) {
                return 1;
            }
            enchantment = (Enchantment)iterator.next();
        }
        int n2 = n + 8 * EnchantmentHelper.getLevel(c36947.Prot.access$000((c36947.Prot)this.f36950.m33466()), itemStack) + 2 * EnchantmentHelper.getLevel(Enchantments.field_9111, itemStack) + 2 * EnchantmentHelper.getLevel(Enchantments.field_9107, itemStack) + 2 * EnchantmentHelper.getLevel(Enchantments.field_9095, itemStack) + 2 * EnchantmentHelper.getLevel(Enchantments.field_9096, itemStack) + 2 * ((ArmorItem)itemStack.getItem()).getProtection() + EnchantmentHelper.getLevel(Enchantments.field_9119, itemStack);
        if (this.f36953.m33466() && EnchantmentHelper.getLevel(Enchantments.field_9101, itemStack) > 0) {
            n2 += this.f36954.m33466();
        }
        return n2;
    }
    
    private boolean m36973() {
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity instanceof EnderCrystalEntity && c36537.m36539((LivingEntity)this.mc.player, entity.getPos()) > this.f36962.m33466()) {
                return true;
            }
        }
        if (this.mc.world.dimension.getType() != DimensionType.field_13072) {
            for (final BlockEntity blockEntity : this.mc.world.blockEntities) {
                if (blockEntity instanceof BedBlockEntity && c36537.m36546((LivingEntity)this.mc.player, new Vec3d((Vec3i)blockEntity.getPos())) > this.f36962.m33466()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private List<class_1887> m36977() {
        final ArrayList<Enchantment> list = (ArrayList<Enchantment>)new ArrayList<class_1887>();
        list.add((class_1887)Enchantments.field_9113);
        list.add((class_1887)Enchantments.field_9122);
        return (List<class_1887>)list;
    }
    
    private /* synthetic */ void m36980(final c36575 c36575) {
        if (this.mc.player.abilities.creativeMode) {
            return;
        }
        if (this.f36951.m33466() && this.mc.currentScreen instanceof InventoryScreen) {
            return;
        }
        if (this.f36961.m33466() && this.f36950.m33466() != c36947.Prot.Blast_Protection && this.m36973()) {
            this.f36950.m33468(c36947.Prot.Blast_Protection);
            this.f36964 = 0;
            this.f36965 = true;
        }
        if (this.f36964 > 0) {
            --this.f36964;
            return;
        }
        this.f36964 = this.f36960.m33466();
        final c36947.Prot prot = this.f36950.m33466();
        if (this.f36965) {
            this.f36964 = this.f36963.m33466();
            this.f36965 = false;
        }
        for (int i = 0; i < 4; ++i) {
            int m36967 = 0;
            final ItemStack armorStack = this.mc.player.inventory.getArmorStack(i);
            if (!EnchantmentHelper.hasBindingCurse(armorStack)) {
                if (armorStack.getItem() instanceof ArmorItem) {
                    if (i == 1 && this.f36952.m33466()) {
                        this.f36950.m33468(c36947.Prot.Blast_Protection);
                    }
                    m36967 = this.m36967(armorStack);
                }
                int n = -1;
                int n2 = 0;
                for (int j = 0; j < 36; ++j) {
                    final ItemStack invStack = this.mc.player.inventory.getInvStack(j);
                    if (invStack.getItem() instanceof ArmorItem && ((ArmorItem)invStack.getItem()).getSlotType().getEntitySlotId() == i) {
                        final int m36968 = this.m36967(invStack);
                        if (n2 < m36968) {
                            n2 = m36968;
                            n = j;
                        }
                    }
                }
                if (n2 > m36967 && n > -1) {
                    c31671.m31675(c31671.m31693(n), 0, SlotActionType.field_7790);
                    c31671.m31675(8 - i, 0, SlotActionType.field_7790);
                    c31671.m31675(c31671.m31693(n), 0, SlotActionType.field_7790);
                    if (this.f36959.m33466()) {
                        break;
                    }
                }
                this.f36950.m33468(prot);
            }
        }
    }
    
    static {
        f36948 = new String[] { "auto-armor", "Manages your armor for you.", "prioritize", "Which protection to prioritize.", "pause-in-inventory", "Stops moving armour when you are in an inventory", "blast-protection-leggings", "Prioritizes blast protection on leggings", "prefer-mending", "Prefers to equip mending than non mending.", "weight", "How preferred mending is.", "avoided-enchantments", "Enchantments that will only be equipped as a last resort.", "ban-binding", "Stops you from putting on any item with Curse of Binding", "anti-break", "Tries to stop your armor getting broken.", "break-durability", "The durability damaged armor is swapped.", "pause-between-pieces", "Pauses between each individual piece being moved.(helps prevent desync)", "delay", "The delay between pieces being moved.(helps prevent desync)", "switch-for-explosion", "Switches to Blast Protection automatically if you're going to get hit by an explosion", "max-explosion-damage", "The maximum damage you will take before switching to Blast Protection.", "switch-cooldown", "A cooldown before switching from an automatically switched protection to your chosen protection." };
    }
}
