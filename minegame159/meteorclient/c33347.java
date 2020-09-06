package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.container.*;

public class c33347 extends c34014
{
    private static final String[] f33348;
    
    public c33347() {
        super("drop", "Drops things.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final MinecraftClient instance = MinecraftClient.getInstance();
        if (instance.player.isSpectator()) {
            c31351.m31371("Can't drop items while in spectator.", new Object[0]);
            return;
        }
        if (array.length == 0) {
            this.m33349();
            return;
        }
        final String lowerCase = array[0].toLowerCase();
        switch (lowerCase) {
            case "hand": {
                instance.player.dropSelectedItem(true);
                break;
            }
            case "offhand": {
                c31671.m31675(c31671.m31693(45), 1, SlotActionType.field_7795);
                break;
            }
            case "hotbar": {
                for (int i = 0; i < 9; ++i) {
                    c31671.m31675(c31671.m31693(i), 1, SlotActionType.field_7795);
                }
                break;
            }
            case "inventory": {
                for (int j = 9; j < instance.player.inventory.main.size(); ++j) {
                    c31671.m31675(c31671.m31693(j), 1, SlotActionType.field_7795);
                }
                break;
            }
            case "all": {
                for (int k = 0; k < instance.player.inventory.main.size(); ++k) {
                    c31671.m31675(c31671.m31693(k), 1, SlotActionType.field_7795);
                }
                break;
            }
            default: {
                this.m33349();
                break;
            }
        }
    }
    
    private void m33349() {
        c31351.m31371("You need to select a mode. (hand, offhand, hotbar, inventory, all)", new Object[0]);
    }
    
    static {
        f33348 = new String[] { "drop", "Drops things.", "Can't drop items while in spectator.", "hand", "offhand", "hotbar", "inventory", "all", "You need to select a mode. (hand, offhand, hotbar, inventory, all)" };
    }
}
