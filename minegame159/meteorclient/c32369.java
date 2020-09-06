package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.nbt.*;

public class c32369 extends Value<Integer>
{
    private static final String[] f33052;
    private final Integer f33053;
    private final Integer f33054;
    private final Integer f33055;
    private final Integer f33056;
    
    private c32369(final String s, final String s2, final Integer n, final Consumer<Integer> consumer, final Consumer<Value<Integer>> consumer2, final Integer f33053, final Integer f33054, final Integer f33055, final Integer f33056) {
        super(s, s2, n, consumer, consumer2);
        this.f33053 = f33053;
        this.f33054 = f33054;
        this.f33055 = f33055;
        this.f33056 = f33056;
        this.f33465 = new c32167((f33055 != null) ? f33055 : 0, (f33056 != null) ? f33056 : 10, this.m33466());
        ((c32167)this.f33465).f32168 = (c32167 -> {
            if (!this.m33468(c32167.m32171())) {
                c32167.m32173(this.m33466());
            }
        });
    }
    
    protected Integer m33057(final String s) {
        try {
            return Integer.parseInt(s.trim());
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }
    
    @Override
    public void m33485() {
        ((c32167)this.f33465).m32173(this.m33466());
    }
    
    protected boolean m33061(final Integer n) {
        return (this.f33053 == null || n >= this.f33053) && (this.f33054 == null || n <= this.f33054);
    }
    
    @Override
    protected String m33489() {
        final String s = "(highlight)";
        String s2;
        if (this.f33053 == null) {
            s2 = s + "inf";
        }
        else {
            s2 = s + this.f33053;
        }
        final String string = s2 + " (default)- (highlight)";
        String s3;
        if (this.f33054 == null) {
            s3 = string + "inf";
        }
        else {
            s3 = string + this.f33054;
        }
        return s3;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        m33490.putInt("value", (int)this.m33466());
        return m33490;
    }
    
    public Integer m33064(final CompoundTag compoundTag) {
        this.m33468(compoundTag.getInt("value"));
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m33061((Integer)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m33057(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m33064(compoundTag);
    }
    
    private /* synthetic */ void m33067(final c32167 c32167) {
        if (!this.m33468(c32167.m32171())) {
            c32167.m32173(this.m33466());
        }
    }
    
    c32369(final String s, final String s2, final Integer n, final Consumer consumer, final Consumer consumer2, final Integer n2, final Integer n3, final Integer n4, final Integer n5, final c34684 c34684) {
        this(s, s2, n, consumer, consumer2, n2, n3, n4, n5);
    }
    
    static {
        f33052 = new String[] { "(highlight)", "inf", " (default)- (highlight)", "inf", "value", "value" };
    }
    
    public static class c32370
    {
        private static final String[] f32371;
        private String f32372;
        private String f32373;
        private Integer f32374;
        private Consumer<Integer> f32375;
        private Consumer<Value<Integer>> f32376;
        private Integer f32377;
        private Integer f32378;
        private Integer f32379;
        private Integer f32380;
        
        public c32370() {
            super();
            this.f32372 = "undefined";
            this.f32373 = "";
        }
        
        public c32370 m32381(final String f32372) {
            this.f32372 = f32372;
            return this;
        }
        
        public c32370 m32384(final String f32373) {
            this.f32373 = f32373;
            return this;
        }
        
        public c32370 m32387(final int n) {
            this.f32374 = n;
            return this;
        }
        
        public c32370 m32390(final Consumer<Integer> f32375) {
            this.f32375 = f32375;
            return this;
        }
        
        public c32370 m32393(final Consumer<Value<Integer>> f32376) {
            this.f32376 = f32376;
            return this;
        }
        
        public c32370 m32396(final int n) {
            this.f32377 = n;
            return this;
        }
        
        public c32370 m32399(final int n) {
            this.f32378 = n;
            return this;
        }
        
        public c32370 m32402(final int n) {
            this.f32379 = n;
            return this;
        }
        
        public c32370 m32405(final int n) {
            this.f32380 = n;
            return this;
        }
        
        public c32369 m32408() {
            return new c32369(this.f32372, this.f32373, this.f32374, this.f32375, this.f32376, this.f32377, this.f32378, this.f32379, this.f32380, null);
        }
        
        static {
            f32371 = new String[] { "undefined", "" };
        }
    }
    
    static class c34684
    {
    }
}
