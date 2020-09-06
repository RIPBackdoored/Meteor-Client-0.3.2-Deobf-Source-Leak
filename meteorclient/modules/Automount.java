package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;
import net.minecraft.entity.vehicle.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.mob.*;
import java.util.*;

public class Automount extends Module
{
    private static final String[] f36699;
    private final Settings f36700;
    private final Value<Boolean> f36701;
    private final Value<Boolean> f36702;
    private final Value<Boolean> f36703;
    private final Value<Boolean> f36704;
    private final Value<Boolean> f36705;
    private final Value<Boolean> f36706;
    private final Value<Boolean> f36707;
    private final Value<Boolean> f36708;
    private final Value<Boolean> f36709;
    @EventHandler
    private final Listener<c36575> f36710;
    
    public Automount() {
        super(Category.Player, "auto-mount", "Mounts entities for you.");
        this.f36700 = this.f38675.m34572();
        this.f36701 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("donkey").m34667("DoNkE").m34670(false).m34679());
        this.f36702 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("llama").m34667("Llama").m34670(false).m34679());
        this.f36703 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("boat").m34667("Boat").m34670(false).m34679());
        this.f36704 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("minecart").m34667("Minecart").m34670(false).m34679());
        this.f36705 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("horse").m34667("Horse").m34670(false).m34679());
        this.f36706 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("pig").m34667("Pig").m34670(false).m34679());
        this.f36707 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("mule").m34667("Mule").m34670(false).m34679());
        this.f36708 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("skeleton-horse").m34667("Skeleton Horse").m34670(false).m34679());
        this.f36709 = this.f36700.addValue((Value<Boolean>)new c34427.c34657().m34664("check-saddle").m34667("Check if the entity has a saddle before mounting").m34670(false).m34679());
        this.f36710 = (Listener<c36575>)new Listener(this::m36711, new Predicate[0]);
    }
    
    private /* synthetic */ void m36711(final c36575 c36575) {
        if (this.mc.player.hasVehicle()) {
            return;
        }
        for (final Entity entity : this.mc.world.getEntities()) {
            if (this.mc.player.distanceTo(entity) > 4.0f) {
                continue;
            }
            if (this.f36701.m33466() && entity instanceof DonkeyEntity && (!this.f36709.m33466() || ((DonkeyEntity)entity).isSaddled())) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else if (this.f36702.m33466() && entity instanceof LlamaEntity) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else if (this.f36703.m33466() && entity instanceof BoatEntity) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else if (this.f36704.m33466() && entity instanceof MinecartEntity) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else if (this.f36705.m33466() && entity instanceof HorseEntity && (!this.f36709.m33466() || ((HorseEntity)entity).isSaddled())) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else if (this.f36706.m33466() && entity instanceof PigEntity && ((PigEntity)entity).isSaddled()) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else if (this.f36707.m33466() && entity instanceof MuleEntity && (!this.f36709.m33466() || ((MuleEntity)entity).isSaddled())) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
            else {
                if (!this.f36708.m33466() || !(entity instanceof SkeletonHorseEntity) || (this.f36709.m33466() && !((SkeletonHorseEntity)entity).isSaddled())) {
                    continue;
                }
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket(entity, Hand.field_5808));
            }
        }
    }
    
    static {
        f36699 = new String[] { "auto-mount", "Mounts entities for you.", "donkey", "DoNkE", "llama", "Llama", "boat", "Boat", "minecart", "Minecart", "horse", "Horse", "pig", "Pig", "mule", "Mule", "skeleton-horse", "Skeleton Horse", "check-saddle", "Check if the entity has a saddle before mounting" };
    }
}
