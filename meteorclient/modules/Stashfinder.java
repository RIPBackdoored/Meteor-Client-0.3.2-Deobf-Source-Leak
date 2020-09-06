package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import java.util.*;
import com.google.common.reflect.*;
import net.minecraft.util.math.*;
import java.io.*;
import meteorclient.util.*;
import baritone.api.*;
import baritone.api.pathing.goals.*;
import minegame159.meteorclient.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.*;
import net.minecraft.util.*;
import com.mojang.blaze3d.platform.*;
import net.minecraft.block.entity.*;
import net.minecraft.client.toast.*;
import com.google.gson.*;

public class Stashfinder extends Module
{
    private static final String[] f35103;
    private static final Gson f35104;
    private final Settings f35105;
    private final Value<List<class_2591<?>>> f35106;
    private final Value<Integer> f35107;
    private final Value<Integer> f35108;
    private final Value<Boolean> f35109;
    public List<c32097.c32098> f35110;
    @EventHandler
    private final Listener<c33296> f35111;
    
    public Stashfinder() {
        super(Category.Misc, "stash-finder", "Searches loaded chunks for storage blocks. Saves to <your minecraft folder>/meteor-client");
        this.f35105 = this.f38675.m34572();
        this.f35106 = this.f35105.addValue((Value<List<class_2591<?>>>)new c32920.c32921().m32928("storage-blocks").m32931("Select storage blocks to search for.").m32934(Arrays.asList(c32920.f35246)).m32943());
        this.f35107 = this.f35105.addValue((Value<Integer>)new c32369.c32370().m32381("minimum-storage-cont").m32384("Minimum storage block count required to record that chunk.").m32387(4).m32396(1).m32408());
        this.f35108 = this.f35105.addValue((Value<Integer>)new c32369.c32370().m32381("minimum-distance").m32384("Minimum distance in blocks from spawn required to record that chunk.").m32387(0).m32396(0).m32405(10000).m32408());
        this.f35109 = this.f35105.addValue((Value<Boolean>)new c34427.c34657().m34664("send-notifications").m34667("Send minecraft notifications when new stashes are found.").m34670(true).m34679());
        this.f35110 = new ArrayList<c32097.c32098>();
        this.f35111 = (Listener<c33296>)new Listener(this::m35164, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.m35119();
    }
    
    @Override
    public c31923 m38680() {
        this.f35110.sort(Comparator.comparingInt((ToIntFunction<? super c32097.c32098>)c32097::m35162));
        final c36715 c36715 = new c36715();
        final c38616 c36716 = c36715.m31937(new c38616("Clear")).m39632();
        c36715.m36739();
        final c36715 c36717 = new c36715();
        if (this.f35110.size() > 0) {
            c36715.m31937(c36717);
        }
        c36716.f38618 = this::m35158;
        this.m35112(c36717);
        return c36715;
    }
    
    private void m35112(final c36715 c36715) {
        for (final c32097.c32098 c36716 : this.f35110) {
            c36715.m31937(new c39081("Pos: " + c36716.f32101 + ", " + c36716.f32102));
            c36715.m31937(new c39081("Total: " + c36716.m32112()));
            c36715.m31937(new c38616("Open")).m39632().f38618 = this::m35154;
            c36715.m31937(new c38616("Goto")).m39632().f38618 = c32097::m35151;
            c36715.m31937(new c36419()).m39632().f36420 = this::m35146;
            c36715.m36739();
        }
    }
    
    private void m35119() {
        boolean b = false;
        final File m35142 = this.m35142();
        if (m35142.exists()) {
            try {
                final FileReader json = new FileReader(m35142);
                class c34615 extends TypeToken<List<c32097.c32098>>
                {
                    final /* synthetic */ Stashfinder f34616;
                    
                    c34615(final Stashfinder f34616) {
                        this.f34616 = f34616;
                        super();
                    }
                }
                this.f35110 = (List<c32097.c32098>)Stashfinder.f35104.fromJson(json, new c32097.c34615(this).getType());
                json.close();
                final Iterator<c32097.c32098> iterator = this.f35110.iterator();
                while (iterator.hasNext()) {
                    iterator.next().m32110();
                }
                b = true;
            }
            catch (Exception ex) {
                if (this.f35110 == null) {
                    this.f35110 = new ArrayList<c32097.c32098>();
                }
            }
        }
        final File m35143 = this.m35144();
        if (!b && m35143.exists()) {
            try {
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(m35143));
                bufferedReader.readLine();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    final String[] split = line.split(" ");
                    final c32097.c32098 c32098 = new c32097.c32098(new ChunkPos(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
                    c32098.f32103 = Integer.parseInt(split[2]);
                    c32098.f32105 = Integer.parseInt(split[3]);
                    c32098.f32106 = Integer.parseInt(split[4]);
                    c32098.f32107 = Integer.parseInt(split[5]);
                    c32098.f32108 = Integer.parseInt(split[6]);
                    c32098.f32109 = Integer.parseInt(split[7]);
                    this.f35110.add(c32098);
                }
                bufferedReader.close();
            }
            catch (Exception ex2) {
                if (this.f35110 == null) {
                    this.f35110 = new ArrayList<c32097.c32098>();
                }
            }
        }
    }
    
    private void m35131() {
        try {
            final File m35144 = this.m35144();
            m35144.getParentFile().mkdirs();
            final FileWriter fileWriter = new FileWriter(m35144);
            fileWriter.write("X,Z,Chests,Shulkers,EnderChests,Furnaces,DispensersDroppers,Hopper\n");
            final Iterator<c32097.c32098> iterator = this.f35110.iterator();
            while (iterator.hasNext()) {
                iterator.next().m32114((Writer)fileWriter);
            }
            fileWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void m35137() {
        try {
            final File m35142 = this.m35142();
            m35142.getParentFile().mkdirs();
            final FileWriter writer = new FileWriter(m35142);
            Stashfinder.f35104.toJson(this.f35110, writer);
            writer.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private File m35142() {
        return new File(new File(new File(MeteorClient.dir, "stashes"), EnchantUtil.m35577()), "stashes.json");
    }
    
    private File m35144() {
        return new File(new File(new File(MeteorClient.dir, "stashes"), EnchantUtil.m35577()), "stashes.csv");
    }
    
    private /* synthetic */ void m35146(final c32097.c32098 c32098, final c36715 c32099, final c36419 c32100) {
        if (this.f35110.remove(c32098)) {
            c32099.m31945();
            this.m35112(c32099);
            this.m35137();
            this.m35131();
        }
    }
    
    private static /* synthetic */ void m35151(final c32097.c32098 c32098, final c38616 c32099) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath((Goal)new GoalXZ(c32098.f32101, c32098.f32102));
    }
    
    private /* synthetic */ void m35154(final c32097.c32098 c32098, final c38616 c32099) {
        this.mc.openScreen((Screen)new c34172(c32098));
    }
    
    private /* synthetic */ void m35158(final c36715 c36715, final c38616 c36716) {
        this.f35110.clear();
        c36715.m31945();
    }
    
    private static /* synthetic */ int m35162(final c32097.c32098 c32098) {
        return -c32098.m32112();
    }
    
    private /* synthetic */ void m35164(final c33296 c33296) {
        final double n = Math.abs(c33296.f33297.getPos().x * 16);
        final double n2 = Math.abs(c33296.f33297.getPos().z * 16);
        if (Math.sqrt(n * n + n2 * n2) < this.f35108.m33466()) {
            return;
        }
        final c32097.c32098 c33297 = new c32097.c32098(c33296.f33297.getPos());
        for (final BlockEntity blockEntity : c33296.f33297.getBlockEntities().values()) {
            if (!this.f35106.m33466().contains(blockEntity.getType())) {
                continue;
            }
            if (blockEntity instanceof ChestBlockEntity) {
                final c32097.c32098 c33298 = c33297;
                ++c33298.f32103;
            }
            else if (blockEntity instanceof BarrelBlockEntity) {
                final c32097.c32098 c33299 = c33297;
                ++c33299.f32104;
            }
            else if (blockEntity instanceof ShulkerBoxBlockEntity) {
                final c32097.c32098 c33300 = c33297;
                ++c33300.f32105;
            }
            else if (blockEntity instanceof EnderChestBlockEntity) {
                final c32097.c32098 c33301 = c33297;
                ++c33301.f32106;
            }
            else if (blockEntity instanceof AbstractFurnaceBlockEntity) {
                final c32097.c32098 c33302 = c33297;
                ++c33302.f32107;
            }
            else if (blockEntity instanceof DispenserBlockEntity) {
                final c32097.c32098 c33303 = c33297;
                ++c33303.f32108;
            }
            else {
                if (!(blockEntity instanceof HopperBlockEntity)) {
                    continue;
                }
                final c32097.c32098 c33304 = c33297;
                ++c33304.f32109;
            }
        }
        if (c33297.m32112() >= this.f35107.m33466()) {
            c32097.c32098 c33305 = null;
            final int index = this.f35110.indexOf(c33297);
            if (index < 0) {
                this.f35110.add(c33297);
            }
            else {
                c33305 = this.f35110.set(index, c33297);
            }
            this.m35137();
            this.m35131();
            if (this.f35109.m33466() && (!c33297.equals((Object)c33305) || !c33297.m32117(c33305))) {
                class c34617 implements class_368
                {
                    private static final String[] f34618;
                    private long f34619;
                    private long f34620;
                    final /* synthetic */ Stashfinder f34621;
                    
                    c34617(final Stashfinder f34621) {
                        this.f34621 = f34621;
                        super();
                        this.f34620 = -1L;
                    }
                    
                    public class_368.class_369 method_1986(final ToastManager toastManager, final long f34620) {
                        if (this.f34620 == -1L) {
                            this.f34620 = f34620;
                        }
                        else {
                            this.f34619 += f34620 - this.f34620;
                        }
                        toastManager.getGame().getTextureManager().bindTexture(new Identifier("textures/gui/toasts.png"));
                        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 255.0f);
                        toastManager.blit(0, 0, 0, 32, 160, 32);
                        toastManager.getGame().textRenderer.draw("StashRecorder found stash.", 12.0f, 12.0f, -11534256);
                        return (this.f34619 >= 32000L) ? class_368.class_369.field_2209 : class_368.class_369.field_2210;
                    }
                    
                    static {
                        c34617.f34618 = new String[] { "textures/gui/toasts.png", "StashRecorder found stash." };
                    }
                }
                this.mc.getToastManager().add((Toast)new c32097.c34617(this));
            }
        }
    }
    
    static {
        f35103 = new String[] { "stash-finder", "Searches loaded chunks for storage blocks. Saves to <your minecraft folder>/meteor-client", "storage-blocks", "Select storage blocks to search for.", "minimum-storage-cont", "Minimum storage block count required to record that chunk.", "minimum-distance", "Minimum distance in blocks from spawn required to record that chunk.", "send-notifications", "Send minecraft notifications when new stashes are found.", "Clear", "Pos: ", ", ", "Total: ", "Open", "Goto", " ", "X,Z,Chests,Shulkers,EnderChests,Furnaces,DispensersDroppers,Hopper\n", "stashes", "stashes.json", "stashes", "stashes.csv" };
        f35104 = new GsonBuilder().setPrettyPrinting().create();
    }
}
