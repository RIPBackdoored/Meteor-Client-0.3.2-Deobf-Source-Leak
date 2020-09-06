package minegame159.meteorclient;

import meteorclient.util.*;
import meteorclient.setting.*;
import java.util.*;

public class c38848 extends c34014
{
    private static final String[] f38849;
    
    public c38848() {
        super("reset", "Resets module's oldsettings.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final c38667 m35625 = EnchantUtil.m35625(array);
        if (m35625 == null) {
            return;
        }
        final Iterator<Value<?>> iterator = m35625.f38675.iterator();
        while (iterator.hasNext()) {
            iterator.next().m33474();
        }
    }
    
    static {
        f38849 = new String[] { "reset", "Resets module's oldsettings." };
    }
}
