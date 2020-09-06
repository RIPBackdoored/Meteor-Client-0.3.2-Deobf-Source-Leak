package minegame159.meteorclient;

import java.util.*;

public class c36630 extends c35714
{
    private static final String[] f36631;
    
    public c36630() {
        super("Profiles", false, c31870.WindowType.Profiles);
        this.f35715 = (p0 -> c31870.f37895.m37932(this.f35716, false).m31880(this.f31925, this.f31926));
        this.m35729();
    }
    
    private void m35729() {
        final c36715 c36715 = this.m31937(new c36715()).m39632();
        final List<String> m35022 = c35019.m35022();
        final Iterator<String> iterator = m35022.iterator();
        while (iterator.hasNext()) {
            c36715.m31937(new c39081(iterator.next()));
            final String s;
            c36715.m31937(new c38616("Save")).m39632().f38618 = (p1 -> c35019.m35027(s));
            c36715.m31937(new c38616("Load")).m39632().f38618 = (p1 -> c35019.m35030(s));
            c36715.m31937(new c36419()).m39632().f36420 = (p1 -> {
                c35019.m35033(s);
                this.m31945();
                this.m35729();
                return;
            });
            c36715.m36739();
        }
        this.m36739();
        if (m35022.size() > 0) {
            this.m31937(new c38757()).m39587().m39583();
            this.m36739();
        }
        final c36715 c36716;
        this.m31937(new c36715()).m39587().m39583().m39632().m31937(new c35036()).m39632().f35037 = (p1 -> {
            if (c35019.m35027(c36716.m31937(new c31399("", 70.0)).m39587().m39583().m39632().f31403)) {
                this.m31945();
                this.m35729();
            }
        });
    }
    
    private /* synthetic */ void m36642(final c31399 c31399, final c35036 c31400) {
        if (c35019.m35027(c31399.f31403)) {
            this.m31945();
            this.m35729();
        }
    }
    
    private /* synthetic */ void m36646(final String s, final c36419 c36419) {
        c35019.m35033(s);
        this.m31945();
        this.m35729();
    }
    
    private static /* synthetic */ void m36650(final String s, final c38616 c38616) {
        c35019.m35030(s);
    }
    
    private static /* synthetic */ void m36653(final String s, final c38616 c38616) {
        c35019.m35027(s);
    }
    
    private /* synthetic */ void m36656(final c35714 c35714) {
        c31870.f37895.m37932(this.f35716, false).m31880(this.f31925, this.f31926);
    }
    
    static {
        f36631 = new String[] { "Profiles", "Save", "Load", "" };
    }
}
