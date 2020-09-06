package minegame159.meteorclient;

import net.minecraft.item.*;
import com.mojang.blaze3d.platform.*;
import net.minecraft.client.render.*;
import net.minecraft.client.*;

public class c33867 extends c32787
{
    private double f33868;
    private double f33869;
    private ItemStack f33870;
    
    public c33867() {
        super();
    }
    
    public c33867 m33871(final double f33868, final double f33869, final ItemStack f33870) {
        this.f33868 = f33868;
        this.f33869 = f33869;
        this.f33870 = f33870;
        return this;
    }
    
    @Override
    public void m32788(final c36250 c36250) {
        GlStateManager.enableTexture();
        DiffuseLighting.enableForItems();
        GlStateManager.enableDepthTest();
        MinecraftClient.getInstance().getItemRenderer().renderGuiItem(this.f33870, (int)this.f33868, (int)this.f33869);
    }
    
    @Override
    public void m32789(final c36250 c36250) {
        c36250.f36265.m32905(this);
    }
}
