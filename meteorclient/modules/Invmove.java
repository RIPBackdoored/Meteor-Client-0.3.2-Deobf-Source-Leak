package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import meteorclient.util.*;
import net.minecraft.client.input.*;
import net.minecraft.client.network.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.screen.ingame.*;

public class Invmove extends Module
{
    private static final String[] f33506;
    private final Settings f33507;
    private final Value<Boolean> f33508;
    private final Value<Boolean> f33509;
    private final Value<Boolean> f33510;
    private final Value<Boolean> f33511;
    private final Value<Double> f33512;
    @EventHandler
    private final Listener<c36575> f33513;
    
    public Invmove() {
        super(Category.Movement, "inv-move", "Allows you to move while in guis.");
        this.f33507 = this.f38675.m34572();
        this.f33508 = this.f33507.addValue((Value<Boolean>)new c34427.c34657().m34664("sneak").m34667("Allows you to sneak.").m34670(true).m34679());
        this.f33509 = this.f33507.addValue((Value<Boolean>)new c34427.c34657().m34664("jump").m34667("Allows you to jump.").m34670(true).m34679());
        this.f33510 = this.f33507.addValue((Value<Boolean>)new c34427.c34657().m34664("sprint").m34667("Allows you to sprint.").m34670(true).m34679());
        this.f33511 = this.f33507.addValue((Value<Boolean>)new c34427.c34657().m34664("arrows-rotate").m34667("Allows you to use arrow keys to rotate.").m34670(true).m34679());
        this.f33512 = this.f33507.addValue((Value<Double>)new c37033.c38947().m38959("rotate-speed").m38962("Rotation speed.").m38965(4.0).m38974(0.0).m38988());
        this.f33513 = (Listener<c36575>)new Listener(this::m33520, new Predicate[0]);
    }
    
    public void m33514() {
        if (!this.m35315() || this.m33518()) {
            return;
        }
        this.mc.player.input.movementForward = 0.0f;
        this.mc.player.input.movementSideways = 0.0f;
        if (c38412.m38417(this.mc.options.keyForward)) {
            this.mc.player.input.pressingForward = true;
            final Input input = this.mc.player.input;
            ++input.movementForward;
        }
        else {
            this.mc.player.input.pressingForward = false;
        }
        if (c38412.m38417(this.mc.options.keyBack)) {
            this.mc.player.input.pressingBack = true;
            final Input input2 = this.mc.player.input;
            --input2.movementForward;
        }
        else {
            this.mc.player.input.pressingBack = false;
        }
        if (c38412.m38417(this.mc.options.keyRight)) {
            this.mc.player.input.pressingRight = true;
            final Input input3 = this.mc.player.input;
            --input3.movementSideways;
        }
        else {
            this.mc.player.input.pressingRight = false;
        }
        if (c38412.m38417(this.mc.options.keyLeft)) {
            this.mc.player.input.pressingLeft = true;
            final Input input4 = this.mc.player.input;
            ++input4.movementSideways;
        }
        else {
            this.mc.player.input.pressingLeft = false;
        }
        this.m33516();
        if (this.f33511.m33466()) {
            if (c38412.m38420(262)) {
                final ClientPlayerEntity player = this.mc.player;
                player.yaw += (float)(Object)this.f33512.m33466();
            }
            if (c38412.m38420(263)) {
                final ClientPlayerEntity player2 = this.mc.player;
                player2.yaw -= (float)(Object)this.f33512.m33466();
            }
            if (c38412.m38420(265)) {
                final ClientPlayerEntity player3 = this.mc.player;
                player3.pitch -= (float)(Object)this.f33512.m33466();
            }
            if (c38412.m38420(264)) {
                final ClientPlayerEntity player4 = this.mc.player;
                player4.pitch += (float)(Object)this.f33512.m33466();
            }
            this.mc.player.pitch = EnchantUtil.m35640(this.mc.player.pitch, -90.0f, 90.0f);
        }
    }
    
    private void m33516() {
        this.mc.player.input.jumping = (this.f33509.m33466() && c38412.m38417(this.mc.options.keyJump));
        this.mc.player.input.sneaking = (this.f33508.m33466() && c38412.m38417(this.mc.options.keySneak));
        this.mc.player.setSprinting(this.f33510.m33466() && c38412.m38417(this.mc.options.keySprint));
    }
    
    private boolean m33518() {
        return this.mc.currentScreen == null || (this.mc.currentScreen instanceof CreativeInventoryScreen && ((c32668)this.mc.currentScreen).m32669() == ItemGroup.SEARCH.getIndex()) || this.mc.currentScreen instanceof c32480 || this.mc.currentScreen instanceof ChatScreen || this.mc.currentScreen instanceof SignEditScreen || this.mc.currentScreen instanceof AnvilScreen;
    }
    
    private /* synthetic */ void m33520(final c36575 c36575) {
        if (!this.m33518()) {
            this.m33516();
        }
    }
    
    static {
        f33506 = new String[] { "inv-move", "Allows you to move while in guis.", "sneak", "Allows you to sneak.", "jump", "Allows you to jump.", "sprint", "Allows you to sprint.", "arrows-rotate", "Allows you to use arrow keys to rotate.", "rotate-speed", "Rotation speed." };
    }
}
