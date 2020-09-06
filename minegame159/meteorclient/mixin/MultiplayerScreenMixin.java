package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.widget.*;
import org.spongepowered.asm.mixin.injection.*;
import minegame159.meteorclient.*;
import net.minecraft.client.gui.screen.*;

@Mixin({ class_500.class })
public class MultiplayerScreenMixin extends class_437
{
    private static final String[] ENCRYPTED_STRINGS;
    private int textColor1;
    private int textColor2;
    private String loggedInAs;
    private int loggedInAsLength;
    
    public MultiplayerScreenMixin(final Text text) {
        super(text);
    }
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        this.textColor1 = c37042.m37063(255, 255, 255, 255);
        this.textColor2 = c37042.m37063(175, 175, 175, 255);
        this.loggedInAs = "Logged in as ";
        this.loggedInAsLength = this.font.getStringWidth(this.loggedInAs);
        this.addButton((AbstractButtonWidget)new ButtonWidget(this.width - 75 - 3, 3, 75, 20, "Accounts", this::lambda$onInit$0));
    }
    
    @Inject(method = { "render" }, at = { @At("TAIL") })
    private void onRender(final int n, final int n2, final float n3, final CallbackInfo callbackInfo) {
        this.drawString(this.font, this.loggedInAs, 3, 3, this.textColor1);
        this.drawString(this.font, this.minecraft.getSession().getUsername(), 3 + this.loggedInAsLength, 3, this.textColor2);
    }
    
    private /* synthetic */ void lambda$onInit$0(final ButtonWidget buttonWidget) {
        this.minecraft.openScreen((Screen)new c33070());
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Logged in as ", "Accounts" };
    }
}
