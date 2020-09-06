package minegame159.meteorclient;

import java.util.*;

public class c31383 extends c34014
{
    private static final String[] f31384;
    
    public c31383() {
        super("modules", "Lists all modules.");
    }
    
    @Override
    public void m34018(final String[] array) {
        c31351.m31357("All (highlight)%d (default)modules:", c34030.f34033.m34055().size());
        for (final Category category : c34030.f34032) {
            final List<c38667> m34052 = c34030.f34033.m34052(category);
            c31351.m31357("- (highlight)%s (default)(%d):", category.toString(), m34052.size());
            for (final c38667 c38667 : m34052) {
                c31351.m31357("  - (highlight)%s%s (default)- %s", c33436.f34122.m34133(), c38667.f38671, c38667.f38673);
            }
        }
    }
    
    static {
        f31384 = new String[] { "modules", "Lists all modules.", "All (highlight)%d (default)modules:", "- (highlight)%s (default)(%d):", "  - (highlight)%s%s (default)- %s" };
    }
}
