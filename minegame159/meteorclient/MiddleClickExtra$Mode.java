package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.item.*;

public enum Mode
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final Mode Pearl;
    public static final Mode Bow;
    public static final Mode Gap;
    public static final Mode EGap;
    public static final Mode Rod;
    private final Item item;
    private static final /* synthetic */ Mode[] $VALUES;
    
    public static Mode[] values() {
        return Mode.$VALUES.clone();
    }
    
    public static Mode valueOf(final String s) {
        return Enum.valueOf(Mode.class, s);
    }
    
    private Mode(final String s, final int n, final class_1792 item) {
        this.item = (Item)item;
    }
    
    static /* synthetic */ Item access$000(final Mode mode) {
        return mode.item;
    }
    
    static {
        Mode.ENCRYPTED_STRINGS = new String[] { "Pearl", "Bow", "Gap", "EGap", "Rod" };
        Mode.Pearl = new Mode("Pearl", 0, Items.field_8634);
        Mode.Bow = new Mode("Bow", 1, Items.field_8107);
        Mode.Gap = new Mode("Gap", 2, Items.field_8463);
        Mode.EGap = new Mode("EGap", 3, Items.field_8367);
        Mode.Rod = new Mode("Rod", 4, Items.field_8378);
        Mode.$VALUES = new Mode[] { Mode.Pearl, Mode.Bow, Mode.Gap, Mode.EGap, Mode.Rod };
    }
}
