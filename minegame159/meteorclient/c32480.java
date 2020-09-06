package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.text.*;
import meteorclient.util.*;
import com.mojang.blaze3d.platform.*;

public class c32480 extends class_437
{
    public final String f37288;
    protected final MinecraftClient f37289;
    public Screen f37290;
    public final c31923 f37291;
    private int f37292;
    private boolean f37293;
    
    public c32480(final String f37288) {
        super((Text)new LiteralText(f37288));
        this.f37293 = false;
        this.f37288 = f37288;
        this.f37289 = MinecraftClient.getInstance();
        this.f37290 = this.f37289.currentScreen;
        this.f37291 = new c32481(null);
        this.f37292 = c34739.f34740;
    }
    
    public <T extends c31923> c33587<T> add(final T t) {
        return this.f37291.m31937(t);
    }
    
    public void clear() {
        this.f37291.m31945();
    }
    
    public void method_16014(double n, double n2) {
        final double scaleFactor = this.f37289.window.getScaleFactor();
        final double f37896 = c31870.f37895.f37896;
        n *= scaleFactor;
        n2 *= scaleFactor;
        n /= f37896;
        n2 /= f37896;
        this.f37291.m32009(n, n2);
    }
    
    public boolean mouseClicked(final double n, final double n2, final int n3) {
        return this.f37291.m32019(n3);
    }
    
    public boolean mouseReleased(final double n, final double n2, final int n3) {
        return this.f37291.m32026(n3);
    }
    
    public boolean mouseScrolled(final double n, final double n2, final double n3) {
        return this.f37291.m32033(n3);
    }
    
    public boolean keyPressed(final int n, final int n2, final int n3) {
        if (n3 == 2 && n == 57) {
            this.f37293 = !this.f37293;
            return true;
        }
        return this.f37291.m32040(n, n3) || super.keyPressed(n, n2, n3);
    }
    
    public void keyRepeated(final int n, final int n2) {
        this.f37291.m32049(n, n2);
    }
    
    public boolean charTyped(final char c, final int n) {
        return this.f37291.m32058(c, n);
    }
    
    public void tick() {
        this.f37291.m31980();
    }
    
    public void render(int n, int n2, final float n3) {
        if (!EnchantUtil.m35613()) {
            this.renderBackground();
        }
        final double scaleFactor = this.f37289.window.getScaleFactor();
        final double f37896 = c31870.f37895.f37896;
        n *= (int)scaleFactor;
        n2 *= (int)scaleFactor;
        n /= (int)f37896;
        n2 /= (int)f37896;
        GlStateManager.pushMatrix();
        GlStateManager.scaled(1.0 / scaleFactor, 1.0 / scaleFactor, 1.0);
        GlStateManager.scaled(f37896, f37896, 1.0);
        c36250.f36252.m36274();
        this.f37291.m31985(c36250.f36252, n, n2, n3);
        c36250.f36252.m36278();
        if (this.f37293) {
            c36250.f36252.m36388(this.f37291);
        }
        GlStateManager.popMatrix();
    }
    
    public void resize(final MinecraftClient minecraftClient, final int n, final int n2) {
        super.resize(minecraftClient, n, n2);
        this.f37291.m31935();
    }
    
    public void onClose() {
        c34739.f34740 = this.f37292;
        this.f37289.openScreen(this.f37290);
    }
    
    public boolean isPauseScreen() {
        return false;
    }
    
    private class c32481 extends c31923
    {
        final /* synthetic */ c32480 f32482;
        
        private c32481(final c32480 f32482) {
            this.f32482 = f32482;
            super();
        }
        
        @Override
        protected void m31978() {
            this.f31927 = EnchantUtil.m35545();
            this.f31928 = EnchantUtil.m35546();
        }
        
        c32481(final c32480 c32480, final c40071 c32481) {
            this(c32480);
        }
    }
    
    static class c40071
    {
    }
}
