package minegame159.meteorclient;

import java.util.*;

public class c35851 extends c35714
{
    public static boolean f35852;
    public final Category f35853;
    
    public c35851(final Category f35853) {
        super(f35853.toString(), false, 0.0, 0.0, c31870.WindowType.valueOf(f35853.toString()));
        this.f35853 = f35853;
        this.f35715 = (p0 -> {
            c31870.f37895.m37932(this.f35716, false).m31880(this.f31925, this.f31926);
            c35851.f35852 = true;
            return;
        });
        final Iterator<c38667> iterator = c34030.f34033.m34052(f35853).iterator();
        while (iterator.hasNext()) {
            this.m31937(new c33647(iterator.next())).m39587().m39583();
            this.m36739();
        }
    }
    
    private /* synthetic */ void m35854(final c35714 c35714) {
        c31870.f37895.m37932(this.f35716, false).m31880(this.f31925, this.f31926);
        c35851.f35852 = true;
    }
    
    static {
        c35851.f35852 = false;
    }
}
