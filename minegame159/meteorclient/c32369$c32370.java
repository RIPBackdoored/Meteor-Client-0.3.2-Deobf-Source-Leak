package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;

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
