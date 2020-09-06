package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.client.render.entity.model.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_828.class })
public class EnchantingTableBlockEntityRendererMixin
{
    public EnchantingTableBlockEntityRendererMixin() {
        super();
    }
    
    @Redirect(method = { "render" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/BookModel;render(FFFFFF)V"))
    private void onRenderBookModelRenderProxy(final BookModel bookModel, final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        if (!c34030.f34033.m34042(Norender.class).m31748()) {
            bookModel.render(n, n2, n3, n4, n5, n6);
        }
    }
}
