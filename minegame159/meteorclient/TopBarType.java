package minegame159.meteorclient;

public enum TopBarType
{
    private static final String[] ENCRYPTED_STRINGS;
    
    Modules("Modules", 0, c39298::new), 
    Config("Config", 1, c36467::new), 
    Gui("Gui", 2, c38426::new), 
    Friends("Friends", 3, c32272::new), 
    Macros("Macros", 4, c33298::new), 
    Baritone("Baritone", 5, c37462::new), 
    Waypoints("Waypoints", 6, c32337::new);
    
    private final c37147 topBarScreenFactory;
    private static final /* synthetic */ TopBarType[] $VALUES;
    
    public static TopBarType[] values() {
        return TopBarType.$VALUES.clone();
    }
    
    public static TopBarType valueOf(final String s) {
        return Enum.valueOf(TopBarType.class, s);
    }
    
    private TopBarType(final String s, final int n, final c37147 topBarScreenFactory) {
        this.topBarScreenFactory = topBarScreenFactory;
    }
    
    public c36626 createScreen() {
        return this.topBarScreenFactory.m37148();
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Modules", "Config", "Gui", "Friends", "Macros", "Baritone", "Waypoints" };
        $VALUES = new TopBarType[] { TopBarType.Modules, TopBarType.Config, TopBarType.Gui, TopBarType.Friends, TopBarType.Macros, TopBarType.Baritone, TopBarType.Waypoints };
    }
    
    private interface c37147
    {
        c36626 m37148();
    }
}
