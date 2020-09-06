package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.block.entity.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_498.class })
public class SignEditScreenMixin implements c31564
{
    @Shadow
    @Final
    private SignBlockEntity field_3031;
    
    public SignEditScreenMixin() {
        super();
    }
    
    @Override
    public SignBlockEntity m31565() {
        return this.sign;
    }
}
