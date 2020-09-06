package minegame159.meteorclient;

import meteorclient.util.*;

public class c38264 extends c31923
{
    public c31921 f38265;
    public boolean f38266;
    private boolean f38267;
    private double f38268;
    
    public c38264(final boolean f38266) {
        super();
        this.f38266 = f38266;
        this.f38268 = (f38266 ? 1.0 : 0.0);
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 14.0;
        this.f31928 = 14.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f38267 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f38267) {
            this.f38267 = false;
            this.f38266 = !this.f38266;
            if (this.f38265 != null) {
                this.f38265.m31922(this);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36344(this, this.f31932, this.f38267);
        this.f38268 += n3 * (this.f38266 ? 1 : -1);
        this.f38268 = EnchantUtil.m35644(this.f38268, 0.0, 1.0);
        if (this.f38268 > 0.0) {
            c36250.m36337(this.f31925 + 3.0 + 4.0 * (1.0 - this.f38268), this.f31926 + 3.0 + 4.0 * (1.0 - this.f38268), 8.0 * this.f38268, 8.0 * this.f38268, this.f38267 ? c31870.f37895.f37907 : c31870.f37895.f37906);
        }
    }
}
