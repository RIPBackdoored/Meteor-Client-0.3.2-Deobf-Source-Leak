package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.enchantment.*;
import meteorclient.util.*;

public class c38014 extends c34014
{
    private static final String[] f38015;
    private final MinecraftClient f38016;
    
    public c38014() {
        super("enchant", "Enchants the currently held item with almost every enchantment (must be in creative)");
        this.f38016 = MinecraftClient.getInstance();
    }
    
    @Override
    public void m34018(final String[] array) {
        if (array.length == 0) {
            c31351.m31371("Please include a level.", new Object[0]);
            return;
        }
        if (this.f38016.player.isCreative()) {
            try {
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9105, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9112, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9107, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9117, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9128, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9131, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9129, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9124, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9095, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9126, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9130, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9122, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9106, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9125, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9110, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9120, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9114, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9100, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9101, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9132, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9103, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9096, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9111, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9116, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9098, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9127, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9118, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9123, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9115, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9118, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9097, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9119, Integer.parseInt(array[0]));
                EnchantUtil.m35648(this.f38016.player.getMainHandStack(), Enchantments.field_9109, Integer.parseInt(array[0]));
            }
            catch (NumberFormatException ex) {
                c31351.m31371("That is not a valid number. Try again.", new Object[0]);
            }
        }
        else {
            c31351.m31371("You must be in creative mode to use this.", new Object[0]);
        }
    }
    
    static {
        f38015 = new String[] { "enchant", "Enchants the currently held item with almost every enchantment (must be in creative)", "Please include a level.", "That is not a valid number. Try again.", "You must be in creative mode to use this." };
    }
}
