package minegame159.meteorclient;

import java.util.*;

public class c33493
{
    public double f33494;
    public double f33495;
    public double f33496;
    public double f33497;
    private c37042 f33498;
    private c37042 f33499;
    private c37042 f33500;
    
    public c33493(final double n, final double n2, final int n3, final int n4, final int n5, final int n6, final c37042 f33498, final c37042 f33499, final c37042 f33500) {
        super();
        this.f33494 = n3 / n;
        this.f33495 = n4 / n2;
        this.f33496 = n5 / n;
        this.f33497 = n6 / n2;
        this.f33498 = f33498;
        this.f33499 = f33499;
        this.f33500 = f33500;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final c33493 c33493 = (c33493)o;
        return this.f33494 == c33493.f33494 && this.f33495 == c33493.f33495 && this.f33496 == c33493.f33496 && this.f33497 == c33493.f33497;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f33494, this.f33495, this.f33496, this.f33497);
    }
    
    public c37042 m33501(final boolean b, final boolean b2) {
        if (b2) {
            return this.f33500;
        }
        if (b) {
            return this.f33499;
        }
        return this.f33498;
    }
}
