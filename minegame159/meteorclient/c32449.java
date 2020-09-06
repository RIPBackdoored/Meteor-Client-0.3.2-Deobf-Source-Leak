package minegame159.meteorclient;

public class c32449
{
    private static final String[] f32450;
    private final int[] f32451;
    private final int f32452;
    private final String f32453;
    
    private c32449(final int n, final int n2, final int n3, final int f32452) {
        super();
        this.f32451 = new int[] { n, n2, n3 };
        this.f32452 = f32452;
        if (f32452 == -1) {
            this.f32453 = String.format("%d.%d.%d", n, n2, n3);
        }
        else {
            this.f32453 = String.format("%d.%d.%d beta%d", n, n2, n3, f32452);
        }
    }
    
    public boolean m32454(final c32449 c32449) {
        for (int i = 0; i < this.f32451.length; ++i) {
            if (this.f32451[i] > c32449.f32451[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean m32458(final c32449 c32449) {
        for (int i = 0; i < this.f32451.length; ++i) {
            if (this.f32451[i] >= c32449.f32451[i]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean m32462(final c32449 c32449) {
        for (int i = 0; i < this.f32451.length; ++i) {
            if (this.f32451[i] < c32449.f32451[i]) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.f32453;
    }
    
    public static c32449 m32466(final String s) {
        final String[] split = s.split(" ");
        final String[] split2 = split[0].split("\\.");
        return new c32449(m32470(split2[0]), m32470(split2[1]), m32470(split2[2]), (split.length > 1) ? m32470(split[1].substring(4)) : -1);
    }
    
    private static int m32470(final String s) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
    
    static {
        f32450 = new String[] { "%d.%d.%d", "%d.%d.%d beta%d", " ", "\\." };
    }
}
