package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.block.entity.*;
import net.minecraft.state.property.*;
import net.minecraft.block.enums.*;
import net.minecraft.util.math.*;
import minegame159.meteorclient.*;
import java.util.*;
import net.minecraft.block.*;

public class Storageesp extends Module
{
    private static final String[] f40108;
    private final Settings f40109;
    private final Value<List<class_2591<?>>> f40110;
    private final Value<c40107.Mode> f40111;
    private final Value<c37042> f40112;
    private final Value<c37042> f40113;
    private final Value<c37042> f40114;
    private final Value<c37042> f40115;
    private final Value<c37042> f40116;
    private final Value<Double> f40117;
    private final c37042 f40118;
    private final c37042 f40119;
    private boolean f40120;
    private int f40121;
    @EventHandler
    private final Listener<c36846> f40122;
    
    public Storageesp() {
        super(Category.Render, "storage-esp", "Shows storage blocks.");
        this.f40109 = this.f38675.m34572();
        this.f40110 = this.f40109.addValue((Value<List<class_2591<?>>>)new c32920.c32921().m32928("storage-blocks").m32931("Select storage blocks to display.").m32934(Arrays.asList(c32920.f35246)).m32943());
        this.f40111 = this.f40109.addValue((Value<c40107.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Rendering mode.").m36932((Enum)c40107.Mode.Both).m36941());
        this.f40112 = this.f40109.addValue((Value<c37042>)new c33179.c33180().m33187("chest").m33190("Color of chests.").m33193(new c37042(255, 160, 0, 255)).m33202());
        this.f40113 = this.f40109.addValue((Value<c37042>)new c33179.c33180().m33187("barrel").m33190("Color of barrels.").m33193(new c37042(255, 160, 0, 255)).m33202());
        this.f40114 = this.f40109.addValue((Value<c37042>)new c33179.c33180().m33187("shulker").m33190("Color of shulkers.").m33193(new c37042(255, 160, 0, 255)).m33202());
        this.f40115 = this.f40109.addValue((Value<c37042>)new c33179.c33180().m33187("ender-chest").m33190("Color of ender chests.").m33193(new c37042(120, 0, 255, 255)).m33202());
        this.f40116 = this.f40109.addValue((Value<c37042>)new c33179.c33180().m33187("other").m33190("Color of furnaces, dispenders, droppers and hoppers.").m33193(new c37042(140, 140, 140, 255)).m33202());
        this.f40117 = this.f40109.addValue((Value<Double>)new c37033.c38947().m38959("fade-distance").m38962("At which distance the color will fade out.").m38965(6.0).m38974(0.0).m38983(12.0).m38988());
        this.f40118 = new c37042(0, 0, 0, 0);
        this.f40119 = new c37042(0, 0, 0, 0);
        this.f40122 = (Listener<c36846>)new Listener(this::m40127, new Predicate[0]);
    }
    
    private void m40123(final BlockEntity blockEntity) {
        this.f40120 = false;
        if (!this.f40110.m33466().contains(blockEntity.getType())) {
            return;
        }
        if (blockEntity instanceof ChestBlockEntity) {
            this.f40118.m37049(this.f40112.m33466());
        }
        else if (blockEntity instanceof BarrelBlockEntity) {
            this.f40118.m37049(this.f40113.m33466());
        }
        else if (blockEntity instanceof ShulkerBoxBlockEntity) {
            this.f40118.m37049(this.f40114.m33466());
        }
        else if (blockEntity instanceof EnderChestBlockEntity) {
            this.f40118.m37049(this.f40115.m33466());
        }
        else {
            if (!(blockEntity instanceof FurnaceBlockEntity) && !(blockEntity instanceof DispenserBlockEntity) && !(blockEntity instanceof HopperBlockEntity)) {
                return;
            }
            this.f40118.m37049(this.f40116.m33466());
        }
        this.f40120 = true;
        if (this.f40111.m33466() == c40107.Mode.Sides || this.f40111.m33466() == c40107.Mode.Both) {
            this.f40119.m37049(this.f40118);
            final c37042 f40119 = this.f40119;
            f40119.f37048 -= 225;
            if (this.f40119.f37048 < 0) {
                this.f40119.f37048 = 0;
            }
        }
    }
    
    @Override
    public String m35302() {
        return Integer.toString(this.f40121);
    }
    
    private /* synthetic */ void m40127(final c36846 c36846) {
        this.f40121 = 0;
        for (final BlockEntity blockEntity : this.mc.world.blockEntities) {
            this.m40123(blockEntity);
            if (this.f40120) {
                double n = blockEntity.getPos().getX();
                final double n2 = blockEntity.getPos().getY();
                double n3 = blockEntity.getPos().getZ();
                double n4 = blockEntity.getPos().getX() + 1;
                double n5 = blockEntity.getPos().getY() + 1;
                double n6 = blockEntity.getPos().getZ() + 1;
                Direction facing = null;
                if (blockEntity instanceof ChestBlockEntity) {
                    final BlockState blockState = this.mc.world.getBlockState(blockEntity.getPos());
                    if ((blockState.getBlock() == Blocks.field_10034 || blockState.getBlock() == Blocks.field_10380) && blockState.get((Property)ChestBlock.CHEST_TYPE) != ChestType.field_12569) {
                        facing = ChestBlock.getFacing(blockState);
                    }
                }
                if (blockEntity instanceof ChestBlockEntity || blockEntity instanceof EnderChestBlockEntity) {
                    final double n7 = 0.0625;
                    if (facing != Direction.field_11039) {
                        n += n7;
                    }
                    if (facing != Direction.field_11043) {
                        n3 += n7;
                    }
                    if (facing != Direction.field_11034) {
                        n4 -= n7;
                    }
                    n5 -= n7 * 2.0;
                    if (facing != Direction.field_11035) {
                        n6 -= n7;
                    }
                }
                final double squaredDistanceTo = this.mc.player.squaredDistanceTo((double)(blockEntity.getPos().getX() + 1), (double)(blockEntity.getPos().getY() + 1), (double)(blockEntity.getPos().getZ() + 1));
                double n8 = 1.0;
                if (squaredDistanceTo <= this.f40117.m33466() * this.f40117.m33466()) {
                    n8 = squaredDistanceTo / (this.f40117.m33466() * this.f40117.m33466());
                }
                final int f37048 = this.f40118.f37048;
                final int f37049 = this.f40119.f37048;
                final c37042 f37050 = this.f40118;
                f37050.f37048 *= (int)n8;
                final c37042 f37051 = this.f40119;
                f37051.f37048 *= (int)n8;
                if (n8 >= 0.075) {
                    if (this.f40111.m33466() == c40107.Mode.Lines) {
                        c39337.m39418(n, n2, n3, n4, n5, n6, this.f40118, facing);
                    }
                    else if (this.f40111.m33466() == c40107.Mode.Sides) {
                        c39337.m39444(n, n2, n3, n4, n5, n6, this.f40119, facing);
                    }
                    else {
                        c39337.m39418(n, n2, n3, n4, n5, n6, this.f40118, facing);
                        c39337.m39444(n, n2, n3, n4, n5, n6, this.f40119, facing);
                    }
                }
                this.f40118.f37048 = f37048;
                this.f40119.f37048 = f37049;
                ++this.f40121;
            }
        }
    }
    
    static {
        f40108 = new String[] { "storage-esp", "Shows storage blocks.", "storage-blocks", "Select storage blocks to display.", "mode", "Rendering mode.", "chest", "Color of chests.", "barrel", "Color of barrels.", "shulker", "Color of shulkers.", "ender-chest", "Color of ender chests.", "other", "Color of furnaces, dispenders, droppers and hoppers.", "fade-distance", "At which distance the color will fade out." };
    }
}
