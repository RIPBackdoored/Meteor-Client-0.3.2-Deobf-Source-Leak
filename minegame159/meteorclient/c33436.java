package minegame159.meteorclient;

import java.io.*;
import java.util.*;
import net.minecraft.nbt.*;

public class c33436 extends c37297<c33436>
{
    private static final String[] f34121;
    public static c33436 f34122;
    public final c32449 f34123;
    private String f34124;
    public c33437 f34125;
    public c31870 f34126;
    public boolean f34127;
    private Map<WindowType, c34213> f34128;
    private Map<Category, c37042> f34129;
    
    public c33436() {
        super(new File(MeteorClient.dir, "config.nbt"));
        this.f34123 = c32449.m32466("0.3.2 beta1");
        this.f34124 = ".";
        this.f34125 = new c33437(null);
        this.f34126 = new c31870();
        this.f34127 = true;
        this.f34128 = new HashMap<WindowType, c34213>();
        this.f34129 = new HashMap<Category, c37042>();
    }
    
    public void m34130(final String f34124) {
        this.f34124 = f34124;
        this.m37303();
    }
    
    public String m34133() {
        return this.f34124;
    }
    
    public c34213 m34135(final WindowType windowType, final boolean b) {
        return this.f34128.computeIfAbsent(windowType, p1 -> new c34213(b, null));
    }
    
    public void m34139(final Category category, final c37042 c37042) {
        this.f34129.put(category, c37042);
        this.m37303();
    }
    
    public c37042 m34143(final Category category) {
        return this.f34129.get(category);
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("version", this.f34123.toString());
        compoundTag.putString("prefix", this.f34124);
        compoundTag.put("autoCraft", (Tag)this.f34125.m34682());
        compoundTag.put("windowConfigs", (Tag)c33633.m39908((Map)this.f34128));
        compoundTag.put("categoryColors", (Tag)c33633.m39908((Map)this.f34129));
        compoundTag.put("guiConfig", (Tag)this.f34126.m34682());
        compoundTag.putBoolean("chatCommandsInfo", this.f34127);
        return compoundTag;
    }
    
    public c33436 m34146(final CompoundTag compoundTag) {
        this.f34124 = compoundTag.getString("prefix");
        this.f34125.m33452(compoundTag.getCompound("autoCraft"));
        this.f34128 = (Map<WindowType, c34213>)c33633.m39912(compoundTag.getCompound("windowConfigs"), (c33633.c38062)WindowType::valueOf, (c33633.c33634)this::m34153);
        this.f34129 = (Map<Category, c37042>)c33633.m39912(compoundTag.getCompound("categoryColors"), (c33633.c38062)Category::valueOf, (c33633.c33634)c33436::m34151);
        this.f34126.m37940(compoundTag.getCompound("guiConfig"));
        this.f34127 = (!compoundTag.contains("chatCommandsInfo") || compoundTag.getBoolean("chatCommandsInfo"));
        final c32449 m32466 = c32449.m32466(compoundTag.getString("version"));
        final c32449 m32467 = c32449.m32466("0.2.9");
        if (m32466.m32462(m32467) && this.f34123.m32458(m32467)) {
            MeteorClient.INSTANCE.m32325();
        }
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m34146(compoundTag);
    }
    
    private static /* synthetic */ c37042 m34151(final Tag tag) {
        return new c37042().m37060((CompoundTag)tag);
    }
    
    private /* synthetic */ c34213 m34153(final Tag tag) {
        return new c34213(false, null).m34231((CompoundTag)tag);
    }
    
    private /* synthetic */ c34213 m34156(final boolean b, final WindowType windowType) {
        return new c34213(b, null);
    }
    
    static {
        f34121 = new String[] { "config.nbt", "0.3.2 beta1", ".", "version", "prefix", "autoCraft", "windowConfigs", "categoryColors", "guiConfig", "chatCommandsInfo", "prefix", "autoCraft", "windowConfigs", "categoryColors", "guiConfig", "chatCommandsInfo", "chatCommandsInfo", "version", "0.2.9" };
    }
    
    public enum WindowType
    {
        private static final String[] ENCRYPTED_STRINGS;
        
        Combat("Combat", 0), 
        Player("Player", 1), 
        Movement("Movement", 2), 
        Render("Render", 3), 
        Misc("Misc", 4), 
        Setting("Setting", 5), 
        Profiles("Profiles", 6), 
        Search("Search", 7);
        
        private static final /* synthetic */ WindowType[] $VALUES;
        
        public static WindowType[] values() {
            return WindowType.$VALUES.clone();
        }
        
        public static WindowType valueOf(final String s) {
            return Enum.valueOf(WindowType.class, s);
        }
        
        private WindowType(final String s, final int n) {
        }
        
        static {
            ENCRYPTED_STRINGS = new String[] { "Combat", "Player", "Movement", "Render", "Misc", "Setting", "Profiles", "Search" };
            $VALUES = new WindowType[] { WindowType.Combat, WindowType.Player, WindowType.Movement, WindowType.Render, WindowType.Misc, WindowType.Setting, WindowType.Profiles, WindowType.Search };
        }
    }
    
    public class c34213 implements c34681<c34213>
    {
        private static final String[] f34214;
        private c40030 f34215;
        private boolean f34216;
        final /* synthetic */ c33436 f34217;
        
        private c34213(final c33436 f34217, final boolean f34218) {
            this.f34217 = f34217;
            super();
            this.f34215 = new c40030(-1.0, -1.0);
            this.f34216 = f34218;
        }
        
        public double m34218() {
            return this.f34215.f40033;
        }
        
        public double m34220() {
            return this.f34215.f40034;
        }
        
        public void m34222(final double n, final double n2) {
            this.f34215.m40035(n, n2);
            this.f34217.m37303();
        }
        
        public boolean m34226() {
            return this.f34216;
        }
        
        public void m34228(final boolean f34216) {
            this.f34216 = f34216;
            this.f34217.m37303();
        }
        
        @Override
        public CompoundTag m34682() {
            final CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("pos", (Tag)this.f34215.m34682());
            compoundTag.putBoolean("expanded", this.f34216);
            return compoundTag;
        }
        
        public c34213 m34231(final CompoundTag compoundTag) {
            this.f34215.m40041(compoundTag.getCompound("pos"));
            this.f34216 = compoundTag.getBoolean("expanded");
            return this;
        }
        
        public /* bridge */ Object m34683(final CompoundTag compoundTag) {
            return this.m34231(compoundTag);
        }
        
        c34213(final c33436 c33436, final boolean b, final c33736 c33437) {
            this(c33436, b);
        }
        
        static {
            f34214 = new String[] { "pos", "expanded", "pos", "expanded" };
        }
    }
    
    public class c33437 implements c34681<c33437>
    {
        private static final String[] f33438;
        private boolean f33439;
        private boolean f33440;
        final /* synthetic */ c33436 f33441;
        
        private c33437(final c33436 f33441) {
            this.f33441 = f33441;
            super();
            this.f33439 = true;
            this.f33440 = true;
        }
        
        public void m33442(final boolean f33439) {
            this.f33439 = f33439;
            this.f33441.m37303();
        }
        
        public boolean m33445() {
            return this.f33439;
        }
        
        public void m33447(final boolean f33440) {
            this.f33440 = f33440;
            this.f33441.m37303();
        }
        
        public boolean m33450() {
            return this.f33440;
        }
        
        @Override
        public CompoundTag m34682() {
            final CompoundTag compoundTag = new CompoundTag();
            compoundTag.putBoolean("craftByOne", this.f33439);
            compoundTag.putBoolean("stopWhenNoIngredients", this.f33440);
            return compoundTag;
        }
        
        public c33437 m33452(final CompoundTag compoundTag) {
            this.f33439 = compoundTag.getBoolean("craftByOne");
            this.f33440 = compoundTag.getBoolean("stopWhenNoIngredients");
            return this;
        }
        
        public /* bridge */ Object m34683(final CompoundTag compoundTag) {
            return this.m33452(compoundTag);
        }
        
        c33437(final c33436 c33436, final c33736 c33437) {
            this(c33436);
        }
        
        static {
            f33438 = new String[] { "craftByOne", "stopWhenNoIngredients", "craftByOne", "stopWhenNoIngredients" };
        }
    }
    
    static class c33736
    {
    }
}
