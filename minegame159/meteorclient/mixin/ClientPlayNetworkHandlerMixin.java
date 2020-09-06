package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.network.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.network.*;
import net.minecraft.util.math.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.entity.*;

@Mixin({ class_634.class })
public abstract class ClientPlayNetworkHandlerMixin
{
    @Shadow
    private MinecraftClient field_3690;
    
    public ClientPlayNetworkHandlerMixin() {
        super();
    }
    
    @Inject(at = { @At("TAIL") }, method = { "onGameJoin" })
    private void onGameJoin(final GameJoinS2CPacket gameJoinS2CPacket, final CallbackInfo callbackInfo) {
        MeteorClient.f32301 = false;
        MeteorClient.eventBus.post((Object)c34429.m34500());
    }
    
    @Inject(at = { @At("HEAD") }, method = { "sendPacket" }, cancellable = true)
    public void onSendPacket(final Packet packet, final CallbackInfo callbackInfo) {
        final c32410 m34469 = c34429.m34469(packet);
        MeteorClient.eventBus.post((Object)m34469);
        if (m34469.m32676()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(at = { @At("HEAD") }, method = { "onPlaySound" })
    private void onPlaySound(final PlaySoundS2CPacket playSoundS2CPacket, final CallbackInfo callbackInfo) {
        MeteorClient.eventBus.post((Object)c34429.m34467(playSoundS2CPacket));
    }
    
    @Inject(method = { "onChunkData" }, at = { @At("TAIL") })
    private void onChunkData(final ChunkDataS2CPacket chunkDataS2CPacket, final CallbackInfo callbackInfo) {
        MeteorClient.eventBus.post((Object)c34429.m34512(this.client.world.method_8497(chunkDataS2CPacket.getX(), chunkDataS2CPacket.getZ())));
    }
    
    @Inject(method = { "onContainerSlotUpdate" }, at = { @At("TAIL") })
    private void onContainerSlotUpdate(final ContainerSlotUpdateS2CPacket containerSlotUpdateS2CPacket, final CallbackInfo callbackInfo) {
        MeteorClient.eventBus.post((Object)c34429.m34528(containerSlotUpdateS2CPacket));
    }
    
    @Inject(method = { "onEntitiesDestroy" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;removeEntity(I)V") }, locals = LocalCapture.CAPTURE_FAILSOFT)
    private void onEntityDestroy(final EntitiesDestroyS2CPacket entitiesDestroyS2CPacket, final CallbackInfo callbackInfo, final int n, final int n2) {
        MeteorClient.eventBus.post((Object)c34429.m34522(this.client.world.getEntityById(n2)));
    }
    
    @Redirect(method = { "onExplosion" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V"))
    private void onExplosionVec3dAddProxy(final ClientPlayerEntity clientPlayerEntity, final Vec3d velocity) {
        if (clientPlayerEntity != this.client.player) {
            clientPlayerEntity.setVelocity(velocity);
        }
        final double n = velocity.x - clientPlayerEntity.getVelocity().x;
        final double n2 = velocity.y - clientPlayerEntity.getVelocity().y;
        final double n3 = velocity.z - clientPlayerEntity.getVelocity().z;
        final Velocity velocity2 = c34030.f34033.m34042(Velocity.class);
        clientPlayerEntity.setVelocity(clientPlayerEntity.getVelocity().x + n * velocity2.m35284(), clientPlayerEntity.getVelocity().y + n2 * velocity2.m35286(), clientPlayerEntity.getVelocity().z + n3 * velocity2.m35284());
    }
    
    @Inject(method = { "onItemPickupAnimation" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;getEntityById(I)Lnet/minecraft/entity/Entity;", ordinal = 0) })
    private void onItemPickupAnimation(final ItemPickupAnimationS2CPacket itemPickupAnimationS2CPacket, final CallbackInfo callbackInfo) {
        final Entity entityById = this.client.world.getEntityById(itemPickupAnimationS2CPacket.getEntityId());
        final Entity entityById2 = this.client.world.getEntityById(itemPickupAnimationS2CPacket.getCollectorEntityId());
        if (entityById instanceof ItemEntity && entityById2 == this.client.player) {
            MeteorClient.eventBus.post((Object)c34429.m34544(((ItemEntity)entityById).getStack(), itemPickupAnimationS2CPacket.getStackAmount()));
        }
    }
}
