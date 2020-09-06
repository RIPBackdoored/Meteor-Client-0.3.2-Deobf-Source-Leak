package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.network.*;

public class c34160 extends c34014
{
    private static final String[] f34161;
    
    public c34160() {
        super("hclip", "Lets your clip through blocks horizontally.");
    }
    
    @Override
    public void m34018(final String[] array) {
        if (array.length == 0) {
            this.m34168();
            return;
        }
        try {
            final double double1 = Double.parseDouble(array[0]);
            final ClientPlayerEntity player = MinecraftClient.getInstance().player;
            final Vec3d normalize = Vec3d.fromPolar(0.0f, player.yaw).normalize();
            player.updatePosition(player.x + normalize.x * double1, player.y, player.z + normalize.z * double1);
        }
        catch (NumberFormatException ex) {
            this.m34168();
        }
    }
    
    private void m34168() {
        c31351.m31371("Specify a number.", new Object[0]);
    }
    
    static {
        f34161 = new String[] { "hclip", "Lets your clip through blocks horizontally.", "Specify a number." };
    }
}
