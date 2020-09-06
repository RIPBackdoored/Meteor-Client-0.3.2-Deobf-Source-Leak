package minegame159.meteorclient;

import net.minecraft.nbt.*;

public class c31871 implements c34681<c31871>
{
    private static final String[] f31872;
    private c40030 f31873;
    private boolean f31874;
    final /* synthetic */ c31870 f31875;
    
    private c31871(final c31870 f31875, final boolean f31876) {
        this.f31875 = f31875;
        super();
        this.f31873 = new c40030(-1.0, -1.0);
        this.f31874 = f31876;
    }
    
    public double m31876() {
        return this.f31873.f40033;
    }
    
    public double m31878() {
        return this.f31873.f40034;
    }
    
    public void m31880(final double n, final double n2) {
        this.f31873.m40035(n, n2);
    }
    
    public boolean m31884() {
        return this.f31874;
    }
    
    public void m31886(final boolean f31874) {
        this.f31874 = f31874;
        c33436.f34122.m37303();
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("pos", (Tag)this.f31873.m34682());
        compoundTag.putBoolean("expanded", this.f31874);
        return compoundTag;
    }
    
    public c31871 m31889(final CompoundTag compoundTag) {
        this.f31873.m40041(compoundTag.getCompound("pos"));
        this.f31874 = compoundTag.getBoolean("expanded");
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m31889(compoundTag);
    }
    
    c31871(final c31870 c31870, final boolean b, final c34261 c31871) {
        this(c31870, b);
    }
    
    static {
        f31872 = new String[] { "pos", "expanded", "pos", "expanded" };
    }
}
