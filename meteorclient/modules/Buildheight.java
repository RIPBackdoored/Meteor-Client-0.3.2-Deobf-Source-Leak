package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.util.math.*;
import minegame159.meteorclient.*;

public class Buildheight extends Module
{
    private static final String[] f38841;
    @EventHandler
    private final Listener<c32410> f38842;
    
    public Buildheight() {
        super(Category.Player, "build-height", "Lets you interact with blocks at build limit.");
        this.f38842 = (Listener<c32410>)new Listener(c38840::m38843, new Predicate[0]);
    }
    
    private static /* synthetic */ void m38843(final c32410 c32410) {
        if (!(c32410.f32411 instanceof PlayerInteractBlockC2SPacket)) {
            return;
        }
        final PlayerInteractBlockC2SPacket playerInteractBlockC2SPacket = (PlayerInteractBlockC2SPacket)c32410.f32411;
        if (playerInteractBlockC2SPacket.getBlockHitResult().getPos().y >= 255.0 && playerInteractBlockC2SPacket.getBlockHitResult().getSide() == Direction.field_11036) {
            ((c33406)playerInteractBlockC2SPacket.getBlockHitResult()).m33407(Direction.field_11033);
        }
    }
    
    static {
        f38841 = new String[] { "build-height", "Lets you interact with blocks at build limit." };
    }
}
