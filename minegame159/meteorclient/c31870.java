package minegame159.meteorclient;

import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.*;

public class c31870 implements c34681<c31870>
{
    private static final String[] f37894;
    public static c31870 f37895;
    public double f37896;
    public c37042 f37897;
    public c37042 f37898;
    public c37042 f37899;
    public c37042 f37900;
    public c37042 f37901;
    public c37042 f37902;
    public c37042 f37903;
    public c37042 f37904;
    public c37042 f37905;
    public c37042 f37906;
    public c37042 f37907;
    public c37042 f37908;
    public c37042 f37909;
    public c37042 f37910;
    public c37042 f37911;
    public c37042 f37912;
    public c37042 f37913;
    public c37042 f37914;
    public c37042 f37915;
    public c37042 f37916;
    public c37042 f37917;
    public c37042 f37918;
    public c37042 f37919;
    public c37042 f37920;
    public c37042 f37921;
    public c37042 f37922;
    public c37042 f37923;
    public c37042 f37924;
    public c37042 f37925;
    public c37042 f37926;
    public c37042 f37927;
    public c37042 f37928;
    public c37042 f37929;
    public c37042 f37930;
    private Map<WindowType, c31871> f37931;
    
    public c31870() {
        super();
        this.f37896 = 2.0;
        this.f37897 = new c37042(255, 255, 255);
        this.f37898 = new c37042(255, 255, 255);
        this.f37899 = new c37042(45, 225, 45);
        this.f37900 = new c37042(20, 20, 20, 200);
        this.f37901 = new c37042(30, 30, 30, 200);
        this.f37902 = new c37042(40, 40, 40, 200);
        this.f37903 = new c37042(0, 0, 0, 225);
        this.f37904 = new c37042(10, 10, 10, 225);
        this.f37905 = new c37042(20, 20, 20, 225);
        this.f37906 = new c37042(45, 225, 45);
        this.f37907 = new c37042(70, 225, 70);
        this.f37908 = new c37042(200, 200, 200, 225);
        this.f37909 = new c37042(45, 225, 45);
        this.f37910 = new c37042(60, 225, 60);
        this.f37911 = new c37042(75, 225, 75);
        this.f37912 = new c37042(225, 45, 45);
        this.f37913 = new c37042(225, 60, 60);
        this.f37914 = new c37042(225, 75, 75);
        this.f37915 = new c37042(135, 0, 255);
        this.f37916 = new c37042(50, 50, 50);
        this.f37917 = new c37042(50, 50, 50);
        this.f37918 = new c37042(60, 60, 60);
        this.f37919 = new c37042(70, 70, 70);
        this.f37920 = new c37042(0, 150, 80);
        this.f37921 = new c37042(50, 50, 50);
        this.f37922 = new c37042(0, 255, 180);
        this.f37923 = new c37042(0, 240, 165);
        this.f37924 = new c37042(0, 225, 150);
        this.f37925 = new c37042(70, 70, 70);
        this.f37926 = new c37042(80, 80, 80);
        this.f37927 = new c37042(90, 90, 90);
        this.f37928 = new c37042(50, 50, 50);
        this.f37929 = new c37042(60, 60, 60);
        this.f37930 = new c37042(70, 70, 70);
        this.f37931 = new HashMap<WindowType, c31871>();
        c31870.f37895 = this;
    }
    
    public c31871 m37932(final WindowType windowType, final boolean b) {
        return this.f37931.computeIfAbsent(windowType, p1 -> new c31871(b, null));
    }
    
    public void m37936() {
        this.f37931.clear();
        c33436.f34122.m37303();
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putDouble("guiScale", this.f37896);
        compoundTag.put("text", (Tag)this.f37897.m34682());
        compoundTag.put("windowHeaderText", (Tag)this.f37897.m34682());
        compoundTag.put("loggedInText", (Tag)this.f37899.m34682());
        compoundTag.put("background", (Tag)this.f37900.m34682());
        compoundTag.put("backgroundHovered", (Tag)this.f37901.m34682());
        compoundTag.put("backgroundPressed", (Tag)this.f37902.m34682());
        compoundTag.put("outline", (Tag)this.f37903.m34682());
        compoundTag.put("outlineHovered", (Tag)this.f37904.m34682());
        compoundTag.put("outlinePressed", (Tag)this.f37905.m34682());
        compoundTag.put("checkbox", (Tag)this.f37906.m34682());
        compoundTag.put("checkboxPressed", (Tag)this.f37907.m34682());
        compoundTag.put("separator", (Tag)this.f37908.m34682());
        compoundTag.put("plus", (Tag)this.f37909.m34682());
        compoundTag.put("plusHovered", (Tag)this.f37910.m34682());
        compoundTag.put("plusPressed", (Tag)this.f37911.m34682());
        compoundTag.put("minus", (Tag)this.f37912.m34682());
        compoundTag.put("minusHovered", (Tag)this.f37913.m34682());
        compoundTag.put("minusPressed", (Tag)this.f37914.m34682());
        compoundTag.put("accent", (Tag)this.f37915.m34682());
        compoundTag.put("moduleBackground", (Tag)this.f37916.m34682());
        compoundTag.put("reset", (Tag)this.f37917.m34682());
        compoundTag.put("resetHovered", (Tag)this.f37918.m34682());
        compoundTag.put("resetPressed", (Tag)this.f37919.m34682());
        compoundTag.put("sliderLeft", (Tag)this.f37920.m34682());
        compoundTag.put("sliderRight", (Tag)this.f37921.m34682());
        compoundTag.put("sliderHandle", (Tag)this.f37922.m34682());
        compoundTag.put("sliderHandleHovered", (Tag)this.f37923.m34682());
        compoundTag.put("sliderHandlePressed", (Tag)this.f37924.m34682());
        compoundTag.put("colorEditHandle", (Tag)this.f37925.m34682());
        compoundTag.put("colorEditHandleHovered", (Tag)this.f37926.m34682());
        compoundTag.put("colorEditHandlePressed", (Tag)this.f37927.m34682());
        compoundTag.put("edit", (Tag)this.f37928.m34682());
        compoundTag.put("editHovered", (Tag)this.f37929.m34682());
        compoundTag.put("editPressed", (Tag)this.f37930.m34682());
        compoundTag.put("windowConfigs", (Tag)c33633.m39908((Map)this.f37931));
        return compoundTag;
    }
    
    public c31870 m37940(final CompoundTag compoundTag) {
        if (compoundTag.contains("guiScale")) {
            this.f37896 = compoundTag.getDouble("guiScale");
        }
        this.m37943(compoundTag, "text", (c34681)this.f37897);
        this.m37943(compoundTag, "windowHeaderText", (c34681)this.f37898);
        this.m37943(compoundTag, "loggedInText", (c34681)this.f37899);
        this.m37943(compoundTag, "background", (c34681)this.f37900);
        this.m37943(compoundTag, "backgroundHovered", (c34681)this.f37901);
        this.m37943(compoundTag, "backgroundPressed", (c34681)this.f37902);
        this.m37943(compoundTag, "outline", (c34681)this.f37903);
        this.m37943(compoundTag, "outlineHovered", (c34681)this.f37904);
        this.m37943(compoundTag, "outlinePressed", (c34681)this.f37905);
        this.m37943(compoundTag, "checkbox", (c34681)this.f37906);
        this.m37943(compoundTag, "checkboxPressed", (c34681)this.f37907);
        this.m37943(compoundTag, "separator", (c34681)this.f37908);
        this.m37943(compoundTag, "plus", (c34681)this.f37909);
        this.m37943(compoundTag, "plusHovered", (c34681)this.f37910);
        this.m37943(compoundTag, "plusPressed", (c34681)this.f37911);
        this.m37943(compoundTag, "minus", (c34681)this.f37912);
        this.m37943(compoundTag, "minusHovered", (c34681)this.f37913);
        this.m37943(compoundTag, "minusPressed", (c34681)this.f37914);
        this.m37943(compoundTag, "accent", (c34681)this.f37915);
        this.m37943(compoundTag, "reset", (c34681)this.f37917);
        this.m37943(compoundTag, "resetHovered", (c34681)this.f37918);
        this.m37943(compoundTag, "resetPressed", (c34681)this.f37919);
        this.m37943(compoundTag, "moduleBackground", (c34681)this.f37916);
        this.m37943(compoundTag, "sliderLeft", (c34681)this.f37920);
        this.m37943(compoundTag, "sliderRight", (c34681)this.f37921);
        this.m37943(compoundTag, "sliderHandle", (c34681)this.f37922);
        this.m37943(compoundTag, "sliderHandleHovered", (c34681)this.f37923);
        this.m37943(compoundTag, "sliderHandlePressed", (c34681)this.f37924);
        this.m37943(compoundTag, "colorEditHandle", (c34681)this.f37925);
        this.m37943(compoundTag, "colorEditHandleHovered", (c34681)this.f37926);
        this.m37943(compoundTag, "colorEditHandlePressed", (c34681)this.f37927);
        this.m37943(compoundTag, "edit", (c34681)this.f37928);
        this.m37943(compoundTag, "editHovered", (c34681)this.f37929);
        this.m37943(compoundTag, "editPressed", (c34681)this.f37930);
        this.f37931 = (Map<WindowType, c31871>)c33633.m39912(compoundTag.getCompound("windowConfigs"), (c33633.c38062)WindowType::valueOf, (c33633.c33634)this::m37949);
        return this;
    }
    
    private void m37943(final class_2487 class_2487, final String s, final c34681<?> c34681) {
        if (((CompoundTag)class_2487).contains(s)) {
            c34681.m34683(((CompoundTag)class_2487).getCompound(s));
        }
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m37940(compoundTag);
    }
    
    private /* synthetic */ c31871 m37949(final Tag tag) {
        return new c31871(false, null).m31889((CompoundTag)tag);
    }
    
    private /* synthetic */ c31871 m37952(final boolean b, final WindowType windowType) {
        return new c31871(b, null);
    }
    
    static {
        f37894 = new String[] { "guiScale", "text", "windowHeaderText", "loggedInText", "background", "backgroundHovered", "backgroundPressed", "outline", "outlineHovered", "outlinePressed", "checkbox", "checkboxPressed", "separator", "plus", "plusHovered", "plusPressed", "minus", "minusHovered", "minusPressed", "accent", "moduleBackground", "reset", "resetHovered", "resetPressed", "sliderLeft", "sliderRight", "sliderHandle", "sliderHandleHovered", "sliderHandlePressed", "colorEditHandle", "colorEditHandleHovered", "colorEditHandlePressed", "edit", "editHovered", "editPressed", "windowConfigs", "guiScale", "guiScale", "text", "windowHeaderText", "loggedInText", "background", "backgroundHovered", "backgroundPressed", "outline", "outlineHovered", "outlinePressed", "checkbox", "checkboxPressed", "separator", "plus", "plusHovered", "plusPressed", "minus", "minusHovered", "minusPressed", "accent", "reset", "resetHovered", "resetPressed", "moduleBackground", "sliderLeft", "sliderRight", "sliderHandle", "sliderHandleHovered", "sliderHandlePressed", "colorEditHandle", "colorEditHandleHovered", "colorEditHandlePressed", "edit", "editHovered", "editPressed", "windowConfigs" };
    }
    
    public class c31871 implements c34681<c31871>
    {
        private static final String[] f31872;
        private c40030 f31873;
        private boolean f31874;
        final /* synthetic */ c31870 f31875;
        
        private c31871(final c31870 f31875, final boolean f31876) {
            this.f31875 = f31875;
            super();
            this.f31873 = new c40030(-1.0, -1.0);
            this.f31874 = f31876;
        }
        
        public double m31876() {
            return this.f31873.f40033;
        }
        
        public double m31878() {
            return this.f31873.f40034;
        }
        
        public void m31880(final double n, final double n2) {
            this.f31873.m40035(n, n2);
        }
        
        public boolean m31884() {
            return this.f31874;
        }
        
        public void m31886(final boolean f31874) {
            this.f31874 = f31874;
            c33436.f34122.m37303();
        }
        
        @Override
        public CompoundTag m34682() {
            final CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("pos", (Tag)this.f31873.m34682());
            compoundTag.putBoolean("expanded", this.f31874);
            return compoundTag;
        }
        
        public c31871 m31889(final CompoundTag compoundTag) {
            this.f31873.m40041(compoundTag.getCompound("pos"));
            this.f31874 = compoundTag.getBoolean("expanded");
            return this;
        }
        
        public /* bridge */ Object m34683(final CompoundTag compoundTag) {
            return this.m31889(compoundTag);
        }
        
        c31871(final c31870 c31870, final boolean b, final c34261 c31871) {
            this(c31870, b);
        }
        
        static {
            f31872 = new String[] { "pos", "expanded", "pos", "expanded" };
        }
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
    
    static class c34261
    {
    }
}
