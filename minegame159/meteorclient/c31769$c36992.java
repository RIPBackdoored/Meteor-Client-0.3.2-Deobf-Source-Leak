package minegame159.meteorclient;

import java.util.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c36992
{
    private static final String[] f36993;
    private String f36994;
    private String f36995;
    private List<class_2248> f36996;
    private Consumer<List<class_2248>> f36997;
    private Consumer<Value<List<class_2248>>> f36998;
    
    public c36992() {
        super();
        this.f36994 = "undefined";
        this.f36995 = "";
    }
    
    public c36992 m36999(final String f36994) {
        this.f36994 = f36994;
        return this;
    }
    
    public c36992 m37002(final String f36995) {
        this.f36995 = f36995;
        return this;
    }
    
    public c36992 m37005(final List<class_2248> f36996) {
        this.f36996 = f36996;
        return this;
    }
    
    public c36992 m37008(final Consumer<List<class_2248>> f36997) {
        this.f36997 = f36997;
        return this;
    }
    
    public c36992 m37011(final Consumer<Value<List<class_2248>>> f36998) {
        this.f36998 = f36998;
        return this;
    }
    
    public c31769 m37014() {
        return new c31769(this.f36994, this.f36995, this.f36996, this.f36997, this.f36998);
    }
    
    static {
        f36993 = new String[] { "undefined", "" };
    }
}
