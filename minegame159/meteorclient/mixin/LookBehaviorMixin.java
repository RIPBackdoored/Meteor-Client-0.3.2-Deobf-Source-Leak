package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import baritone.behavior.*;
import baritone.api.utils.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ LookBehavior.class })
public class LookBehaviorMixin implements c34922
{
    @Shadow
    private Rotation target;
    
    public LookBehaviorMixin() {
        super();
    }
    
    @Override
    public Rotation m34923() {
        return this.target;
    }
}
