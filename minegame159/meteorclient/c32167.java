package minegame159.meteorclient;

public class c32167 extends c36715
{
    public c32767 f32168;
    private final c36453 f32169;
    private final c34710 f32170;
    
    public c32167(final int n, final int n2, final int n3) {
        super();
        this.f32169 = this.m31937(new c36453(n3, 50.0)).m39632();
        this.f32170 = this.m31937(new c34710(n, n2, n3, 75.0)).m39632();
        this.f32169.f36454 = (c36453 -> {
            if (c36453.f36455 != Math.round(this.f32170.f34712)) {
                this.f32170.f34712 = c36453.f36455;
                if (this.f32168 != null) {
                    this.f32168.m32768(this);
                }
            }
            return;
        });
        this.f32170.f34711 = (c36454 -> {
            if (Math.round(c36454.f34712) != this.f32169.f36455) {
                this.f32169.m36464((int)Math.round(c36454.f34712));
                if (this.f32168 != null) {
                    this.f32168.m32768(this);
                }
            }
        });
    }
    
    public int m32171() {
        return this.f32169.f36455;
    }
    
    public void m32173(final int n) {
        this.f32169.m36464(n);
        if (Math.round(this.f32170.f34712) != n) {
            this.f32170.f34712 = n;
        }
    }
    
    private /* synthetic */ void m32176(final c34710 c34710) {
        if (Math.round(c34710.f34712) != this.f32169.f36455) {
            this.f32169.m36464((int)Math.round(c34710.f34712));
            if (this.f32168 != null) {
                this.f32168.m32768(this);
            }
        }
    }
    
    private /* synthetic */ void m32179(final c36453 c36453) {
        if (c36453.f36455 != Math.round(this.f32170.f34712)) {
            this.f32170.f34712 = c36453.f36455;
            if (this.f32168 != null) {
                this.f32168.m32768(this);
            }
        }
    }
}
