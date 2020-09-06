package minegame159.meteorclient;

public class c31514 extends c34014
{
    private static final String[] f31515;
    
    public c31514() {
        super("reset-gui", "Resets gui positions.");
    }
    
    @Override
    public void m34018(final String[] array) {
        c33436.f34122.f34126.m37936();
        c31351.m31357("Gui positions has been reset.", new Object[0]);
    }
    
    static {
        f31515 = new String[] { "reset-gui", "Resets gui positions.", "Gui positions has been reset." };
    }
}
