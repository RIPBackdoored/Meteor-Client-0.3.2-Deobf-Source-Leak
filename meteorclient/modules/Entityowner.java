package meteorclient.modules;

import meteorclient.*;
import java.lang.reflect.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import meteorclient.util.*;
import net.minecraft.client.render.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import java.util.*;
import minegame159.meteorclient.*;

public class Entityowner extends Module
{
    private static final String[] f31792;
    private static final c37042 f31793;
    private static final c37042 f31794;
    private static final Type f31795;
    private final Settings f31796;
    private final Value<Double> f31797;
    private final Map<UUID, String> f31798;
    @EventHandler
    private final Listener<c36846> f31799;
    
    public Entityowner() {
        super(Category.Render, "entity-owner", "Displays name of the player that owns that entity.");
        this.f31796 = this.f38675.m34572();
        this.f31797 = this.f31796.addValue((Value<Double>)new c37033.c38947().m38959("scale").m38962("Scale.").m38965(1.0).m38974(0.0).m38988());
        this.f31798 = new HashMap<UUID, String>();
        this.f31799 = (Listener<c36846>)new Listener(this::m31821, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        c31516.m31520();
    }
    
    @Override
    public void m35294() {
        c31516.m31522();
        this.f31798.clear();
    }
    
    private void m31800(final c36846 c36846, final Entity entity, final String s) {
        final Camera camera = this.mc.gameRenderer.getCamera();
        double n = 0.025;
        final double m35611 = EnchantUtil.m35611(entity);
        if (m35611 > 10.0) {
            n *= m35611 / 10.0 * this.f31797.m33466();
        }
        c39098.m39100();
        c39098.m39101(entity.prevX + (entity.x - entity.prevX) * c36846.f36847 - c36846.f36848, entity.prevY + (entity.y - entity.prevY) * c36846.f36847 + entity.getHeight() + 0.25 - c36846.f36849, entity.prevZ + (entity.z - entity.prevZ) * c36846.f36847 - c36846.f36850);
        c39098.m39105(-camera.getYaw(), 0.0, 1.0, 0.0);
        c39098.m39105(camera.getPitch(), 1.0, 0.0, 0.0);
        c39098.m39110(-n, -n, n);
        final double n2 = MeteorClient.largeFont.m33815(s) / 2.0;
        c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
        c39337.m39347(-n2 - 1.0, -1.0, 0.0, -n2 - 1.0, 8.0, 0.0, n2 + 1.0, 8.0, 0.0, n2 + 1.0, -1.0, 0.0, Entityowner.f31793);
        c39337.m39346();
        MeteorClient.largeFont.m33795(s, -n2, 0.0, Entityowner.f31794);
        c39098.m39114();
    }
    
    private String m31812(final UUID uuid) {
        final PlayerEntity playerByUuid = this.mc.world.getPlayerByUuid(uuid);
        if (playerByUuid != null) {
            return playerByUuid.getGameProfile().getName();
        }
        final String s = this.f31798.get(uuid);
        if (s != null) {
            return s;
        }
        c31516.m31524(this::m31817);
        final String s2 = "Retrieving";
        this.f31798.put(uuid, s2);
        return s2;
    }
    
    private /* synthetic */ void m31817(final UUID uuid) {
        if (this.m35315()) {
            final List<c34238> list = c37229.m37244("https://api.mojang.com/user/profiles/" + uuid.toString().replace("-", "") + "/names", Entityowner.f31795);
            if (this.m35315()) {
                if (list == null || list.size() <= 0) {
                    this.f31798.put(uuid, "Failed to get name");
                }
                else {
                    this.f31798.put(uuid, list.get(list.size() - 1).f34239);
                }
            }
        }
    }
    
    private /* synthetic */ void m31821(final c36846 c36846) {
        for (final Entity entity : this.mc.world.getEntities()) {
            UUID uuid = null;
            if (entity instanceof TameableEntity) {
                uuid = ((TameableEntity)entity).getOwnerUuid();
            }
            else if (entity instanceof HorseBaseEntity) {
                uuid = ((HorseBaseEntity)entity).getOwnerUuid();
            }
            if (uuid == null) {
                continue;
            }
            this.m31800(c36846, entity, this.m31812(uuid));
        }
    }
    
    static {
        f31792 = new String[] { "entity-owner", "Displays name of the player that owns that entity.", "scale", "Scale.", "Retrieving", "https://api.mojang.com/user/profiles/", "-", "", "/names", "Failed to get name" };
        f31793 = new c37042(0, 0, 0, 75);
        f31794 = new c37042(255, 255, 255);
        f31795 = new c31791.c33719().getType();
    }
}
