package minegame159.meteorclient;

import meteorclient.modules.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.*;
import net.minecraft.util.shape.*;

private class c38708
{
    private static final int f38709 = 2;
    private static final int f38710 = 4;
    private static final int f38711 = 8;
    private static final int f38712 = 16;
    private static final int f38713 = 32;
    private static final int f38714 = 64;
    private static final int f38715 = 128;
    private static final int f38716 = 256;
    private static final int f38717 = 512;
    private static final int f38718 = 1024;
    private static final int f38719 = 2048;
    private static final int f38720 = 4096;
    private static final int f38721 = 8192;
    private static final int f38722 = 16384;
    private static final int f38723 = 32768;
    private static final int f38724 = 65536;
    private static final int f38725 = 131072;
    private static final int f38726 = 262144;
    private int f38727;
    private int f38728;
    private int f38729;
    private BlockState f38730;
    private int f38731;
    final /* synthetic */ Search f38732;
    
    private c38708(final Search f38732) {
        this.f38732 = f38732;
        super();
    }
    
    public void m38733(final BlockPos blockPos) {
        this.f38727 = blockPos.getX();
        this.f38728 = blockPos.getY();
        this.f38729 = blockPos.getZ();
        this.f38730 = Search.m38197(this.f38732).world.getBlockState(blockPos);
        this.m38736();
    }
    
    public void m38736() {
        this.f38731 = 0;
        if (this.m38738(0.0, 0.0, 1.0)) {
            this.f38731 |= 0x2;
        }
        if (this.m38738(1.0, 0.0, 1.0)) {
            this.f38731 |= 0x4;
        }
        if (this.m38738(1.0, 0.0, 0.0)) {
            this.f38731 |= 0x8;
        }
        if (this.m38738(1.0, 0.0, -1.0)) {
            this.f38731 |= 0x10;
        }
        if (this.m38738(0.0, 0.0, -1.0)) {
            this.f38731 |= 0x20;
        }
        if (this.m38738(-1.0, 0.0, -1.0)) {
            this.f38731 |= 0x40;
        }
        if (this.m38738(-1.0, 0.0, 0.0)) {
            this.f38731 |= 0x80;
        }
        if (this.m38738(-1.0, 0.0, 1.0)) {
            this.f38731 |= 0x100;
        }
        if (this.m38738(0.0, 1.0, 0.0)) {
            this.f38731 |= 0x200;
        }
        if (this.m38738(0.0, 1.0, 1.0)) {
            this.f38731 |= 0x400;
        }
        if (this.m38738(0.0, 1.0, -1.0)) {
            this.f38731 |= 0x800;
        }
        if (this.m38738(1.0, 1.0, 0.0)) {
            this.f38731 |= 0x1000;
        }
        if (this.m38738(-1.0, 1.0, 0.0)) {
            this.f38731 |= 0x2000;
        }
        if (this.m38738(0.0, -1.0, 0.0)) {
            this.f38731 |= 0x4000;
        }
        if (this.m38738(0.0, -1.0, 1.0)) {
            this.f38731 |= 0x8000;
        }
        if (this.m38738(0.0, -1.0, -1.0)) {
            this.f38731 |= 0x10000;
        }
        if (this.m38738(1.0, -1.0, 0.0)) {
            this.f38731 |= 0x20000;
        }
        if (this.m38738(-1.0, -1.0, 0.0)) {
            this.f38731 |= 0x40000;
        }
    }
    
    private boolean m38738(final double n, final double n2, final double n3) {
        Search.m38199().method_10102(this.f38727 + n, this.f38728 + n2, this.f38729 + n3);
        return Search.m38200(this.f38732).world.getBlockState((BlockPos)Search.m38199()).getBlock() == this.f38730.getBlock();
    }
    
    public void m38743(final c36846 c36846) {
        double n = this.f38727;
        double n2 = this.f38728;
        double n3 = this.f38729;
        double n4 = this.f38727 + 1;
        double n5 = this.f38728 + 1;
        double n6 = this.f38729 + 1;
        boolean shapeFullCube = true;
        if (!Search.m38202(this.f38732).m33466()) {
            final VoxelShape outlineShape = this.f38730.getOutlineShape((BlockView)Search.m38204(this.f38732).world, (BlockPos)Search.m38206(this.f38732));
            shapeFullCube = Block.isShapeFullCube(outlineShape);
            if (!outlineShape.isEmpty()) {
                n = this.f38727 + outlineShape.getMinimum(class_2350.class_2351.field_11048);
                n2 = this.f38728 + outlineShape.getMinimum(class_2350.class_2351.field_11052);
                n3 = this.f38729 + outlineShape.getMinimum(class_2350.class_2351.field_11051);
                n4 = this.f38727 + outlineShape.getMaximum(class_2350.class_2351.field_11048);
                n5 = this.f38728 + outlineShape.getMaximum(class_2350.class_2351.field_11052);
                n6 = this.f38729 + outlineShape.getMaximum(class_2350.class_2351.field_11051);
            }
        }
        if (shapeFullCube) {
            if (((this.f38731 & 0x80) != 0x80 && (this.f38731 & 0x20) != 0x20) || ((this.f38731 & 0x80) == 0x80 && (this.f38731 & 0x20) == 0x20 && (this.f38731 & 0x40) != 0x40)) {
                c39337.m39404(n, n2, n3, n, n5, n3, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x80) != 0x80 && (this.f38731 & 0x2) != 0x2) || ((this.f38731 & 0x80) == 0x80 && (this.f38731 & 0x2) == 0x2 && (this.f38731 & 0x100) != 0x100)) {
                c39337.m39404(n, n2, n6, n, n5, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x8) != 0x8 && (this.f38731 & 0x20) != 0x20) || ((this.f38731 & 0x8) == 0x8 && (this.f38731 & 0x20) == 0x20 && (this.f38731 & 0x10) != 0x10)) {
                c39337.m39404(n4, n2, n3, n4, n5, n3, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x8) != 0x8 && (this.f38731 & 0x2) != 0x2) || ((this.f38731 & 0x8) == 0x8 && (this.f38731 & 0x2) == 0x2 && (this.f38731 & 0x4) != 0x4)) {
                c39337.m39404(n4, n2, n6, n4, n5, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x20) != 0x20 && (this.f38731 & 0x4000) != 0x4000) || ((this.f38731 & 0x20) != 0x20 && (this.f38731 & 0x10000) == 0x10000)) {
                c39337.m39404(n, n2, n3, n4, n2, n3, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x2) != 0x2 && (this.f38731 & 0x4000) != 0x4000) || ((this.f38731 & 0x2) != 0x2 && (this.f38731 & 0x8000) == 0x8000)) {
                c39337.m39404(n, n2, n6, n4, n2, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x20) != 0x20 && (this.f38731 & 0x200) != 0x200) || ((this.f38731 & 0x20) != 0x20 && (this.f38731 & 0x800) == 0x800)) {
                c39337.m39404(n, n5, n3, n4, n5, n3, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x2) != 0x2 && (this.f38731 & 0x200) != 0x200) || ((this.f38731 & 0x2) != 0x2 && (this.f38731 & 0x400) == 0x400)) {
                c39337.m39404(n, n5, n6, n4, n5, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x80) != 0x80 && (this.f38731 & 0x4000) != 0x4000) || ((this.f38731 & 0x80) != 0x80 && (this.f38731 & 0x40000) == 0x40000)) {
                c39337.m39404(n, n2, n3, n, n2, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x8) != 0x8 && (this.f38731 & 0x4000) != 0x4000) || ((this.f38731 & 0x8) != 0x8 && (this.f38731 & 0x20000) == 0x20000)) {
                c39337.m39404(n4, n2, n3, n4, n2, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x80) != 0x80 && (this.f38731 & 0x200) != 0x200) || ((this.f38731 & 0x80) != 0x80 && (this.f38731 & 0x2000) == 0x2000)) {
                c39337.m39404(n, n5, n3, n, n5, n6, Search.m38208(this.f38732).m33466());
            }
            if (((this.f38731 & 0x8) != 0x8 && (this.f38731 & 0x200) != 0x200) || ((this.f38731 & 0x8) != 0x8 && (this.f38731 & 0x1000) == 0x1000)) {
                c39337.m39404(n4, n5, n3, n4, n5, n6, Search.m38208(this.f38732).m33466());
            }
        }
        else {
            c39337.m39427(n, n2, n3, n4, n5, n6, Search.m38208(this.f38732).m33466());
        }
        if (Search.m38210(this.f38732).m33970()) {
            c39337.m39404(Search.m38212(this.f38732).x - (Search.m38214(this.f38732).cameraEntity.x - c36846.f36848), Search.m38212(this.f38732).y - (Search.m38216(this.f38732).cameraEntity.y - c36846.f36849), Search.m38212(this.f38732).z - (Search.m38218(this.f38732).cameraEntity.z - c36846.f36850), this.f38727 + 0.5, this.f38728 + 0.5, this.f38729 + 0.5f, Search.m38220(this.f38732).m33466());
        }
    }
    
    public boolean m38754(final BlockPos blockPos) {
        return this.f38727 == blockPos.getX() && this.f38728 == blockPos.getY() && this.f38729 == blockPos.getZ();
    }
    
    c38708(final Search search, final c34640.c34641 c34641) {
        this(search);
    }
}
