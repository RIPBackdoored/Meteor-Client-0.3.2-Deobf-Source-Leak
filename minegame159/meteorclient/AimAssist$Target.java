package minegame159.meteorclient;

public enum Target
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Target Eyes;
    public static final Target Body;
    public static final Target Feet;
    private static final /* synthetic */ Target[] $VALUES;
    
    public static Target[] values() {
        return Target.$VALUES.clone();
    }
    
    public static Target valueOf(final String s) {
        return Enum.valueOf(Target.class, s);
    }
    
    private Target(final String s, final int n) {
    }
    
    static {
        Target.ENCRYPTED_STRINGS = new String[] { "Eyes", "Body", "Feet" };
        Target.Eyes = new Target("Eyes", 0);
        Target.Body = new Target("Body", 1);
        Target.Feet = new Target("Feet", 2);
        Target.$VALUES = new Target[] { Target.Eyes, Target.Body, Target.Feet };
    }
}
