package meteorclient.setting;

import minegame159.meteorclient.*;
import org.apache.commons.lang3.*;
import java.util.function.*;
import java.util.stream.*;
import net.minecraft.nbt.*;
import java.util.*;

public abstract class Value<T> implements c34681<T>
{
    private static final String[] f33456;
    public final String f33457;
    public final String f33458;
    public final String f33459;
    private String f33460;
    protected final T f33461;
    protected T f33462;
    private final Consumer<T> f33463;
    public final Consumer<Value<T>> f33464;
    public c31923 f33465;
    
    public Value(final String f33457, final String f33458, final T f33459, final Consumer<T> f33460, final Consumer<Value<T>> f33461) {
        super();
        this.f33457 = f33457;
        this.f33458 = Arrays.stream(f33457.split("-")).map((Function<? super String, ?>)StringUtils::capitalize).collect((Collector<? super Object, ?, String>)Collectors.joining(" "));
        this.f33459 = f33458;
        this.f33461 = f33459;
        this.m33471(false);
        this.f33463 = f33460;
        this.f33464 = f33461;
    }
    
    public T m33466() {
        return this.f33462;
    }
    
    public boolean m33468(final T f33462) {
        if (!this.m33486(f33462)) {
            return false;
        }
        this.f33462 = f33462;
        this.m33485();
        this.m33480();
        return true;
    }
    
    public void m33471(final boolean b) {
        this.f33462 = this.f33461;
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    public void m33474() {
        this.m33471(true);
    }
    
    public boolean m33476(final String s) {
        final T m33484 = this.m33484(s);
        if (m33484 != null && this.m33486(m33484)) {
            this.f33462 = m33484;
            this.m33485();
            this.m33480();
        }
        return m33484 != null;
    }
    
    public void m33480() {
        if (this.f33463 != null) {
            this.f33463.accept(this.f33462);
        }
    }
    
    public void m33482() {
        if (this.f33464 != null) {
            this.f33464.accept(this);
        }
    }
    
    protected abstract T m33484(final String p0);
    
    public abstract void m33485();
    
    protected abstract boolean m33486(final T p0);
    
    public String m33487() {
        if (this.f33460 == null) {
            this.f33460 = this.m33489();
        }
        return this.f33460;
    }
    
    protected abstract String m33489();
    
    protected CompoundTag m33490() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("name", this.f33457);
        return compoundTag;
    }
    
    @Override
    public String toString() {
        return this.f33462.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f33457, ((Value)o).f33457));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f33457);
    }
    
    static {
        f33456 = new String[] { "-", " ", "name" };
    }
}
