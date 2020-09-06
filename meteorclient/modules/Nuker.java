package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import meteorclient.util.*;
import net.minecraft.world.*;
import net.minecraft.util.shape.*;
import java.util.function.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import java.util.*;

public class Nuker extends Module
{
    private static final String[] f39711;
    private final Settings f39712;
    private final Value<c39710.Mode> f39713;
    private final Value<Boolean> f39714;
    private final Value<List<class_2248>> f39715;
    private final Value<Boolean> f39716;
    private final Value<Double> f39717;
    private final Value<c39710.SortMode> f39718;
    private final Value<Boolean> f39719;
    private final c32900<class_2338.class_2339> f39720;
    private final List<class_2338.class_2339> f39721;
    private final class_2338.class_2339 f39722;
    private final class_2338.class_2339 f39723;
    @EventHandler
    private final Listener<c36575> f39724;
    
    public Nuker() {
        super(Category.Misc, "nuker", "Breaks blocks around you.");
        this.f39712 = this.f38675.m34572();
        this.f39713 = this.f39712.addValue((Value<c39710.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Which blocks to break.").m36932((Enum)c39710.Mode.All).m36941());
        this.f39714 = this.f39712.addValue((Value<Boolean>)new c34427.c34657().m34664("packet-mine").m34667("Mines blocks using packet spamming.").m34670(false).m34679());
        this.f39715 = this.f39712.addValue((Value<List<class_2248>>)new c31769.c36992().m36999("selected-blocks").m37002("Which blocks to mine when only selected is true.").m37005(new ArrayList<class_2248>(0)).m37014());
        this.f39716 = this.f39712.addValue((Value<Boolean>)new c34427.c34657().m34664("only-selected").m34667("Only mines selected blocks.").m34670(false).m34679());
        this.f39717 = this.f39712.addValue((Value<Double>)new c37033.c38947().m38959("range").m38962("Break range.").m38965(5.0).m38974(0.0).m38988());
        this.f39718 = this.f39712.addValue((Value<c39710.SortMode>)new c36601.c36919<Enum>().m36926("sort-mode").m36929("Which blocks to mine first.").m36932((Enum)c39710.SortMode.Closest).m36941());
        this.f39719 = this.f39712.addValue((Value<Boolean>)new c34427.c34657().m34664("no-particles").m34667("Disables block break particles.").m34670(false).m34679());
        this.f39720 = new c32900<class_2338.class_2339>(class_2338.class_2339::new);
        this.f39721 = new ArrayList<class_2338.class_2339>();
        this.f39722 = new class_2338.class_2339();
        this.f39723 = new class_2338.class_2339();
        this.f39724 = (Listener<c36575>)new Listener(this::m39728, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        this.mc.interactionManager.cancelBlockBreaking();
    }
    
    public boolean m39726() {
        return this.m35315() && this.f39719.m33466();
    }
    
    private /* synthetic */ void m39728(final c36575 c36575) {
        if (this.mc.world.getBlockState((BlockPos)this.f39723).getBlock() != Blocks.field_10124) {
            this.mc.interactionManager.method_2902((BlockPos)this.f39723, Direction.field_11036);
            return;
        }
        final double n = this.mc.player.x - 0.5;
        final double y = this.mc.player.y;
        final double n2 = this.mc.player.z - 0.5;
        final int n3 = (int)Math.floor(n - this.f39717.m33466());
        final int n4 = (int)Math.floor(y - this.f39717.m33466());
        final int n5 = (int)Math.floor(n2 - this.f39717.m33466());
        final int n6 = (int)Math.floor(n + this.f39717.m33466());
        final int n7 = (int)Math.floor(y + this.f39717.m33466());
        final int n8 = (int)Math.floor(n2 + this.f39717.m33466());
        final double pow = Math.pow(this.f39717.m33466(), 2.0);
        for (int i = n4; i <= n7; ++i) {
            boolean b = false;
            for (int j = n3; j <= n6; ++j) {
                for (int k = n5; k <= n8; ++k) {
                    if (EnchantUtil.m35557(n, y, n2, j, i, k) <= pow) {
                        this.f39722.method_10103(j, i, k);
                        final BlockState blockState = this.mc.world.getBlockState((BlockPos)this.f39722);
                        if (blockState.getOutlineShape((BlockView)this.mc.world, (BlockPos)this.f39722) != VoxelShapes.empty()) {
                            if (this.f39713.m33466() == c39710.Mode.Flatten && i < this.mc.player.y) {
                                b = true;
                                break;
                            }
                            if (this.f39713.m33466() != c39710.Mode.Smash || blockState.getHardness((BlockView)this.mc.world, (BlockPos)this.f39722) == 0.0f) {
                                if (!this.f39716.m33466() || this.f39715.m33466().contains(blockState.getBlock())) {
                                    final class_2338.class_2339 class_2339 = this.f39720.m32903();
                                    class_2339.method_10103(j, i, k);
                                    this.f39721.add(class_2339);
                                }
                            }
                        }
                    }
                }
                if (b) {
                    break;
                }
            }
        }
        if (this.f39718.m33466() != c39710.SortMode.None) {
            this.f39721.sort(Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::m39750));
        }
        boolean b2 = false;
        for (final class_2338.class_2339 class_2340 : this.f39721) {
            if (!this.f39714.m33466()) {
                if (!this.f39723.equals((Object)class_2340)) {
                    this.mc.interactionManager.cancelBlockBreaking();
                    this.mc.interactionManager.attackBlock((BlockPos)class_2340, Direction.field_11036);
                    this.mc.player.swingHand(Hand.field_5808);
                }
                this.f39723.method_10101((Vec3i)class_2340);
                this.mc.interactionManager.method_2902((BlockPos)class_2340, Direction.field_11036);
                this.mc.player.swingHand(Hand.field_5808);
                b2 = true;
                break;
            }
            this.mc.getNetworkHandler().sendPacket((Packet)new PlayerActionC2SPacket(class_2846.class_2847.field_12968, (BlockPos)class_2340, Direction.field_11036));
            this.mc.getNetworkHandler().sendPacket((Packet)new PlayerActionC2SPacket(class_2846.class_2847.field_12973, (BlockPos)class_2340, Direction.field_11036));
        }
        if (!b2) {
            this.mc.interactionManager.cancelBlockBreaking();
        }
        final Iterator<class_2338.class_2339> iterator2 = this.f39721.iterator();
        while (iterator2.hasNext()) {
            this.f39720.m32905(iterator2.next());
        }
        this.f39721.clear();
    }
    
    private /* synthetic */ double m39750(final double n, final double n2, final double n3, final class_2338.class_2339 class_2339) {
        return EnchantUtil.m35557(n, n2, n3, class_2339.getX(), class_2339.getY(), class_2339.getZ()) * ((this.f39718.m33466() == c39710.SortMode.Closest) ? 1 : -1);
    }
    
    static {
        f39711 = new String[] { "nuker", "Breaks blocks around you.", "mode", "Which blocks to break.", "packet-mine", "Mines blocks using packet spamming.", "selected-blocks", "Which blocks to mine when only selected is true.", "only-selected", "Only mines selected blocks.", "range", "Break range.", "sort-mode", "Which blocks to mine first.", "no-particles", "Disables block break particles." };
    }
}
