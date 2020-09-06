package minegame159.meteorclient;

import meteorclient.util.*;

public class c38357 extends c34014
{
    private static final String[] f38358;
    
    public c38357() {
        super("reset-bind", "Resets modules bind.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final c38667 m35625 = EnchantUtil.m35625(array);
        if (m35625 == null) {
            return;
        }
        c31351.m31357("Bind has been reset.", new Object[0]);
        m35625.m38702(-1);
    }
    
    static {
        f38358 = new String[] { "reset-bind", "Resets modules bind.", "Bind has been reset." };
    }
}
