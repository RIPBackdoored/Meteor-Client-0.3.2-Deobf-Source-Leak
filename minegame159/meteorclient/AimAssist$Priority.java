package minegame159.meteorclient;

public enum Priority
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Priority LowestDistance;
    public static final Priority HighestDistance;
    public static final Priority LowestHealth;
    public static final Priority HighestHealth;
    private static final /* synthetic */ Priority[] $VALUES;
    
    public static Priority[] values() {
        return Priority.$VALUES.clone();
    }
    
    public static Priority valueOf(final String s) {
        return Enum.valueOf(Priority.class, s);
    }
    
    private Priority(final String s, final int n) {
    }
    
    static {
        Priority.ENCRYPTED_STRINGS = new String[] { "LowestDistance", "HighestDistance", "LowestHealth", "HighestHealth" };
        Priority.LowestDistance = new Priority("LowestDistance", 0);
        Priority.HighestDistance = new Priority("HighestDistance", 1);
        Priority.LowestHealth = new Priority("LowestHealth", 2);
        Priority.HighestHealth = new Priority("HighestHealth", 3);
        Priority.$VALUES = new Priority[] { Priority.LowestDistance, Priority.HighestDistance, Priority.LowestHealth, Priority.HighestHealth };
    }
}
