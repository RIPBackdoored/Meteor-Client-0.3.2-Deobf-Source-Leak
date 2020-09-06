package minegame159.meteorclient;

import net.minecraft.client.*;
import java.util.*;
import meteorclient.util.*;

public abstract class c31923
{
    public boolean f31924;
    public double f31925;
    public double f31926;
    public double f31927;
    public double f31928;
    protected c31923 f31929;
    protected List<c33587<?>> f31930;
    private boolean f31931;
    protected boolean f31932;
    protected double f31933;
    public String f31934;
    
    public c31923() {
        super();
        this.f31924 = true;
        this.f31930 = new ArrayList<c33587<?>>();
    }
    
    public void m31935() {
        this.m32005().f31931 = true;
    }
    
    public <T extends c31923> c33587<T> m31937(final T f39544) {
        f39544.f31929 = this;
        final c33587<Object> c33587 = new c33587<Object>();
        c33587.f39544 = f39544;
        this.f31930.add(c33587);
        this.m31935();
        return (c33587<T>)c33587;
    }
    
    public <T extends c31923> void m31941(final T f39544) {
        final c33587 c33587 = new c33587();
        c33587.f39544 = (T)f39544;
        if (this.f31930.remove(c33587)) {
            this.m31935();
        }
    }
    
    public void m31945() {
        if (this.f31930.size() > 0) {
            this.f31930.clear();
            this.m31935();
        }
    }
    
    public boolean m31947(final double n, final double n2) {
        return n >= this.f31925 && n <= this.f31925 + this.f31927 && n2 >= this.f31926 && n2 <= this.f31926 + this.f31928;
    }
    
    public void m31951(final double n, final double n2, final boolean b) {
        this.m31956(this, n, n2);
        if (b) {
            this.m32009(MinecraftClient.getInstance().mouse.getX() / MinecraftClient.getInstance().window.getScaleFactor(), MinecraftClient.getInstance().mouse.getY() / MinecraftClient.getInstance().window.getScaleFactor());
        }
    }
    
    protected void m31956(final c31923 c31923, final double n, final double n2) {
        c31923.f31925 += n;
        c31923.f31926 += n2;
        for (final c33587<c31923> c31925 : c31923.f31930) {
            final c33587<c31923> c31924 = c31925;
            c31925.f39545 += n;
            final c33587<c31923> c31926 = c31924;
            c31926.f39546 += n2;
            this.m31956(c31924.m39632(), n, n2);
        }
    }
    
    public void m31962() {
        this.m31975();
        this.m31969();
        this.m32009(MinecraftClient.getInstance().mouse.getX() / MinecraftClient.getInstance().window.getScaleFactor(), MinecraftClient.getInstance().mouse.getY() / MinecraftClient.getInstance().window.getScaleFactor());
        this.m31964(this, false);
    }
    
    private void m31964(final c31923 c31923, final boolean f31931) {
        c31923.f31931 = f31931;
        final Iterator<c33587<c31923>> iterator = c31923.f31930.iterator();
        while (iterator.hasNext()) {
            this.m31964(iterator.next().m39632(), f31931);
        }
    }
    
    private void m31969() {
        this.m31972();
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            iterator.next().m39632().m31969();
        }
    }
    
    protected void m31972() {
        for (final c33587<?> c33587 : this.f31930) {
            c33587.f39545 = this.f31925 + c33587.f39552;
            c33587.f39546 = this.f31926 + c33587.f39549;
            c33587.f39547 = this.f31927 - c33587.f39552 - c33587.f39550;
            c33587.f39548 = this.f31928 - c33587.f39549 - c33587.f39551;
            c33587.m39637();
        }
    }
    
    protected void m31975() {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            iterator.next().m39632().m31975();
        }
        this.m31978();
    }
    
    protected void m31978() {
        this.f31927 = 10.0;
        this.f31928 = 10.0;
    }
    
    public void m31980() {
        if (!this.f31924) {
            return;
        }
        this.m31983();
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            iterator.next().m39632().m31980();
        }
    }
    
    protected void m31983() {
    }
    
    public void m31985(final c36250 c36250, final double n, final double n2, final double n3) {
        if (!this.f31924) {
            return;
        }
        if (this.f31931) {
            this.m31962();
        }
        if (this.f31932) {
            this.f31933 += n3 / 10.0;
        }
        this.m31999(c36250, n, n2, n3);
        for (final c33587<c31923> c36251 : this.f31930) {
            if (c36251.f39545 > EnchantUtil.m35545()) {
                break;
            }
            if (c36251.f39546 > EnchantUtil.m35546()) {
                break;
            }
            this.m31992(c36251.m39632(), c36250, n, n2, n3);
        }
        if (this.f31932 && this.f31933 >= 1.0 && this.f31934 != null) {
            c36250.m36377(this.f31934, n + 8.0, n2 + 8.0, c31870.f37895.f37897);
        }
    }
    
    protected void m31992(final c31923 c31923, final c36250 c31924, final double n, final double n2, final double n3) {
        c31923.m31985(c31924, n, n2, n3);
    }
    
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
    }
    
    public c31923 m32005() {
        return (this.f31929 != null) ? this.f31929.m32005() : this;
    }
    
    public List<c33587<?>> m32007() {
        return this.f31930;
    }
    
    public void m32009(final double n, final double n2) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            iterator.next().m39632().m32009(n, n2);
        }
        final boolean f31932 = this.f31932;
        this.f31932 = this.m31947(n, n2);
        if (!f31932 && this.f31932) {
            this.f31933 = 0.0;
        }
        this.m32015(n, n2);
    }
    
    protected void m32015(final double n, final double n2) {
    }
    
    public boolean m32019(final int n) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().m39632().m32019(n)) {
                return true;
            }
        }
        return this.m32023(n);
    }
    
    protected boolean m32023(final int n) {
        return false;
    }
    
    public boolean m32026(final int n) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().m39632().m32026(n)) {
                return true;
            }
        }
        return this.m32030(n);
    }
    
    protected boolean m32030(final int n) {
        return false;
    }
    
    public boolean m32033(final double n) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().m39632().m32033(n)) {
                return true;
            }
        }
        return this.m32037(n);
    }
    
    protected boolean m32037(final double n) {
        return false;
    }
    
    public boolean m32040(final int n, final int n2) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().m39632().m32040(n, n2)) {
                return true;
            }
        }
        return this.m32045(n, n2);
    }
    
    protected boolean m32045(final int n, final int n2) {
        return false;
    }
    
    public boolean m32049(final int n, final int n2) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().m39632().m32049(n, n2)) {
                return true;
            }
        }
        return this.m32054(n, n2);
    }
    
    protected boolean m32054(final int n, final int n2) {
        return false;
    }
    
    public boolean m32058(final char c, final int n) {
        final Iterator<c33587<c31923>> iterator = this.f31930.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().m39632().m32058(c, n)) {
                return true;
            }
        }
        return this.m32063(c, n);
    }
    
    protected boolean m32063(final char c, final int n) {
        return false;
    }
}
