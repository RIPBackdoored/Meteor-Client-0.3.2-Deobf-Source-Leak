package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_2490.class })
public class SlimeBlockMixin
{
    public SlimeBlockMixin() {
        super();
    }
    
    @Inject(method = { "onSteppedOn" }, at = { @At("HEAD") }, cancellable = true)
    private void onSteppedOn(final World world, final BlockPos blockPos, final Entity entity, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Noslow.class).m34425() && entity == MinecraftClient.getInstance().player) {
            callbackInfo.cancel();
        }
    }
}
