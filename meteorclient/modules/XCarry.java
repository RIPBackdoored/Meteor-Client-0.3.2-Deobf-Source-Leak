package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;
import minegame159.meteorclient.*;

public class XCarry extends Module
{
    private static final String[] f33270;
    private boolean f33271;
    @EventHandler
    private final Listener<c32410> f33272;
    
    public XCarry() {
        super(Category.Player, "XCarry", "Allows you to store items in your crafting grid.");
        this.f33272 = (Listener<c32410>)new Listener(this::m33273, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f33271 = false;
    }
    
    @Override
    public void m35294() {
        if (this.f33271) {
            this.mc.player.networkHandler.sendPacket((Packet)new GuiCloseC2SPacket(this.mc.player.playerContainer.syncId));
        }
    }
    
    private /* synthetic */ void m33273(final c32410 c32410) {
        if (!(c32410.f32411 instanceof GuiCloseC2SPacket)) {
            return;
        }
        if (((c32351)c32410.f32411).m32352() == this.mc.player.playerContainer.syncId) {
            this.f33271 = true;
            c32410.m32674();
        }
    }
    
    static {
        f33270 = new String[] { "XCarry", "Allows you to store items in your crafting grid." };
    }
}
