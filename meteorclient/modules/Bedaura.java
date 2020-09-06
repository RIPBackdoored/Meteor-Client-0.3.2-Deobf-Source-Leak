package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.util.hit.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.block.entity.*;
import net.minecraft.world.dimension.*;
import minegame159.meteorclient.*;
import java.util.stream.*;
import net.minecraft.client.network.*;
import java.util.*;

public class Bedaura extends Module
{
    private static final String[] f32993;
    private final Settings f32994;
    private final Settings f32995;
    private final Value<Double> f32996;
    private final Value<Double> f32997;
    private final Value<c32992.Mode> f32998;
    private final Value<c32992.Mode> f32999;
    private final Value<Boolean> f33000;
    private final Value<Boolean> f33001;
    private final Value<Integer> f33002;
    private final Value<Boolean> f33003;
    private final Value<Double> f33004;
    private final Value<Boolean> f33005;
    private final Value<Double> f33006;
    private final Value<Double> f33007;
    private final Value<Double> f33008;
    private final Value<Boolean> f33009;
    private int f33010;
    private Vec3d f33011;
    private double f33012;
    private BlockPos f33013;
    private double f33014;
    private BlockPos f33015;
    private BlockPos f33016;
    private Vec3d f33017;
    private BlockPos f33018;
    private float f33019;
    private double f33020;
    private int f33021;
    @EventHandler
    private final Listener<c36575> f33022;
    
    public Bedaura() {
        super(Category.Combat, "bed-aura", "Automatically places and blows up beds in the nether");
        this.f32994 = this.f38675.m34572();
        this.f32995 = this.f38675.m34588("Place");
        this.f32996 = this.f32994.addValue((Value<Double>)new c37033.c38947().m38959("place-range").m38962("The distance in a single direction the beds get placed.").m38965(3.0).m38974(0.0).m38983(5.0).m38988());
        this.f32997 = this.f32994.addValue((Value<Double>)new c37033.c38947().m38959("break-range").m38962("The distance in a single direction the beds get broken.").m38965(3.0).m38974(0.0).m38983(5.0).m38988());
        this.f32998 = this.f32994.addValue((Value<c32992.Mode>)new c36601.c36919<Enum>().m36926("place-mode").m36929("The way beds are placed").m36932((Enum)c32992.Mode.safe).m36941());
        this.f32999 = this.f32994.addValue((Value<c32992.Mode>)new c36601.c36919<Enum>().m36926("break-mode").m36929("The way the beds are broken").m36932((Enum)c32992.Mode.safe).m36941());
        this.f33000 = this.f32994.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-switch").m34667("Switches to bed automatically").m34670(false).m34679());
        this.f33001 = this.f32994.addValue((Value<Boolean>)new c34427.c34657().m34664("switch-back").m34667("Switches back to the previous slot after auto switching.").m34670(false).m34679());
        this.f33002 = this.f32994.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("The delay between placements.").m32387(2).m32396(0).m32405(10).m32408());
        this.f33003 = this.f32994.addValue((Value<Boolean>)new c34427.c34657().m34664("smart-delay").m34667("Reduces crystal consumption when doing large amounts of damage.").m34670(true).m34679());
        this.f33004 = this.f32994.addValue((Value<Double>)new c37033.c38947().m38959("damage-increase").m38962("The damage increase for smart delay to work.").m38965(5.0).m38974(0.0).m38977(20.0).m38988());
        this.f33005 = this.f32994.addValue((Value<Boolean>)new c34427.c34657().m34664("air-place").m34667("Places beds in the air if they do more damage.").m34670(false).m34679());
        this.f33006 = this.f32995.addValue((Value<Double>)new c37033.c38947().m38959("min-damage").m38962("The minimum damage the beds will place").m38965(5.5).m38988());
        this.f33007 = this.f32995.addValue((Value<Double>)new c37033.c38947().m38959("max-damage").m38962("The maximum self-damage allowed").m38965(3.0).m38988());
        this.f33008 = this.f32995.addValue((Value<Double>)new c37033.c38947().m38959("min-health").m38962("The minimum health you have to be for it to place").m38965(15.0).m38988());
        this.f33009 = this.f32994.addValue((Value<Boolean>)new c34427.c34657().m34664("place").m34667("Allow it to place beds").m34670(true).m34679());
        this.f33010 = this.f33002.m33466();
        this.f33020 = 0.0;
        this.f33021 = 0;
        this.f33022 = (Listener<c36575>)new Listener(this::m33038, new Predicate[0]);
    }
    
    private void m33023() {
        this.f33015 = new BlockPos(this.f33011.x, this.f33011.y, this.f33011.z);
        int selectedSlot = -1;
        if (this.f33000.m33466()) {
            for (int i = 0; i < 9; ++i) {
                if (this.mc.player.inventory.getInvStack(i).getItem() instanceof BedItem) {
                    selectedSlot = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = i;
                }
            }
        }
        Hand hand = Hand.field_5808;
        if (!(this.mc.player.getMainHandStack().getItem() instanceof BedItem) && this.mc.player.getOffHandStack().getItem() instanceof BedItem) {
            hand = Hand.field_5810;
        }
        if (this.f33021 == 0) {
            this.f33019 = this.mc.player.yaw;
            this.mc.player.yaw = -90.0f;
            this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(-90.0f, this.mc.player.pitch, this.mc.player.onGround));
            this.mc.player.yaw = this.f33019;
        }
        else if (this.f33021 == 1) {
            this.f33019 = this.mc.player.yaw;
            this.mc.player.yaw = 179.0f;
            this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(179.0f, this.mc.player.pitch, this.mc.player.onGround));
            this.mc.player.yaw = this.f33019;
        }
        else if (this.f33021 == 2) {
            this.f33019 = this.mc.player.yaw;
            this.mc.player.yaw = 1.0f;
            this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(1.0f, this.mc.player.pitch, this.mc.player.onGround));
            this.mc.player.yaw = this.f33019;
        }
        else if (this.f33021 == 3) {
            this.f33019 = this.mc.player.yaw;
            this.mc.player.yaw = 90.0f;
            this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(90.0f, this.mc.player.pitch, this.mc.player.onGround));
            this.mc.player.yaw = this.f33019;
        }
        this.f33020 = this.f33012;
        this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, hand, new BlockHitResult(this.f33011, Direction.field_11036, this.f33015, false));
        this.mc.player.swingHand(Hand.field_5808);
        if (selectedSlot != -1 && this.mc.player.inventory.selectedSlot != selectedSlot && this.f33001.m33466()) {
            this.mc.player.inventory.selectedSlot = selectedSlot;
        }
    }
    
    private void m33028(final PlayerEntity playerEntity) {
        this.f33011 = null;
        this.f33012 = 0.0;
        this.f33013 = this.mc.player.getBlockPos();
        for (double n = this.f33013.getX() - this.f32996.m33466(); n < this.f33013.getX() + this.f32996.m33466(); ++n) {
            for (double n2 = this.f33013.getZ() - this.f32996.m33466(); n2 < this.f33013.getZ() + this.f32996.m33466(); ++n2) {
                for (double n3 = this.f33013.getY() - 3; n3 < this.f33013.getY() + 3; ++n3) {
                    this.f33016 = new BlockPos(n, n3, n2);
                    this.f33017 = new Vec3d(n, n3, n2);
                    this.f33018 = this.f33016.add(0, 1, 0);
                    if (this.mc.world.getBlockState(this.f33018).getMaterial().isReplaceable() && this.mc.world.getEntities((Entity)null, new Box((double)this.f33018.getX(), (double)this.f33018.getY(), (double)this.f33018.getZ(), this.f33018.getX() + 1.0, this.f33018.getY() + 1.0, this.f33018.getZ() + 1.0)).isEmpty() && (this.mc.world.getBlockState(new BlockPos((Vec3i)this.f33018).add(1, 0, 0)).getMaterial().isReplaceable() || this.mc.world.getBlockState(this.f33018.add(-1, 0, 0)).getMaterial().isReplaceable() || this.mc.world.getBlockState(this.f33018.add(0, 0, 1)).getMaterial().isReplaceable() || this.mc.world.getBlockState(this.f33018.add(0, 0, -1)).getMaterial().isReplaceable())) {
                        if (this.f33005.m33466()) {
                            if (this.f33011 == null) {
                                this.f33011 = this.f33017;
                                this.f33012 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(0.5, 1.5, 0.5));
                            }
                            if (this.f33012 < c36537.m36546((LivingEntity)playerEntity, this.f33017.add(0.5, 1.5, 0.5)) && (c36537.m36546((LivingEntity)this.mc.player, this.f33017.add(0.5, 1.5, 0.5)) < this.f33006.m33466() || this.f32998.m33466() == c32992.Mode.suicide)) {
                                this.f33011 = this.f33017;
                                this.f33012 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(0.5, 1.5, 0.5));
                            }
                        }
                        else if (!this.f33005.m33466() && !this.mc.world.getBlockState(this.f33016).getMaterial().isReplaceable()) {
                            if (this.f33011 == null) {
                                this.f33011 = this.f33017;
                                this.f33012 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(0.5, 1.5, 0.5));
                            }
                            if (this.f33012 < c36537.m36546((LivingEntity)playerEntity, this.f33017.add(0.5, 1.5, 0.5)) && (c36537.m36546((LivingEntity)this.mc.player, this.f33017.add(0.5, 1.5, 0.5)) < this.f33006.m33466() || this.f32998.m33466() == c32992.Mode.suicide)) {
                                this.f33011 = this.f33017;
                                this.f33012 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(0.5, 1.5, 0.5));
                            }
                        }
                    }
                }
            }
        }
        double m36546 = -1.0;
        double m36547 = -1.0;
        double m36548 = -1.0;
        double m36549 = -1.0;
        this.f33015 = new BlockPos(this.f33011.x, this.f33011.y + 1.0, this.f33011.z);
        if (this.mc.world.getBlockState(this.f33015.add(1, 1, 0)).getMaterial().isReplaceable()) {
            m36547 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(1.5, 1.5, 0.5));
        }
        if (this.mc.world.getBlockState(this.f33015.add(-1, 1, 0)).getMaterial().isReplaceable()) {
            m36549 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(-1.5, 1.5, 0.5));
        }
        if (this.mc.world.getBlockState(this.f33015.add(0, 1, 1)).getMaterial().isReplaceable()) {
            m36548 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(0.5, 1.5, 1.5));
        }
        if (this.mc.world.getBlockState(this.f33015.add(0, 1, -1)).getMaterial().isReplaceable()) {
            m36546 = c36537.m36546((LivingEntity)playerEntity, this.f33011.add(0.5, 1.5, -1.5));
        }
        if (m36547 > m36546 && m36547 > m36548 && m36547 > m36549) {
            this.f33021 = 0;
        }
        else if (m36547 < m36546 && m36546 > m36548 && m36546 > m36549) {
            this.f33021 = 1;
        }
        else if (m36548 > m36546 && m36547 < m36548 && m36548 > m36549) {
            this.f33021 = 2;
        }
        else if (m36549 > m36546 && m36549 > m36548 && m36547 < m36549) {
            this.f33021 = 3;
        }
        this.f33012 = Math.max(this.f33012, Math.max(m36546, Math.max(m36547, Math.max(m36548, m36549))));
    }
    
    private /* synthetic */ void m33038(final c36575 c36575) {
        --this.f33010;
        if (this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount() <= this.f33008.m33466() && this.f32998.m33466() != c32992.Mode.suicide) {
            return;
        }
        for (final BlockEntity blockEntity : this.mc.world.blockEntities) {
            if (blockEntity instanceof BedBlockEntity && Math.sqrt(blockEntity.getSquaredDistance(this.mc.player.x, this.mc.player.y, this.mc.player.z)) <= this.f32997.m33466()) {
                this.f33014 = c36537.m36546((LivingEntity)this.mc.player, new Vec3d((Vec3i)blockEntity.getPos()));
                if (this.f33014 >= this.f33007.m33466() && this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount() - this.f33014 >= this.f33008.m33466() && !this.f32999.m33466().equals((Object)c32992.Mode.suicide)) {
                    continue;
                }
                this.mc.player.setSneaking(false);
                this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(this.mc.player.getPos(), Direction.field_11036, blockEntity.getPos(), false));
            }
        }
        if (this.mc.player.dimension == DimensionType.field_13072) {
            c31351.m31360(this, "You are in the overworld. Disabling!", new Object[0]);
            this.m35300();
            return;
        }
        if (this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount() <= this.f33008.m33466() && this.f32998.m33466() != c32992.Mode.suicide) {
            return;
        }
        if (this.f33009.m33466() && !(this.mc.player.getMainHandStack().getItem() instanceof BedItem) && !(this.mc.player.getOffHandStack().getItem() instanceof BedItem) && !this.f33000.m33466()) {
            return;
        }
        if (this.f33009.m33466()) {
            final Iterator<AbstractClientPlayerEntity> iterator2 = (Iterator<AbstractClientPlayerEntity>)((List)this.mc.world.getPlayers().stream().filter(c39017.f39019::m39041).filter(this::m33049).filter(this::m33046).collect(Collectors.toList())).iterator();
            if (!iterator2.hasNext()) {
                return;
            }
            Object o = iterator2.next();
            Object o2 = null;
            while (iterator2.hasNext()) {
                if (o2 != null) {
                    if (this.mc.player.distanceTo((Entity)o2) < this.mc.player.distanceTo((Entity)o)) {
                        o = o2;
                    }
                }
                o2 = iterator2.next();
            }
            if (!this.f33003.m33466() && this.f33010 > 0) {
                return;
            }
            this.m33028((PlayerEntity)o);
            if (this.f33011 != null && this.f33012 >= this.f33006.m33466()) {
                if (!this.f33003.m33466()) {
                    this.f33010 = this.f33002.m33466();
                    this.m33023();
                }
                else if (this.f33003.m33466() && (this.f33010 <= 0 || this.f33012 - this.f33020 > this.f33004.m33466())) {
                    this.f33020 = this.f33012;
                    this.m33023();
                    if (this.f33010 <= 0) {
                        this.f33010 = 10;
                    }
                }
            }
        }
    }
    
    private /* synthetic */ boolean m33046(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return this.mc.player.distanceTo((Entity)abstractClientPlayerEntity) <= 10.0f;
    }
    
    private /* synthetic */ boolean m33049(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return !abstractClientPlayerEntity.getDisplayName().equals(this.mc.player.getDisplayName());
    }
    
    static {
        f32993 = new String[] { "bed-aura", "Automatically places and blows up beds in the nether", "Place", "place-range", "The distance in a single direction the beds get placed.", "break-range", "The distance in a single direction the beds get broken.", "place-mode", "The way beds are placed", "break-mode", "The way the beds are broken", "auto-switch", "Switches to bed automatically", "switch-back", "Switches back to the previous slot after auto switching.", "delay", "The delay between placements.", "smart-delay", "Reduces crystal consumption when doing large amounts of damage.", "damage-increase", "The damage increase for smart delay to work.", "air-place", "Places beds in the air if they do more damage.", "min-damage", "The minimum damage the beds will place", "max-damage", "The maximum self-damage allowed", "min-health", "The minimum health you have to be for it to place", "place", "Allow it to place beds", "You are in the overworld. Disabling!" };
    }
}
