package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.world.dimension.*;
import net.minecraft.client.gui.screen.*;

public class c32353 extends c36715
{
    private static final c37042 f36660;
    private static final c37042 f36661;
    private final c33820 f36662;
    
    public c32353(final c33820 f36662) {
        super();
        this.f36662 = f36662;
        this.m31937(new c34004(null));
        final c39081 c38265 = this.m31937(new c39081(f36662.f33823)).m39632();
        boolean b = false;
        final DimensionType dimension = MinecraftClient.getInstance().player.dimension;
        if (f36662.f33832 && dimension == DimensionType.field_13072) {
            b = true;
        }
        else if (f36662.f33833 && dimension == DimensionType.field_13076) {
            b = true;
        }
        else if (f36662.f33834 && dimension == DimensionType.field_13078) {
            b = true;
        }
        c38265.f39082 = (b ? c32353.f36660 : c32353.f36661);
        this.m31937(new c38264(f36662.f33829)).m39632().f38265 = (c38264 -> {
            f36662.f33829 = c38264.f38266;
            c34924.f34927.m37303();
            return;
        });
        final c36715 c38266 = this.m31937(new c36715()).m39587().m39589().m39632();
        c38266.m31937(new c38616(c36250.f36261)).m39632().f38618 = (p1 -> MinecraftClient.getInstance().openScreen((Screen)new c33684(f36662)));
        c38266.m31937(new c36419()).m39632().f36420 = (p1 -> c34924.f34927.m34938(f36662));
    }
    
    private static /* synthetic */ void m36663(final c33820 c33820, final c36419 c33821) {
        c34924.f34927.m34938(c33820);
    }
    
    private static /* synthetic */ void m36666(final c33820 c33820, final c38616 c33821) {
        MinecraftClient.getInstance().openScreen((Screen)new c33684(c33820));
    }
    
    private static /* synthetic */ void m36669(final c33820 c33820, final c38264 c33821) {
        c33820.f33829 = c33821.f38266;
        c34924.f34927.m37303();
    }
    
    static /* synthetic */ c33820 m36672(final c32353 c32353) {
        return c32353.f36662;
    }
    
    static {
        f36660 = new c37042(255, 255, 255);
        f36661 = new c37042(200, 200, 200);
    }
    
    private class c34004 extends c31923
    {
        final /* synthetic */ c32353 f34005;
        
        private c34004(final c32353 f34005) {
            this.f34005 = f34005;
            super();
        }
        
        @Override
        protected void m31978() {
            this.f31927 = 16.0;
            this.f31928 = 16.0;
        }
        
        @Override
        protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
            c36250.m36285(() -> this.f34005.f36662.m33843(this.f31925, this.f31926, 0.0));
        }
        
        private /* synthetic */ void m34012() {
            this.f34005.f36662.m33843(this.f31925, this.f31926, 0.0);
        }
        
        c34004(final c32353 c32353, final c32354 c32354) {
            this(c32353);
        }
    }
    
    static class c32354
    {
    }
}
