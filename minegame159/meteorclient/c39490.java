package minegame159.meteorclient;

import java.util.function.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.*;

public class c39490
{
    public static Predicate<c32410> f39491;
    public static Predicate<c32410> f39492;
    
    public c39490() {
        super();
    }
    
    private static /* synthetic */ boolean m39493(final c32410 c32410) {
        return c32410.f32411 instanceof HandSwingC2SPacket;
    }
    
    private static /* synthetic */ boolean m39495(final c32410 c32410) {
        return c32410.f32411 instanceof PlayerInteractEntityC2SPacket && ((PlayerInteractEntityC2SPacket)c32410.f32411).getType() == class_2824.class_2825.field_12875;
    }
    
    static {
        c39490.f39491 = (c32410 -> c32410.f32411 instanceof PlayerInteractEntityC2SPacket && ((PlayerInteractEntityC2SPacket)c32410.f32411).getType() == class_2824.class_2825.field_12875);
        c39490.f39492 = (c32411 -> c32411.f32411 instanceof HandSwingC2SPacket);
    }
}
