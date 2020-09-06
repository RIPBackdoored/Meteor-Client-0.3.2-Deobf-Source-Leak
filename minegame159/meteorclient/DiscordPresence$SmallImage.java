package minegame159.meteorclient;

import net.arikia.dev.drpc.*;

private enum SmallImage
{
    private static final String[] ENCRYPTED_STRINGS;
    public static final SmallImage MineGame;
    public static final SmallImage Squid;
    private final String key;
    private final String text;
    private static final /* synthetic */ SmallImage[] $VALUES;
    
    public static SmallImage[] values() {
        return SmallImage.$VALUES.clone();
    }
    
    public static SmallImage valueOf(final String s) {
        return Enum.valueOf(SmallImage.class, s);
    }
    
    private SmallImage(final String s, final int n, final String key, final String text) {
        this.key = key;
        this.text = text;
    }
    
    void apply(final DiscordRichPresence discordRichPresence) {
        discordRichPresence.smallImageKey = this.key;
        discordRichPresence.smallImageText = this.text;
    }
    
    SmallImage next() {
        if (this == SmallImage.MineGame) {
            return SmallImage.Squid;
        }
        return SmallImage.MineGame;
    }
    
    static {
        SmallImage.ENCRYPTED_STRINGS = new String[] { "MineGame", "minegame", "MineGame159", "Squid", "squidoodly", "squidoodly" };
        SmallImage.MineGame = new SmallImage("MineGame", 0, "minegame", "MineGame159");
        SmallImage.Squid = new SmallImage("Squid", 1, "squidoodly", "squidoodly");
        SmallImage.$VALUES = new SmallImage[] { SmallImage.MineGame, SmallImage.Squid };
    }
}
