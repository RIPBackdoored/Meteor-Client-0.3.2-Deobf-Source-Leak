package minegame159.meteorclient;

import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c36577
{
    private static final String[] f36578;
    private String f36579;
    private String f36580;
    private Object2BooleanMap<Class<? extends class_2596<?>>> f36581;
    private Consumer<Object2BooleanMap<Class<? extends class_2596<?>>>> f36582;
    private Consumer<Value<Object2BooleanMap<Class<? extends class_2596<?>>>>> f36583;
    
    public c36577() {
        super();
        this.f36579 = "undefined";
        this.f36580 = "";
    }
    
    public c36577 m36584(final String f36579) {
        this.f36579 = f36579;
        return this;
    }
    
    public c36577 m36587(final String f36580) {
        this.f36580 = f36580;
        return this;
    }
    
    public c36577 m36590(final Object2BooleanMap<Class<? extends class_2596<?>>> f36581) {
        this.f36581 = f36581;
        return this;
    }
    
    public c36577 m36593(final Consumer<Object2BooleanMap<Class<? extends class_2596<?>>>> f36582) {
        this.f36582 = f36582;
        return this;
    }
    
    public c36577 m36596(final Consumer<Value<Object2BooleanMap<Class<? extends class_2596<?>>>>> f36583) {
        this.f36583 = f36583;
        return this;
    }
    
    public c36576 m36599() {
        return new c36576(this.f36579, this.f36580, this.f36581, this.f36582, this.f36583);
    }
    
    static {
        f36578 = new String[] { "undefined", "" };
    }
}
