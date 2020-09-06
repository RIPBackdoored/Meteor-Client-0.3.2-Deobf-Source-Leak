package meteorclient.modules;

import meteorclient.*;
import net.minecraft.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import it.unimi.dsi.fastutil.objects.*;
import minegame159.meteorclient.*;
import java.util.*;

public class Packetcanceller extends Module
{
    private static final String[] f35818;
    public static Object2BooleanMap<Class<? extends class_2596<?>>> f35819;
    public static Object2BooleanMap<Class<? extends class_2596<?>>> f35820;
    private final Settings f35821;
    private final Value<Object2BooleanMap<Class<? extends class_2596<?>>>> f35822;
    private final Value<Object2BooleanMap<Class<? extends class_2596<?>>>> f35823;
    @EventHandler
    private final Listener<c39306> f35824;
    @EventHandler
    private final Listener<c32410> f35825;
    
    public Packetcanceller() {
        super(Category.Misc, "packet-canceller", "Allows you to cancel packets.");
        this.f35821 = this.f38675.m34572();
        this.f35822 = this.f35821.addValue((Value<Object2BooleanMap<Class<? extends class_2596<?>>>>)new c36576.c36577().m36584("S2C-packets").m36587("Server-to-client packets to cancel.").m36590(Packetcanceller.f35819).m36599());
        this.f35823 = this.f35821.addValue((Value<Object2BooleanMap<Class<? extends class_2596<?>>>>)new c36576.c36577().m36584("C2S-packets").m36587("Client-to-server packets to cancel.").m36590(Packetcanceller.f35820).m36599());
        this.f35824 = (Listener<c39306>)new Listener(this::m35829, 201, new Predicate[0]);
        this.f35825 = (Listener<c32410>)new Listener(this::m35826, 201, new Predicate[0]);
    }
    
    private /* synthetic */ void m35826(final c32410 c32410) {
        if (this.f35823.m33466().getBoolean((Object)c32410.f32411.getClass())) {
            c32410.m32674();
        }
    }
    
    private /* synthetic */ void m35829(final c39306 c39306) {
        if (this.f35822.m33466().getBoolean((Object)c39306.f39307.getClass())) {
            c39306.m32674();
        }
    }
    
    static {
        f35818 = new String[] { "packet-canceller", "Allows you to cancel packets.", "S2C-packets", "Server-to-client packets to cancel.", "C2S-packets", "Client-to-server packets to cancel." };
        Packetcanceller.f35819 = (Object2BooleanMap<Class<? extends class_2596<?>>>)new Object2BooleanArrayMap();
        Packetcanceller.f35820 = (Object2BooleanMap<Class<? extends class_2596<?>>>)new Object2BooleanArrayMap();
        final Iterator<Class<? extends class_2596<?>>> iterator = c34333.m34345().iterator();
        while (iterator.hasNext()) {
            Packetcanceller.f35819.put((Object)iterator.next(), false);
        }
        final Iterator<Class<? extends class_2596<?>>> iterator2 = c34333.m34346().iterator();
        while (iterator2.hasNext()) {
            Packetcanceller.f35820.put((Object)iterator2.next(), false);
        }
    }
}
