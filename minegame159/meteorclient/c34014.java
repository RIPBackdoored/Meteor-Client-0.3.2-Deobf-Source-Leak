package minegame159.meteorclient;

import net.minecraft.client.*;

public abstract class c34014
{
    protected static MinecraftClient f34015;
    public final String f34016;
    public final String f34017;
    
    public c34014(final String f34016, final String f34017) {
        super();
        this.f34016 = f34016;
        this.f34017 = f34017;
        c34014.f34015 = MinecraftClient.getInstance();
    }
    
    public abstract void m34018(final String[] p0);
}
