package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_2815.class })
public class GuiCloseC2SPacketMixin implements c32351
{
    @Shadow
    private int field_12827;
    
    public GuiCloseC2SPacketMixin() {
        super();
    }
    
    @Override
    public int m32352() {
        return this.id;
    }
}
