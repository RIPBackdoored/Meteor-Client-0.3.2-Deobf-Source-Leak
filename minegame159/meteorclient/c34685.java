package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import meteorclient.util.*;
import java.util.*;
import net.minecraft.network.packet.s2c.play.*;

public class c34685 implements Listenable
{
    public static c34685 f34686;
    private final float[] f34687;
    private int f34688;
    private long f34689;
    private long f34690;
    @EventHandler
    private Listener<c39306> f34691;
    @EventHandler
    private Listener<c33675> f34692;
    
    private c34685() {
        super();
        this.f34687 = new float[20];
        this.f34688 = 0;
        this.f34689 = -1L;
        this.f34691 = (Listener<c39306>)new Listener(c39306 -> {
            if (c39306.f39307 instanceof WorldTimeUpdateS2CPacket) {
                if (this.f34689 != -1L) {
                    this.f34687[this.f34688 % this.f34687.length] = EnchantUtil.m35640(20.0f / ((System.currentTimeMillis() - this.f34689) / 1000.0f), 0.0f, 20.0f);
                    ++this.f34688;
                }
                this.f34689 = System.currentTimeMillis();
            }
        }, new Predicate[0]);
        this.f34692 = (Listener<c33675>)new Listener(c33675 -> {
            Arrays.fill(this.f34687, 0.0f);
            this.f34688 = 0;
            this.f34689 = -1L;
            this.f34690 = System.currentTimeMillis();
        }, new Predicate[0]);
        MeteorClient.eventBus.subscribe((Listenable)this);
    }
    
    public float m34693() {
        if (System.currentTimeMillis() - this.f34690 < 4000L) {
            return 20.0f;
        }
        float n = 0.0f;
        float n2 = 0.0f;
        for (final float n3 : this.f34687) {
            if (n3 > 0.0f) {
                n2 += n3;
                ++n;
            }
        }
        return EnchantUtil.m35640(n2 / n, 0.0f, 20.0f);
    }
    
    public float m34698() {
        if (System.currentTimeMillis() - this.f34690 < 4000L) {
            return 0.0f;
        }
        return (System.currentTimeMillis() - this.f34689) / 1000.0f;
    }
    
    private /* synthetic */ void m34700(final c33675 c33675) {
        Arrays.fill(this.f34687, 0.0f);
        this.f34688 = 0;
        this.f34689 = -1L;
        this.f34690 = System.currentTimeMillis();
    }
    
    private /* synthetic */ void m34703(final c39306 c39306) {
        if (c39306.f39307 instanceof WorldTimeUpdateS2CPacket) {
            if (this.f34689 != -1L) {
                this.f34687[this.f34688 % this.f34687.length] = EnchantUtil.m35640(20.0f / ((System.currentTimeMillis() - this.f34689) / 1000.0f), 0.0f, 20.0f);
                ++this.f34688;
            }
            this.f34689 = System.currentTimeMillis();
        }
    }
    
    static {
        c34685.f34686 = new c34685();
    }
}
