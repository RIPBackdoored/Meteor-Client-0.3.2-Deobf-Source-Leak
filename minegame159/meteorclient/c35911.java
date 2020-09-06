package minegame159.meteorclient;

public class c35911 extends c39130
{
    private static final String[] f35912;
    
    public c35911() {
        super("Add Account", true);
        this.add(new c39081("Email:"));
        this.add(new c31399("", 200.0)).m39632().m31416(true);
        this.m39132();
        this.add(new c39081("Password:"));
        final c31399 c31399 = this.add(new c31399("", 200.0)).m39632();
        this.m39132();
        final c31399 c31400;
        final c31399 c31401;
        this.add(new c38616("Add")).m39587().m39583().m39632().f38618 = (p2 -> {
            if (!c31400.f31403.isEmpty() && !c31401.f31403.isEmpty() && c31400.f31403.contains("@")) {
                c34371.f34373.m34376(new c34353(c31400.f31403, c31401.f31403));
                this.onClose();
            }
        });
    }
    
    private /* synthetic */ void m35913(final c31399 c31399, final c31399 c31400, final c38616 c31401) {
        if (!c31399.f31403.isEmpty() && !c31400.f31403.isEmpty() && c31399.f31403.contains("@")) {
            c34371.f34373.m34376(new c34353(c31399.f31403, c31400.f31403));
            this.onClose();
        }
    }
    
    static {
        f35912 = new String[] { "Add Account", "Email:", "", "Password:", "", "Add", "@" };
    }
}
