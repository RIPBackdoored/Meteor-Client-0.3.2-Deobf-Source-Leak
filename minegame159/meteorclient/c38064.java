package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import meteorclient.util.*;
import net.minecraft.entity.effect.*;
import net.minecraft.util.registry.*;
import net.minecraft.nbt.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import net.minecraft.util.*;
import java.util.*;

public class c38064 extends Value<Object2IntMap<class_1291>>
{
    private static final String[] f38309;
    
    public c38064(final String s, final String s2, final Object2IntMap<class_1291> object2IntMap, final Consumer<Object2IntMap<class_1291>> consumer, final Consumer<Value<Object2IntMap<class_1291>>> consumer2) {
        super(s, s2, object2IntMap, consumer, consumer2);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c34391(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new Object2IntArrayMap((Object2IntMap)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected Object2IntMap<class_1291> m38312(final String s) {
        return EnchantUtil.m35547();
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m38316(final Object2IntMap<class_1291> object2IntMap) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)not implemented";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final CompoundTag compoundTag = new CompoundTag();
        for (final StatusEffect statusEffect : ((Value<Object2IntMap>)this).m33466().keySet()) {
            compoundTag.putInt(Registry.STATUS_EFFECT.getId((Object)statusEffect).toString(), ((Value<Object2IntMap>)this).m33466().getInt((Object)statusEffect));
        }
        m33490.put("value", (Tag)compoundTag);
        return m33490;
    }
    
    public Object2IntMap<class_1291> m38324(final class_2487 class_2487) {
        ((Value<Object2IntMap>)this).m33466().clear();
        final CompoundTag compound = ((CompoundTag)class_2487).getCompound("value");
        for (final String s : compound.getKeys()) {
            ((Value<Object2IntMap>)this).m33466().put(Registry.STATUS_EFFECT.get(new Identifier(s)), compound.getInt(s));
        }
        this.m33480();
        return (Object2IntMap<class_1291>)((Value<Object2IntMap>)this).m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m38316((Object2IntMap<class_1291>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m38312(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m38324(compoundTag);
    }
    
    private /* synthetic */ void m38332(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c34391(this));
    }
    
    static {
        f38309 = new String[] { "Select", "(highlight)not implemented", "value", "value" };
    }
    
    public static class c38065
    {
        private static final String[] f38066;
        private String f38067;
        private String f38068;
        private Object2IntMap<class_1291> f38069;
        private Consumer<Object2IntMap<class_1291>> f38070;
        private Consumer<Value<Object2IntMap<class_1291>>> f38071;
        
        public c38065() {
            super();
            this.f38067 = "undefined";
            this.f38068 = "";
        }
        
        public c38065 m38072(final String f38067) {
            this.f38067 = f38067;
            return this;
        }
        
        public c38065 m38075(final String f38068) {
            this.f38068 = f38068;
            return this;
        }
        
        public c38065 m38078(final Object2IntMap<class_1291> f38069) {
            this.f38069 = f38069;
            return this;
        }
        
        public c38065 m38081(final Consumer<Object2IntMap<class_1291>> f38070) {
            this.f38070 = f38070;
            return this;
        }
        
        public c38065 m38084(final Consumer<Value<Object2IntMap<class_1291>>> f38071) {
            this.f38071 = f38071;
            return this;
        }
        
        public c38064 m38087() {
            return new c38064(this.f38067, this.f38068, this.f38069, this.f38070, this.f38071);
        }
        
        static {
            f38066 = new String[] { "undefined", "" };
        }
    }
}
