package minegame159.meteorclient.mixin;

import net.minecraft.item.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.widget.*;
import org.spongepowered.asm.mixin.injection.*;
import java.util.*;
import net.minecraft.client.*;
import org.lwjgl.glfw.*;
import net.minecraft.*;
import java.util.function.*;
import net.minecraft.nbt.*;
import it.unimi.dsi.fastutil.io.*;
import java.io.*;

@Mixin({ class_473.class })
public abstract class BookEditScreenMixin extends class_437
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    @Final
    private ItemStack field_2835;
    @Shadow
    @Final
    private List<String> field_17116;
    @Shadow
    private int field_2840;
    @Shadow
    private int field_2833;
    @Shadow
    private boolean field_2837;
    @Shadow
    private int field_2829;
    
    @Shadow
    protected abstract void method_2413();
    
    public BookEditScreenMixin(final Text text) {
        super(text);
    }
    
    @Inject(method = { "init" }, at = { @At("TAIL") })
    private void onInit(final CallbackInfo callbackInfo) {
        this.addButton((AbstractButtonWidget)new ButtonWidget(4, 4, 70, 16, "Copy", this::lambda$onInit$0));
        this.addButton((AbstractButtonWidget)new ButtonWidget(4, 24, 70, 16, "Paste", this::lambda$onInit$1));
    }
    
    private /* synthetic */ void lambda$onInit$1(final ButtonWidget buttonWidget) {
        final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(GLFW.glfwGetClipboardString(MinecraftClient.getInstance().window.getHandle()))));
        try {
            final CompoundTag read = NbtIo.read(dataInputStream);
            final ListTag method_10612 = read.getList("pages", 8).method_10612();
            this.pages.clear();
            for (int i = 0; i < method_10612.size(); ++i) {
                this.pages.add(method_10612.getString(i));
            }
            if (this.pages.isEmpty()) {
                this.pages.add("");
            }
            this.currentPage = read.getInt("currentPage");
            this.dirty = true;
            this.updateButtons();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private /* synthetic */ void lambda$onInit$0(final ButtonWidget buttonWidget) {
        final ListTag listTag = new ListTag();
        this.pages.stream().map(class_2519::new).forEach(listTag::add);
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("pages", (Tag)listTag);
        compoundTag.putInt("currentPage", this.currentPage);
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
        ENCRYPTED_STRINGS = new String[] { "Copy", "Paste", "pages", "", "currentPage", "pages", "currentPage" };
    }
}
