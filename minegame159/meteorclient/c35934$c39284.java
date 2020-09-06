package minegame159.meteorclient;

import net.minecraft.*;
import meteorclient.modules.*;
import net.minecraft.client.toast.*;
import net.minecraft.util.*;
import com.mojang.blaze3d.platform.*;

class c39284 implements class_368
{
    private static final String[] f39285;
    private long f39286;
    private long f39287;
    final /* synthetic */ HUD f39288;
    
    c39284(final HUD f39288) {
        this.f39288 = f39288;
        super();
        this.f39287 = -1L;
    }
    
    public class_368.class_369 method_1986(final ToastManager toastManager, final long f39287) {
        if (this.f39287 == -1L) {
            this.f39287 = f39287;
        }
        else {
            this.f39286 += f39287 - this.f39287;
        }
        toastManager.getGame().getTextureManager().bindTexture(new Identifier("textures/gui/toasts.png"));
        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 255.0f);
        toastManager.blit(0, 0, 0, 32, 160, 32);
        toastManager.getGame().textRenderer.draw("Armor Low.", 12.0f, 12.0f, -11534256);
        return (this.f39286 >= 32000L) ? class_368.class_369.field_2209 : class_368.class_369.field_2210;
    }
    
    static {
        c39284.f39285 = new String[] { "textures/gui/toasts.png", "Armor Low." };
    }
}
