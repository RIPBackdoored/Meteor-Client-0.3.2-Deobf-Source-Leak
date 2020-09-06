package minegame159.meteorclient.mixin;

import net.minecraft.entity.player.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.*;
import minegame159.meteorclient.*;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_1657.class })
public class PlayerEntityMixin implements c31839
{
    @Shadow
    public PlayerInventory field_7514;
    
    public PlayerEntityMixin() {
        super();
    }
    
    @Inject(method = { "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;" }, at = { @At("HEAD") })
    private void onDropItem(final class_1799 class_1799, final boolean b, final boolean b2, final CallbackInfoReturnable<class_1542> callbackInfoReturnable) {
        MeteorClient.eventBus.post((Object)c34429.m34542((ItemStack)class_1799));
    }
    
    @Override
    public void m31840(final PlayerInventory inventory) {
        this.inventory = inventory;
    }
}
