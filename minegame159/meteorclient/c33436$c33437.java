package minegame159.meteorclient;

import net.minecraft.nbt.*;

public class c33437 implements c34681<c33437>
{
    private static final String[] f33438;
    private boolean f33439;
    private boolean f33440;
    final /* synthetic */ c33436 f33441;
    
    private c33437(final c33436 f33441) {
        this.f33441 = f33441;
        super();
        this.f33439 = true;
        this.f33440 = true;
    }
    
    public void m33442(final boolean f33439) {
        this.f33439 = f33439;
        this.f33441.m37303();
    }
    
    public boolean m33445() {
        return this.f33439;
    }
    
    public void m33447(final boolean f33440) {
        this.f33440 = f33440;
        this.f33441.m37303();
    }
    
    public boolean m33450() {
        return this.f33440;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putBoolean("craftByOne", this.f33439);
        compoundTag.putBoolean("stopWhenNoIngredients", this.f33440);
        return compoundTag;
    }
    
    public c33437 m33452(final CompoundTag compoundTag) {
        this.f33439 = compoundTag.getBoolean("craftByOne");
        this.f33440 = compoundTag.getBoolean("stopWhenNoIngredients");
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m33452(compoundTag);
    }
    
    c33437(final c33436 c33436, final c33736 c33437) {
        this(c33436);
    }
    
    static {
        f33438 = new String[] { "craftByOne", "stopWhenNoIngredients", "craftByOne", "stopWhenNoIngredients" };
    }
}
