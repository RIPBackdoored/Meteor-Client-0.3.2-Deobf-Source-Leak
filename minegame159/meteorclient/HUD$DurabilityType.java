package minegame159.meteorclient;

public enum DurabilityType
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final DurabilityType None;
    public static final DurabilityType Default;
    public static final DurabilityType Numbers;
    public static final DurabilityType Percentage;
    private static final /* synthetic */ DurabilityType[] $VALUES;
    
    public static DurabilityType[] values() {
        return DurabilityType.$VALUES.clone();
    }
    
    public static DurabilityType valueOf(final String s) {
        return Enum.valueOf(DurabilityType.class, s);
    }
    
    private DurabilityType(final String s, final int n) {
    }
    
    static {
        DurabilityType.ENCRYPTED_STRINGS = new String[] { "None", "Default", "Numbers", "Percentage" };
        DurabilityType.None = new DurabilityType("None", 0);
        DurabilityType.Default = new DurabilityType("Default", 1);
        DurabilityType.Numbers = new DurabilityType("Numbers", 2);
        DurabilityType.Percentage = new DurabilityType("Percentage", 3);
        DurabilityType.$VALUES = new DurabilityType[] { DurabilityType.None, DurabilityType.Default, DurabilityType.Numbers, DurabilityType.Percentage };
    }
}
