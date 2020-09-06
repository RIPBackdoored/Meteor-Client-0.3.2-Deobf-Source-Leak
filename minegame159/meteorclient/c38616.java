package minegame159.meteorclient;

public class c38616 extends c31923
{
    private static final String[] f38617;
    public c34753 f38618;
    private String f38619;
    private double f38620;
    private c33493 f38621;
    private boolean f38622;
    
    public c38616(final String s, final c33493 f38621) {
        super();
        if (s != null) {
            this.m38623(s);
        }
        else {
            this.f38621 = f38621;
        }
    }
    
    public c38616(final String s) {
        this(s, null);
    }
    
    public c38616(final c33493 c33493) {
        this(null, c33493);
    }
    
    public void m38623(final String s) {
        this.f38619 = ((s != null) ? s : "");
        this.f38620 = MeteorClient.smallFont.m33815(this.f38619);
        this.m31935();
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 3.0 + ((this.f38619 != null) ? MeteorClient.smallFont.m33815(this.f38619) : MeteorClient.smallFont.m33813()) + 3.0;
        this.f31928 = 3.0 + MeteorClient.smallFont.m33813() + 3.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f38622 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f38622) {
            this.f38622 = false;
            if (this.f38618 != null) {
                this.f38618.m34754(this);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36344(this, this.f31932, this.f38622);
        if (this.f38619 != null) {
            c36250.m36370(this.f38619, this.f31925 + this.f31927 / 2.0 - this.f38620 / 2.0, this.f31926 + 3.5, c31870.f37895.f37897, false);
        }
        else {
            c36250.m36321(this.f31925 + 3.0, this.f31926 + 3.0, this.f31927 - 6.0, this.f31928 - 6.0, this.f38621, this.f38621.m33501(this.f31932, this.f38622));
        }
    }
    
    static {
        f38617 = new String[] { "" };
    }
}
