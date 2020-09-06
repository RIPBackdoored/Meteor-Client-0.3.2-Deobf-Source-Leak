package minegame159.meteorclient;

import meteorclient.modules.*;

private class c38568
{
    public float f38569;
    public float f38570;
    public float f38571;
    public float f38572;
    public float f38573;
    public float f38574;
    final /* synthetic */ Breadcrumbs f38575;
    
    private c38568(final Breadcrumbs f38575) {
        this.f38575 = f38575;
        super();
    }
    
    public void m38576() {
        this.f38569 = (float)Breadcrumbs.m33135(this.f38575).player.x;
        this.f38570 = (float)Breadcrumbs.m33137(this.f38575).player.y;
        this.f38571 = (float)Breadcrumbs.m33139(this.f38575).player.z;
    }
    
    public void m38578() {
        this.f38572 = (float)Breadcrumbs.m33141(this.f38575).player.x;
        this.f38573 = (float)Breadcrumbs.m33143(this.f38575).player.y;
        this.f38574 = (float)Breadcrumbs.m33145(this.f38575).player.z;
    }
    
    public void m38580() {
        c39337.m39404(this.f38569, this.f38570, this.f38571, this.f38572, this.f38573, this.f38574, Breadcrumbs.m33147(this.f38575).m33466());
    }
    
    c38568(final Breadcrumbs breadcrumbs, final c33098.c33099 c33099) {
        this(breadcrumbs);
    }
}
