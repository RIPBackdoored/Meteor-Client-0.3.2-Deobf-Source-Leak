package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.client.*;
import net.minecraft.client.gl.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.render.entity.*;
import com.mojang.blaze3d.platform.*;
import net.minecraft.client.render.*;
import net.minecraft.entity.*;
import java.util.*;

public class c38335
{
    private static final String[] f38336;
    public static final List<class_1297> f38337;
    public static boolean f38338;
    public static boolean f38339;
    private static Framebuffer f38340;
    private static ShaderEffect f38341;
    
    public c38335() {
        super();
    }
    
    public static void m38342() {
        try {
            final MinecraftClient instance = MinecraftClient.getInstance();
            if (GlProgramManager.getInstance() == null) {
                GlProgramManager.init();
            }
            if (c38335.f38341 != null) {
                c38335.f38341.close();
            }
            c38335.f38338 = true;
            (c38335.f38341 = new ShaderEffect(instance.getTextureManager(), instance.getResourceManager(), instance.getFramebuffer(), new Identifier("meteor-client", "shaders/post/my_entity_outline.json"))).setupDimensions(instance.window.getFramebufferWidth(), instance.window.getFramebufferHeight());
            c38335.f38340 = c38335.f38341.getSecondaryTarget("final");
            c38335.f38338 = false;
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void m38345(final EntityRenderDispatcher entityRenderDispatcher, final VisibleRegion visibleRegion, final Camera camera, final float n) {
        final MinecraftClient instance = MinecraftClient.getInstance();
        if (c38335.f38337.size() > 0) {
            c38335.f38340.clear(MinecraftClient.IS_SYSTEM_MAC);
            GlStateManager.depthFunc(519);
            GlStateManager.disableFog();
            c38335.f38340.beginWrite(false);
            DiffuseLighting.disable();
            entityRenderDispatcher.setRenderOutlines(c38335.f38339 = true);
            for (final Entity entity : c38335.f38337) {
                if (entityRenderDispatcher.shouldRender(entity, visibleRegion, camera.getPos().x, camera.getPos().y, camera.getPos().z)) {
                    entityRenderDispatcher.render(entity, n, false);
                }
            }
            entityRenderDispatcher.setRenderOutlines(false);
            c38335.f38339 = false;
            DiffuseLighting.enable();
            GlStateManager.depthMask(false);
            c38335.f38341.render(n);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.enableFog();
            GlStateManager.enableColorMaterial();
            GlStateManager.depthFunc(515);
            GlStateManager.enableDepthTest();
            GlStateManager.enableAlphaTest();
            instance.getFramebuffer().beginWrite(false);
            c38335.f38337.clear();
        }
    }
    
    public static void m38352() {
        if (c38335.f38337.size() > 0) {
            final MinecraftClient instance = MinecraftClient.getInstance();
            c38335.f38340.drawInternal(instance.window.getFramebufferWidth(), instance.window.getFramebufferHeight(), false);
        }
    }
    
    public static void m38354(final int n, final int n2) {
        if (c38335.f38341 != null) {
            c38335.f38341.setupDimensions(n, n2);
        }
    }
    
    static {
        f38336 = new String[] { "meteor-client", "shaders/post/my_entity_outline.json", "final" };
        f38337 = new ArrayList<class_1297>();
    }
}
