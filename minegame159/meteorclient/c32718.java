package minegame159.meteorclient;

import java.util.*;
import meteorclient.util.*;

public class c32718 extends c36715
{
    private final String f32719;
    public final c38381 f32720;
    public final c36715 f32721;
    public boolean f32722;
    private double f32723;
    
    public c32718(final String f32719) {
        super();
        this.f32722 = false;
        this.f32719 = f32719;
        this.f32720 = super.m31937(new c38381()).m39587().m39583().m39632();
        super.m36739();
        (this.f32721 = super.m31937(new c36715()).m39587().m39583().m39632()).m36760(4.0);
    }
    
    @Override
    public <T extends c31923> c33587<T> m31937(final T t) {
        return this.f32721.m31937(t);
    }
    
    @Override
    public void m36739() {
        this.f32721.m36739();
    }
    
    @Override
    public void m31945() {
        this.f32721.m31945();
    }
    
    @Override
    public boolean m32019(final int n) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f32722 || c33587.m39632() instanceof c38381) && c33587.m39632().m32019(n)) {
                return true;
            }
        }
        return this.m32023(n);
    }
    
    @Override
    public boolean m32026(final int n) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f32722 || c33587.m39632() instanceof c38381) && c33587.m39632().m32026(n)) {
                return true;
            }
        }
        return this.m32030(n);
    }
    
    @Override
    public void m32009(final double n, final double n2) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if (this.f32722 || c33587.m39632() instanceof c38381) {
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
            if ((this.f32722 || c33587.m39632() instanceof c38381) && c33587.m39632().m32033(n)) {
                return true;
            }
        }
        return this.m32037(n);
    }
    
    @Override
    public boolean m32040(final int n, final int n2) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f32722 || c33587.m39632() instanceof c38381) && c33587.m39632().m32040(n, n2)) {
                return true;
            }
        }
        return this.m32045(n, n2);
    }
    
    @Override
    public boolean m32049(final int n, final int n2) {
        for (final c33587<c31923> c33587 : this.f31930) {
            if ((this.f32722 || c33587.m39632() instanceof c38381) && c33587.m39632().m32049(n, n2)) {
                return true;
            }
        }
        return this.m32054(n, n2);
    }
    
    @Override
    public boolean m32058(final char c, final int n) {
        for (final c33587<c31923> c2 : this.f31930) {
            if ((this.f32722 || c2.m39632() instanceof c38381) && c2.m39632().m32058(c, n)) {
                return true;
            }
        }
        return this.m32063(c, n);
    }
    
    @Override
    protected void m31978() {
        this.f36717 = EnchantUtil.m35546() - 32.0;
        super.m31978();
        this.f32723 = this.f31928;
        if (!this.f32722) {
            this.f31928 = this.f32720.f31928;
        }
    }
    
    public void m32754(final boolean f32722) {
        this.f32722 = f32722;
        this.f32720.f38382.f37356 = !f32722;
        if (f32722) {
            this.f31928 = this.f32723;
        }
        else {
            this.f31928 = this.f32720.f31928;
        }
        this.m31935();
    }
    
    @Override
    protected void m31992(final c31923 c31923, final c36250 c31924, final double n, final double n2, final double n3) {
        if (this.f32722) {
            c31923.m31985(c31924, n, n2, n3);
        }
        else if (c31923 instanceof c38381) {
            c31923.m31985(c31924, n, n2, n3);
        }
    }
    
    static /* synthetic */ String m32763(final c32718 c32718) {
        return c32718.f32719;
    }
    
    public class c38381 extends c36715
    {
        private final c37353 f38382;
        final /* synthetic */ c32718 f38383;
        
        c38381(final c32718 f38383) {
            this.f38383 = f38383;
            super();
            this.m36760(4.0);
            this.f38382 = this.m31937(new c37353()).m39632();
            this.f38382.f37355 = true;
            this.f38382.f37356 = !f38383.f32722;
            this.f38382.f37354 = (c37353 -> this.f38383.m32754(!c37353.f37356));
            this.m31937(new c39081(f38383.f32719, true)).m39587().m39591().m39606(4.0);
        }
        
        @Override
        protected boolean m32030(final int n) {
            if (this.f31932) {
                this.f38382.f37357 = true;
                this.f38382.m32030(n);
                return true;
            }
            return false;
        }
        
        private /* synthetic */ void m38386(final c37353 c37353) {
            this.f38383.m32754(!c37353.f37356);
        }
        
        static /* synthetic */ c37353 m38389(final c38381 c38381) {
            return c38381.f38382;
        }
    }
}
