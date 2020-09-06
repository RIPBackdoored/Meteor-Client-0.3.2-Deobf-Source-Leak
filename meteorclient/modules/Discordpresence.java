package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import meteorclient.util.*;
import net.arikia.dev.drpc.*;

public class Discordpresence extends Module
{
    private static final String[] f39138;
    private final Settings f39139;
    private final Value<Boolean> f39140;
    private final Value<Boolean> f39141;
    private final DiscordRichPresence f39142;
    private boolean f39143;
    private int f39144;
    private c39137.SmallImage f39145;
    @EventHandler
    private final Listener<c36575> f39146;
    
    public Discordpresence() {
        super(Category.Misc, "discord-presence", "That stuff you see in discord");
        this.f39139 = this.f38675.m34572();
        this.f39140 = this.f39139.addValue((Value<Boolean>)new c34427.c34657().m34664("display-name").m34667("Displays your name in discord rpc.").m34670(true).m34673(this::m39174).m34679());
        this.f39141 = this.f39139.addValue((Value<Boolean>)new c34427.c34657().m34664("display-server").m34667("Displays the server you are in.").m34670(true).m34673(this::m39171).m34679());
        this.f39142 = new DiscordRichPresence();
        this.f39146 = (Listener<c36575>)new Listener(this::m39157, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f39144 = 0;
        this.f39145 = c39137.SmallImage.MineGame;
        DiscordRPC.discordInitialize("709793491911180378", new DiscordEventHandlers.Builder().setReadyEventHandler(this::m39168).setDisconnectedEventHandler(this::m39164).setErroredEventHandler(this::m39160).build(), false);
    }
    
    @Override
    public void m35294() {
        DiscordRPC.discordShutdown();
    }
    
    private void m39149() {
        if (this.m35315()) {
            this.f39142.details = this.m39151();
            if (this.f39143) {
                DiscordRPC.discordUpdatePresence(this.f39142);
            }
        }
    }
    
    private String m39151() {
        if (this.mc.isInSingleplayer()) {
            if (this.f39140.m33466()) {
                return this.m39155() + " || SinglePlayer";
            }
            return "SinglePlayer";
        }
        else {
            if (this.f39140.m33466() && this.f39141.m33466()) {
                return this.m39155() + " || " + this.m39153();
            }
            if (!this.f39140.m33466() && this.f39141.m33466()) {
                return this.m39153();
            }
            if (this.f39140.m33466() && !this.f39141.m33466()) {
                return this.m39155();
            }
            return "";
        }
    }
    
    private String m39153() {
        return EnchantUtil.m35577();
    }
    
    private String m39155() {
        return this.mc.player.getEntityName();
    }
    
    private /* synthetic */ void m39157(final c36575 c36575) {
        if (this.f39143) {
            ++this.f39144;
            if (this.f39144 >= 200) {
                (this.f39145 = this.f39145.next()).apply(this.f39142);
                DiscordRPC.discordUpdatePresence(this.f39142);
                this.f39144 = 0;
            }
        }
        DiscordRPC.discordRunCallbacks();
    }
    
    private /* synthetic */ void m39160(final int n, final String s) {
        this.f39143 = false;
    }
    
    private /* synthetic */ void m39164(final int n, final String s) {
        this.f39143 = false;
    }
    
    private /* synthetic */ void m39168(final DiscordUser discordUser) {
        this.f39143 = true;
        this.f39142.startTimestamp = System.currentTimeMillis();
        this.f39142.details = this.m39151();
        this.f39142.largeImageKey = "meteor_client";
        this.f39142.largeImageText = "https://meteorclient.com/";
        this.f39145.apply(this.f39142);
        DiscordRPC.discordUpdatePresence(this.f39142);
    }
    
    private /* bridge */ void m39171(final Boolean b) {
        this.m39149();
    }
    
    private /* bridge */ void m39174(final Boolean b) {
        this.m39149();
    }
    
    static {
        f39138 = new String[] { "discord-presence", "That stuff you see in discord", "display-name", "Displays your name in discord rpc.", "display-server", "Displays the server you are in.", "709793491911180378", " || SinglePlayer", "SinglePlayer", " || ", "", "meteor_client", "https://meteorclient.com/" };
    }
}
