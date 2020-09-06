package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.block.*;
import me.zero.alpine.listener.*;
import meteorclient.modules.*;
import java.util.function.*;
import net.minecraft.world.*;

private class c32355 extends c31500.c37403
{
    private static final String[] f32356;
    private final Value<String> f32357;
    private Block f32358;
    private int f32359;
    private double f32360;
    @EventHandler
    private final Listener<c37812> f32361;
    final /* synthetic */ Announcer f32362;
    
    c32355(final Announcer f32362) {
        super(this.f32362 = f32362, "Mining", "mining-enabled", "Send msg how much blocks you mined.");
        this.f32357 = this.f37404.addValue((Value<Object>)new c36225.c36674().m36681("mining-msg").m36684("Mining message.").m36687("I just mined {count} {block}!").m36696());
        this.f32361 = new Listener(this::m32365, new Predicate[0]);
    }
    
    void m37406() {
        this.f32358 = null;
        this.f32359 = 0;
        this.f32360 = 0.0;
    }
    
    void m37407() {
        if (this.f32360 >= 2.0) {
            this.m32363();
        }
        else {
            this.f32360 += 0.05;
        }
    }
    
    void m32363() {
        if (this.f32359 > 0) {
            Announcer.m33167(this.f32362).player.sendChatMessage(this.f32357.m33466().replace("{count}", Integer.toString(this.f32359)).replace("{block}", this.f32358.getName().getString()));
            this.f32359 = 0;
        }
    }
    
    private /* synthetic */ void m32365(final c37812 c37812) {
        final Block block = c37812.m37814((World)Announcer.m33169(this.f32362).world).getBlock();
        if (this.f32358 != null && this.f32358 != block) {
            this.m32363();
        }
        this.f32358 = block;
        ++this.f32359;
        this.f32360 = 0.0;
    }
    
    static {
        c32355.f32356 = new String[] { "Mining", "mining-enabled", "Send msg how much blocks you mined.", "mining-msg", "Mining message.", "I just mined {count} {block}!", "{count}", "{block}" };
    }
}
