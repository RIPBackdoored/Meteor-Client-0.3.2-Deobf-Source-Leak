package minegame159.meteorclient;

import net.minecraft.client.render.*;
import net.minecraft.client.texture.*;
import java.util.*;
import net.minecraft.nbt.*;

public class c33820 implements c34681<c33820>
{
    private static final String[] f33821;
    private static final c35197 f33822;
    public String f33823;
    public String f33824;
    public c37042 f33825;
    public int f33826;
    public int f33827;
    public int f33828;
    public boolean f33829;
    public int f33830;
    public double f33831;
    public boolean f33832;
    public boolean f33833;
    public boolean f33834;
    
    public c33820() {
        super();
        this.f33823 = "Meteor on Crack!";
        this.f33824 = "Square";
        this.f33825 = new c37042(225, 25, 25);
        this.f33829 = true;
        this.f33830 = 1000;
        this.f33831 = 1.0;
    }
    
    public void m33835(final double n, final double n2, final double n3, final double n4) {
        c33820.f33822.m35203(null, 4, VertexFormats.POSITION_TEXTURE_COLOR);
        final double n5 = 16.0;
        final int f37048 = this.f33825.f37048;
        final c37042 f37049 = this.f33825;
        f37049.f37048 *= (int)n4;
        c33820.f33822.m35212(n, n2, n3).m35217(0.0, 0.0).m35221(this.f33825).m35224();
        c33820.f33822.m35212(n + n5, n2, n3).m35217(1.0, 0.0).m35221(this.f33825).m35224();
        c33820.f33822.m35212(n + n5, n2 + n5, n3).m35217(1.0, 1.0).m35221(this.f33825).m35224();
        c33820.f33822.m35212(n, n2, n3).m35217(0.0, 0.0).m35221(this.f33825).m35224();
        c33820.f33822.m35212(n + n5, n2 + n5, n3).m35217(1.0, 1.0).m35221(this.f33825).m35224();
        c33820.f33822.m35212(n, n2 + n5, n3).m35217(0.0, 1.0).m35221(this.f33825).m35224();
        ((Texture)c34924.f34926.get(this.f33824)).bindTexture();
        c33820.f33822.m35226(true);
        this.f33825.f37048 = f37048;
    }
    
    public void m33843(final double n, final double n2, final double n3) {
        this.m33835(n, n2, n3, 1.0);
    }
    
    private int m33848() {
        int n = 0;
        final Iterator<String> iterator = c34924.f34926.keySet().iterator();
        while (iterator.hasNext()) {
            if (this.f33824.equals(iterator.next())) {
                return n;
            }
            ++n;
        }
        return -1;
    }
    
    private int m33852(final int n) {
        if (n < 0) {
            return c34924.f34926.size() + n;
        }
        if (n >= c34924.f34926.size()) {
            return n - c34924.f34926.size();
        }
        return n;
    }
    
    private String m33855(int m33852) {
        m33852 = this.m33852(m33852);
        int n = 0;
        for (final String s : c34924.f34926.keySet()) {
            if (n == m33852) {
                return s;
            }
            ++n;
        }
        return "Square";
    }
    
    public void m33860() {
        this.f33824 = this.m33855(this.m33848() - 1);
    }
    
    public void m33862() {
        this.f33824 = this.m33855(this.m33848() + 1);
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("name", this.f33823);
        compoundTag.putString("icon", this.f33824);
        compoundTag.put("color", (Tag)this.f33825.m34682());
        compoundTag.putInt("x", this.f33826);
        compoundTag.putInt("y", this.f33827);
        compoundTag.putInt("z", this.f33828);
        compoundTag.putBoolean("visible", this.f33829);
        compoundTag.putInt("maxVisibleDistance", this.f33830);
        compoundTag.putDouble("scale", this.f33831);
        compoundTag.putBoolean("overworld", this.f33832);
        compoundTag.putBoolean("nether", this.f33833);
        compoundTag.putBoolean("end", this.f33834);
        return compoundTag;
    }
    
    public c33820 m33864(final CompoundTag compoundTag) {
        this.f33823 = compoundTag.getString("name");
        this.f33824 = compoundTag.getString("icon");
        this.f33825.m37060(compoundTag.getCompound("color"));
        this.f33826 = compoundTag.getInt("x");
        this.f33827 = compoundTag.getInt("y");
        this.f33828 = compoundTag.getInt("z");
        this.f33829 = compoundTag.getBoolean("visible");
        this.f33830 = compoundTag.getInt("maxVisibleDistance");
        this.f33831 = compoundTag.getDouble("scale");
        this.f33832 = compoundTag.getBoolean("overworld");
        this.f33833 = compoundTag.getBoolean("nether");
        this.f33834 = compoundTag.getBoolean("end");
        if (!c34924.f34926.containsKey(this.f33824)) {
            this.f33824 = "Square";
        }
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m33864(compoundTag);
    }
    
    static {
        f33821 = new String[] { "Meteor on Crack!", "Square", "Square", "name", "icon", "color", "x", "y", "z", "visible", "maxVisibleDistance", "scale", "overworld", "nether", "end", "name", "icon", "color", "x", "y", "z", "visible", "maxVisibleDistance", "scale", "overworld", "nether", "end", "Square" };
        f33822 = new c35197(100);
    }
}
