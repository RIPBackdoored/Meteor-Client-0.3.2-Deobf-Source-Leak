package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode All;
    public static final Mode Flatten;
    public static final Mode Smash;
    private static final /* synthetic */ Mode[] $VALUES;
    
    public static Mode[] values() {
        return Mode.$VALUES.clone();
    }
    
    public static Mode valueOf(final String s) {
        return Enum.valueOf(Mode.class, s);
    }
    
    private Mode(final String s, final int n) {
    }
    
    static {
        Mode.ENCRYPTED_STRINGS = new String[] { "All", "Flatten", "Smash" };
        Mode.All = new Mode("All", 0);
        Mode.Flatten = new Mode("Flatten", 1);
        Mode.Smash = new Mode("Smash", 2);
        Mode.$VALUES = new Mode[] { Mode.All, Mode.Flatten, Mode.Smash };
    }
}
