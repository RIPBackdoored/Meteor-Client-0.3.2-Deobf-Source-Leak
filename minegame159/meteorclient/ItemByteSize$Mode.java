package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Standard;
    public static final Mode True;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Standard", "True" };
        Mode.Standard = new Mode("Standard", 0);
        Mode.True = new Mode("True", 1);
        Mode.$VALUES = new Mode[] { Mode.Standard, Mode.True };
    }
}
