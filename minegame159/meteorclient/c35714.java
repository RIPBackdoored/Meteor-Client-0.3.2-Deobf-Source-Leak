package minegame159.meteorclient;

import java.util.*;
import meteorclient.util.*;

public class c35714 extends c36715
{
    public c38582 f35715;
    public final c31870.WindowType f35716;
    private final String f35717;
    private c36715 f35718;
    private boolean f35719;
    private c37439 f35720;
    private double f35721;
    private double f35722;
    private boolean f35723;
    private double f35724;
    private double f35725;
    
    public c35714(final String f35717, final boolean f35718, final double f35719, final double f35720, final c31870.WindowType f35721) {
        super();
        this.f35717 = f35717;
        this.f35719 = f35718;
        this.f35721 = f35719;
        this.f35722 = f35720;
        this.f35716 = f35721;
        this.f36716.m39580(0.0);
        this.m35729();
        if (f35721 != null) {
            this.m35731(c31870.f37895.m37932(f35721, f35718).m31884());
        }
    }
    
    public c35714(final String s, final boolean b, final c31870.WindowType windowType) {
        this(s, b, 6.0, 4.0, windowType);
    }
    
    public c35714(final String s, final boolean b) {
        this(s, b, null);
    }
    
    @Override
    public <T extends c31923> c33587<T> m31937(final T t) {
        return this.f35718.m31937(t);
    }
    
    @Override
    public void m36739() {
        this.f35718.m36739();
    }
    
    @Override
    public void m31945() {
        this.f35718.m31945();
    }
    
    private void m35729() {
        this.f35720 = super.m31937(new c37439()).m39587().m39583().m39632();
        super.m36739();
        (this.f35718 = super.m31937(new c36715()).m39587().m39583().m39632()).m36760(this.f35721);
        this.f35718.f36716.m39580(this.f35722);
    }
    
    public void m35731(final boolean f35719) {
        this.f35719 = f35719;
        this.f35720.f37441.m37364(!f35719);
    }
    
    @Override
    public boolean m32019(final int n) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f35719 || c33587.m39632() instanceof c37439) && c33587.m39632().m32019(n)) {
                return true;
            }
        }
        return this.m32023(n);
    }
    
    @Override
    public boolean m32026(final int n) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f35719 || c33587.m39632() instanceof c37439) && c33587.m39632().m32026(n)) {
                return true;
            }
        }
        return this.m32030(n);
    }
    
    @Override
    public void m32009(final double n, final double n2) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if (this.f35719 || c33587.m39632() instanceof c37439) {
                c33587.m39632().m32009(n, n2);
            }
        }
        final boolean f31932 = this.f31932;
        this.f31932 = this.m31947(n, n2);
        if (f31932 && this.f31932) {
            this.f31933 = 0.0;
        }
        this.m32015(n, n2);
    }
    
    @Override
    public boolean m32033(final double n) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f35719 || c33587.m39632() instanceof c37439) && c33587.m39632().m32033(n)) {
                return true;
            }
        }
        return this.m32037(n);
    }
    
    @Override
    public boolean m32040(final int n, final int n2) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f35719 || c33587.m39632() instanceof c37439) && c33587.m39632().m32040(n, n2)) {
                return true;
            }
        }
        return this.m32045(n, n2);
    }
    
    @Override
    public boolean m32049(final int n, final int n2) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f35719 || c33587.m39632() instanceof c37439) && c33587.m39632().m32049(n, n2)) {
                return true;
            }
        }
        return this.m32054(n, n2);
    }
    
    @Override
    public boolean m32058(final char c, final int n) {
        for (final c33587<c31923> c2 : this.f31930) {
            if ((this.f35719 || c2.m39632() instanceof c37439) && c2.m39632().m32058(c, n)) {
                return true;
            }
        }
        return this.m32063(c, n);
    }
    
    @Override
    protected void m31978() {
        this.f36717 = EnchantUtil.m35546() - 32.0;
        this.f36718 = (this.f35719 ? 1.0 : 0.0);
        super.m31978();
    }
    
    @Override
    protected void m31972() {
        super.m31972();
        if (this.f35723) {
            this.m31951(this.f35724 - this.f31925, this.f35725 - this.f31926, true);
        }
    }
    
    @Override
    public void m31985(final c36250 c36250, final double n, final double n2, final double n3) {
        this.f36718 += n3 / 4.0 * (this.f35719 ? 1 : -1);
        this.f36718 = EnchantUtil.m35644(this.f36718, this.f35720.f31928 / this.f31928, 1.0);
        super.m31985(c36250, n, n2, n3);
    }
    
    @Override
    protected void m31992(final c31923 c31923, final c36250 c31924, final double n, final double n2, final double n3) {
        if (this.f35719 || this.f36718 > this.f35720.f31928 / this.f31928) {
            c31923.m31985(c31924, n, n2, n3);
        }
        else if (c31923 instanceof c37439) {
            c31923.m31985(c31924, n, n2, n3);
        }
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        if (this.f35719 || this.f36718 > 0.0) {
            c36250.m36337(this.f31925, this.f31926, this.f31927, this.f31928, c31870.f37895.f37900);
        }
    }
    
    static /* synthetic */ String m35778(final c35714 c35714) {
        return c35714.f35717;
    }
    
    static /* synthetic */ double m35780(final c35714 c35714, final double f35724) {
        return c35714.f35724 = f35724;
    }
    
    static /* synthetic */ double m35783(final c35714 c35714, final double f35725) {
        return c35714.f35725 = f35725;
    }
    
    static /* synthetic */ boolean m35786(final c35714 c35714, final boolean f35723) {
        return c35714.f35723 = f35723;
    }
    
    static /* synthetic */ boolean m35789(final c35714 c35714, final boolean f35719) {
        return c35714.f35719 = f35719;
    }
    
    private class c37439 extends c36715
    {
        c39081 f37440;
        c37353 f37441;
        boolean f37442;
        double f37443;
        double f37444;
        final /* synthetic */ c35714 f37445;
        
        c37439(final c35714 f37445) {
            this.f37445 = f37445;
            super();
            this.m36760(4.0);
            this.f37440 = this.m31937(new c39081(f37445.f35717, true)).m39587().m39591().m39606(4.0).m39632();
            this.f37441 = this.m31937(new c37353()).m39632();
            this.f37441.f37354 = (c37353 -> {
                this.f37445.f35719 = !c37353.f37356;
                if (this.f37445.f35716 != null) {
                    c31870.f37895.m37932(this.f37445.f35716, false).m31886(!c37353.f37356);
                }
            });
        }
        
        @Override
        protected boolean m32023(final int n) {
            return this.f31932 && n == 0 && (this.f37442 = true);
        }
        
        @Override
        protected boolean m32030(final int n) {
            if (this.f31932) {
                this.f37442 = false;
                if (n == 1) {
                    this.f37441.f37357 = true;
                    this.f37441.m32030(n);
                }
                return true;
            }
            return false;
        }
        
        @Override
        protected void m32015(final double f37443, final double f37444) {
            if (this.f37442) {
                this.f37445.m31951(f37443 - this.f37443, f37444 - this.f37444, false);
                this.f37445.f35724 = this.f37445.f31925;
                this.f37445.f35725 = this.f37445.f31926;
                this.f37445.f35723 = true;
                if (this.f37445.f35715 != null) {
                    this.f37445.f35715.m38583(this.f37445);
                }
            }
            this.f37443 = f37443;
            this.f37444 = f37444;
        }
        
        @Override
        protected void m31972() {
            super.m31972();
        }
        
        @Override
        protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
            c36250.m36337(this.f31925, this.f31926, this.f31927, this.f31928, c31870.f37895.f37915);
        }
        
        private /* synthetic */ void m37459(final c37353 c37353) {
            this.f37445.f35719 = !c37353.f37356;
            if (this.f37445.f35716 != null) {
                c31870.f37895.m37932(this.f37445.f35716, false).m31886(!c37353.f37356);
            }
        }
    }
}
