package minegame159.meteorclient;

import org.lwjgl.opengl.*;

public class c39098
{
    public c39098() {
        super();
    }
    
    public static void m39099() {
    }
    
    public static void m39100() {
        GL11.glPushMatrix();
    }
    
    public static void m39101(final double n, final double n2, final double n3) {
        GL11.glTranslated(n, n2, n3);
    }
    
    public static void m39105(final double n, final double n2, final double n3, final double n4) {
        GL11.glRotated(n, n2, n3, n4);
    }
    
    public static void m39110(final double n, final double n2, final double n3) {
        GL11.glScaled(n, n2, n3);
    }
    
    public static void m39114() {
        GL11.glPopMatrix();
    }
}
