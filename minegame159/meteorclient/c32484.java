package minegame159.meteorclient;

public class c32484 extends c32787
{
    protected String f32485;
    protected double f32486;
    protected double f32487;
    private c37042 f32488;
    private boolean f32489;
    
    public c32484() {
        super();
    }
    
    public c32484 m32490(final String f32485, final double f32486, final double f32487, final c37042 f32488, final boolean f32489) {
        this.f32485 = f32485;
        this.f32486 = f32486;
        this.f32487 = f32487;
        this.f32488 = f32488;
        this.f32489 = f32489;
        return this;
    }
    
    @Override
    public void m32788(final c36250 c36250) {
        if (this.f32489) {
            MeteorClient.smallFont.m33804(this.f32485, (float)this.f32486, (float)this.f32487, this.f32488);
        }
        else {
            MeteorClient.smallFont.m33795(this.f32485, (float)this.f32486, (float)this.f32487, this.f32488);
        }
    }
    
    @Override
    public void m32789(final c36250 c36250) {
        c36250.f36266.m32905(this);
    }
}
