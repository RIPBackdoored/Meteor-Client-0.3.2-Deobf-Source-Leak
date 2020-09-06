package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_243.class })
public class Vec3dMixin implements c37143
{
    @Shadow
    public double field_1352;
    @Shadow
    public double field_1351;
    @Shadow
    public double field_1350;
    
    public Vec3dMixin() {
        super();
    }
    
    @Override
    public void m37144(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
