package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_339.class })
public class AbstractButtonWidgetMixin implements c34882
{
    @Shadow
    private String message;
    
    public AbstractButtonWidgetMixin() {
        super();
    }
    
    @Override
    public void m34883(final String message) {
        this.message = message;
    }
}
