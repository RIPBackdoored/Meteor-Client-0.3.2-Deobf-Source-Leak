package minegame159.meteorclient;

public enum Position
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Position ABOVE;
    public static final Position ON_TOP;
    private static final /* synthetic */ Position[] $VALUES;
    
    public static Position[] values() {
        return Position.$VALUES.clone();
    }
    
    public static Position valueOf(final String s) {
        return Enum.valueOf(Position.class, s);
    }
    
    private Position(final String s, final int n) {
    }
    
    static {
        Position.ENCRYPTED_STRINGS = new String[] { "ABOVE", "ON_TOP" };
        Position.ABOVE = new Position("ABOVE", 0);
        Position.ON_TOP = new Position("ON_TOP", 1);
        Position.$VALUES = new Position[] { Position.ABOVE, Position.ON_TOP };
    }
}
