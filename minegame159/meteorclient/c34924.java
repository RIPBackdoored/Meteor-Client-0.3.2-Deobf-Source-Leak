package minegame159.meteorclient;

import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.world.dimension.*;
import meteorclient.util.*;
import net.minecraft.nbt.*;
import net.minecraft.client.texture.*;
import java.io.*;
import net.minecraft.client.render.*;
import java.util.*;

public class c34924 extends c37297<c34924> implements Listenable, Iterable<c33820>
{
    private static final String[] f34925;
    public static final Map<String, class_1062> f34926;
    public static final c34924 f34927;
    private static final String[] f34928;
    private static final c37042 f34929;
    private static final c37042 f34930;
    private List<c33820> f34931;
    @EventHandler
    private final Listener<c33675> f34932;
    @EventHandler
    private final Listener<c37829> f34933;
    @EventHandler
    private final Listener<c36846> f34934;
    
    private c34924() {
        super(null);
        this.f34931 = new ArrayList<c33820>();
        this.f34932 = (Listener<c33675>)new Listener(c33675 -> this.m37309(), new Predicate[0]);
        this.f34933 = (Listener<c37829>)new Listener(c37829 -> {
            this.m37303();
            this.f34931.clear();
        }, new Predicate[0]);
        this.f34934 = (Listener<c36846>)new Listener(c36846 -> {
            for (final c33820 c36847 : this) {
                if (c36847.f33829) {
                    if (!this.m34941(c36847)) {
                        continue;
                    }
                    final Camera camera = MinecraftClient.getInstance().gameRenderer.getCamera();
                    final double m35606 = EnchantUtil.m35606(c36847.f33826, c36847.f33827, c36847.f33828);
                    if (m35606 > c36847.f33830) {
                        continue;
                    }
                    double n = 0.04;
                    if (m35606 > 15.0) {
                        n *= m35606 / 15.0;
                    }
                    double n2 = 1.0;
                    if (m35606 < 10.0) {
                        n2 = m35606 / 10.0;
                        if (n2 < 0.1) {
                            continue;
                        }
                    }
                    final int f37048 = c34924.f34929.f37048;
                    final int f37049 = c34924.f34930.f37048;
                    final c37042 f37050 = c34924.f34929;
                    f37050.f37048 *= (int)n2;
                    final c37042 f37051 = c34924.f34930;
                    f37051.f37048 *= (int)n2;
                    double n3 = c36847.f33826;
                    double n4 = c36847.f33827;
                    double n5 = c36847.f33828;
                    final double n6 = MinecraftClient.getInstance().options.viewDistance * 16;
                    if (m35606 > n6) {
                        final double n7 = c36847.f33826 - camera.getPos().x;
                        final double n8 = c36847.f33827 - camera.getPos().y;
                        final double n9 = c36847.f33828 - camera.getPos().z;
                        final double sqrt = Math.sqrt(n7 * n7 + n8 * n8 + n9 * n9);
                        final double n10 = n7 / sqrt;
                        final double n11 = n8 / sqrt;
                        final double n12 = n9 / sqrt;
                        final double n13 = n10 * n6;
                        final double n14 = n11 * n6;
                        final double n15 = n12 * n6;
                        n3 = camera.getPos().x + n13;
                        n4 = camera.getPos().y + n14;
                        n5 = camera.getPos().z + n15;
                        n = n / (m35606 / 15.0) * (n6 / 15.0);
                    }
                    c39098.m39100();
                    c39098.m39101(n3 + 0.5 - c36846.f36848, n4 - c36846.f36849, n5 + 0.5 - c36846.f36850);
                    c39098.m39101(0.0, -0.5 + c36847.f33831 - 1.0, 0.0);
                    c39098.m39105(-camera.getYaw(), 0.0, 1.0, 0.0);
                    c39098.m39105(camera.getPitch(), 1.0, 0.0, 0.0);
                    c39098.m39101(0.0, 0.5, 0.0);
                    c39098.m39110(-n * c36847.f33831, -n * c36847.f33831, n);
                    final String string = Math.round(m35606) + " blocks";
                    final double n16 = MeteorClient.largeFont.m33815(c36847.f33823) / 2.0;
                    final double n17 = MeteorClient.largeFont.m33815(string) / 2.0;
                    c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
                    c39337.m39347(-n16 - 1.0, -1.0 - MeteorClient.largeFont.m33813(), 0.0, -n16 - 1.0, 8.0 - MeteorClient.largeFont.m33813(), 0.0, n16 + 1.0, 8.0 - MeteorClient.largeFont.m33813(), 0.0, n16 + 1.0, -1.0 - MeteorClient.largeFont.m33813(), 0.0, c34924.f34929);
                    c39337.m39347(-n17 - 1.0, -1.0, 0.0, -n17 - 1.0, 8.0, 0.0, n17 + 1.0, 8.0, 0.0, n17 + 1.0, -1.0, 0.0, c34924.f34929);
                    c39337.m39346();
                    c36847.m33835(-8.0, 9.0, 0.0, n2);
                    MeteorClient.largeFont.m33789();
                    MeteorClient.largeFont.m33795(c36847.f33823, -n16, -MeteorClient.largeFont.m33813(), c34924.f34930);
                    MeteorClient.largeFont.m33795(string, -n17, 0.0, c34924.f34930);
                    MeteorClient.largeFont.m33793();
                    c39098.m39114();
                    c34924.f34929.f37048 = f37048;
                    c34924.f34930.f37048 = f37049;
                }
            }
        }, new Predicate[0]);
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    public void m34935(final c33820 c33820) {
        this.f34931.add(c33820);
        MeteorClient.eventBus.post((Object)c34429.m34536());
        this.m37303();
    }
    
    public void m34938(final c33820 c33820) {
        if (this.f34931.remove(c33820)) {
            MeteorClient.eventBus.post((Object)c34429.m34536());
            this.m37303();
        }
    }
    
    private boolean m34941(final c33820 c33820) {
        final DimensionType dimension = MinecraftClient.getInstance().player.dimension;
        return (c33820.f33832 && dimension == DimensionType.field_13072) || (c33820.f33833 && dimension == DimensionType.field_13076) || (c33820.f33834 && dimension == DimensionType.field_13078);
    }
    
    @Override
    public File m37311() {
        return new File(new File(MeteorClient.dir, "waypoints"), EnchantUtil.m35577() + ".nbt");
    }
    
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("waypoints", (Tag)c33633.m39899((Iterable)this.f34931));
        return compoundTag;
    }
    
    public c34924 m34947(final CompoundTag compoundTag) {
        this.f34931 = (List<c33820>)c33633.m39903(compoundTag.getList("waypoints", 10), (c33633.c33634)c34924::m34967);
        return this;
    }
    
    public Iterator<c33820> iterator() {
        return this.f34931.iterator();
    }
    
    public static void m34950() {
        final File file = new File(new File(MeteorClient.dir, "waypoints"), "icons");
        file.mkdirs();
        final String[] f34928 = c34924.f34928;
        for (int length = f34928.length, i = 0; i < length; ++i) {
            final File file2 = new File(file, f34928[i] + ".png");
            if (!file2.exists()) {
                m34959(file2);
            }
        }
        for (final File file3 : file.listFiles()) {
            if (file3.getName().endsWith(".png")) {
                try {
                    c34924.f34926.put(file3.getName().replace(".png", ""), (class_1062)new NativeImageBackedTexture(NativeImage.read((InputStream)new FileInputStream(file3))));
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private static void m34959(final File file) {
        try {
            final InputStream resourceAsStream = c34924.class.getResourceAsStream("/assets/meteor-client/waypoint-icons/" + file.getName());
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            final byte[] array = new byte[256];
            int read;
            while ((read = resourceAsStream.read(array)) > 0) {
                fileOutputStream.write(array, 0, read);
            }
            fileOutputStream.close();
            resourceAsStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m34947(compoundTag);
    }
    
    private static /* synthetic */ c33820 m34967(final Tag tag) {
        return new c33820().m33864((CompoundTag)tag);
    }
    
    private /* synthetic */ void m34969(final c36846 c36846) {
        for (final c33820 c36847 : this) {
            if (c36847.f33829) {
                if (!this.m34941(c36847)) {
                    continue;
                }
                final Camera camera = MinecraftClient.getInstance().gameRenderer.getCamera();
                final double m35606 = EnchantUtil.m35606(c36847.f33826, c36847.f33827, c36847.f33828);
                if (m35606 > c36847.f33830) {
                    continue;
                }
                double n = 0.04;
                if (m35606 > 15.0) {
                    n *= m35606 / 15.0;
                }
                double n2 = 1.0;
                if (m35606 < 10.0) {
                    n2 = m35606 / 10.0;
                    if (n2 < 0.1) {
                        continue;
                    }
                }
                final int f37048 = c34924.f34929.f37048;
                final int f37049 = c34924.f34930.f37048;
                final c37042 f37050 = c34924.f34929;
                f37050.f37048 *= (int)n2;
                final c37042 f37051 = c34924.f34930;
                f37051.f37048 *= (int)n2;
                double n3 = c36847.f33826;
                double n4 = c36847.f33827;
                double n5 = c36847.f33828;
                final double n6 = MinecraftClient.getInstance().options.viewDistance * 16;
                if (m35606 > n6) {
                    final double n7 = c36847.f33826 - camera.getPos().x;
                    final double n8 = c36847.f33827 - camera.getPos().y;
                    final double n9 = c36847.f33828 - camera.getPos().z;
                    final double sqrt = Math.sqrt(n7 * n7 + n8 * n8 + n9 * n9);
                    final double n10 = n7 / sqrt;
                    final double n11 = n8 / sqrt;
                    final double n12 = n9 / sqrt;
                    final double n13 = n10 * n6;
                    final double n14 = n11 * n6;
                    final double n15 = n12 * n6;
                    n3 = camera.getPos().x + n13;
                    n4 = camera.getPos().y + n14;
                    n5 = camera.getPos().z + n15;
                    n = n / (m35606 / 15.0) * (n6 / 15.0);
                }
                c39098.m39100();
                c39098.m39101(n3 + 0.5 - c36846.f36848, n4 - c36846.f36849, n5 + 0.5 - c36846.f36850);
                c39098.m39101(0.0, -0.5 + c36847.f33831 - 1.0, 0.0);
                c39098.m39105(-camera.getYaw(), 0.0, 1.0, 0.0);
                c39098.m39105(camera.getPitch(), 1.0, 0.0, 0.0);
                c39098.m39101(0.0, 0.5, 0.0);
                c39098.m39110(-n * c36847.f33831, -n * c36847.f33831, n);
                final String string = Math.round(m35606) + " blocks";
                final double n16 = MeteorClient.largeFont.m33815(c36847.f33823) / 2.0;
                final double n17 = MeteorClient.largeFont.m33815(string) / 2.0;
                c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
                c39337.m39347(-n16 - 1.0, -1.0 - MeteorClient.largeFont.m33813(), 0.0, -n16 - 1.0, 8.0 - MeteorClient.largeFont.m33813(), 0.0, n16 + 1.0, 8.0 - MeteorClient.largeFont.m33813(), 0.0, n16 + 1.0, -1.0 - MeteorClient.largeFont.m33813(), 0.0, c34924.f34929);
                c39337.m39347(-n17 - 1.0, -1.0, 0.0, -n17 - 1.0, 8.0, 0.0, n17 + 1.0, 8.0, 0.0, n17 + 1.0, -1.0, 0.0, c34924.f34929);
                c39337.m39346();
                c36847.m33835(-8.0, 9.0, 0.0, n2);
                MeteorClient.largeFont.m33789();
                MeteorClient.largeFont.m33795(c36847.f33823, -n16, -MeteorClient.largeFont.m33813(), c34924.f34930);
                MeteorClient.largeFont.m33795(string, -n17, 0.0, c34924.f34930);
                MeteorClient.largeFont.m33793();
                c39098.m39114();
                c34924.f34929.f37048 = f37048;
                c34924.f34930.f37048 = f37049;
            }
        }
    }
    
    private /* synthetic */ void m34990(final c37829 c37829) {
        this.m37303();
        this.f34931.clear();
    }
    
    private /* synthetic */ void m34993(final c33675 c33675) {
        this.m37309();
    }
    
    static {
        f34925 = new String[] { "waypoints", ".nbt", "waypoints", "waypoints", "waypoints", "icons", ".png", ".png", ".png", "", "/assets/meteor-client/waypoint-icons/", " blocks", "Square", "Circle", "Triangle", "Star", "Diamond" };
        f34926 = new HashMap<String, class_1062>();
        f34927 = new c34924();
        f34928 = new String[] { "Square", "Circle", "Triangle", "Star", "Diamond" };
        f34929 = new c37042(0, 0, 0, 75);
        f34930 = new c37042(255, 255, 255);
    }
}
