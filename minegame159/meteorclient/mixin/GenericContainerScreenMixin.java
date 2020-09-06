package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.entity.player.*;
import net.minecraft.text.*;
import net.minecraft.client.gui.widget.*;
import net.minecraft.client.*;
import net.minecraft.container.*;

@Mixin({ class_476.class })
public abstract class GenericContainerScreenMixin extends class_465<class_1707>
{
    private static final String[] ENCRYPTED_STRINGS;
    
    public GenericContainerScreenMixin(final GenericContainer genericContainer, final PlayerInventory playerInventory, final Text text) {
        super((Container)genericContainer, playerInventory, text);
    }
    
    protected void init() {
        super.init();
        this.addButton((AbstractButtonWidget)new ButtonWidget(this.x + this.containerWidth - 50 - 7, this.y + 3, 50, 12, "Steal", this::lambda$init$0));
        this.addButton((AbstractButtonWidget)new ButtonWidget(this.x + this.containerWidth - 50 - 7, this.y + this.containerHeight - 96 - 1, 50, 12, "Dump", this::lambda$init$1));
    }
    
    private /* synthetic */ void lambda$init$1(final ButtonWidget buttonWidget) {
        for (int i = ((GenericContainer)this.container).getRows() * 9; i < ((GenericContainer)this.container).getRows() * 9 + 1 + 27; ++i) {
            MinecraftClient.getInstance().interactionManager.method_2906(((GenericContainer)this.container).syncId, i, 0, SlotActionType.field_7794, this.playerInventory.player);
        }
    }
    
    private /* synthetic */ void lambda$init$0(final ButtonWidget buttonWidget) {
        for (int i = 0; i < ((GenericContainer)this.container).getRows() * 9; ++i) {
            MinecraftClient.getInstance().interactionManager.method_2906(((GenericContainer)this.container).syncId, i, 0, SlotActionType.field_7794, this.playerInventory.player);
        }
        boolean b = true;
        for (int j = 0; j < ((GenericContainer)this.container).getRows() * 9; ++j) {
            if (!((GenericContainer)this.container).getSlot(j).getStack().isEmpty()) {
                b = false;
                break;
            }
        }
        if (b) {
            MinecraftClient.getInstance().player.closeContainer();
        }
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Steal", "Dump" };
    }
}
