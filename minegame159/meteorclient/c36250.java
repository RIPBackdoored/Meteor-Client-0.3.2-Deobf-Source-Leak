package minegame159.meteorclient;

import net.minecraft.util.*;
import meteorclient.util.*;
import net.minecraft.client.*;
import net.minecraft.client.render.*;
import java.util.*;
import net.minecraft.item.*;

public class c36250
{
    private static final String[] f36251;
    public static final c36250 f36252;
    private static final c37042 f36253;
    private static final c37042 f36254;
    private static final Identifier f36255;
    private static final int f36256 = 97;
    private static final int f36257 = 32;
    public static final c33493 f36258;
    public static final c33493 f36259;
    public static final c33493 f36260;
    public static final c33493 f36261;
    final c32900<c40045> f36262;
    final c32900<c38644> f36263;
    final c32900<c37997> f36264;
    final c32900<c33867> f36265;
    final c32900<c32484> f36266;
    final c32900<c32608> f36267;
    private c32608 f36268;
    private c32608 f36269;
    private final List<Runnable> f36270;
    private c32787 f36271;
    
    public c36250() {
        super();
        this.f36262 = new c32900<c40045>(c40045::new);
        this.f36263 = new c32900<c38644>(c38644::new);
        this.f36264 = new c32900<c37997>(c37997::new);
        this.f36265 = new c32900<c33867>(c33867::new);
        this.f36266 = new c32900<c32484>(c32484::new);
        this.f36267 = new c32900<c32608>(c32608::new);
        this.f36270 = new ArrayList<Runnable>();
    }
    
    void m36272() {
        if (!c36524.m36534()) {
            c36524.m36530();
            MeteorClient.smallFont.m33789();
        }
    }
    
    public void m36274() {
        final c32608 m32619 = this.f36267.m32903().m32619(null, 0.0, 0.0, EnchantUtil.m35545(), EnchantUtil.m35546(), false, false);
        this.f36269 = m32619;
        this.f36268 = m32619;
    }
    
    void m36276() {
        if (c36524.m36534()) {
            MinecraftClient.getInstance().getTextureManager().bindTexture(c36250.f36255);
            c36524.m36531(true);
            MeteorClient.smallFont.m33793();
        }
    }
    
    public void m36278() {
        this.f36268.m32628(this);
        this.f36267.m32905(this.f36268);
        this.f36268 = null;
        final Iterator<Runnable> iterator = this.f36270.iterator();
        while (iterator.hasNext()) {
            iterator.next().run();
        }
        this.f36270.clear();
        if (this.f36271 != null) {
            final double n = ((c32484)this.f36271).f32486 - 2.0;
            final double n2 = ((c32484)this.f36271).f32487 - 2.0;
            final double n3 = MeteorClient.smallFont.m33815(((c32484)this.f36271).f32485) + 4.0;
            final double n4 = MeteorClient.smallFont.m33813() + 4.0;
            c39337.m39340(null, 4, VertexFormats.POSITION_COLOR);
            c39337.m39347(n, n2, 0.0, n + n3, n2, 0.0, n + n3, n2 + n4, 0.0, n, n2 + n4, 0.0, c33436.f34122.f34126.f37900);
            c39337.m39346();
            this.f36271.m32788(this);
            this.f36271.m32789(this);
            this.f36271 = null;
        }
    }
    
    public void m36285(final Runnable runnable) {
        this.f36270.add(runnable);
    }
    
    public void m36288(final double n, final double n2, final double n3, final double n4, final boolean b) {
        final c32608 m32619 = this.f36267.m32903().m32619(this.f36269, n, n2, n3, n4, true, b);
        this.f36269.f32616.add(m32619);
        this.f36269 = m32619;
    }
    
    public void m36296() {
        this.f36269 = this.f36269.f32609;
    }
    
    public void m36298(final c31923 c31923, final double n, final double n2, final double n3, final double n4, final boolean b) {
        this.m36288(c31923.f31925 + n4, EnchantUtil.m35546() - c31923.f31926 - c31923.f31928 + n, c31923.f31927 - n4 - n2, c31923.f31928 - n - n3, b);
    }
    
    public void m36310(final double n, final double n2, final double n3, final double n4, final c33493 c33493, final c37042 c33494, final c37042 c33495, final c37042 c33496, final c37042 c33497) {
        this.f36269.f32617.add(this.f36262.m32903().m40055(n, n2, n3, n4, c33493, c33494, c33495, c33496, c33497));
    }
    
    public void m36321(final double n, final double n2, final double n3, final double n4, final c33493 c33493, final c37042 c33494) {
        this.m36310(n, n2, n3, n4, c33493, c33494, c33494, c33494, c33494);
    }
    
    public void m36329(final double n, final double n2, final double n3, final double n4, final c37042 c37042, final c37042 c37043) {
        this.m36310(n, n2, n3, n4, null, c37042, c37043, c37043, c37042);
    }
    
    public void m36337(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        this.m36310(n, n2, n3, n4, null, c37042, c37042, c37042, c37042);
    }
    
    public void m36344(final c31923 c31923, final boolean b, final boolean b2) {
        c37042 c31924 = c31870.f37895.f37900;
        c37042 c31925 = c31870.f37895.f37903;
        if (b2) {
            c31924 = c31870.f37895.f37902;
            c31925 = c31870.f37895.f37905;
        }
        else if (b) {
            c31924 = c31870.f37895.f37901;
            c31925 = c31870.f37895.f37904;
        }
        this.m36337(c31923.f31925, c31923.f31926, c31923.f31927, c31923.f31928, c31924);
        this.m36337(c31923.f31925, c31923.f31926, c31923.f31927, 1.0, c31925);
        this.m36337(c31923.f31925, c31923.f31926 + c31923.f31928 - 1.0, c31923.f31927, 1.0, c31925);
        this.m36337(c31923.f31925, c31923.f31926, 1.0, c31923.f31928, c31925);
        this.m36337(c31923.f31925 + c31923.f31927 - 1.0, c31923.f31926, 1.0, c31923.f31928, c31925);
    }
    
    public void m36351(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        this.f36269.f32617.add(this.f36263.m32903().m38650(n, n2, n3, n4, c37042));
    }
    
    public void m36358(final double n, final double n2, final double n3, final double n4, final c37042 c37042) {
        this.f36269.f32617.add(this.f36264.m32903().m38003(n, n2, n3, n4, c37042));
    }
    
    public void m36365(final double n, final double n2, final ItemStack itemStack) {
        this.f36269.f32618.add(this.f36265.m32903().m33871(n, n2, itemStack));
    }
    
    public void m36370(final String s, final double n, final double n2, final c37042 c37042, final boolean b) {
        this.f36269.f32618.add(this.f36266.m32903().m32490(s, n, n2, c37042, b));
    }
    
    public void m36377(final String s, final double n, final double n2, final c37042 c37042) {
        this.f36271 = this.f36266.m32903().m32490(s, n, n2, c37042, true);
    }
    
    private void m36383(final c31923 c31923, final boolean b) {
        if (b) {
            this.m36274();
        }
        this.m36358(c31923.f31925, c31923.f31926, c31923.f31925 + c31923.f31927, c31923.f31926, c36250.f36253);
        this.m36358(c31923.f31925, c31923.f31926 + c31923.f31928, c31923.f31925 + c31923.f31927, c31923.f31926 + c31923.f31928, c36250.f36253);
        this.m36358(c31923.f31925, c31923.f31926, c31923.f31925, c31923.f31926 + c31923.f31928, c36250.f36253);
        this.m36358(c31923.f31925 + c31923.f31927, c31923.f31926, c31923.f31925 + c31923.f31927, c31923.f31926 + c31923.f31928, c36250.f36253);
        for (final c33587<c31923> c31924 : c31923.m32007()) {
            this.m36358(c31924.m39624(), c31924.m39626(), c31924.m39624() + c31924.m39628(), c31924.m39626(), c36250.f36254);
            this.m36358(c31924.m39624(), c31924.m39626() + c31924.m39630(), c31924.m39624() + c31924.m39628(), c31924.m39626() + c31924.m39630(), c36250.f36254);
            this.m36358(c31924.m39624(), c31924.m39626(), c31924.m39624(), c31924.m39626() + c31924.m39630(), c36250.f36254);
            this.m36358(c31924.m39624() + c31924.m39628(), c31924.m39626(), c31924.m39624() + c31924.m39628(), c31924.m39626() + c31924.m39630(), c36250.f36254);
            this.m36383(c31924.m39632(), false);
        }
        if (b) {
            this.m36278();
        }
    }
    
    public void m36388(final c31923 c31923) {
        this.m36383(c31923, true);
    }
    
    static {
        f36251 = new String[] { "meteor-client", "gui.png" };
        f36252 = new c36250();
        f36253 = new c37042(25, 25, 225);
        f36254 = new c37042(25, 225, 25);
        f36255 = new Identifier("meteor-client", "gui.png");
        f36258 = new c33493(97.0, 32.0, 0, 0, 1, 1, null, null, null);
        f36259 = new c33493(97.0, 32.0, 1, 0, 32, 32, c31870.f37895.f37917, c31870.f37895.f37918, c31870.f37895.f37919);
        f36260 = new c33493(97.0, 32.0, 33, 0, 32, 32, c31870.f37895.f37922, c31870.f37895.f37923, c31870.f37895.f37924);
        f36261 = new c33493(97.0, 32.0, 65, 0, 32, 32, c31870.f37895.f37928, c31870.f37895.f37929, c31870.f37895.f37930);
    }
}
