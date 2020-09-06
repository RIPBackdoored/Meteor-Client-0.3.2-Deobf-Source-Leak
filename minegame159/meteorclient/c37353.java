package minegame159.meteorclient;

import meteorclient.util.*;

public class c37353 extends c31923
{
    public c34240 f37354;
    public boolean f37355;
    public boolean f37356;
    boolean f37357;
    private double f37358;
    
    public c37353() {
        super();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 10.0;
        this.f31928 = 10.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f37357 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f37357) {
            this.f37357 = false;
            this.f37356 = !this.f37356;
            if (this.f37354 != null) {
                this.f37354.m34241(this);
            }
            return true;
        }
        return false;
    }
    
    public void m37364(final boolean f37356) {
        this.f37356 = f37356;
        this.f37358 = (f37356 ? -90.0 : 0.0);
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c37042 c36251 = this.f37355 ? c31870.f37895.f37915 : c31870.f37895.f37900;
        if (this.f37357) {
            c36251 = (this.f37355 ? c31870.f37895.f37915 : c31870.f37895.f37902);
        }
        else if (this.f31932) {
            c36251 = (this.f37355 ? c31870.f37895.f37915 : c31870.f37895.f37901);
        }
        this.f37358 += n3 * 40.0 * (this.f37356 ? -1 : 1);
        this.f37358 = EnchantUtil.m35644(this.f37358, -90.0, 0.0);
        c36250.m36351(this.f31925, this.f31926 + this.f31928 / 4.0, this.f31927, this.f37358, c36251);
    }
}
