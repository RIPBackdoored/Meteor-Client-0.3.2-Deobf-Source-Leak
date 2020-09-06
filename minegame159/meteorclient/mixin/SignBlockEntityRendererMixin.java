package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import java.util.function.*;
import net.minecraft.*;
import meteorclient.modules.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.block.entity.*;

@Mixin({ class_837.class })
public class SignBlockEntityRendererMixin
{
    public SignBlockEntityRendererMixin() {
        super();
    }
    
    @Redirect(method = { "render" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/SignBlockEntity;getTextBeingEditedOnRow(ILjava/util/function/Function;)Ljava/lang/String;"))
    private String onRenderSignBlockEntityGetTextBeingEditedOnRowProxy(final class_2625 class_2625, final int n, final Function<class_2561, String> function) {
        if (c34030.f34033.m34042(Norender.class).m31750()) {
            return null;
        }
        return ((SignBlockEntity)class_2625).getTextBeingEditedOnRow(n, (Function)function);
    }
}
