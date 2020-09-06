package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_898.class })
public class EntityRenderDispatcherMixin
{
    public EntityRenderDispatcherMixin() {
        super();
    }
    
    @Inject(method = { "render(Lnet/minecraft/entity/Entity;DDDFFZ)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onRender(final Entity entity, final double n, final double n2, final double n3, final float n4, final float n5, final boolean b, final CallbackInfo callbackInfo) {
        if (c34030.f34033.m34042(Norender.class).m31746() && entity instanceof ItemEntity) {
            callbackInfo.cancel();
        }
    }
}
