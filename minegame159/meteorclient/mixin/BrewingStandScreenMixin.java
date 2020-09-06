package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.entity.player.*;
import net.minecraft.text.*;
import net.minecraft.container.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;

@Mixin({ class_472.class })
public abstract class BrewingStandScreenMixin extends class_465<class_1708>
{
    public BrewingStandScreenMixin(final BrewingStandContainer brewingStandContainer, final PlayerInventory playerInventory, final Text text) {
        super((Container)brewingStandContainer, playerInventory, text);
    }
    
    public void tick() {
        super.tick();
        if (c34030.f34033.m34049(Autobrewer.class)) {
            c34030.f34033.m34042(Autobrewer.class).m32130((BrewingStandContainer)this.container);
        }
    }
    
    public void onClose() {
        if (c34030.f34033.m34049(Autobrewer.class)) {
            c34030.f34033.m34042(Autobrewer.class).m32128();
        }
        super.onClose();
    }
}
