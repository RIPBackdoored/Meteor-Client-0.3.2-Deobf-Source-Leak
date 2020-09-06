package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.item.*;
import me.zero.alpine.listener.*;
import meteorclient.modules.*;
import java.util.function.*;

private class c33737 extends c31500.c37403
{
    private static final String[] f33738;
    private final Value<String> f33739;
    private Item f33740;
    private int f33741;
    private double f33742;
    @EventHandler
    private final Listener<c32250> f33743;
    final /* synthetic */ Announcer f33744;
    
    c33737(final Announcer f33744) {
        super(this.f33744 = f33744, "Pick Items", "pick-items-enabled", "Send msg how much items you pick up.");
        this.f33739 = this.f37404.addValue((Value<Object>)new c36225.c36674().m36681("pick-items-msg").m36684("Pick items message.").m36687("I just picked up {count} {item}!").m36696());
        this.f33743 = new Listener(this::m33747, new Predicate[0]);
    }
    
    void m37406() {
        this.f33740 = null;
        this.f33741 = 0;
        this.f33742 = 0.0;
    }
    
    void m37407() {
        if (this.f33742 >= 1.0) {
            this.m33745();
        }
        else {
            this.f33742 += 0.05;
        }
    }
    
    void m33745() {
        if (this.f33741 > 0) {
            Announcer.m33175(this.f33744).player.sendChatMessage(this.f33739.m33466().replace("{count}", Integer.toString(this.f33741)).replace("{item}", this.f33740.getName().getString()));
            this.f33741 = 0;
        }
    }
    
    private /* synthetic */ void m33747(final c32250 c32250) {
        if (this.f33740 != null && this.f33740 != c32250.f32251.getItem()) {
            this.m33745();
        }
        this.f33740 = c32250.f32251.getItem();
        this.f33741 += c32250.f32251.getCount();
        this.f33742 = 0.0;
    }
    
    static {
        c33737.f33738 = new String[] { "Pick Items", "pick-items-enabled", "Send msg how much items you pick up.", "pick-items-msg", "Pick items message.", "I just picked up {count} {item}!", "{count}", "{item}" };
    }
}
