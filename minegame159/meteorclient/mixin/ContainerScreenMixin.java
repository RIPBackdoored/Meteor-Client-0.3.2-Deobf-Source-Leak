package minegame159.meteorclient.mixin;

import net.minecraft.container.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.gui.widget.*;
import org.spongepowered.asm.mixin.injection.*;
import meteorclient.util.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import meteorclient.*;
import minegame159.meteorclient.*;
import net.minecraft.nbt.*;
import net.minecraft.*;
import com.mojang.blaze3d.platform.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.render.*;
import java.util.*;
import net.minecraft.client.gui.*;
import meteorclient.modules.*;
import net.minecraft.util.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;

@Mixin({ class_465.class })
public abstract class ContainerScreenMixin<T extends class_1703> extends class_437 implements class_3936<T>
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    protected Slot field_2787;
    @Shadow
    protected int field_2776;
    @Shadow
    protected int field_2800;
    private static final Identifier TEXTURE;
    private static MinecraftClient mc;
    
    public ContainerScreenMixin(final Text text) {
        super(text);
    }
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        ContainerScreenMixin.mc = MinecraftClient.getInstance();
        if (ContainerScreenMixin.mc.player.getVehicle() instanceof AbstractDonkeyEntity) {
            this.addButton((AbstractButtonWidget)new ButtonWidget(this.x + 82, this.y + 2, 39, 12, "Dupe", ContainerScreenMixin::lambda$onInit$0));
        }
    }
    
    @Inject(method = { "render" }, at = { @At("TAIL") })
    private void onRender(final int n, final int n2, final float n3, final CallbackInfo callbackInfo) {
        if (this.focusedSlot != null && !this.focusedSlot.getStack().isEmpty()) {
            if (EnchantUtil.m35628(this.focusedSlot.getStack().getItem()) && MeteorClient.INSTANCE.shulkerPeek.isPressed()) {
                final CompoundTag subTag = this.focusedSlot.getStack().getSubTag("BlockEntityTag");
                if (subTag != null && subTag.contains("Items", 9)) {
                    final DefaultedList ofSize = DefaultedList.ofSize(27, (Object)ItemStack.EMPTY);
                    Inventories.fromTag(subTag, ofSize);
                    this.draw(ofSize, n, n2);
                }
            }
            if (this.focusedSlot.getStack().getItem() == Items.ENDER_CHEST && c34030.f34033.m34049(EChestpreview.class)) {
                this.draw(c38903.f38906, n, n2);
            }
        }
    }
    
    @Inject(method = { "drawMouseoverTooltip" }, at = { @At("HEAD") }, cancellable = true)
    private void onDrawMouseoverTooltip(final int n, final int n2, final CallbackInfo callbackInfo) {
        if (this.focusedSlot != null && !this.focusedSlot.getStack().isEmpty()) {
            if (EnchantUtil.m35628(this.focusedSlot.getStack().getItem()) && MeteorClient.INSTANCE.shulkerPeek.isPressed()) {
                callbackInfo.cancel();
            }
            else if (this.focusedSlot.getStack().getItem() == Items.ENDER_CHEST && c34030.f34033.m34049(EChestpreview.class)) {
                callbackInfo.cancel();
            }
        }
    }
    
    private void draw(final class_2371<class_1799> class_2371, final int n, final int n2) {
        GlStateManager.disableLighting();
        GlStateManager.disableDepthTest();
        GL11.glClear(256);
        this.drawBackground(n + 6, n2 + 6);
        DiffuseLighting.enableForItems();
        int n3 = 0;
        int n4 = 0;
        final Iterator iterator = ((DefaultedList)class_2371).iterator();
        while (iterator.hasNext()) {
            this.drawItem(iterator.next(), n + 6 + 8 + n4 * 18, n2 + 6 + 7 + n3 * 18);
            if (++n4 >= 9) {
                n4 = 0;
                ++n3;
            }
        }
        GlStateManager.enableLighting();
        GlStateManager.enableDepthTest();
    }
    
    private void drawItem(final ItemStack itemStack, final int n, final int n2) {
        ContainerScreenMixin.mc.getItemRenderer().renderGuiItem((LivingEntity)ContainerScreenMixin.mc.player, itemStack, n, n2);
        ContainerScreenMixin.mc.getItemRenderer().renderGuiItemOverlay(ContainerScreenMixin.mc.textRenderer, itemStack, n, n2, (String)null);
    }
    
    private void drawBackground(final int n, final int n2) {
        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        ContainerScreenMixin.mc.getTextureManager().bindTexture(ContainerScreenMixin.TEXTURE);
        final int n3 = 176;
        final int n4 = 67;
        DrawableHelper.blit(n, n2, 0, 0.0f, 0.0f, n3, n4, n4, n3);
    }
    
    private static /* synthetic */ void lambda$onInit$0(final AbstractDonkeyEntity abstractDonkeyEntity, final ButtonWidget buttonWidget) {
        c34030.f34033.m34042(Mountbypass.class).m35004();
        ContainerScreenMixin.mc.getNetworkHandler().sendPacket((Packet)new PlayerInteractEntityC2SPacket((Entity)abstractDonkeyEntity, Hand.field_5808, abstractDonkeyEntity.getPos().add((double)(abstractDonkeyEntity.getWidth() / 2.0f), (double)(abstractDonkeyEntity.getHeight() / 2.0f), (double)(abstractDonkeyEntity.getWidth() / 2.0f))));
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Dupe", "BlockEntityTag", "Items", "meteor-client", "container_3x9.png" };
        TEXTURE = new Identifier("meteor-client", "container_3x9.png");
    }
}
