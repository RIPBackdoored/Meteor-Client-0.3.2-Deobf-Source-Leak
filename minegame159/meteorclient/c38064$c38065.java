package minegame159.meteorclient;

import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.*;
import java.util.function.*;
import meteorclient.setting.*;

public static class c38065
{
    private static final String[] f38066;
    private String f38067;
    private String f38068;
    private Object2IntMap<class_1291> f38069;
    private Consumer<Object2IntMap<class_1291>> f38070;
    private Consumer<Value<Object2IntMap<class_1291>>> f38071;
    
    public c38065() {
        super();
        this.f38067 = "undefined";
        this.f38068 = "";
    }
    
    public c38065 m38072(final String f38067) {
        this.f38067 = f38067;
        return this;
    }
    
    public c38065 m38075(final String f38068) {
        this.f38068 = f38068;
        return this;
    }
    
    public c38065 m38078(final Object2IntMap<class_1291> f38069) {
        this.f38069 = f38069;
        return this;
    }
    
    public c38065 m38081(final Consumer<Object2IntMap<class_1291>> f38070) {
        this.f38070 = f38070;
        return this;
    }
    
    public c38065 m38084(final Consumer<Value<Object2IntMap<class_1291>>> f38071) {
        this.f38071 = f38071;
        return this;
    }
    
    public c38064 m38087() {
        return new c38064(this.f38067, this.f38068, this.f38069, this.f38070, this.f38071);
    }
    
    static {
        f38066 = new String[] { "undefined", "" };
    }
}
