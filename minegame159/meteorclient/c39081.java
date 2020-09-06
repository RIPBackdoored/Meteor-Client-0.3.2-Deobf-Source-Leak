package minegame159.meteorclient;

public class c39081 extends c31923
{
    public c37042 f39082;
    private String f39083;
    public boolean f39084;
    
    public c39081(final String f39083, final boolean f39084) {
        super();
        this.f39083 = f39083;
        this.f39084 = f39084;
        this.f39082 = c31870.f37895.f37897;
    }
    
    public c39081(final String s) {
        this(s, false);
    }
    
    public String m39085() {
        return this.f39083;
    }
    
    public void m39087(final String f39083) {
        this.f39083 = f39083;
        this.m31935();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = MeteorClient.smallFont.m33815(this.f39083);
        this.f31928 = MeteorClient.smallFont.m33813();
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36370(this.f39083, this.f31925, this.f31926, this.f39082, this.f39084);
    }
}
