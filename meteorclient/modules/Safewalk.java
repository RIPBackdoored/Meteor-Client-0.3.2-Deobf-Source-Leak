package meteorclient.modules;

import meteorclient.*;
import minegame159.meteorclient.*;

public class Safewalk extends Module
{
    private static final String[] f34801;
    
    public Safewalk() {
        super(Category.Movement, "safe-walk", "Stops you from walking off the edge of blocks.");
    }
    
    static {
        f34801 = new String[] { "safe-walk", "Stops you from walking off the edge of blocks." };
    }
}
