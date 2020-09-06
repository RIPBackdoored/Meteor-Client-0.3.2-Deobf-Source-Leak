package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.nbt.*;

public class c33179 extends Value<c37042>
{
    private static final String[] f40078;
    private c32910 f40079;
    
    public c33179(final String s, final String s2, final c37042 c37042, final Consumer<c37042> consumer, final Consumer<Value<c37042>> consumer2) {
        super(s, s2, c37042, consumer, consumer2);
        this.f33465 = new c36715();
        this.f40079 = this.f33465.m31937(new c32910(this.m33466())).m39632();
        final c37174 c37043;
        this.f33465.m31937(new c38616(c36250.f36261)).m39632().f38618 = (p0 -> {
            c37043 = new c37174(this);
            c37043.f39655 = (p0 -> this.f40079.f32911.m37049(this.m33466()));
            MinecraftClient.getInstance().openScreen((Screen)c37043);
        });
    }
    
    protected c37042 m40080(final String s) {
        try {
            final String[] split = s.split(" ");
            return new c37042(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        }
        catch (IndexOutOfBoundsException | NumberFormatException ex) {
            return null;
        }
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new c37042((c37042)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    @Override
    public void m33485() {
        this.f40079.f32911.m37049(this.m33466());
    }
    
    protected boolean m40088(final c37042 c37042) {
        c37042.m37052();
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)0-255 0-255 0-255 0-255";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        m33490.put("value", (Tag)this.m33466().m34682());
        return m33490;
    }
    
    public c37042 m40094(final CompoundTag compoundTag) {
        this.m33466().m37060(compoundTag.getCompound("value"));
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m40088((c37042)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m40080(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m40094(compoundTag);
    }
    
    private /* synthetic */ void m40100(final c38616 c38616) {
        final c37174 c38617 = new c37174(this);
        c38617.f39655 = (p0 -> this.f40079.f32911.m37049(this.m33466()));
        MinecraftClient.getInstance().openScreen((Screen)c38617);
    }
    
    private /* synthetic */ void m40104(final c37174 c37174) {
        this.f40079.f32911.m37049(this.m33466());
    }
    
    static {
        f40078 = new String[] { " ", "(highlight)0-255 0-255 0-255 0-255", "value", "value" };
    }
    
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
}
