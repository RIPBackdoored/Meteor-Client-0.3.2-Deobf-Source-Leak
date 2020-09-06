package minegame159.meteorclient;

public class c38757 extends c31923
{
    private String f38758;
    private double f38759;
    
    public c38757(final String f38758) {
        super();
        this.f38758 = f38758;
        this.f38759 = ((f38758 != null) ? MeteorClient.smallFont.m33815(f38758) : 0.0);
    }
    
    public c38757() {
        this(null);
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 0.0;
        this.f31928 = ((this.f38758 != null) ? MeteorClient.smallFont.m33813() : 1.0);
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        final double n4 = this.f31927 / 2.0 - this.f38759 / 2.0 - 2.0;
        final double n5 = 2.0 + n4 + this.f38759 + 2.0;
        final double n6 = this.f31928 / 2.0;
        if (this.f38758 != null) {
            c36250.m36337(this.f31925, this.f31926 + n6, n4, 1.0, c31870.f37895.f37908);
            c36250.m36370(this.f38758, this.f31925 + n4 + 2.0, this.f31926, c31870.f37895.f37908, false);
            c36250.m36337(this.f31925 + n5, this.f31926 + n6, this.f31927 - n5, 1.0, c31870.f37895.f37908);
        }
        else {
            c36250.m36337(this.f31925, this.f31926, this.f31927, this.f31928, c31870.f37895.f37908);
        }
    }
}
