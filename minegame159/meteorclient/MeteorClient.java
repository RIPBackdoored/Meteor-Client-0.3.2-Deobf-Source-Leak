package minegame159.meteorclient;

import net.fabricmc.api.*;
import meteorclient.font.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import me.zero.alpine.listener.*;
import net.minecraft.util.*;
import net.minecraft.*;
import java.util.function.*;
import net.fabricmc.fabric.api.client.keybinding.*;
import meteorclient.util.*;
import meteorclient.modules.*;
import java.awt.*;
import java.io.*;
import net.minecraft.entity.effect.*;
import me.zero.alpine.bus.*;
import net.fabricmc.loader.api.*;

public class MeteorClient implements ClientModInitializer, Listenable
{
    private static final String[] f32296;
    public static MeteorClient INSTANCE;
    public static final EventBus eventBus;
    public static CFont smallFont;
    public static CFont largeFont;
    public static boolean f32301;
    public static final File dir;
    private MinecraftClient mc;
    private FabricKeyBinding openClickGUI;
    public FabricKeyBinding shulkerPeek;
    public Screen f32306;
    @EventHandler
    private final Listener<c36575> f32307;
    
    public MeteorClient() {
        super();
        this.openClickGUI = FabricKeyBinding.Builder.create(new Identifier("meteor-client", "open-click-gui"), class_3675.class_307.field_1668, 344, "Meteor Client").build();
        this.shulkerPeek = FabricKeyBinding.Builder.create(new Identifier("meteor-client", "shulker-peek"), class_3675.class_307.field_1668, 342, "Meteor Client").build();
        this.f32307 = (Listener<c36575>)new Listener(c36575 -> {
            c32253.m35807();
            if (this.f32306 != null && this.mc.currentScreen == null) {
                this.mc.openScreen(this.f32306);
                this.f32306 = null;
            }
            if (this.openClickGUI.isPressed() && this.mc.currentScreen == null && c34739.m34743()) {
                this.openClickGUI();
            }
            this.mc.player.getActiveStatusEffects().values().removeIf(MeteorClient::m32335);
        }, new Predicate[0]);
    }
    
    public void onInitializeClient() {
        if (MeteorClient.INSTANCE == null) {
            KeyBindingRegistry.INSTANCE.addCategory("Meteor Client");
            KeyBindingRegistry.INSTANCE.register(this.openClickGUI);
            KeyBindingRegistry.INSTANCE.register(this.shulkerPeek);
            MeteorClient.INSTANCE = this;
            return;
        }
        System.out.println("Initializing Meteor Client.");
        this.mc = MinecraftClient.getInstance();
        EnchantUtil.mc = this.mc;
        EntityUtil.mc = this.mc;
        (c33436.f34122 = new c33436()).m37309();
        this.m32314();
        c34030.f34033 = new c34030();
        c38237.m38239();
        c34371.m34384();
        c38903.m38909();
        c32253.m35802();
        this.m32308();
        c35919.m35925();
        c34924.m34950();
        MeteorClient.eventBus.subscribe((Listenable)this);
        Runtime.getRuntime().addShutdownHook(new Thread(this::m32310));
    }
    
    public void m32308() {
        if (!c34030.f34033.m37309()) {
            c34030.f34033.m34042(Discordpresence.class).m35296(false);
        }
        c39017.f39019.m37309();
        c33410.f33412.m37309();
        c34371.f34373.m37309();
    }
    
    private void m32310() {
        c33436.f34122.m37303();
        c34030.f34033.m37303();
        c39017.f39019.m37303();
        c33410.f33412.m37303();
        c34371.f34373.m37303();
        c35919.m35930();
    }
    
    private void openClickGUI() {
        this.mc.openScreen((Screen)new c39298());
    }
    
    private void m32314() {
        final File[] array = MeteorClient.dir.exists() ? MeteorClient.dir.listFiles() : new File[0];
        File file = null;
        if (array != null) {
            for (final File file2 : array) {
                if (file2.getName().endsWith(".ttf") || file2.getName().endsWith(".TTF")) {
                    file = file2;
                    break;
                }
            }
        }
        if (file == null) {
            try {
                file = new File(MeteorClient.dir, "JetBrainsMono-Regular.ttf");
                file.getParentFile().mkdirs();
                final InputStream resourceAsStream = MeteorClient.class.getResourceAsStream("/assets/meteor-client/JetBrainsMono-Regular.ttf");
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                final byte[] array3 = new byte[255];
                int read;
                while ((read = resourceAsStream.read(array3)) > 0) {
                    fileOutputStream.write(array3, 0, read);
                }
                resourceAsStream.close();
                fileOutputStream.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            MeteorClient.smallFont = new CFont(Font.createFont(0, file).deriveFont(16.0f), true, true);
            MeteorClient.largeFont = new CFont(Font.createFont(0, file).deriveFont(32.0f), true, true);
            MeteorClient.largeFont.f33761 = 0.5;
        }
        catch (FontFormatException | IOException ex2) {
            final Throwable t;
            t.printStackTrace();
        }
    }
    
    public void m32325() {
        final File[] array = MeteorClient.dir.exists() ? MeteorClient.dir.listFiles() : new File[0];
        if (array != null) {
            for (final File file : array) {
                if (file.getName().endsWith(".ttf") || file.getName().endsWith(".TTF")) {
                    file.delete();
                }
            }
        }
    }
    
    public void m32329(final int n) {
        if (n == this.openClickGUI.getBoundKey().method_1444()) {
            this.openClickGUI();
        }
    }
    
    private /* synthetic */ void m32332(final c36575 c36575) {
        c32253.m35807();
        if (this.f32306 != null && this.mc.currentScreen == null) {
            this.mc.openScreen(this.f32306);
            this.f32306 = null;
        }
        if (this.openClickGUI.isPressed() && this.mc.currentScreen == null && c34739.m34743()) {
            this.openClickGUI();
        }
        this.mc.player.getActiveStatusEffects().values().removeIf(MeteorClient::m32335);
    }
    
    private static /* synthetic */ boolean m32335(final StatusEffectInstance statusEffectInstance) {
        return statusEffectInstance.getDuration() <= 0;
    }
    
    static {
        f32296 = new String[] { "meteor-client", "open-click-gui", "Meteor Client", "meteor-client", "shulker-peek", "Meteor Client", "Meteor Client", "Initializing Meteor Client.", ".ttf", ".TTF", "JetBrainsMono-Regular.ttf", "/assets/meteor-client/JetBrainsMono-Regular.ttf", ".ttf", ".TTF", "meteor-client" };
        eventBus = (EventBus)new EventManager();
        dir = new File(FabricLoader.getInstance().getGameDirectory(), "meteor-client");
    }
}
