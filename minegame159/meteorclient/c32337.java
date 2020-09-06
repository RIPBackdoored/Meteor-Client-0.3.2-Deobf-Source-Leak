package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import meteorclient.util.*;
import net.minecraft.client.gui.screen.*;
import java.util.*;

public class c32337 extends c36626 implements Listenable
{
    private final c35714 f32338;
    @EventHandler
    private final Listener<c38839> f32339;
    
    public c32337() {
        super(TopBarType.Waypoints);
        this.f32339 = (Listener<c38839>)new Listener(c38839 -> {
            this.clear();
            this.m32340();
        }, new Predicate[0]);
        this.f32338 = this.add(new c35714(this.f37288, true)).m39601().m39632();
        this.m32340();
    }
    
    protected void init() {
        super.init();
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    private void m32340() {
        boolean b = false;
        final Iterator<c33820> iterator = c34924.f34927.iterator();
        while (iterator.hasNext()) {
            this.f32338.m31937(new c32353(iterator.next())).m39587().m39583();
            this.f32338.m36739();
            b = true;
        }
        if (EnchantUtil.m35613()) {
            if (!b) {
                this.f32338.m36739();
            }
            this.f32338.m31937(new c35036()).m39587().m39589().m39632().f35037 = (p0 -> this.f37289.openScreen((Screen)new c33684((c33820)null)));
        }
    }
    
    public void clear() {
        this.f32338.m31945();
    }
    
    public void onClose() {
        super.onClose();
        MeteorClient.eventBus.unsubscribe((Listenable)this);
    }
    
    private /* synthetic */ void m32345(final c38839 c38839) {
        this.clear();
        this.m32340();
    }
    
    private /* synthetic */ void m32348(final c35036 c35036) {
        this.f37289.openScreen((Screen)new c33684((c33820)null));
    }
}
