package minegame159.meteorclient;

import meteorclient.util.*;

public class c31892 extends c31399
{
    public c33951 f31893;
    public double f31894;
    
    public c31892(final double f31894, final double n) {
        super(EnchantUtil.m35634(f31894), n);
        this.f31402 = c38392.f38395;
        this.f31894 = f31894;
        super.f31401 = this::m31896;
    }
    
    @Override
    protected void m31408() {
        if (this.f31403.length() > 1 || (this.f31403.length() == 1 && this.f31403.charAt(0) != '-')) {
            super.m31408();
        }
    }
    
    private void m31896(final c31399 c31399) {
        final double f31894 = this.f31894;
        if (this.f31403.isEmpty()) {
            this.f31894 = 0.0;
        }
        else if (this.f31403.length() == 1 && this.f31403.charAt(0) == '-') {
            this.f31894 = 0.0;
        }
        else {
            try {
                this.f31894 = Double.parseDouble(this.f31403);
            }
            catch (NumberFormatException ex) {
                this.f31894 = 0.0;
                this.f31403 = EnchantUtil.m35634(this.f31894);
            }
        }
        if (this.f31893 != null && this.f31894 != f31894) {
            this.f31893.m33952(this);
        }
    }
    
    public void m31901(final double f31894) {
        this.f31894 = f31894;
        this.f31403 = EnchantUtil.m35634(f31894);
    }
}
