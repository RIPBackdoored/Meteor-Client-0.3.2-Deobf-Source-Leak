package minegame159.meteorclient;

import net.minecraft.client.options.*;

public class c38412
{
    private static final boolean[] f38413;
    
    public c38412() {
        super();
    }
    
    public static void m38414(final int n, final boolean b) {
        if (n < c38412.f38413.length) {
            c38412.f38413[n] = b;
        }
    }
    
    public static boolean m38417(final KeyBinding keyBinding) {
        final int method_1444 = ((c39520)keyBinding).m39522().method_1444();
        return method_1444 < c38412.f38413.length && c38412.f38413[method_1444];
    }
    
    public static boolean m38420(final int n) {
        return n < c38412.f38413.length && c38412.f38413[n];
    }
    
    static {
        f38413 = new boolean[512];
    }
}
