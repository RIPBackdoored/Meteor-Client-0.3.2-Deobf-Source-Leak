package minegame159.meteorclient;

import baritone.api.pathing.goals.*;
import net.minecraft.util.math.*;
import baritone.api.utils.*;
import baritone.api.*;

public class c37413 implements Goal
{
    private static final String[] f37414;
    private static final double f37415;
    private float f37416;
    private int f37417;
    private int f37418;
    
    public c37413(final Vec3d vec3d, final float f37416) {
        super();
        this.f37416 = f37416;
        this.m37419(vec3d);
    }
    
    public void m37419(final Vec3d vec3d) {
        final float n = (float)Math.toRadians(this.f37416);
        this.f37417 = (int)Math.floor(vec3d.x - MathHelper.sin(n) * 100.0);
        this.f37418 = (int)Math.floor(vec3d.z + MathHelper.cos(n) * 100.0);
    }
    
    public boolean isInGoal(final int n, final int n2, final int n3) {
        return n == this.f37417 && n3 == this.f37418;
    }
    
    public double heuristic(final int n, final int n2, final int n3) {
        return m37423(n - this.f37417, n3 - this.f37418);
    }
    
    @Override
    public String toString() {
        return String.format("GoalXZ{x=%s,z=%s}", SettingsUtil.maybeCensor(this.f37417), SettingsUtil.maybeCensor(this.f37418));
    }
    
    public static double m37423(final double n, final double n2) {
        final double abs = Math.abs(n);
        final double abs2 = Math.abs(n2);
        double n3;
        double n4;
        if (abs < abs2) {
            n3 = abs2 - abs;
            n4 = abs;
        }
        else {
            n3 = abs - abs2;
            n4 = abs2;
        }
        return (n4 * c37413.f37415 + n3) * (double)BaritoneAPI.getSettings().costHeuristic.value;
    }
    
    public int m37432() {
        return this.f37417;
    }
    
    public int m37434() {
        return this.f37418;
    }
    
    static {
        f37414 = new String[] { "GoalXZ{x=%s,z=%s}" };
        f37415 = Math.sqrt(2.0);
    }
}
