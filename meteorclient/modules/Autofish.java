package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.item.*;
import meteorclient.util.*;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.entity.projectile.*;

public class Autofish extends Module
{
    private static final String[] f36890;
    private final Settings f36891;
    private final Settings f36892;
    private final Value<Boolean> f36893;
    private final Value<Integer> f36894;
    private final Value<Integer> f36895;
    private final Value<Integer> f36896;
    private final Value<Double> f36897;
    private boolean f36898;
    private int f36899;
    private int f36900;
    private int f36901;
    private boolean f36902;
    private int f36903;
    @EventHandler
    private Listener<c36628> f36904;
    @EventHandler
    private Listener<c36575> f36905;
    @EventHandler
    private Listener<c38944> f36906;
    
    public Autofish() {
        super(Category.Player, "auto-fish", "Automatically fishes.");
        this.f36891 = this.f38675.m34572();
        this.f36892 = this.f38675.m34582("Splash Sound Range Detection", "Allows you to use multiple accounts next to each other.", "splash-range-detection", false);
        this.f36893 = this.f36891.addValue((Value<Boolean>)new c34427.c34657().m34664("auto-cast").m34667("Automatically casts when not fishing.").m34670(true).m34679());
        this.f36894 = this.f36891.addValue((Value<Integer>)new c32369.c32370().m32381("ticks-auto-cast").m32384("Ticks to wait before auto casting.").m32387(10).m32396(0).m32405(60).m32408());
        this.f36895 = this.f36891.addValue((Value<Integer>)new c32369.c32370().m32381("ticks-catch").m32384("Ticks to wait before catching the fish").m32387(6).m32396(0).m32405(60).m32408());
        this.f36896 = this.f36891.addValue((Value<Integer>)new c32369.c32370().m32381("ticks-throw").m32384("Ticks to wait before throwing the bobber.").m32387(14).m32396(0).m32405(60).m32408());
        this.f36897 = this.f36892.addValue((Value<Double>)new c37033.c38947().m38959("splash-detection-range").m38962("Detection range of splash sound. Low values will not work when TPS is low.").m38965(10.0).m38974(0.0).m38988());
        this.f36904 = (Listener<c36628>)new Listener(this::m36914, new Predicate[0]);
        this.f36905 = (Listener<c36575>)new Listener(this::m36911, new Predicate[0]);
        this.f36906 = (Listener<c38944>)new Listener(this::m36908, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f36898 = false;
        this.f36902 = false;
        this.f36903 = 0;
    }
    
    private /* synthetic */ void m36908(final c38944 c38944) {
        if (this.mc.options.keyUse.isPressed()) {
            this.f36898 = false;
        }
    }
    
    private /* synthetic */ void m36911(final c36575 c36575) {
        if (this.f36903 <= 0) {
            this.f36903 = 30;
            if (this.f36893.m33466() && !this.f36898 && !this.f36902 && this.mc.player.fishHook == null && this.mc.player.getMainHandStack().getItem() instanceof FishingRodItem) {
                this.f36901 = 0;
                this.f36902 = true;
            }
        }
        else {
            --this.f36903;
        }
        if (this.f36902) {
            ++this.f36901;
            if (this.f36901 > this.f36894.m33466()) {
                this.f36902 = false;
                EnchantUtil.m35624();
            }
        }
        if (this.f36898 && this.f36899 <= 0) {
            if (this.f36900 == 0) {
                EnchantUtil.m35624();
                this.f36899 = this.f36896.m33466();
                this.f36900 = 1;
            }
            else if (this.f36900 == 1) {
                EnchantUtil.m35624();
                this.f36898 = false;
            }
        }
        --this.f36899;
    }
    
    private /* synthetic */ void m36914(final c36628 c36628) {
        final PlaySoundS2CPacket f36629 = c36628.f36629;
        final FishingBobberEntity fishHook = this.mc.player.fishHook;
        if (f36629.getSound().getId().getPath().equals("entity.fishing_bobber.splash") && (!this.f36892.m33970() || EnchantUtil.m35567(fishHook.x, fishHook.y, fishHook.z, f36629.getX(), f36629.getY(), f36629.getZ()) <= this.f36897.m33466())) {
            this.f36898 = true;
            this.f36899 = this.f36895.m33466();
            this.f36900 = 0;
        }
    }
    
    static {
        f36890 = new String[] { "auto-fish", "Automatically fishes.", "Splash Sound Range Detection", "Allows you to use multiple accounts next to each other.", "splash-range-detection", "auto-cast", "Automatically casts when not fishing.", "ticks-auto-cast", "Ticks to wait before auto casting.", "ticks-catch", "Ticks to wait before catching the fish", "ticks-throw", "Ticks to wait before throwing the bobber.", "splash-detection-range", "Detection range of splash sound. Low values will not work when TPS is low.", "entity.fishing_bobber.splash" };
    }
}
