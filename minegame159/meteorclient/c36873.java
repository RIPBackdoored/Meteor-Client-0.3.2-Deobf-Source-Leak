package minegame159.meteorclient;

public class c36873 extends c36715
{
    public c39851 f36874;
    private final c31892 f36875;
    private c34710 f36876;
    
    public c36873(final double n, final double n2, final double n3, final boolean b) {
        super();
        this.f36875 = this.m31937(new c31892(n3, 50.0)).m39632();
        if (!b) {
            this.f36876 = this.m31937(new c34710(n, n2, n3, 75.0)).m39632();
        }
        this.f36875.f31893 = (c34711 -> {
            if (!b) {
                this.f36876.f34712 = c34711.f31894;
            }
            if (this.f36874 != null) {
                this.f36874.m39852(this);
            }
            return;
        });
        if (!b) {
            this.f36876.f34711 = (c34710 -> {
                this.f36875.m31901(c34710.f34712);
                if (this.f36874 != null) {
                    this.f36874.m39852(this);
                }
            });
        }
    }
    
    public c36873(final double n, final double n2, final double n3) {
        this(n, n2, n3, false);
    }
    
    public double m36877() {
        return this.f36875.f31894;
    }
    
    public void m36879(final double f34712) {
        this.f36875.m31901(f34712);
        if (this.f36876 != null) {
            this.f36876.f34712 = f34712;
        }
    }
    
    private /* synthetic */ void m36882(final c34710 c34710) {
        this.f36875.m31901(c34710.f34712);
        if (this.f36874 != null) {
            this.f36874.m39852(this);
        }
    }
    
    private /* synthetic */ void m36885(final boolean b, final c31892 c31892) {
        if (!b) {
            this.f36876.f34712 = c31892.f31894;
        }
        if (this.f36874 != null) {
            this.f36874.m39852(this);
        }
    }
}
