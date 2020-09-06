package minegame159.meteorclient;

public enum SortMode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final SortMode None;
    public static final SortMode Closest;
    public static final SortMode Furthest;
    private static final /* synthetic */ SortMode[] $VALUES;
    
    public static SortMode[] values() {
        return SortMode.$VALUES.clone();
    }
    
    public static SortMode valueOf(final String s) {
        return Enum.valueOf(SortMode.class, s);
    }
    
    private SortMode(final String s, final int n) {
    }
    
    static {
        SortMode.ENCRYPTED_STRINGS = new String[] { "None", "Closest", "Furthest" };
        SortMode.None = new SortMode("None", 0);
        SortMode.Closest = new SortMode("Closest", 1);
        SortMode.Furthest = new SortMode("Furthest", 2);
        SortMode.$VALUES = new SortMode[] { SortMode.None, SortMode.Closest, SortMode.Furthest };
    }
}
