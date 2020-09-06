package minegame159.meteorclient;

public enum AlignmentY
{
    private static final String[] ENCRYPTED_STRINGS;
    
    Top("Top", 0), 
    Center("Center", 1), 
    Bottom("Bottom", 2);
    
    private static final /* synthetic */ AlignmentY[] $VALUES;
    
    public static AlignmentY[] values() {
        return AlignmentY.$VALUES.clone();
    }
    
    public static AlignmentY valueOf(final String s) {
        return Enum.valueOf(AlignmentY.class, s);
    }
    
    private AlignmentY(final String s, final int n) {
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Top", "Center", "Bottom" };
        $VALUES = new AlignmentY[] { AlignmentY.Top, AlignmentY.Center, AlignmentY.Bottom };
    }
}
