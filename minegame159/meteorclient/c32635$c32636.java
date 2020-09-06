package minegame159.meteorclient;

import java.util.*;
import meteorclient.modules.*;
import net.minecraft.entity.player.*;
import meteorclient.util.*;
import net.minecraft.client.render.*;

private class c32636
{
    private static final String[] f32637;
    public final double f32638;
    public final double f32639;
    public final double f32640;
    public final double f32641;
    public final double f32642;
    public final UUID f32643;
    public final String f32644;
    public final int f32645;
    public final int f32646;
    public final String f32647;
    final /* synthetic */ Logoutspots f32648;
    
    public c32636(final Logoutspots f32648, final PlayerEntity playerEntity) {
        this.f32648 = f32648;
        super();
        this.f32638 = playerEntity.x;
        this.f32639 = playerEntity.y;
        this.f32640 = playerEntity.z;
        this.f32641 = playerEntity.getBoundingBox().getXLength();
        this.f32642 = playerEntity.getBoundingBox().getZLength();
        this.f32643 = playerEntity.getUuid();
        this.f32644 = playerEntity.getGameProfile().getName();
        this.f32645 = Math.round(playerEntity.getHealth() + playerEntity.getAbsorptionAmount());
        this.f32646 = Math.round(playerEntity.getMaximumHealth() + playerEntity.getAbsorptionAmount());
        this.f32647 = " " + this.f32645;
    }
    
    public void m32649(final c36846 c36846) {
        final Camera camera = Logoutspots.m33936(this.f32648).gameRenderer.getCamera();
        double n = 0.025;
        final double m35606 = EnchantUtil.m35606(this.f32638, this.f32639, this.f32640);
        if (m35606 > 10.0) {
            n *= m35606 / 10.0 * Logoutspots.m33938(this.f32648).m33466();
        }
        if (m35606 > Logoutspots.m33940(this.f32648).options.viewDistance * 16) {
            return;
        }
        final double n2 = this.f32645 / (double)this.f32646;
        c39337.m39476(this.f32638, this.f32639, this.f32640, this.f32641, this.f32642, Logoutspots.m33942(this.f32648), Logoutspots.m33944(this.f32648).m33466());
        c37042 c36847;
        if (n2 <= 0.333) {
            c36847 = Logoutspots.m33946();
        }
        else if (n2 <= 0.666) {
            c36847 = Logoutspots.m33947();
        }
        else {
            c36847 = Logoutspots.m33948();
        }
        c39098.m39100();
        c39098.m39101(this.f32638 + this.f32641 / 2.0 - c36846.f36848, this.f32639 + 0.5 - c36846.f36849, this.f32640 + this.f32642 / 2.0 - c36846.f36850);
        c39098.m39105(-camera.getYaw(), 0.0, 1.0, 0.0);
        c39098.m39105(camera.getPitch(), 1.0, 0.0, 0.0);
        c39098.m39110(-n, -n, n);
        final double n3 = MeteorClient.largeFont.m33815(this.f32644) / 2.0 + MeteorClient.largeFont.m33815(this.f32647) / 2.0;
        c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
        c39337.m39347(-n3 - 1.0, -1.0, 0.0, -n3 - 1.0, 8.0, 0.0, n3 + 1.0, 8.0, 0.0, n3 + 1.0, -1.0, 0.0, Logoutspots.m33949());
        c39337.m39346();
        MeteorClient.largeFont.m33789();
        MeteorClient.largeFont.m33795(this.f32647, MeteorClient.largeFont.m33795(this.f32644, -n3, 0.0, Logoutspots.m33950()), 0.0, c36847);
        MeteorClient.largeFont.m33793();
        c39098.m39114();
    }
    
    static {
        c32636.f32637 = new String[] { " " };
    }
}
