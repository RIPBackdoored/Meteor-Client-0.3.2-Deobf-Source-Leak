package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.ingame.*;
import minegame159.meteorclient.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.text.*;
import net.minecraft.network.*;

public class Autosign extends Module
{
    private static final String[] f39069;
    private String[] f39070;
    @EventHandler
    private Listener<c32410> f39071;
    @EventHandler
    private Listener<c31559> f39072;
    
    public Autosign() {
        super(Category.Misc, "auto-sign", "Automatically writes signs. When enabled first sign's text will be used.");
        this.f39071 = (Listener<c32410>)new Listener(this::m39078, new Predicate[0]);
        this.f39072 = (Listener<c31559>)new Listener(this::m39074, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.f39070 = null;
    }
    
    private /* synthetic */ void m39074(final c31559 c31559) {
        if (!(c31559.f31560 instanceof SignEditScreen) || this.f39070 == null) {
            return;
        }
        this.mc.player.networkHandler.sendPacket((Packet)new UpdateSignC2SPacket(((c31564)c31559.f31560).m31565().getPos(), (Text)new LiteralText(this.f39070[0]), (Text)new LiteralText(this.f39070[1]), (Text)new LiteralText(this.f39070[2]), (Text)new LiteralText(this.f39070[3])));
        c31559.m32674();
    }
    
    private /* synthetic */ void m39078(final c32410 c32410) {
        if (!(c32410.f32411 instanceof UpdateSignC2SPacket)) {
            return;
        }
        this.f39070 = ((UpdateSignC2SPacket)c32410.f32411).getText();
    }
    
    static {
        f39069 = new String[] { "auto-sign", "Automatically writes signs. When enabled first sign's text will be used." };
    }
}
