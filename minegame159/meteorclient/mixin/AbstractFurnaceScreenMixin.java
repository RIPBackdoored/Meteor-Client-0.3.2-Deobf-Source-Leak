package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.entity.player.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import meteorclient.*;
import net.minecraft.container.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_489.class })
public abstract class AbstractFurnaceScreenMixin<T extends class_1720> extends class_465<T>
{
    public AbstractFurnaceScreenMixin(final T t, final class_1661 class_1661, final class_2561 class_1662) {
        super((Container)t, (PlayerInventory)class_1661, (Text)class_1662);
    }
    
    @Inject(method = { "tick" }, at = { @At("TAIL") })
    private void onTick(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34049(Autosmelter.class)) {
            c34030.f34033.m34042(Autosmelter.class).m39883((AbstractFurnaceContainer)this.container);
        }
    }
    
    public void onClose() {
        super.onClose();
        if (c34030.f34033.m34049(Autosmelter.class)) {
            c34030.f34033.m34042(Autosmelter.class).m39881();
        }
    }
}
