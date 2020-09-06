package meteorclient.modules;

import meteorclient.*;
import minegame159.meteorclient.*;

public class Antifriendhit extends Module
{
    private static final String[] f35793;
    
    public Antifriendhit() {
        super(Category.Combat, "anti-friend-hit", "Cancels attacks that hit friends");
    }
    
    static {
        f35793 = new String[] { "anti-friend-hit", "Cancels attacks that hit friends" };
    }
}
