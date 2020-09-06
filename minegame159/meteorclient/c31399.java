package minegame159.meteorclient;

import net.minecraft.client.*;

public class c31399 extends c31923
{
    private static final String[] f31400;
    public c35815 f31401;
    public c34880 f31402;
    public String f31403;
    private final double f31404;
    private boolean f31405;
    private int f31406;
    private boolean f31407;
    
    public c31399(final String s, final double f31404) {
        super();
        this.f31403 = ((s != null) ? s : "");
        this.f31404 = f31404;
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 3.0 + this.f31404 + 3.0;
        this.f31928 = 3.0 + MeteorClient.smallFont.m33813() + 3.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        if (!this.f31405 && this.f31932) {
            c34739.m34741(true);
        }
        else if (this.f31405 && !this.f31932) {
            c34739.m34741(false);
        }
        this.f31405 = this.f31932;
        if (this.f31405 && n == 1) {
            final String f31403 = this.f31403;
            this.f31403 = "";
            if (!f31403.equals(this.f31403)) {
                this.m31408();
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean m32045(final int n, final int n2) {
        if (this.f31405 && n == 259 && this.f31403.length() > 0) {
            this.f31403 = this.f31403.substring(0, this.f31403.length() - 1);
            this.m31408();
            return true;
        }
        if (n == 86 && n2 == 2 && this.f31405) {
            this.f31403 += MinecraftClient.getInstance().keyboard.getClipboard();
            this.m31408();
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean m32054(final int n, final int n2) {
        if (this.f31405 && n == 259 && this.f31403.length() > 0) {
            this.f31403 = this.f31403.substring(0, this.f31403.length() - 1);
            this.m31408();
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean m32063(final char c, final int n) {
        if (this.f31405) {
            if (this.f31402 == null) {
                this.f31403 += c;
                this.m31408();
            }
            else if (this.f31402.m34881(this, c)) {
                this.f31403 += c;
                this.m31408();
            }
            return true;
        }
        return false;
    }
    
    protected void m31408() {
        if (this.f31401 != null) {
            this.f31401.m35816(this);
        }
    }
    
    public boolean m31410() {
        return this.f31405;
    }
    
    public void m31412(final boolean f31405, final boolean b) {
        if (b) {
            if (!this.f31405 && f31405) {
                c34739.m34741(true);
            }
            else if (this.f31405 && !f31405) {
                c34739.m34741(false);
            }
        }
        this.f31405 = f31405;
    }
    
    public void m31416(final boolean b) {
        this.m31412(b, true);
    }
    
    @Override
    protected void m31983() {
        if (this.f31406 >= 10) {
            this.f31407 = !this.f31407;
            this.f31406 = 0;
        }
        else {
            ++this.f31406;
        }
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36344(this, false, false);
        final double m33815 = MeteorClient.smallFont.m33815(this.f31403);
        double n4 = m33815 - this.f31927 + 3.0 + 3.0;
        if (n4 < 0.0) {
            n4 = 0.0;
        }
        if (this.f31403.length() > 0) {
            if (n4 > 0.0) {
                c36250.m36298(this, 0.0, 3.0, 0.0, 3.0, true);
            }
            c36250.m36370(this.f31403, this.f31925 + 3.0 - n4, this.f31926 + 3.0, c31870.f37895.f37897, false);
            if (n4 > 0.0) {
                c36250.m36296();
            }
        }
        if (this.f31405 && this.f31407) {
            c36250.m36337(this.f31925 + 3.0 + m33815 - n4, this.f31926 + 3.0, 1.0, MeteorClient.smallFont.m33813(), c31870.f37895.f37897);
        }
    }
    
    static {
        f31400 = new String[] { "", "" };
    }
    
    public interface c34880
    {
        boolean m34881(final c31399 p0, final char p1);
    }
}
