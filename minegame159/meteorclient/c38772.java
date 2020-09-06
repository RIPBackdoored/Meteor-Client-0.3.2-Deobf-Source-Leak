package minegame159.meteorclient;

import java.util.function.*;

public class c38772 extends c36715
{
    public c37042 f38773;
    public Consumer<c38772> f38774;
    private final c32910 f38775;
    private final c36453 f38776;
    private final c36453 f38777;
    private final c36453 f38778;
    private final c36453 f38779;
    
    public c38772(final c37042 f38773) {
        super();
        this.f38773 = f38773;
        this.f38775 = this.m31937(new c32910(f38773)).m39632();
        this.f38776 = this.m31937(new c36453(f38773.f37045, 20.0)).m39632();
        this.f38776.f36454 = (p0 -> this.m38780());
        this.f38777 = this.m31937(new c36453(f38773.f37046, 20.0)).m39632();
        this.f38777.f36454 = (p0 -> this.m38780());
        this.f38778 = this.m31937(new c36453(f38773.f37047, 20.0)).m39632();
        this.f38778.f36454 = (p0 -> this.m38780());
        this.f38779 = this.m31937(new c36453(f38773.f37048, 20.0)).m39632();
        this.f38779.f36454 = (p0 -> this.m38780());
    }
    
    private void m38780() {
        this.f38773.f37045 = this.f38776.f36455;
        this.f38773.f37046 = this.f38777.f36455;
        this.f38773.f37047 = this.f38778.f36455;
        this.f38773.f37048 = this.f38779.f36455;
        this.f38773.m37052();
        if (this.f38776.f36455 != 0 || this.f38773.f37045 != 0) {
            this.f38776.m36464(this.f38773.f37045);
        }
        if (this.f38777.f36455 != 0 || this.f38773.f37046 != 0) {
            this.f38777.m36464(this.f38773.f37046);
        }
        if (this.f38778.f36455 != 0 || this.f38773.f37047 != 0) {
            this.f38778.m36464(this.f38773.f37047);
        }
        if (this.f38779.f36455 != 0 || this.f38773.f37048 != 0) {
            this.f38779.m36464(this.f38773.f37048);
        }
        this.f38775.f32911.m37049(this.f38773);
        if (this.f38774 != null) {
            this.f38774.accept(this);
        }
    }
    
    public void m38782(final c37042 c37042) {
        c37042.m37052();
        this.f38773.m37049(c37042);
        this.m38785();
        this.f38775.f32911.m37049(c37042);
    }
    
    public void m38785() {
        this.f38776.m36464(this.f38773.f37045);
        this.f38777.m36464(this.f38773.f37046);
        this.f38778.m36464(this.f38773.f37047);
        this.f38779.m36464(this.f38773.f37048);
    }
    
    private /* bridge */ void m38787(final c36453 c36453) {
        this.m38780();
    }
    
    private /* bridge */ void m38790(final c36453 c36453) {
        this.m38780();
    }
    
    private /* bridge */ void m38793(final c36453 c36453) {
        this.m38780();
    }
    
    private /* bridge */ void m38796(final c36453 c36453) {
        this.m38780();
    }
}
