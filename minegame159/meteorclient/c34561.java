package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.*;

public class c34561 implements Iterable<Value<?>>
{
    private static final String[] f34562;
    private Settings f34563;
    private final List<Settings> f34564;
    private c36715 f34565;
    
    public c34561() {
        super();
        this.f34564 = new ArrayList<Settings>(1);
    }
    
    public Value<?> m34566(final String s) {
        for (final Value<?> value : this) {
            if (s.equalsIgnoreCase(value.f33457)) {
                return value;
            }
        }
        return null;
    }
    
    public int m34570() {
        return this.f34564.size();
    }
    
    public Settings m34572() {
        if (this.f34563 == null) {
            this.f34563 = new Settings(this, "General", null, null, false, null);
            this.f34564.add(this.f34563);
        }
        return this.f34563;
    }
    
    public Settings m34574(final String s, final String s2, final String s3, final boolean b, final c38769 c38769) {
        final Settings settings = new Settings(this, s, s2, s3, b, c38769);
        this.f34564.add(settings);
        return settings;
    }
    
    public Settings m34582(final String s, final String s2, final String s3, final boolean b) {
        return this.m34574(s, s2, s3, b, null);
    }
    
    public Settings m34588(final String s) {
        return this.m34574(s, null, null, false, null);
    }
    
    public c36715 m34591(final boolean b) {
        this.f34565 = new c36715();
        for (final Value<?> value : this) {
            if (b) {
                value.m33482();
            }
            value.m33485();
        }
        final Iterator<Settings> iterator2 = this.f34564.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().m33982(this.f34565);
        }
        return this.f34565;
    }
    
    public c36715 m34596() {
        return this.m34591(true);
    }
    
    void m34598() {
        if (this.f34565 != null) {
            this.f34565.m31945();
            final Iterator<Settings> iterator = this.f34564.iterator();
            while (iterator.hasNext()) {
                iterator.next().m33982(this.f34565);
            }
        }
    }
    
    @Override
    public Iterator<Value<?>> iterator() {
        return new c39523();
    }
    
    static /* synthetic */ List m34601(final c34561 c34561) {
        return c34561.f34564;
    }
    
    static {
        f34562 = new String[] { "General" };
    }
    
    private class c39523 implements Iterator<Value<?>>
    {
        private int f39524;
        private Iterator<Value<?>> f39525;
        final /* synthetic */ c34561 f39526;
        
        public c39523(final c34561 f39526) {
            this.f39526 = f39526;
            super();
            this.f39524 = 0;
            if (f39526.f34564.size() > 0) {
                this.f39525 = f39526.f34564.get(this.f39524++).iterator();
            }
        }
        
        @Override
        public boolean hasNext() {
            return this.f39524 < this.f39526.f34564.size() || (this.f39525 != null && this.f39525.hasNext());
        }
        
        public Value<?> m39527() {
            if (this.f39525.hasNext()) {
                return this.f39525.next();
            }
            do {
                this.f39525 = this.f39526.f34564.get(this.f39524++).iterator();
            } while (!this.f39525.hasNext());
            return this.f39525.next();
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.m39527();
        }
    }
}
