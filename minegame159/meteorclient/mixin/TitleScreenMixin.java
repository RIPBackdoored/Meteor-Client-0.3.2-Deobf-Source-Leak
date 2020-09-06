package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import meteorclient.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import minegame159.meteorclient.*;

@Mixin({ class_442.class })
public class TitleScreenMixin extends class_437
{
    private static final String[] ENCRYPTED_STRINGS;
    private int text1Color;
    private int text2Color;
    private int text3Color;
    private int text4Color;
    private String text1;
    private int text1Length;
    private String text2;
    private int text2Length;
    private String text3;
    private int text3Length;
    private String text4;
    private int text4Length;
    
    public TitleScreenMixin(final Text text) {
        super(text);
    }
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        this.text1Color = c37042.m37063(255, 255, 255, 255);
        this.text2Color = c37042.m37063(175, 175, 175, 255);
        this.text3Color = c37042.m37063(255, 255, 255, 255);
        this.text4Color = c37042.m37063(175, 175, 175, 255);
        this.text1 = "Meteor Client by ";
        this.text2 = "MineGame159";
        this.text3 = " & ";
        this.text4 = "squidoodly";
        this.text1Length = this.font.getStringWidth(this.text1);
        this.text2Length = this.font.getStringWidth(this.text2);
        this.text3Length = this.font.getStringWidth(this.text3);
        this.text4Length = this.font.getStringWidth(this.text4);
    }
    
    @Inject(method = { "render" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/TitleScreen;drawString(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)V", ordinal = 0) })
    private void onRenderIdkDude(final int n, final int n2, final float n3, final CallbackInfo callbackInfo) {
        if (EnchantUtil.f35532) {
            EnchantUtil.f35532 = false;
            System.out.println("Checking latest version of Meteor Client.");
            c31516.m31520();
            final c32449 c32449;
            c31516.m31524(() -> c37229.m37237("https://meteorclient.com/version.txt", s -> {
                minegame159.meteorclient.c32449.m32466(s);
                if (c32449.m32454(c33436.f34122.f34123)) {
                    MinecraftClient.getInstance().openScreen((Screen)new c37035(c32449));
                }
            }));
            c31516.m31522();
        }
    }
    
    @Inject(method = { "render" }, at = { @At("TAIL") })
    private void onRender(final int n, final int n2, final float n3, final CallbackInfo callbackInfo) {
        this.drawString(this.font, this.text1, this.width - this.text4Length - this.text3Length - this.text2Length - this.text1Length - 3, 3, this.text1Color);
        this.drawString(this.font, this.text2, this.width - this.text4Length - this.text3Length - this.text2Length - 3, 3, this.text2Color);
        this.drawString(this.font, this.text3, this.width - this.text4Length - this.text3Length - 3, 3, this.text3Color);
        this.drawString(this.font, this.text4, this.width - this.text4Length - 3, 3, this.text4Color);
    }
    
    private static /* synthetic */ void lambda$onRenderIdkDude$1() {
        final c32449 c32449;
        c37229.m37237("https://meteorclient.com/version.txt", s -> {
            minegame159.meteorclient.c32449.m32466(s);
            if (c32449.m32454(c33436.f34122.f34123)) {
                MinecraftClient.getInstance().openScreen((Screen)new c37035(c32449));
            }
        });
    }
    
    private static /* synthetic */ void lambda$null$0(final String s) {
        final c32449 m32466 = c32449.m32466(s);
        if (m32466.m32454(c33436.f34122.f34123)) {
            MinecraftClient.getInstance().openScreen((Screen)new c37035(m32466));
        }
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Meteor Client by ", "MineGame159", " & ", "squidoodly", "Checking latest version of Meteor Client.", "https://meteorclient.com/version.txt" };
    }
}
