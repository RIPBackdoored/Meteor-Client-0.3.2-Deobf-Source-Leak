package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Always;
    public static final Mode Legit;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Always", "Legit" };
        Mode.Always = new Mode("Always", 0);
        Mode.Legit = new Mode("Legit", 1);
        Mode.$VALUES = new Mode[] { Mode.Always, Mode.Legit };
    }
}
