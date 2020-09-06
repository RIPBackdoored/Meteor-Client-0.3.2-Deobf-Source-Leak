package minegame159.meteorclient;

public enum JumpIf
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final JumpIf Sprinting;
    public static final JumpIf Walking;
    public static final JumpIf Always;
    private static final /* synthetic */ JumpIf[] $VALUES;
    
    public static JumpIf[] values() {
        return JumpIf.$VALUES.clone();
    }
    
    public static JumpIf valueOf(final String s) {
        return Enum.valueOf(JumpIf.class, s);
    }
    
    private JumpIf(final String s, final int n) {
    }
    
    static {
        JumpIf.ENCRYPTED_STRINGS = new String[] { "Sprinting", "Walking", "Always" };
        JumpIf.Sprinting = new JumpIf("Sprinting", 0);
        JumpIf.Walking = new JumpIf("Walking", 1);
        JumpIf.Always = new JumpIf("Always", 2);
        JumpIf.$VALUES = new JumpIf[] { JumpIf.Sprinting, JumpIf.Walking, JumpIf.Always };
    }
}
