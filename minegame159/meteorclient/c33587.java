package minegame159.meteorclient;

import java.util.*;

public class c33587<T extends c31923>
{
    T f39544;
    double f39545;
    double f39546;
    double f39547;
    double f39548;
    double f39549;
    double f39550;
    double f39551;
    double f39552;
    double f39553;
    double f39554;
    double f39555;
    double f39556;
    AlignmentX f39557;
    AlignmentY f39558;
    boolean f39559;
    boolean f39560;
    boolean f39561;
    
    public c33587() {
        super();
        this.f39557 = AlignmentX.Left;
        this.f39558 = AlignmentY.Top;
    }
    
    public c33587<T> m39562(final double f39553) {
        this.f39553 = f39553;
        return this;
    }
    
    public c33587<T> m39565(final double f39554) {
        this.f39554 = f39554;
        return this;
    }
    
    public c33587<T> m39568(final double f39555) {
        this.f39555 = f39555;
        return this;
    }
    
    public c33587<T> m39571(final double f39556) {
        this.f39556 = f39556;
        return this;
    }
    
    public c33587<T> m39574(final double n) {
        this.f39554 = n;
        this.f39556 = n;
        return this;
    }
    
    public c33587<T> m39577(final double n) {
        this.f39553 = n;
        this.f39555 = n;
        return this;
    }
    
    public c33587<T> m39580(final double n) {
        this.f39556 = n;
        this.f39555 = n;
        this.f39554 = n;
        this.f39553 = n;
        return this;
    }
    
    public c33587<T> m39583() {
        this.f39560 = true;
        return this;
    }
    
    public c33587<T> m39585() {
        this.f39561 = true;
        return this;
    }
    
    public c33587<T> m39587() {
        this.f39559 = true;
        return this;
    }
    
    public c33587<T> m39589() {
        this.f39557 = AlignmentX.Right;
        return this;
    }
    
    public c33587<T> m39591() {
        this.f39557 = AlignmentX.Center;
        return this;
    }
    
    public c33587<T> m39593() {
        this.f39557 = AlignmentX.Left;
        return this;
    }
    
    public c33587<T> m39595() {
        this.f39558 = AlignmentY.Top;
        return this;
    }
    
    public c33587<T> m39597() {
        this.f39558 = AlignmentY.Center;
        return this;
    }
    
    public c33587<T> m39599() {
        this.f39558 = AlignmentY.Bottom;
        return this;
    }
    
    public c33587<T> m39601() {
        this.f39557 = AlignmentX.Center;
        this.f39558 = AlignmentY.Center;
        return this;
    }
    
    public c33587<T> m39603(final double f39549) {
        this.f39549 = f39549;
        return this;
    }
    
    public c33587<T> m39606(final double f39550) {
        this.f39550 = f39550;
        return this;
    }
    
    public c33587<T> m39609(final double f39551) {
        this.f39551 = f39551;
        return this;
    }
    
    public c33587<T> m39612(final double f39552) {
        this.f39552 = f39552;
        return this;
    }
    
    public c33587<T> m39615(final double n) {
        this.f39552 = n;
        this.f39550 = n;
        return this;
    }
    
    public c33587<T> m39618(final double n) {
        this.f39551 = n;
        this.f39549 = n;
        return this;
    }
    
    public c33587<T> m39621(final double n) {
        this.f39552 = n;
        this.f39551 = n;
        this.f39550 = n;
        this.f39549 = n;
        return this;
    }
    
    public double m39624() {
        return this.f39545;
    }
    
    public double m39626() {
        return this.f39546;
    }
    
    public double m39628() {
        return this.f39547;
    }
    
    public double m39630() {
        return this.f39548;
    }
    
    public T m39632() {
        return this.f39544;
    }
    
    public void m39634(final c33587 c33587) {
        this.f39545 = c33587.f39545;
        this.f39546 = c33587.f39546;
        this.f39547 = c33587.f39547;
        this.f39548 = c33587.f39548;
        this.f39549 = c33587.f39549;
        this.f39550 = c33587.f39550;
        this.f39551 = c33587.f39551;
        this.f39552 = c33587.f39552;
        this.f39553 = c33587.f39553;
        this.f39554 = c33587.f39554;
        this.f39555 = c33587.f39555;
        this.f39556 = c33587.f39556;
        this.f39557 = c33587.f39557;
        this.f39558 = c33587.f39558;
        this.f39559 = c33587.f39559;
        final boolean f39561 = c33587.f39561;
        this.f39561 = f39561;
        this.f39560 = f39561;
    }
    
    void m39637() {
        if (this.f39560) {
            this.f39544.f31925 = this.f39545;
            this.f39544.f31927 = this.f39547;
        }
        else {
            switch (c33588.f33589[this.f39557.ordinal()]) {
                case 1: {
                    this.f39544.f31925 = this.f39545;
                    break;
                }
                case 2: {
                    this.f39544.f31925 = this.f39545 + this.f39547 / 2.0 - this.f39544.f31927 / 2.0;
                    break;
                }
                case 3: {
                    this.f39544.f31925 = this.f39545 + this.f39547 - this.f39544.f31927;
                    break;
                }
            }
        }
        if (this.f39561) {
            this.f39544.f31926 = this.f39546;
            this.f39544.f31928 = this.f39548;
        }
        else {
            switch (c33588.f33590[this.f39558.ordinal()]) {
                case 1: {
                    this.f39544.f31926 = this.f39546;
                    break;
                }
                case 2: {
                    this.f39544.f31926 = this.f39546 + this.f39548 / 2.0 - this.f39544.f31928 / 2.0;
                    break;
                }
                case 3: {
                    this.f39544.f31926 = this.f39546 + this.f39548 - this.f39544.f31928;
                    break;
                }
            }
        }
    }
    
    void m39639() {
        this.f39544 = null;
        final double n = 0.0;
        this.f39546 = n;
        this.f39545 = n;
        final double n2 = 0.0;
        this.f39548 = n2;
        this.f39547 = n2;
        final double n3 = 0.0;
        this.f39552 = n3;
        this.f39551 = n3;
        this.f39550 = n3;
        this.f39549 = n3;
        final double n4 = 0.0;
        this.f39556 = n4;
        this.f39555 = n4;
        this.f39554 = n4;
        this.f39553 = n4;
        this.f39557 = AlignmentX.Left;
        this.f39558 = AlignmentY.Top;
        this.f39559 = false;
        final boolean b = false;
        this.f39561 = b;
        this.f39560 = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f39544, ((c33587)o).f39544));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f39544);
    }
    
    static class c33588
    {
        static final /* synthetic */ int[] f33589;
        static final /* synthetic */ int[] f33590;
        
        static {
            f33590 = new int[AlignmentY.values().length];
            try {
                c33588.f33590[AlignmentY.Top.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                c33588.f33590[AlignmentY.Center.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                c33588.f33590[AlignmentY.Bottom.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            f33589 = new int[AlignmentX.values().length];
            try {
                c33588.f33589[AlignmentX.Left.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                c33588.f33589[AlignmentX.Center.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                c33588.f33589[AlignmentX.Right.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
