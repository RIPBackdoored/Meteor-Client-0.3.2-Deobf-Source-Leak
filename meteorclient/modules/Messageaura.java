package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;

public class Messageaura extends Module
{
    private static final String[] f32706;
    private final Settings f32707;
    private final Value<String> f32708;
    private final Value<Boolean> f32709;
    @EventHandler
    private final Listener<c34242> f32710;
    
    public Messageaura() {
        super(Category.Misc, "message-aura", "Sends a message to every player when they enter render distance.");
        this.f32707 = this.f38675.m34572();
        this.f32708 = this.f32707.addValue((Value<String>)new c36225.c36674().m36681("message").m36684("The message sent to players.").m36687("Meteor on Crack!").m36696());
        this.f32709 = this.f32707.addValue((Value<Boolean>)new c34427.c34657().m34664("ignore-friends").m34667("Doesn't send messages to friends.").m34670(false).m34679());
        this.f32710 = (Listener<c34242>)new Listener(this::m32711, new Predicate[0]);
    }
    
    private /* synthetic */ void m32711(final c34242 c34242) {
        if (!(c34242.f34243 instanceof PlayerEntity) || c34242.f34243.getUuid().equals(this.mc.player.getUuid())) {
            return;
        }
        if (!this.f32709.m33466() || (this.f32709.m33466() && !c39017.f39019.m39027(new c31543((PlayerEntity)c34242.f34243)))) {
            this.mc.player.sendChatMessage("/msg " + ((PlayerEntity)c34242.f34243).getGameProfile().getName() + " " + this.f32708.m33466());
        }
    }
    
    static {
        f32706 = new String[] { "message-aura", "Sends a message to every player when they enter render distance.", "message", "The message sent to players.", "Meteor on Crack!", "ignore-friends", "Doesn't send messages to friends.", "/msg ", " " };
    }
}
