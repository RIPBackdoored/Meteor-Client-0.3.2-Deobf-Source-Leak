package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import org.apache.commons.lang3.*;
import java.util.function.*;
import net.minecraft.client.render.*;
import meteorclient.util.*;
import net.minecraft.client.*;
import net.minecraft.*;
import net.minecraft.util.hit.*;
import net.minecraft.client.network.*;
import java.util.*;
import net.minecraft.world.dimension.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.effect.*;
import net.minecraft.client.toast.*;
import minegame159.meteorclient.*;
import net.minecraft.item.*;
import com.mojang.blaze3d.platform.*;

public class HUD extends Module
{
    private static final String[] f35935;
    private static final c37042 f35936;
    private static final c37042 f35937;
    private static final c37042 f35938;
    private final Settings f35939;
    private final Settings f35940;
    private final Settings f35941;
    private final Settings f35942;
    private final Settings f35943;
    private final Value<c35934.DurabilityType> f35944;
    private final Value<Double> f35945;
    private final Value<Boolean> f35946;
    private final Value<Integer> f35947;
    private final Value<Boolean> f35948;
    private final Value<Boolean> f35949;
    private final Value<Boolean> f35950;
    private final Value<Boolean> f35951;
    private final Value<Boolean> f35952;
    private final Value<Boolean> f35953;
    private final Value<Boolean> f35954;
    private final Value<Boolean> f35955;
    private final Value<Boolean> f35956;
    private final Value<Boolean> f35957;
    private final Value<Boolean> f35958;
    private final Value<Boolean> f35959;
    private final Value<Boolean> f35960;
    private final Value<Boolean> f35961;
    private final Value<Double> f35962;
    private final Value<c37042> f35963;
    private final Value<c37042> f35964;
    private final Value<c37042> f35965;
    private final Value<c37042> f35966;
    private final Value<Boolean> f35967;
    public final Value<Boolean> f35968;
    private final Value<Boolean> f35969;
    private final Value<Boolean> f35970;
    private final HashMap<String, c35934.c36215> f35971;
    private int f35972;
    private boolean f35973;
    private int f35974;
    private Map<Integer, class_1799> f35975;
    private final List<Module> f35976;
    private final class_2338.class_2339 f35977;
    @EventHandler
    private final Listener<c33752> f35978;
    @EventHandler
    private final Listener<c37149> f35979;
    @EventHandler
    private final Listener<c34242> f35980;
    @EventHandler
    private final Listener<c32661> f35981;
    @EventHandler
    private final Listener<c36575> f35982;
    @EventHandler
    private final Listener<c38402> f35983;
    
    public HUD() {
        super(Category.Render, "HUD", "Displays various info to the screen.");
        this.f35939 = this.f38675.m34582("Armor", "armor-enabled", "Armor HUD", true);
        this.f35940 = this.f38675.m34588("Top Left");
        this.f35941 = this.f38675.m34582("Minimap", "minimap-enabled", "Minimap.", true);
        this.f35942 = this.f38675.m34588("Top Right");
        this.f35943 = this.f38675.m34588("Bottom Right");
        this.f35944 = this.f35939.addValue((Value<c35934.DurabilityType>)new c36601.c36919<Enum>().m36926("armor-durability").m36929("Displays armor durability on top of hotbar").m36932((Enum)c35934.DurabilityType.Default).m36941());
        this.f35945 = this.f35939.addValue((Value<Double>)new c37033.c38947().m38959("scale").m38962("The scale of the numbers over the armor").m38974(0.5).m38977(1.0).m38983(1.0).m38965(0.8).m38988());
        this.f35946 = this.f35939.addValue((Value<Boolean>)new c34427.c34657().m34664("durability-warner").m34667("Warns you if your armor is about to break.").m34670(true).m34679());
        this.f35947 = this.f35939.addValue((Value<Integer>)new c32369.c32370().m32381("warn-durability").m32384("The durability you are warned at").m32387(30).m32396(1).m32399(360).m32405(100).m32408());
        this.f35948 = this.f35939.addValue((Value<Boolean>)new c34427.c34657().m34664("chat-notifications").m34667("Sends messages in chat rather than in the corner of the screen.").m34670(false).m34679());
        this.f35949 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("water-mark").m34667("Water mark.").m34670(true).m34679());
        this.f35950 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("fps").m34667("Display fps.").m34670(true).m34679());
        this.f35951 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("ping").m34667("Display ping.").m34670(true).m34679());
        this.f35952 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("tps").m34667("Display tps.").m34670(true).m34679());
        this.f35953 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("speed").m34667("Display speed in blocks per second.").m34670(true).m34679());
        this.f35954 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("biome").m34667("Displays biome you are in.").m34670(true).m34679());
        this.f35955 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("time").m34667("Displays ingame time in ticks.").m34670(true).m34679());
        this.f35956 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("durability").m34667("Durability of the time in your main hand.").m34670(true).m34679());
        this.f35957 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("breaking-block").m34667("Displays the percentage how much you have broken the block.").m34670(true).m34679());
        this.f35958 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("looking-at").m34667("Displays block or entity you are looking at.").m34670(true).m34679());
        this.f35959 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("entities").m34667("Display number of entities.").m34670(true).m34673(this::m36151).m34679());
        this.f35960 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("entity-custom-names").m34667("Use custom names.").m34670(true).m34673(this::m36148).m34679());
        this.f35961 = this.f35940.addValue((Value<Boolean>)new c34427.c34657().m34664("separate-sheeps-by-color").m34667("Separates sheeps by color in entity list.").m34670(false).m34673(this::m36145).m34679());
        this.f35962 = this.f35941.addValue((Value<Double>)new c37033.c38947().m38959("minimap-scale").m38962("Scale.").m38965(1.0).m38974(0.0).m38983(2.0).m38988());
        this.f35963 = this.f35941.addValue((Value<c37042>)new c33179.c33180().m33187("minimap-background").m33190("Minimap background color.").m33193(new c37042(25, 25, 25, 175)).m33202());
        this.f35964 = this.f35941.addValue((Value<c37042>)new c33179.c33180().m33187("minimap-player").m33190("Minimap player color.").m33193(new c37042(225, 225, 225, 225)).m33202());
        this.f35965 = this.f35941.addValue((Value<c37042>)new c33179.c33180().m33187("minimap-animal").m33190("Minimap animal color.").m33193(new c37042(25, 225, 25, 225)).m33202());
        this.f35966 = this.f35941.addValue((Value<c37042>)new c33179.c33180().m33187("minimap-mob").m33190("Minimap mob color.").m33193(new c37042(225, 25, 25, 225)).m33202());
        this.f35967 = this.f35942.addValue((Value<Boolean>)new c34427.c34657().m34664("active-modules").m34667("Display active modules.").m34670(true).m34679());
        this.f35968 = this.f35943.addValue((Value<Boolean>)new c34427.c34657().m34664("potion-timers").m34667("Display potion timers and hide minecraft default potion icons.").m34670(true).m34679());
        this.f35969 = this.f35943.addValue((Value<Boolean>)new c34427.c34657().m34664("position").m34667("Display your position.").m34670(true).m34679());
        this.f35970 = this.f35943.addValue((Value<Boolean>)new c34427.c34657().m34664("rotation").m34667("Display your rotation.").m34670(true).m34679());
        this.f35971 = new HashMap<String, c35934.c36215>();
        this.f35972 = 0;
        this.f35974 = 2;
        this.f35975 = new HashMap<Integer, class_1799>();
        this.f35976 = new ArrayList<Module>();
        this.f35977 = new class_2338.class_2339();
        this.f35978 = (Listener<c33752>)new Listener(this::m36142, new Predicate[0]);
        this.f35979 = (Listener<c37149>)new Listener(this::m36139, new Predicate[0]);
        this.f35980 = (Listener<c34242>)new Listener(this::m36136, new Predicate[0]);
        this.f35981 = (Listener<c32661>)new Listener(this::m36133, new Predicate[0]);
        this.f35982 = (Listener<c36575>)new Listener(this::m36126, new Predicate[0]);
        this.f35983 = (Listener<c38402>)new Listener(this::m36111, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f35973 = true;
        this.m36080();
    }
    
    private String m35985(final Entity entity) {
        if (entity instanceof PlayerEntity) {
            return "Player";
        }
        if (entity instanceof ItemEntity) {
            return "Item";
        }
        final String s = this.f35960.m33466() ? entity.getDisplayName().asString() : entity.getType().getName().asString();
        if (this.f35961.m33466() && entity instanceof SheepEntity) {
            return StringUtils.capitalize(((SheepEntity)entity).getColor().getName().replace('_', ' ')) + " - " + s;
        }
        return s;
    }
    
    private c35934.c36215 m35989(final Entity entity) {
        return this.f35971.computeIfAbsent(this.m35985(entity), c35934.c36215::new);
    }
    
    private boolean m35992(final Entity entity) {
        return entity != this.mc.player;
    }
    
    private void m35995() {
        this.f35972 = 0;
        final Iterator<c35934.c36215> iterator = this.f35971.values().iterator();
        while (iterator.hasNext()) {
            this.f35972 = Math.max(this.f35972, iterator.next().f36218.length());
        }
    }
    
    private void m35998(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        final double doubleValue = this.f35962.m33466();
        c39337.m39347(2.0 + n * doubleValue, 2.0 + n2 * doubleValue, 0.0, 2.0 + (n + n3) * doubleValue, 2.0 + n2 * doubleValue, 0.0, 2.0 + (n + n3) * doubleValue, 2.0 + (n2 + n4) * doubleValue, 0.0, 2.0 + n * doubleValue, 2.0 + (n2 + n4) * doubleValue, 0.0, c37042);
    }
    
    private void m36006(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        final double doubleValue = this.f35962.m33466();
        c39337.m39384(2.0 + n * doubleValue, 2.0 + n2 * doubleValue, n3 * doubleValue, n4, c37042, false);
    }
    
    private void m36014(final c38402 c38402) {
        if (this.mc.options.debugEnabled) {
            return;
        }
        int n = 2;
        if (this.f35941.m33970()) {
            c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
            this.m35998(0.0, 0.0, 100.0, 100.0, this.f35963.m33466());
            this.m35998(0.0, 0.0, 100.0, 1.0, this.f35963.m33466());
            this.m35998(0.0, 0.0, 1.0, 100.0, this.f35963.m33466());
            this.m35998(99.0, 0.0, 1.0, 100.0, this.f35963.m33466());
            this.m35998(0.0, 99.0, 100.0, 1.0, this.f35963.m33466());
            double n2 = 32.0;
            if (this.mc.options.viewDistance > 4) {
                n2 += 16.0;
            }
            final double x = this.mc.player.x;
            final double z = this.mc.player.z;
            for (final Entity entity : this.mc.world.getEntities()) {
                final double n3 = entity.x - x;
                final double n4 = entity.z - z;
                if (Math.abs(n3) <= n2) {
                    if (Math.abs(n4) > n2) {
                        continue;
                    }
                    c37042 c38403;
                    if (EntityUtil.isPlayer(entity)) {
                        c38403 = this.f35964.m33466();
                    }
                    else if (EntityUtil.isAnimal(entity)) {
                        c38403 = this.f35965.m33466();
                    }
                    else {
                        if (!EntityUtil.isMonster(entity)) {
                            continue;
                        }
                        c38403 = this.f35966.m33466();
                    }
                    final double n5 = n3 / n2 * 50.0 + 50.0;
                    final double n6 = n4 / n2 * 50.0 + 50.0;
                    if (entity.getEntityId() == this.mc.player.getEntityId()) {
                        this.m36006(n5 - 2.5, n6 - 2.5, 5.0, this.mc.player.yaw, c38403);
                    }
                    else {
                        this.m35998(n5 - 1.0, n6 - 1.0, 2.0, 2.0, c38403);
                    }
                }
            }
            MeteorClient.smallFont.m33804("N", 52.0 - MeteorClient.smallFont.m33815("N") / 2.0, 4.0, HUD.f35936);
            MeteorClient.smallFont.m33804("S", 52.0 - MeteorClient.smallFont.m33815("S") / 2.0, 102.0 - MeteorClient.smallFont.m33813() - 2.0, HUD.f35936);
            MeteorClient.smallFont.m33804("W", 4.0, 52.0 - MeteorClient.smallFont.m33813() / 2.0, HUD.f35936);
            MeteorClient.smallFont.m33804("E", 102.0 - MeteorClient.smallFont.m33815("E") - 2.0, 52.0 - MeteorClient.smallFont.m33813() / 2.0, HUD.f35936);
            c39337.m39346();
            n += (int)(100.0 * this.f35962.m33466() + 2.0);
        }
        if (this.f35949.m33466()) {
            this.m36052("Meteor Client ", c33436.f34122.f34123.toString(), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35950.m33466()) {
            this.m36052("FPS: ", MinecraftClient.getCurrentFps() + "", n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        final PlayerListEntry playerListEntry = this.mc.getNetworkHandler().getPlayerListEntry(this.mc.player.getUuid());
        if (this.f35951.m33466() && playerListEntry != null) {
            this.m36052("Ping: ", playerListEntry.getLatency() + "", n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35952.m33466()) {
            this.m36052("TPS: ", String.format("%.1f", c34685.f34686.m34693()), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        final float m34698 = c34685.f34686.m34698();
        if (m34698 >= 1.0f) {
            this.m36046("Since last tick: ", String.format("%.1f", m34698), n, HUD.f35938);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35953.m33466()) {
            final double abs = Math.abs(this.mc.player.x - this.mc.player.prevX);
            final double abs2 = Math.abs(this.mc.player.z - this.mc.player.prevZ);
            this.m36052("Speed: ", String.format("%.1f", Math.sqrt(abs * abs + abs2 * abs2) * 20.0), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35954.m33466()) {
            this.f35977.method_10105((Entity)this.mc.player);
            this.m36052("Biome: ", this.mc.world.getBiome((BlockPos)this.f35977).getName().asString(), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35955.m33466()) {
            int n7 = (int)(this.mc.world.getTimeOfDay() % 24000L);
            n7 += 6000;
            if (n7 > 24000) {
                n7 -= 24000;
            }
            this.m36052("Time: ", String.format("%02d:%02d", n7 / 1000, (int)(n7 % 1000 / 1000.0 * 60.0)), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35956.m33466()) {
            Integer value = null;
            if (!this.mc.player.getMainHandStack().isEmpty() && this.mc.player.getMainHandStack().isDamageable()) {
                value = this.mc.player.getMainHandStack().getMaxDamage() - this.mc.player.getMainHandStack().getDamage();
            }
            this.m36052("Durability: ", (value == null) ? "" : value.toString(), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35957.m33466()) {
            this.m36052("Breaking block: ", String.format("%.0f%%", ((c39918)this.mc.interactionManager).m39920() * 100.0), n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35958.m33466()) {
            String s = "";
            if (this.mc.crosshairTarget.getType() == class_239.class_240.field_1332) {
                s = this.mc.world.getBlockState(((BlockHitResult)this.mc.crosshairTarget).getBlockPos()).getBlock().getName().asString();
            }
            else if (this.mc.crosshairTarget.getType() == class_239.class_240.field_1331) {
                s = ((EntityHitResult)this.mc.crosshairTarget).getEntity().getDisplayName().asString();
            }
            this.m36052("Looking At: ", s, n);
            n += (int)(MeteorClient.smallFont.m33813() + 2.0);
        }
        if (this.f35959.m33466()) {
            for (final c35934.c36215 c38404 : this.f35971.values()) {
                if (!c38404.f36219) {
                    continue;
                }
                this.m36068(c38404, n);
                n += (int)(MeteorClient.smallFont.m33813() + 2.0);
            }
        }
    }
    
    private void m36039(final String s, final String s2, final double n, final double n2, final c37042 c37042) {
        MeteorClient.smallFont.m33804(s, n, n2, c37042);
        MeteorClient.smallFont.m33804(s2, n + MeteorClient.smallFont.m33815(s), n2, HUD.f35937);
    }
    
    private void m36046(final String s, final String s2, final double n, final c37042 c37042) {
        this.m36039(s, s2, 2.0, n, c37042);
    }
    
    private void m36052(final String s, final String s2, final double n) {
        this.m36046(s, s2, n, HUD.f35936);
    }
    
    private void m36057(final String s, final String s2, final double n, final c37042 c37042) {
        this.m36039(s, s2, this.mc.window.getScaledWidth() - MeteorClient.smallFont.m33815(s) - MeteorClient.smallFont.m33815(s2) - 2.0, n, c37042);
    }
    
    private void m36063(final String s, final String s2, final double n) {
        this.m36057(s, s2, n, HUD.f35936);
    }
    
    private void m36068(final c35934.c36215 c36215, final double n) {
        MeteorClient.smallFont.m33804(c36215.f36218, 2.0, n, HUD.f35937);
        MeteorClient.smallFont.m33804(c36215.f36216, 2 + (this.f35972 - c36215.f36218.length()) * 4 + 4 + MeteorClient.smallFont.m33815(c36215.f36218), n, HUD.f35936);
    }
    
    private void m36072(final c38402 c38402) {
        if (this.mc.options.debugEnabled) {
            return;
        }
        double n = 2.0;
        if (this.f35967.m33466()) {
            for (final Module module : this.f35976) {
                final String m35302 = module.m35302();
                if (m35302 == null) {
                    MeteorClient.smallFont.m33804(module.f38672, c38402.f38403 - MeteorClient.smallFont.m33815(module.f38672) - 2.0, n, module.f38674);
                }
                else {
                    final double n2 = c38402.f38403 - MeteorClient.smallFont.m33815(module.f38672 + " " + m35302) - 2.0;
                    MeteorClient.smallFont.m33804(module.f38672, n2, n, module.f38674);
                    MeteorClient.smallFont.m33804(module.m35302(), n2 + MeteorClient.smallFont.m33815(module.f38672 + " "), n, HUD.f35937);
                }
                n += MeteorClient.smallFont.m33813() + 1.0;
            }
        }
    }
    
    private void m36080() {
        this.f35976.clear();
        for (final Module module : c34030.f34033.m34057()) {
            if (module.m35313()) {
                this.f35976.add(module);
            }
        }
        this.f35976.sort(c35934::m36107);
    }
    
    private void m36083(final c38402 c38402) {
        double n = c38402.f38404 - MeteorClient.smallFont.m33813() - 2.0;
        if (this.f35970.m33466()) {
            final Direction horizontalFacing = this.mc.cameraEntity.getHorizontalFacing();
            String s = "invalid";
            switch (c35934.c39289.f39290[horizontalFacing.ordinal()]) {
                case 1: {
                    s = "-Z";
                    break;
                }
                case 2: {
                    s = "+Z";
                    break;
                }
                case 3: {
                    s = "-X";
                    break;
                }
                case 4: {
                    s = "+X";
                    break;
                }
            }
            float n2 = this.mc.cameraEntity.yaw % 360.0f;
            if (n2 < 0.0f) {
                n2 += 360.0f;
            }
            if (n2 > 180.0f) {
                n2 -= 360.0f;
            }
            float n3 = this.mc.cameraEntity.pitch % 360.0f;
            if (n3 < 0.0f) {
                n3 += 360.0f;
            }
            if (n3 > 180.0f) {
                n3 -= 360.0f;
            }
            this.m36063(String.format("%s %s ", StringUtils.capitalize(horizontalFacing.getName()), s), String.format("(%.1f, %.1f)", n2, n3), n);
            n -= MeteorClient.smallFont.m33813() + 2.0;
        }
        if (this.f35969.m33466()) {
            if (this.mc.player.dimension == DimensionType.field_13072) {
                this.m36094(c38402.f38403, "Nether Pos: ", n, this.mc.cameraEntity.x / 8.0, this.mc.cameraEntity.y, this.mc.cameraEntity.z / 8.0);
                final double n4 = n - (MeteorClient.smallFont.m33813() + 2.0);
                this.m36094(c38402.f38403, "Pos: ", n4, this.mc.cameraEntity.x, this.mc.cameraEntity.y, this.mc.cameraEntity.z);
                n = n4 - (MeteorClient.smallFont.m33813() + 2.0);
            }
            else if (this.mc.player.dimension == DimensionType.field_13076) {
                this.m36094(c38402.f38403, "Overworld Pos: ", n, this.mc.cameraEntity.x * 8.0, this.mc.cameraEntity.y, this.mc.cameraEntity.z * 8.0);
                final double n5 = n - (MeteorClient.smallFont.m33813() + 2.0);
                this.m36094(c38402.f38403, "Pos: ", n5, this.mc.cameraEntity.x, this.mc.cameraEntity.y, this.mc.cameraEntity.z);
                n = n5 - (MeteorClient.smallFont.m33813() + 2.0);
            }
            else if (this.mc.player.dimension == DimensionType.field_13078) {
                this.m36094(c38402.f38403, "Pos: ", n, this.mc.cameraEntity.x, this.mc.cameraEntity.y, this.mc.cameraEntity.z);
                n -= MeteorClient.smallFont.m33813() + 2.0;
            }
        }
        if (this.f35968.m33466()) {
            for (final StatusEffectInstance statusEffectInstance : this.mc.player.getStatusEffects()) {
                final StatusEffect effectType = statusEffectInstance.getEffectType();
                final int color = effectType.getColor();
                HUD.f35936.f37045 = c37042.m37068(color);
                HUD.f35936.f37046 = c37042.m37070(color);
                HUD.f35936.f37047 = c37042.m37072(color);
                this.m36057(effectType.method_5560().asString(), " " + (statusEffectInstance.getAmplifier() + 1) + " (" + StatusEffectUtil.durationToString(statusEffectInstance, 1.0f) + ")", n, HUD.f35936);
                n -= MeteorClient.smallFont.m33813() + 2.0;
                final c37042 f35936 = HUD.f35936;
                final c37042 f35937 = HUD.f35936;
                final c37042 f35938 = HUD.f35936;
                final int f35939 = 255;
                f35938.f37047 = f35939;
                f35937.f37046 = f35939;
                f35936.f37045 = f35939;
            }
        }
    }
    
    private void m36094(final int n, final String s, final double n2, final double n3, final double n4, final double n5) {
        final String format = String.format("%.1f %.1f %.1f", n3, n4, n5);
        final double n6 = n - MeteorClient.smallFont.m33815(format) - 2.0;
        final double n7 = n - MeteorClient.smallFont.m33815(format) - MeteorClient.smallFont.m33815(s) - 2.0;
        MeteorClient.smallFont.m33804(format, n6, n2, HUD.f35937);
        MeteorClient.smallFont.m33804(s, n7, n2, HUD.f35936);
    }
    
    private void m36105() {
        if (!this.f35948.m33466()) {
            this.mc.getToastManager().add((Toast)new c35934.c39284(this));
        }
        else {
            c31351.m31360(this, "One of your armor pieces is low.", new Object[0]);
        }
    }
    
    private static /* synthetic */ int m36107(final Module module, final Module module2) {
        final int compare = Double.compare((module.m35302() == null) ? MeteorClient.smallFont.m33815(module.f38672) : MeteorClient.smallFont.m33815(module.f38672 + " " + module.m35302()), (module2.m35302() == null) ? MeteorClient.smallFont.m33815(module2.f38672) : MeteorClient.smallFont.m33815(module2.f38672 + " " + module2.m35302()));
        if (compare == 0) {
            return 0;
        }
        return (compare < 0) ? 1 : -1;
    }
    
    private /* synthetic */ void m36111(final c38402 c38402) {
        MeteorClient.smallFont.m33789();
        this.m36014(c38402);
        this.m36072(c38402);
        this.m36083(c38402);
        MeteorClient.smallFont.m33793();
        if (this.f35939.m33970()) {
            int n = c38402.f38403 / 2 + 12;
            int n2 = c38402.f38404 - 38;
            if (!this.mc.player.abilities.creativeMode) {
                n2 -= 18;
            }
            if (this.f35944.m33466() == c35934.DurabilityType.Default) {
                for (int i = this.mc.player.inventory.armor.size() - 1; i >= 0; --i) {
                    final ItemStack itemStack = (ItemStack)this.mc.player.inventory.armor.get(i);
                    this.mc.getItemRenderer().renderGuiItem(itemStack, n, n2);
                    this.mc.getItemRenderer().renderGuiItemOverlay(this.mc.textRenderer, itemStack, n, n2);
                    n += 20;
                }
            }
            else if (this.f35944.m33466() == c35934.DurabilityType.Numbers) {
                for (int j = this.mc.player.inventory.armor.size() - 1; j >= 0; --j) {
                    final ItemStack itemStack2 = (ItemStack)this.mc.player.inventory.armor.get(j);
                    this.mc.getItemRenderer().renderGuiItem(itemStack2, n, n2);
                    if (!itemStack2.isEmpty()) {
                        final String string = Integer.toString(itemStack2.getMaxDamage() - itemStack2.getDamage());
                        MeteorClient.smallFont.f33761 = this.f35945.m33466();
                        MeteorClient.smallFont.m33804(string, n + (15.0 - MeteorClient.smallFont.m33815(string)) / 2.0 + 1.0, n2 - 5, HUD.f35936);
                        MeteorClient.smallFont.f33761 = 1.0;
                    }
                    n += 20;
                }
            }
            else if (this.f35944.m33466() == c35934.DurabilityType.Percentage) {
                for (int k = this.mc.player.inventory.armor.size() - 1; k >= 0; --k) {
                    final ItemStack itemStack3 = (ItemStack)this.mc.player.inventory.armor.get(k);
                    this.mc.getItemRenderer().renderGuiItem(itemStack3, n, n2);
                    if (!itemStack3.isEmpty()) {
                        final String string2 = Integer.toString(Math.round((float)((itemStack3.getMaxDamage() - itemStack3.getDamage()) * 100 / itemStack3.getMaxDamage())));
                        MeteorClient.smallFont.f33761 = this.f35945.m33466();
                        MeteorClient.smallFont.m33804(string2, n + (15.0 - MeteorClient.smallFont.m33815(string2)) / 2.0 + 1.0, n2 - 5, HUD.f35936);
                        MeteorClient.smallFont.f33761 = 1.0;
                    }
                    n += 20;
                }
            }
            else if (this.f35944.m33466() == c35934.DurabilityType.None) {
                for (int l = this.mc.player.inventory.armor.size() - 1; l >= 0; --l) {
                    this.mc.getItemRenderer().renderGuiItem((ItemStack)this.mc.player.inventory.armor.get(l), n, n2);
                    n += 20;
                }
            }
            GlStateManager.disableLighting();
        }
    }
    
    private /* synthetic */ void m36126(final c36575 c36575) {
        --this.f35974;
        if (this.f35959.m33466() && this.f35973 && this.f35974 <= 0 && this.f35959.m33466()) {
            final Iterator<c35934.c36215> iterator = this.f35971.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().m36223();
            }
            for (final Entity entity : this.mc.world.getEntities()) {
                if (!this.m35992(entity)) {
                    continue;
                }
                this.m35989(entity).m36220(entity);
            }
            this.f35973 = false;
            this.f35974 = 2;
            this.m35995();
        }
        if (this.f35946.m33466()) {
            for (int i = this.mc.player.inventory.armor.size() - 1; i >= 0; --i) {
                final ItemStack itemStack = (ItemStack)this.mc.player.inventory.armor.get(i);
                if (!itemStack.isEmpty()) {
                    if (itemStack.getMaxDamage() - itemStack.getDamage() <= this.f35947.m33466()) {
                        if (!this.f35975.containsKey(i)) {
                            this.f35975.put(i, (class_1799)itemStack);
                            this.m36105();
                        }
                        else if (this.f35975.containsKey(i) && ((ItemStack)this.f35975.get(i)).getMaxDamage() - ((ItemStack)this.f35975.get(i)).getDamage() < itemStack.getMaxDamage() - itemStack.getDamage()) {
                            this.f35975.put(i, (class_1799)itemStack);
                            this.m36105();
                        }
                    }
                }
            }
        }
    }
    
    private /* synthetic */ void m36133(final c32661 c32661) {
        if (this.f35959.m33466()) {
            if (!this.m35992(c32661.f32662)) {
                return;
            }
            this.f35973 = true;
        }
    }
    
    private /* synthetic */ void m36136(final c34242 c34242) {
        if (this.f35959.m33466()) {
            if (!this.m35992(c34242.f34243)) {
                return;
            }
            this.f35973 = true;
        }
    }
    
    private /* synthetic */ void m36139(final c37149 c37149) {
        if (c37149.f37150.m35315()) {
            this.m36080();
        }
    }
    
    private /* bridge */ void m36142(final c33752 c33752) {
        this.m36080();
    }
    
    private /* synthetic */ void m36145(final Boolean b) {
        this.f35973 = true;
    }
    
    private /* synthetic */ void m36148(final Boolean b) {
        this.f35973 = true;
    }
    
    private /* synthetic */ void m36151(final Boolean b) {
        this.f35973 = true;
    }
    
    static {
        f35935 = new String[] { "HUD", "Displays various info to the screen.", "Armor", "armor-enabled", "Armor HUD", "Top Left", "Minimap", "minimap-enabled", "Minimap.", "Top Right", "Bottom Right", "armor-durability", "Displays armor durability on top of hotbar", "scale", "The scale of the numbers over the armor", "durability-warner", "Warns you if your armor is about to break.", "warn-durability", "The durability you are warned at", "chat-notifications", "Sends messages in chat rather than in the corner of the screen.", "water-mark", "Water mark.", "fps", "Display fps.", "ping", "Display ping.", "tps", "Display tps.", "speed", "Display speed in blocks per second.", "biome", "Displays biome you are in.", "time", "Displays ingame time in ticks.", "durability", "Durability of the time in your main hand.", "breaking-block", "Displays the percentage how much you have broken the block.", "looking-at", "Displays block or entity you are looking at.", "entities", "Display number of entities.", "entity-custom-names", "Use custom names.", "separate-sheeps-by-color", "Separates sheeps by color in entity list.", "minimap-scale", "Scale.", "minimap-background", "Minimap background color.", "minimap-player", "Minimap player color.", "minimap-animal", "Minimap animal color.", "minimap-mob", "Minimap mob color.", "active-modules", "Display active modules.", "potion-timers", "Display potion timers and hide minecraft default potion icons.", "position", "Display your position.", "rotation", "Display your rotation.", "Player", "Item", " - ", "N", "N", "S", "S", "W", "E", "E", "Meteor Client ", "FPS: ", "", "Ping: ", "", "TPS: ", "%.1f", "Since last tick: ", "%.1f", "Speed: ", "%.1f", "Biome: ", "Time: ", "%02d:%02d", "Durability: ", "", "Breaking block: ", "%.0f%%", "", "Looking At: ", " ", " ", "invalid", "-Z", "+Z", "-X", "+X", "%s %s ", "(%.1f, %.1f)", "Nether Pos: ", "Pos: ", "Overworld Pos: ", "Pos: ", "Pos: ", " ", " (", ")", "%.1f %.1f %.1f", "One of your armor pieces is low.", " ", " " };
        f35936 = new c37042(255, 255, 255);
        f35937 = new c37042(185, 185, 185);
        f35938 = new c37042(225, 45, 45);
    }
}
