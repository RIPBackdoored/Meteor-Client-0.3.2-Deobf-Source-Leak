package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.client.network.*;

public class c32865 extends c34014
{
    private static final String[] f32866;
    
    public c32865() {
        super("vclip", "Lets you clip through blocks vertically.");
    }
    
    @Override
    public void m34018(final String[] array) {
        if (array.length == 0) {
            this.m32867();
            return;
        }
        try {
            final double double1 = Double.parseDouble(array[0]);
            final ClientPlayerEntity player = MinecraftClient.getInstance().player;
            player.updatePosition(player.x, player.y + double1, player.z);
        }
        catch (NumberFormatException ex) {
            this.m32867();
        }
    }
    
    private void m32867() {
        c31351.m31371("Specify a number.", new Object[0]);
    }
    
    static {
        f32866 = new String[] { "vclip", "Lets you clip through blocks vertically.", "Specify a number." };
    }
}
