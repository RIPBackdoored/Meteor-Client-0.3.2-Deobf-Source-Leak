package minegame159.meteorclient;

public class c34739
{
    public static int f34740;
    
    public c34739() {
        super();
    }
    
    public static void m34741(final boolean b) {
        c34739.f34740 += (b ? 1 : -1);
    }
    
    public static boolean m34743() {
        return c34739.f34740 <= 0;
    }
    
    public static void m34744() {
        c34739.f34740 = 0;
    }
    
    static {
        c34739.f34740 = 0;
    }
}
