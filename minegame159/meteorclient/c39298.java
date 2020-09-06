package minegame159.meteorclient;

public class c39298 extends c36626
{
    private static final String[] f39299;
    
    public c39298() {
        super(TopBarType.Modules);
        this.add(new c34745());
        final c36715 c36715 = this.add(new c36715()).m39599().m39593().m39632();
        c36715.m36760(4.0);
        c36715.m31937(new c39081("Left click - activate/deactivate module", true));
        c36715.m36739();
        c36715.m31937(new c39081("Right click - open module settings", true));
    }
    
    protected void init() {
        if (c35851.f35852) {
            c33436.f34122.m37303();
        }
        c35851.f35852 = false;
    }
    
    @Override
    public void onClose() {
        c34030.f34033.m37303();
        if (c35851.f35852) {
            c33436.f34122.m37303();
        }
        super.onClose();
    }
    
    static {
        f39299 = new String[] { "Left click - activate/deactivate module", "Right click - open module settings" };
    }
}
