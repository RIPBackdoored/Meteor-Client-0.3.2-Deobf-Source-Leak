package minegame159.meteorclient;

import java.util.*;

public class c39529 extends c31923
{
    public c39529() {
        super();
    }
    
    @Override
    protected void m31978() {
        double max = 0.0;
        double max2 = 0.0;
        for (final c33587<?> c33587 : this.m32007()) {
            c33587.f39545 = this.f31925;
            c33587.f39546 = this.f31926;
            max = Math.max(max, c33587.f39545);
            max2 = Math.max(max2, c33587.f39546);
        }
        this.f31927 = max - this.f31925;
        this.f31928 = max2 - this.f31926;
    }
}
