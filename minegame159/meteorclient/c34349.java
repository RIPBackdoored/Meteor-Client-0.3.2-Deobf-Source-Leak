package minegame159.meteorclient;

public class c34349 extends c34014
{
    private static final String[] f34350;
    
    public c34349() {
        super("clear-chat", "Clears your chat.");
    }
    
    @Override
    public void m34018(final String[] array) {
        c34349.f34015.inGameHud.getChatHud().clear(false);
    }
    
    static {
        f34350 = new String[] { "clear-chat", "Clears your chat." };
    }
}
