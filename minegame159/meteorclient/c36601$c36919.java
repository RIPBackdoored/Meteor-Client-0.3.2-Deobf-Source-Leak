package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;

public static class c36919<T extends Enum<?>>
{
    private static final String[] f36920;
    protected String f36921;
    protected String f36922;
    protected T f36923;
    protected Consumer<T> f36924;
    protected Consumer<Value<T>> f36925;
    
    public c36919() {
        super();
        this.f36921 = "undefined";
        this.f36922 = "";
    }
    
    public c36919<T> m36926(final String f36921) {
        this.f36921 = f36921;
        return this;
    }
    
    public c36919<T> m36929(final String f36922) {
        this.f36922 = f36922;
        return this;
    }
    
    public c36919<T> m36932(final T f36923) {
        this.f36923 = f36923;
        return this;
    }
    
    public c36919<T> m36935(final Consumer<T> f36924) {
        this.f36924 = f36924;
        return this;
    }
    
    public c36919<T> m36938(final Consumer<Value<T>> f36925) {
        this.f36925 = f36925;
        return this;
    }
    
    public c36601<T> m36941() {
        return new c36601<T>(this.f36921, this.f36922, this.f36923, this.f36924, this.f36925);
    }
    
    static {
        f36920 = new String[] { "undefined", "" };
    }
}
