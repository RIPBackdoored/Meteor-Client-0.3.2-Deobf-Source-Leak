package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.item.*;
import net.minecraft.block.*;

@Mixin({ class_1747.class })
public class BlockItemMixin
{
    public BlockItemMixin() {
        super();
    }
    
    @Inject(method = { "place(Lnet/minecraft/item/ItemPlacementContext;Lnet/minecraft/block/BlockState;)Z" }, at = { @At("HEAD") })
    private void onPlace(final class_1750 class_1750, final class_2680 class_1751, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        MeteorClient.eventBus.post((Object)c34429.m34539(((ItemPlacementContext)class_1750).getBlockPos(), ((BlockState)class_1751).getBlock()));
    }
}
