package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;

public static class c36674
{
    private static final String[] f36675;
    private String f36676;
    private String f36677;
    private String f36678;
    private Consumer<String> f36679;
    private Consumer<Value<String>> f36680;
    
    public c36674() {
        super();
        this.f36676 = "undefined";
        this.f36677 = "";
    }
    
    public c36674 m36681(final String f36676) {
        this.f36676 = f36676;
        return this;
    }
    
    public c36674 m36684(final String f36677) {
        this.f36677 = f36677;
        return this;
    }
    
    public c36674 m36687(final String f36678) {
        this.f36678 = f36678;
        return this;
    }
    
    public c36674 m36690(final Consumer<String> f36679) {
        this.f36679 = f36679;
        return this;
    }
    
    public c36674 m36693(final Consumer<Value<String>> f36680) {
        this.f36680 = f36680;
        return this;
    }
    
    public c36225 m36696() {
        return new c36225(this.f36676, this.f36677, this.f36678, this.f36679, this.f36680);
    }
    
    static {
        f36675 = new String[] { "undefined", "" };
    }
}
