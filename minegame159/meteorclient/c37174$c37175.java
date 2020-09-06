package minegame159.meteorclient;

import meteorclient.util.*;

private class c37175 extends c31923
{
    private double f37176;
    private double f37177;
    private final c37042 f37178;
    private boolean f37179;
    private double f37180;
    private boolean f37181;
    final /* synthetic */ c37174 f37182;
    
    private c37175(final c37174 f37182) {
        this.f37182 = f37182;
        super();
        this.f37178 = new c37042();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 100.0;
        this.f31928 = 10.0;
    }
    
    void m37184(final boolean b) {
        final c37042 c37042 = c37174.m39707(this.f37182).m33466();
        int n = 0;
        final double n2 = Math.min(c37042.f37045, c37042.f37046);
        final double n3 = (n2 < c37042.f37047) ? n2 : c37042.f37047;
        final double n4 = Math.max(c37042.f37045, c37042.f37046);
        final double n5 = (n4 > c37042.f37047) ? n4 : c37042.f37047;
        final double n6 = n5 - n3;
        if (n6 < 1.0E-5) {
            this.f37176 = 0.0;
            n = 1;
        }
        if (n == 0) {
            if (n5 <= 0.0) {
                this.f37176 = 0.0;
                n = 1;
            }
            if (n == 0) {
                if (c37042.f37045 >= n5) {
                    this.f37176 = (c37042.f37046 - c37042.f37047) / n6;
                }
                else if (c37042.f37046 >= n5) {
                    this.f37176 = 2.0 + (c37042.f37047 - c37042.f37045) / n6;
                }
                else {
                    this.f37176 = 4.0 + (c37042.f37045 - c37042.f37046) / n6;
                }
                this.f37176 *= 60.0;
                if (this.f37176 < 0.0) {
                    this.f37176 += 360.0;
                }
            }
        }
        if (b) {
            this.f37177 = this.f37176 / 360.0 * this.f31927;
        }
        else {
            this.f37181 = true;
        }
    }
    
    @Override
    protected void m31972() {
        if (this.f37181) {
            this.f37177 = this.f37176 / 360.0 * this.f31927;
            this.f37181 = false;
        }
        super.m31972();
    }
    
    void m37195() {
        double f37176 = this.f37176;
        if (f37176 >= 360.0) {
            f37176 = 0.0;
        }
        final double n = f37176 / 60.0;
        final int n2 = (int)n;
        final double n3 = n - n2;
        final double n4 = 0.0;
        final double n5 = 1.0 * (1.0 - 1.0 * n3);
        final double n6 = 1.0 * (1.0 - 1.0 * (1.0 - n3));
        double n7 = 0.0;
        double n8 = 0.0;
        double n9 = 0.0;
        switch (n2) {
            case 0: {
                n7 = 1.0;
                n8 = n6;
                n9 = n4;
                break;
            }
            case 1: {
                n7 = n5;
                n8 = 1.0;
                n9 = n4;
                break;
            }
            case 2: {
                n7 = n4;
                n8 = 1.0;
                n9 = n6;
                break;
            }
            case 3: {
                n7 = n4;
                n8 = n5;
                n9 = 1.0;
                break;
            }
            case 4: {
                n7 = n6;
                n8 = n4;
                n9 = 1.0;
                break;
            }
            default: {
                n7 = 1.0;
                n8 = n4;
                n9 = n5;
                break;
            }
        }
        this.f37178.f37045 = (int)(n7 * 255.0);
        this.f37178.f37046 = (int)(n8 * 255.0);
        this.f37178.f37047 = (int)(n9 * 255.0);
        this.f37178.m37052();
    }
    
    @Override
    protected boolean m32023(final int n) {
        if (this.f31932) {
            this.f37179 = true;
            this.f37177 = this.f37180 - this.f31925;
            this.m37213();
            c37174.m39701(this.f37182);
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f37179) {
            this.f37179 = false;
        }
        return this.f31932;
    }
    
    @Override
    protected void m32015(final double f37180, final double n) {
        if (this.f37179) {
            if (f37180 >= this.f31925 && f37180 <= this.f31925 + this.f31927) {
                this.f37177 += f37180 - this.f37180;
                this.f37177 = EnchantUtil.m35644(this.f37177, 0.0, this.f31927);
            }
            else if (this.f37177 > 0.0 && f37180 < this.f31925) {
                this.f37177 = 0.0;
            }
            else if (this.f37177 < this.f31927 && f37180 > this.f31925 + this.f31927) {
                this.f37177 = this.f31927;
            }
            this.m37213();
            c37174.m39701(this.f37182);
        }
        this.f37180 = f37180;
    }
    
    void m37213() {
        this.f37176 = this.f37177 / (this.f31927 - 4.0) * 360.0;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        final double n4 = this.f31927 / (c37174.m39709().length - 1);
        double f31925 = this.f31925;
        for (int i = 0; i < c37174.m39709().length - 1; ++i) {
            c36250.m36329(f31925, this.f31926, n4, this.f31928, c37174.m39709()[i], c37174.m39709()[i + 1]);
            f31925 += n4;
        }
        c37042 c36251 = c31870.f37895.f37925;
        if (this.f37179) {
            c36251 = c31870.f37895.f37927;
        }
        else if (n >= this.f31925 + this.f37177 - 1.0 && n <= this.f31925 + this.f37177 + 1.0 && n2 >= this.f31926 && n2 <= this.f31926 + this.f31928) {
            c36251 = c31870.f37895.f37926;
        }
        c36250.m36337(this.f31925 + this.f37177 - 1.0, this.f31926, 2.0, this.f31928, c36251);
    }
    
    c37175(final c37174 c37174, final c39096 c37175) {
        this(c37174);
    }
    
    static /* synthetic */ double m37225(final c37175 c37175) {
        return c37175.f37176;
    }
    
    static /* synthetic */ c37042 m37227(final c37175 c37175) {
        return c37175.f37178;
    }
}
