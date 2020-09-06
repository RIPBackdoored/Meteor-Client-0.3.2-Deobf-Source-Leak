package minegame159.meteorclient;

import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;

public class c35524 extends c34014
{
    private static final String[] f35525;
    
    public c35524() {
        super("dismount", "Dismounts you from entity you are riding.");
    }
    
    @Override
    public void m34018(final String[] array) {
        c35524.f34015.getNetworkHandler().sendPacket((Packet)new PlayerInputC2SPacket(0.0f, 0.0f, false, true));
    }
    
    static {
        f35525 = new String[] { "dismount", "Dismounts you from entity you are riding." };
    }
}
