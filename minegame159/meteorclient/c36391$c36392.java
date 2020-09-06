package minegame159.meteorclient;

import java.util.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c36392
{
    private static final String[] f36393;
    private String f36394;
    private String f36395;
    private List<class_3414> f36396;
    private Consumer<List<class_3414>> f36397;
    private Consumer<Value<List<class_3414>>> f36398;
    
    public c36392() {
        super();
        this.f36394 = "undefined";
        this.f36395 = "";
    }
    
    public c36392 m36399(final String f36394) {
        this.f36394 = f36394;
        return this;
    }
    
    public c36392 m36402(final String f36395) {
        this.f36395 = f36395;
        return this;
    }
    
    public c36392 m36405(final List<class_3414> f36396) {
        this.f36396 = f36396;
        return this;
    }
    
    public c36392 m36408(final Consumer<List<class_3414>> f36397) {
        this.f36397 = f36397;
        return this;
    }
    
    public c36392 m36411(final Consumer<Value<List<class_3414>>> f36398) {
        this.f36398 = f36398;
        return this;
    }
    
    public c36391 m36414() {
        return new c36391(this.f36394, this.f36395, this.f36396, this.f36397, this.f36398);
    }
    
    static {
        f36393 = new String[] { "undefined", "" };
    }
}
