package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Fullbright extends Module
{
    private static final String[] f32185;
    private double f32186;
    @EventHandler
    private Listener<c36575> f32187;
    
    public Fullbright() {
        super(Category.Render, "full-bright", "No more darkness.");
        this.f32187 = (Listener<c36575>)new Listener(this::m32188, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f32186 = this.mc.options.gamma;
        this.mc.options.gamma = 16.0;
    }
    
    @Override
    public void m35294() {
        this.mc.options.gamma = this.f32186;
    }
    
    private /* synthetic */ void m32188(final c36575 c36575) {
        this.mc.options.gamma = 16.0;
    }
    
    static {
        f32185 = new String[] { "full-bright", "No more darkness." };
    }
}
