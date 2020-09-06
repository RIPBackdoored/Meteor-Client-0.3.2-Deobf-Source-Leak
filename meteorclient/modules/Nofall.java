package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.packet.c2s.play.*;
import minegame159.meteorclient.*;

public class Nofall extends Module
{
    private static final String[] f34840;
    @EventHandler
    private final Listener<c32410> f34841;
    
    public Nofall() {
        super(Category.Movement, "no-fall", "Protects you from fall damage.");
        this.f34841 = (Listener<c32410>)new Listener(c34839::m34842, new Predicate[0]);
    }
    
    private static /* synthetic */ void m34842(final c32410 c32410) {
        if (c32410.f32411 instanceof PlayerMoveC2SPacket) {
            ((c34907)c32410.f32411).m34908(true);
        }
    }
    
    static {
        f34840 = new String[] { "no-fall", "Protects you from fall damage." };
    }
}
