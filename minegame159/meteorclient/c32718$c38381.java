package minegame159.meteorclient;

public class c38381 extends c36715
{
    private final c37353 f38382;
    final /* synthetic */ c32718 f38383;
    
    c38381(final c32718 f38383) {
        this.f38383 = f38383;
        super();
        this.m36760(4.0);
        this.f38382 = this.m31937(new c37353()).m39632();
        this.f38382.f37355 = true;
        this.f38382.f37356 = !f38383.f32722;
        this.f38382.f37354 = (c37353 -> this.f38383.m32754(!c37353.f37356));
        this.m31937(new c39081(c32718.m32763(f38383), true)).m39587().m39591().m39606(4.0);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f31932) {
            this.f38382.f37357 = true;
            this.f38382.m32030(n);
            return true;
        }
        return false;
    }
    
    private /* synthetic */ void m38386(final c37353 c37353) {
        this.f38383.m32754(!c37353.f37356);
    }
    
    static /* synthetic */ c37353 m38389(final c38381 c38381) {
        return c38381.f38382;
    }
}
