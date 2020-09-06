package meteorclient.modules;

import meteorclient.*;
import net.minecraft.container.*;
import minegame159.meteorclient.*;

public class Autosmelter extends Module
{
    private static final String[] f39875;
    private int f39876;
    private boolean f39877;
    private int f39878;
    private boolean f39879;
    
    public Autosmelter() {
        super(Category.Misc, "auto-smelter", "Automatically smelts all smeltable items in your inventory.");
    }
    
    @Override
    public void m35292() {
        this.f39877 = true;
        this.f39879 = false;
    }
    
    public void m39881() {
        this.f39877 = true;
        this.f39879 = false;
    }
    
    public void m39883(final AbstractFurnaceContainer abstractFurnaceContainer) {
        ++this.f39878;
        if (!this.f39877) {
            this.f39877 = true;
            this.f39876 = 0;
            this.f39878 = 0;
        }
        if (this.m39891(abstractFurnaceContainer)) {
            return;
        }
        if (abstractFurnaceContainer.getCookProgress() != 0 || this.f39878 < 5) {
            return;
        }
        if (this.f39876 == 0) {
            if (this.m39896(abstractFurnaceContainer)) {
                return;
            }
            ++this.f39876;
            this.f39878 = 0;
        }
        else if (this.f39876 == 1) {
            if (this.f39879) {
                if (abstractFurnaceContainer.slots.get(0).getStack().isEmpty()) {
                    this.f39876 = 0;
                    this.f39878 = 0;
                    this.f39879 = false;
                }
                return;
            }
            if (this.m39886(abstractFurnaceContainer)) {
                return;
            }
            this.f39879 = true;
        }
    }
    
    private boolean m39886(final AbstractFurnaceContainer abstractFurnaceContainer) {
        if (!abstractFurnaceContainer.slots.get(0).getStack().isEmpty()) {
            return true;
        }
        int n = -1;
        for (int i = 3; i < abstractFurnaceContainer.slots.size(); ++i) {
            if (((c35891)abstractFurnaceContainer).m35892(((Slot)abstractFurnaceContainer.slots.get(i)).getStack())) {
                n = i;
                break;
            }
        }
        if (n == -1) {
            c31351.m31360(this, "Disabled because you don't have any items to smelt in your inventory.", new Object[0]);
            this.m35300();
            return true;
        }
        c31671.m31675(n, 0, SlotActionType.field_7790);
        c31671.m31675(0, 0, SlotActionType.field_7790);
        return false;
    }
    
    private boolean m39891(final AbstractFurnaceContainer abstractFurnaceContainer) {
        if (abstractFurnaceContainer.getFuelProgress() <= 1 && !((c35891)abstractFurnaceContainer).m35893(abstractFurnaceContainer.slots.get(1).getStack())) {
            if (!abstractFurnaceContainer.slots.get(1).getStack().isEmpty()) {
                c31671.m31675(1, 0, SlotActionType.field_7794);
                if (!abstractFurnaceContainer.slots.get(1).getStack().isEmpty()) {
                    c31351.m31360(this, "Disabled because your inventory is full.", new Object[0]);
                    this.m35300();
                    return true;
                }
            }
            int n = -1;
            for (int i = 3; i < abstractFurnaceContainer.slots.size(); ++i) {
                if (((c35891)abstractFurnaceContainer).m35893(((Slot)abstractFurnaceContainer.slots.get(i)).getStack())) {
                    n = i;
                    break;
                }
            }
            if (n == -1) {
                c31351.m31360(this, "Disabled because you don't have any fuel in your inventory.", new Object[0]);
                this.m35300();
                return true;
            }
            c31671.m31675(n, 0, SlotActionType.field_7790);
            c31671.m31675(1, 0, SlotActionType.field_7790);
        }
        return false;
    }
    
    private boolean m39896(final AbstractFurnaceContainer abstractFurnaceContainer) {
        c31671.m31675(2, 0, SlotActionType.field_7794);
        if (!abstractFurnaceContainer.slots.get(2).getStack().isEmpty()) {
            c31351.m31360(this, "Disabled because your inventory is full.", new Object[0]);
            this.m35300();
            return true;
        }
        return false;
    }
    
    static {
        f39875 = new String[] { "auto-smelter", "Automatically smelts all smeltable items in your inventory.", "Disabled because you don't have any items to smelt in your inventory.", "Disabled because your inventory is full.", "Disabled because you don't have any fuel in your inventory.", "Disabled because your inventory is full." };
    }
}
