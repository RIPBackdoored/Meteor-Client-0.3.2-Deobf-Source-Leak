package minegame159.meteorclient;

import meteorclient.setting.*;

public class c36467 extends c36626
{
    private static final String[] f36468;
    
    public c36467() {
        super(TopBarType.Config);
        final c34561 c37043 = new c34561();
        final Settings m34572 = c37043.m34572();
        final Settings m34573 = c37043.m34588("Category Colors");
        m34572.addValue((Value<Object>)new c36225.c36674().m36681("prefix").m36684("Prefix.").m36687(".").m36690(c33436.f34122::m34130).m36693(value -> value.m33468(c33436.f34122.m34133())).m36696());
        m34572.addValue((Value<Object>)new c34427.c34657().m34664("chat-commands-info").m34667("Send chat message when you use chat comamnds (eg toggling module, changing a setting, etc).").m34670(true).m34673(b -> c33436.f34122.f34127 = b).m34676(value2 -> value2.m33468(c33436.f34122.f34127)).m34679());
        for (final Category category : c34030.f34032) {
            c37042 c37044 = null;
            m34573.addValue((Value<Object>)new c33179.c33180().m33187(category.toString().toLowerCase() + "-color").m33190(category.toString() + " color.").m33193(new c37042(0, 0, 0, 0)).m33196(c37042 -> c33436.f34122.m34139(category, c37042)).m33199(value3 -> {
                c33436.f34122.m34143(category);
                if (c37044 == null) {
                    c37044 = new c37042(0, 0, 0, 0);
                }
                value3.m33468(c37044);
                return;
            }).m33202());
        }
        this.add(new c35714(this.f37288, true)).m39601().m39632().m31937(c37043.m34596()).m39587().m39583();
    }
    
    @Override
    public void onClose() {
        c33436.f34122.m37303();
        super.onClose();
    }
    
    private static /* synthetic */ void m36469(final Category category, final Value value) {
        c37042 m34143 = c33436.f34122.m34143(category);
        if (m34143 == null) {
            m34143 = new c37042(0, 0, 0, 0);
        }
        value.m33468(m34143);
    }
    
    private static /* synthetic */ void m36473(final Category category, final c37042 c37042) {
        c33436.f34122.m34139(category, c37042);
    }
    
    private static /* synthetic */ void m36476(final Value value) {
        value.m33468(c33436.f34122.f34127);
    }
    
    private static /* bridge */ void m36478(final Boolean b) {
        c33436.f34122.f34127 = b;
    }
    
    private static /* synthetic */ void m36480(final Value value) {
        value.m33468(c33436.f34122.m34133());
    }
    
    static {
        f36468 = new String[] { "Category Colors", "prefix", "Prefix.", ".", "chat-commands-info", "Send chat message when you use chat comamnds (eg toggling module, changing a setting, etc).", "-color", " color." };
    }
}
