package meteorclient.modules;

import meteorclient.*;
import minegame159.meteorclient.*;

public class UnfocusedCPU extends Module
{
    private static final String[] f31567;
    
    public UnfocusedCPU() {
        super(Category.Misc, "unfocused-CPU", "Doesn't render anything when window is not focused.");
    }
    
    static {
        f31567 = new String[] { "unfocused-CPU", "Doesn't render anything when window is not focused." };
    }
}
