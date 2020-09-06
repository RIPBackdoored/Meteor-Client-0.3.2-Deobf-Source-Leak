package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import java.util.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_2591.class })
public class BlockEntityTypeMixin implements c34170
{
    @Shadow
    @Final
    private Set<class_2248> field_19315;
    
    public BlockEntityTypeMixin() {
        super();
    }
    
    @Override
    public Set<class_2248> m34171() {
        return (Set<class_2248>)this.blocks;
    }
}
