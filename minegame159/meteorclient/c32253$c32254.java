package minegame159.meteorclient;

import net.minecraft.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.texture.*;

private static class c32254 extends class_2960
{
    private static final String[] f32255;
    private boolean f32256;
    private boolean f32257;
    private NativeImage f32258;
    private int f32259;
    
    public c32254(final String s) {
        super("meteor-client", "capes/" + s + ".png");
    }
    
    public void m32260() {
        if (this.f32256 || this.f32257 || this.f32259 > 0) {
            return;
        }
        this.f32257 = true;
        c31516.m31520();
        final InputStream inputStream;
        c31516.m31524(() -> {
            try {
                c37229.m37232("https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/" + this.path);
                if (inputStream == null) {
                    synchronized (c32253.m35813()) {
                        c32253.m35813().add(this);
                        this.f32259 = 200;
                        this.f32257 = false;
                        return;
                    }
                }
                this.f32258 = NativeImage.read(inputStream);
                synchronized (c32253.m35814()) {
                    c32253.m35814().add(this);
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        });
        c31516.m31522();
    }
    
    public void m32262() {
        MinecraftClient.getInstance().getTextureManager().registerTexture((Identifier)this, (Texture)new NativeImageBackedTexture(this.f32258));
        this.f32258 = null;
        this.f32257 = false;
        this.f32256 = true;
    }
    
    public boolean m32264() {
        if (this.f32259 > 0) {
            --this.f32259;
            return false;
        }
        this.m32260();
        return true;
    }
    
    public boolean m32266() {
        return this.f32256;
    }
    
    public /* bridge */ int compareTo(final Object o) {
        return super.method_12833((Identifier)o);
    }
    
    private /* synthetic */ void m32268() {
        try {
            final InputStream m37232 = c37229.m37232("https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/" + this.path);
            if (m37232 == null) {
                synchronized (c32253.m35813()) {
                    c32253.m35813().add(this);
                    this.f32259 = 200;
                    this.f32257 = false;
                    return;
                }
            }
            this.f32258 = NativeImage.read(m37232);
            synchronized (c32253.m35814()) {
                c32253.m35814().add(this);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        f32255 = new String[] { "meteor-client", "capes/", ".png", "https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/" };
    }
}
