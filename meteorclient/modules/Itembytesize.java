package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import minegame159.meteorclient.*;

public class Itembytesize extends Module
{
    private static final String[] f34643;
    private final Settings f34644;
    private final Value<c34642.Mode> f34645;
    
    public Itembytesize() {
        super(Category.Misc, "item-byte-size", "Displays item's size in bytes in tooltip.");
        this.f34644 = this.f38675.m34582("Use KB if big enough", "use-kb-if-big-enough", "Uses kilobytes instead of bytes if the item is larger than 1 kb.", true);
        this.f34645 = this.f34644.addValue((Value<c34642.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Standard 1 kb = 1000 b, True 1 kb = 1024 b.").m36932((Enum)c34642.Mode.True).m36941());
    }
    
    private int m34646() {
        return (this.f34645.m33466() == c34642.Mode.True) ? 1024 : 1000;
    }
    
    public String m34648(final int n) {
        if (this.f34644.m33970() && n >= this.m34646()) {
            return String.format("%.2f kb", n / (float)this.m34646());
        }
        return String.format("%d bytes", n);
    }
    
    static {
        f34643 = new String[] { "item-byte-size", "Displays item's size in bytes in tooltip.", "Use KB if big enough", "use-kb-if-big-enough", "Uses kilobytes instead of bytes if the item is larger than 1 kb.", "mode", "Standard 1 kb = 1000 b, True 1 kb = 1024 b.", "%.2f kb", "%d bytes" };
    }
}
