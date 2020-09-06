package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Lines;
    public static final Mode Sides;
    public static final Mode Both;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Lines", "Sides", "Both" };
        Mode.Lines = new Mode("Lines", 0);
        Mode.Sides = new Mode("Sides", 1);
        Mode.Both = new Mode("Both", 2);
        Mode.$VALUES = new Mode[] { Mode.Lines, Mode.Sides, Mode.Both };
    }
}
