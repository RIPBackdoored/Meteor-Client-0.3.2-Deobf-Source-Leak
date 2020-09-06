package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.util.math.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_3965.class })
public class BlockHitResultMixin implements c33406
{
    @Shadow
    private Direction field_17588;
    
    public BlockHitResultMixin() {
        super();
    }
    
    @Override
    public void m33407(final Direction side) {
        this.side = side;
    }
}
