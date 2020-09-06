package meteorclient.modules;

import meteorclient.*;
import minegame159.meteorclient.*;

public class Antichunkban extends Module
{
    private static final String[] f34332;
    
    public Antichunkban() {
        super(Category.Misc, "anti-chunk-ban", "Prevents you from getting kicked by huge packets.");
    }
    
    static {
        f34332 = new String[] { "anti-chunk-ban", "Prevents you from getting kicked by huge packets." };
    }
}
