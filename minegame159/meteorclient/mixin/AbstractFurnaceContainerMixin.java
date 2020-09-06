package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ class_1720.class })
public abstract class AbstractFurnaceContainerMixin implements c35891
{
    public AbstractFurnaceContainerMixin() {
        super();
    }
    
    @Shadow
    protected abstract boolean method_7640(final ItemStack p0);
    
    @Shadow
    protected abstract boolean method_16945(final ItemStack p0);
    
    @Override
    public boolean m35892(final ItemStack itemStack) {
        return this.isSmeltable(itemStack);
    }
    
    @Override
    public boolean m35893(final ItemStack itemStack) {
        return this.isFuel(itemStack);
    }
}
