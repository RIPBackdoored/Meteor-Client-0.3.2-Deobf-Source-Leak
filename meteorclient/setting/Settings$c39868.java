package meteorclient.setting;

import java.util.*;

private class c39868 implements Iterator<Value<?>>
{
    private final Iterator<Value<?>> f39869;
    private final Iterator<Value<?>> f39870;
    final /* synthetic */ Settings f39871;
    
    private c39868(final Settings f39871) {
        this.f39871 = f39871;
        super();
        this.f39869 = this.f39871.values.iterator();
        this.f39870 = ((Settings.m34001(this.f39871) != null) ? Settings.m34001(this.f39871).iterator() : Settings.m34003());
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
