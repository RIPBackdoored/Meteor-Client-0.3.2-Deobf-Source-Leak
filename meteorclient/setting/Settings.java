package meteorclient.setting;

import java.util.*;
import minegame159.meteorclient.*;

public class Settings implements Iterable<Value<?>>
{
    private static final String[] f33960;
    private static final c37313 f33961;
    public final String f33962;
    private final c34561 f33963;
    private final Value<Boolean> f33964;
    final List<Value<?>> values;
    private final c38769 f33966;
    private Settings f33967;
    
    Settings(final c34561 f33963, final String f33964, final String s, final String s2, final boolean b, final c38769 f33965) {
        super();
        this.values = new ArrayList<Value<?>>(1);
        this.f33963 = f33963;
        this.f33962 = f33964;
        if (s != null) {
            this.f33964 = this.addValue((Value<Boolean>)new c34427.c34657().m34664(s).m34667(s2).m34670(b).m34673(p2 -> {
                f33963.m34598();
                if (f33965 != null) {
                    f33965.m38770(this);
                }
                return;
            }).m34679());
        }
        else {
            this.f33964 = null;
        }
        this.f33966 = f33965;
    }
    
    public boolean m33968() {
        return this.f33962 != null;
    }
    
    public boolean m33970() {
        return this.f33964 == null || this.f33964.m33466();
    }
    
    public void m33972(final boolean b) {
        if (this.f33964 != null) {
            this.f33964.m33468(b);
        }
    }
    
    public <T> Value<T> addValue(final Value<T> value) {
        this.values.add(value);
        return value;
    }
    
    public boolean m33978() {
        return this.f33967 != null;
    }
    
    public Settings m33980() {
        if (this.f33967 == null) {
            this.f33967 = new Settings(this.f33963, null, null, null, false, null);
        }
        return this.f33967;
    }
    
    public void m33982(final c36715 c36715) {
        if (this.m33968()) {
            c36715.m31937(new c38757(this.f33962)).m39587().m39583();
            c36715.m36739();
        }
        if (this.f33964 != null) {
            this.m33986(c36715, this.f33964);
        }
        if (this.m33970()) {
            for (final Value<Boolean> value : this.values) {
                if (value != this.f33964) {
                    this.m33986(c36715, value);
                }
            }
        }
        else if (this.m33978()) {
            this.m33980().m33982(c36715);
        }
    }
    
    private void m33986(final c36715 c36715, final Value<?> value) {
        if (value.f33465 instanceof c31399) {
            ((c31399)value.f33465).m31412(false, false);
        }
        c36715.m31937(new c39081(value.f33458)).m39632().f31934 = value.f33459;
        c36715.m31937(value.f33465).m39632().f31934 = value.f33459;
        final c38616 c36716 = c36715.m31937(new c38616(c36250.f36259)).m39587().m39589().m39632();
        c36716.f31934 = "Reset";
        c36716.f38618 = (p1 -> value.m33474());
        c36715.m36739();
    }
    
    @Override
    public Iterator<Value<?>> iterator() {
        return new c39868(null);
    }
    
    private static /* synthetic */ void m33993(final Value value, final c38616 c38616) {
        value.m33474();
    }
    
    private /* synthetic */ void m33996(final c34561 c34561, final c38769 c34562, final Boolean b) {
        c34561.m34598();
        if (c34562 != null) {
            c34562.m38770(this);
        }
    }
    
    static /* synthetic */ Settings m34001(final Settings settings) {
        return settings.f33967;
    }
    
    static /* synthetic */ c37313 m34003() {
        return Settings.f33961;
    }
    
    static {
        f33960 = new String[] { "Reset" };
        f33961 = new c37313(null);
    }
    
    private static class c37313 implements Iterator<Value<?>>
    {
        private c37313() {
            super();
        }
        
        @Override
        public boolean hasNext() {
            return false;
        }
        
        public Value<?> m37314() {
            return null;
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.m37314();
        }
        
        c37313(final c38771 c38771) {
            this();
        }
    }
    
    private class c39868 implements Iterator<Value<?>>
    {
        private final Iterator<Value<?>> f39869;
        private final Iterator<Value<?>> f39870;
        final /* synthetic */ Settings f39871;
        
        private c39868(final Settings f39871) {
            this.f39871 = f39871;
            super();
            this.f39869 = this.f39871.values.iterator();
            this.f39870 = ((this.f39871.f33967 != null) ? this.f39871.f33967.iterator() : Settings.f33961);
        }
        
        @Override
        public boolean hasNext() {
            return this.f39869.hasNext() || this.f39870.hasNext();
        }
        
        public Value<?> m39872() {
            if (this.f39869.hasNext()) {
                return this.f39869.next();
            }
            return this.f39870.next();
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.m39872();
        }
        
        c39868(final Settings settings, final c38771 c38771) {
            this(settings);
        }
    }
    
    static class c38771
    {
    }
}
