package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.mojang.blaze3d.platform.*;
import net.minecraft.client.network.*;
import net.minecraft.client.*;

public class Logoutspots extends Module
{
    private static final String[] f33890;
    private static final c37042 f33891;
    private static final c37042 f33892;
    private static final c37042 f33893;
    private static final c37042 f33894;
    private static final c37042 f33895;
    private final Settings f33896;
    private final c37042 f33897;
    private final Value<Double> f33898;
    private final Value<c37042> f33899;
    private final List<c32635.c32636> f33900;
    private final List<class_640> f33901;
    private final List<class_1657> f33902;
    private int f33903;
    @EventHandler
    private final Listener<c34242> f33904;
    @EventHandler
    private final Listener<c36575> f33905;
    @EventHandler
    private final Listener<c36846> f33906;
    
    public Logoutspots() {
        super(Category.Render, "logout-spots", "Displays players logout position.");
        this.f33896 = this.f38675.m34572();
        this.f33897 = new c37042();
        this.f33898 = this.f33896.addValue((Value<Double>)new c37033.c38947().m38959("scale").m38962("Scale.").m38965(1.0).m38974(0.0).m38988());
        this.f33899 = this.f33896.addValue((Value<c37042>)new c33179.c33180().m33187("color").m33190("Color.").m33193(new c37042(255, 0, 255)).m33196(this::m33933).m33202());
        this.f33900 = new ArrayList<c32635.c32636>();
        this.f33901 = new ArrayList<class_640>();
        this.f33902 = new ArrayList<class_1657>();
        this.f33904 = (Listener<c34242>)new Listener(this::m33928, new Predicate[0]);
        this.f33905 = (Listener<c36575>)new Listener(this::m33920, new Predicate[0]);
        this.f33906 = (Listener<c36846>)new Listener(this::m33913, new Predicate[0]);
        this.f33899.m33480();
    }
    
    @Override
    public void m35292() {
        this.f33901.addAll(this.mc.getNetworkHandler().getPlayerList());
        this.m33907();
        this.f33903 = 10;
    }
    
    @Override
    public void m35294() {
        this.f33900.clear();
        this.f33901.clear();
    }
    
    private void m33907() {
        this.f33902.clear();
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity instanceof PlayerEntity) {
                this.f33902.add((class_1657)entity);
            }
        }
    }
    
    private void m33910(final c32635.c32636 c32636) {
        this.f33900.removeIf(c32635::m33917);
        this.f33900.add(c32636);
    }
    
    @Override
    public String m35302() {
        return Integer.toString(this.f33900.size());
    }
    
    private /* synthetic */ void m33913(final c36846 c36846) {
        final Iterator<c32635.c32636> iterator = this.f33900.iterator();
        while (iterator.hasNext()) {
            iterator.next().m32649(c36846);
        }
        GlStateManager.disableDepthTest();
        GlStateManager.disableTexture();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
    }
    
    private static /* bridge */ boolean m33917(final c32635.c32636 c32636, final c32635.c32636 c32637) {
        return c32637.f32643.equals(c32636.f32643);
    }
    
    private /* synthetic */ void m33920(final c36575 c36575) {
        if (this.mc.getNetworkHandler().getPlayerList().size() != this.f33901.size()) {
            for (final PlayerListEntry playerListEntry : this.f33901) {
                if (this.mc.getNetworkHandler().getPlayerList().stream().anyMatch(c32635::m33925)) {
                    continue;
                }
                for (final PlayerEntity playerEntity : this.f33902) {
                    if (playerEntity.getUuid().equals(playerListEntry.getProfile().getId())) {
                        this.m33910(new c32635.c32636(this, playerEntity));
                    }
                }
            }
            this.f33901.clear();
            this.f33901.addAll(this.mc.getNetworkHandler().getPlayerList());
            this.m33907();
        }
        if (this.f33903 <= 0) {
            this.m33907();
            this.f33903 = 10;
        }
        else {
            --this.f33903;
        }
    }
    
    private static /* synthetic */ boolean m33925(final PlayerListEntry playerListEntry, final PlayerListEntry playerListEntry2) {
        return playerListEntry2.getProfile().equals((Object)playerListEntry.getProfile());
    }
    
    private /* synthetic */ void m33928(final c34242 c34242) {
        if (c34242.f34243 instanceof PlayerEntity) {
            int n = -1;
            for (int i = 0; i < this.f33900.size(); ++i) {
                if (this.f33900.get(i).f32643.equals(c34242.f34243.getUuid())) {
                    n = i;
                    break;
                }
            }
            if (n != -1) {
                this.f33900.remove(n);
            }
        }
    }
    
    private /* synthetic */ void m33933(final c37042 c37042) {
        this.f33897.m37049(c37042);
        final c37042 f33897 = this.f33897;
        f33897.f37048 -= 200;
        this.f33897.m37052();
    }
    
    static /* synthetic */ MinecraftClient m33936(final Logoutspots logoutspots) {
        return logoutspots.mc;
    }
    
    static /* synthetic */ Value m33938(final Logoutspots logoutspots) {
        return logoutspots.f33898;
    }
    
    static /* synthetic */ MinecraftClient m33940(final Logoutspots logoutspots) {
        return logoutspots.mc;
    }
    
    static /* synthetic */ c37042 m33942(final Logoutspots logoutspots) {
        return logoutspots.f33897;
    }
    
    static /* synthetic */ Value m33944(final Logoutspots logoutspots) {
        return logoutspots.f33899;
    }
    
    static /* synthetic */ c37042 m33946() {
        return Logoutspots.f33895;
    }
    
    static /* synthetic */ c37042 m33947() {
        return Logoutspots.f33894;
    }
    
    static /* synthetic */ c37042 m33948() {
        return Logoutspots.f33893;
    }
    
    static /* synthetic */ c37042 m33949() {
        return Logoutspots.f33891;
    }
    
    static /* synthetic */ c37042 m33950() {
        return Logoutspots.f33892;
    }
    
    static {
        f33890 = new String[] { "logout-spots", "Displays players logout position.", "scale", "Scale.", "color", "Color." };
        f33891 = new c37042(0, 0, 0, 75);
        f33892 = new c37042(255, 255, 255);
        f33893 = new c37042(25, 225, 25);
        f33894 = new c37042(225, 105, 25);
        f33895 = new c37042(225, 25, 25);
    }
}
