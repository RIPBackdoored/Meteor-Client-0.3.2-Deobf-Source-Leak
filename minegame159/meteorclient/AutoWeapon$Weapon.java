package minegame159.meteorclient;

public enum Weapon
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Weapon Sword;
    public static final Weapon Axe;
    private static final /* synthetic */ Weapon[] $VALUES;
    
    public static Weapon[] values() {
        return Weapon.$VALUES.clone();
    }
    
    public static Weapon valueOf(final String s) {
        return Enum.valueOf(Weapon.class, s);
    }
    
    private Weapon(final String s, final int n) {
    }
    
    static {
        Weapon.ENCRYPTED_STRINGS = new String[] { "Sword", "Axe" };
        Weapon.Sword = new Weapon("Sword", 0);
        Weapon.Axe = new Weapon("Axe", 1);
        Weapon.$VALUES = new Weapon[] { Weapon.Sword, Weapon.Axe };
    }
}
