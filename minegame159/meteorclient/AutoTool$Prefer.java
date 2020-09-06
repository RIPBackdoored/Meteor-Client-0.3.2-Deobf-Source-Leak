package minegame159.meteorclient;

public enum Prefer
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Prefer None;
    public static final Prefer Fortune;
    public static final Prefer SilkTouch;
    private static final /* synthetic */ Prefer[] $VALUES;
    
    public static Prefer[] values() {
        return Prefer.$VALUES.clone();
    }
    
    public static Prefer valueOf(final String s) {
        return Enum.valueOf(Prefer.class, s);
    }
    
    private Prefer(final String s, final int n) {
    }
    
    static {
        Prefer.ENCRYPTED_STRINGS = new String[] { "None", "Fortune", "SilkTouch" };
        Prefer.None = new Prefer("None", 0);
        Prefer.Fortune = new Prefer("Fortune", 1);
        Prefer.SilkTouch = new Prefer("SilkTouch", 2);
        Prefer.$VALUES = new Prefer[] { Prefer.None, Prefer.Fortune, Prefer.SilkTouch };
    }
}
