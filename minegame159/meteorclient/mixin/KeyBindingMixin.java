package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.*;

@Mixin({ class_304.class })
public class KeyBindingMixin implements c39520
{
    @Shadow
    private boolean field_1653;
    @Shadow
    private class_3675.class_306 field_1655;
    
    public KeyBindingMixin() {
        super();
    }
    
    @Override
    public void m39521(final boolean pressed) {
        this.pressed = pressed;
    }
    
    @Override
    public class_3675.class_306 m39522() {
        return this.keyCode;
    }
}
