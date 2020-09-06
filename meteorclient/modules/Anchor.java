package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import minegame159.meteorclient.*;
import meteorclient.util.*;

public class Anchor extends Module
{
    private static final String[] f34803;
    private final Settings f34804;
    private final Value<Integer> f34805;
    private final class_2338.class_2339 f34806;
    private boolean f34807;
    private int f34808;
    private int f34809;
    @EventHandler
    private final Listener<c36575> f34810;
    
    public Anchor() {
        super(Category.Movement, "anchor", "Helps you get into holes.");
        this.f34804 = this.f38675.m34572();
        this.f34805 = this.f34804.addValue((Value<Integer>)new c32369.c32370().m32381("max-height").m32384("Max height.").m32387(10).m32396(0).m32399(255).m32405(20).m32408());
        this.f34806 = new class_2338.class_2339();
        this.f34810 = (Listener<c36575>)new Listener(this::m34827, new Predicate[0]);
    }
    
    private boolean m34811(final int n, final int n2, final int n3) {
        return this.m34816(n, n2 - 1, n3) && this.m34816(n + 1, n2, n3) && this.m34816(n - 1, n2, n3) && this.m34816(n, n2, n3 + 1) && this.m34816(n, n2, n3 - 1);
    }
    
    private boolean m34816(final int n, final int n2, final int n3) {
        this.f34806.method_10103(n, n2, n3);
        final Block block = this.mc.world.getBlockState((BlockPos)this.f34806).getBlock();
        return block == Blocks.field_9987 || block == Blocks.field_10540;
    }
    
    private boolean m34822(final int n, final int n2, final int n3) {
        this.f34806.method_10103(n, n2, n3);
        return this.mc.world.getBlockState((BlockPos)this.f34806).isAir();
    }
    
    private /* synthetic */ void m34827(final c36575 c36575) {
        final int floor = MathHelper.floor(this.mc.player.x);
        int floor2 = MathHelper.floor(this.mc.player.y);
        final int floor3 = MathHelper.floor(this.mc.player.z);
        if (this.m34811(floor, floor2, floor3)) {
            this.f34807 = true;
            this.f34808 = floor;
            this.f34809 = floor3;
            return;
        }
        if (this.f34807 && this.f34808 == floor && this.f34809 == floor3) {
            return;
        }
        if (this.f34807 && this.f34808 != floor && this.f34809 != floor3) {
            this.f34807 = false;
        }
        boolean b = false;
        double n = 0.0;
        double n2 = 0.0;
        for (int n3 = 0; n3 < this.f34805.m33466() && --floor2 > 0; ++n3) {
            if (!this.m34822(floor, floor2, floor3)) {
                break;
            }
            if (this.m34811(floor, floor2, floor3)) {
                b = true;
                n = floor + 0.5;
                n2 = floor3 + 0.5;
                break;
            }
        }
        if (b) {
            ((c37143)this.mc.player.getVelocity()).m37144(EnchantUtil.m35644(n - this.mc.player.x, -0.05, 0.05), this.mc.player.getVelocity().y, EnchantUtil.m35644(n2 - this.mc.player.z, -0.05, 0.05));
        }
    }
    
    static {
        f34803 = new String[] { "anchor", "Helps you get into holes.", "max-height", "Max height." };
    }
}
