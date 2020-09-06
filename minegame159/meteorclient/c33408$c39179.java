package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.util.math.*;

private static class c39179
{
    public class_2338.class_2339 f39180;
    public c37042 f39181;
    public c37042 f39182;
    
    private c39179() {
        super();
        this.f39180 = new class_2338.class_2339();
        this.f39181 = new c37042();
        this.f39182 = new c37042();
    }
    
    public c39179 m39183(final BlockPos blockPos, final c37042 c37042) {
        this.f39180.method_10101((Vec3i)blockPos);
        this.f39182.m37049(c37042);
        this.f39181.m37049(c37042);
        final c37042 f39181 = this.f39181;
        f39181.f37048 -= 175;
        this.f39181.m37052();
        return this;
    }
    
    c39179(final c33408.c33409 c33409) {
        this();
    }
}
