package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import minegame159.meteorclient.*;

public class Mountbypass extends Module
{
    private static final String[] f34997;
    private boolean f34998;
    @EventHandler
    private final Listener<c32410> f34999;
    
    public Mountbypass() {
        super(Category.Player, "mount-bypass", "Allows you to bypass illegal stacks and put chests on donkeys.");
        this.f34999 = (Listener<c32410>)new Listener(this::m35006, new Predicate[0]);
    }
    
    public void m35000(final c32410 c32410) {
        if (this.f34998) {
            this.f34998 = false;
            return;
        }
        if (!(c32410.f32411 instanceof PlayerInteractEntityC2SPacket)) {
            return;
        }
        final PlayerInteractEntityC2SPacket playerInteractEntityC2SPacket = (PlayerInteractEntityC2SPacket)c32410.f32411;
        if (playerInteractEntityC2SPacket.getType() == class_2824.class_2825.field_12873 && playerInteractEntityC2SPacket.getEntity((World)this.mc.world) instanceof AbstractDonkeyEntity) {
            c32410.m32674();
        }
    }
    
    public void m35004() {
        if (this.m35315()) {
            this.f34998 = true;
        }
    }
    
    private /* synthetic */ void m35006(final c32410 c32410) {
        if (c34030.f34033.m34049(Automountbypassdupe.class)) {
            return;
        }
        this.m35000(c32410);
    }
    
    static {
        f34997 = new String[] { "mount-bypass", "Allows you to bypass illegal stacks and put chests on donkeys." };
    }
}
