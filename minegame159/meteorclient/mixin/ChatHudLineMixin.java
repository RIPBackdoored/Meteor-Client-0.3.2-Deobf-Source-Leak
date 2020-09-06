package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_303.class })
public class ChatHudLineMixin implements c32714
{
    @Shadow
    private Text field_1651;
    @Shadow
    private int field_1650;
    @Shadow
    private int field_1649;
    
    public ChatHudLineMixin() {
        super();
    }
    
    @Override
    public void m32715(final Text text) {
        this.text = text;
    }
    
    @Override
    public void m32716(final int creationTick) {
        this.creationTick = creationTick;
    }
    
    @Override
    public void m32717(final int id) {
        this.id = id;
    }
}
