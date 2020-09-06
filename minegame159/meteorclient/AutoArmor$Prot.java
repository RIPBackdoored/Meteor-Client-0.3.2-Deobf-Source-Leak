package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.enchantment.*;

public enum Prot
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Prot Protection;
    public static final Prot Blast_Protection;
    public static final Prot Fire_Protection;
    public static final Prot Projectile_Protection;
    private final Enchantment enchantment;
    private static final /* synthetic */ Prot[] $VALUES;
    
    public static Prot[] values() {
        return Prot.$VALUES.clone();
    }
    
    public static Prot valueOf(final String s) {
        return Enum.valueOf(Prot.class, s);
    }
    
    private Prot(final String s, final int n, final class_1887 enchantment) {
        this.enchantment = (Enchantment)enchantment;
    }
    
    static /* synthetic */ Enchantment access$000(final Prot prot) {
        return prot.enchantment;
    }
    
    static {
        Prot.ENCRYPTED_STRINGS = new String[] { "Protection", "Blast_Protection", "Fire_Protection", "Projectile_Protection" };
        Prot.Protection = new Prot("Protection", 0, Enchantments.field_9111);
        Prot.Blast_Protection = new Prot("Blast_Protection", 1, Enchantments.field_9107);
        Prot.Fire_Protection = new Prot("Fire_Protection", 2, Enchantments.field_9095);
        Prot.Projectile_Protection = new Prot("Projectile_Protection", 3, Enchantments.field_9096);
        Prot.$VALUES = new Prot[] { Prot.Protection, Prot.Blast_Protection, Prot.Fire_Protection, Prot.Projectile_Protection };
    }
}
