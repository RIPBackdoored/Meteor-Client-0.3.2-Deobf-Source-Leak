package minegame159.meteorclient.mixin;

import net.minecraft.client.gui.screen.recipebook.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.*;
import net.minecraft.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.widget.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.entity.player.*;
import net.minecraft.container.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.client.gui.screen.*;

@Mixin({ class_479.class })
public abstract class CraftingTableScreenMixin extends class_465<class_1714>
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    @Final
    private RecipeBookWidget field_2880;
    @Shadow
    private boolean field_2877;
    private MinecraftClient mc;
    private ButtonWidget autoCraftBtn;
    private ButtonWidget configBtn;
    private boolean autoCrafting;
    private int craftingI;
    private class_1792[] ingredients;
    private int timer;
    
    public CraftingTableScreenMixin(final CraftingTableContainer craftingTableContainer, final PlayerInventory playerInventory, final Text text) {
        super((Container)craftingTableContainer, playerInventory, text);
        this.ingredients = (class_1792[])new Item[9];
    }
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        this.mc = MinecraftClient.getInstance();
        this.autoCrafting = false;
        this.craftingI = 0;
        this.autoCraftBtn = (ButtonWidget)this.addButton((AbstractButtonWidget)new ButtonWidget(this.x + 30 + 54 + 4, this.y + 16, 70, 13, "Auto craft", this::lambda$onInit$0));
        this.configBtn = (ButtonWidget)this.addButton((AbstractButtonWidget)new ButtonWidget(this.x + 30 + 54 + 4, this.y + 17 + 40, 70, 13, "Config", CraftingTableScreenMixin::lambda$onInit$1));
    }
    
    private void onAutoCraft() {
        if (!this.autoCrafting) {
            if (this.getStack(0).isEmpty()) {
                c31351.m31371("Invalid recipe.", new Object[0]);
            }
            else {
                this.autoCrafting = true;
                this.craftingI = 0;
                for (int i = 1; i < 10; ++i) {
                    this.ingredients[i - 1] = (class_1792)this.getStack(i).getItem();
                }
                this.autoCraftBtn.setMessage("Stop crafting");
            }
        }
        else {
            this.stopCrafting(null);
        }
    }
    
    @Inject(method = { "tick" }, at = { @At("TAIL") })
    private void onTick(final CallbackInfo callbackInfo) {
        final int n = this.recipeBookGui.findLeftEdge(this.isNarrow, this.width, this.containerWidth) + 30 + 54 + 4;
        this.autoCraftBtn.x = n;
        this.configBtn.x = n;
        if (this.autoCrafting) {
            ++this.timer;
            if (this.craftingI == 0) {
                this.mc.interactionManager.method_2906(((CraftingTableContainer)this.container).syncId, 0, 0, SlotActionType.field_7794, (PlayerEntity)this.mc.player);
                if (!this.getStack(0).isEmpty()) {
                    this.stopCrafting("Stopped because your inventory is full.");
                    return;
                }
                ++this.craftingI;
                this.timer = 0;
            }
            else {
                if (this.getStack(this.craftingI).isEmpty() && this.findIngredients(this.craftingI) && c33436.f34122.f34125.m33450()) {
                    this.stopCrafting("Stopped because you have ran out of ingredients.");
                }
                ++this.craftingI;
                if (this.craftingI >= 10) {
                    this.craftingI = 0;
                }
                this.timer = 0;
            }
        }
    }
    
    private boolean findIngredients(final int n) {
        if (this.ingredients[n - 1] == Items.AIR) {
            return false;
        }
        int n2 = -1;
        for (int i = 10; i < ((CraftingTableContainer)this.container).slots.size(); ++i) {
            if (this.getStack(i).getItem() == this.ingredients[n - 1]) {
                n2 = i;
                break;
            }
        }
        if (n2 == -1) {
            return true;
        }
        this.moveIngredients(n2, n);
        return false;
    }
    
    private void moveIngredients(final int n, final int n2) {
        this.mc.interactionManager.method_2906(((CraftingTableContainer)this.container).syncId, n, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
        if (c33436.f34122.f34125.m33445()) {
            this.mc.interactionManager.method_2906(((CraftingTableContainer)this.container).syncId, n2, 1, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
            this.mc.interactionManager.method_2906(((CraftingTableContainer)this.container).syncId, n, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
        }
        else {
            this.mc.interactionManager.method_2906(((CraftingTableContainer)this.container).syncId, n2, 0, SlotActionType.field_7790, (PlayerEntity)this.mc.player);
        }
    }
    
    @Inject(method = { "onMouseClick" }, at = { @At("TAIL") })
    private void onMouseClick(final Slot slot, final int n, final int n2, final SlotActionType slotActionType, final CallbackInfo callbackInfo) {
        if (this.autoCrafting) {
            this.stopCrafting(null);
        }
    }
    
    private void stopCrafting(final String s) {
        if (s != null) {
            c31351.m31357(s, new Object[0]);
        }
        this.autoCrafting = false;
        this.autoCraftBtn.setMessage("Auto craft");
    }
    
    private ItemStack getStack(final int n) {
        final ItemStack stack = ((CraftingTableContainer)this.container).getSlot(n).getStack();
        return (stack == null) ? ItemStack.EMPTY : stack;
    }
    
    private static /* synthetic */ void lambda$onInit$1(final ButtonWidget buttonWidget) {
        MinecraftClient.getInstance().openScreen((Screen)new c33953());
    }
    
    private /* bridge */ void lambda$onInit$0(final ButtonWidget buttonWidget) {
        this.onAutoCraft();
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Auto craft", "Config", "Invalid recipe.", "Stop crafting", "Stopped because your inventory is full.", "Stopped because you have ran out of ingredients.", "Auto craft" };
    }
}
