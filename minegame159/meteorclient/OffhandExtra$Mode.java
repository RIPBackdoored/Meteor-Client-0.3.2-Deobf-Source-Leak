package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Enchanted_Golden_Apple;
    public static final Mode Golden_Apple;
    public static final Mode Exp_Bottle;
    public static final Mode End_Crystal;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Enchanted_Golden_Apple", "Golden_Apple", "Exp_Bottle", "End_Crystal" };
        Mode.Enchanted_Golden_Apple = new Mode("Enchanted_Golden_Apple", 0);
        Mode.Golden_Apple = new Mode("Golden_Apple", 1);
        Mode.Exp_Bottle = new Mode("Exp_Bottle", 2);
        Mode.End_Crystal = new Mode("End_Crystal", 3);
        Mode.$VALUES = new Mode[] { Mode.Enchanted_Golden_Apple, Mode.Golden_Apple, Mode.Exp_Bottle, Mode.End_Crystal };
    }
}
