package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.container.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.function.*;
import net.minecraft.*;

public class c31671
{
    public static final int f31672 = 45;
    private static final MinecraftClient f31673;
    private static c32663 f31674;
    
    public c31671() {
        super();
    }
    
    public static void m31675(final int n, final int n2, final SlotActionType slotActionType) {
        c31671.f31673.interactionManager.method_2906(c31671.f31673.player.container.syncId, n, n2, slotActionType, (PlayerEntity)c31671.f31673.player);
    }
    
    public static c32663 m31679(final Item item) {
        c31671.f31674.f32664 = -1;
        c31671.f31674.f32665 = 0;
        for (int i = 0; i < 36; ++i) {
            final ItemStack invStack = c31671.f31673.player.inventory.getInvStack(i);
            if (invStack.getItem() == item) {
                if (!c31671.f31674.m32666()) {
                    c31671.f31674.f32664 = i;
                }
                final c32663 f31674 = c31671.f31674;
                f31674.f32665 += invStack.getCount();
            }
        }
        return c31671.f31674;
    }
    
    public static int m31683(final class_1792 class_1792, final Predicate<class_1799> predicate) {
        for (int i = 0; i < 36; ++i) {
            final ItemStack invStack = c31671.f31673.player.inventory.getInvStack(i);
            if (invStack.getItem() == class_1792 && predicate.test((class_1799)invStack)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int m31688(final class_1792 class_1792, final Predicate<class_1799> predicate) {
        for (int i = 0; i < 9; ++i) {
            final ItemStack invStack = c31671.f31673.player.inventory.getInvStack(i);
            if (invStack.getItem() == class_1792 && predicate.test((class_1799)invStack)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int m31693(final int n) {
        if (n < 9) {
            return 44 - (8 - n);
        }
        return n;
    }
    
    static {
        f31673 = MinecraftClient.getInstance();
        c31671.f31674 = new c32663();
    }
    
    public static class c32663
    {
        public int f32664;
        public int f32665;
        
        public c32663() {
            super();
        }
        
        public boolean m32666() {
            return this.f32664 != -1;
        }
    }
}
