package minegame159.meteorclient;

import meteorclient.util.*;

public class c32765 extends c34014
{
    private static final String[] f32766;
    
    public c32765() {
        super("bind", "Binds module to a key.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final c38667 m35625 = EnchantUtil.m35625(array);
        if (m35625 == null) {
            return;
        }
        c31351.m31357("Press some key.", new Object[0]);
        c34030.f34033.m34059(m35625);
    }
    
    static {
        f32766 = new String[] { "bind", "Binds module to a key.", "Press some key." };
    }
}
