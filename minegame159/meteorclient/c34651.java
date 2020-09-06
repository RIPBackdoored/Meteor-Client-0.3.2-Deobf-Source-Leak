package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.*;

public class c34651 extends c34014
{
    private static final String[] f34652;
    
    public c34651() {
        super("reset-all", "Resets all modules oldsettings.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final Iterator<c38667> iterator = c34030.f34033.m34055().iterator();
        while (iterator.hasNext()) {
            final Iterator<Value<?>> iterator2 = iterator.next().f38675.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().m33474();
            }
        }
    }
    
    static {
        f34652 = new String[] { "reset-all", "Resets all modules oldsettings." };
    }
}
