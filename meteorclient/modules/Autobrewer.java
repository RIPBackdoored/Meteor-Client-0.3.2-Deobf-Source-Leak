package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.container.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;

public class Autobrewer extends Module
{
    private static final String[] f32121;
    private final Settings f32122;
    private final Value<MyPotion> f32123;
    private final Value<c32120.Modifier> f32124;
    private int f32125;
    private boolean f32126;
    private int f32127;
    
    public Autobrewer() {
        super(Category.Misc, "auto-brewer", "Automatically brews potions.");
        this.f32122 = this.f38675.m34572();
        this.f32123 = this.f32122.addValue(new c37436.c37437().m36926("potion").m36929("Potion to brew.").m36932(MyPotion.Strength).m36941());
        this.f32124 = this.f32122.addValue((Value<c32120.Modifier>)new c36601.c36919<Enum>().m36926("modifier").m36929("Modifier.").m36932((Enum)c32120.Modifier.None).m36941());
    }
    
    @Override
    public void m35292() {
        this.f32126 = false;
    }
    
    public void m32128() {
        this.f32126 = false;
    }
    
    public void m32130(final BrewingStandContainer brewingStandContainer) {
        ++this.f32127;
        if (!this.f32126) {
            this.f32126 = true;
            this.f32125 = -2;
            this.f32127 = 0;
        }
        if (brewingStandContainer.getBrewTime() != 0 || this.f32127 < 5) {
            return;
        }
        if (this.f32125 == -2) {
            if (this.m32163(brewingStandContainer)) {
                return;
            }
            ++this.f32125;
            this.f32127 = 0;
        }
        else if (this.f32125 == -1) {
            if (this.m32156(brewingStandContainer)) {
                return;
            }
            ++this.f32125;
            this.f32127 = 0;
        }
        else if (this.f32125 < this.f32123.m33466().ingredients.length) {
            if (this.m32146(brewingStandContainer)) {
                return;
            }
            if (this.m32140(brewingStandContainer, (Item)this.f32123.m33466().ingredients[this.f32125])) {
                return;
            }
            ++this.f32125;
            this.f32127 = 0;
        }
        else if (this.f32125 == this.f32123.m33466().ingredients.length) {
            if (this.m32133(brewingStandContainer)) {
                return;
            }
            ++this.f32125;
            this.f32127 = 0;
        }
        else {
            this.f32125 = -2;
            this.f32127 = 0;
        }
    }
    
    private boolean m32133(final BrewingStandContainer brewingStandContainer) {
        if (this.f32124.m33466() != c32120.Modifier.None) {
            Item item;
            if (this.f32124.m33466() == c32120.Modifier.Splash) {
                item = Items.field_8054;
            }
            else {
                item = Items.field_8613;
            }
            int n = -1;
            for (int i = 5; i < brewingStandContainer.slots.size(); ++i) {
                if (((Slot)brewingStandContainer.slots.get(i)).getStack().getItem() == item) {
                    n = i;
                    break;
                }
            }
            if (n == -1) {
                c31351.m31360(this, "Disabled because you don't have any %s left in your inventory.", item.getName().asString());
                this.m35300();
                return true;
            }
            this.m32151(brewingStandContainer, n, 3);
        }
        return false;
    }
    
    private boolean m32140(final BrewingStandContainer brewingStandContainer, final Item item) {
        int n = -1;
        for (int i = 5; i < brewingStandContainer.slots.size(); ++i) {
            if (((Slot)brewingStandContainer.slots.get(i)).getStack().getItem() == item) {
                n = i;
                break;
            }
        }
        if (n == -1) {
            c31351.m31360(this, "Disabled because you don't have any %s left in your inventory.", item.getName().asString());
            this.m35300();
            return true;
        }
        this.m32151(brewingStandContainer, n, 3);
        return false;
    }
    
    private boolean m32146(final BrewingStandContainer brewingStandContainer) {
        if (brewingStandContainer.getFuel() == 0) {
            int n = -1;
            for (int i = 5; i < brewingStandContainer.slots.size(); ++i) {
                if (((Slot)brewingStandContainer.slots.get(i)).getStack().getItem() == Items.field_8183) {
                    n = i;
                    break;
                }
            }
            if (n == -1) {
                c31351.m31360(this, "Disabled because you don't have any blaze powder (as fuel) left in your inventory.", new Object[0]);
                this.m35300();
                return true;
            }
            this.m32151(brewingStandContainer, n, 4);
        }
        return false;
    }
    
    private void m32151(final BrewingStandContainer brewingStandContainer, final int n, final int n2) {
        this.mc.interactionManager.method_2906(brewingStandContainer.syncId, n, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
        this.mc.interactionManager.method_2906(brewingStandContainer.syncId, n2, 1, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
        this.mc.interactionManager.method_2906(brewingStandContainer.syncId, n, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
    }
    
    private boolean m32156(final BrewingStandContainer brewingStandContainer) {
        for (int i = 0; i < 3; ++i) {
            int n = -1;
            for (int j = 5; j < brewingStandContainer.slots.size(); ++j) {
                if (((Slot)brewingStandContainer.slots.get(j)).getStack().getItem() == Items.field_8574 && PotionUtil.getPotion(((Slot)brewingStandContainer.slots.get(j)).getStack()) == Potions.field_8991) {
                    n = j;
                    break;
                }
            }
            if (n == -1) {
                c31351.m31360(this, "Disabled because you don't have any water bottles left in your inventory.", new Object[0]);
                this.m35300();
                return true;
            }
            this.mc.interactionManager.method_2906(brewingStandContainer.syncId, n, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
            this.mc.interactionManager.method_2906(brewingStandContainer.syncId, i, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
        }
        return false;
    }
    
    private boolean m32163(final BrewingStandContainer brewingStandContainer) {
        for (int i = 0; i < 3; ++i) {
            this.mc.interactionManager.method_2906(brewingStandContainer.syncId, i, 0, SlotActionType.field_7794, (PlayerEntity)this.mc.player);
            if (!((Slot)brewingStandContainer.slots.get(i)).getStack().isEmpty()) {
                c31351.m31360(this, "Disabled because your inventory is full.", new Object[0]);
                this.m35300();
                return true;
            }
        }
        return false;
    }
    
    static {
        f32121 = new String[] { "auto-brewer", "Automatically brews potions.", "potion", "Potion to brew.", "modifier", "Modifier.", "Disabled because you don't have any %s left in your inventory.", "Disabled because you don't have any %s left in your inventory.", "Disabled because you don't have any blaze powder (as fuel) left in your inventory.", "Disabled because you don't have any water bottles left in your inventory.", "Disabled because your inventory is full." };
    }
}
