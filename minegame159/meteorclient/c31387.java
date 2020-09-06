package minegame159.meteorclient;

import net.minecraft.util.*;
import net.minecraft.*;
import java.util.*;

public class c31387 extends c35714
{
    private static final String[] f31388;
    private c31399 f31389;
    
    public c31387() {
        super("Search", false, c31870.WindowType.Search);
        this.f35715 = (p0 -> c31870.f37895.m37932(this.f35716, false).m31880(this.f31925, this.f31926));
        this.m35729();
    }
    
    private void m35729() {
        final boolean b = this.f31389 != null && this.f31389.m31410();
        if (b) {
            c34739.m34741(false);
        }
        (this.f31389 = this.m31937(new c31399((this.f31389 != null) ? this.f31389.f31403 : "", 70.0)).m39587().m39583().m39632()).m31416(b);
        this.f31389.f31401 = (p0 -> {
            this.m31945();
            this.m35729();
            return;
        });
        this.m36739();
        if (!this.f31389.f31403.isEmpty()) {
            final List<class_3545<c38667, Integer>> m34062 = c34030.f34033.m34062(this.f31389.f31403);
            if (m34062.size() > 0) {
                this.m31937(new c38757("Modules")).m39587().m39583();
                this.m36739();
            }
            final Iterator<class_3545<c38667, Integer>> iterator = m34062.iterator();
            while (iterator.hasNext()) {
                this.m31937(new c33647((c38667)((Pair)iterator.next()).getLeft())).m39580(0.0);
                this.m36739();
            }
            final List<class_3545<c38667, Integer>> m34063 = c34030.f34033.m34068(this.f31389.f31403);
            this.m31937(new c38757("Settings")).m39587().m39583();
            this.m36739();
            final Iterator<class_3545<c38667, Integer>> iterator2 = m34063.iterator();
            while (iterator2.hasNext()) {
                this.m31937(new c33647((c38667)((Pair)iterator2.next()).getLeft()));
                this.m36739();
            }
        }
    }
    
    private /* synthetic */ void m31390(final c31399 c31399) {
        this.m31945();
        this.m35729();
    }
    
    private /* synthetic */ void m31393(final c35714 c35714) {
        c31870.f37895.m37932(this.f35716, false).m31880(this.f31925, this.f31926);
    }
    
    static {
        f31388 = new String[] { "Search", "", "Modules", "Settings" };
    }
}
