package minegame159.meteorclient;

public class c40045 extends c32787
{
    private double f40046;
    private double f40047;
    private double f40048;
    private double f40049;
    private c33493 f40050;
    private c37042 f40051;
    private c37042 f40052;
    private c37042 f40053;
    private c37042 f40054;
    
    public c40045() {
        super();
    }
    
    public c40045 m40055(final double f40046, final double f40047, final double f40048, final double f40049, final c33493 f40050, final c37042 f40051, final c37042 f40052, final c37042 f40053, final c37042 f40054) {
        this.f40046 = f40046;
        this.f40047 = f40047;
        this.f40048 = f40048;
        this.f40049 = f40049;
        this.f40050 = f40050;
        this.f40051 = f40051;
        this.f40052 = f40052;
        this.f40053 = f40053;
        this.f40054 = f40054;
        return this;
    }
    
    @Override
    public void m32788(final c36250 c36250) {
        c33493 c36251 = this.f40050;
        if (c36251 == null) {
            c36251 = c36250.f36258;
        }
        c39337.m39374(this.f40046, this.f40047, this.f40048, this.f40049, c36251, this.f40051, this.f40052, this.f40053, this.f40054);
    }
    
    @Override
    public void m32789(final c36250 c36250) {
        c36250.f36262.m32905(this);
    }
}
