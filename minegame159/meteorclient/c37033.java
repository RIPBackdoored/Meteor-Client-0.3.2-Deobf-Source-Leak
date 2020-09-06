package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.nbt.*;

public class c37033 extends Value<Double>
{
    private static final String[] f39308;
    private final Double f39309;
    private final Double f39310;
    private final Double f39311;
    private final Double f39312;
    
    private c37033(final String s, final String s2, final Double n, final Consumer<Double> consumer, final Consumer<Value<Double>> consumer2, final Double f39309, final Double f39310, final Double f39311, final Double f39312, final boolean b) {
        super(s, s2, n, consumer, consumer2);
        this.f39309 = f39309;
        this.f39310 = f39310;
        this.f39311 = f39311;
        this.f39312 = f39312;
        this.f33465 = new c36873((f39311 != null) ? f39311 : 0.0, (f39312 != null) ? f39312 : 10.0, this.m33466(), b);
        ((c36873)this.f33465).f36874 = (c36873 -> {
            if (!this.m33468(Math.round(c36873.m36877() * 1000.0) / 1000.0)) {
                c36873.m36879(this.m33466());
            }
        });
    }
    
    protected Double m39313(final String s) {
        try {
            return Double.parseDouble(s.trim());
        }
        catch (NumberFormatException ex) {
            return null;
        }
    }
    
    @Override
    public void m33485() {
        ((c36873)this.f33465).m36879(this.m33466());
    }
    
    protected boolean m39318(final Double n) {
        return (this.f39309 == null || n >= this.f39309) && (this.f39310 == null || n <= this.f39310);
    }
    
    @Override
    protected String m33489() {
        final String s = "(highlight)";
        String s2;
        if (this.f39309 == null) {
            s2 = s + "inf";
        }
        else {
            s2 = s + this.f39309;
        }
        final String string = s2 + " (default)- (highlight)";
        String s3;
        if (this.f39310 == null) {
            s3 = string + "inf";
        }
        else {
            s3 = string + this.f39310;
        }
        return s3;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        m33490.putDouble("value", (double)this.m33466());
        return m33490;
    }
    
    public Double m39325(final CompoundTag compoundTag) {
        this.m33468(compoundTag.getDouble("value"));
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m39318((Double)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m39313(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m39325(compoundTag);
    }
    
    private /* synthetic */ void m39331(final c36873 c36873) {
        if (!this.m33468(Math.round(c36873.m36877() * 1000.0) / 1000.0)) {
            c36873.m36879(this.m33466());
        }
    }
    
    c37033(final String s, final String s2, final Double n, final Consumer consumer, final Consumer consumer2, final Double n2, final Double n3, final Double n4, final Double n5, final boolean b, final c37034 c37034) {
        this(s, s2, n, consumer, consumer2, n2, n3, n4, n5, b);
    }
    
    static {
        f39308 = new String[] { "(highlight)", "inf", " (default)- (highlight)", "inf", "value", "value" };
    }
    
    public static class c38947
    {
        private static final String[] f38948;
        private String f38949;
        private String f38950;
        private Double f38951;
        private Consumer<Double> f38952;
        private Consumer<Value<Double>> f38953;
        private Double f38954;
        private Double f38955;
        private Double f38956;
        private Double f38957;
        private boolean f38958;
        
        public c38947() {
            super();
            this.f38949 = "undefined";
            this.f38950 = "";
        }
        
        public c38947 m38959(final String f38949) {
            this.f38949 = f38949;
            return this;
        }
        
        public c38947 m38962(final String f38950) {
            this.f38950 = f38950;
            return this;
        }
        
        public c38947 m38965(final double n) {
            this.f38951 = n;
            return this;
        }
        
        public c38947 m38968(final Consumer<Double> f38952) {
            this.f38952 = f38952;
            return this;
        }
        
        public c38947 m38971(final Consumer<Value<Double>> f38953) {
            this.f38953 = f38953;
            return this;
        }
        
        public c38947 m38974(final double n) {
            this.f38954 = n;
            return this;
        }
        
        public c38947 m38977(final double n) {
            this.f38955 = n;
            return this;
        }
        
        public c38947 m38980(final double n) {
            this.f38956 = n;
            return this;
        }
        
        public c38947 m38983(final double n) {
            this.f38957 = n;
            return this;
        }
        
        public c38947 m38986() {
            this.f38958 = true;
            return this;
        }
        
        public c37033 m38988() {
            return new c37033(this.f38949, this.f38950, this.f38951, this.f38952, this.f38953, this.f38954, this.f38955, this.f38956, this.f38957, this.f38958, null);
        }
        
        static {
            f38948 = new String[] { "undefined", "" };
        }
    }
    
    static class c37034
    {
    }
}
