package minegame159.meteorclient;

import net.minecraft.item.*;

public class c38636 extends c31923
{
    public ItemStack f38637;
    
    public c38636(final ItemStack f38637) {
        super();
        this.f38637 = f38637;
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 16.0;
        this.f31928 = 16.0;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        c36250.m36365(this.f31925, this.f31926, this.f38637);
    }
}
