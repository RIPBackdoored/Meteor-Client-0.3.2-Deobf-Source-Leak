package minegame159.meteorclient;

public class c36419 extends c31923
{
    public c32908 f36420;
    private boolean f36421;
    
    public c36419() {
        super();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 14.0;
        this.f31928 = 14.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f36421 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f36421) {
            this.f36421 = false;
            if (this.f36420 != null) {
                this.f36420.m32909(this);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36344(this, this.f31932, this.f36421);
        c37042 c36251 = c31870.f37895.f37912;
        if (this.f36421) {
            c36251 = c31870.f37895.f37914;
        }
        else if (this.f31932) {
            c36251 = c31870.f37895.f37913;
        }
        c36250.m36337(this.f31925 + 4.0, this.f31926 + 4.0 + 2.0, 6.0, 2.0, c36251);
    }
}
