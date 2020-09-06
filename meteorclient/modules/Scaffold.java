package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.world.*;
import net.minecraft.util.shape.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import meteorclient.util.*;

public class Scaffold extends Module
{
    private static final String[] f35051;
    private final Settings f35052;
    private final Value<Boolean> f35053;
    private final Value<Boolean> f35054;
    private final Value<Integer> f35055;
    private final Value<Boolean> f35056;
    private final Value<List<class_2248>> f35057;
    private final Value<Boolean> f35058;
    private final class_2338.class_2339 f35059;
    private BlockState f35060;
    private BlockState f35061;
    private int f35062;
    private int f35063;
    @EventHandler
    private final Listener<c36575> f35064;
    
    public Scaffold() {
        super(Category.Movement, "scaffold", "Places blocks under you.");
        this.f35052 = this.f38675.m34572();
        this.f35053 = this.f35052.addValue((Value<Boolean>)new c34427.c34657().m34664("safe-walk").m34667("Safe walk.").m34670(true).m34679());
        this.f35054 = this.f35052.addValue((Value<Boolean>)new c34427.c34657().m34664("fast-tower").m34667("To the sky.").m34670(false).m34679());
        this.f35055 = this.f35052.addValue((Value<Integer>)new c32369.c32370().m32381("radius").m32384("Radius.").m32387(1).m32396(1).m32402(1).m32405(7).m32408());
        this.f35056 = this.f35052.addValue((Value<Boolean>)new c34427.c34657().m34664("swing-hand").m34667("Only client side.").m34670(false).m34679());
        this.f35057 = this.f35052.addValue((Value<List<class_2248>>)new c31769.c36992().m36999("blacklist").m37002("Stops you from placing certain blocks as scaffold.").m37005(new ArrayList<class_2248>()).m37014());
        this.f35058 = this.f35052.addValue((Value<Boolean>)new c34427.c34657().m34664("self-toggle").m34667("Toggles when you run out of blocks.").m34670(true).m34679());
        this.f35059 = new class_2338.class_2339();
        this.f35064 = (Listener<c36575>)new Listener(this::m35086, new Predicate[0]);
    }
    
    private boolean m35065() {
        if (this.mc.player.inventory.getInvStack(this.f35062).isEmpty()) {
            this.f35062 = this.m35075(this.f35060);
            if (this.f35062 == -1) {
                this.mc.player.inventory.selectedSlot = this.f35063;
                if (this.f35058.m33466()) {
                    this.m35300();
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean m35067(final BlockState blockState) {
        return blockState.getOutlineShape((BlockView)this.mc.world, this.m35070(0, -1, 0)) != VoxelShapes.empty();
    }
    
    private BlockPos m35070(final int n, final int n2, final int n3) {
        this.f35059.method_10105((Entity)this.mc.player);
        if (n != 0) {
            this.f35059.method_20787(this.f35059.getX() + n);
        }
        if (n2 != 0) {
            this.f35059.method_10099(this.f35059.getY() + n2);
        }
        if (n3 != 0) {
            this.f35059.method_20788(this.f35059.getZ() + n3);
        }
        return (BlockPos)this.f35059;
    }
    
    private int m35075(final BlockState blockState) {
        int n = -1;
        for (int i = 0; i < 9; ++i) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(i);
            if (!invStack.isEmpty()) {
                if (invStack.getItem() instanceof BlockItem) {
                    if (!this.f35057.m33466().contains(Block.getBlockFromItem(invStack.getItem()))) {
                        final Block block = ((BlockItem)invStack.getItem()).getBlock();
                        this.f35061 = block.getDefaultState();
                        if (Block.isShapeFullCube(this.f35061.getCollisionShape((BlockView)this.mc.world, this.m35070(0, -1, 0)))) {
                            if (!(block instanceof FallingBlock) || !FallingBlock.canFallThrough(blockState)) {
                                n = i;
                                break;
                            }
                        }
                    }
                }
            }
        }
        final ItemStack mainHandStack = this.mc.player.getMainHandStack();
        if (mainHandStack.isEmpty() || !(mainHandStack.getItem() instanceof BlockItem)) {
            return n;
        }
        if (this.f35057.m33466().contains(Block.getBlockFromItem(mainHandStack.getItem()))) {
            return n;
        }
        final Block block2 = ((BlockItem)mainHandStack.getItem()).getBlock();
        this.f35061 = block2.getDefaultState();
        if (!Block.isShapeFullCube(this.f35061.getCollisionShape((BlockView)this.mc.world, this.m35070(0, -1, 0)))) {
            return n;
        }
        if (block2 instanceof FallingBlock && FallingBlock.canFallThrough(blockState)) {
            return n;
        }
        return this.mc.player.inventory.selectedSlot;
    }
    
    public boolean m35084() {
        return this.f35053.m33466();
    }
    
    private /* synthetic */ void m35086(final c36575 c36575) {
        if (this.f35054.m33466() && !this.mc.world.getBlockState(this.m35070(0, -1, 0)).getMaterial().isReplaceable() && this.mc.options.keyJump.isPressed() && this.m35075(this.mc.world.getBlockState(this.m35070(0, -1, 0))) != -1 && this.mc.player.sidewaysSpeed == 0.0f && this.mc.player.forwardSpeed == 0.0f) {
            this.mc.player.jump();
        }
        this.f35060 = this.mc.world.getBlockState(this.m35070(0, -1, 0));
        if (!this.f35060.getMaterial().isReplaceable()) {
            return;
        }
        this.f35062 = this.m35075(this.f35060);
        if (this.f35062 == -1) {
            return;
        }
        this.f35063 = this.mc.player.inventory.selectedSlot;
        this.mc.player.inventory.selectedSlot = this.f35062;
        boolean b = true;
        final BlockState blockState = this.mc.world.getBlockState(this.m35070(0, -2, 0));
        final BlockState blockState2 = this.mc.world.getBlockState(this.m35070(1, -1, 0));
        final BlockState blockState3 = this.mc.world.getBlockState(this.m35070(-1, -1, 0));
        final BlockState blockState4 = this.mc.world.getBlockState(this.m35070(0, -1, 1));
        final BlockState blockState5 = this.mc.world.getBlockState(this.m35070(0, -1, -1));
        if (!this.m35067(blockState) && !this.m35067(blockState2) && !this.m35067(blockState3) && !this.m35067(blockState4) && !this.m35067(blockState5)) {
            b = false;
        }
        if (!b) {
            boolean b2 = EnchantUtil.m35585(this.f35061, this.m35070(1, -1, 0), this.f35056.m33466(), false, true);
            if (!b2) {
                b2 = EnchantUtil.m35585(this.f35061, this.m35070(-1, -1, 0), this.f35056.m33466(), false, true);
            }
            if (!b2) {
                b2 = EnchantUtil.m35585(this.f35061, this.m35070(0, -1, 1), this.f35056.m33466(), false, true);
            }
            if (!b2) {
                b2 = EnchantUtil.m35585(this.f35061, this.m35070(0, -1, -1), this.f35056.m33466(), false, true);
            }
            if (!b2) {
                b2 = EnchantUtil.m35585(this.f35061, this.m35070(0, -2, 0), this.f35056.m33466(), false, true);
            }
            if (!b2) {
                System.err.println("[Meteor]: Scaffold: Failed to place extra block when going diagonally. This shouldn't happen.");
                return;
            }
            if (!this.m35065()) {
                return;
            }
        }
        EnchantUtil.m35585(this.f35061, this.m35070(0, -1, 0), this.f35056.m33466(), false, false);
        for (int i = 1; i < this.f35055.m33466(); ++i) {
            final int n = 1 + (i - 1) * 2;
            final int n2 = n / 2;
            for (int j = 0; j < n; ++j) {
                if (!this.m35065()) {
                    return;
                }
                EnchantUtil.m35585(this.f35061, this.m35070(j - n2, -1, i), this.f35056.m33466(), false, false);
            }
            for (int k = 0; k < n; ++k) {
                if (!this.m35065()) {
                    return;
                }
                EnchantUtil.m35585(this.f35061, this.m35070(k - n2, -1, -i), this.f35056.m33466(), false, false);
            }
            for (int l = 0; l < n; ++l) {
                if (!this.m35065()) {
                    return;
                }
                EnchantUtil.m35585(this.f35061, this.m35070(i, -1, l - n2), this.f35056.m33466(), false, false);
            }
            for (int n3 = 0; n3 < n; ++n3) {
                if (!this.m35065()) {
                    return;
                }
                EnchantUtil.m35585(this.f35061, this.m35070(-i, -1, n3 - n2), this.f35056.m33466(), false, false);
            }
            if (!this.m35065()) {
                return;
            }
            EnchantUtil.m35585(this.f35061, this.m35070(-i, -1, i), this.f35056.m33466(), false, false);
            if (!this.m35065()) {
                return;
            }
            EnchantUtil.m35585(this.f35061, this.m35070(i, -1, i), this.f35056.m33466(), false, false);
            if (!this.m35065()) {
                return;
            }
            EnchantUtil.m35585(this.f35061, this.m35070(-i, -1, -i), this.f35056.m33466(), false, false);
            if (!this.m35065()) {
                return;
            }
            EnchantUtil.m35585(this.f35061, this.m35070(i, -1, -i), this.f35056.m33466(), false, false);
        }
        this.mc.player.inventory.selectedSlot = this.f35063;
    }
    
    static {
        f35051 = new String[] { "scaffold", "Places blocks under you.", "safe-walk", "Safe walk.", "fast-tower", "To the sky.", "radius", "Radius.", "swing-hand", "Only client side.", "blacklist", "Stops you from placing certain blocks as scaffold.", "self-toggle", "Toggles when you run out of blocks.", "[Meteor]: Scaffold: Failed to place extra block when going diagonally. This shouldn't happen." };
    }
}
