package minegame159.meteorclient;

public enum materialPreference
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final materialPreference None;
    public static final materialPreference Same;
    public static final materialPreference Best;
    private static final /* synthetic */ materialPreference[] $VALUES;
    
    public static materialPreference[] values() {
        return materialPreference.$VALUES.clone();
    }
    
    public static materialPreference valueOf(final String s) {
        return Enum.valueOf(materialPreference.class, s);
    }
    
    private materialPreference(final String s, final int n) {
    }
    
    static {
        materialPreference.ENCRYPTED_STRINGS = new String[] { "None", "Same", "Best" };
        materialPreference.None = new materialPreference("None", 0);
        materialPreference.Same = new materialPreference("Same", 1);
        materialPreference.Best = new materialPreference("Best", 2);
        materialPreference.$VALUES = new materialPreference[] { materialPreference.None, materialPreference.Same, materialPreference.Best };
    }
}
