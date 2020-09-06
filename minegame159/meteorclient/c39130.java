package minegame159.meteorclient;

public class c39130 extends c32480
{
    protected c35714 f39131;
    
    public c39130(final String s, final boolean b) {
        super(s);
        this.m39134(b);
    }
    
    @Override
    public <T extends c31923> c33587<T> add(final T t) {
        return this.f39131.m31937(t);
    }
    
    public void m39132() {
        this.f39131.m36739();
    }
    
    @Override
    public void clear() {
        this.f39131.m31945();
    }
    
    private void m39134(final boolean b) {
        this.f39131 = super.add(new c35714(this.f37288, b)).m39601().m39632();
    }
}
