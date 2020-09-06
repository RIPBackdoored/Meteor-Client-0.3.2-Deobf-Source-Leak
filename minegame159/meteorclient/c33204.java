package minegame159.meteorclient;

import net.minecraft.client.*;
import meteorclient.util.*;
import net.minecraft.item.*;
import net.minecraft.container.*;
import net.minecraft.inventory.*;
import net.minecraft.client.network.*;
import net.minecraft.*;
import net.minecraft.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.screen.*;

public class c33204 extends c34014
{
    private static final String[] f34899;
    private static class_1799[] f34900;
    
    public c33204() {
        super("peek", "Lets you see whats inside shulker boxes.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final ClientPlayerEntity player = MinecraftClient.getInstance().player;
        ItemStack itemStack;
        if (EnchantUtil.m35628(((PlayerEntity)player).getMainHandStack().getItem())) {
            itemStack = ((PlayerEntity)player).getMainHandStack();
        }
        else {
            if (!EnchantUtil.m35628(((PlayerEntity)player).getOffHandStack().getItem())) {
                c31351.m31371("You must be holding a shulker box.", new Object[0]);
                return;
            }
            itemStack = ((PlayerEntity)player).getOffHandStack();
        }
        EnchantUtil.m35538(itemStack, (ItemStack[])c33204.f34900);
        MeteorClient.INSTANCE.f32306 = (Screen)new c33205(new ShulkerBoxContainer(0, ((PlayerEntity)player).inventory, (Inventory)new BasicInventory(c33204.f34900)), ((PlayerEntity)player).inventory, itemStack.getName());
    }
    
    static {
        f34899 = new String[] { "peek", "Lets you see whats inside shulker boxes.", "You must be holding a shulker box." };
        c33204.f34900 = (class_1799[])new ItemStack[27];
    }
    
    private static class c33205 extends class_495
    {
        public c33205(final ShulkerBoxContainer shulkerBoxContainer, final PlayerInventory playerInventory, final Text text) {
            super(shulkerBoxContainer, playerInventory, text);
        }
        
        public boolean mouseClicked(final double n, final double n2, final int n3) {
            return false;
        }
        
        public boolean mouseReleased(final double n, final double n2, final int n3) {
            return false;
        }
    }
}
