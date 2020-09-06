package meteorclient.font;

import minegame159.meteorclient.*;

public class c35894
{
    public int f35895;
    public int f35896;
    public int f35897;
    public int f35898;
    final /* synthetic */ CFont f35899;
    
    public c35894(final CFont f35899) {
        this.f35899 = f35899;
        super();
    }
    
    public void m35900(final c35197 f39339, final double n, final double n2, final c37042 c37042) {
        final double n3 = this.f35895 / 512.0;
        final double n4 = this.f35896 / 512.0;
        final double n5 = this.f35897 / 512.0;
        final double n6 = this.f35898 / 512.0;
        final c35197 f39340 = c39337.f39339;
        c39337.f39339 = f39339;
        c39337.m39361(n / 2.0, n2 / 2.0, this.f35897 / 2.0 * this.f35899.f33761, this.f35898 / 2.0 * this.f35899.f33761, n3, n4, n5, n6, c37042, c37042, c37042, c37042);
        c39337.f39339 = f39340;
    }
}
