package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import minegame159.meteorclient.*;
import it.unimi.dsi.fastutil.chars.*;

public class Suffix extends Module
{
    private static final String[] f33392;
    private static final Char2CharMap f33393;
    private final Settings f33394;
    private final Value<String> f33395;
    private final Value<Boolean> f33396;
    private final StringBuilder f33397;
    @EventHandler
    private final Listener<c37172> f33398;
    
    public Suffix() {
        super(Category.Misc, "suffix", "Adds a suffix after every message you send.");
        this.f33394 = this.f38675.m34572();
        this.f33395 = this.f33394.addValue((Value<String>)new c36225.c36674().m36681("text").m36684("Text to add.").m36687(" meteor on crack").m36696());
        this.f33396 = this.f33394.addValue((Value<Boolean>)new c34427.c34657().m34664("small-caps").m34667("Uses small font.").m34670(true).m34679());
        this.f33397 = new StringBuilder();
        this.f33398 = (Listener<c37172>)new Listener(this::m33403, new Predicate[0]);
    }
    
    private String m33399() {
        String string = this.f33395.m33466();
        if (this.f33396.m33466()) {
            this.f33397.setLength(0);
            for (final char c : string.toCharArray()) {
                if (Suffix.f33393.containsKey(c)) {
                    this.f33397.append(Suffix.f33393.get(c));
                }
                else {
                    this.f33397.append(c);
                }
            }
            string = this.f33397.toString();
        }
        return string;
    }
    
    private /* synthetic */ void m33403(final c37172 c37172) {
        if (!c37172.f37173.startsWith(c33436.f34122.m34133() + "b")) {
            c37172.f37173 += this.m33399();
        }
    }
    
    static {
        f33392 = new String[] { "suffix", "Adds a suffix after every message you send.", "text", "Text to add.", " meteor on crack", "small-caps", "Uses small font.", "b", "abcdefghijklmnopqrstuvwxyz", "", "\u1d00\u0299\u1d04\u1d05\u1d07\ua730\u0262\u029c\u026a\u1d0a\u1d0b\u029f\u1d0d\u0274\u1d0f\u1d29q\u0280\ua731\u1d1b\u1d1c\u1d20\u1d21xy\u1d22", "" };
        f33393 = (Char2CharMap)new Char2CharArrayMap();
        final String[] split = "abcdefghijklmnopqrstuvwxyz".split("");
        final String[] split2 = "\u1d00\u0299\u1d04\u1d05\u1d07\ua730\u0262\u029c\u026a\u1d0a\u1d0b\u029f\u1d0d\u0274\u1d0f\u1d29q\u0280\ua731\u1d1b\u1d1c\u1d20\u1d21xy\u1d22".split("");
        for (int i = 0; i < split.length; ++i) {
            Suffix.f33393.put(split[i].charAt(0), split2[i].charAt(0));
        }
    }
}
