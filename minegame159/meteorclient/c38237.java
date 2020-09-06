package minegame159.meteorclient;

import java.util.function.*;
import java.util.*;

public class c38237
{
    private static final List<c34014> f38238;
    
    public c38237() {
        super();
    }
    
    public static void m38239() {
        m38246(new c32765());
        m38246(new c34349());
        m38246(new c38406());
        m38246(new c31383());
        m38246(new c38357());
        m38246(new c39300());
        m38246(new c38014());
        m38246(new c38848());
        m38246(new c31385());
        m38246(new c34651());
        m38246(new c36943());
        m38246(new c32670());
        m38246(new c35524());
        m38246(new c39292());
        m38246(new c35919());
        m38246(new c33347());
        m38246(new c34160());
        m38246(new c32865());
        m38246(new c34909());
        m38246(new c31514());
        m38246(new c33204());
    }
    
    public static c34014 m38240(final String s) {
        for (final c34014 c34014 : c38237.f38238) {
            if (c34014.f34016.equalsIgnoreCase(s)) {
                return c34014;
            }
        }
        return null;
    }
    
    public static void m38243(final Consumer<c34014> consumer) {
        c38237.f38238.forEach(consumer);
    }
    
    public static int m38245() {
        return c38237.f38238.size();
    }
    
    private static void m38246(final c34014 c34014) {
        c38237.f38238.add(c34014);
    }
    
    static {
        f38238 = new ArrayList<c34014>();
    }
}
