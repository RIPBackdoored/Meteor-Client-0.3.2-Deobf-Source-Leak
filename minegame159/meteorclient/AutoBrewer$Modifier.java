package minegame159.meteorclient;

public enum Modifier
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Modifier None;
    public static final Modifier Splash;
    public static final Modifier Lingering;
    private static final /* synthetic */ Modifier[] $VALUES;
    
    public static Modifier[] values() {
        return Modifier.$VALUES.clone();
    }
    
    public static Modifier valueOf(final String s) {
        return Enum.valueOf(Modifier.class, s);
    }
    
    private Modifier(final String s, final int n) {
    }
    
    static {
        Modifier.ENCRYPTED_STRINGS = new String[] { "None", "Splash", "Lingering" };
        Modifier.None = new Modifier("None", 0);
        Modifier.Splash = new Modifier("Splash", 1);
        Modifier.Lingering = new Modifier("Lingering", 2);
        Modifier.$VALUES = new Modifier[] { Modifier.None, Modifier.Splash, Modifier.Lingering };
    }
}
