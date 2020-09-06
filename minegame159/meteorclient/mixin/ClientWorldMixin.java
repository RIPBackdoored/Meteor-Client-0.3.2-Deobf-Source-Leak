package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;

@Mixin({ class_638.class })
public class ClientWorldMixin
{
    public ClientWorldMixin() {
        super();
    }
    
    @Inject(method = { "addEntityPrivate" }, at = { @At("TAIL") })
    private void onAddEntityPrivate(final int n, final Entity entity, final CallbackInfo callbackInfo) {
        MeteorClient.eventBus.post((Object)c34429.m34474(entity));
    }
    
    @Inject(method = { "finishRemovingEntity" }, at = { @At("TAIL") })
    private void onFinishRemovingEntity(final Entity entity, final CallbackInfo callbackInfo) {
        MeteorClient.eventBus.post((Object)c34429.m34476(entity));
    }
    
    @Inject(method = { "setBlockStateWithoutNeighborUpdates" }, at = { @At("TAIL") })
    private void onSetBlockStateWithoutNeighborUpdates(final BlockPos blockPos, final BlockState blockState, final CallbackInfo callbackInfo) {
        final Search search = c34030.f34033.m34042(Search.class);
        if (search.m35315()) {
            search.m38128(blockPos, blockState);
        }
    }
}
