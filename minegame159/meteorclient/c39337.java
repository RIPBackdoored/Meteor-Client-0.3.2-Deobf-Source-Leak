package minegame159.meteorclient;

import net.minecraft.client.render.*;
import net.minecraft.util.math.*;

public class c39337
{
    private static final c35197 f39338;
    public static c35197 f39339;
    
    public c39337() {
        super();
    }
    
    public static void m39340(final c36846 c36846, final int n, final VertexFormat vertexFormat) {
        c39337.f39338.m35203(c36846, n, vertexFormat);
        c39337.f39339 = c39337.f39338;
        c39098.m39100();
    }
    
    public static void m39344(final boolean b) {
        c39337.f39339.m35226(b);
        c39337.f39339 = c36524.f36525;
        c39098.m39114();
    }
    
    public static void m39346() {
        m39344(false);
    }
    
    public static void m39347(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8, final double n9, final double n10, final double n11, final double n12, final c37042 c37042) {
        c39337.f39339.m35212(n, n2, n3).m35221(c37042).m35224();
        c39337.f39339.m35212(n4, n5, n6).m35221(c37042).m35224();
        c39337.f39339.m35212(n7, n8, n9).m35221(c37042).m35224();
        c39337.f39339.m35212(n, n2, n3).m35221(c37042).m35224();
        c39337.f39339.m35212(n7, n8, n9).m35221(c37042).m35224();
        c39337.f39339.m35212(n10, n11, n12).m35221(c37042).m35224();
    }
    
    public static void m39361(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8, final c37042 c37042, final c37042 c37043, final c37042 c37044, final c37042 c37045) {
        c39337.f39339.m35212(n, n2, 0.0).m35217(n5, n6).m35221(c37042).m35224();
        c39337.f39339.m35212(n + n3, n2, 0.0).m35217(n5 + n7, n6).m35221(c37043).m35224();
        c39337.f39339.m35212(n + n3, n2 + n4, 0.0).m35217(n5 + n7, n6 + n8).m35221(c37044).m35224();
        c39337.f39339.m35212(n, n2, 0.0).m35217(n5, n6).m35221(c37042).m35224();
        c39337.f39339.m35212(n + n3, n2 + n4, 0.0).m35217(n5 + n7, n6 + n8).m35221(c37044).m35224();
        c39337.f39339.m35212(n, n2 + n4, 0.0).m35217(n5, n6 + n8).m35221(c37045).m35224();
    }
    
    public static void m39374(final double n, final double n2, final double n3, final double n4, final c33493 c33493, final c37042 c33494, final c37042 c33495, final c37042 c33496, final c37042 c33497) {
        m39361(n, n2, n3, n4, c33493.f33494, c33493.f33495, c33493.f33496, c33493.f33497, c33494, c33495, c33496, c33497);
    }
    
    public static void m39384(final double n, final double n2, final double n3, final double n4, final c37042 c37042, final boolean b) {
        final double cos = Math.cos(Math.toRadians(n4));
        final double sin = Math.sin(Math.toRadians(n4));
        final double n5 = n + n3 / 2.0;
        final double n6 = n2 + n3 / 4.0;
        final double n7 = (n - n5) * cos - (n2 - n6) * sin + n5;
        final double n8 = (n2 - n6) * cos + (n - n5) * sin + n6;
        if (b) {
            c39337.f39339.m35212(n7, n8, 0.0).m35217(c36250.f36258.f33494, c36250.f36258.f33495).m35221(c37042).m35224();
        }
        else {
            c39337.f39339.m35212(n7, n8, 0.0).m35221(c37042).m35224();
        }
        final double n9 = (n + n3 - n5) * cos - (n2 - n6) * sin + n5;
        final double n10 = (n2 - n6) * cos + (n + n3 - n5) * sin + n6;
        if (b) {
            c39337.f39339.m35212(n9, n10, 0.0).m35217(c36250.f36258.f33494 + c36250.f36258.f33496, c36250.f36258.f33495).m35221(c37042).m35224();
        }
        else {
            c39337.f39339.m35212(n9, n10, 0.0).m35221(c37042).m35224();
        }
        final double n11 = n2 + n3 / (b ? 2.0 : 0.9) - n6;
        final double n12 = (n + n3 / 2.0 - n5) * cos - n11 * sin + n5;
        final double n13 = n11 * cos + (n + n3 / 2.0 - n5) * sin + n6;
        if (b) {
            c39337.f39339.m35212(n12, n13, 0.0).m35217(c36250.f36258.f33494 + c36250.f36258.f33496, c36250.f36258.f33495 + c36250.f36258.f33497).m35221(c37042).m35224();
        }
        else {
            c39337.f39339.m35212(n12, n13, 0.0).m35221(c37042).m35224();
        }
    }
    
    public static void m39398(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        m39384(n, n2, n3, n4, c37042, true);
    }
    
    public static void m39404(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final c37042 c37042) {
        c36524.f36526.m35212(n, n2, n3).m35221(c37042).m35224();
        c36524.f36526.m35212(n4, n5, n6).m35221(c37042).m35224();
    }
    
    public static void m39412(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        m39404(n, n2, 0.0, n3, n4, 0.0, c37042);
    }
    
    public static void m39418(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final c37042 c37042, final Direction direction) {
        if (direction != Direction.field_11039 && direction != Direction.field_11043) {
            m39404(n, n2, n3, n, n5, n3, c37042);
        }
        if (direction != Direction.field_11039 && direction != Direction.field_11035) {
            m39404(n, n2, n6, n, n5, n6, c37042);
        }
        if (direction != Direction.field_11034 && direction != Direction.field_11043) {
            m39404(n4, n2, n3, n4, n5, n3, c37042);
        }
        if (direction != Direction.field_11034 && direction != Direction.field_11035) {
            m39404(n4, n2, n6, n4, n5, n6, c37042);
        }
        if (direction != Direction.field_11043) {
            m39404(n, n2, n3, n4, n2, n3, c37042);
        }
        if (direction != Direction.field_11043) {
            m39404(n, n5, n3, n4, n5, n3, c37042);
        }
        if (direction != Direction.field_11035) {
            m39404(n, n2, n6, n4, n2, n6, c37042);
        }
        if (direction != Direction.field_11035) {
            m39404(n, n5, n6, n4, n5, n6, c37042);
        }
        if (direction != Direction.field_11039) {
            m39404(n, n2, n3, n, n2, n6, c37042);
        }
        if (direction != Direction.field_11039) {
            m39404(n, n5, n3, n, n5, n6, c37042);
        }
        if (direction != Direction.field_11034) {
            m39404(n4, n2, n3, n4, n2, n6, c37042);
        }
        if (direction != Direction.field_11034) {
            m39404(n4, n5, n3, n4, n5, n6, c37042);
        }
    }
    
    public static void m39427(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final c37042 c37042) {
        m39418(n, n2, n3, n4, n5, n6, c37042, null);
    }
    
    public static void m39435(final int n, final int n2, final int n3, final c37042 c37042, final Direction direction) {
        m39418(n, n2, n3, n + 1, n2 + 1, n3 + 1, c37042, direction);
    }
    
    public static void m39441(final BlockPos blockPos, final c37042 c37042) {
        m39435(blockPos.getX(), blockPos.getY(), blockPos.getZ(), c37042, null);
    }
    
    public static void m39444(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final c37042 c37042, final Direction direction) {
        if (direction != Direction.field_11033) {
            m39347(n, n2, n3, n, n2, n6, n4, n2, n6, n4, n2, n3, c37042);
        }
        if (direction != Direction.field_11036) {
            m39347(n, n5, n3, n, n5, n6, n4, n5, n6, n4, n5, n3, c37042);
        }
        if (direction != Direction.field_11043) {
            m39347(n, n2, n3, n, n5, n3, n4, n5, n3, n4, n2, n3, c37042);
        }
        if (direction != Direction.field_11035) {
            m39347(n, n2, n6, n, n5, n6, n4, n5, n6, n4, n2, n6, c37042);
        }
        if (direction != Direction.field_11039) {
            m39347(n, n2, n3, n, n5, n3, n, n5, n6, n, n2, n6, c37042);
        }
        if (direction != Direction.field_11034) {
            m39347(n4, n2, n3, n4, n5, n3, n4, n5, n6, n4, n2, n6, c37042);
        }
    }
    
    public static void m39453(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final c37042 c37042) {
        m39444(n, n2, n3, n4, n5, n6, c37042, null);
    }
    
    public static void m39461(final int n, final int n2, final int n3, final c37042 c37042, final Direction direction) {
        m39444(n, n2, n3, n + 1, n2 + 1, n3 + 1, c37042, direction);
    }
    
    public static void m39467(final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final c37042 c37042, final c37042 c37043) {
        m39347(n, n2, n3, n4, n2, n6, n4, n5, n6, n, n5, n3, c37042);
        m39404(n, n2, n3, n4, n2, n6, c37043);
        m39404(n, n2, n3, n, n5, n3, c37043);
        m39404(n, n5, n3, n4, n5, n6, c37043);
        m39404(n4, n2, n6, n4, n5, n6, c37043);
    }
    
    public static void m39476(final double n, final double n2, final double n3, final double n4, final double n5, final c37042 c37042, final c37042 c37043) {
        m39347(n, n2, n3, n, n2, n3 + n5, n + n4, n2, n3 + n5, n + n4, n2, n3, c37042);
        m39404(n, n2, n3, n, n2, n3 + n5, c37043);
        m39404(n, n2, n3 + n5, n + n4, n2, n3 + n5, c37043);
        m39404(n + n4, n2, n3 + n5, n + n4, n2, n3, c37043);
        m39404(n, n2, n3, n + n4, n2, n3, c37043);
    }
    
    public static void m39484(final double n, final double n2, final double n3, final c37042 c37042, final c37042 c37043) {
        m39476(n, n2, n3, 1.0, 1.0, c37042, c37043);
    }
    
    static {
        f39338 = new c35197();
        c39337.f39339 = c36524.f36525;
    }
}
