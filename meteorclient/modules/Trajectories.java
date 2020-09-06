package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.item.*;
import meteorclient.util.*;
import minegame159.meteorclient.*;
import net.minecraft.util.hit.*;

public class Trajectories extends Module
{
    private static final String[] f35658;
    private final Settings f35659;
    private final Value<c37042> f35660;
    private final c32900<class_243> f35661;
    private final List<class_243> f35662;
    private boolean f35663;
    private boolean f35664;
    private double f35665;
    private double f35666;
    private double f35667;
    private double f35668;
    private double f35669;
    private double f35670;
    private final c37042 f35671;
    @EventHandler
    private final Listener<c36846> f35672;
    
    public Trajectories() {
        super(Category.Render, "trajectories", "Displays trajectory of held items.");
        this.f35659 = this.f38675.m34572();
        this.f35660 = this.f35659.addValue((Value<c37042>)new c33179.c33180().m33187("color").m33190("Color.").m33193(new c37042(255, 150, 0)).m33202());
        this.f35661 = new c32900<class_243>(c35657::m35711);
        this.f35662 = new ArrayList<class_243>();
        this.f35671 = new c37042();
        this.f35672 = (Listener<c36846>)new Listener(this::m35706, new Predicate[0]);
    }
    
    private void m35673(final float n) {
        final Iterator<class_243> iterator = this.f35662.iterator();
        while (iterator.hasNext()) {
            this.f35661.m32905(iterator.next());
        }
        this.f35662.clear();
        final Item item = this.mc.player.getMainHandStack().getItem();
        double n2 = this.mc.player.lastRenderX + (this.mc.player.x - this.mc.player.lastRenderX) * n - Math.cos(Math.toRadians(this.mc.player.yaw)) * 0.16;
        double n3 = this.mc.player.lastRenderY + (this.mc.player.y - this.mc.player.lastRenderY) * n + this.mc.player.getStandingEyeHeight() - 0.1;
        double n4 = this.mc.player.lastRenderZ + (this.mc.player.z - this.mc.player.lastRenderZ) * n - Math.sin(Math.toRadians(this.mc.player.yaw)) * 0.16;
        final double n5 = (item instanceof RangedWeaponItem) ? 1.0 : 0.4;
        final double radians = Math.toRadians(this.mc.player.yaw);
        final double radians2 = Math.toRadians(this.mc.player.pitch);
        final double n6 = -Math.sin(radians) * Math.cos(radians2) * n5;
        final double n7 = -Math.sin(radians2) * n5;
        final double n8 = Math.cos(radians) * Math.cos(radians2) * n5;
        final double sqrt = Math.sqrt(n6 * n6 + n7 * n7 + n8 * n8);
        final double n9 = n6 / sqrt;
        final double n10 = n7 / sqrt;
        final double n11 = n8 / sqrt;
        double n15;
        double n16;
        double n17;
        if (item instanceof RangedWeaponItem) {
            final float n12 = (72000 - this.mc.player.getItemUseTimeLeft()) / 20.0f;
            float n13 = (n12 * n12 + n12 * 2.0f) / 3.0f;
            if (n13 > 1.0f || n13 <= 0.1f) {
                n13 = 1.0f;
            }
            final float n14 = n13 * 3.0f;
            n15 = n9 * n14;
            n16 = n10 * n14;
            n17 = n11 * n14;
        }
        else {
            n15 = n9 * 1.5;
            n16 = n10 * 1.5;
            n17 = n11 * 1.5;
        }
        final double m35697 = this.m35697(item);
        final Vec3d add = this.mc.player.getPos().add(0.0, (double)this.mc.player.getEyeHeight(this.mc.player.getPose()), 0.0);
        BlockHitResult rayTrace = null;
        do {
            final Vec3d m35698 = this.m35700(n2, n3, n4);
            n2 += n15 * 0.1;
            n3 += n16 * 0.1;
            n4 += n17 * 0.1;
            if (n3 < 0.0) {
                break;
            }
            n15 *= 0.999;
            final double n18 = n16 * 0.999;
            n17 *= 0.999;
            n16 = n18 - m35697 * 0.1;
            if (!this.mc.world.method_2935().isChunkLoaded((int)(n2 / 16.0), (int)(n4 / 16.0))) {
                break;
            }
            rayTrace = this.mc.world.rayTrace(new RayTraceContext(add, m35698, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (Entity)this.mc.player));
        } while (((HitResult)rayTrace).getType() == class_239.class_240.field_1333);
        if (rayTrace != null && ((HitResult)rayTrace).getType() == class_239.class_240.field_1332) {
            final BlockHitResult blockHitResult = rayTrace;
            this.f35663 = true;
            this.f35665 = blockHitResult.getPos().x;
            this.f35666 = blockHitResult.getPos().y;
            this.f35667 = blockHitResult.getPos().z;
            this.f35668 = blockHitResult.getPos().x;
            this.f35669 = blockHitResult.getPos().y;
            this.f35670 = blockHitResult.getPos().z;
            if (blockHitResult.getSide() == Direction.field_11036 || blockHitResult.getSide() == Direction.field_11033) {
                this.f35664 = true;
                this.f35665 -= 0.25;
                this.f35667 -= 0.25;
                this.f35668 += 0.25;
                this.f35670 += 0.25;
            }
            else if (blockHitResult.getSide() == Direction.field_11043 || blockHitResult.getSide() == Direction.field_11035) {
                this.f35664 = false;
                this.f35665 -= 0.25;
                this.f35666 -= 0.25;
                this.f35668 += 0.25;
                this.f35669 += 0.25;
            }
            else {
                this.f35664 = false;
                this.f35667 -= 0.25;
                this.f35666 -= 0.25;
                this.f35670 += 0.25;
                this.f35669 += 0.25;
            }
        }
        else {
            this.f35663 = false;
        }
    }
    
    private double m35697(final Item item) {
        if (item instanceof BowItem || item instanceof CrossbowItem) {
            return 0.05;
        }
        if (item instanceof PotionItem) {
            return 0.4;
        }
        if (item instanceof FishingRodItem) {
            return 0.15;
        }
        if (item instanceof TridentItem) {
            return 0.015;
        }
        return 0.03;
    }
    
    private Vec3d m35700(final double n, final double n2, final double n3) {
        final Vec3d vec3d = (Vec3d)this.f35661.m32903();
        ((c37143)vec3d).m37144(n, n2, n3);
        this.f35662.add((class_243)vec3d);
        return vec3d;
    }
    
    private /* synthetic */ void m35706(final c36846 c36846) {
        if (!EnchantUtil.m35630(this.mc.player.getMainHandStack().getItem())) {
            return;
        }
        this.m35673(c36846.f36847);
        Vec3d vec3d = null;
        for (final Vec3d vec3d2 : this.f35662) {
            if (vec3d != null) {
                c39337.m39404(vec3d.x, vec3d.y, vec3d.z, vec3d2.x, vec3d2.y, vec3d2.z, this.f35660.m33466());
            }
            vec3d = vec3d2;
        }
        if (this.f35663) {
            this.f35671.m37049(this.f35660.m33466());
            this.f35671.f37048 = 35;
            if (this.f35664) {
                c39337.m39476(this.f35665, this.f35666, this.f35667, 0.5, 0.5, this.f35671, this.f35660.m33466());
            }
            else {
                c39337.m39467(this.f35665, this.f35666, this.f35667, this.f35668, this.f35669, this.f35670, this.f35671, this.f35660.m33466());
            }
        }
    }
    
    private static /* synthetic */ Vec3d m35711() {
        return new Vec3d(0.0, 0.0, 0.0);
    }
    
    static {
        f35658 = new String[] { "trajectories", "Displays trajectory of held items.", "color", "Color." };
    }
}
