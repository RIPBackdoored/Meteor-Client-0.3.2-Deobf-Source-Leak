package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode safe;
    public static final Mode suicide;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "safe", "suicide" };
        Mode.safe = new Mode("safe", 0);
        Mode.suicide = new Mode("suicide", 1);
        Mode.$VALUES = new Mode[] { Mode.safe, Mode.suicide };
    }
}
