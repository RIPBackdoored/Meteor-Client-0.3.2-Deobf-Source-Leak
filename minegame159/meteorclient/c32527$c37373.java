package minegame159.meteorclient;

import java.util.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c37373
{
    private static final String[] f37374;
    private String f37375;
    private String f37376;
    private List<class_1792> f37377;
    private Consumer<List<class_1792>> f37378;
    private Consumer<Value<List<class_1792>>> f37379;
    
    public c37373() {
        super();
        this.f37375 = "undefined";
        this.f37376 = "";
    }
    
    public c37373 m37380(final String f37375) {
        this.f37375 = f37375;
        return this;
    }
    
    public c37373 m37383(final String f37376) {
        this.f37376 = f37376;
        return this;
    }
    
    public c37373 m37386(final List<class_1792> f37377) {
        this.f37377 = f37377;
        return this;
    }
    
    public c37373 m37389(final Consumer<List<class_1792>> f37378) {
        this.f37378 = f37378;
        return this;
    }
    
    public c37373 m37392(final Consumer<Value<List<class_1792>>> f37379) {
        this.f37379 = f37379;
        return this;
    }
    
    public c32527 m37395() {
        return new c32527(this.f37375, this.f37376, this.f37377, this.f37378, this.f37379);
    }
    
    static {
        f37374 = new String[] { "undefined", "" };
    }
}
