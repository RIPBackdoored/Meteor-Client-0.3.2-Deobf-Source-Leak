package minegame159.meteorclient;

public enum AlignmentX
{
    private static final String[] ENCRYPTED_STRINGS;
    
    Left("Left", 0), 
    Center("Center", 1), 
    Right("Right", 2);
    
    private static final /* synthetic */ AlignmentX[] $VALUES;
    
    public static AlignmentX[] values() {
        return AlignmentX.$VALUES.clone();
    }
    
    public static AlignmentX valueOf(final String s) {
        return Enum.valueOf(AlignmentX.class, s);
    }
    
    private AlignmentX(final String s, final int n) {
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Left", "Center", "Right" };
        $VALUES = new AlignmentX[] { AlignmentX.Left, AlignmentX.Center, AlignmentX.Right };
    }
}
