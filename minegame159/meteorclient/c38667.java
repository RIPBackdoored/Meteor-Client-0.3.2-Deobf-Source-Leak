package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import net.minecraft.client.*;
import meteorclient.util.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.nbt.*;
import meteorclient.setting.*;
import java.util.*;

public abstract class c38667 implements Listenable, c34681<c38667>
{
    private static final String[] f38668;
    protected final MinecraftClient mc;
    public final Category category;
    public final String f38671;
    public final String f38672;
    public final String f38673;
    public final c37042 f38674;
    public final c34561 f38675;
    public boolean f38676;
    private int f38677;
    
    public c38667(final Category category, final String f38671, final String f38672) {
        super();
        this.f38675 = new c34561();
        this.f38676 = true;
        this.f38677 = -1;
        this.mc = MinecraftClient.getInstance();
        this.category = category;
        this.f38671 = f38671;
        this.f38672 = EnchantUtil.m35580(f38671);
        this.f38673 = f38672;
        this.f38674 = c37042.m37076(EnchantUtil.m35617(0.0, 360.0), 0.35, 1.0);
    }
    
    public c32480 m38678() {
        return new c34174(this);
    }
    
    public c31923 m38680() {
        return null;
    }
    
    public void m38682() {
        this.mc.openScreen((Screen)this.m38678());
    }
    
    public void m38684(final boolean b) {
        this.m38682();
    }
    
    public void m38687() {
        this.m38684(true);
    }
    
    public CompoundTag m34682() {
        if (!this.f38676) {
            return null;
        }
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("name", this.f38671);
        compoundTag.putInt("key", this.f38677);
        compoundTag.put("settings", (Tag)c33633.m39899((Iterable)this.f38675));
        return compoundTag;
    }
    
    public c38667 m38691(final CompoundTag compoundTag) {
        this.f38677 = compoundTag.getInt("key");
        for (final CompoundTag compoundTag2 : compoundTag.getList("settings", 10)) {
            final Value<?> m34566 = this.f38675.m34566(compoundTag2.getString("name"));
            if (m34566 != null) {
                m34566.m34683(compoundTag2);
            }
        }
        return this;
    }
    
    public void m38698(final int f38677, final boolean b) {
        this.f38677 = f38677;
        if (b) {
            MeteorClient.eventBus.post((Object)c34429.m34481(this));
        }
    }
    
    public void m38702(final int n) {
        this.m38698(n, true);
    }
    
    public int m38705() {
        return this.f38677;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f38671, ((c38667)o).f38671));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f38671);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m38691(compoundTag);
    }
    
    static {
        f38668 = new String[] { "name", "key", "settings", "key", "settings", "name" };
    }
}
