package minegame159.meteorclient;

import net.minecraft.util.*;

public class c37035 extends c39130
{
    private static final String[] f37036;
    
    public c37035(final c32449 c32449) {
        super("New Update", true);
        this.add(new c39081("New version of Meteor has been released."));
        this.m39132();
        this.add(new c38757()).m39587().m39583();
        this.m39132();
        final c36715 c32450 = this.add(new c36715()).m39632();
        this.m39132();
        c32450.m31937(new c39081("Your version:"));
        c32450.m31937(new c39081(c33436.f34122.f34123.toString()));
        c32450.m36739();
        c32450.m31937(new c39081("Latest version:"));
        c32450.m31937(new c39081(c32449.toString()));
        this.add(new c38757()).m39587().m39583();
        this.m39132();
        final c36715 c32451 = this.add(new c36715()).m39632();
        c32451.m31937(new c38616("Download " + c32449)).m39587().m39583().m39632().f38618 = (p0 -> Util.getOperatingSystem().method_670("https://meteorclient.com/"));
        c32451.m31937(new c38616("OK")).m39587().m39583().m39632().f38618 = (p0 -> this.onClose());
    }
    
    private /* synthetic */ void m37037(final c38616 c38616) {
        this.onClose();
    }
    
    private static /* synthetic */ void m37040(final c38616 c38616) {
        Util.getOperatingSystem().method_670("https://meteorclient.com/");
    }
    
    static {
        f37036 = new String[] { "New Update", "New version of Meteor has been released.", "Your version:", "Latest version:", "Download ", "OK", "https://meteorclient.com/" };
    }
}
