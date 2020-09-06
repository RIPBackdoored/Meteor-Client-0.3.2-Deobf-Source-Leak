package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import minegame159.meteorclient.*;
import meteorclient.modules.*;
import net.minecraft.util.shape.*;

@Mixin({ class_2404.class })
public abstract class FluidBlockMixin extends class_2248 implements class_2263
{
    public FluidBlockMixin(final class_2248.class_2251 class_2251) {
        super(class_2251);
    }
    
    public VoxelShape method_9549(final BlockState blockState, final BlockView blockView, final BlockPos blockPos, final EntityContext entityContext) {
        if (c34030.f34033 != null && c34030.f34033.m34042(Jesus.class).m32081()) {
            return VoxelShapes.fullCube();
        }
        return super.getCollisionShape(blockState, blockView, blockPos, entityContext);
    }
}
