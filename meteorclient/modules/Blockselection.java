package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.util.hit.*;
import net.minecraft.world.*;
import minegame159.meteorclient.*;
import net.minecraft.util.shape.*;
import net.minecraft.util.math.*;

public class Blockselection extends Module
{
    private static final String[] f33592;
    private final Settings f33593;
    private final Value<c33591.Mode> f33594;
    private final Value<Boolean> f33595;
    private final Value<c37042> f33596;
    private final c37042 f33597;
    @EventHandler
    private final Listener<c36846> f33598;
    
    public Blockselection() {
        super(Category.Render, "block-selection", "Modifies your block selection outline.");
        this.f33593 = this.f38675.m34572();
        this.f33594 = this.f33593.addValue((Value<c33591.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Rendering mode").m36932((Enum)c33591.Mode.Lines).m36941());
        this.f33595 = this.f33593.addValue((Value<Boolean>)new c34427.c34657().m34664("advanced").m34667("Shows more advanced outline.").m34670(true).m34679());
        this.f33596 = this.f33593.addValue((Value<c37042>)new c33179.c33180().m33187("color").m33190("Color.").m33193(new c37042(255, 255, 255)).m33202());
        this.f33597 = new c37042();
        this.f33598 = (Listener<c36846>)new Listener(this::m33601, new Predicate[0]);
    }
    
    private void m33599() {
        this.f33597.m37049(this.f33596.m33466());
        this.f33597.f37048 = 30;
    }
    
    private /* synthetic */ void m33601(final c36846 c36846) {
        if (this.mc.crosshairTarget == null || !(this.mc.crosshairTarget instanceof BlockHitResult)) {
            return;
        }
        final BlockPos blockPos = ((BlockHitResult)this.mc.crosshairTarget).getBlockPos();
        final VoxelShape outlineShape = this.mc.world.getBlockState(blockPos).getOutlineShape((BlockView)this.mc.world, blockPos);
        if (outlineShape.isEmpty()) {
            return;
        }
        final Box boundingBox = outlineShape.getBoundingBox();
        if (this.f33595.m33466()) {
            outlineShape.forEachBox(this::m33608);
        }
        else {
            if (this.f33594.m33466() == c33591.Mode.Lines || this.f33594.m33466() == c33591.Mode.Both) {
                c39337.m39427(blockPos.getX() + boundingBox.x1, blockPos.getY() + boundingBox.y1, blockPos.getZ() + boundingBox.z1, blockPos.getX() + boundingBox.x2, blockPos.getY() + boundingBox.y2, blockPos.getZ() + boundingBox.z2, this.f33596.m33466());
            }
            if (this.f33594.m33466() == c33591.Mode.Sides || this.f33594.m33466() == c33591.Mode.Both) {
                this.m33599();
                c39337.m39453(blockPos.getX() + boundingBox.x1, blockPos.getY() + boundingBox.y1, blockPos.getZ() + boundingBox.z1, blockPos.getX() + boundingBox.x2, blockPos.getY() + boundingBox.y2, blockPos.getZ() + boundingBox.z2, this.f33597);
            }
        }
    }
    
    private /* synthetic */ void m33608(final BlockPos blockPos, final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        if (this.f33594.m33466() == c33591.Mode.Lines || this.f33594.m33466() == c33591.Mode.Both) {
            c39337.m39427(blockPos.getX() + n, blockPos.getY() + n2, blockPos.getZ() + n3, blockPos.getX() + n4, blockPos.getY() + n5, blockPos.getZ() + n6, this.f33596.m33466());
        }
        if (this.f33594.m33466() == c33591.Mode.Sides || this.f33594.m33466() == c33591.Mode.Both) {
            this.m33599();
            c39337.m39453(blockPos.getX() + n, blockPos.getY() + n2, blockPos.getZ() + n3, blockPos.getX() + n4, blockPos.getY() + n5, blockPos.getZ() + n6, this.f33597);
        }
    }
    
    static {
        f33592 = new String[] { "block-selection", "Modifies your block selection outline.", "mode", "Rendering mode", "advanced", "Shows more advanced outline.", "color", "Color." };
    }
}
