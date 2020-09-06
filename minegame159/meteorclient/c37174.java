package minegame159.meteorclient;

import meteorclient.setting.*;
import meteorclient.util.*;

public class c37174 extends c39130
{
    private static final String[] f39651;
    private static final c37042[] f39652;
    private static final c37042 f39653;
    private static final c37042 f39654;
    public c38089 f39655;
    private final Value<c37042> f39656;
    private final c32910 f39657;
    private final c37316 f39658;
    private final c37175 f39659;
    private final c32167 f39660;
    private final c32167 f39661;
    private final c32167 f39662;
    private final c32167 f39663;
    
    public c37174(final Value<c37042> f39656) {
        super("Select Color", true);
        this.f39656 = f39656;
        this.f39657 = this.add(new c32910(f39656.m33466())).m39587().m39583().m39632();
        this.m39132();
        this.f39658 = this.add(new c37316(null)).m39587().m39583().m39632();
        this.m39132();
        this.f39659 = this.add(new c37175(null)).m39587().m39583().m39632();
        this.m39132();
        final c36715 c36715 = this.add(new c36715()).m39587().m39583().m39632();
        this.m39132();
        c36715.m31937(new c39081("R:"));
        this.f39660 = c36715.m31937(new c32167(0, 255, f39656.m33466().f37045)).m39632();
        this.f39660.f32168 = (p0 -> this.m39666());
        c36715.m36739();
        c36715.m31937(new c39081("G:"));
        this.f39661 = c36715.m31937(new c32167(0, 255, f39656.m33466().f37046)).m39632();
        this.f39661.f32168 = (p0 -> this.m39666());
        c36715.m36739();
        c36715.m31937(new c39081("B:"));
        this.f39662 = c36715.m31937(new c32167(0, 255, f39656.m33466().f37047)).m39632();
        this.f39662.f32168 = (p0 -> this.m39666());
        c36715.m36739();
        c36715.m31937(new c39081("A:"));
        this.f39663 = c36715.m31937(new c32167(0, 255, f39656.m33466().f37048)).m39632();
        this.f39663.f32168 = (p0 -> this.m39666());
        final c36715 c36716 = this.add(new c36715()).m39587().m39583().m39632();
        c36716.m31937(new c38616("Back")).m39587().m39583().m39632().f38618 = (p0 -> this.onClose());
        c36716.m31937(new c38616(c36250.f36259)).m39632().f38618 = (p1 -> {
            f39656.m33474();
            this.f39660.m32173(f39656.m33466().f37045);
            this.f39661.m32173(f39656.m33466().f37046);
            this.f39662.m32173(f39656.m33466().f37047);
            this.f39663.m32173(f39656.m33466().f37048);
            this.f39657.f32911.m37049(f39656.m33466());
            this.f39659.m37184((boolean)(1 != 0));
            this.f39658.m37327(f39656.m33466(), (boolean)(1 != 0));
            this.m39664();
            return;
        });
        this.f39659.m37184(false);
        this.f39658.m37327(f39656.m33466(), false);
    }
    
    private void m39664() {
        if (this.f39655 != null) {
            this.f39655.m38090(this);
        }
    }
    
    private void m39666() {
        final c37042 c37042 = this.f39656.m33466();
        c37042.f37045 = this.f39660.m32171();
        c37042.f37046 = this.f39661.m32171();
        c37042.f37047 = this.f39662.m32171();
        c37042.f37048 = this.f39663.m32171();
        c37042.m37052();
        if (c37042.f37045 != this.f39660.m32171()) {
            this.f39660.m32173(c37042.f37045);
        }
        if (c37042.f37046 != this.f39661.m32171()) {
            this.f39661.m32173(c37042.f37046);
        }
        if (c37042.f37047 != this.f39662.m32171()) {
            this.f39662.m32173(c37042.f37047);
        }
        if (c37042.f37048 != this.f39663.m32171()) {
            this.f39663.m32173(c37042.f37048);
        }
        this.f39657.f32911.m37049(c37042);
        this.f39659.m37184(true);
        this.f39658.m37327(this.f39656.m33466(), true);
        this.f39656.m33480();
        this.m39664();
    }
    
    private void m39669() {
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        boolean b = false;
        if (this.f39658.f37317 <= 0.0) {
            n = this.f39658.f37318;
            n2 = this.f39658.f37318;
            n3 = this.f39658.f37318;
            b = true;
        }
        if (!b) {
            double m37225 = this.f39659.f37176;
            if (m37225 >= 360.0) {
                m37225 = 0.0;
            }
            final double n4 = m37225 / 60.0;
            final int n5 = (int)n4;
            final double n6 = n4 - n5;
            final double n7 = this.f39658.f37318 * (1.0 - this.f39658.f37317);
            final double n8 = this.f39658.f37318 * (1.0 - this.f39658.f37317 * n6);
            final double n9 = this.f39658.f37318 * (1.0 - this.f39658.f37317 * (1.0 - n6));
            switch (n5) {
                case 0: {
                    n = this.f39658.f37318;
                    n2 = n9;
                    n3 = n7;
                    break;
                }
                case 1: {
                    n = n8;
                    n2 = this.f39658.f37318;
                    n3 = n7;
                    break;
                }
                case 2: {
                    n = n7;
                    n2 = this.f39658.f37318;
                    n3 = n9;
                    break;
                }
                case 3: {
                    n = n7;
                    n2 = n8;
                    n3 = this.f39658.f37318;
                    break;
                }
                case 4: {
                    n = n9;
                    n2 = n7;
                    n3 = this.f39658.f37318;
                    break;
                }
                default: {
                    n = this.f39658.f37318;
                    n2 = n7;
                    n3 = n8;
                    break;
                }
            }
        }
        final c37042 c37042 = this.f39656.m33466();
        c37042.f37045 = (int)(n * 255.0);
        c37042.f37046 = (int)(n2 * 255.0);
        c37042.f37047 = (int)(n3 * 255.0);
        c37042.m37052();
        this.f39660.m32173(c37042.f37045);
        this.f39661.m32173(c37042.f37046);
        this.f39662.m32173(c37042.f37047);
        this.f39657.f32911.m37049(c37042);
        this.f39656.m33480();
        this.m39664();
    }
    
    private /* synthetic */ void m39682(final Value value, final c38616 c38616) {
        value.m33474();
        this.f39660.m32173(value.m33466().f37045);
        this.f39661.m32173(value.m33466().f37046);
        this.f39662.m32173(value.m33466().f37047);
        this.f39663.m32173(value.m33466().f37048);
        this.f39657.f32911.m37049(value.m33466());
        this.f39659.m37184(true);
        this.f39658.m37327(value.m33466(), true);
        this.m39664();
    }
    
    private /* synthetic */ void m39686(final c38616 c38616) {
        this.onClose();
    }
    
    private /* bridge */ void m39689(final c32167 c32167) {
        this.m39666();
    }
    
    private /* bridge */ void m39692(final c32167 c32167) {
        this.m39666();
    }
    
    private /* bridge */ void m39695(final c32167 c32167) {
        this.m39666();
    }
    
    private /* bridge */ void m39698(final c32167 c32167) {
        this.m39666();
    }
    
    static /* bridge */ void m39701(final c37174 c37174) {
        c37174.m39669();
    }
    
    static /* synthetic */ c37175 m39703(final c37174 c37174) {
        return c37174.f39659;
    }
    
    static /* synthetic */ c37042 m39705() {
        return c37174.f39653;
    }
    
    static /* synthetic */ c37042 m39706() {
        return c37174.f39654;
    }
    
    static /* synthetic */ Value m39707(final c37174 c37174) {
        return c37174.f39656;
    }
    
    static /* synthetic */ c37042[] m39709() {
        return c37174.f39652;
    }
    
    static {
        f39651 = new String[] { "Select Color", "R:", "G:", "B:", "A:", "Back" };
        f39652 = new c37042[] { new c37042(255, 0, 0), new c37042(255, 255, 0), new c37042(0, 255, 0), new c37042(0, 255, 255), new c37042(0, 0, 255), new c37042(255, 0, 255), new c37042(255, 0, 0) };
        f39653 = new c37042(255, 255, 255);
        f39654 = new c37042(0, 0, 0);
    }
    
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
            final c37042 c37042 = this.f37182.f39656.m33466();
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
                c37174.this.m39669();
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
                c37174.this.m39669();
            }
            this.f37180 = f37180;
        }
        
        void m37213() {
            this.f37176 = this.f37177 / (this.f31927 - 4.0) * 360.0;
        }
        
        @Override
        protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
            final double n4 = this.f31927 / (c37174.f39652.length - 1);
            double f31925 = this.f31925;
            for (int i = 0; i < c37174.f39652.length - 1; ++i) {
                c36250.m36329(f31925, this.f31926, n4, this.f31928, c37174.f39652[i], c37174.f39652[i + 1]);
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
            c37174.this.m39669();
        }
        
        @Override
        protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
            this.f37325.f39659.m37195();
            c36250.m36310(this.f31925, this.f31926, this.f31927, this.f31928, null, c37174.f39653, this.f37325.f39659.f37178, c37174.f39654, c37174.f39654);
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
    
    public interface c38089
    {
        void m38090(final c37174 p0);
    }
    
    static class c39096
    {
    }
}
