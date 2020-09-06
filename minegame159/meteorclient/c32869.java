package minegame159.meteorclient;

import java.lang.reflect.*;

public class c32869<T extends Enum<?>> extends c31923
{
    private static final String[] f32870;
    public c33372<T> f32871;
    public T f32872;
    private String f32873;
    private T[] f32874;
    private double f32875;
    private double f32876;
    private int f32877;
    private boolean f32878;
    
    public c32869(final T f32872) {
        super();
        this.f32872 = f32872;
        this.f32873 = f32872.toString();
        this.f32876 = MeteorClient.smallFont.m33815(f32872.toString());
        try {
            final Method method = f32872.getClass().getMethod("values", (Class<?>[])new Class[0]);
            final boolean accessible = method.isAccessible();
            method.setAccessible(true);
            this.f32874 = (T[])method.invoke(null, new Object[0]);
            method.setAccessible(accessible);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            final Throwable t;
            t.printStackTrace();
        }
        final T[] f32873 = this.f32874;
        for (int length = f32873.length, i = 0; i < length; ++i) {
            this.f32875 = Math.max(this.f32875, MeteorClient.smallFont.m33815(f32873[i].toString()));
        }
        this.m32879();
    }
    
    private void m32879() {
        for (int i = 0; i < this.f32874.length; ++i) {
            if (this.f32874[i] == this.f32872) {
                this.f32877 = i;
            }
        }
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 3.0 + this.f32875 + 3.0;
        this.f31928 = 3.0 + MeteorClient.smallFont.m33813() + 3.0;
    }
    
    private void m32884() {
        if (this.f32877 < 0) {
            this.f32877 = this.f32874.length - 1;
        }
        else if (this.f32877 >= this.f32874.length) {
            this.f32877 = 0;
        }
        this.f32872 = this.f32874[this.f32877];
        this.f32873 = this.f32872.toString();
        this.f32876 = MeteorClient.smallFont.m33815(this.f32872.toString());
        if (this.f32871 != null) {
            this.f32871.m33373(this);
        }
        this.m31935();
    }
    
    public void m32886(final T f32872) {
        this.f32872 = f32872;
        this.f32873 = f32872.toString();
        this.f32876 = MeteorClient.smallFont.m33815(f32872.toString());
        this.m32879();
        this.m31935();
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f32878 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f32878) {
            this.f32878 = false;
            if (n == 0) {
                ++this.f32877;
                this.m32884();
                this.m32893();
            }
            else if (n == 1) {
                --this.f32877;
                this.m32884();
                this.m32893();
            }
            return true;
        }
        return false;
    }
    
    private void m32893() {
        if (this.f32871 != null) {
            this.f32871.m33373(this);
        }
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36344(this, this.f31932, this.f32878);
        c36250.m36370(this.f32873, this.f31925 + 3.0 + this.f32875 / 2.0 - this.f32876 / 2.0, this.f31926 + 3.5, c31870.f37895.f37897, false);
    }
    
    static {
        f32870 = new String[] { "values" };
    }
}
