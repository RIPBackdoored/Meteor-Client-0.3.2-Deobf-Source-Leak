package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;

public static class c33180
{
    private static final String[] f33181;
    private String f33182;
    private String f33183;
    private c37042 f33184;
    private Consumer<c37042> f33185;
    private Consumer<Value<c37042>> f33186;
    
    public c33180() {
        super();
        this.f33182 = "undefined";
        this.f33183 = "";
    }
    
    public c33180 m33187(final String f33182) {
        this.f33182 = f33182;
        return this;
    }
    
    public c33180 m33190(final String f33183) {
        this.f33183 = f33183;
        return this;
    }
    
    public c33180 m33193(final c37042 f33184) {
        this.f33184 = f33184;
        return this;
    }
    
    public c33180 m33196(final Consumer<c37042> f33185) {
        this.f33185 = f33185;
        return this;
    }
    
    public c33180 m33199(final Consumer<Value<c37042>> f33186) {
        this.f33186 = f33186;
        return this;
    }
    
    public c33179 m33202() {
        return new c33179(this.f33182, this.f33183, this.f33184, this.f33185, this.f33186);
    }
    
    static {
        f33181 = new String[] { "undefined", "" };
    }
}
