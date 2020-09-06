package minegame159.meteorclient;

import baritone.api.*;

public class c36943 extends c34014
{
    private static final String[] f36944;
    
    public c36943() {
        super("b", "Baritone.");
    }
    
    @Override
    public void m34018(final String[] array) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute(String.join(" ", (CharSequence[])array));
    }
    
    static {
        f36944 = new String[] { "b", "Baritone.", " " };
    }
}
