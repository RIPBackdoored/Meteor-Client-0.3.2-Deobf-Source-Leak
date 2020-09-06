package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import meteorclient.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class Surround extends Module
{
    private static final String[] f32946;
    private final Settings f32947;
    private final Value<Boolean> f32948;
    private final Value<Boolean> f32949;
    private final Value<Boolean> f32950;
    private final Value<Boolean> f32951;
    private final Value<Boolean> f32952;
    private final Value<Boolean> f32953;
    private int f32954;
    private final class_2338.class_2339 f32955;
    private boolean f32956;
    @EventHandler
    private final Listener<c36575> f32957;
    
    public Surround() {
        super(Category.Combat, "surround", "Surrounds you with obsidian (or other blocks) to take less damage.");
        this.f32947 = this.f38675.m34572();
        this.f32948 = this.f32947.addValue((Value<Boolean>)new c34427.c34657().m34664("only-on-ground").m34667("Works only when you standing on ground.").m34670(true).m34679());
        this.f32949 = this.f32947.addValue((Value<Boolean>)new c34427.c34657().m34664("only-when-sneaking").m34667("Places blocks only when sneaking.").m34670(false).m34679());
        this.f32950 = this.f32947.addValue((Value<Boolean>)new c34427.c34657().m34664("turn-off").m34667("Turns off when placed.").m34670(false).m34679());
        this.f32951 = this.f32947.addValue((Value<Boolean>)new c34427.c34657().m34664("center").m34667("Moves you to the center of the block.").m34670(true).m34679());
        this.f32952 = this.f32947.addValue((Value<Boolean>)new c34427.c34657().m34664("instant").m34667("Places all blocks in one tick.").m34670(true).m34679());
        this.f32953 = this.f32947.addValue((Value<Boolean>)new c34427.c34657().m34664("disable-on-jump").m34667("Automatically disables when you jump.").m34670(true).m34679());
        this.f32955 = new class_2338.class_2339();
        this.f32957 = (Listener<c36575>)new Listener(this::m32985, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        if (this.f32951.m33466()) {
            this.mc.player.updatePosition(MathHelper.floor(this.mc.player.x) + 0.5, this.mc.player.y, MathHelper.floor(this.mc.player.z) + 0.5);
            this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2829(this.mc.player.x, this.mc.player.y, this.mc.player.z, this.mc.player.onGround));
        }
    }
    
    private boolean m32958(final int n, final int n2) {
        final boolean m32967 = this.m32967(n, 0, n2);
        if (this.f32956) {
            return m32967;
        }
        if (m32967) {
            return true;
        }
        for (int i = 0; i < 5; ++i) {
            int n3 = n;
            int n4 = 0;
            int n5 = n2;
            switch (i) {
                case 0: {
                    --n4;
                    break;
                }
                case 1: {
                    ++n3;
                    break;
                }
                case 2: {
                    --n3;
                    break;
                }
                case 3: {
                    ++n5;
                    break;
                }
                case 4: {
                    --n5;
                    break;
                }
            }
            final boolean m32968 = this.m32967(n3, n4, n5);
            if (this.f32956) {
                return m32968;
            }
            if (m32968) {
                this.m32967(n, 0, n2);
                return true;
            }
        }
        return false;
    }
    
    private boolean m32967(final int n, final int n2, final int n3) {
        this.m32974(n, n2, n3);
        final boolean b = !this.f32952.m33466() && this.mc.world.getBlockState((BlockPos)this.f32955).getBlock() == Blocks.field_10540;
        if (this.m32979()) {
            EnchantUtil.m35585(Blocks.field_10540.getDefaultState(), (BlockPos)this.f32955, true, false, true);
            this.m32983();
            if (!this.f32952.m33466()) {
                final boolean b2 = this.mc.world.getBlockState((BlockPos)this.f32955).getBlock() == Blocks.field_10540;
                if (!b && b2) {
                    this.f32956 = true;
                }
            }
        }
        return !this.mc.world.getBlockState((BlockPos)this.f32955).getMaterial().isReplaceable();
    }
    
    private void m32974(final int n, final int n2, final int n3) {
        this.f32955.method_10105((Entity)this.mc.player);
        this.f32955.method_10100(n, n2, n3);
    }
    
    private boolean m32979() {
        this.f32954 = this.mc.player.inventory.selectedSlot;
        for (int i = 0; i < 9; ++i) {
            if (this.mc.player.inventory.getInvStack(i).getItem() == Items.OBSIDIAN) {
                this.mc.player.inventory.selectedSlot = i;
                return true;
            }
        }
        return false;
    }
    
    private void m32983() {
        this.mc.player.inventory.selectedSlot = this.f32954;
    }
    
    private /* synthetic */ void m32985(final c36575 c36575) {
        if (this.f32953.m33466() && this.mc.options.keyJump.isPressed()) {
            this.m35300();
            return;
        }
        if (this.f32948.m33466() && !this.mc.player.onGround) {
            return;
        }
        if (this.f32949.m33466() && !this.mc.options.keySneak.isPressed()) {
            return;
        }
        this.f32956 = false;
        final boolean m32958 = this.m32958(1, 0);
        if (this.f32956) {
            return;
        }
        final boolean m32959 = this.m32958(-1, 0);
        if (this.f32956) {
            return;
        }
        final boolean m32960 = this.m32958(0, 1);
        if (this.f32956) {
            return;
        }
        final boolean m32961 = this.m32958(0, -1);
        if (this.f32956) {
            return;
        }
        if (this.f32950.m33466() && m32958 && m32959 && m32960 && m32961) {
            this.m35300();
        }
    }
    
    static {
        f32946 = new String[] { "surround", "Surrounds you with obsidian (or other blocks) to take less damage.", "only-on-ground", "Works only when you standing on ground.", "only-when-sneaking", "Places blocks only when sneaking.", "turn-off", "Turns off when placed.", "center", "Moves you to the center of the block.", "instant", "Places all blocks in one tick.", "disable-on-jump", "Automatically disables when you jump." };
    }
}
