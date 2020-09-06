package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.*;
import java.util.*;

public class c33070 extends c39130 implements Listenable
{
    private static final String[] f33071;
    private c39081 f33072;
    @EventHandler
    private Listener<c39291> f33073;
    
    public c33070() {
        super("Accounts", true);
        this.f33073 = (Listener<c39291>)new Listener(c39291 -> {
            this.clear();
            this.m33074();
        }, new Predicate[0]);
        this.m33074();
    }
    
    protected void init() {
        super.init();
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    private void m33074() {
        if (c34371.f34373.m34382().size() > 0) {
            final c36715 c36715 = this.add(new c36715()).m39632();
            this.m39132();
            for (final c34353 c36716 : c34371.f34373.m34382()) {
                final c39081 c36717 = c36715.m31937(new c39081(c36716.m34362())).m39632();
                final c39081 f33072 = c36715.m31937(new c39081("- logged in")).m39632();
                f33072.f39082 = c31870.f37895.f37899;
                if (this.f37289.getSession().getUsername().equalsIgnoreCase(c36716.m34362())) {
                    this.f33072 = f33072;
                }
                else {
                    f33072.f31924 = false;
                }
                final c34353 c36718;
                final c39081 f33073;
                final c39081 c36719;
                c36715.m31937(new c38616("Log In")).m39632().f38618 = (p3 -> {
                    if (c36718.m34358()) {
                        if (this.f33072 != null) {
                            this.f33072.f31924 = (0 != 0);
                        }
                        f33073.f31924 = true;
                        this.f33072 = f33073;
                        c36719.m39087(c36718.m34362());
                    }
                    return;
                });
                c36715.m31937(new c36419()).m39632().f36420 = (p1 -> c34371.f34373.m34379(c36716));
                c36715.m36739();
            }
            this.add(new c38757()).m39587().m39583();
            this.m39132();
        }
        this.add(new c35036()).m39587().m39589().m39632().f35037 = (p0 -> this.f37289.openScreen((Screen)new c35911()));
    }
    
    public void onClose() {
        MeteorClient.eventBus.unsubscribe((Listenable)this);
        super.onClose();
    }
    
    private /* synthetic */ void m33083(final c39291 c39291) {
        this.clear();
        this.m33074();
    }
    
    private /* synthetic */ void m33086(final c35036 c35036) {
        this.f37289.openScreen((Screen)new c35911());
    }
    
    private static /* synthetic */ void m33089(final c34353 c34353, final c36419 c34354) {
        c34371.f34373.m34379(c34353);
    }
    
    private /* synthetic */ void m33092(final c34353 c34353, final c39081 f33072, final c39081 c34354, final c38616 c34355) {
        if (c34353.m34358()) {
            if (this.f33072 != null) {
                this.f33072.f31924 = false;
            }
            f33072.f31924 = true;
            this.f33072 = f33072;
            c34354.m39087(c34353.m34362());
        }
    }
    
    static {
        f33071 = new String[] { "Accounts", "- logged in", "Log In" };
    }
}
