package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;

public class c39292 extends c34014
{
    private static final String[] f39293;
    
    public c39292() {
        super("say", "Sends messages in chat.");
    }
    
    @Override
    public void m34018(final String[] array) {
        if (array.length != 0) {
            String string = array[0];
            for (int i = 1; i < array.length; ++i) {
                string = string + " " + array[i];
            }
            MinecraftClient.getInstance().getNetworkHandler().sendPacket((Packet)new ChatMessageC2SPacket(string));
        }
        else {
            c31351.m31371("Invalid text length.", new Object[0]);
        }
    }
    
    static {
        f39293 = new String[] { "say", "Sends messages in chat.", " ", "Invalid text length." };
    }
}
