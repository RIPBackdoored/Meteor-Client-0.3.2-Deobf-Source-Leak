package minegame159.meteorclient;

public enum Category
{
    private static final String[] ENCRYPTED_STRINGS;
    
    Combat("Combat", 0), 
    Player("Player", 1), 
    Movement("Movement", 2), 
    Render("Render", 3), 
    Misc("Misc", 4);
    
    private static final /* synthetic */ Category[] $VALUES;
    
    public static Category[] values() {
        return Category.$VALUES.clone();
    }
    
    public static Category valueOf(final String s) {
        return Enum.valueOf(Category.class, s);
    }
    
    private Category(final String s, final int n) {
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Combat", "Player", "Movement", "Render", "Misc" };
        $VALUES = new Category[] { Category.Combat, Category.Player, Category.Movement, Category.Render, Category.Misc };
    }
}
