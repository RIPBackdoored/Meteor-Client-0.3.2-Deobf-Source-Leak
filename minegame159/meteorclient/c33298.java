package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import meteorclient.util.*;
import net.minecraft.client.gui.screen.*;
import java.util.*;

public class c33298 extends c36626 implements Listenable
{
    private static final String[] f33299;
    private c35714 f33300;
    @EventHandler
    private Listener<c38391> f33301;
    
    public c33298() {
        super(TopBarType.Macros);
        this.f33301 = (Listener<c38391>)new Listener(c38391 -> {
            this.clear();
            this.m33302();
        }, new Predicate[0]);
        this.f33300 = this.add(new c35714(this.f37288, true)).m39601().m39632();
        this.m33302();
    }
    
    public void clear() {
        this.f33300.m31945();
    }
    
    protected void init() {
        super.init();
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    private void m33302() {
        if (c33410.f33412.m33417().size() > 0) {
            final c36715 c36715 = this.f33300.m31937(new c36715()).m39632();
            this.f33300.m36739();
            for (final c37831 c36716 : c33410.f33412.m33417()) {
                c36715.m31937(new c39081(c36716.f37833 + " (" + EnchantUtil.m35582(c36716.f37835) + ")"));
                c36715.m31937(new c38616("Edit")).m39632().f38618 = (p1 -> this.f37289.openScreen((Screen)new c38854(c36716)));
                c36715.m31937(new c36419()).m39632().f36420 = (p1 -> c33410.f33412.m33419(c36716));
                c36715.m36739();
            }
            this.f33300.m31937(new c38757());
            this.f33300.m36739();
        }
        this.f33300.m31937(new c35036()).m39587().m39589().m39632().f35037 = (p0 -> this.f37289.openScreen((Screen)new c38854(null)));
    }
    
    public void onClose() {
        MeteorClient.eventBus.unsubscribe((Listenable)this);
        super.onClose();
    }
    
    private /* synthetic */ void m33309(final c38391 c38391) {
        this.clear();
        this.m33302();
    }
    
    private /* synthetic */ void m33312(final c35036 c35036) {
        this.f37289.openScreen((Screen)new c38854(null));
    }
    
    private static /* synthetic */ void m33315(final c37831 c37831, final c36419 c37832) {
        c33410.f33412.m33419(c37831);
    }
    
    private /* synthetic */ void m33318(final c37831 c37831, final c38616 c37832) {
        this.f37289.openScreen((Screen)new c38854(c37831));
    }
    
    static {
        f33299 = new String[] { " (", ")", "Edit" };
    }
}
