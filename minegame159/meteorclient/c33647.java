package minegame159.meteorclient;

import meteorclient.*;
import net.minecraft.client.*;
import meteorclient.util.*;

public class c33647 extends c31923
{
    private final c38667 f33648;
    private final double f33649;
    private boolean f33650;
    private double f33651;
    private double f33652;
    private double f33653;
    private double f33654;
    
    public c33647(final c38667 f33648) {
        super();
        this.f33648 = f33648;
        this.f33649 = MeteorClient.smallFont.m33815(f33648.f38672);
        this.f31934 = f33648.f38673;
        if (f33648 instanceof Module && ((Module)f33648).m35315()) {
            this.f33651 = 1.0;
            this.f33652 = 1.0;
            this.f33653 = 1.0;
            this.f33654 = 1.0;
        }
        else {
            this.f33651 = 0.0;
            this.f33652 = -1.0;
            this.f33653 = 0.0;
            this.f33654 = -1.0;
        }
    }
    
    @Override
    protected void m31978() {
        this.f31927 = 2.0 + this.f33649 + 2.0;
        this.f31928 = 2.0 + MeteorClient.smallFont.m33813() + 2.0;
    }
    
    @Override
    protected boolean m32023(final int n) {
        return this.f31932 && (this.f33650 = true);
    }
    
    @Override
    protected boolean m32030(final int n) {
        if (this.f33650) {
            this.f33650 = false;
            if (n == 0) {
                this.f33648.m38684(MinecraftClient.getInstance().world != null);
            }
            else if (n == 1) {
                this.f33648.m38682();
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected void m31999(final c36250 c36250, final double n, final double n2, final double n3) {
        if (this.f33648 instanceof Module) {
            if (((Module)this.f33648).m35315()) {
                this.f33652 = 1.0;
                this.f33654 = 1.0;
            }
            else {
                this.f33652 = -1.0;
                this.f33654 = -1.0;
            }
        }
        if (this.f31932) {
            this.f33652 = 1.0;
        }
        else if (this.f33648 instanceof Module) {
            if (!((Module)this.f33648).m35315()) {
                this.f33652 = -1.0;
            }
        }
        else {
            this.f33652 = -1.0;
        }
        this.f33651 += n3 / 10.0 * this.f33652;
        this.f33651 = EnchantUtil.m35644(this.f33651, 0.0, 1.0);
        this.f33653 += n3 / 10.0 * this.f33654;
        this.f33653 = EnchantUtil.m35644(this.f33653, 0.0, 1.0);
        if (this.f33651 > 0.0 || this.f33653 > 0.0) {
            c36250.m36337(this.f31925, this.f31926, this.f31927 * this.f33651, this.f31928, c31870.f37895.f37916);
            c36250.m36337(this.f31925, this.f31926 + this.f31928 * (1.0 - this.f33653), 1.0, this.f31928 * this.f33653, c31870.f37895.f37915);
        }
        c36250.m36370(this.f33648.f38672, this.f31925 + this.f31927 / 2.0 - this.f33649 / 2.0, this.f31926 + 2.0, c31870.f37895.f37897, false);
    }
}
