package minegame159.meteorclient;

import java.util.*;
import meteorclient.setting.*;

private class c39523 implements Iterator<Value<?>>
{
    private int f39524;
    private Iterator<Value<?>> f39525;
    final /* synthetic */ c34561 f39526;
    
    public c39523(final c34561 f39526) {
        this.f39526 = f39526;
        super();
        this.f39524 = 0;
        if (c34561.m34601(f39526).size() > 0) {
            this.f39525 = c34561.m34601(f39526).get(this.f39524++).iterator();
        }
    }
    
    @Override
    public boolean hasNext() {
        return this.f39524 < c34561.m34601(this.f39526).size() || (this.f39525 != null && this.f39525.hasNext());
    }
    
    public Value<?> m39527() {
        if (this.f39525.hasNext()) {
            return this.f39525.next();
        }
        do {
            this.f39525 = c34561.m34601(this.f39526).get(this.f39524++).iterator();
        } while (!this.f39525.hasNext());
        return this.f39525.next();
    }
    
    @Override
    public /* bridge */ Object next() {
        return this.m39527();
    }
}
