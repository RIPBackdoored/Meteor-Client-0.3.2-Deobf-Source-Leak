package minegame159.meteorclient;

import java.util.*;

public class c34909 extends c34014
{
    private static final String[] f34910;
    
    public c34909() {
        super("friend", "Manages friends.");
    }
    
    @Override
    public void m34018(final String[] array) {
        if (array.length == 0) {
            this.m34918();
            return;
        }
        final String lowerCase = array[0].toLowerCase();
        switch (lowerCase) {
            case "add": {
                if (array.length < 2) {
                    this.m34920();
                    return;
                }
                String s = "";
                for (int i = 1; i < array.length; ++i) {
                    if (i > 1) {
                        s += " ";
                    }
                    s += array[i];
                }
                if (c39017.f39019.m39022(new c31543(s))) {
                    c31351.m31357("Added (highlight)%s (default)to friends.", s);
                    break;
                }
                break;
            }
            case "remove": {
                if (array.length < 2) {
                    this.m34920();
                    return;
                }
                String s2 = "";
                for (int j = 1; j < array.length; ++j) {
                    if (j > 1) {
                        s2 += " ";
                    }
                    s2 += array[j];
                }
                if (c39017.f39019.m39053(new c31543(s2))) {
                    c31351.m31357("Removed (highlight)%s (default)from friends.", s2);
                    break;
                }
                break;
            }
            case "list": {
                c31351.m31357("You have (highlight)%d (default)friends:", c39017.f39019.m39056());
                final Iterator<c31543> iterator = c39017.f39019.iterator();
                while (iterator.hasNext()) {
                    c31351.m31357(" - (highlight)%s", iterator.next().f31545);
                }
                break;
            }
            default: {
                this.m34918();
                break;
            }
        }
    }
    
    private void m34918() {
        c31351.m31371("Wrong sub-command. Use (highlight)add(default), (highlight)remove (default)or (highlight)list(default).", new Object[0]);
    }
    
    private void m34920() {
        c31351.m31371("Enter name of your friend.", new Object[0]);
    }
    
    static {
        f34910 = new String[] { "friend", "Manages friends.", "add", "remove", "list", "", " ", "Added (highlight)%s (default)to friends.", "", " ", "Removed (highlight)%s (default)from friends.", "You have (highlight)%d (default)friends:", " - (highlight)%s", "Wrong sub-command. Use (highlight)add(default), (highlight)remove (default)or (highlight)list(default).", "Enter name of your friend." };
    }
}
