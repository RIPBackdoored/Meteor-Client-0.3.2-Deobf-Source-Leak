package meteorclient.modules;

import meteorclient.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;

public class Annoy extends Module
{
    private static final String[] f33429;
    @EventHandler
    private final Listener<c37172> f33430;
    
    public Annoy() {
        super(Category.Misc, "annoy", "Makes your messages wEiRd.");
        this.f33430 = (Listener<c37172>)new Listener(c33428::m33431, new Predicate[0]);
    }
    
    private static /* synthetic */ void m33431(final c37172 c37172) {
        final StringBuilder sb = new StringBuilder(c37172.f37173.length());
        boolean b = true;
        for (final int n : c37172.f37173.codePoints().toArray()) {
            if (b) {
                sb.appendCodePoint(Character.toUpperCase(n));
            }
            else {
                sb.appendCodePoint(Character.toLowerCase(n));
            }
            b = !b;
        }
        c37172.f37173 = sb.toString();
    }
    
    static {
        f33429 = new String[] { "annoy", "Makes your messages wEiRd." };
    }
}
