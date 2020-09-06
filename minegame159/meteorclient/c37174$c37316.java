package minegame159.meteorclient;

private class c37316 extends c31923
{
    double f37317;
    double f37318;
    double f37319;
    double f37320;
    boolean f37321;
    double f37322;
    double f37323;
    boolean f37324;
    final /* synthetic */ c37174 f37325;
    
    private c37316(final c37174 f37325) {
        this.f37325 = f37325;
        super();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 100.0;
        this.f31928 = this.f31927;
    }
    
    void m37327(final c37042 c37042, final boolean b) {
        final double n = Math.min(Math.min(c37042.f37045, c37042.f37046), c37042.f37047);
        final double n2 = Math.max(Math.max(c37042.f37045, c37042.f37046), c37042.f37047);
        final double n3 = n2 - n;
        this.f37318 = n2 / 255.0;
        if (n3 == 0.0) {
            this.f37317 = 0.0;
        }
        else {
            this.f37317 = n3 / n2;
        }
        if (b) {
            this.f37319 = this.f37317 * this.f31927;
            this.f37320 = (1.0 - this.f37318) * this.f31928;
        }
        else {
            this.f37324 = true;
        }
    }
    
    @Override
    protected void m31972() {
        if (this.f37324) {
            this.f37319 = this.f37317 * this.f31927;
            this.f37320 = (1.0 - this.f37318) * this.f31928;
            this.f37324 = false;
        }
        super.m31972();
    }
    
    @Override
    protected boolean m32023(final int n) {
        if (this.f31932) {
            this.f37321 = true;
            this.f37319 = this.f37322 - this.f31925;
            this.f37320 = this.f37323 - this.f31926;
            this.m37343();
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f37321) {
            this.f37321 = false;
        }
        return this.f31932;
    }
    
    @Override
    protected void m32015(final double f37322, final double f37323) {
        if (this.f37321) {
            if (f37322 >= this.f31925 && f37322 <= this.f31925 + this.f31927) {
                this.f37319 += f37322 - this.f37322;
            }
            else if (this.f37319 > 0.0 && f37322 < this.f31925) {
                this.f37319 = 0.0;
            }
            else if (this.f37319 < this.f31927 && f37322 > this.f31925 + this.f31927) {
                this.f37319 = this.f31927;
            }
            if (f37323 >= this.f31926 && f37323 <= this.f31926 + this.f31928) {
                this.f37320 += f37323 - this.f37323;
            }
            else if (this.f37320 > 0.0 && f37323 < this.f31926) {
                this.f37320 = 0.0;
            }
            else if (this.f37320 < this.f31928 && f37323 > this.f31926 + this.f31928) {
                this.f37320 = this.f31928;
            }
            this.m37343();
        }
        this.f37322 = f37322;
        this.f37323 = f37323;
    }
    
    void m37343() {
        final double f37317 = this.f37319 / this.f31927;
        final double n = this.f37320 / this.f31928;
        this.f37317 = f37317;
        this.f37318 = 1.0 - n;
        c37174.m39701(this.f37325);
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c37174.m39703(this.f37325).m37195();
        c36250.m36310(this.f31925, this.f31926, this.f31927, this.f31928, null, c37174.m39705(), c37174.m39703(this.f37325).f37178, c37174.m39706(), c37174.m39706());
        c37042 c36251 = c31870.f37895.f37925;
        if (this.f37321) {
            c36251 = c31870.f37895.f37927;
        }
        else if (n >= this.f31925 + this.f37319 - 1.0 && n <= this.f31925 + this.f37319 + 1.0 && n2 >= this.f31926 + this.f37320 - 1.0 && n2 <= this.f31926 + this.f37320 + 1.0) {
            c36251 = c31870.f37895.f37926;
        }
        c36250.m36337(this.f31925 + this.f37319 - 1.0, this.f31926 + this.f37320 - 1.0, 2.0, 2.0, c36251);
    }
    
    c37316(final c37174 c37174, final c39096 c37175) {
        this(c37174);
    }
}
