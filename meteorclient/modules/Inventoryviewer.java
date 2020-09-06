package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.util.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import com.mojang.blaze3d.platform.*;
import net.minecraft.client.gui.*;
import minegame159.meteorclient.*;
import net.minecraft.client.render.*;

public class Inventoryviewer extends Module
{
    private static final String[] f33540;
    private final Settings f33541;
    private final Settings f33542;
    private final Settings f33543;
    private final Value<Boolean> f33544;
    private final Value<AlignmentX> f33545;
    private final Value<Integer> f33546;
    private final Value<AlignmentY> f33547;
    private final Value<Integer> f33548;
    private static final Identifier f33549;
    private static final Identifier f33550;
    private static final int f33551 = 176;
    private static final int f33552 = 67;
    @EventHandler
    private Listener<c38402> f33553;
    
    public Inventoryviewer() {
        super(Category.Render, "inventory-viewer", "Displays your inventory.");
        this.f33541 = this.f38675.m34582("Background", "draw-background", "Draw inventory background.", true);
        this.f33542 = this.f38675.m34588("X");
        this.f33543 = this.f38675.m34588("Y");
        this.f33544 = this.f33541.addValue((Value<Boolean>)new c34427.c34657().m34664("background-transparent").m34667("Draws inventory background transparent.").m34670(false).m34679());
        this.f33545 = this.f33542.addValue(new c36601.c36919<AlignmentX>().m36926("x-alignment").m36929("X alignment.").m36932(AlignmentX.Left).m36941());
        this.f33546 = this.f33542.addValue((Value<Integer>)new c32369.c32370().m32381("x-offset").m32384("X offset.").m32387(3).m32405(200).m32408());
        this.f33547 = this.f33543.addValue(new c36601.c36919<AlignmentY>().m36926("y-alignment").m36929("Y alignment.").m36932(AlignmentY.Bottom).m36941());
        this.f33548 = this.f33543.addValue((Value<Integer>)new c32369.c32370().m32381("y-offset").m32384("Y offset.").m32387(3).m32405(200).m32408());
        this.f33553 = (Listener<c38402>)new Listener(this::m33569, new Predicate[0]);
    }
    
    private void m33554(final ItemStack itemStack, final int n, final int n2) {
        this.mc.getItemRenderer().renderGuiItem((LivingEntity)this.mc.player, itemStack, n, n2);
        this.mc.getItemRenderer().renderGuiItemOverlay(this.mc.textRenderer, itemStack, n, n2, (String)null);
    }
    
    private void m33559(final int n, final int n2) {
        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(((boolean)this.f33544.m33466()) ? Inventoryviewer.f33550 : Inventoryviewer.f33549);
        DrawableHelper.blit(n, n2, 0, 0.0f, 0.0f, 176, 67, 67, 176);
    }
    
    private int m33563(final int n) {
        switch (c33539.c38990.f38991[this.f33545.m33466().ordinal()]) {
            case 1: {
                return this.f33546.m33466();
            }
            case 2: {
                return n / 2 - 88 + this.f33546.m33466();
            }
            case 3: {
                return n - 176 - this.f33546.m33466();
            }
            default: {
                return 0;
            }
        }
    }
    
    private int m33566(final int n) {
        switch (c33539.c38990.f38992[this.f33547.m33466().ordinal()]) {
            case 1: {
                return this.f33548.m33466();
            }
            case 2: {
                return n / 2 - 33 + this.f33548.m33466();
            }
            case 3: {
                return n - 67 - this.f33548.m33466();
            }
            default: {
                return 0;
            }
        }
    }
    
    private /* synthetic */ void m33569(final c38402 c38402) {
        final int m33563 = this.m33563(c38402.f38403);
        final int m33564 = this.m33566(c38402.f38404);
        if (this.f33541.m33970()) {
            this.m33559(m33563, m33564);
        }
        DiffuseLighting.enableForItems();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.m33554(this.mc.player.inventory.getInvStack(9 + i * 9 + j), m33563 + 8 + j * 18, m33564 + 7 + i * 18);
            }
        }
        GlStateManager.disableLighting();
    }
    
    static {
        f33540 = new String[] { "inventory-viewer", "Displays your inventory.", "Background", "draw-background", "Draw inventory background.", "X", "Y", "background-transparent", "Draws inventory background transparent.", "x-alignment", "X alignment.", "x-offset", "X offset.", "y-alignment", "Y alignment.", "y-offset", "Y offset.", "meteor-client", "container_3x9.png", "meteor-client", "container_3x9-transparent.png" };
        f33549 = new Identifier("meteor-client", "container_3x9.png");
        f33550 = new Identifier("meteor-client", "container_3x9-transparent.png");
    }
}
