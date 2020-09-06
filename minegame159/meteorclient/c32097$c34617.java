package minegame159.meteorclient;

import net.minecraft.*;
import meteorclient.modules.*;
import net.minecraft.client.toast.*;
import net.minecraft.util.*;
import com.mojang.blaze3d.platform.*;

class c34617 implements class_368
{
    private static final String[] f34618;
    private long f34619;
    private long f34620;
    final /* synthetic */ Stashfinder f34621;
    
    c34617(final Stashfinder f34621) {
        this.f34621 = f34621;
        super();
        this.f34620 = -1L;
    }
    
    public class_368.class_369 method_1986(final ToastManager toastManager, final long f34620) {
        if (this.f34620 == -1L) {
            this.f34620 = f34620;
        }
        else {
            this.f34619 += f34620 - this.f34620;
        }
        toastManager.getGame().getTextureManager().bindTexture(new Identifier("textures/gui/toasts.png"));
        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 255.0f);
        toastManager.blit(0, 0, 0, 32, 160, 32);
        toastManager.getGame().textRenderer.draw("StashRecorder found stash.", 12.0f, 12.0f, -11534256);
        return (this.f34619 >= 32000L) ? class_368.class_369.field_2209 : class_368.class_369.field_2210;
    }
    
    static {
        c34617.f34618 = new String[] { "textures/gui/toasts.png", "StashRecorder found stash." };
    }
}
