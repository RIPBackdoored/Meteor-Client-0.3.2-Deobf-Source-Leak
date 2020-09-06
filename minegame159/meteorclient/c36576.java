package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.nbt.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import java.util.*;

public class c36576 extends Value<Object2BooleanMap<Class<? extends class_2596<?>>>>
{
    private static final String[] f38799;
    
    public c36576(final String s, final String s2, final Object2BooleanMap<Class<? extends class_2596<?>>> object2BooleanMap, final Consumer<Object2BooleanMap<Class<? extends class_2596<?>>>> consumer, final Consumer<Value<Object2BooleanMap<Class<? extends class_2596<?>>>>> consumer2) {
        super(s, s2, object2BooleanMap, consumer, consumer2);
        this.f33462 = (T)new Object2BooleanArrayMap((Object2BooleanMap)object2BooleanMap);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c35173(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new Object2BooleanArrayMap((Object2BooleanMap)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected Object2BooleanMap<Class<? extends class_2596<?>>> m38802(final String s) {
        return (Object2BooleanMap<Class<? extends class_2596<?>>>)new Object2BooleanArrayMap();
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m38806(final Object2BooleanMap<Class<? extends class_2596<?>>> object2BooleanMap) {
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
        for (final Class<? extends class_2596<?>> clazz : ((Value<Object2BooleanMap>)this).m33466().keySet()) {
            compoundTag.putBoolean(c34333.m34339(clazz), ((Value<Object2BooleanMap>)this).m33466().getBoolean((Object)clazz));
        }
        m33490.put("value", (Tag)compoundTag);
        return m33490;
    }
    
    public Object2BooleanMap<Class<? extends class_2596<?>>> m38814(final class_2487 class_2487) {
        ((Value<Object2BooleanMap>)this).m33466().clear();
        final CompoundTag compound = ((CompoundTag)class_2487).getCompound("value");
        for (final String s : compound.getKeys()) {
            final Class<? extends class_2596<?>> m34342 = c34333.m34342(s);
            if (m34342 != null) {
                ((Value<Object2BooleanMap>)this).m33466().put((Object)m34342, compound.getBoolean(s));
            }
        }
        this.m33480();
        return (Object2BooleanMap<Class<? extends class_2596<?>>>)((Value<Object2BooleanMap>)this).m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m38806((Object2BooleanMap<Class<? extends class_2596<?>>>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m38802(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m38814(compoundTag);
    }
    
    private /* synthetic */ void m38823(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c35173(this));
    }
    
    static {
        f38799 = new String[] { "Select", "(highlight)not implemented", "value", "value" };
    }
    
    public static class c36577
    {
        private static final String[] f36578;
        private String f36579;
        private String f36580;
        private Object2BooleanMap<Class<? extends class_2596<?>>> f36581;
        private Consumer<Object2BooleanMap<Class<? extends class_2596<?>>>> f36582;
        private Consumer<Value<Object2BooleanMap<Class<? extends class_2596<?>>>>> f36583;
        
        public c36577() {
            super();
            this.f36579 = "undefined";
            this.f36580 = "";
        }
        
        public c36577 m36584(final String f36579) {
            this.f36579 = f36579;
            return this;
        }
        
        public c36577 m36587(final String f36580) {
            this.f36580 = f36580;
            return this;
        }
        
        public c36577 m36590(final Object2BooleanMap<Class<? extends class_2596<?>>> f36581) {
            this.f36581 = f36581;
            return this;
        }
        
        public c36577 m36593(final Consumer<Object2BooleanMap<Class<? extends class_2596<?>>>> f36582) {
            this.f36582 = f36582;
            return this;
        }
        
        public c36577 m36596(final Consumer<Value<Object2BooleanMap<Class<? extends class_2596<?>>>>> f36583) {
            this.f36583 = f36583;
            return this;
        }
        
        public c36576 m36599() {
            return new c36576(this.f36579, this.f36580, this.f36581, this.f36582, this.f36583);
        }
        
        static {
            f36578 = new String[] { "undefined", "" };
        }
    }
}
