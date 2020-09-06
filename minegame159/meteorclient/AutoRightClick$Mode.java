package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Hold;
    public static final Mode Press;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Hold", "Press" };
        Mode.Hold = new Mode("Hold", 0);
        Mode.Press = new Mode("Press", 1);
        Mode.$VALUES = new Mode[] { Mode.Hold, Mode.Press };
    }
}
