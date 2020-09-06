package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_742.class })
public class AbstractClientPlayerEntityMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    private static final Identifier ID;
    
    public AbstractClientPlayerEntityMixin() {
        super();
    }
    
    @Inject(method = { "getCapeTexture" }, at = { @At("HEAD") }, cancellable = true)
    private void onGetCapeTexture(final CallbackInfoReturnable<class_2960> callbackInfoReturnable) {
        final Identifier m35803 = c32253.m35803((PlayerEntity)this);
        if (m35803 != null) {
            callbackInfoReturnable.setReturnValue((Object)m35803);
        }
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "meteor-client", "cape.png" };
        ID = new Identifier("meteor-client", "cape.png");
    }
}
