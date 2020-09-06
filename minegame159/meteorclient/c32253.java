package minegame159.meteorclient;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.texture.*;

public class c32253
{
    private static final String[] f35794;
    private static final String f35795 = "https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/capes/owners.txt";
    private static final String f35796 = "https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/";
    private static final Identifier f35797;
    private static final Map<UUID, String> f35798;
    private static final Map<String, c32254> f35799;
    private static final List<c32254> f35800;
    private static final List<c32254> f35801;
    
    public c32253() {
        super();
    }
    
    public static void m35802() {
        c31516.m31520();
        final String[] array;
        c31516.m31524(() -> c37229.m37237("https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/capes/owners.txt", s -> {
            s.split(" ");
            if (array.length >= 2) {
                c32253.f35798.put(UUID.fromString(array[0]), array[1]);
                if (!c32253.f35799.containsKey(array[1])) {
                    c32253.f35799.put(array[1], new c32254(array[1]));
                }
            }
        }));
        c31516.m31522();
    }
    
    public static Identifier m35803(final PlayerEntity playerEntity) {
        final String s = c32253.f35798.get(playerEntity.getUuid());
        if (s == null) {
            return null;
        }
        final c32254 c32254 = c32253.f35799.get(s);
        if (c32254.m32266()) {
            return (Identifier)c32254;
        }
        c32254.m32260();
        return c32253.f35797;
    }
    
    public static void m35807() {
        synchronized (c32253.f35800) {
            final Iterator<c32254> iterator = c32253.f35800.iterator();
            while (iterator.hasNext()) {
                iterator.next().m32262();
            }
            c32253.f35800.clear();
        }
        synchronized (c32253.f35801) {
            c32253.f35801.removeIf(c32254::m32264);
        }
    }
    
    private static /* synthetic */ void m35809() {
        final String[] array;
        c37229.m37237("https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/capes/owners.txt", s -> {
            s.split(" ");
            if (array.length >= 2) {
                c32253.f35798.put(UUID.fromString(array[0]), array[1]);
                if (!c32253.f35799.containsKey(array[1])) {
                    c32253.f35799.put(array[1], new c32254(array[1]));
                }
            }
        });
    }
    
    private static /* synthetic */ void m35810(final String s) {
        final String[] split = s.split(" ");
        if (split.length >= 2) {
            c32253.f35798.put(UUID.fromString(split[0]), split[1]);
            if (!c32253.f35799.containsKey(split[1])) {
                c32253.f35799.put(split[1], new c32254(split[1]));
            }
        }
    }
    
    static /* synthetic */ List m35813() {
        return c32253.f35801;
    }
    
    static /* synthetic */ List m35814() {
        return c32253.f35800;
    }
    
    static {
        f35794 = new String[] { "https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/capes/owners.txt", " ", "meteor-client", "empty_cape.png" };
        f35797 = new Identifier("meteor-client", "empty_cape.png");
        f35798 = new HashMap<UUID, String>();
        f35799 = new HashMap<String, c32254>();
        f35800 = new ArrayList<c32254>();
        f35801 = new ArrayList<c32254>();
    }
    
    private static class c32254 extends class_2960
    {
        private static final String[] f32255;
        private boolean f32256;
        private boolean f32257;
        private NativeImage f32258;
        private int f32259;
        
        public c32254(final String s) {
            super("meteor-client", "capes/" + s + ".png");
        }
        
        public void m32260() {
            if (this.f32256 || this.f32257 || this.f32259 > 0) {
                return;
            }
            this.f32257 = true;
            c31516.m31520();
            final InputStream inputStream;
            c31516.m31524(() -> {
                try {
                    c37229.m37232("https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/" + this.path);
                    if (inputStream == null) {
                        synchronized (c32253.f35801) {
                            c32253.f35801.add(this);
                            this.f32259 = 200;
                            this.f32257 = false;
                            return;
                        }
                    }
                    this.f32258 = NativeImage.read(inputStream);
                    synchronized (c32253.f35800) {
                        c32253.f35800.add(this);
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                return;
            });
            c31516.m31522();
        }
        
        public void m32262() {
            MinecraftClient.getInstance().getTextureManager().registerTexture((Identifier)this, (Texture)new NativeImageBackedTexture(this.f32258));
            this.f32258 = null;
            this.f32257 = false;
            this.f32256 = true;
        }
        
        public boolean m32264() {
            if (this.f32259 > 0) {
                --this.f32259;
                return false;
            }
            this.m32260();
            return true;
        }
        
        public boolean m32266() {
            return this.f32256;
        }
        
        public /* bridge */ int compareTo(final Object o) {
            return super.method_12833((Identifier)o);
        }
        
        private /* synthetic */ void m32268() {
            try {
                final InputStream m37232 = c37229.m37232("https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/" + this.path);
                if (m37232 == null) {
                    synchronized (c32253.f35801) {
                        c32253.f35801.add(this);
                        this.f32259 = 200;
                        this.f32257 = false;
                        return;
                    }
                }
                this.f32258 = NativeImage.read(m37232);
                synchronized (c32253.f35800) {
                    c32253.f35800.add(this);
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        static {
            f32255 = new String[] { "meteor-client", "capes/", ".png", "https://raw.githubusercontent.com/MeteorClient/meteorclient.github.io/master/" };
        }
    }
}
