package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import minegame159.meteorclient.*;
import meteorclient.util.*;

public class Autorightclick extends Module
{
    private static final String[] f34251;
    private final Settings f34252;
    private final Value<c34250.Mode> f34253;
    private final Value<Integer> f34254;
    private final Value<Boolean> f34255;
    private int f34256;
    @EventHandler
    private final Listener<c36575> f34257;
    
    public Autorightclick() {
        super(Category.Player, "auto-right-click", "Automatically right clicks.");
        this.f34252 = this.f38675.m34572();
        this.f34253 = this.f34252.addValue((Value<c34250.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("How it right clicks.").m36932((Enum)c34250.Mode.Press).m36941());
        this.f34254 = this.f34252.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("Delay between clicks in ticks.").m32387(2).m32396(0).m32405(60).m32408());
        this.f34255 = this.f34252.addValue((Value<Boolean>)new c34427.c34657().m34664("only-when-holding-use").m34667("Only when holding right click.").m34670(false).m34679());
        this.f34257 = (Listener<c36575>)new Listener(this::m34258, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f34256 = 0;
    }
    
    private /* synthetic */ void m34258(final c36575 c36575) {
        if (this.mc.player.getHealth() <= 0.0f) {
            return;
        }
        if (this.f34253.m33466() == c34250.Mode.Hold && !this.mc.options.keyUse.isPressed()) {
            ((c39520)this.mc.options.keyUse).m39521(true);
            return;
        }
        if (this.f34253.m33466() == c34250.Mode.Hold) {
            return;
        }
        ++this.f34256;
        if (this.f34256 > this.f34254.m33466()) {
            if (this.f34255.m33466()) {
                if (this.mc.options.keyAttack.isPressed()) {
                    EnchantUtil.m35624();
                }
            }
            else {
                EnchantUtil.m35624();
            }
            this.f34256 = 0;
        }
    }
    
    static {
        f34251 = new String[] { "auto-right-click", "Automatically right clicks.", "mode", "How it right clicks.", "delay", "Delay between clicks in ticks.", "only-when-holding-use", "Only when holding right click." };
    }
}
