package minegame159.meteorclient;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import java.util.*;

public class c31543 implements c34681<c31543>
{
    private static final String[] f31544;
    public String f31545;
    public boolean f31546;
    public c37042 f31547;
    public boolean f31548;
    public boolean f31549;
    
    public c31543(final String f31545) {
        super();
        this.f31546 = true;
        this.f31547 = new c37042(0, 255, 180);
        this.f31548 = false;
        this.f31549 = true;
        this.f31545 = f31545;
    }
    
    public c31543(final PlayerEntity playerEntity) {
        this(playerEntity.getGameProfile().getName());
    }
    
    public c31543(final CompoundTag compoundTag) {
        super();
        this.f31546 = true;
        this.f31547 = new c37042(0, 255, 180);
        this.f31548 = false;
        this.f31549 = true;
        this.m31550(compoundTag);
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("name", this.f31545);
        compoundTag.putBoolean("trusted", this.f31546);
        compoundTag.put("color", (Tag)this.f31547.m34682());
        compoundTag.putBoolean("attack", this.f31548);
        compoundTag.putBoolean("showInTracers", this.f31549);
        return compoundTag;
    }
    
    public c31543 m31550(final CompoundTag compoundTag) {
        this.f31545 = compoundTag.getString("name");
        this.f31546 = compoundTag.getBoolean("trusted");
        this.f31547.m37060(compoundTag.getCompound("color"));
        this.f31548 = compoundTag.getBoolean("attack");
        this.f31549 = compoundTag.getBoolean("showInTracers");
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f31545, ((c31543)o).f31545));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f31545);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m31550(compoundTag);
    }
    
    static {
        f31544 = new String[] { "name", "trusted", "color", "attack", "showInTracers", "name", "trusted", "color", "attack", "showInTracers" };
    }
}
