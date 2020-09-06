package minegame159.meteorclient;

import meteorclient.util.*;
import java.util.*;

public class c34745 extends c31923
{
    public c34745() {
        super();
        final Category[] f34032 = c34030.f34032;
        for (int length = f34032.length, i = 0; i < length; ++i) {
            this.m31937(new c35851(f34032[i]));
        }
        this.m31937(new c36630());
        this.m31937(new c31387());
    }
    
    @Override
    protected void m31978() {
        this.f31927 = ((this.f31929 != null) ? (this.f31929.f31927 - (this.f31929.f31927 - this.f31925)) : 0.0);
        this.f31928 = ((this.f31929 != null) ? (this.f31929.f31928 - (this.f31929.f31928 - this.f31926)) : 0.0);
    }
    
    @Override
    protected void m31972() {
        double f31925 = this.f31925;
        double m31878 = this.f31926 + 16.0;
        for (final c33587<c35714> c33587 : this.f31930) {
            final c31870.c31871 m31879 = c31870.f37895.m37932(c33587.m39632().f35716, false);
            boolean b = false;
            double f31926;
            if (m31879.m31876() != -1.0 && m31879.m31878() != -1.0) {
                f31926 = m31879.m31876();
                m31878 = m31879.m31878();
            }
            else {
                f31926 = f31925 + 16.0;
                b = true;
            }
            c33587.f39547 = c33587.m39632().f31927;
            c33587.f39548 = c33587.m39632().f31928;
            if (b && f31926 + c33587.f39547 > EnchantUtil.m35545()) {
                f31926 = this.f31925;
                m31878 += 60.0;
            }
            if (f31926 > EnchantUtil.m35545()) {
                f31926 = EnchantUtil.m35545() / 2.0 - c33587.f39547 / 2.0;
                if (f31926 < 0.0) {
                    f31926 = 0.0;
                }
            }
            if (m31878 > EnchantUtil.m35546()) {
                m31878 = EnchantUtil.m35546() / 2.0 - c33587.f39548 / 2.0;
                if (m31878 < 0.0) {
                    m31878 = 0.0;
                }
            }
            if (f31926 != m31879.m31876() || m31878 != m31879.m31878()) {
                m31879.m31880(f31926, m31878);
            }
            c33436.f34122.m37303();
            c33587.f39545 = f31926;
            c33587.f39546 = m31878;
            f31925 = f31926 + c33587.f39547;
            c33587.m39637();
        }
    }
}
