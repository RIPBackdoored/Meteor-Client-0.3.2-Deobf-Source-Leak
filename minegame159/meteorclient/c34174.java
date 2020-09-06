package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import meteorclient.*;
import org.lwjgl.glfw.*;

public class c34174 extends c39130 implements Listenable
{
    private static final String[] f34175;
    private c38667 f34176;
    private c39081 f34177;
    private boolean f34178;
    @EventHandler
    private Listener<c34369> f34179;
    
    public c34174(final c38667 f34176) {
        super(f34176.f38672, true);
        this.f34178 = true;
        this.f34179 = (Listener<c34369>)new Listener(c34369 -> {
            if (c34369.f34370 == this.f34176) {
                this.f34178 = true;
                this.f34177.m39087(this.m34186());
            }
        }, new Predicate[0]);
        this.f34176 = f34176;
        this.m34180();
    }
    
    private void m34180() {
        this.add(new c39081(this.f34176.f38673));
        this.m39132();
        if (this.f34176.f38675.m34570() > 0) {
            this.add(this.f34176.f38675.m34591(false)).m39587().m39583().m39632();
        }
        else {
            this.add(new c38757()).m39587().m39583();
            this.m39132();
        }
        final c31923 m38680 = this.f34176.m38680();
        if (m38680 != null) {
            if (this.f34176.f38675.m34570() > 0) {
                this.add(new c38757()).m39587().m39583();
                this.m39132();
            }
            this.add(m38680);
            this.m39132();
        }
        if (this.f34176 instanceof Module) {
            if (m38680 != null || this.f34176.f38675.m34570() > 0) {
                this.add(new c38757()).m39587().m39583();
                this.m39132();
            }
            final c36715 c38266 = this.add(new c36715()).m39587().m39583().m39632();
            this.f34177 = c38266.m31937(new c39081(this.m34186())).m39632();
            c38266.m31937(new c38616("Set bind")).m39632().f38618 = (p0 -> {
                c34030.f34033.m34059(this.f34176);
                this.f34178 = (0 != 0);
                this.f34177.m39087("Bind: press any key");
                return;
            });
            c38266.m31937(new c38616("Reset bind")).m39632().f38618 = (p0 -> {
                if (this.f34178) {
                    this.f34176.m38702(-1);
                    this.f34177.m39087(this.m34186());
                }
                return;
            });
            this.m39132();
            this.add(new c38757()).m39587().m39583();
            this.m39132();
            final c36715 c38267 = this.add(new c36715()).m39632();
            c38267.m31937(new c39081("Visible: ")).m39632().f31934 = "Visible in HUD.";
            final c38264 c38268 = c38267.m31937(new c38264(((Module)this.f34176).m35313())).m39632();
            c38268.f31934 = "Visible in HUD.";
            c38268.f38265 = (c38264 -> {
                if (((Module)this.f34176).m35313() != c38264.f38266) {
                    ((Module)this.f34176).m35310(c38264.f38266);
                }
                return;
            });
            c38267.m36739();
            c38267.m31937(new c39081("Active:"));
            c38267.m31937(new c38264(((Module)this.f34176).m35315())).m39632().f38265 = (c38265 -> {
                if (((Module)this.f34176).m35315() != c38265.f38266) {
                    ((Module)this.f34176).m35296(this.f37289.world != null);
                }
            });
        }
    }
    
    protected void init() {
        super.init();
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    private String m34186() {
        return "Bind: " + ((this.f34176.m38705() == -1) ? "none" : GLFW.glfwGetKeyName(this.f34176.m38705(), 0));
    }
    
    public void onClose() {
        MeteorClient.eventBus.unsubscribe((Listenable)this);
        super.onClose();
    }
    
    private /* synthetic */ void m34188(final c34369 c34369) {
        if (c34369.f34370 == this.f34176) {
            this.f34178 = true;
            this.f34177.m39087(this.m34186());
        }
    }
    
    private /* synthetic */ void m34191(final c38264 c38264) {
        if (((Module)this.f34176).m35315() != c38264.f38266) {
            ((Module)this.f34176).m35296(this.f37289.world != null);
        }
    }
    
    private /* synthetic */ void m34194(final c38264 c38264) {
        if (((Module)this.f34176).m35313() != c38264.f38266) {
            ((Module)this.f34176).m35310(c38264.f38266);
        }
    }
    
    private /* synthetic */ void m34197(final c38616 c38616) {
        if (this.f34178) {
            this.f34176.m38702(-1);
            this.f34177.m39087(this.m34186());
        }
    }
    
    private /* synthetic */ void m34200(final c38616 c38616) {
        c34030.f34033.m34059(this.f34176);
        this.f34178 = false;
        this.f34177.m39087("Bind: press any key");
    }
    
    static {
        f34175 = new String[] { "Set bind", "Reset bind", "Visible: ", "Visible in HUD.", "Visible in HUD.", "Active:", "Bind: ", "none", "Bind: press any key" };
    }
}
