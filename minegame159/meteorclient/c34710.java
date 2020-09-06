package minegame159.meteorclient;

import meteorclient.util.*;

public class c34710 extends c31923
{
    public c36535 f34711;
    public double f34712;
    private double f34713;
    private double f34714;
    private double f34715;
    private boolean f34716;
    private boolean f34717;
    private double f34718;
    
    public c34710(final double f34713, final double f34714, final double f34715, final double f34716) {
        super();
        this.f34713 = f34713;
        this.f34714 = f34714;
        this.f34715 = f34716;
        this.f34712 = f34715;
    }
    
    @Override
    protected void m31978() {
        this.f31927 = this.f34715;
        this.f31928 = 8.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        if (this.f34716) {
            return this.f34717 = true;
        }
        if (this.f31932) {
            this.f34712 = (this.f34718 - (this.f31925 + 4.0)) / (this.f31927 - 8.0) * (this.f34714 - this.f34713) + this.f34713;
            if (this.f34711 != null) {
                this.f34711.m36536(this);
            }
            return this.f34717 = true;
        }
        return false;
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f34717) {
            this.f34717 = false;
        }
        return this.f31932;
    }
    
    @Override
    protected void m32015(final double f34718, final double n) {
        final double n2 = (this.f34712 - this.f34713) / (this.f34714 - this.f34713) * (this.f31927 - 8.0);
        final double n3 = this.f31925 + 4.0 + n2 - this.f31928 / 2.0;
        this.f34716 = (f34718 >= n3 && f34718 <= n3 + this.f31928 && n >= this.f31926 && n <= this.f31926 + this.f31928);
        final boolean b = f34718 >= this.f31925 + 4.0 && f34718 <= this.f31925 + 4.0 + this.f31927 - 8.0;
        this.f31932 = (b && n >= this.f31926 && n <= this.f31926 + this.f31928);
        if (this.f34717) {
            if (b) {
                this.f34712 = EnchantUtil.m35644(n2 + (f34718 - this.f34718), 0.0, this.f31927 - 8.0) / (this.f31927 - 8.0) * (this.f34714 - this.f34713) + this.f34713;
                if (this.f34711 != null) {
                    this.f34711.m36536(this);
                }
            }
            else if (this.f34712 > this.f34713 && f34718 < this.f31925 + 4.0) {
                this.f34712 = this.f34713;
                if (this.f34711 != null) {
                    this.f34711.m36536(this);
                }
            }
            else if (this.f34712 < this.f34714 && f34718 > this.f31925 + 4.0 + this.f31927 - 8.0) {
                this.f34712 = this.f34714;
                if (this.f34711 != null) {
                    this.f34711.m36536(this);
                }
            }
        }
        this.f34718 = f34718;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        this.f34712 = EnchantUtil.m35644(this.f34712, this.f34713, this.f34714);
        final double n4 = (this.f34712 - this.f34713) / (this.f34714 - this.f34713) * (this.f31927 - 8.0);
        c36250.m36337(this.f31925 + 4.0, this.f31926 + 3.0, n4, 2.0, c31870.f37895.f37920);
        c36250.m36337(this.f31925 + 4.0 + n4, this.f31926 + 3.0, this.f31927 - n4 - 8.0, 2.0, c31870.f37895.f37921);
        c36250.m36321(this.f31925 + 4.0 + n4 - this.f31928 / 2.0, this.f31926, this.f31928, this.f31928, c36250.f36260, c36250.f36260.m33501(this.f34716, this.f34717));
    }
}
