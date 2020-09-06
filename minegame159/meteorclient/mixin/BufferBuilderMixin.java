package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_287.class })
public class BufferBuilderMixin implements c34410
{
    @Shadow
    private boolean field_1556;
    
    public BufferBuilderMixin() {
        super();
    }
    
    @Override
    public boolean m34411() {
        return this.building;
    }
}
