package minegame159.meteorclient;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Simple;
    public static final Mode Smart;
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
        Mode.ENCRYPTED_STRINGS = new String[] { "Simple", "Smart" };
        Mode.Simple = new Mode("Simple", 0);
        Mode.Smart = new Mode("Smart", 1);
        Mode.$VALUES = new Mode[] { Mode.Simple, Mode.Smart };
    }
}
