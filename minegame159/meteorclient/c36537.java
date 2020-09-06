package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.world.explosion.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.*;
import net.minecraft.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.effect.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.damage.*;

public class c36537
{
    public static MinecraftClient f36538;
    
    public c36537() {
        super();
    }
    
    public static double m36539(final LivingEntity livingEntity, final Vec3d vec3d) {
        final double sqrt = Math.sqrt(livingEntity.squaredDistanceTo(vec3d));
        if (sqrt > 12.0) {
            return 0.0;
        }
        final double n = (1.0 - sqrt / 12.0) * Explosion.getExposure(vec3d, (Entity)livingEntity);
        double m36566 = m36566((Entity)livingEntity, m36571((PlayerEntity)livingEntity, DamageUtil.getDamageLeft((float)m36559((n * n + n) / 2.0 * 7.0 * 12.0 + 1.0), (float)livingEntity.getArmor(), (float)livingEntity.getAttributeInstance(EntityAttributes.ARMOR_TOUGHNESS).getValue())), new Explosion((World)c36537.f36538.world, (Entity)null, vec3d.x, vec3d.y, vec3d.z, 6.0f, false, class_1927.class_4179.field_18687));
        if (m36566 < 0.0) {
            m36566 = 0.0;
        }
        return m36566;
    }
    
    public static double m36546(final LivingEntity livingEntity, final Vec3d vec3d) {
        final double sqrt = Math.sqrt(livingEntity.squaredDistanceTo(vec3d));
        if (sqrt > 10.0) {
            return 0.0;
        }
        final double n = (1.0 - sqrt / 10.0) * Explosion.getExposure(vec3d, (Entity)livingEntity);
        double m36566 = m36566((Entity)livingEntity, m36571((PlayerEntity)livingEntity, DamageUtil.getDamageLeft((float)m36559((n * n + n) / 2.0 * 7.0 * 10.0 + 1.0), (float)livingEntity.getArmor(), (float)livingEntity.getAttributeInstance(EntityAttributes.ARMOR_TOUGHNESS).getValue())), new Explosion((World)c36537.f36538.world, (Entity)null, vec3d.x, vec3d.y, vec3d.z, 5.0f, false, class_1927.class_4179.field_18687));
        if (m36566 < 0.0) {
            m36566 = 0.0;
        }
        return m36566;
    }
    
    public static double m36553(final PlayerEntity playerEntity, final boolean b) {
        double n = 0.0;
        if (b) {
            if (playerEntity.getActiveItem().getItem() == Items.field_8802) {
                n += 7.0;
            }
            else if (playerEntity.getActiveItem().getItem() == Items.field_8845) {
                n += 4.0;
            }
            else if (playerEntity.getActiveItem().getItem() == Items.field_8371) {
                n += 6.0;
            }
            else if (playerEntity.getActiveItem().getItem() == Items.field_8528) {
                n += 5.0;
            }
            else if (playerEntity.getActiveItem().getItem() == Items.field_8091) {
                n += 4.0;
            }
            n *= 1.5;
        }
        if (playerEntity.getActiveItem().getEnchantments() != null && EnchantmentHelper.getEnchantments(playerEntity.getActiveItem()).containsKey(Enchantments.field_9118)) {
            n += 0.5 * EnchantmentHelper.getLevel(Enchantments.field_9118, playerEntity.getActiveItem()) + 0.5;
        }
        if (playerEntity.getActiveStatusEffects().containsKey(StatusEffects.field_5910)) {
            n += 3 * (Objects.requireNonNull(playerEntity.getStatusEffect(StatusEffects.field_5910)).getAmplifier() + 1);
        }
        double m36562 = m36562((Entity)playerEntity, m36571(playerEntity, DamageUtil.getDamageLeft((float)n, (float)playerEntity.getArmor(), (float)playerEntity.getAttributeInstance(EntityAttributes.ARMOR_TOUGHNESS).getValue())));
        if (m36562 < 0.0) {
            m36562 = 0.0;
        }
        return m36562;
    }
    
    private static double m36559(double min) {
        final Difficulty difficulty = c36537.f36538.world.getDifficulty();
        if (difficulty == Difficulty.field_5801) {
            min = 0.0;
        }
        if (difficulty == Difficulty.field_5805) {
            min = Math.min(min / 2.0 + 1.0, min);
        }
        if (difficulty == Difficulty.field_5807) {
            min = min * 3.0 / 2.0;
        }
        return min;
    }
    
    private static double m36562(final Entity entity, double n) {
        int protectionAmount = EnchantmentHelper.getProtectionAmount(entity.getArmorItems(), DamageSource.GENERIC);
        if (protectionAmount > 20) {
            protectionAmount = 20;
        }
        n *= 1.0 - protectionAmount / 25.0;
        if (n < 0.0) {
            n = 0.0;
        }
        return n;
    }
    
    private static double m36566(final Entity entity, double n, final Explosion explosion) {
        int protectionAmount = EnchantmentHelper.getProtectionAmount(entity.getArmorItems(), DamageSource.explosion(explosion));
        if (protectionAmount > 20) {
            protectionAmount = 20;
        }
        n *= 1.0 - protectionAmount / 25.0;
        if (n < 0.0) {
            n = 0.0;
        }
        return n;
    }
    
    private static double m36571(final PlayerEntity playerEntity, double n) {
        if (playerEntity.hasStatusEffect(StatusEffects.field_5907)) {
            n *= 1.0 - (playerEntity.getStatusEffect(StatusEffects.field_5907).getAmplifier() + 1) * 0.2;
        }
        if (n < 0.0) {
            n = 0.0;
        }
        return n;
    }
    
    static {
        c36537.f36538 = MinecraftClient.getInstance();
    }
}
