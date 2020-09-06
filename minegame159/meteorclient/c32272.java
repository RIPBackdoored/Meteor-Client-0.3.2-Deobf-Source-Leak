package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.*;
import java.util.*;

public class c32272 extends c36626 implements Listenable
{
    private static final String[] f32273;
    private c35714 f32274;
    @EventHandler
    private Listener<c31526> f32275;
    
    public c32272() {
        super(TopBarType.Friends);
        this.f32275 = (Listener<c31526>)new Listener(c31526 -> {
            this.clear();
            this.m32276();
        }, new Predicate[0]);
        this.f32274 = this.add(new c35714(this.f37288, true)).m39601().m39632();
        this.m32276();
    }
    
    public void clear() {
        this.f32274.m31945();
    }
    
    protected void init() {
        super.init();
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    private void m32276() {
        final Iterator<c31543> iterator = c39017.f39019.m39025().iterator();
        while (iterator.hasNext()) {
            this.f32274.m31937(new c39081(iterator.next().f31545));
            final c31543 c31543;
            this.f32274.m31937(new c38616(c36250.f36261)).m39632().f38618 = (p1 -> this.f37289.openScreen((Screen)new c38584(c31543)));
            this.f32274.m31937(new c36419()).m39632().f36420 = (p1 -> c39017.f39019.m39053(c31543));
            this.f32274.m36739();
        }
        final c36715 c31544 = this.f32274.m31937(new c36715()).m39587().m39583().m39632();
        c31544.m31937(new c31399("", 200.0)).m39587().m39583().m39632().m31416(true);
        final c31399 c31545;
        c31544.m31937(new c35036()).m39632().f35037 = (p1 -> c39017.f39019.m39022(new c31543(c31545.f31403.trim())));
    }
    
    public void onClose() {
        MeteorClient.eventBus.unsubscribe((Listenable)this);
        c39017.f39019.m37303();
        super.onClose();
    }
    
    private /* synthetic */ void m32283(final c31526 c31526) {
        this.clear();
        this.m32276();
    }
    
    private static /* synthetic */ void m32286(final c31399 c31399, final c35036 c31400) {
        c39017.f39019.m39022(new c31543(c31399.f31403.trim()));
    }
    
    private static /* synthetic */ void m32289(final c31543 c31543, final c36419 c31544) {
        c39017.f39019.m39053(c31543);
    }
    
    private /* synthetic */ void m32292(final c31543 c31543, final c38616 c31544) {
        this.f37289.openScreen((Screen)new c38584(c31543));
    }
    
    static {
        f32273 = new String[] { "" };
    }
}
