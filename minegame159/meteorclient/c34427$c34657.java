package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;

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
