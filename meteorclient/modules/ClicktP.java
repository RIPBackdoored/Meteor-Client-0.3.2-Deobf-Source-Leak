package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.hit.*;
import net.minecraft.util.math.*;

public class ClicktP extends Module
{
    private static final String[] f32776;
    private final Settings f32777;
    private final Value<Double> f32778;
    @EventHandler
    private final Listener<c36575> f32779;
    
    public ClicktP() {
        super(Category.Movement, "click-tP", "Teleports you to the block you are looking at.");
        this.f32777 = this.f38675.m34572();
        this.f32778 = this.f32777.addValue((Value<Double>)new c37033.c38947().m38959("max-distance").m38962("Maximum distance.").m38965(5.0).m38988());
        this.f32779 = (Listener<c36575>)new Listener(this::m32780, new Predicate[0]);
    }
    
    private /* synthetic */ void m32780(final c36575 c36575) {
        if (this.mc.player.isUsingItem()) {
            return;
        }
        if (this.mc.options.keyUse.isPressed()) {
            final HitResult rayTrace = this.mc.player.rayTrace((double)this.f32778.m33466(), 0.05f, false);
            if (rayTrace.getType() == class_239.class_240.field_1331 && this.mc.player.interact(((EntityHitResult)rayTrace).getEntity(), Hand.field_5808) != ActionResult.field_5811) {
                return;
            }
            if (rayTrace.getType() == class_239.class_240.field_1332) {
                final BlockPos blockPos = ((BlockHitResult)rayTrace).getBlockPos();
                final Direction side = ((BlockHitResult)rayTrace).getSide();
                if (this.mc.world.getBlockState(blockPos).activate((World)this.mc.world, (PlayerEntity)this.mc.player, Hand.field_5808, (BlockHitResult)rayTrace)) {
                    return;
                }
                this.mc.player.updatePosition(blockPos.getX() + 0.5 + side.getOffsetX(), (double)(blockPos.getY() + side.getOffsetY()), blockPos.getZ() + 0.5 + side.getOffsetZ());
            }
        }
    }
    
    static {
        f32776 = new String[] { "click-tP", "Teleports you to the block you are looking at.", "max-distance", "Maximum distance." };
    }
}
