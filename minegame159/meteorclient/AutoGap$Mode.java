package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Fire_Resistance;
    public static final Mode Regeneration;
    public static final Mode Constant;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Fire_Resistance", "Regeneration", "Constant" };
        Mode.Fire_Resistance = new Mode("Fire_Resistance", 0);
        Mode.Regeneration = new Mode("Regeneration", 1);
        Mode.Constant = new Mode("Constant", 2);
        Mode.$VALUES = new Mode[] { Mode.Fire_Resistance, Mode.Regeneration, Mode.Constant };
    }
}
