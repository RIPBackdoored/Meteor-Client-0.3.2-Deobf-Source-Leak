package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import meteorclient.util.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.block.*;
import net.minecraft.client.render.model.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import minegame159.meteorclient.*;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.*;
import java.util.*;
import net.minecraft.util.registry.*;

public class Nametags extends Module
{
    private static final String[] f31569;
    private static final c37042 f31570;
    private static final c37042 f31571;
    private final Settings f31572;
    private final Settings f31573;
    private final Value<Boolean> f31574;
    private final Value<Boolean> f31575;
    private final Value<c31568.Position> f31576;
    private final Value<List<class_1887>> f31577;
    private final Value<Boolean> f31578;
    private final Value<Double> f31579;
    private final Value<Double> f31580;
    private final Value<Boolean> f31581;
    private final Value<c37042> f31582;
    private final Value<c37042> f31583;
    private final Value<c37042> f31584;
    private final Value<c37042> f31585;
    private final Value<c37042> f31586;
    private final Value<c37042> f31587;
    @EventHandler
    private final Listener<c36846> f31588;
    
    public Nametags() {
        super(Category.Render, "nametags", "Displays nametags above players.");
        this.f31572 = this.f38675.m34572();
        this.f31573 = this.f38675.m34588("Colors");
        this.f31574 = this.f31572.addValue((Value<Boolean>)new c34427.c34657().m34664("display-armor").m34667("Display armor.").m34670(true).m34679());
        this.f31575 = this.f31572.addValue((Value<Boolean>)new c34427.c34657().m34664("display-armor-enchants").m34667("Display armor enchantments.").m34670(true).m34679());
        this.f31576 = this.f31572.addValue((Value<c31568.Position>)new c36601.c36919<Enum>().m36926("enchantment-position").m36929("Where enchantments are rendered.").m36932((Enum)c31568.Position.ON_TOP).m36941());
        this.f31577 = this.f31572.addValue((Value<List<class_1887>>)new c38020.c38993().m39000("displayed-enchantments").m39003("The enchantments that are shown on nametags").m39006(this.m31663()).m39015());
        this.f31578 = this.f31572.addValue((Value<Boolean>)new c34427.c34657().m34664("ping").m34667("Shows players ping").m34670(true).m34679());
        this.f31579 = this.f31572.addValue((Value<Double>)new c37033.c38947().m38959("scale").m38962("Scale.").m38965(1.0).m38974(0.1).m38988());
        this.f31580 = this.f31572.addValue((Value<Double>)new c37033.c38947().m38959("enchant-text-scale").m38962("Enchantment text scale.").m38965(0.6).m38974(0.1).m38977(1.0).m38980(0.1).m38983(1.0).m38988());
        this.f31581 = this.f31572.addValue((Value<Boolean>)new c34427.c34657().m34664("yourself").m34667("Displays nametag above your player in Freecam.").m34670(true).m34679());
        this.f31582 = this.f31573.addValue((Value<c37042>)new c33179.c33180().m33187("normal-color").m33190("The color of non-friends").m33193(new c37042(255, 255, 255)).m33202());
        this.f31583 = this.f31573.addValue((Value<c37042>)new c33179.c33180().m33187("ping-color").m33190("The color of ping.").m33193(new c37042(150, 150, 150)).m33202());
        this.f31584 = this.f31573.addValue((Value<c37042>)new c33179.c33180().m33187("health-stage-1").m33190("The color of full health").m33193(new c37042(25, 252, 25)).m33202());
        this.f31585 = this.f31573.addValue((Value<c37042>)new c33179.c33180().m33187("health-stage-2").m33190("The color of 2/3 health").m33193(new c37042(255, 105, 25)).m33202());
        this.f31586 = this.f31573.addValue((Value<c37042>)new c33179.c33180().m33187("health-stage-3").m33190("The color of 1/3 health").m33193(new c37042(255, 25, 25)).m33202());
        this.f31587 = this.f31573.addValue((Value<c37042>)new c33179.c33180().m33187("enchantment-text-color").m33190("The color of enchantment text.").m33193(new c37042(255, 255, 255)).m33202());
        this.f31588 = (Listener<c36846>)new Listener(this::m31667, new Predicate[0]);
    }
    
    private void m31589(final c36846 c36846, final PlayerEntity playerEntity) {
        final Camera camera = this.mc.gameRenderer.getCamera();
        final double m35611 = EnchantUtil.m35611((Entity)playerEntity);
        double n = 0.04 * this.f31579.m33466();
        if (m35611 > 15.0) {
            n *= m35611 / 15.0;
        }
        int latency;
        try {
            latency = this.mc.getNetworkHandler().getPlayerListEntry(playerEntity.getUuid()).getLatency();
        }
        catch (NullPointerException ex) {
            latency = 0;
        }
        final float absorptionAmount = playerEntity.getAbsorptionAmount();
        final int round = Math.round(playerEntity.getHealth() + absorptionAmount);
        final double n2 = round / (playerEntity.getMaximumHealth() + absorptionAmount);
        final String name = playerEntity.getGameProfile().getName();
        final String string = " " + round;
        final String string2 = "[" + latency + "]";
        c39098.m39100();
        c39098.m39101(playerEntity.prevX + (playerEntity.x - playerEntity.prevX) * c36846.f36847 - c36846.f36848, playerEntity.prevY + (playerEntity.y - playerEntity.prevY) * c36846.f36847 + playerEntity.getHeight() + 0.5 - c36846.f36849, playerEntity.prevZ + (playerEntity.z - playerEntity.prevZ) * c36846.f36847 - c36846.f36850);
        c39098.m39105(-camera.getYaw(), 0.0, 1.0, 0.0);
        c39098.m39105(camera.getPitch(), 1.0, 0.0, 0.0);
        c39098.m39110(-n, -n, n);
        final double[] array = new double[4];
        boolean b = false;
        int max = 0;
        if (this.f31574.m33466() || this.f31575.m33466()) {
            MeteorClient.largeFont.f33761 = 0.5 * this.f31580.m33466();
            for (int i = 0; i < 4; ++i) {
                final ItemStack itemStack = (ItemStack)playerEntity.inventory.armor.get(i);
                final Map enchantments = EnchantmentHelper.getEnchantments(itemStack);
                final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                for (final Enchantment enchantment : this.f31577.m33466()) {
                    if (enchantments.containsKey(enchantment)) {
                        hashMap.put(enchantment, enchantments.get(enchantment));
                    }
                }
                if (array[i] == 0.0) {
                    array[i] = 16.0;
                }
                if (!itemStack.isEmpty() && this.f31574.m33466()) {
                    b = true;
                }
                if (this.f31575.m33466()) {
                    for (final Enchantment enchantment2 : hashMap.keySet()) {
                        array[i] = Math.max(array[i], MeteorClient.largeFont.m33815(EnchantUtil.m35549(enchantment2) + " " + hashMap.get(enchantment2)));
                    }
                    max = Math.max(max, hashMap.size());
                }
            }
            MeteorClient.largeFont.f33761 = 0.5;
        }
        final double m35612 = MeteorClient.largeFont.m33815(name);
        final double m35613 = MeteorClient.largeFont.m33815(string);
        final double m35614 = MeteorClient.largeFont.m33815(string2);
        double n3 = m35612 + m35613;
        if (this.f31578.m33466()) {
            n3 += m35614;
        }
        double n4 = 0.0;
        final double[] array2 = array;
        for (int length = array2.length, j = 0; j < length; ++j) {
            n4 += array2[j];
        }
        final double max2 = Math.max(n3, n4);
        final double n5 = max2 / 2.0;
        final double m35615 = MeteorClient.largeFont.m33813();
        final double max3;
        final double n6 = max3 = Math.max(b ? 16 : 0, max * MeteorClient.largeFont.m33813() * this.f31580.m33466());
        c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
        c39337.m39347(-n5 - 1.0, -1.0, 0.0, -n5 - 1.0, m35615, 0.0, n5 + 1.0, m35615, 0.0, n5 + 1.0, -1.0, 0.0, Nametags.f31570);
        c39337.m39346();
        final double n7 = (max2 - n4) / 4.0;
        if (b) {
            double n8 = -n5;
            c39337.m39340(null, 4, VertexFormats.POSITION_TEXTURE_COLOR);
            boolean b2 = false;
            for (int k = 0; k < 4; ++k) {
                final ItemStack itemStack2 = (ItemStack)playerEntity.inventory.armor.get(k);
                if (itemStack2.isDamaged()) {
                    b2 = true;
                }
                final Iterator iterator3 = this.mc.getItemRenderer().getModel(itemStack2).getQuads((BlockState)null, (Direction)null, (Random)null).iterator();
                while (iterator3.hasNext()) {
                    final Sprite sprite = iterator3.next().getSprite();
                    if (itemStack2.getItem() instanceof DyeableArmorItem) {
                        final int color = ((DyeableArmorItem)itemStack2.getItem()).getColor(itemStack2);
                        Nametags.f31571.f37045 = c37042.m37068(color);
                        Nametags.f31571.f37046 = c37042.m37070(color);
                        Nametags.f31571.f37047 = c37042.m37072(color);
                    }
                    final double n9 = n8;
                    c39337.m39361(n8 + (array[k] - 16.0) / 2.0, -max3 + (n6 - 16.0) / 2.0, 16.0, 16.0, sprite.getMinU(), sprite.getMinV(), sprite.getMaxU() - sprite.getMinU(), sprite.getMaxV() - sprite.getMinV(), Nametags.f31571, Nametags.f31571, Nametags.f31571, Nametags.f31571);
                    n8 = n9;
                    final c37042 f31571 = Nametags.f31571;
                    final c37042 f31572 = Nametags.f31571;
                    final c37042 f31573 = Nametags.f31571;
                    final int f31574 = 255;
                    f31573.f37047 = f31574;
                    f31572.f37046 = f31574;
                    f31571.f37045 = f31574;
                }
                n8 += array[k] + n7;
            }
            this.mc.getTextureManager().bindTexture(SpriteAtlasTexture.BLOCK_ATLAS_TEX);
            c39337.m39344(true);
            if (b2) {
                double n10 = -n5;
                c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
                for (int l = 0; l < 4; ++l) {
                    final ItemStack itemStack3 = (ItemStack)playerEntity.inventory.armor.get(l);
                    final double n11 = Math.max(0, itemStack3.getDamage());
                    final double n12 = itemStack3.getMaxDamage();
                    final double max4 = Math.max(0.0, (n12 - n11) / n12);
                    final double n13 = (double)Math.round(13.0 - n11 * 13.0 / n12);
                    final int hsvToRgb = MathHelper.hsvToRgb((float)(max4 / 3.0), 1.0f, 1.0f);
                    final double n14 = n10;
                    final double n15 = n10 + (array[l] - 17.0) / 2.0;
                    final double n16 = (n6 - 16.0) / 2.0;
                    final c37042 f31575 = Nametags.f31571;
                    final c37042 f31576 = Nametags.f31571;
                    final c37042 f31577 = Nametags.f31571;
                    final int f31578 = 0;
                    f31577.f37047 = f31578;
                    f31576.f37046 = f31578;
                    f31575.f37045 = f31578;
                    c39337.m39347(n15 + 2.0, -max3 + 13.0 + n16, 0.0, n15 + 2.0 + 13.0, -max3 + 13.0 + n16, 0.0, n15 + 2.0 + 13.0, -max3 + 2.0 + 13.0 + n16, 0.0, n15 + 2.0, -max3 + 2.0 + 13.0 + n16, 0.0, Nametags.f31571);
                    Nametags.f31571.f37045 = (hsvToRgb >> 16 & 0xFF);
                    Nametags.f31571.f37046 = (hsvToRgb >> 8 & 0xFF);
                    Nametags.f31571.f37047 = (hsvToRgb & 0xFF);
                    c39337.m39347(n15 + 2.0, -max3 + 13.0 + n16, 0.0, n15 + 2.0 + n13, -max3 + 13.0 + n16, 0.0, n15 + 2.0 + n13, -max3 + 1.0 + 13.0 + n16, 0.0, n15 + 2.0, -max3 + 1.0 + 13.0 + n16, 0.0, Nametags.f31571);
                    final c37042 f31579 = Nametags.f31571;
                    final c37042 f31580 = Nametags.f31571;
                    final c37042 f31581 = Nametags.f31571;
                    final int f31582 = 255;
                    f31581.f37047 = f31582;
                    f31580.f37046 = f31582;
                    f31579.f37045 = f31582;
                    n10 = n14 + (array[l] + n7);
                }
                c39337.m39346();
            }
        }
        c37042 c36847;
        if (n2 <= 0.333) {
            c36847 = this.f31586.m33466();
        }
        else if (n2 <= 0.666) {
            c36847 = this.f31585.m33466();
        }
        else {
            c36847 = this.f31584.m33466();
        }
        MeteorClient.largeFont.m33789();
        final double m35616 = MeteorClient.largeFont.m33804(name, -n5, 0.0, c39017.f39019.m39045(playerEntity, this.f31582.m33466()));
        MeteorClient.largeFont.m33804(string, m35616 + (max2 - m35612 - m35613), 0.0, c36847);
        MeteorClient.largeFont.m33804(string2, m35616 + 3.0, 0.0, this.f31583.m33466());
        double n17 = -n5;
        if (max > 0) {
            MeteorClient.largeFont.f33761 = 0.5 * this.f31580.m33466();
            for (int n18 = 0; n18 < 4; ++n18) {
                final Map enchantments2 = EnchantmentHelper.getEnchantments((ItemStack)playerEntity.inventory.armor.get(n18));
                final HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
                for (final Enchantment enchantment3 : this.f31577.m33466()) {
                    if (enchantments2.containsKey(enchantment3)) {
                        hashMap2.put(enchantment3, enchantments2.get(enchantment3));
                    }
                }
                final double n19 = array[n18];
                double n20 = 0.0;
                double n21 = (n6 - hashMap2.size() * MeteorClient.largeFont.m33813()) / 2.0;
                if (this.f31576.m33466() == c31568.Position.ABOVE) {
                    n21 -= 16.0;
                }
                for (final Enchantment enchantment4 : hashMap2.keySet()) {
                    final String string3 = EnchantUtil.m35549(enchantment4) + " " + hashMap2.get(enchantment4);
                    MeteorClient.largeFont.m33804(string3, n17 + (n19 - MeteorClient.largeFont.m33815(string3)) / 2.0, -max3 + n20 + n21, this.f31587.m33466());
                    n20 += MeteorClient.largeFont.m33813();
                }
                n17 += array[n18] + n7;
            }
            MeteorClient.largeFont.f33761 = 0.5;
        }
        MeteorClient.largeFont.m33793();
        c39098.m39114();
    }
    
    private List<class_1887> m31663() {
        final ArrayList<Enchantment> list = (ArrayList<Enchantment>)new ArrayList<class_1887>();
        final Iterator iterator = Registry.ENCHANTMENT.iterator();
        while (iterator.hasNext()) {
            list.add((class_1887)iterator.next());
        }
        return (List<class_1887>)list;
    }
    
    private /* synthetic */ void m31667(final c36846 c36846) {
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity instanceof PlayerEntity && entity != this.mc.player) {
                if (entity == this.mc.cameraEntity) {
                    continue;
                }
                if (!this.f31581.m33466() && entity.getUuid().equals(this.mc.player.getUuid())) {
                    continue;
                }
                this.m31589(c36846, (PlayerEntity)entity);
            }
        }
    }
    
    static {
        f31569 = new String[] { "nametags", "Displays nametags above players.", "Colors", "display-armor", "Display armor.", "display-armor-enchants", "Display armor enchantments.", "enchantment-position", "Where enchantments are rendered.", "displayed-enchantments", "The enchantments that are shown on nametags", "ping", "Shows players ping", "scale", "Scale.", "enchant-text-scale", "Enchantment text scale.", "yourself", "Displays nametag above your player in Freecam.", "normal-color", "The color of non-friends", "ping-color", "The color of ping.", "health-stage-1", "The color of full health", "health-stage-2", "The color of 2/3 health", "health-stage-3", "The color of 1/3 health", "enchantment-text-color", "The color of enchantment text.", " ", "[", "]", " ", " " };
        f31570 = new c37042(0, 0, 0, 75);
        f31571 = new c37042(255, 255, 255);
    }
}
