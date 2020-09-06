package minegame159.meteorclient;

public class c32910 extends c31923
{
    public c37042 f32911;
    
    public c32910(final c37042 f32911) {
        super();
        this.f32911 = f32911;
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 4.0 + MeteorClient.smallFont.m33813() + 4.0;
        this.f31928 = 4.0 + MeteorClient.smallFont.m33813() + 4.0;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36337(this.f31925, this.f31926, this.f31927, this.f31928, this.f32911);
    }
}
