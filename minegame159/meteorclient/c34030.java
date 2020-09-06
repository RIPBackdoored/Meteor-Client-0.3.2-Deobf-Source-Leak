package minegame159.meteorclient;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.io.*;
import java.util.*;
import net.minecraft.*;
import meteorclient.util.*;
import net.minecraft.util.*;
import java.util.function.*;
import meteorclient.setting.*;
import net.minecraft.nbt.*;
import meteorclient.modules.*;
import net.minecraft.client.*;

public class c34030 extends c37297<c34030> implements Listenable
{
    private static final String[] f34031;
    public static final Category[] f34032;
    public static c34030 f34033;
    private final Map<Class<? extends c38667>, c38667> f34034;
    private final Map<Category, List<c38667>> f34035;
    private final List<Module> f34036;
    private c38667 f34037;
    public boolean f34038;
    @EventHandler
    public Listener<c38944> f34039;
    @EventHandler
    private final Listener<c33675> f34040;
    @EventHandler
    private final Listener<c37829> f34041;
    
    public c34030() {
        super(new File(MeteorClient.dir, "modules.nbt"));
        this.f34034 = new HashMap<Class<? extends c38667>, c38667>();
        this.f34035 = new HashMap<Category, List<c38667>>();
        this.f34036 = new ArrayList<Module>();
        this.f34038 = false;
        this.f34039 = (Listener<c38944>)new Listener(c38944 -> {
            if (!c38944.f38946) {
                return;
            }
            if (this.f34037 != null) {
                this.f34037.m38702(c38944.f38945);
                c31351.m31357("Module (highlight)%s (default)bound to (highlight)%s(default).", this.f34037.f38672, EnchantUtil.m35582(c38944.f38945));
                this.f34037 = null;
                c38944.m32674();
                return;
            }
            if (!this.f34038 && MinecraftClient.getInstance().currentScreen == null) {
                for (final c38667 c38945 : this.f34034.values()) {
                    if (c38945.m38705() == c38944.f38945) {
                        c38945.m38687();
                        this.m37303();
                    }
                }
            }
        }, 201, new Predicate[0]);
        this.f34040 = (Listener<c33675>)new Listener(c33675 -> {
            synchronized (this.f34036) {
                final Iterator<Module> iterator = this.f34036.iterator();
                while (iterator.hasNext()) {
                    iterator.next().m35292();
                }
            }
        }, new Predicate[0]);
        this.f34041 = (Listener<c37829>)new Listener(c37829 -> {
            synchronized (this.f34036) {
                final Iterator<Module> iterator = this.f34036.iterator();
                while (iterator.hasNext()) {
                    iterator.next().m35294();
                }
            }
        }, new Predicate[0]);
        this.m34091();
        this.m34093();
        this.m34095();
        this.m34097();
        this.m34099();
        final Iterator<List<c38667>> iterator = this.f34035.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().sort(Comparator.comparing(c38667 -> c38667.f38672));
        }
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    public <T extends c38667> T m34042(final Class<T> clazz) {
        return (T)this.f34034.get(clazz);
    }
    
    public c38667 m34045(final String s) {
        for (final c38667 c38667 : this.f34034.values()) {
            if (c38667.f38671.equalsIgnoreCase(s)) {
                return c38667;
            }
        }
        return null;
    }
    
    public boolean m34049(final Class<? extends Module> clazz) {
        return this.m34042(clazz).m35315();
    }
    
    public List<c38667> m34052(final Category category) {
        return this.f34035.computeIfAbsent(category, p0 -> new ArrayList());
    }
    
    public Collection<c38667> m34055() {
        return this.f34034.values();
    }
    
    public List<Module> m34057() {
        synchronized (this.f34036) {
            return this.f34036;
        }
    }
    
    public void m34059(final c38667 f34037) {
        this.f34037 = f34037;
    }
    
    public List<class_3545<c38667, Integer>> m34062(final String s) {
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<class_3545<c38667, Integer>>();
        for (final c38667 c38667 : this.f34034.values()) {
            final int m35551 = EnchantUtil.m35551(c38667.f38672, s);
            if (m35551 > 0) {
                list.add(new Pair((Object)c38667, (Object)m35551));
            }
        }
        list.sort(Comparator.comparingInt((ToIntFunction<? super class_3545<c38667, Integer>>)c34030::m34115));
        return (List<class_3545<c38667, Integer>>)list;
    }
    
    public List<class_3545<c38667, Integer>> m34068(final String s) {
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<class_3545<c38667, Integer>>();
        for (final c38667 c38667 : this.f34034.values()) {
            final Iterator<Value<?>> iterator2 = c38667.f38675.iterator();
            while (iterator2.hasNext()) {
                final int m35551 = EnchantUtil.m35551(iterator2.next().f33458, s);
                if (m35551 > 0) {
                    list.add(new Pair((Object)c38667, (Object)m35551));
                    break;
                }
            }
        }
        list.sort(Comparator.comparingInt((ToIntFunction<? super class_3545<c38667, Integer>>)c34030::m34113));
        return (List<class_3545<c38667, Integer>>)list;
    }
    
    void m34075(final Module module) {
        synchronized (this.f34036) {
            if (!this.f34036.contains(module)) {
                this.f34036.add(module);
                MeteorClient.eventBus.post((Object)c34429.m34471());
            }
        }
    }
    
    void m34078(final Module module) {
        synchronized (this.f34036) {
            if (this.f34036.remove(module)) {
                MeteorClient.eventBus.post((Object)c34429.m34471());
            }
        }
    }
    
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        final ListTag listTag = new ListTag();
        final Iterator<c38667> iterator = this.m34055().iterator();
        while (iterator.hasNext()) {
            final CompoundTag m34682 = iterator.next().m34682();
            if (m34682 != null) {
                listTag.add((Object)m34682);
            }
        }
        compoundTag.put("modules", (Tag)listTag);
        return compoundTag;
    }
    
    public c34030 m34081(final CompoundTag compoundTag) {
        for (final CompoundTag compoundTag2 : compoundTag.getList("modules", 10)) {
            final c38667 m34045 = this.m34045(compoundTag2.getString("name"));
            if (m34045 != null) {
                m34045.m38691(compoundTag2);
            }
        }
        return this;
    }
    
    private void m34088(final c38667 c38667) {
        this.f34034.put(c38667.getClass(), c38667);
        this.m34052(c38667.category).add(c38667);
    }
    
    private void m34091() {
        this.m34088(new Auto32k());
        this.m34088(new Antifriendhit());
        this.m34088(new Criticals());
        this.m34088(new Autototem());
        this.m34088(new Bedaura());
        this.m34088(new Autoweapon());
        this.m34088(new Autolog());
        this.m34088(new Killaura());
        this.m34088(new Crystalaura());
        this.m34088(new Offhandextra());
        this.m34088(new Smartsurround());
        this.m34088(new Surround());
        this.m34088(new Trigger());
        this.m34088(new Autoexp());
        this.m34088(new Aimassist());
        this.m34088(new Autoarmor());
        this.m34088(new Antibed());
        this.m34088(new Totempopnotifier());
    }
    
    private void m34093() {
        this.m34088(new Autofish());
        this.m34088(new Deathposition());
        this.m34088(new Fastuse());
        this.m34088(new Autorespawn());
        this.m34088(new Antifire());
        this.m34088(new Automend());
        this.m34088(new Autogap());
        this.m34088(new Autoreplenish());
        this.m34088(new Antihunger());
        this.m34088(new Autotool());
        this.m34088(new Autoeat());
        this.m34088(new Automount());
        this.m34088(new Xpbottlethrower());
        this.m34088(new Middleclickextra());
        this.m34088(new Autodrop());
        this.m34088(new Autorightclick());
        this.m34088(new Portals());
        this.m34088(new Reach());
        this.m34088(new Potionspoof());
        this.m34088(new Liquidinteract());
        this.m34088(new Mountbypass());
        this.m34088(new Packetmine());
        this.m34088(new XCarry());
        this.m34088(new Buildheight());
        this.m34088(new Rotation());
    }
    
    private void m34095() {
        this.m34088(new Autosprint());
        this.m34088(new Autowalk());
        this.m34088(new Blink());
        this.m34088(new Fastladder());
        this.m34088(new Nofall());
        this.m34088(new Spider());
        this.m34088(new Autojump());
        this.m34088(new Flight());
        this.m34088(new Velocity());
        this.m34088(new Elytra());
        this.m34088(new Entitycontrol());
        this.m34088(new Highjump());
        this.m34088(new Speed());
        this.m34088(new Safewalk());
        this.m34088(new Parkour());
        this.m34088(new Step());
        this.m34088(new Jesus());
        this.m34088(new Airjump());
        this.m34088(new Antilevitation());
        this.m34088(new Scaffold());
        this.m34088(new Boatfly());
        this.m34088(new Noslow());
        this.m34088(new Invmove());
        this.m34088(new Anchor());
        this.m34088(new ClicktP());
    }
    
    private void m34097() {
        this.m34088(new HUD());
        this.m34088(new Fullbright());
        this.m34088(new Storageesp());
        this.m34088(new Xray());
        this.m34088(new Esp());
        this.m34088(new Freecam());
        this.m34088(new Tracers());
        this.m34088(new Nametags());
        this.m34088(new Inventoryviewer());
        this.m34088(new Holeesp());
        this.m34088(new Logoutspots());
        this.m34088(new Trajectories());
        this.m34088(new Chams());
        this.m34088(new Cameraclip());
        this.m34088(new Search());
        this.m34088(new Entityowner());
        this.m34088(new Norender());
        this.m34088(new Breadcrumbs());
        this.m34088(new Blockselection());
        this.m34088(new Friendcolor());
    }
    
    private void m34099() {
        this.m34088(new Longerchat());
        this.m34088(new Autosign());
        this.m34088(new Antiweather());
        this.m34088(new Autoreconnect());
        this.m34088(new Shulkertooltip());
        this.m34088(new Autoshearer());
        this.m34088(new Autonametag());
        this.m34088(new Bookbot());
        this.m34088(new Discordpresence());
        this.m34088(new EChestfarmer());
        this.m34088(new Middleclickfriend());
        this.m34088(new Stashfinder());
        this.m34088(new Autobrewer());
        this.m34088(new Autosmelter());
        this.m34088(new Annoy());
        this.m34088(new Spam());
        this.m34088(new UnfocusedCPU());
        this.m34088(new Itembytesize());
        this.m34088(new Antispam());
        this.m34088(new Packetcanceller());
        this.m34088(new Entitylogger());
        this.m34088(new EChestpreview());
        this.m34088(new Timer());
        this.m34088(new Suffix());
        this.m34088(new Messageaura());
        this.m34088(new Automountbypassdupe());
        this.m34088(new Nuker());
        this.m34088(new Soundblocker());
        this.m34088(new Antichunkban());
        this.m34088(new Announcer());
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m34081(compoundTag);
    }
    
    private /* synthetic */ void m34101(final c37829 c37829) {
        synchronized (this.f34036) {
            final Iterator<Module> iterator = this.f34036.iterator();
            while (iterator.hasNext()) {
                iterator.next().m35294();
            }
        }
    }
    
    private /* synthetic */ void m34105(final c33675 c33675) {
        synchronized (this.f34036) {
            final Iterator<Module> iterator = this.f34036.iterator();
            while (iterator.hasNext()) {
                iterator.next().m35292();
            }
        }
    }
    
    private /* synthetic */ void m34109(final c38944 c38944) {
        if (!c38944.f38946) {
            return;
        }
        if (this.f34037 != null) {
            this.f34037.m38702(c38944.f38945);
            c31351.m31357("Module (highlight)%s (default)bound to (highlight)%s(default).", this.f34037.f38672, EnchantUtil.m35582(c38944.f38945));
            this.f34037 = null;
            c38944.m32674();
            return;
        }
        if (!this.f34038 && MinecraftClient.getInstance().currentScreen == null) {
            for (final c38667 c38945 : this.f34034.values()) {
                if (c38945.m38705() == c38944.f38945) {
                    c38945.m38687();
                    this.m37303();
                }
            }
        }
    }
    
    private static /* synthetic */ int m34113(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private static /* synthetic */ int m34115(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private static /* synthetic */ List m34117(final Category category) {
        return new ArrayList();
    }
    
    private static /* synthetic */ String m34119(final c38667 c38667) {
        return c38667.f38672;
    }
    
    static {
        f34031 = new String[] { "modules.nbt", "modules", "modules", "name", "Module (highlight)%s (default)bound to (highlight)%s(default)." };
        f34032 = new Category[] { Category.Combat, Category.Player, Category.Movement, Category.Render, Category.Misc };
    }
}
