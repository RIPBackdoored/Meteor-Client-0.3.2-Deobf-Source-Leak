package meteorclient.util;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.decoration.*;
import net.minecraft.entity.vehicle.*;
import net.minecraft.*;
import net.minecraft.entity.*;

public class EntityUtil
{
    public static MinecraftClient mc;
    
    public EntityUtil() {
        super();
    }
    
    public static boolean isPlayer(final Entity entity) {
        return entity instanceof PlayerEntity;
    }
    
    public static boolean isAnimal(final Entity entity) {
        return entity instanceof AnimalEntity || entity instanceof AmbientEntity || entity instanceof WaterCreatureEntity || entity instanceof GolemEntity || entity instanceof VillagerEntity;
    }
    
    public static boolean isMonster(final Entity entity) {
        return entity instanceof Monster;
    }
    
    public static boolean isItem(final Entity entity) {
        return entity instanceof ItemEntity;
    }
    
    public static boolean isCrystal(final Entity entity) {
        return entity instanceof EnderCrystalEntity;
    }
    
    public static boolean isBoat(final Entity entity) {
        return entity instanceof BoatEntity || entity instanceof AbstractMinecartEntity;
    }
    
    public static boolean m33631(final class_1299<?> class_1299) {
        return class_1299 != EntityType.field_6083 && class_1299 != EntityType.field_6122 && class_1299 != EntityType.field_6089 && class_1299 != EntityType.field_6133 && class_1299 != EntityType.field_6052 && class_1299 != EntityType.field_6124 && class_1299 != EntityType.field_6135 && class_1299 != EntityType.field_6082 && class_1299 != EntityType.field_6064 && class_1299 != EntityType.field_6045 && class_1299 != EntityType.field_6127 && class_1299 != EntityType.field_6112 && class_1299 != EntityType.field_6103 && class_1299 != EntityType.field_6044 && class_1299 != EntityType.field_6144;
    }
}
