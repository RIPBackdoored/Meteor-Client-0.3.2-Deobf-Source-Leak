package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import org.lwjgl.glfw.*;

public class c38854 extends c39130 implements Listenable
{
    private static final String[] f38855;
    private c37831 f38856;
    private c39081 f38857;
    private boolean f38858;
    private final boolean f38859;
    @EventHandler
    private Listener<c38944> f38860;
    
    public c38854(final c37831 c37831) {
        super("Edit Macro", true);
        this.f38860 = (Listener<c38944>)new Listener(c38944 -> {
            if (this.f38858) {
                this.f38858 = false;
                this.f38856.f37835 = c38944.f38945;
                this.f38857.m39087(this.m38876());
            }
        }, 200, new Predicate[0]);
        this.f38856 = ((c37831 == null) ? new c37831() : c37831);
        this.f38859 = (c37831 == null);
        this.m38861(c37831);
    }
    
    private void m38861(final c37831 c37831) {
        this.add(new c39081("Name:"));
        final c31399 c37833 = this.add(new c31399(this.f38859 ? "" : this.f38856.f37833, 200.0)).m39587().m39583().m39632();
        c37833.m31416(true);
        c37833.f31401 = (c37832 -> this.f38856.f37833 = c37832.f31403.trim());
        this.m39132();
        this.add(new c39081("Messages:")).m39603(2.0).m39595();
        final c36715 c37834 = this.add(new c36715()).m39632();
        this.m38869(c37834);
        this.m39132();
        c37834.m31937(new c35036()).m39632().f35037 = (p1 -> {
            this.f38856.f37834.add(c37834.m31937(new c31399("", 200.0)).m39587().m39583().m39632().f31403.trim());
            this.clear();
            this.m38861(this.f38856);
            return;
        });
        this.f38857 = this.add(new c39081(this.m38876())).m39632();
        this.add(new c38616("Set key")).m39632().f38618 = (p0 -> {
            this.f38858 = true;
            this.f38857.m39087(this.m38876());
            return;
        });
        this.m39132();
        this.add(new c38757());
        this.m39132();
        this.add(new c38616(this.f38859 ? "Add" : "Apply")).m39587().m39583().m39632().f38618 = (p0 -> {
            if (this.f38859) {
                if (this.f38856.f37833 != null && !this.f38856.f37833.isEmpty() && this.f38856.f37834.size() > 0 && this.f38856.f37835 != -1) {
                    c33410.f33412.m33414(this.f38856);
                    this.onClose();
                }
            }
            else {
                c33410.f33412.m37303();
                MeteorClient.eventBus.post((Object)c34429.m34505());
                this.onClose();
            }
        });
    }
    
    protected void init() {
        super.init();
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    private void m38869(final c36715 c36715) {
        for (int i = 0; i < this.f38856.f37834.size(); ++i) {
            final int n;
            final String s;
            c36715.m31937(new c31399(this.f38856.f37834.get(i), 200.0)).m39632().f31401 = (c36716 -> s = this.f38856.f37834.set(n, c36716.f31403.trim()));
            new c36419().f36420 = (p2 -> {
                this.f38856.m37840(n);
                c36715.m31945();
                this.m38869(c36715);
                return;
            });
            c36715.m36739();
        }
    }
    
    private String m38876() {
        if (this.f38858) {
            return "Press any key";
        }
        return "Key: " + ((this.f38856.f37835 == -1) ? "none" : GLFW.glfwGetKeyName(this.f38856.f37835, 0));
    }
    
    public void onClose() {
        MeteorClient.eventBus.unsubscribe((Listenable)this);
        super.onClose();
    }
    
    private /* synthetic */ void m38878(final c38944 c38944) {
        if (this.f38858) {
            this.f38858 = false;
            this.f38856.f37835 = c38944.f38945;
            this.f38857.m39087(this.m38876());
        }
    }
    
    private /* synthetic */ void m38881(final int n, final c36715 c36715, final c36419 c36716) {
        this.f38856.m37840(n);
        c36715.m31945();
        this.m38869(c36715);
    }
    
    private /* synthetic */ void m38886(final int n, final c31399 c31399) {
        final String s = this.f38856.f37834.set(n, c31399.f31403.trim());
    }
    
    private /* synthetic */ void m38890(final c38616 c38616) {
        if (this.f38859) {
            if (this.f38856.f37833 != null && !this.f38856.f37833.isEmpty() && this.f38856.f37834.size() > 0 && this.f38856.f37835 != -1) {
                c33410.f33412.m33414(this.f38856);
                this.onClose();
            }
        }
        else {
            c33410.f33412.m37303();
            MeteorClient.eventBus.post((Object)c34429.m34505());
            this.onClose();
        }
    }
    
    private /* synthetic */ void m38893(final c38616 c38616) {
        this.f38858 = true;
        this.f38857.m39087(this.m38876());
    }
    
    private /* synthetic */ void m38896(final c31399 c31399, final c35036 c31400) {
        this.f38856.f37834.add(c31399.f31403.trim());
        this.clear();
        this.m38861(this.f38856);
    }
    
    private /* bridge */ void m38900(final c31399 c31399) {
        this.f38856.f37833 = c31399.f31403.trim();
    }
    
    static {
        f38855 = new String[] { "Edit Macro", "Name:", "", "Messages:", "", "Set key", "Add", "Apply", "Press any key", "Key: ", "none" };
    }
}
