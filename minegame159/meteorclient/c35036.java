package minegame159.meteorclient;

public class c35036 extends c31923
{
    public c34347 f35037;
    private boolean f35038;
    
    public c35036() {
        super();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 14.0;
        this.f31928 = 14.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f35038 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f35038) {
            this.f35038 = false;
            if (this.f35037 != null) {
                this.f35037.m34348(this);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36344(this, this.f31932, this.f35038);
        c37042 c36251 = c31870.f37895.f37909;
        if (this.f35038) {
            c36251 = c31870.f37895.f37911;
        }
        else if (this.f31932) {
            c36251 = c31870.f37895.f37910;
        }
        c36250.m36337(this.f31925 + 4.0, this.f31926 + 4.0 + 2.0, 6.0, 2.0, c36251);
        c36250.m36337(this.f31925 + 4.0 + 2.0, this.f31926 + 4.0, 2.0, 6.0, c36251);
    }
}
