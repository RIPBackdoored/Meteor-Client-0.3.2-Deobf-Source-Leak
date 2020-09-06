package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import net.minecraft.client.gui.widget.*;
import org.spongepowered.asm.mixin.injection.*;
import minegame159.meteorclient.*;
import net.minecraft.client.gui.screen.*;

@Mixin({ class_418.class })
public class DeathScreenMixin extends class_437
{
    private static final String[] ENCRYPTED_STRINGS;
    
    protected DeathScreenMixin(final Text text) {
        super(text);
    }
    
    @Inject(method = { "init" }, at = { @At("HEAD") })
    protected void init(final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Bypassdeathscreen.class).m35315()) {
            this.addButton((AbstractButtonWidget)new ButtonWidget(this.width / 2 - 100, this.height / 4 + 48, 200, 20, "Ghost Spectate", this::lambda$init$0));
        }
    }
    
    private /* synthetic */ void lambda$init$0(final ButtonWidget buttonWidget) {
        c31351.m31357("You gay nigga 3", new Object[0]);
        c34030.f34033.m34042(Bypassdeathscreen.class).f38262 = true;
        this.minecraft.openScreen((Screen)null);
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Ghost Spectate", "You gay nigga 3" };
    }
}
