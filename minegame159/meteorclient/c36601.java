package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import java.lang.reflect.*;
import net.minecraft.nbt.*;
import net.minecraft.*;

public class c36601<T extends Enum<?>> extends Value<T>
{
    private static final String[] f36602;
    private T[] f36603;
    
    public c36601(final String s, final String s2, final T t, final Consumer<T> consumer, final Consumer<Value<T>> consumer2) {
        super(s, s2, t, consumer, consumer2);
        try {
            this.f36603 = (T[])t.getClass().getMethod("values", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            final Throwable t2;
            t2.printStackTrace();
        }
        this.f33465 = new c32869<Object>(this.m33466());
        ((c32869)this.f33465).f32871 = (c32869 -> this.m33468((T)c32869.f32872));
    }
    
    protected T m36604(final String s) {
        for (final Enum<?> enum1 : this.f36603) {
            if (s.equalsIgnoreCase(enum1.toString())) {
                return (T)enum1;
            }
        }
        return null;
    }
    
    @Override
    public void m33485() {
        ((c32869)this.f33465).m32886(this.m33466());
    }
    
    protected boolean m36609(final T t) {
        return true;
    }
    
    @Override
    protected String m33489() {
        String s = "";
        for (int i = 0; i < this.f36603.length; ++i) {
            if (i > 0) {
                s += " (default)or ";
            }
            s = s + "(highlight)" + this.f36603[i];
        }
        return s;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        m33490.putString("value", this.m33466().toString());
        return m33490;
    }
    
    public T m36617(final class_2487 class_2487) {
        this.m33476(((CompoundTag)class_2487).getString("value"));
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m36609((T)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m36604(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m36617(compoundTag);
    }
    
    private /* synthetic */ void m36623(final c32869 c32869) {
        this.m33468((T)c32869.f32872);
    }
    
    static {
        f36602 = new String[] { "values", "", " (default)or ", "(highlight)", "value", "value" };
    }
    
    public static class c36919<T extends Enum<?>>
    {
        private static final String[] f36920;
        protected String f36921;
        protected String f36922;
        protected T f36923;
        protected Consumer<T> f36924;
        protected Consumer<Value<T>> f36925;
        
        public c36919() {
            super();
            this.f36921 = "undefined";
            this.f36922 = "";
        }
        
        public c36919<T> m36926(final String f36921) {
            this.f36921 = f36921;
            return this;
        }
        
        public c36919<T> m36929(final String f36922) {
            this.f36922 = f36922;
            return this;
        }
        
        public c36919<T> m36932(final T f36923) {
            this.f36923 = f36923;
            return this;
        }
        
        public c36919<T> m36935(final Consumer<T> f36924) {
            this.f36924 = f36924;
            return this;
        }
        
        public c36919<T> m36938(final Consumer<Value<T>> f36925) {
            this.f36925 = f36925;
            return this;
        }
        
        public c36601<T> m36941() {
            return new c36601<T>(this.f36921, this.f36922, this.f36923, this.f36924, this.f36925);
        }
        
        static {
            f36920 = new String[] { "undefined", "" };
        }
    }
}
