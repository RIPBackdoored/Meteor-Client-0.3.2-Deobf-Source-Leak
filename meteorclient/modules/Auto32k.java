package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import net.minecraft.entity.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.block.*;
import minegame159.meteorclient.*;
import meteorclient.util.*;
import net.minecraft.util.*;
import net.minecraft.util.hit.*;
import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.container.*;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class Auto32k extends Module
{
    private static final String[] f35390;
    private final Settings f35391;
    private final Value<c35389.Mode> f35392;
    private final Value<Double> f35393;
    private final Value<Boolean> f35394;
    private final Value<List<class_2248>> f35395;
    private final Value<Boolean> f35396;
    private int f35397;
    private int f35398;
    private int f35399;
    private BlockPos f35400;
    @EventHandler
    private final Listener<c36575> f35401;
    
    public Auto32k() {
        super(Category.Combat, "auto32k", "Does 32k PvP for you.");
        this.f35391 = this.f38675.m34572();
        this.f35392 = this.f35391.addValue((Value<c35389.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("The bypass used.").m36932((Enum)c35389.Mode.Dispenser).m36941());
        this.f35393 = this.f35391.addValue((Value<Double>)new c37033.c38947().m38959("place-range").m38962("The distance in a single direction the shulker is placed.").m38965(3.0).m38974(0.0).m38983(5.0).m38988());
        this.f35394 = this.f35391.addValue((Value<Boolean>)new c34427.c34657().m34664("fill-hopper").m34667("Fills all but one slot of the hopper.").m34670(true).m34679());
        this.f35395 = this.f35391.addValue((Value<List<class_2248>>)new c31769.c36992().m36999("throwaway-blocks").m37002("Acceptable blocks to use to fill the hopper").m37005(this.m35426()).m37014());
        this.f35396 = this.f35391.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-move").m34667("Moves the sword for you").m34670(true).m34679());
        this.f35399 = 0;
        this.f35401 = (Listener<c36575>)new Listener(this::m35432, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.f35399 = 0;
    }
    
    @Override
    public void m35292() {
        this.f35400 = this.m35409();
    }
    
    private List<class_2338> m35404() {
        final Iterator<BlockPos> iterator = this.m35414(this.mc.player.getBlockPos(), (double)this.f35393.m33466()).iterator();
        final ArrayList<class_2338> list = new ArrayList<class_2338>();
        Object o = null;
        while (iterator.hasNext()) {
            if (o != null) {
                if (!this.mc.world.getBlockState((BlockPos)o).getMaterial().isReplaceable() && this.mc.world.getBlockState(((BlockPos)o).up()).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)((BlockPos)o).up().getX(), (double)((BlockPos)o).up().getY(), (double)((BlockPos)o).up().getZ(), ((BlockPos)o).up().getX() + 1.0, ((BlockPos)o).up().getY() + 2.0, ((BlockPos)o).up().getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(((BlockPos)o).up(2)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)((BlockPos)o).up(2).getX(), (double)((BlockPos)o).up(2).getY(), (double)((BlockPos)o).up(2).getZ(), ((BlockPos)o).up(2).getX() + 1.0, ((BlockPos)o).up(2).getY() + 2.0, ((BlockPos)o).up(2).getZ() + 1.0)).isEmpty()) {
                    list.add((class_2338)o);
                }
            }
            o = iterator.next();
        }
        return list;
    }
    
    private BlockPos m35409() {
        final List m35414 = this.m35414(this.mc.player.getBlockPos(), (double)this.f35393.m33466());
        m35414.sort(Comparator.comparingDouble((ToDoubleFunction<? super BlockPos>)this::m35429));
        final Iterator<BlockPos> iterator = m35414.iterator();
        BlockPos blockPos = null;
        while (iterator.hasNext()) {
            if (blockPos != null) {
                if (!this.mc.world.getBlockState(blockPos).getMaterial().isReplaceable() && this.mc.world.getBlockState(blockPos.up()).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.up().getX(), (double)blockPos.up().getY(), (double)blockPos.up().getZ(), blockPos.up().getX() + 1.0, blockPos.up().getY() + 2.0, blockPos.up().getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(blockPos.up(2)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.up(2).getX(), (double)blockPos.up(2).getY(), (double)blockPos.up(2).getZ(), blockPos.up(2).getX() + 1.0, blockPos.up(2).getY() + 2.0, blockPos.up(2).getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(blockPos.up(3)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.up(3).getX(), (double)blockPos.up(3).getY(), (double)blockPos.up(3).getZ(), blockPos.up(2).getX() + 1.0, blockPos.up(2).getY() + 2.0, blockPos.up(2).getZ() + 1.0)).isEmpty()) {
                    if (this.mc.world.getBlockState(blockPos.add(-1, 1, 0)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(-1, 1, 0).getX(), (double)blockPos.add(-1, 1, 0).getY(), (double)blockPos.add(-1, 1, 0).getZ(), blockPos.add(-1, 1, 0).getX() + 1.0, blockPos.add(-1, 1, 0).getY() + 2.0, blockPos.add(-1, 1, 0).getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(blockPos.add(-1, 0, 0)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(-1, 0, 0).getX(), (double)blockPos.add(-1, 0, 0).getY(), (double)blockPos.add(-1, 0, 0).getZ(), blockPos.add(-1, 0, 0).getX() + 1.0, blockPos.add(-1, 0, 0).getY() + 2.0, blockPos.add(-1, 0, 0).getZ() + 1.0)).isEmpty()) {
                        this.f35397 = -1;
                        this.f35398 = 0;
                        return blockPos;
                    }
                    if (this.mc.world.getBlockState(blockPos.add(1, 1, 0)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(1, 1, 0).getX(), (double)blockPos.add(1, 1, 0).getY(), (double)blockPos.add(1, 1, 0).getZ(), blockPos.add(1, 1, 0).getX() + 1.0, blockPos.add(1, 1, 0).getY() + 2.0, blockPos.add(1, 1, 0).getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(blockPos.add(1, 0, 0)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(1, 0, 0).getX(), (double)blockPos.add(1, 0, 0).getY(), (double)blockPos.add(1, 0, 0).getZ(), blockPos.add(1, 0, 0).getX() + 1.0, blockPos.add(1, 0, 0).getY() + 2.0, blockPos.add(1, 0, 0).getZ() + 1.0)).isEmpty()) {
                        this.f35397 = 1;
                        this.f35398 = 0;
                        return blockPos;
                    }
                    if (this.mc.world.getBlockState(blockPos.add(0, 1, -1)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(0, 1, -1).getX(), (double)blockPos.add(0, 1, -1).getY(), (double)blockPos.add(0, 1, -1).getZ(), blockPos.add(0, 1, -1).getX() + 1.0, blockPos.add(0, 1, -1).getY() + 2.0, blockPos.add(0, 1, -1).getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(blockPos.add(0, 0, -1)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(0, 0, -1).getX(), (double)blockPos.add(0, 0, -1).getY(), (double)blockPos.add(0, 0, -1).getZ(), blockPos.add(0, 0, -1).getX() + 1.0, blockPos.add(0, 0, -1).getY() + 2.0, blockPos.add(0, 0, -1).getZ() + 1.0)).isEmpty()) {
                        this.f35397 = 0;
                        this.f35398 = -1;
                        return blockPos;
                    }
                    if (this.mc.world.getBlockState(blockPos.add(0, 1, 1)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(0, 1, 1).getX(), (double)blockPos.add(0, 1, 1).getY(), (double)blockPos.add(0, 1, 1).getZ(), blockPos.add(0, 1, 1).getX() + 1.0, blockPos.add(0, 1, 1).getY() + 2.0, blockPos.add(0, 1, 1).getZ() + 1.0)).isEmpty() && this.mc.world.getBlockState(blockPos.add(0, 0, 1)).getBlock() == Blocks.field_10124 && this.mc.world.getEntities((Entity)null, new Box((double)blockPos.add(0, 0, 1).getX(), (double)blockPos.add(0, 0, 1).getY(), (double)blockPos.add(0, 0, 1).getZ(), blockPos.add(0, 0, 1).getX() + 1.0, blockPos.add(0, 0, 1).getY() + 2.0, blockPos.add(0, 0, 1).getZ() + 1.0)).isEmpty()) {
                        this.f35397 = 0;
                        this.f35398 = 1;
                        return blockPos;
                    }
                }
            }
            blockPos = iterator.next();
        }
        return null;
    }
    
    private List<class_2338> m35414(final class_2338 class_2338, final double n) {
        final ArrayList<class_2338> list = new ArrayList<class_2338>();
        for (double n2 = ((BlockPos)class_2338).getX() - n; n2 < ((BlockPos)class_2338).getX() + n; ++n2) {
            for (double n3 = ((BlockPos)class_2338).getZ() - n; n3 < ((BlockPos)class_2338).getZ() + n; ++n3) {
                for (int i = ((BlockPos)class_2338).getY() - 3; i < ((BlockPos)class_2338).getY() + 3; ++i) {
                    list.add((class_2338)new BlockPos(n2, (double)i, n3));
                }
            }
        }
        return list;
    }
    
    private boolean m35423(final int n) {
        return n == -1 || n >= 9;
    }
    
    private List<class_2248> m35426() {
        final ArrayList<Block> list = (ArrayList<Block>)new ArrayList<class_2248>();
        list.add((class_2248)Blocks.field_10540);
        list.add((class_2248)Blocks.field_10445);
        return (List<class_2248>)list;
    }
    
    private /* synthetic */ double m35429(final BlockPos blockPos) {
        return this.mc.player.squaredDistanceTo((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ());
    }
    
    private /* synthetic */ void m35432(final c36575 c36575) {
        if (this.f35399 <= 7) {
            if (this.f35392.m33466() == c35389.Mode.Hopper) {
                final int f32664 = c31671.m31679(Items.SHULKER_BOX).f32664;
                final int f32665 = c31671.m31679(Items.HOPPER).f32664;
                if (this.m35423(f32664) || this.m35423(f32665)) {
                    return;
                }
                final List<class_2338> m35404 = this.m35404();
                m35404.sort(Comparator.comparingDouble((ToDoubleFunction<? super class_2338>)this::m35456));
                final Iterator<class_2338> iterator = m35404.iterator();
                BlockPos up = null;
                if (iterator.hasNext()) {
                    up = (BlockPos)iterator.next();
                }
                if (up != null) {
                    this.mc.player.inventory.selectedSlot = f32665;
                    while (!EnchantUtil.m35595(Blocks.field_10312.getDefaultState(), up) && iterator.hasNext()) {
                        up = ((BlockPos)iterator.next()).up();
                    }
                    this.mc.player.setSneaking(true);
                    this.mc.player.inventory.selectedSlot = f32664;
                    if (!EnchantUtil.m35595(Blocks.field_10603.getDefaultState(), up.up())) {
                        EnchantUtil.m35620("#redFailed to place.", new Object[0]);
                        this.m35300();
                        return;
                    }
                    this.mc.player.setSneaking(false);
                    this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)up.up()), this.mc.player.getHorizontalFacing(), up.up(), false));
                    this.f35399 = 8;
                }
            }
            else if (this.f35392.m33466() == c35389.Mode.Dispenser) {
                final int f32666 = c31671.m31679(Items.SHULKER_BOX).f32664;
                final int f32667 = c31671.m31679(Items.HOPPER).f32664;
                final int f32668 = c31671.m31679(Items.DISPENSER).f32664;
                final int f32669 = c31671.m31679(Items.REDSTONE_BLOCK).f32664;
                if ((this.m35423(f32666) && this.f35392.m33466() == c35389.Mode.Hopper) || this.m35423(f32667) || this.m35423(f32668) || this.m35423(f32669)) {
                    return;
                }
                if (this.f35399 == 0) {
                    this.f35400 = this.m35409();
                    this.mc.player.inventory.selectedSlot = f32667;
                    if (this.f35400 == null) {
                        return;
                    }
                    if (!EnchantUtil.m35595(Blocks.field_10312.getDefaultState(), this.f35400.add(this.f35397, 0, this.f35398))) {
                        EnchantUtil.m35620("#redFailed to place", new Object[0]);
                        this.m35300();
                        return;
                    }
                    ++this.f35399;
                }
                else if (this.f35399 == 1) {
                    this.mc.player.inventory.selectedSlot = f32668;
                    if (this.f35397 == -1) {
                        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(-90.0f, this.mc.player.pitch, this.mc.player.onGround));
                    }
                    else if (this.f35397 == 1) {
                        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(90.0f, this.mc.player.pitch, this.mc.player.onGround));
                    }
                    else if (this.f35398 == -1) {
                        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(1.0f, this.mc.player.pitch, this.mc.player.onGround));
                    }
                    else if (this.f35398 == 1) {
                        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(179.0f, this.mc.player.pitch, this.mc.player.onGround));
                    }
                    ++this.f35399;
                }
                else if (this.f35399 == 2) {
                    this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.f35400), Direction.field_11036, this.f35400, false));
                    ++this.f35399;
                }
                else if (this.f35399 == 3) {
                    this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.f35400.up()), this.mc.player.getHorizontalFacing().getOpposite(), this.f35400.up(), false));
                    ++this.f35399;
                }
                else if (this.f35399 == 4 && this.mc.currentScreen instanceof Generic3x3ContainerScreen) {
                    this.mc.player.getSpeed();
                    c31671.m31675(c31671.m31693(f32666), 0, SlotActionType.field_7790);
                    c31671.m31675(4, 0, SlotActionType.field_7790);
                    ++this.f35399;
                }
                else if (this.f35399 == 5 && this.mc.currentScreen instanceof Generic3x3ContainerScreen) {
                    this.mc.player.closeContainer();
                    ++this.f35399;
                }
                else if (this.f35399 == 6) {
                    this.mc.player.inventory.selectedSlot = f32669;
                    this.mc.player.setSneaking(true);
                    this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.f35400.up()), this.mc.player.getHorizontalFacing().getOpposite(), this.f35400.up(2), false));
                    this.mc.player.setSneaking(false);
                    ++this.f35399;
                }
                else if (this.f35399 == 7) {
                    this.mc.interactionManager.interactBlock(this.mc.player, this.mc.world, Hand.field_5808, new BlockHitResult(new Vec3d((Vec3i)this.f35400.up()), this.mc.player.getHorizontalFacing().getOpposite(), this.f35400.add(this.f35397, 0, this.f35398), false));
                    ++this.f35399;
                }
            }
        }
        else if (this.f35399 == 8) {
            if (this.mc.currentScreen instanceof HopperScreen) {
                if (this.f35394.m33466() && !this.f35395.m33466().isEmpty()) {
                    int n = -1;
                    int count = 0;
                    final Iterator<class_2248> iterator2 = this.f35395.m33466().iterator();
                    Item item = ((Block)iterator2.next()).asItem();
                    while (iterator2.hasNext()) {
                        for (int i = 5; i <= 40; ++i) {
                            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
                            if (invStack.getItem() == item && invStack.getCount() >= 4) {
                                n = i;
                                count = invStack.getCount();
                                break;
                            }
                        }
                        if (count >= 4) {
                            break;
                        }
                        item = ((Block)iterator2.next()).asItem();
                    }
                    for (int j = 1; j < 5; ++j) {
                        if (this.mc.player.container.getSlot(j).getStack().getItem() instanceof AirBlockItem) {
                            c31671.m31675(c31671.m31693(n) - 4, 0, SlotActionType.field_7790);
                            c31671.m31675(j, 1, SlotActionType.field_7790);
                            c31671.m31675(c31671.m31693(n) - 4, 0, SlotActionType.field_7790);
                        }
                    }
                }
                boolean b = true;
                int n2 = -1;
                int n3 = -1;
                for (int k = 32; k < 41; ++k) {
                    if (EnchantmentHelper.getLevel(Enchantments.field_9118, this.mc.player.container.getSlot(k).getStack()) > 5) {
                        b = false;
                        n2 = k;
                        break;
                    }
                    if (this.mc.player.container.getSlot(k).getStack().getItem() instanceof SwordItem && EnchantmentHelper.getLevel(Enchantments.field_9118, this.mc.player.container.getSlot(k).getStack()) <= 5) {
                        n3 = k;
                    }
                }
                if (n3 != -1) {
                    c31671.m31675(c31671.m31693(n3), 0, SlotActionType.field_7795);
                }
                if (this.f35396.m33466() && b) {
                    final int emptySlot = this.mc.player.inventory.getEmptySlot();
                    if (emptySlot < 9 && emptySlot != -1 && EnchantmentHelper.getLevel(Enchantments.field_9118, this.mc.player.container.getSlot(0).getStack()) > 5) {
                        c31671.m31675(0, 0, SlotActionType.field_7790);
                        c31671.m31675(c31671.m31693(emptySlot) - 4, 0, SlotActionType.field_7790);
                    }
                    else if (EnchantmentHelper.getLevel(Enchantments.field_9118, this.mc.player.container.getSlot(0).getStack()) <= 5 && this.mc.player.container.getSlot(0).getStack().getItem() != Items.AIR) {
                        c31671.m31675(0, 0, SlotActionType.field_7795);
                    }
                }
                if (n2 != -1) {
                    this.mc.player.inventory.selectedSlot = n2 - 32;
                }
            }
            else {
                this.m35300();
            }
        }
    }
    
    private /* synthetic */ double m35456(final BlockPos blockPos) {
        return this.mc.player.squaredDistanceTo((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ());
    }
    
    static {
        f35390 = new String[] { "auto32k", "Does 32k PvP for you.", "mode", "The bypass used.", "place-range", "The distance in a single direction the shulker is placed.", "fill-hopper", "Fills all but one slot of the hopper.", "throwaway-blocks", "Acceptable blocks to use to fill the hopper", "auto-move", "Moves the sword for you", "#redFailed to place.", "#redFailed to place" };
    }
}
