package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;

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
