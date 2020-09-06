package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.hit.*;
import net.minecraft.client.gui.screen.ingame.*;
import minegame159.meteorclient.*;
import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class Antibed extends Module
{
    private static final String[] f38280;
    private final Settings f38281;
    private final Value<Boolean> f38282;
    private final Value<Boolean> f38283;
    private final Value<Boolean> f38284;
    private int f38285;
    private boolean f38286;
    @EventHandler
    private final Listener<c36575> f38287;
    
    public Antibed() {
        super(Category.Combat, "anti-bed", "Stops people placing beds in blocks you are standing");
        this.f38281 = this.f38675.m34572();
        this.f38282 = this.f38281.addValue((Value<Boolean>)new c34427.c34657().m34664("self-toggle").m34667("Toggles this module when it's finished.").m34670(false).m34679());
        this.f38283 = this.f38281.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-center").m34667("Moves you to the center of blocks when needed.").m34670(true).m34679());
        this.f38284 = this.f38281.addValue((Value<Boolean>)new c34427.c34657().m34664("only-on-ground").m34667("Only works you are on the ground.").m34670(true).m34679());
        this.f38285 = -1;
        this.f38286 = false;
        this.f38287 = (Listener<c36575>)new Listener(this::m38297, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.f38286 = false;
    }
    
    private BlockPos m38289() {
        BlockPos blockPos = null;
        if (!this.mc.world.getBlockState(this.mc.player.getBlockPos().add(0, 1, 1)).isAir()) {
            blockPos = this.mc.player.getBlockPos().add(0, 1, 1);
        }
        else if (!this.mc.world.getBlockState(this.mc.player.getBlockPos().add(0, 1, -1)).isAir()) {
            blockPos = this.mc.player.getBlockPos().add(0, 1, -1);
        }
        else if (!this.mc.world.getBlockState(this.mc.player.getBlockPos().add(1, 1, 0)).isAir()) {
            blockPos = this.mc.player.getBlockPos().add(1, 1, 0);
        }
        else if (!this.mc.world.getBlockState(this.mc.player.getBlockPos().add(-1, 1, 0)).isAir()) {
            blockPos = this.mc.player.getBlockPos().add(-1, 1, 0);
        }
        return blockPos;
    }
    
    private void m38292(final int selectedSlot) {
        final int selectedSlot2 = this.mc.player.inventory.selectedSlot;
        this.mc.player.inventory.selectedSlot = selectedSlot;
        final boolean sneaking = this.mc.player.isSneaking();
        this.mc.player.setSneaking(true);
        this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.mc.player.getBlockPos().up()), Direction.field_11033, this.mc.player.getBlockPos().up(), this.mc.player.onGround));
        this.mc.player.setSneaking(sneaking);
        this.mc.player.inventory.selectedSlot = selectedSlot2;
        if (this.f38282.m33466()) {
            this.m35300();
        }
    }
    
    private /* synthetic */ void m38297(final c36575 c36575) {
        if (this.f38286 && this.mc.currentScreen instanceof SignEditScreen) {
            this.f38286 = false;
            this.mc.player.closeScreen();
            return;
        }
        if (this.f38286) {
            return;
        }
        if (!this.mc.world.getBlockState(this.mc.player.getBlockPos().up()).isAir()) {
            return;
        }
        if (this.f38284.m33466() && !this.mc.player.onGround) {
            return;
        }
        if (this.f38285 == 0) {
            --this.f38285;
            this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.mc.player.getBlockPos().up()), Direction.field_11033, this.mc.player.getBlockPos().up(), this.mc.player.onGround));
            ((c39520)this.mc.options.keySneak).m39521(false);
            if (this.f38282.m33466()) {
                this.m35300();
            }
        }
        else if (this.f38285 > 0) {
            --this.f38285;
        }
        for (int i = 0; i < 9; ++i) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
            final Item item = invStack.getItem();
            final Block blockFromItem = Block.getBlockFromItem(item);
            if (item == Items.field_8276 || blockFromItem instanceof TrapdoorBlock || item == Items.COBWEB) {
                this.m38292(i);
                return;
            }
            if (blockFromItem instanceof SlabBlock) {
                this.mc.player.inventory.selectedSlot = i;
                ((c39520)this.mc.options.keySneak).m39521(true);
                if (this.f38285 == -1) {
                    this.f38285 = 2;
                }
                return;
            }
            if (blockFromItem instanceof DoorBlock) {
                if (this.f38283.m33466()) {
                    Vec3d vec3d = new Vec3d((Vec3i)this.mc.player.getBlockPos());
                    if (this.mc.player.getHorizontalFacing() == Direction.field_11035) {
                        vec3d = vec3d.add(0.5, 0.0, 0.7);
                    }
                    else if (this.mc.player.getHorizontalFacing() == Direction.field_11043) {
                        vec3d = vec3d.add(0.5, 0.0, 0.3);
                    }
                    else if (this.mc.player.getHorizontalFacing() == Direction.field_11034) {
                        vec3d = vec3d.add(0.7, 0.0, 0.5);
                    }
                    else if (this.mc.player.getHorizontalFacing() == Direction.field_11039) {
                        vec3d = vec3d.add(0.3, 0.0, 0.5);
                    }
                    this.mc.player.updatePosition(vec3d.x, vec3d.y, vec3d.z);
                    this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2829(vec3d.x, vec3d.y, vec3d.z, this.mc.player.onGround));
                }
                this.m38292(i);
                return;
            }
            if (item == Items.LADDER) {
                if (this.f38283.m33466()) {
                    Vec3d vec3d2 = new Vec3d((Vec3i)this.mc.player.getBlockPos());
                    final BlockPos m38289 = this.m38289();
                    if (m38289 == null) {
                        return;
                    }
                    if (vec3d2.subtract(new Vec3d((Vec3i)m38289)).x > 0.0) {
                        vec3d2 = vec3d2.add(0.7, 0.0, 0.5);
                    }
                    else if (vec3d2.subtract(new Vec3d((Vec3i)m38289)).x < 0.0) {
                        vec3d2 = vec3d2.add(0.3, 0.0, 0.5);
                    }
                    else if (vec3d2.subtract(new Vec3d((Vec3i)m38289)).z > 0.0) {
                        vec3d2 = vec3d2.add(0.5, 0.0, 0.7);
                    }
                    else if (vec3d2.subtract(new Vec3d((Vec3i)m38289)).z < 0.0) {
                        vec3d2 = vec3d2.add(0.5, 0.0, 0.3);
                    }
                    this.mc.player.updatePosition(vec3d2.x, vec3d2.y, vec3d2.z);
                    this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2829(vec3d2.x, vec3d2.y, vec3d2.z, this.mc.player.onGround));
                }
                this.m38292(i);
                return;
            }
            if (item instanceof BannerItem || item == Items.LEVER || item == Items.TORCH || item == Items.REDSTONE_TORCH || item instanceof SignItem || item == Items.TRIPWIRE_HOOK || blockFromItem instanceof StoneButtonBlock || blockFromItem instanceof WoodButtonBlock) {
                this.m38292(i);
                if (item instanceof SignItem) {
                    this.f38286 = true;
                }
                return;
            }
            if (item == Items.SCAFFOLDING && invStack.getCount() >= 2) {
                final int selectedSlot = this.mc.player.inventory.selectedSlot;
                this.mc.player.inventory.selectedSlot = i;
                final boolean sneaking = this.mc.player.isSneaking();
                this.mc.player.setSneaking(true);
                this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.mc.player.getBlockPos()), Direction.field_11033, this.mc.player.getBlockPos(), this.mc.player.onGround));
                this.mc.player.setSneaking(sneaking);
                this.mc.player.inventory.selectedSlot = selectedSlot;
                this.m38292(i);
                return;
            }
        }
    }
    
    static {
        f38280 = new String[] { "anti-bed", "Stops people placing beds in blocks you are standing", "self-toggle", "Toggles this module when it's finished.", "auto-center", "Moves you to the center of blocks when needed.", "only-on-ground", "Only works you are on the ground." };
    }
}
