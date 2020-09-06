package meteorclient.modules;

import meteorclient.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;

public class Blink extends Module
{
    private static final String[] f35833;
    private final List<class_2828> f35834;
    private int f35835;
    @EventHandler
    private final Listener<c36575> f35836;
    @EventHandler
    private final Listener<c32410> f35837;
    
    public Blink() {
        super(Category.Movement, "blink", "Suspends all motion updates while enabled.");
        this.f35834 = new ArrayList<class_2828>();
        this.f35835 = 0;
        this.f35836 = (Listener<c36575>)new Listener(this::m35845, new Predicate[0]);
        this.f35837 = (Listener<c32410>)new Listener(this::m35840, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        synchronized (this.f35834) {
            this.f35834.forEach(this::m35848);
            this.f35834.clear();
            this.f35835 = 0;
        }
    }
    
    @Override
    public String m35302() {
        return String.format("%.1f", this.f35835 / 20.0f);
    }
    
    private /* synthetic */ void m35840(final c32410 c32410) {
        if (!(c32410.f32411 instanceof PlayerMoveC2SPacket)) {
            return;
        }
        c32410.m32674();
        synchronized (this.f35834) {
            final PlayerMoveC2SPacket playerMoveC2SPacket = (PlayerMoveC2SPacket)c32410.f32411;
            final PlayerMoveC2SPacket playerMoveC2SPacket2 = (this.f35834.size() == 0) ? null : ((PlayerMoveC2SPacket)this.f35834.get(this.f35834.size() - 1));
            if (playerMoveC2SPacket2 != null && playerMoveC2SPacket.isOnGround() == playerMoveC2SPacket2.isOnGround() && playerMoveC2SPacket.getYaw(-1.0f) == playerMoveC2SPacket2.getYaw(-1.0f) && playerMoveC2SPacket.getPitch(-1.0f) == playerMoveC2SPacket2.getPitch(-1.0f) && playerMoveC2SPacket.getX(-1.0) == playerMoveC2SPacket2.getX(-1.0) && playerMoveC2SPacket.getY(-1.0) == playerMoveC2SPacket2.getY(-1.0) && playerMoveC2SPacket.getZ(-1.0) == playerMoveC2SPacket2.getZ(-1.0)) {
                return;
            }
            this.f35834.add((class_2828)playerMoveC2SPacket);
        }
    }
    
    private /* synthetic */ void m35845(final c36575 c36575) {
        ++this.f35835;
    }
    
    private /* synthetic */ void m35848(final PlayerMoveC2SPacket playerMoveC2SPacket) {
        this.mc.player.networkHandler.sendPacket((Packet)playerMoveC2SPacket);
    }
    
    static {
        f35833 = new String[] { "blink", "Suspends all motion updates while enabled.", "%.1f" };
    }
}
