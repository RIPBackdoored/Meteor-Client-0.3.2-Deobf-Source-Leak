package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Hopper;
    public static final Mode Dispenser;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Hopper", "Dispenser" };
        Mode.Hopper = new Mode("Hopper", 0);
        Mode.Dispenser = new Mode("Dispenser", 1);
        Mode.$VALUES = new Mode[] { Mode.Hopper, Mode.Dispenser };
    }
}
