package minegame159.meteorclient;

import net.minecraft.util.math.*;
import meteorclient.modules.*;
import net.minecraft.block.*;
import meteorclient.util.*;
import net.minecraft.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;

private class c35013
{
    public BlockPos f35014;
    public Direction f35015;
    final /* synthetic */ Packetmine f35016;
    
    private c35013(final Packetmine f35016) {
        this.f35016 = f35016;
        super();
    }
    
    public boolean m35017() {
        if (Packetmine.m37270(this.f35016).world.getBlockState(this.f35014).getBlock() == Blocks.field_10124) {
            return true;
        }
        if (EnchantUtil.m35567(Packetmine.m37272(this.f35016).player.x - 0.5, Packetmine.m37274(this.f35016).player.y + Packetmine.m37278(this.f35016).player.getEyeHeight(Packetmine.m37276(this.f35016).player.getPose()), Packetmine.m37280(this.f35016).player.z - 0.5, this.f35014.getX() + this.f35015.getOffsetX(), this.f35014.getY() + this.f35015.getOffsetY(), this.f35014.getZ() + this.f35015.getOffsetZ()) > Packetmine.m37282(this.f35016).interactionManager.getReachDistance()) {
            return true;
        }
        Packetmine.m37284(this.f35016).getNetworkHandler().sendPacket((Packet)new PlayerActionC2SPacket(class_2846.class_2847.field_12968, this.f35014, this.f35015));
        Packetmine.m37286(this.f35016).getNetworkHandler().sendPacket((Packet)new PlayerActionC2SPacket(class_2846.class_2847.field_12973, this.f35014, this.f35015));
        return false;
    }
    
    c35013(final Packetmine packetmine, final c33676.c33677 c33677) {
        this(packetmine);
    }
}
