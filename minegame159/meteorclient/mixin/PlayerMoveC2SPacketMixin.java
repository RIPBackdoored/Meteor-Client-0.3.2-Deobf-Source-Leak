package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_2828.class })
public class PlayerMoveC2SPacketMixin implements c34907
{
    @Shadow
    protected boolean field_12891;
    
    public PlayerMoveC2SPacketMixin() {
        super();
    }
    
    @Override
    public void m34908(final boolean onGround) {
        this.onGround = onGround;
    }
}
