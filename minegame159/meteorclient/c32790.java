package minegame159.meteorclient;

import meteorclient.*;
import meteorclient.setting.*;
import java.util.*;

public class c32790
{
    private static final String[] f32791;
    
    public c32790() {
        super();
    }
    
    public static void m32792(final String s) {
        final String[] split = s.split(" ");
        final c34014 m38240 = c38237.m38240(split[0]);
        if (m38240 != null) {
            m38240.m34018(m32798(split, 1));
            return;
        }
        final c38667 m38241 = c34030.f34033.m34045(split[0]);
        if (m38241 == null) {
            c31351.m31371("Not a valid command or module. Do (highlight).commands (default)or (highlight).modules (default)for a list of commands/modules.", new Object[0]);
            return;
        }
        final String[] m38242 = m32798(split, 1);
        if (m38242.length <= 0) {
            m38241.m38687();
            if (c33436.f34122.f34127 && m38241 instanceof Module) {
                c31351.m31357("Toggled (highlight)%s(default) %s.", m38241.f38672, ((Module)m38241).m35315() ? "on" : "off");
            }
        }
        else {
            final Value<?> m38243 = m38241.f38675.m34566(m38242[0]);
            if (m38243 == null) {
                c31351.m31371("Module (highlight)%s (default)doesn't have a setting with name (highlight)%s(default).", m38241.f38672, m38242[0]);
                return;
            }
            final String[] m38244 = m32798(m38242, 1);
            if (m38244.length <= 0) {
                c31351.m31357("Value of (highlight)%s (default)for module (highlight)%s (default)is (highlight)%s(default).", m38243.f33458, m38241.f38672, m38243.m33466().toString());
            }
            else {
                if (!m38243.m33476(String.join(" ", (CharSequence[])m38244))) {
                    c31351.m31371("Usage of (highlight)%s (default)is (highlight)%s(default).", m38243.f33457, m38243.m33487());
                }
                if (c33436.f34122.f34127) {
                    c31351.m31357("Value of (highlight)%s (default)for module (highlight)%s (default)changed to (highlight)%s(default).", m38243.f33458, m38241.f38672, m38243.m33466().toString());
                }
            }
        }
    }
    
    private static String[] m32798(final String[] array, final int n) {
        return Arrays.copyOfRange(array, n, array.length);
    }
    
    static {
        f32791 = new String[] { " ", "Not a valid command or module. Do (highlight).commands (default)or (highlight).modules (default)for a list of commands/modules.", "Toggled (highlight)%s(default) %s.", "on", "off", "Module (highlight)%s (default)doesn't have a setting with name (highlight)%s(default).", "Value of (highlight)%s (default)for module (highlight)%s (default)is (highlight)%s(default).", " ", "Usage of (highlight)%s (default)is (highlight)%s(default).", "Value of (highlight)%s (default)for module (highlight)%s (default)changed to (highlight)%s(default)." };
    }
}
