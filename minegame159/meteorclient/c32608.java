package minegame159.meteorclient;

import org.lwjgl.opengl.*;
import java.util.*;

public class c32608
{
    public c32608 f32609;
    private double f32610;
    private double f32611;
    private double f32612;
    private double f32613;
    private boolean f32614;
    private boolean f32615;
    public List<c32608> f32616;
    public List<c32787> f32617;
    public List<c32787> f32618;
    
    public c32608() {
        super();
        this.f32616 = new ArrayList<c32608>();
        this.f32617 = new ArrayList<c32787>();
        this.f32618 = new ArrayList<c32787>();
    }
    
    public c32608 m32619(final c32608 f32609, double f32610, double f32611, double f32612, double f32613, final boolean f32614, final boolean f32615) {
        if (f32609 != null) {
            if (f32610 < f32609.f32610) {
                f32610 = f32609.f32610;
            }
            else if (f32610 + f32612 > f32609.f32610 + f32609.f32612) {
                f32612 -= f32610 + f32612 - (f32609.f32610 + f32609.f32612);
            }
            if (f32611 < f32609.f32611) {
                f32611 = f32609.f32611;
            }
            else if (f32611 + f32613 > f32609.f32611 + f32609.f32613) {
                f32613 -= f32611 + f32613 - (f32609.f32611 + f32609.f32613);
            }
        }
        this.f32609 = f32609;
        this.f32610 = f32610;
        this.f32611 = f32611;
        this.f32612 = f32612;
        this.f32613 = f32613;
        this.f32614 = f32614;
        this.f32615 = f32615;
        return this;
    }
    
    public void m32628(final c36250 c36250) {
        if (this.f32614) {
            final double f37896 = c31870.f37895.f37896;
            GL11.glEnable(3089);
            GL11.glScissor((int)(this.f32610 * f37896), (int)(this.f32611 * f37896), (int)(this.f32612 * f37896), (int)(this.f32613 * f37896));
        }
        if (!this.f32615) {
            c36250.m36272();
        }
        for (final c32787 c36251 : this.f32617) {
            c36251.m32788(c36250);
            c36251.m32789(c36250);
        }
        if (!this.f32615) {
            c36250.m36276();
        }
        this.f32617.clear();
        for (final c32787 c36252 : this.f32618) {
            c36252.m32788(c36250);
            c36252.m32789(c36250);
        }
        this.f32618.clear();
        if (this.f32614) {
            GL11.glDisable(3089);
        }
        for (final c32608 c36253 : this.f32616) {
            c36253.m32628(c36250);
            c36250.f36267.m32905(c36253);
        }
        this.f32616.clear();
    }
}
