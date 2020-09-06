package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import org.lwjgl.glfw.*;

private static class c32207 extends c31923
{
    TopBarType f32208;
    boolean f32209;
    
    c32207(final TopBarType f32208) {
        super();
        this.f32208 = f32208;
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 2.0 + MeteorClient.smallFont.m33815(this.f32208.toString()) + 2.0;
        this.f31928 = 2.0 + MeteorClient.smallFont.m33813() + 2.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f32209 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f31932) {
            this.f32209 = false;
            final Screen currentScreen = MinecraftClient.getInstance().currentScreen;
            if (!(currentScreen instanceof c36626) || ((c36626)currentScreen).f36627 != this.f32208) {
                final MinecraftClient instance = MinecraftClient.getInstance();
                final double x = instance.mouse.getX();
                final double y = instance.mouse.getY();
                if (currentScreen != null) {
                    currentScreen.onClose();
                }
                instance.openScreen((Screen)this.f32208.createScreen());
                GLFW.glfwSetCursorPos(instance.window.getHandle(), x, y);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c37042 c36251 = c31870.f37895.f37900;
        if (this.f32209) {
            c36251 = c31870.f37895.f37902;
        }
        else if (this.f31932) {
            c36251 = c31870.f37895.f37901;
        }
        final Screen currentScreen = MinecraftClient.getInstance().currentScreen;
        if (currentScreen instanceof c36626 && ((c36626)currentScreen).f36627 == this.f32208) {
            c36251 = c31870.f37895.f37902;
        }
        c36250.m36337(this.f31925, this.f31926, this.f31927, this.f31928, c36251);
        c36250.m36370(this.f32208.toString(), this.f31925 + 2.0, this.f31926 + 2.0, c31870.f37895.f37897, false);
    }
}
