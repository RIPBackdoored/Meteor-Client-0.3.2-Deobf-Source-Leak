package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.nbt.*;

public class c36225 extends Value<String>
{
    private static final String[] f36226;
    
    public c36225(final String s, final String s2, final String f33462, final Consumer<String> consumer, final Consumer<Value<String>> consumer2) {
        super(s, s2, f33462, consumer, consumer2);
        this.f33462 = (T)f33462;
        this.f33465 = new c31399(this.m33466(), 200.0);
        ((c31399)this.f33465).f31401 = (c31399 -> {
            if (!this.m33468(c31399.f31403)) {
                c31399.f31403 = this.m33466();
            }
        });
    }
    
    protected String m36227(final String s) {
        return s;
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new String((String)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    @Override
    public void m33485() {
        ((c31399)this.f33465).f31403 = this.m33466();
    }
    
    protected boolean m36233(final String s) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)<text>";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        m33490.putString("value", (String)this.m33466());
        return m33490;
    }
    
    public String m36239(final CompoundTag compoundTag) {
        this.m33468(compoundTag.getString("value"));
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m36233((String)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m36227(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m36239(compoundTag);
    }
    
    private /* synthetic */ void m36245(final c31399 c31399) {
        if (!this.m33468(c31399.f31403)) {
            c31399.f31403 = this.m33466();
        }
    }
    
    static {
        f36226 = new String[] { "(highlight)<text>", "value", "value" };
    }
    
    public static class c36674
    {
        private static final String[] f36675;
        private String f36676;
        private String f36677;
        private String f36678;
        private Consumer<String> f36679;
        private Consumer<Value<String>> f36680;
        
        public c36674() {
            super();
            this.f36676 = "undefined";
            this.f36677 = "";
        }
        
        public c36674 m36681(final String f36676) {
            this.f36676 = f36676;
            return this;
        }
        
        public c36674 m36684(final String f36677) {
            this.f36677 = f36677;
            return this;
        }
        
        public c36674 m36687(final String f36678) {
            this.f36678 = f36678;
            return this;
        }
        
        public c36674 m36690(final Consumer<String> f36679) {
            this.f36679 = f36679;
            return this;
        }
        
        public c36674 m36693(final Consumer<Value<String>> f36680) {
            this.f36680 = f36680;
            return this;
        }
        
        public c36225 m36696() {
            return new c36225(this.f36676, this.f36677, this.f36678, this.f36679, this.f36680);
        }
        
        static {
            f36675 = new String[] { "undefined", "" };
        }
    }
}
