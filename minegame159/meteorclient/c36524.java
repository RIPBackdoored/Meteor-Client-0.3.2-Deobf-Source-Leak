package minegame159.meteorclient;

import net.minecraft.client.render.*;

public class c36524
{
    public static final c35197 f36525;
    public static final c35197 f36526;
    private static boolean f36527;
    
    public c36524() {
        super();
    }
    
    public static void m36528(final c36846 c36846) {
        if (!c36524.f36527) {
            c36524.f36525.m35203(c36846, 4, VertexFormats.POSITION_COLOR);
            c36524.f36526.m35203(c36846, 1, VertexFormats.POSITION_COLOR);
            c36524.f36527 = true;
        }
    }
    
    public static void m36530() {
        if (!c36524.f36527) {
            c36524.f36525.m35208(4, VertexFormats.POSITION_TEXTURE_COLOR);
            c36524.f36526.m35208(1, VertexFormats.POSITION_COLOR);
            c36524.f36527 = true;
        }
    }
    
    public static void m36531(final boolean b) {
        if (c36524.f36527) {
            c36524.f36525.m35226(b);
            c36524.f36526.m35226(false);
            c36524.f36527 = false;
        }
    }
    
    public static void m36533() {
        m36531(false);
    }
    
    public static boolean m36534() {
        return c36524.f36527;
    }
    
    static {
        f36525 = new c35197();
        f36526 = new c35197();
    }
}
