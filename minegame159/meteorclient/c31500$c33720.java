package minegame159.meteorclient;

import meteorclient.setting.*;
import meteorclient.modules.*;

private class c33720 extends c31500.c37403
{
    private static final String[] f33721;
    private final Value<String> f33722;
    private final Value<Double> f33723;
    private final Value<Double> f33724;
    private double f33725;
    private double f33726;
    private double f33727;
    private double f33728;
    private boolean f33729;
    final /* synthetic */ Announcer f33730;
    
    c33720(final Announcer f33730) {
        super(this.f33730 = f33730, "Moving", "moving-enabled", "Send msg how much you moved.");
        this.f33722 = this.f37404.addValue((Value<Object>)new c36225.c36674().m36681("moving-msg").m36684("Moving message.").m36687("I just moved {dist} blocks!").m36696());
        this.f33723 = this.f37404.addValue((Value<Object>)new c37033.c38947().m38959("moving-delay").m38962("Moving delay between messages in seconds.").m38965(10.0).m38983(60.0).m38988());
        this.f33724 = this.f37404.addValue((Value<Object>)new c37033.c38947().m38959("moving-min-dist").m38962("Moving minimum distance.").m38965(10.0).m38983(100.0).m38988());
    }
    
    void m37406() {
        this.f33725 = 0.0;
        this.f33726 = 0.0;
        this.f33729 = true;
    }
    
    void m37407() {
        if (this.f33729) {
            this.f33729 = false;
            this.m33731();
        }
        final double n = Announcer.m33157(this.f33730).player.x - this.f33727;
        final double n2 = Announcer.m33159(this.f33730).player.z - this.f33728;
        this.f33725 += Math.sqrt(n * n + n2 * n2);
        if (this.f33726 >= this.f33723.m33466()) {
            this.f33726 = 0.0;
            if (this.f33725 >= this.f33724.m33466()) {
                this.m33733();
                this.f33725 = 0.0;
            }
        }
        else {
            this.f33726 += 0.05;
        }
        this.m33731();
    }
    
    void m33731() {
        this.f33727 = Announcer.m33161(this.f33730).player.x;
        this.f33728 = Announcer.m33163(this.f33730).player.z;
    }
    
    void m33733() {
        Announcer.m33165(this.f33730).player.sendChatMessage(this.f33722.m33466().replace("{dist}", String.format("%.1f", this.f33725)));
    }
    
    static {
        c33720.f33721 = new String[] { "Moving", "moving-enabled", "Send msg how much you moved.", "moving-msg", "Moving message.", "I just moved {dist} blocks!", "moving-delay", "Moving delay between messages in seconds.", "moving-min-dist", "Moving minimum distance.", "{dist}", "%.1f" };
    }
}
