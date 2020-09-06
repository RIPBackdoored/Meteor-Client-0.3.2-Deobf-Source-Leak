package minegame159.meteorclient;

import java.util.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c38993
{
    private static final String[] f38994;
    private String f38995;
    private String f38996;
    private List<class_1887> f38997;
    private Consumer<List<class_1887>> f38998;
    private Consumer<Value<List<class_1887>>> f38999;
    
    public c38993() {
        super();
        this.f38995 = "undefined";
        this.f38996 = "";
    }
    
    public c38993 m39000(final String f38995) {
        this.f38995 = f38995;
        return this;
    }
    
    public c38993 m39003(final String f38996) {
        this.f38996 = f38996;
        return this;
    }
    
    public c38993 m39006(final List<class_1887> f38997) {
        this.f38997 = f38997;
        return this;
    }
    
    public c38993 m39009(final Consumer<List<class_1887>> f38998) {
        this.f38998 = f38998;
        return this;
    }
    
    public c38993 m39012(final Consumer<Value<List<class_1887>>> f38999) {
        this.f38999 = f38999;
        return this;
    }
    
    public c38020 m39015() {
        return new c38020(this.f38995, this.f38996, this.f38997, this.f38998, this.f38999);
    }
    
    static {
        f38994 = new String[] { "undefined", "" };
    }
}
