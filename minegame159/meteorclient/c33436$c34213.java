package minegame159.meteorclient;

import net.minecraft.nbt.*;

public class c34213 implements c34681<c34213>
{
    private static final String[] f34214;
    private c40030 f34215;
    private boolean f34216;
    final /* synthetic */ c33436 f34217;
    
    private c34213(final c33436 f34217, final boolean f34218) {
        this.f34217 = f34217;
        super();
        this.f34215 = new c40030(-1.0, -1.0);
        this.f34216 = f34218;
    }
    
    public double m34218() {
        return this.f34215.f40033;
    }
    
    public double m34220() {
        return this.f34215.f40034;
    }
    
    public void m34222(final double n, final double n2) {
        this.f34215.m40035(n, n2);
        this.f34217.m37303();
    }
    
    public boolean m34226() {
        return this.f34216;
    }
    
    public void m34228(final boolean f34216) {
        this.f34216 = f34216;
        this.f34217.m37303();
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("pos", (Tag)this.f34215.m34682());
        compoundTag.putBoolean("expanded", this.f34216);
        return compoundTag;
    }
    
    public c34213 m34231(final CompoundTag compoundTag) {
        this.f34215.m40041(compoundTag.getCompound("pos"));
        this.f34216 = compoundTag.getBoolean("expanded");
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m34231(compoundTag);
    }
    
    c34213(final c33436 c33436, final boolean b, final c33736 c33437) {
        this(c33436, b);
    }
    
    static {
        f34214 = new String[] { "pos", "expanded", "pos", "expanded" };
    }
}
