package meteorclient;

import me.zero.alpine.listener.*;
import meteorclient.setting.*;
import java.util.*;
import net.minecraft.nbt.*;
import minegame159.meteorclient.*;

public abstract class Module extends c38667
{
    private static final String[] f35289;
    private boolean f35290;
    private boolean f35291;
    
    public Module(final Category category, final String s, final String s2) {
        super(category, s, s2);
        this.f35291 = true;
    }
    
    public void m35292() {
    }
    
    public void m35294() {
    }
    
    public void m35296(final boolean b) {
        if (!this.f35290) {
            this.f35290 = true;
            c34030.f34033.m34075(this);
            MeteorClient.eventBus.subscribe((Listenable)this);
            for (final Value<T> value : this.f38675) {
                if (value.f33464 != null) {
                    value.f33464.accept(value);
                }
            }
            if (b) {
                this.m35292();
            }
        }
        else {
            this.f35290 = false;
            c34030.f34033.m34078(this);
            MeteorClient.eventBus.unsubscribe((Listenable)this);
            if (b) {
                this.m35294();
            }
        }
    }
    
    public void m35300() {
        this.m35296(true);
    }
    
    @Override
    public void m38684(final boolean b) {
        this.m35296(b);
    }
    
    public String m35302() {
        return null;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m34682 = super.m34682();
        m34682.putBoolean("active", this.f35290);
        m34682.putBoolean("visible", this.f35291);
        return m34682;
    }
    
    public Module m35306(final CompoundTag compoundTag) {
        super.m38691(compoundTag);
        if (compoundTag.getBoolean("active") != this.m35315()) {
            this.m35296(false);
        }
        this.m35310(compoundTag.getBoolean("visible"));
        return this;
    }
    
    public void m35310(final boolean f35291) {
        this.f35291 = f35291;
        MeteorClient.eventBus.post((Object)c34429.m34483(this));
    }
    
    public boolean m35313() {
        return this.f35291;
    }
    
    public boolean m35315() {
        return this.f35290;
    }
    
    @Override
    public /* bridge */ c38667 m38691(final CompoundTag compoundTag) {
        return this.m35306(compoundTag);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m35306(compoundTag);
    }
    
    static {
        f35289 = new String[] { "active", "visible", "active", "visible" };
    }
}
