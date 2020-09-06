package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.block.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_2680.class })
public class BlockStateMixin
{
    public BlockStateMixin() {
        super();
    }
    
    @Inject(method = { "activate" }, at = { @At("HEAD") })
    private void onActivate(final class_1937 class_1937, final class_1657 class_1938, final class_1268 class_1939, final class_3965 class_1940, final CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        MeteorClient.eventBus.post((Object)c34429.m34530((BlockState)this));
    }
}
