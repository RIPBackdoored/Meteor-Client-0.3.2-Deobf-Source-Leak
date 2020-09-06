package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;

public enum MyPotion
{
    private static final String[] ENCRYPTED_STRINGS;
    
    Swiftness("Swiftness", 0, Potions.field_9005, (class_1792[])new Item[] { Items.field_8790, Items.field_8479 }), 
    SwiftnessLong("SwiftnessLong", 1, Potions.field_8983, (class_1792[])new Item[] { Items.field_8790, Items.field_8479, Items.field_8725 }), 
    SwiftnessStrong("SwiftnessStrong", 2, Potions.field_8966, (class_1792[])new Item[] { Items.field_8790, Items.field_8479, Items.field_8601 }), 
    Slowness("Slowness", 3, Potions.field_8996, (class_1792[])new Item[] { Items.field_8790, Items.field_8479, Items.field_8711 }), 
    SlownessLong("SlownessLong", 4, Potions.field_8989, (class_1792[])new Item[] { Items.field_8790, Items.field_8479, Items.field_8711, Items.field_8725 }), 
    SlownessStrong("SlownessStrong", 5, Potions.field_8976, (class_1792[])new Item[] { Items.field_8790, Items.field_8479, Items.field_8711, Items.field_8601 }), 
    JumpBoost("JumpBoost", 6, Potions.field_8979, (class_1792[])new Item[] { Items.field_8790, Items.field_8073 }), 
    JumpBoostLong("JumpBoostLong", 7, Potions.field_8971, (class_1792[])new Item[] { Items.field_8790, Items.field_8073, Items.field_8725 }), 
    JumpBoostStrong("JumpBoostStrong", 8, Potions.field_8998, (class_1792[])new Item[] { Items.field_8790, Items.field_8073, Items.field_8601 }), 
    Strength("Strength", 9, Potions.field_8978, (class_1792[])new Item[] { Items.field_8790, Items.field_8183 }), 
    StrengthLong("StrengthLong", 10, Potions.field_8965, (class_1792[])new Item[] { Items.field_8790, Items.field_8183, Items.field_8725 }), 
    StrengthStrong("StrengthStrong", 11, Potions.field_8993, (class_1792[])new Item[] { Items.field_8790, Items.field_8183, Items.field_8601 }), 
    Healing("Healing", 12, Potions.field_8963, (class_1792[])new Item[] { Items.field_8790, Items.field_8597 }), 
    HealingStrong("HealingStrong", 13, Potions.field_8980, (class_1792[])new Item[] { Items.field_8790, Items.field_8597, Items.field_8601 }), 
    Harming("Harming", 14, Potions.field_9004, (class_1792[])new Item[] { Items.field_8790, Items.field_8597, Items.field_8711 }), 
    HarmingStrong("HarmingStrong", 15, Potions.field_8973, (class_1792[])new Item[] { Items.field_8790, Items.field_8597, Items.field_8711, Items.field_8601 }), 
    Poison("Poison", 16, Potions.field_8982, (class_1792[])new Item[] { Items.field_8790, Items.field_8680 }), 
    PoisonLong("PoisonLong", 17, Potions.field_9002, (class_1792[])new Item[] { Items.field_8790, Items.field_8680, Items.field_8725 }), 
    PoisonStrong("PoisonStrong", 18, Potions.field_8972, (class_1792[])new Item[] { Items.field_8790, Items.field_8680, Items.field_8601 }), 
    Regeneration("Regeneration", 19, Potions.field_8986, (class_1792[])new Item[] { Items.field_8790, Items.field_8070 }), 
    RegenerationLong("RegenerationLong", 20, Potions.field_9003, (class_1792[])new Item[] { Items.field_8790, Items.field_8070, Items.field_8725 }), 
    RegenerationStrong("RegenerationStrong", 21, Potions.field_8992, (class_1792[])new Item[] { Items.field_8790, Items.field_8070, Items.field_8601 }), 
    FireResistance("FireResistance", 22, Potions.field_8987, (class_1792[])new Item[] { Items.field_8790, Items.field_8135 }), 
    FireResistanceLong("FireResistanceLong", 23, Potions.field_8969, (class_1792[])new Item[] { Items.field_8790, Items.field_8135, Items.field_8725 }), 
    WaterBreathing("WaterBreathing", 24, Potions.field_8994, (class_1792[])new Item[] { Items.field_8790, Items.field_8323 }), 
    WaterBreathingLong("WaterBreathingLong", 25, Potions.field_9001, (class_1792[])new Item[] { Items.field_8790, Items.field_8323, Items.field_8725 }), 
    NightVision("NightVision", 26, Potions.field_8968, (class_1792[])new Item[] { Items.field_8790, Items.field_8071 }), 
    NightVisionLong("NightVisionLong", 27, Potions.field_8981, (class_1792[])new Item[] { Items.field_8790, Items.field_8071, Items.field_8725 }), 
    Invisibility("Invisibility", 28, Potions.field_8997, (class_1792[])new Item[] { Items.field_8790, Items.field_8071, Items.field_8711 }), 
    InvisibilityLong("InvisibilityLong", 29, Potions.field_9000, (class_1792[])new Item[] { Items.field_8790, Items.field_8071, Items.field_8711, Items.field_8725 }), 
    TurtleMaster("TurtleMaster", 30, Potions.field_8990, (class_1792[])new Item[] { Items.field_8790, Items.field_8090 }), 
    TurtleMasterLong("TurtleMasterLong", 31, Potions.field_8988, (class_1792[])new Item[] { Items.field_8790, Items.field_8090, Items.field_8725 }), 
    TurtleMasterStrong("TurtleMasterStrong", 32, Potions.field_8977, (class_1792[])new Item[] { Items.field_8790, Items.field_8090, Items.field_8601 }), 
    SlowFalling("SlowFalling", 33, Potions.field_8974, (class_1792[])new Item[] { Items.field_8790, Items.field_8614 }), 
    SlowFallingLong("SlowFallingLong", 34, Potions.field_8964, (class_1792[])new Item[] { Items.field_8790, Items.field_8614, Items.field_8725 }), 
    Weakness("Weakness", 35, Potions.field_8975, (class_1792[])new Item[] { Items.field_8711 }), 
    WeaknessLong("WeaknessLong", 36, Potions.field_8970, (class_1792[])new Item[] { Items.field_8711, Items.field_8725 });
    
    public final ItemStack potion;
    public final class_1792[] ingredients;
    private static final /* synthetic */ MyPotion[] $VALUES;
    
    public static MyPotion[] values() {
        return MyPotion.$VALUES.clone();
    }
    
    public static MyPotion valueOf(final String s) {
        return Enum.valueOf(MyPotion.class, s);
    }
    
    private MyPotion(final String s, final int n, final class_1842 class_1842, final class_1792[] ingredients) {
        this.potion = PotionUtil.setPotion(new ItemStack((ItemConvertible)Items.field_8574), (Potion)class_1842);
        this.ingredients = ingredients;
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "Swiftness", "SwiftnessLong", "SwiftnessStrong", "Slowness", "SlownessLong", "SlownessStrong", "JumpBoost", "JumpBoostLong", "JumpBoostStrong", "Strength", "StrengthLong", "StrengthStrong", "Healing", "HealingStrong", "Harming", "HarmingStrong", "Poison", "PoisonLong", "PoisonStrong", "Regeneration", "RegenerationLong", "RegenerationStrong", "FireResistance", "FireResistanceLong", "WaterBreathing", "WaterBreathingLong", "NightVision", "NightVisionLong", "Invisibility", "InvisibilityLong", "TurtleMaster", "TurtleMasterLong", "TurtleMasterStrong", "SlowFalling", "SlowFallingLong", "Weakness", "WeaknessLong" };
        $VALUES = new MyPotion[] { MyPotion.Swiftness, MyPotion.SwiftnessLong, MyPotion.SwiftnessStrong, MyPotion.Slowness, MyPotion.SlownessLong, MyPotion.SlownessStrong, MyPotion.JumpBoost, MyPotion.JumpBoostLong, MyPotion.JumpBoostStrong, MyPotion.Strength, MyPotion.StrengthLong, MyPotion.StrengthStrong, MyPotion.Healing, MyPotion.HealingStrong, MyPotion.Harming, MyPotion.HarmingStrong, MyPotion.Poison, MyPotion.PoisonLong, MyPotion.PoisonStrong, MyPotion.Regeneration, MyPotion.RegenerationLong, MyPotion.RegenerationStrong, MyPotion.FireResistance, MyPotion.FireResistanceLong, MyPotion.WaterBreathing, MyPotion.WaterBreathingLong, MyPotion.NightVision, MyPotion.NightVisionLong, MyPotion.Invisibility, MyPotion.InvisibilityLong, MyPotion.TurtleMaster, MyPotion.TurtleMasterLong, MyPotion.TurtleMasterStrong, MyPotion.SlowFalling, MyPotion.SlowFallingLong, MyPotion.Weakness, MyPotion.WeaknessLong };
    }
}
