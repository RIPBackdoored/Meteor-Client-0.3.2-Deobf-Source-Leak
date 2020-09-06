package minegame159.meteorclient;

public class c38406 extends c34014
{
    private static final String[] f38407;
    
    public c38406() {
        super("commands", "Lists all commands.");
    }
    
    @Override
    public void m34018(final String[] array) {
        c31351.m31357("All (highlight)%d (default)commands:", c38237.m38245());
        c38237.m38243(c34014 -> c31351.m31357("- (highlight)%s%s (default)- %s", c33436.f34122.m34133(), c34014.f34016, c34014.f34017));
    }
    
    private static /* synthetic */ void m38410(final c34014 c34014) {
        c31351.m31357("- (highlight)%s%s (default)- %s", c33436.f34122.m34133(), c34014.f34016, c34014.f34017);
    }
    
    static {
        f38407 = new String[] { "commands", "Lists all commands.", "All (highlight)%d (default)commands:", "- (highlight)%s%s (default)- %s" };
    }
}
