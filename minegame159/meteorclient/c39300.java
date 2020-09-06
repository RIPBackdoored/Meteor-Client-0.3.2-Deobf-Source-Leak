package minegame159.meteorclient;

import meteorclient.util.*;
import meteorclient.setting.*;
import java.util.*;

public class c39300 extends c34014
{
    private static final String[] f39301;
    
    public c39300() {
        super("settings", "Displays all settings of specified module.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final c38667 m35625 = EnchantUtil.m35625(array);
        if (m35625 == null) {
            return;
        }
        c31351.m31357("(highlight)%s(default):", m35625.f38672);
        for (final Value<Object> value : m35625.f38675) {
            c31351.m31357("  Usage of (highlight)%s (default)(%s) is (highlight)%s(default).", value.f33457, value.m33466().toString(), value.m33487());
        }
    }
    
    static {
        f39301 = new String[] { "settings", "Displays all settings of specified module.", "(highlight)%s(default):", "  Usage of (highlight)%s (default)(%s) is (highlight)%s(default)." };
    }
}
