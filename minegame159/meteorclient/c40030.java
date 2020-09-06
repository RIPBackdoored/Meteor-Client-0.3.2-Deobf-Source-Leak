package minegame159.meteorclient;

import net.minecraft.nbt.*;
import java.util.*;

public class c40030 implements c34681<c40030>
{
    private static final String[] f40031;
    public static final c40030 f40032;
    public double f40033;
    public double f40034;
    
    public c40030(final double f40033, final double f40034) {
        super();
        this.f40033 = f40033;
        this.f40034 = f40034;
    }
    
    public c40030() {
        this(0.0, 0.0);
    }
    
    public c40030(final c40030 c40030) {
        this(c40030.f40033, c40030.f40034);
    }
    
    public void m40035(final double f40033, final double f40034) {
        this.f40033 = f40033;
        this.f40034 = f40034;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putDouble("x", this.f40033);
        compoundTag.putDouble("y", this.f40034);
        return compoundTag;
    }
    
    public c40030 m40041(final CompoundTag compoundTag) {
        this.f40033 = compoundTag.getDouble("x");
        this.f40034 = compoundTag.getDouble("y");
        return this;
    }
    
    @Override
    public String toString() {
        return this.f40033 + ", " + this.f40034;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final c40030 c40030 = (c40030)o;
        return Double.compare(c40030.f40033, this.f40033) == 0 && Double.compare(c40030.f40034, this.f40034) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f40033, this.f40034);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m40041(compoundTag);
    }
    
    static {
        f40031 = new String[] { "x", "y", "x", "y", ", " };
        f40032 = new c40030(0.0, 0.0);
    }
}
