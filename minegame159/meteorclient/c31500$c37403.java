package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import meteorclient.setting.*;
import meteorclient.modules.*;

private abstract class c37403 implements Listenable
{
    protected Settings f37404;
    final /* synthetic */ Announcer f37405;
    
    protected c37403(final Announcer f37405, final String s, final String s2, final String s3) {
        this.f37405 = f37405;
        super();
        this.f37404 = f37405.f38675.m34574(s, s2, s3, true, this::m37410);
    }
    
    abstract void m37406();
    
    abstract void m37407();
    
    boolean m37408() {
        return this.f37404.m33970();
    }
    
    private /* synthetic */ void m37410(final Settings settings) {
        if (this.f37405.m35315() && this.m37408()) {
            MeteorClient.eventBus.subscribe((Listenable)this);
            this.m37406();
        }
        else if (this.f37405.m35315() && !this.m37408()) {
            MeteorClient.eventBus.unsubscribe((Listenable)this);
        }
    }
}
