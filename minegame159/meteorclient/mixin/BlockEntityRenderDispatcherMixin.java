package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.block.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.util.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_824.class })
public class BlockEntityRenderDispatcherMixin
{
    public BlockEntityRenderDispatcherMixin() {
        super();
    }
    
    @Inject(method = { "renderEntity(Lnet/minecraft/block/entity/BlockEntity;DDDFIZ)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onRenderEntity(final BlockEntity blockEntity, final double n, final double n2, final double n3, final float n4, final int n5, final boolean b, final CallbackInfo callbackInfo) {
        if (!EnchantUtil.f35531) {
            return;
        }
        final Xray xray = c34030.f34033.m34042(Xray.class);
        final Iterator<class_2248> iterator = ((c34170)blockEntity.getType()).m34171().iterator();
        while (iterator.hasNext()) {
            if (xray.m38231((Block)iterator.next())) {
                callbackInfo.cancel();
                break;
            }
        }
    }
}
