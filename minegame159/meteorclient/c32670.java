package minegame159.meteorclient;

public class c32670 extends c34014
{
    private static final String[] f32671;
    
    public c32670() {
        super("reload", "Reloads config, modules, friends, macros and accounts.");
    }
    
    @Override
    public void m34018(final String[] array) {
        MeteorClient.INSTANCE.m32308();
    }
    
    static {
        f32671 = new String[] { "reload", "Reloads config, modules, friends, macros and accounts." };
    }
}
