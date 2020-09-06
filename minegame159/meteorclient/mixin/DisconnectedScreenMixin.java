package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.client.gui.screen.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.text.*;

@Mixin({ class_419.class })
public class DisconnectedScreenMixin implements c34234
{
    @Shadow
    @Final
    private Screen field_2456;
    @Shadow
    @Final
    private Text field_2457;
    @Shadow
    private int field_2454;
    
    public DisconnectedScreenMixin() {
        super();
    }
    
    @Override
    public Screen m34235() {
        return this.parent;
    }
    
    @Override
    public Text m34236() {
        return this.reason;
    }
    
    @Override
    public int m34237() {
        return this.reasonHeight;
    }
}
