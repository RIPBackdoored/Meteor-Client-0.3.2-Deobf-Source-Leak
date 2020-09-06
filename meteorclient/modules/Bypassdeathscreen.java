package meteorclient.modules;

import meteorclient.*;
import minegame159.meteorclient.*;

public class Bypassdeathscreen extends Module
{
    private static final String[] f38261;
    public boolean f38262;
    
    public Bypassdeathscreen() {
        super(Category.Misc, "bypass-death-screen", "Let's you spy on people");
        this.f38262 = false;
    }
    
    @Override
    public void m35294() {
        this.f38262 = false;
        super.m35294();
    }
    
    static {
        f38261 = new String[] { "bypass-death-screen", "Let's you spy on people" };
    }
}
