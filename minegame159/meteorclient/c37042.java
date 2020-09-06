package minegame159.meteorclient;

import java.awt.*;
import net.minecraft.nbt.*;

public class c37042 implements c34681<c37042>
{
    private static final String[] f37043;
    private static byte[] f37044;
    public int f37045;
    public int f37046;
    public int f37047;
    public int f37048;
    
    public c37042() {
        this(255, 255, 255, 255);
    }
    
    public c37042(final int f37045, final int f37046, final int f37047) {
        super();
        this.f37045 = f37045;
        this.f37046 = f37046;
        this.f37047 = f37047;
        this.f37048 = 255;
        this.m37052();
    }
    
    public c37042(final int f37045, final int f37046, final int f37047, final int f37048) {
        super();
        this.f37045 = f37045;
        this.f37046 = f37046;
        this.f37047 = f37047;
        this.f37048 = f37048;
        this.m37052();
    }
    
    public c37042(final int n) {
        super();
        this.f37045 = m37068(n);
        this.f37046 = m37070(n);
        this.f37047 = m37072(n);
        this.f37048 = m37074(n);
    }
    
    public c37042(final c37042 c37042) {
        super();
        this.f37045 = c37042.f37045;
        this.f37046 = c37042.f37046;
        this.f37047 = c37042.f37047;
        this.f37048 = c37042.f37048;
    }
    
    public c37042(final Color color) {
        super();
        this.f37045 = color.getRed();
        this.f37046 = color.getGreen();
        this.f37047 = color.getBlue();
        this.f37048 = color.getAlpha();
    }
    
    public void m37049(final c37042 c37042) {
        this.f37045 = c37042.f37045;
        this.f37046 = c37042.f37046;
        this.f37047 = c37042.f37047;
        this.f37048 = c37042.f37048;
        this.m37052();
    }
    
    public void m37052() {
        if (this.f37045 < 0) {
            this.f37045 = 0;
        }
        else if (this.f37045 > 255) {
            this.f37045 = 255;
        }
        if (this.f37046 < 0) {
            this.f37046 = 0;
        }
        else if (this.f37046 > 255) {
            this.f37046 = 255;
        }
        if (this.f37047 < 0) {
            this.f37047 = 0;
        }
        else if (this.f37047 > 255) {
            this.f37047 = 255;
        }
        if (this.f37048 < 0) {
            this.f37048 = 0;
        }
        else if (this.f37048 > 255) {
            this.f37048 = 255;
        }
    }
    
    public boolean m37054() {
        return this.f37045 == 0 && this.f37046 == 0 && this.f37047 == 0 && this.f37048 == 0;
    }
    
    public int m37056() {
        return m37063(this.f37045, this.f37046, this.f37047, this.f37048);
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("r", this.f37045);
        compoundTag.putInt("g", this.f37046);
        compoundTag.putInt("b", this.f37047);
        compoundTag.putInt("a", this.f37048);
        return compoundTag;
    }
    
    public c37042 m37060(final CompoundTag compoundTag) {
        this.f37045 = compoundTag.getInt("r");
        this.f37046 = compoundTag.getInt("g");
        this.f37047 = compoundTag.getInt("b");
        this.f37048 = compoundTag.getInt("a");
        this.m37052();
        return this;
    }
    
    @Override
    public String toString() {
        return this.f37045 + " " + this.f37046 + " " + this.f37047 + " " + this.f37048;
    }
    
    public static int m37063(final int n, final int n2, final int n3, final int n4) {
        return (n << 16) + (n2 << 8) + (n3 << 0) + (n4 << 24);
    }
    
    public static int m37068(final int n) {
        return n >> 16 & 0xFF;
    }
    
    public static int m37070(final int n) {
        return n >> 8 & 0xFF;
    }
    
    public static int m37072(final int n) {
        return n >> 0 & 0xFF;
    }
    
    public static int m37074(final int n) {
        return n >> 24 & 0xFF;
    }
    
    public static c37042 m37076(final double n, final double n2, final double n3) {
        if (n2 <= 0.0) {
            return new c37042((int)(n3 * 255.0), (int)(n3 * 255.0), (int)(n3 * 255.0), 255);
        }
        double n4 = n;
        if (n4 >= 360.0) {
            n4 = 0.0;
        }
        final double n5 = n4 / 60.0;
        final int n6 = (int)n5;
        final double n7 = n5 - n6;
        final double n8 = n3 * (1.0 - n2);
        final double n9 = n3 * (1.0 - n2 * n7);
        final double n10 = n3 * (1.0 - n2 * (1.0 - n7));
        double n11 = 0.0;
        double n12 = 0.0;
        double n13 = 0.0;
        switch (n6) {
            case 0: {
                n11 = n3;
                n12 = n10;
                n13 = n8;
                break;
            }
            case 1: {
                n11 = n9;
                n12 = n3;
                n13 = n8;
                break;
            }
            case 2: {
                n11 = n8;
                n12 = n3;
                n13 = n10;
                break;
            }
            case 3: {
                n11 = n8;
                n12 = n9;
                n13 = n3;
                break;
            }
            case 4: {
                n11 = n10;
                n12 = n8;
                n13 = n3;
                break;
            }
            default: {
                n11 = n3;
                n12 = n8;
                n13 = n9;
                break;
            }
        }
        return new c37042((int)(n11 * 255.0), (int)(n12 * 255.0), (int)(n13 * 255.0), 255);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m37060(compoundTag);
    }
    
    static {
        f37043 = new String[] { "r", "g", "b", "a", "r", "g", "b", "a", " ", " ", " " };
        c37042.f37044 = new byte[4];
    }
}
