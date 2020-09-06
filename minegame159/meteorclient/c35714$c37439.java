package minegame159.meteorclient;

private class c37439 extends c36715
{
    c39081 f37440;
    c37353 f37441;
    boolean f37442;
    double f37443;
    double f37444;
    final /* synthetic */ c35714 f37445;
    
    c37439(final c35714 f37445) {
        this.f37445 = f37445;
        super();
        this.m36760(4.0);
        this.f37440 = this.m31937(new c39081(c35714.m35778(f37445), true)).m39587().m39591().m39606(4.0).m39632();
        this.f37441 = this.m31937(new c37353()).m39632();
        this.f37441.f37354 = (c37353 -> {
            c35714.m35789(this.f37445, !c37353.f37356);
            if (this.f37445.f35716 != null) {
                c31870.f37895.m37932(this.f37445.f35716, false).m31886(!c37353.f37356);
            }
        });
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && n == 0 && (this.f37442 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f31932) {
            this.f37442 = false;
            if (n == 1) {
                this.f37441.f37357 = true;
                this.f37441.m32030(n);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m32015(final double f37443, final double f37444) {
        if (this.f37442) {
            this.f37445.m31951(f37443 - this.f37443, f37444 - this.f37444, false);
            c35714.m35780(this.f37445, this.f37445.f31925);
            c35714.m35783(this.f37445, this.f37445.f31926);
            c35714.m35786(this.f37445, true);
            if (this.f37445.f35715 != null) {
                this.f37445.f35715.m38583(this.f37445);
            }
        }
        this.f37443 = f37443;
        this.f37444 = f37444;
    }
    
    @Override
    protected void m31972() {
        super.m31972();
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36337(this.f31925, this.f31926, this.f31927, this.f31928, c31870.f37895.f37915);
    }
    
    private /* synthetic */ void m37459(final c37353 c37353) {
        c35714.m35789(this.f37445, !c37353.f37356);
        if (this.f37445.f35716 != null) {
            c31870.f37895.m37932(this.f37445.f35716, false).m31886(!c37353.f37356);
        }
    }
}
