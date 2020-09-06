package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_1293.class })
public class StatusEffectInstanceMixin implements c33716
{
    @Shadow
    private int field_5895;
    @Shadow
    private int field_5893;
    
    public StatusEffectInstanceMixin() {
        super();
    }
    
    @Override
    public void m33717(final int duration) {
        this.duration = duration;
    }
    
    @Override
    public void m33718(final int amplifier) {
        this.amplifier = amplifier;
    }
}
