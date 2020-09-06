package minegame159.meteorclient.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.widget.*;
import org.spongepowered.asm.mixin.injection.*;
import it.unimi.dsi.fastutil.io.*;
import net.minecraft.nbt.*;
import java.io.*;
import net.minecraft.client.*;
import java.util.*;
import org.lwjgl.glfw.*;

@Mixin({ class_3872.class })
public class BookScreenMixin extends class_437
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    private class_3872.class_3931 field_17418;
    @Shadow
    private int field_17119;
    
    public BookScreenMixin(final Text text) {
        super(text);
    }
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        this.addButton((AbstractButtonWidget)new ButtonWidget(4, 4, 70, 16, "Copy", this::lambda$onInit$0));
    }
    
    private /* synthetic */ void lambda$onInit$0(final ButtonWidget buttonWidget) {
        final ListTag listTag = new ListTag();
        for (int i = 0; i < this.contents.method_17560(); ++i) {
            listTag.add((Object)new StringTag(this.contents.method_17561(i).asString()));
        }
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("pages", (Tag)listTag);
        compoundTag.putInt("currentPage", this.pageIndex);
        final FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
        final DataOutputStream dataOutputStream = new DataOutputStream((OutputStream)fastByteArrayOutputStream);
        try {
            NbtIo.write(compoundTag, (DataOutput)dataOutputStream);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        GLFW.glfwSetClipboardString(MinecraftClient.getInstance().window.getHandle(), (CharSequence)Base64.getEncoder().encodeToString(fastByteArrayOutputStream.array));
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Copy", "pages", "currentPage" };
    }
}
