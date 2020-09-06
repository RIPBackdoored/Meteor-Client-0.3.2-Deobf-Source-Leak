package minegame159.meteorclient;

import java.util.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c38917
{
    private static final String[] f38918;
    private String f38919;
    private String f38920;
    private List<class_1299<?>> f38921;
    private Consumer<List<class_1299<?>>> f38922;
    private Consumer<Value<List<class_1299<?>>>> f38923;
    private boolean f38924;
    
    public c38917() {
        super();
        this.f38919 = "undefined";
        this.f38920 = "";
        this.f38924 = false;
    }
    
    public c38917 m38925(final String f38919) {
        this.f38919 = f38919;
        return this;
    }
    
    public c38917 m38928(final String f38920) {
        this.f38920 = f38920;
        return this;
    }
    
    public c38917 m38931(final List<class_1299<?>> f38921) {
        this.f38921 = f38921;
        return this;
    }
    
    public c38917 m38934(final Consumer<List<class_1299<?>>> f38922) {
        this.f38922 = f38922;
        return this;
    }
    
    public c38917 m38937(final Consumer<Value<List<class_1299<?>>>> f38923) {
        this.f38923 = f38923;
        return this;
    }
    
    public c38917 m38940() {
        this.f38924 = true;
        return this;
    }
    
    public c33686 m38942() {
        return new c33686(this.f38919, this.f38920, this.f38921, this.f38922, this.f38923, this.f38924);
    }
    
    static {
        f38918 = new String[] { "undefined", "" };
    }
}
