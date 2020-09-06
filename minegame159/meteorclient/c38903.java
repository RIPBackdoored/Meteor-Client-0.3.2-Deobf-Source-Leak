package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.container.*;
import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import java.util.function.*;

public class c38903
{
    private static final MinecraftClient f38904;
    private static int f38905;
    public static final class_2371<class_1799> f38906;
    private static final Listener<c37956> f38907;
    private static final Listener<c31559> f38908;
    
    public c38903() {
        super();
    }
    
    public static void m38909() {
        MeteorClient.eventBus.subscribe((Listener)c38903.f38907);
        MeteorClient.eventBus.subscribe((Listener)c38903.f38908);
    }
    
    private static /* synthetic */ void m38910(final c31559 c31559) {
        if (c38903.f38905 == 1 && c31559.f31560 instanceof GenericContainerScreen) {
            c38903.f38905 = 2;
            return;
        }
        if (c38903.f38905 == 0) {
            return;
        }
        if (!(c38903.f38904.currentScreen instanceof GenericContainerScreen)) {
            return;
        }
        final GenericContainer genericContainer = (GenericContainer)((GenericContainerScreen)c38903.f38904.currentScreen).getContainer();
        if (genericContainer == null) {
            return;
        }
        final Inventory inventory = genericContainer.getInventory();
        for (int i = 0; i < 27; ++i) {
            c38903.f38906.set(i, (Object)inventory.getInvStack(i));
        }
        c38903.f38905 = 0;
    }
    
    private static /* synthetic */ void m38915(final c37956 c37956) {
        if (c37956.f37957.getBlock() instanceof EnderChestBlock && c38903.f38905 == 0) {
            c38903.f38905 = 1;
        }
    }
    
    static {
        f38904 = MinecraftClient.getInstance();
        c38903.f38906 = DefaultedList.ofSize(27, (Object)ItemStack.EMPTY);
        f38907 = new Listener(c37956 -> {
            if (c37956.f37957.getBlock() instanceof EnderChestBlock && c38903.f38905 == 0) {
                c38903.f38905 = 1;
            }
        }, new Predicate[0]);
        f38908 = new Listener(c31559 -> {
            if (c38903.f38905 == 1 && c31559.f31560 instanceof GenericContainerScreen) {
                c38903.f38905 = 2;
                return;
            }
            if (c38903.f38905 == 0) {
                return;
            }
            if (!(c38903.f38904.currentScreen instanceof GenericContainerScreen)) {
                return;
            }
            final GenericContainer genericContainer = (GenericContainer)((GenericContainerScreen)c38903.f38904.currentScreen).getContainer();
            if (genericContainer == null) {
                return;
            }
            final Inventory inventory = genericContainer.getInventory();
            for (int i = 0; i < 27; ++i) {
                c38903.f38906.set(i, (Object)inventory.getInvStack(i));
            }
            c38903.f38905 = 0;
        }, new Predicate[0]);
    }
}
