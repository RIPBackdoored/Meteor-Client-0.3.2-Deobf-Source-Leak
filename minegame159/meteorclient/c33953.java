package minegame159.meteorclient;

public class c33953 extends c39130
{
    private static final String[] f33954;
    
    public c33953() {
        super("Auto Craft", true);
        this.add(new c39081("Craft by one:")).m39632().f31934 = "Craft items one by one.";
        final c38264 c38266 = this.add(new c38264(c33436.f34122.f34125.m33445())).m39632();
        c38266.f38265 = (c38264 -> c33436.f34122.f34125.m33442(c38264.f38266));
        c38266.f31934 = "Craft items one by one.";
        this.m39132();
        this.add(new c39081("Stop when no ingredients:")).m39632().f31934 = "Stop crafting items when you run out of ingredients.";
        final c38264 c38267 = this.add(new c38264(c33436.f34122.f34125.m33450())).m39632();
        c38267.f38265 = (c38265 -> c33436.f34122.f34125.m33447(c38265.f38266));
        c38267.f31934 = "Stop crafting items when you run out of ingredients.";
    }
    
    private static /* synthetic */ void m33955(final c38264 c38264) {
        c33436.f34122.f34125.m33447(c38264.f38266);
    }
    
    private static /* synthetic */ void m33957(final c38264 c38264) {
        c33436.f34122.f34125.m33442(c38264.f38266);
    }
    
    static {
        f33954 = new String[] { "Auto Craft", "Craft by one:", "Craft items one by one.", "Craft items one by one.", "Stop when no ingredients:", "Stop crafting items when you run out of ingredients.", "Stop crafting items when you run out of ingredients." };
    }
}
