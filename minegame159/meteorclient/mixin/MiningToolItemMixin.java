package minegame159.meteorclient.mixin;

import minegame159.meteorclient.*;
import java.util.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.block.*;

@Mixin({ class_1766.class })
public class MiningToolItemMixin implements c35011
{
    @Shadow
    @Final
    private Set<class_2248> field_7941;
    
    public MiningToolItemMixin() {
        super();
    }
    
    @Override
    public boolean m35012(final Block block) {
        return this.effectiveBlocks.contains(block);
    }
}
