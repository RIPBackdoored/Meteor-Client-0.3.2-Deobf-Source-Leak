package minegame159.meteorclient;

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
