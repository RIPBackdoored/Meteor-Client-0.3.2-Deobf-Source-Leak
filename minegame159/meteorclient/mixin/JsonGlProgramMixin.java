package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import net.minecraft.util.*;
import minegame159.meteorclient.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_280.class })
public class JsonGlProgramMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    
    public JsonGlProgramMixin() {
        super();
    }
    
    @Redirect(method = { "<init>" }, at = @At(value = "NEW", target = "net/minecraft/util/Identifier"))
    private static Identifier onInit(final String s) {
        if (c38335.f38338 && s.equals("shaders/program/my_entity_outline.json")) {
            return new Identifier("meteor-client", s);
        }
        return new Identifier(s);
    }
    
    @Redirect(method = { "getShader" }, at = @At(value = "NEW", target = "net/minecraft/util/Identifier"))
    private static Identifier onGetShader(final String s) {
        if (c38335.f38338 && s.equals("shaders/program/my_entity_sobel.fsh")) {
            return new Identifier("meteor-client", s);
        }
        return new Identifier(s);
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "shaders/program/my_entity_outline.json", "meteor-client", "shaders/program/my_entity_sobel.fsh", "meteor-client" };
    }
}
