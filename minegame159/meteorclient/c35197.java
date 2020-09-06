package minegame159.meteorclient;

import net.minecraft.client.render.*;
import com.mojang.blaze3d.platform.*;
import org.lwjgl.opengl.*;

public class c35197
{
    private static final BufferRenderer f35198;
    private final BufferBuilder f35199;
    private double f35200;
    private double f35201;
    private double f35202;
    
    public c35197(final int n) {
        super();
        this.f35199 = new BufferBuilder(n);
    }
    
    public c35197() {
        this(2097152);
    }
    
    public void m35203(final c36846 c36846, final int n, final VertexFormat vertexFormat) {
        if (c36846 != null) {
            this.f35200 = -c36846.f36848;
            this.f35201 = -c36846.f36849;
            this.f35202 = -c36846.f36850;
        }
        else {
            this.f35200 = 0.0;
            this.f35201 = 0.0;
            this.f35202 = 0.0;
        }
        this.f35199.begin(n, vertexFormat);
    }
    
    public void m35208(final int n, final VertexFormat vertexFormat) {
        this.m35203(null, n, vertexFormat);
    }
    
    public c35197 m35212(final double n, final double n2, final double n3) {
        this.f35199.vertex(n + this.f35200, n2 + this.f35201, n3 + this.f35202);
        return this;
    }
    
    public c35197 m35217(final double n, final double n2) {
        this.f35199.texture(n + this.f35200, n2 + this.f35201);
        return this;
    }
    
    public c35197 m35221(final c37042 c37042) {
        this.f35199.color(c37042.f37045, c37042.f37046, c37042.f37047, c37042.f37048);
        return this;
    }
    
    public void m35224() {
        this.f35199.next();
    }
    
    public void m35226(final boolean b) {
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableDepthTest();
        GlStateManager.disableAlphaTest();
        if (b) {
            GlStateManager.enableTexture();
        }
        else {
            GlStateManager.disableTexture();
        }
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GL11.glEnable(2848);
        GlStateManager.lineWidth(1.0f);
        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.shadeModel(7425);
        this.f35199.end();
        c35197.f35198.draw(this.f35199);
        GlStateManager.disableBlend();
        GlStateManager.enableAlphaTest();
        GlStateManager.enableDepthTest();
        GlStateManager.enableTexture();
        GL11.glDisable(2848);
    }
    
    public boolean m35229() {
        return ((c34410)this.f35199).m34411();
    }
    
    static {
        f35198 = new BufferRenderer();
    }
}
