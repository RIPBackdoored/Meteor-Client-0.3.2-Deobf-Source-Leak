package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_481.class })
public class CreativeInventoryScreenMixin implements c32668
{
    @Shadow
    private static int field_2896;
    
    public CreativeInventoryScreenMixin() {
        super();
    }
    
    @Override
    public int m32669() {
        return CreativeInventoryScreenMixin.selectedTab;
    }
}
