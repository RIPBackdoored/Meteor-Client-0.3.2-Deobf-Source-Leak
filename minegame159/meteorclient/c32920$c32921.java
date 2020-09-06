package minegame159.meteorclient;

import java.util.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c32921
{
    private static final String[] f32922;
    private String f32923;
    private String f32924;
    private List<class_2591<?>> f32925;
    private Consumer<List<class_2591<?>>> f32926;
    private Consumer<Value<List<class_2591<?>>>> f32927;
    
    public c32921() {
        super();
        this.f32923 = "undefined";
        this.f32924 = "";
    }
    
    public c32921 m32928(final String f32923) {
        this.f32923 = f32923;
        return this;
    }
    
    public c32921 m32931(final String f32924) {
        this.f32924 = f32924;
        return this;
    }
    
    public c32921 m32934(final List<class_2591<?>> f32925) {
        this.f32925 = f32925;
        return this;
    }
    
    public c32921 m32937(final Consumer<List<class_2591<?>>> f32926) {
        this.f32926 = f32926;
        return this;
    }
    
    public c32921 m32940(final Consumer<Value<List<class_2591<?>>>> f32927) {
        this.f32927 = f32927;
        return this;
    }
    
    public c32920 m32943() {
        return new c32920(this.f32923, this.f32924, this.f32925, this.f32926, this.f32927);
    }
    
    static {
        f32922 = new String[] { "undefined", "" };
    }
}
