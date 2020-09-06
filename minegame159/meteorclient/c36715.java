package minegame159.meteorclient;

import it.unimi.dsi.fastutil.doubles.*;
import it.unimi.dsi.fastutil.ints.*;
import net.minecraft.client.*;
import java.util.*;

public class c36715 extends c31923
{
    public final c33587<?> f36716;
    public double f36717;
    public double f36718;
    final List<List<c33587<?>>> f36719;
    private int f36720;
    private double f36721;
    private double f36722;
    private double f36723;
    private double f36724;
    private final DoubleList f36725;
    private final DoubleList f36726;
    private final DoubleList f36727;
    private final IntList f36728;
    private final DoubleList f36729;
    private final DoubleList f36730;
    private double f36731;
    public double f36732;
    public boolean f36733;
    
    public c36715() {
        super();
        this.f36716 = new c33587<Object>().m39597().m39580(2.0);
        this.f36718 = 1.0;
        this.f36719 = new ArrayList<List<c33587<?>>>(1);
        this.f36725 = (DoubleList)new DoubleArrayList(1);
        this.f36726 = (DoubleList)new DoubleArrayList(1);
        this.f36727 = (DoubleList)new DoubleArrayList(1);
        this.f36728 = (IntList)new IntArrayList(1);
        this.f36729 = (DoubleList)new DoubleArrayList(1);
        this.f36730 = (DoubleList)new DoubleArrayList(1);
        this.f36731 = -1.0;
        this.f36733 = true;
    }
    
    @Override
    public <T extends c31923> c33587<T> m31937(final T t) {
        final c33587<T> m31937 = super.m31937(t);
        m31937.m39634((c33587<T>)this.f36716);
        List<c33587<?>> list;
        if (this.f36719.size() <= this.f36720) {
            list = new ArrayList<c33587<?>>(1);
            this.f36719.add(list);
        }
        else {
            list = this.f36719.get(this.f36720);
        }
        list.add(m31937);
        return m31937;
    }
    
    public void m36739() {
        ++this.f36720;
    }
    
    @Override
    public void m31945() {
        super.m31945();
        this.f36719.clear();
        this.f36720 = 0;
    }
    
    public c36715 m36742(final double f36721) {
        this.f36721 = f36721;
        return this;
    }
    
    public c36715 m36745(final double f36722) {
        this.f36722 = f36722;
        return this;
    }
    
    public c36715 m36748(final double f36723) {
        this.f36723 = f36723;
        return this;
    }
    
    public c36715 m36751(final double f36724) {
        this.f36724 = f36724;
        return this;
    }
    
    public c36715 m36754(final double n) {
        this.f36724 = n;
        this.f36722 = n;
        return this;
    }
    
    public c36715 m36757(final double n) {
        this.f36723 = n;
        this.f36721 = n;
        return this;
    }
    
    public c36715 m36760(final double n) {
        this.f36724 = n;
        this.f36723 = n;
        this.f36722 = n;
        this.f36721 = n;
        return this;
    }
    
    @Override
    protected boolean m32037(final double n) {
        if (this.f36731 != -1.0 && this.f31932) {
            final double f36732 = this.f36732;
            this.f36732 += n * 16.0;
            if (this.f36732 > 0.0) {
                this.f36732 = 0.0;
            }
            else if (this.f36732 < -(this.f36731 - this.f31928)) {
                this.f36732 = -(this.f36731 - this.f31928);
            }
            this.m36792(0.0, this.f36732 - f36732);
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31978() {
        this.m36797();
        this.f36725.clear();
        double n = this.f31926 + this.f36721;
        double max = this.f31925 + this.f36724;
        double n2 = this.f31926 + this.f36721;
        double double1 = 0.0;
        for (int i = 0; i < this.f36719.size(); ++i) {
            final List<c33587<?>> list = this.f36719.get(i);
            double n3 = this.f31925 + this.f36724;
            double n4 = this.f31925 + this.f36724;
            final double double2 = this.f36726.getDouble(i);
            double f39554 = 0.0;
            if (i > 0) {
                n += Math.max(double1, this.f36729.getDouble(i));
            }
            double1 = this.f36730.getDouble(i);
            for (int j = 0; j < list.size(); ++j) {
                final c33587<?> c33587 = list.get(j);
                final double double3 = this.f36727.getDouble(j);
                if (j > 0) {
                    n3 += Math.max(f39554, c33587.f39556);
                }
                f39554 = c33587.f39554;
                c33587.f39545 = n3 + c33587.f39552;
                c33587.f39546 = n + c33587.f39549;
                c33587.f39547 = double3 - c33587.f39552 - c33587.f39550;
                c33587.f39548 = double2 - c33587.f39549 - c33587.f39551;
                n4 += double3 + ((j > 0) ? f39554 : 0.0);
                n3 += double3;
            }
            this.f36725.add(n4 - this.f31925 + this.f36722);
            max = Math.max(max, n4);
            n2 += double2 + ((i > 0) ? double1 : 0.0);
            n += double2;
        }
        this.f31927 = max - this.f31925 + this.f36722;
        this.f31928 = n2 - this.f31926 + this.f36723;
        if (this.f36733 && this.f36717 != 0.0 && this.f31928 > this.f36717) {
            this.f36731 = this.f31928;
            this.f31928 = this.f36717;
            if (this.f36732 < -(this.f36731 - this.f31928)) {
                this.f36732 = -(this.f36731 - this.f31928);
            }
            this.m36792(0.0, -this.f36732);
        }
        else {
            this.f36731 = -1.0;
            this.f36732 = 0.0;
        }
    }
    
    @Override
    protected void m31972() {
        double n = this.f31926 + this.f36721;
        double double1 = 0.0;
        for (int i = 0; i < this.f36719.size(); ++i) {
            final List<c33587<?>> list = this.f36719.get(i);
            double n2 = this.f31925 + this.f36724;
            final double double2 = this.f36726.getDouble(i);
            final double n3 = (this.f36728.getInt(i) > 0) ? ((this.f31927 - this.f36725.getDouble(i)) / this.f36728.getInt(i)) : 0.0;
            if (i > 0) {
                n += Math.max(double1, this.f36729.getDouble(i));
            }
            double1 = this.f36730.getDouble(i);
            for (int j = 0; j < list.size(); ++j) {
                final c33587<?> c33587 = list.get(j);
                final double double3 = this.f36727.getDouble(j);
                final double n4 = 0.0;
                if (j > 0) {
                    n2 += Math.max(n4, c33587.f39556);
                }
                final double f39554 = c33587.f39554;
                c33587.f39545 = n2 + c33587.f39552;
                c33587.f39546 = n + c33587.f39549;
                final c33587<?> c33588 = c33587;
                c33588.f39547 += (c33587.f39559 ? n3 : 0.0);
                c33587.m39637();
                n2 += double3 + (c33587.f39559 ? n3 : 0.0);
            }
            n += double2;
        }
    }
    
    public void m36792(final double n, final double n2) {
        final Iterator<c33587<c31923>> iterator = this.m32007().iterator();
        while (iterator.hasNext()) {
            this.m31956(iterator.next().m39632(), n, n2);
        }
        this.m32009(MinecraftClient.getInstance().mouse.getX() / MinecraftClient.getInstance().window.getScaleFactor(), MinecraftClient.getInstance().mouse.getY() / MinecraftClient.getInstance().window.getScaleFactor());
    }
    
    private void m36797() {
        this.f36726.clear();
        this.f36727.clear();
        this.f36728.clear();
        this.f36729.clear();
        this.f36730.clear();
        for (final List<c33587<?>> list : this.f36719) {
            double max = 0.0;
            int n = 0;
            double max2 = 0.0;
            double max3 = 0.0;
            for (int i = 0; i < list.size(); ++i) {
                final c33587<c31923> c33587 = list.get(i);
                max = Math.max(max, c33587.f39549 + c33587.m39632().f31928 + c33587.f39551);
                final double n2 = c33587.f39552 + c33587.m39632().f31927 + c33587.f39550;
                if (this.f36727.size() <= i) {
                    this.f36727.add(n2);
                }
                else {
                    this.f36727.set(i, Math.max(this.f36727.getDouble(i), n2));
                }
                if (c33587.f39559) {
                    ++n;
                }
                max2 = Math.max(max2, c33587.f39553);
                max3 = Math.max(max3, c33587.f39555);
            }
            this.f36726.add(max);
            this.f36728.add(n);
            this.f36729.add(max2);
            this.f36730.add(max3);
        }
    }
    
    @Override
    public void m31985(final c36250 c36250, final double n, final double n2, final double n3) {
        if (this.f36731 != -1.0 || (this.f36718 != 0.0 && this.f36718 != 1.0)) {
            c36250.m36298(this, (this.f31928 - this.f36721) * (1.0 - this.f36718), 0.0, 0.0, 0.0, false);
        }
        super.m31985(c36250, n, n2, n3);
        if (this.f36731 != -1.0 || (this.f36718 != 0.0 && this.f36718 != 1.0)) {
            c36250.m36296();
        }
    }
}
