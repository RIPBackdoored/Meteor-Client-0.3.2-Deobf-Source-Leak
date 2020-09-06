package minegame159.meteorclient;

import java.util.*;

public class c36154
{
    public double f36155;
    public double f36156;
    public double f36157;
    public double f36158;
    
    public c36154(final double f36155, final double f36156, final double f36157, final double f36158) {
        super();
        this.f36155 = f36155;
        this.f36156 = f36156;
        this.f36157 = f36157;
        this.f36158 = f36158;
    }
    
    public c36154() {
        this(0.0, 0.0, 0.0, 0.0);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final c36154 c36154 = (c36154)o;
        return Double.compare(c36154.f36155, this.f36155) == 0 && Double.compare(c36154.f36156, this.f36156) == 0 && Double.compare(c36154.f36157, this.f36157) == 0 && Double.compare(c36154.f36158, this.f36158) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f36155, this.f36156, this.f36157, this.f36158);
    }
}
