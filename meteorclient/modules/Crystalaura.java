package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import net.minecraft.util.*;
import meteorclient.util.*;
import net.minecraft.network.*;
import net.minecraft.util.hit.*;
import net.minecraft.client.network.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.*;
import java.util.function.*;
import java.util.stream.*;
import minegame159.meteorclient.*;
import java.util.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.*;
import net.minecraft.entity.decoration.*;

public class Crystalaura extends Module
{
    private static final String[] f39923;
    private final Settings f39924;
    private final Settings f39925;
    private final Value<Double> f39926;
    private final Value<Double> f39927;
    private final Value<c39922.Mode> f39928;
    private final Value<c39922.Mode> f39929;
    private final Value<Boolean> f39930;
    private final Value<Boolean> f39931;
    private final Value<Double> f39932;
    private final Value<Double> f39933;
    private final Value<Boolean> f39934;
    private final Value<Double> f39935;
    private final Value<Boolean> f39936;
    private final Value<Boolean> f39937;
    private final Value<Integer> f39938;
    private final Value<Boolean> f39939;
    private final Value<Boolean> f39940;
    private final Value<Double> f39941;
    private final Value<Double> f39942;
    private final Value<Boolean> f39943;
    private final Value<Double> f39944;
    private final Value<Boolean> f39945;
    private int f39946;
    private int f39947;
    private Vec3d f39948;
    private double f39949;
    private BlockPos f39950;
    private Vec3d f39951;
    private double f39952;
    private boolean f39953;
    @EventHandler
    private final Listener<c36575> f39954;
    
    public Crystalaura() {
        super(Category.Combat, "crystal-aura", "Places and breaks end crystals automatically");
        this.f39924 = this.f38675.m34572();
        this.f39925 = this.f38675.m34588("Place");
        this.f39926 = this.f39924.addValue((Value<Double>)new c37033.c38947().m38959("place-range").m38962("The distance in a single direction the crystals get placed.").m38965(3.0).m38974(0.0).m38983(5.0).m38988());
        this.f39927 = this.f39924.addValue((Value<Double>)new c37033.c38947().m38959("break-range").m38962("The distance in a single direction the crystals get broken.").m38965(3.0).m38974(0.0).m38983(5.0).m38988());
        this.f39928 = this.f39924.addValue((Value<c39922.Mode>)new c36601.c36919<Enum>().m36926("place-mode").m36929("The way crystals are placed").m36932((Enum)c39922.Mode.safe).m36941());
        this.f39929 = this.f39924.addValue((Value<c39922.Mode>)new c36601.c36919<Enum>().m36926("break-mode").m36929("The way crystals are broken.").m36932((Enum)c39922.Mode.safe).m36941());
        this.f39930 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-switch").m34667("Switches to crystals for you.").m34670(false).m34679());
        this.f39931 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("spoof-change").m34667("Spoofs item change to crystal.").m34670(false).m34679());
        this.f39932 = this.f39925.addValue((Value<Double>)new c37033.c38947().m38959("min-damage").m38962("The minimum damage the crystal will place").m38965(5.5).m38988());
        this.f39933 = this.f39925.addValue((Value<Double>)new c37033.c38947().m38959("max-damage").m38962("The maximum self-damage allowed").m38965(3.0).m38988());
        this.f39934 = this.f39925.addValue((Value<Boolean>)new c34427.c34657().m34664("strict").m34667("Helps compatibility with some servers.").m34670(false).m34679());
        this.f39935 = this.f39925.addValue((Value<Double>)new c37033.c38947().m38959("min-health").m38962("The minimum health you have to be for it to place").m38965(15.0).m38988());
        this.f39936 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("ignore-walls").m34667("Attack through walls").m34670(true).m34679());
        this.f39937 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("place").m34667("Allow it to place cystals").m34670(true).m34679());
        this.f39938 = this.f39924.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("Delay ticks between placements.").m32387(2).m32396(0).m32405(10).m32408());
        this.f39939 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("smart-delay").m34667("Reduces crystal consumption when doing large amounts of damage.(Can tank performance on lower end PCs)").m34670(true).m34679());
        this.f39940 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("face-place").m34667("Will face place when target is below a certain health or their armour is low.").m34670(true).m34679());
        this.f39941 = this.f39924.addValue((Value<Double>)new c37033.c38947().m38959("face-place-health").m38962("The health required to face place").m38965(5.0).m38974(1.0).m38977(20.0).m38988());
        this.f39942 = this.f39924.addValue((Value<Double>)new c37033.c38947().m38959("face-place-durability").m38962("The durability required to face place (in percent)").m38965(2.0).m38974(1.0).m38977(100.0).m38983(100.0).m38988());
        this.f39943 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("spam-face-place").m34667("Places faster when someone is below the face place health (requires smart delay)").m34670(false).m34679());
        this.f39944 = this.f39924.addValue((Value<Double>)new c37033.c38947().m38959("damage-increase").m38962("The damage increase for smart delay to work.").m38965(5.0).m38974(0.0).m38977(20.0).m38988());
        this.f39945 = this.f39924.addValue((Value<Boolean>)new c34427.c34657().m34664("anti-weakness").m34667("Switches to tools when you have weakness").m34670(true).m34679());
        this.f39947 = this.f39938.m33466();
        this.f39952 = 0.0;
        this.f39953 = false;
        this.f39954 = (Listener<c36575>)new Listener(this::m39976, 100, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.mc.player.inventory.selectedSlot = this.f39946;
    }
    
    private void m39956(final Vec3d vec3d, final Hand hand) {
        final float yaw = this.mc.player.yaw;
        final float pitch = this.mc.player.pitch;
        final Vec3d add = vec3d.add(0.5, 0.5, 0.5);
        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(EnchantUtil.m35598(add), EnchantUtil.m35600(add), this.mc.player.onGround));
        this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, hand, new BlockHitResult(vec3d, Direction.field_11036, new BlockPos(vec3d), false));
        this.mc.player.swingHand(Hand.field_5808);
        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(yaw, pitch, this.mc.player.onGround));
        this.mc.player.yaw = yaw;
        this.mc.player.pitch = pitch;
    }
    
    private void m39964(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        this.f39948 = null;
        this.f39950 = this.mc.player.getBlockPos();
        for (double n = this.f39950.getX() - this.f39926.m33466(); n < this.f39950.getX() + this.f39926.m33466(); ++n) {
            for (double n2 = this.f39950.getZ() - this.f39926.m33466(); n2 < this.f39950.getZ() + this.f39926.m33466(); ++n2) {
                for (double n3 = this.f39950.getY() - 3; n3 < this.f39950.getY() + 3; ++n3) {
                    this.f39951 = new Vec3d(n, n3, n2);
                    if ((this.mc.world.getBlockState(new BlockPos(this.f39951)).getBlock() == Blocks.field_9987 || this.mc.world.getBlockState(new BlockPos(this.f39951)).getBlock() == Blocks.field_10540) && this.m39973(new BlockPos(this.f39951.add(0.0, 1.0, 0.0)))) {
                        if (!this.f39934.m33466()) {
                            if (this.f39948 == null) {
                                this.f39948 = this.f39951;
                                this.f39949 = c36537.m36539((LivingEntity)abstractClientPlayerEntity, this.f39948.add(0.5, 1.0, 0.5));
                            }
                            if (this.f39949 < c36537.m36539((LivingEntity)abstractClientPlayerEntity, this.f39951.add(0.5, 1.0, 0.5)) && (c36537.m36539((LivingEntity)this.mc.player, this.f39951.add(0.5, 1.0, 0.5)) < this.f39933.m33466() || this.f39928.m33466() == c39922.Mode.suicide)) {
                                this.f39948 = this.f39951;
                                this.f39949 = c36537.m36539((LivingEntity)abstractClientPlayerEntity, this.f39948.add(0.5, 1.0, 0.5));
                            }
                        }
                        else if (this.f39934.m33466() && this.m39973(new BlockPos(this.f39951.add(0.0, 2.0, 0.0)))) {
                            if (this.f39948 == null) {
                                this.f39948 = this.f39951;
                                this.f39949 = c36537.m36539((LivingEntity)abstractClientPlayerEntity, this.f39948.add(0.5, 1.0, 0.5));
                            }
                            if ((this.f39949 < c36537.m36539((LivingEntity)abstractClientPlayerEntity, this.f39951.add(0.5, 1.0, 0.5)) && c36537.m36539((LivingEntity)this.mc.player, this.f39951.add(0.5, 1.0, 0.5)) < this.f39933.m33466()) || this.f39928.m33466() == c39922.Mode.suicide) {
                                this.f39948 = this.f39951;
                                this.f39949 = c36537.m36539((LivingEntity)abstractClientPlayerEntity, this.f39948.add(0.5, 1.0, 0.5));
                            }
                        }
                    }
                }
            }
        }
    }
    
    private float m39970(final PlayerEntity playerEntity) {
        return playerEntity.getHealth() + playerEntity.getAbsorptionAmount();
    }
    
    private boolean m39973(final BlockPos blockPos) {
        return this.mc.world.isAir(blockPos) && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), blockPos.getX() + 1.0, blockPos.getY() + 2.0, blockPos.getZ() + 1.0)).isEmpty();
    }
    
    private /* synthetic */ void m39976(final c36575 c36575) {
        --this.f39947;
        this.f39953 = false;
        if (this.m39970((PlayerEntity)this.mc.player) <= this.f39935.m33466() && this.f39928.m33466() != c39922.Mode.suicide) {
            return;
        }
        Streams.stream(this.mc.world.getEntities()).filter(c39922::m40012).filter(this::m40009).filter(class_1297::method_5805).filter(this::m40006).filter(this::m40003).min(Comparator.comparingDouble((ToDoubleFunction<? super T>)this::m40000)).ifPresent(this::m39993);
        if (!this.f39939.m33466() && this.f39947 > 0) {
            return;
        }
        if (this.f39937.m33466()) {
            final Iterator<AbstractClientPlayerEntity> iterator = (Iterator<AbstractClientPlayerEntity>)((List)this.mc.world.getPlayers().stream().filter(c39017.f39019::m39041).filter(this::m39990).filter(this::m39987).collect(Collectors.toList())).iterator();
            if (!iterator.hasNext()) {
                return;
            }
            AbstractClientPlayerEntity abstractClientPlayerEntity = iterator.next();
            AbstractClientPlayerEntity abstractClientPlayerEntity2 = null;
            while (iterator.hasNext()) {
                if (abstractClientPlayerEntity2 != null) {
                    if (this.mc.player.distanceTo((Entity)abstractClientPlayerEntity2) < this.mc.player.distanceTo((Entity)abstractClientPlayerEntity)) {
                        abstractClientPlayerEntity = abstractClientPlayerEntity2;
                    }
                }
                abstractClientPlayerEntity2 = iterator.next();
            }
            if (this.f39930.m33466() && this.mc.player.getMainHandStack().getItem() != Items.field_8301) {
                final int f32664 = c31671.m31679(Items.field_8301).f32664;
                if (f32664 != -1 && f32664 < 9) {
                    this.f39946 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = f32664;
                }
            }
            Hand hand = Hand.field_5808;
            if (this.mc.player.getMainHandStack().getItem() != Items.field_8301 && this.mc.player.getOffHandStack().getItem() == Items.field_8301) {
                hand = Hand.field_5810;
            }
            else if (this.mc.player.getMainHandStack().getItem() != Items.field_8301 && this.mc.player.getOffHandStack().getItem() != Items.field_8301) {
                return;
            }
            this.m39964(abstractClientPlayerEntity);
            if (this.f39940.m33466() && Math.sqrt(abstractClientPlayerEntity.squaredDistanceTo(this.f39948)) <= 2.0) {
                if (abstractClientPlayerEntity.getHealth() + abstractClientPlayerEntity.getAbsorptionAmount() < this.f39941.m33466()) {
                    this.f39953 = true;
                }
                else {
                    final Iterator iterator2 = abstractClientPlayerEntity.getArmorItems().iterator();
                    ItemStack itemStack = null;
                    while (iterator2.hasNext()) {
                        if (itemStack != null) {
                            if (!itemStack.isEmpty() && (itemStack.getMaxDamage() - itemStack.getDamage()) / (double)itemStack.getMaxDamage() * 100.0 <= this.f39942.m33466()) {
                                this.f39953 = true;
                            }
                        }
                        itemStack = iterator2.next();
                    }
                }
            }
            if (this.f39948 != null && (this.f39949 >= this.f39932.m33466() || this.f39953)) {
                if (!this.f39939.m33466()) {
                    this.f39947 = this.f39938.m33466();
                    this.m39956(this.f39948, hand);
                }
                else if (this.f39939.m33466() && (this.f39947 <= 0 || this.f39949 - this.f39952 > this.f39944.m33466() || (this.f39943.m33466() && this.f39953))) {
                    this.f39952 = this.f39949;
                    this.m39956(this.f39948, hand);
                    if (this.f39947 <= 0) {
                        this.f39947 = 10;
                    }
                }
            }
            if (this.f39931.m33466() && this.f39946 != this.mc.player.inventory.selectedSlot) {
                this.mc.player.inventory.selectedSlot = this.f39946;
            }
        }
    }
    
    private /* synthetic */ boolean m39987(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return this.mc.player.distanceTo((Entity)abstractClientPlayerEntity) <= 10.0f;
    }
    
    private /* synthetic */ boolean m39990(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return !abstractClientPlayerEntity.getDisplayName().equals(this.mc.player.getDisplayName());
    }
    
    private /* synthetic */ void m39993(final Entity entity) {
        final int selectedSlot = this.mc.player.inventory.selectedSlot;
        if (this.mc.player.getActiveStatusEffects().containsKey(StatusEffects.field_5911) && this.f39945.m33466()) {
            for (int i = 0; i < 9; ++i) {
                if (this.mc.player.inventory.getInvStack(i).getItem() instanceof SwordItem || this.mc.player.inventory.getInvStack(i).getItem() instanceof AxeItem) {
                    this.mc.player.inventory.selectedSlot = i;
                }
            }
        }
        final Vec3d pos = entity.getPos();
        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(EnchantUtil.m35598(pos), EnchantUtil.m35600(pos), this.mc.player.onGround));
        this.mc.interactionManager.attackEntity((PlayerEntity)this.mc.player, entity);
        this.mc.player.swingHand(Hand.field_5808);
        this.mc.player.inventory.selectedSlot = selectedSlot;
    }
    
    private /* synthetic */ double m40000(final Entity entity) {
        return entity.distanceTo((Entity)this.mc.player);
    }
    
    private /* synthetic */ boolean m40003(final Entity entity) {
        return this.f39929.m33466() != c39922.Mode.safe || (this.m39970((PlayerEntity)this.mc.player) - c36537.m36539((LivingEntity)this.mc.player, entity.getPos()) > this.f39935.m33466() && c36537.m36539((LivingEntity)this.mc.player, entity.getPos()) < this.f39933.m33466());
    }
    
    private /* synthetic */ boolean m40006(final Entity entity) {
        return this.f39936.m33466() || this.mc.player.canSee(entity);
    }
    
    private /* synthetic */ boolean m40009(final Entity entity) {
        return entity.distanceTo((Entity)this.mc.player) <= this.f39927.m33466();
    }
    
    private static /* synthetic */ boolean m40012(final Entity entity) {
        return entity instanceof EnderCrystalEntity;
    }
    
    static {
        f39923 = new String[] { "crystal-aura", "Places and breaks end crystals automatically", "Place", "place-range", "The distance in a single direction the crystals get placed.", "break-range", "The distance in a single direction the crystals get broken.", "place-mode", "The way crystals are placed", "break-mode", "The way crystals are broken.", "auto-switch", "Switches to crystals for you.", "spoof-change", "Spoofs item change to crystal.", "min-damage", "The minimum damage the crystal will place", "max-damage", "The maximum self-damage allowed", "strict", "Helps compatibility with some servers.", "min-health", "The minimum health you have to be for it to place", "ignore-walls", "Attack through walls", "place", "Allow it to place cystals", "delay", "Delay ticks between placements.", "smart-delay", "Reduces crystal consumption when doing large amounts of damage.(Can tank performance on lower end PCs)", "face-place", "Will face place when target is below a certain health or their armour is low.", "face-place-health", "The health required to face place", "face-place-durability", "The durability required to face place (in percent)", "spam-face-place", "Places faster when someone is below the face place health (requires smart delay)", "damage-increase", "The damage increase for smart delay to work.", "anti-weakness", "Switches to tools when you have weakness" };
    }
}
