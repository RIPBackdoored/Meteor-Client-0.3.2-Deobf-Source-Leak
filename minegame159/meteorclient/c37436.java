package minegame159.meteorclient;

import java.util.function.*;
import meteorclient.setting.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;

public class c37436 extends c36601<MyPotion>
{
    private static final String[] f37817;
    
    public c37436(final String s, final String s2, final MyPotion myPotion, final Consumer<MyPotion> consumer, final Consumer<Value<MyPotion>> consumer2) {
        super(s, s2, myPotion, consumer, consumer2);
        this.f33465 = new c34625(this.m33466().potion);
        this.f33465.m31937(new c38616("Select")).m39632().f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c37016(this)));
    }
    
    @Override
    public void m33485() {
        ((c34625)this.f33465).m34635(this.m33466().potion);
        this.f33465.m31962();
    }
    
    private /* synthetic */ void m37819(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c37016(this));
    }
    
    static {
        f37817 = new String[] { "Select" };
    }
    
    public static class c37437 extends c36919<MyPotion>
    {
        public c37437() {
            super();
        }
        
        @Override
        public c36601<MyPotion> m36941() {
            return new c37436(this.f36921, this.f36922, (MyPotion)this.f36923, (Consumer<MyPotion>)this.f36924, (Consumer<Value<MyPotion>>)this.f36925);
        }
    }
}
