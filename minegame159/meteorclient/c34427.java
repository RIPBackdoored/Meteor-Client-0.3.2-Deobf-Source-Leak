package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.nbt.*;

public class c34427 extends Value<Boolean>
{
    private static final String[] f36433;
    
    private c34427(final String s, final String s2, final Boolean b, final Consumer<Boolean> consumer, final Consumer<Value<Boolean>> consumer2) {
        super(s, s2, b, consumer, consumer2);
        this.f33465 = new c38264(this.m33466());
        ((c38264)this.f33465).f38265 = (c38264 -> this.m33468(c38264.f38266));
    }
    
    protected Boolean m36434(final String s) {
        if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1")) {
            return true;
        }
        if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("0")) {
            return false;
        }
        if (s.equalsIgnoreCase("toggle")) {
            return !this.m33466();
        }
        return null;
    }
    
    @Override
    public void m33485() {
        ((c38264)this.f33465).f38266 = this.m33466();
    }
    
    protected boolean m36438(final Boolean b) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)true(default), (highlight)false (default)or (highlight)toggle";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        m33490.putBoolean("value", (boolean)this.m33466());
        return m33490;
    }
    
    public Boolean m36444(final CompoundTag compoundTag) {
        this.m33468(compoundTag.getBoolean("value"));
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m36438((Boolean)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m36434(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m36444(compoundTag);
    }
    
    private /* synthetic */ void m36450(final c38264 c38264) {
        this.m33468(c38264.f38266);
    }
    
    c34427(final String s, final String s2, final Boolean b, final Consumer consumer, final Consumer consumer2, final c34428 c34428) {
        this(s, s2, b, consumer, consumer2);
    }
    
    static {
        f36433 = new String[] { "true", "1", "false", "0", "toggle", "(highlight)true(default), (highlight)false (default)or (highlight)toggle", "value", "value" };
    }
    
    public static class c34657
    {
        private static final String[] f34658;
        private String f34659;
        private String f34660;
        private Boolean f34661;
        private Consumer<Boolean> f34662;
        private Consumer<Value<Boolean>> f34663;
        
        public c34657() {
            super();
            this.f34659 = "undefined";
            this.f34660 = "";
        }
        
        public c34657 m34664(final String f34659) {
            this.f34659 = f34659;
            return this;
        }
        
        public c34657 m34667(final String f34660) {
            this.f34660 = f34660;
            return this;
        }
        
        public c34657 m34670(final boolean b) {
            this.f34661 = b;
            return this;
        }
        
        public c34657 m34673(final Consumer<Boolean> f34662) {
            this.f34662 = f34662;
            return this;
        }
        
        public c34657 m34676(final Consumer<Value<Boolean>> f34663) {
            this.f34663 = f34663;
            return this;
        }
        
        public c34427 m34679() {
            return new c34427(this.f34659, this.f34660, this.f34661, this.f34662, this.f34663, null);
        }
        
        static {
            f34658 = new String[] { "undefined", "" };
        }
    }
    
    static class c34428
    {
    }
}
