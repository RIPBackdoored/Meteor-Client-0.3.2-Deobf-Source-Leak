package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.util.math.*;
import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.network.*;

public class Criticals extends Module
{
    private static final String[] f36852;
    private boolean f36853;
    @EventHandler
    private final Listener<c33360> f36854;
    
    public Criticals() {
        super(Category.Combat, "criticals", "Critical attacks.");
        this.f36853 = false;
        this.f36854 = (Listener<c33360>)new Listener(this::m36865, new Predicate[0]);
    }
    
    private boolean m36855() {
        final boolean b = !this.mc.player.isSubmergedInWater() && !this.mc.player.isInLava() && !this.mc.player.isClimbing();
        return this.mc.player.onGround && b;
    }
    
    private double m36858(final Vec3d vec3d) {
        final double x = vec3d.x;
        final double y = vec3d.y;
        final double z = vec3d.z;
        final double sqrt = Math.sqrt(x * x + y * y + z * z);
        return Math.toDegrees(MathHelper.atan2(z / sqrt, x / sqrt)) - 90.0;
    }
    
    private /* synthetic */ void m36865(final c33360 c33360) {
        if (!this.m36855()) {
            return;
        }
        if (c34030.f34033.m34042(Nofall.class).m35315()) {
            this.f36853 = true;
            c34030.f34033.m34042(Nofall.class).m35300();
        }
        final double x = this.mc.player.x;
        final double y = this.mc.player.y;
        final double z = this.mc.player.z;
        final double radians = Math.toRadians(this.m36858(new Vec3d(this.mc.player.getVelocity().x, this.mc.player.getVelocity().y, this.mc.player.getVelocity().z)));
        if (Math.sqrt(this.mc.player.getVelocity().x * this.mc.player.getVelocity().x + this.mc.player.getVelocity().z * this.mc.player.getVelocity().z) > 0.20000000298023224) {
            this.mc.player.setVelocity(Math.sin(-radians) * 0.20000000298023224, this.mc.player.getVelocity().y, Math.cos(radians) * 0.20000000298023224);
        }
        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2829(x, y + 0.0625, z, false));
        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2829(x, y, z, false));
        if (this.f36853) {
            c34030.f34033.m34042(Nofall.class).m35300();
        }
    }
    
    static {
        f36852 = new String[] { "criticals", "Critical attacks." };
    }
}
