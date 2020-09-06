package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Spam extends Module
{
    private static final String[] f34204;
    private final Settings f34205;
    private final Value<String> f34206;
    private final Value<Integer> f34207;
    private int f34208;
    @EventHandler
    private Listener<c36575> f34209;
    
    public Spam() {
        super(Category.Misc, "spam", "Spams message in chat.");
        this.f34205 = this.f38675.m34572();
        this.f34206 = this.f34205.addValue((Value<String>)new c36225.c36674().m36681("message").m36684("Message to spam.").m36687("Meteor on Crack!").m36696());
        this.f34207 = this.f34205.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("How much ticks to wait between messages. 20 ticks = 1 second.").m32387(60).m32396(0).m32405(60).m32408());
        this.f34209 = (Listener<c36575>)new Listener(this::m34210, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f34208 = 0;
    }
    
    private /* synthetic */ void m34210(final c36575 c36575) {
        ++this.f34208;
        if (this.f34208 > this.f34207.m33466()) {
            this.mc.player.sendChatMessage((String)this.f34206.m33466());
            this.f34208 = 0;
        }
    }
    
    static {
        f34204 = new String[] { "spam", "Spams message in chat.", "message", "Message to spam.", "Meteor on Crack!", "delay", "How much ticks to wait between messages. 20 ticks = 1 second." };
    }
}
