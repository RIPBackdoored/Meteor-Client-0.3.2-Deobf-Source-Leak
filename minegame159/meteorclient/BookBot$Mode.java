package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode File;
    public static final Mode Random;
    public static final Mode Ascii;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "File", "Random", "Ascii" };
        Mode.File = new Mode("File", 0);
        Mode.Random = new Mode("Random", 1);
        Mode.Ascii = new Mode("Ascii", 2);
        Mode.$VALUES = new Mode[] { Mode.File, Mode.Random, Mode.Ascii };
    }
}
