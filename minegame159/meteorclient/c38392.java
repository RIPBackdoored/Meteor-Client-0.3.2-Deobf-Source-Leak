package minegame159.meteorclient;

public class c38392
{
    private static final String[] f38393;
    public static c31399.c34880 f38394;
    public static c31399.c34880 f38395;
    
    public c38392() {
        super();
    }
    
    private static /* synthetic */ boolean m38396(final c31399 c31399, final char c31400) {
        return (c31400 >= '0' && c31400 <= '9') || (c31400 == '-' && c31399.f31403.length() == 0) || (c31400 == '.' && c31399.f31403.length() > 0 && !c31399.f31403.contains(".") && (c31399.f31403.charAt(0) != '-' || c31399.f31403.length() > 1));
    }
    
    private static /* bridge */ boolean m38399(final c31399 c31399, final char c31400) {
        return (c31400 >= '0' && c31400 <= '9') || (c31400 == '-' && c31399.f31403.length() == 0);
    }
    
    static {
        f38393 = new String[] { "." };
        c38392.f38394 = ((c31399, c31401) -> {
            if (c31401 >= '0' && c31401 <= '9') {
                return true;
            }
            else {
                return c31401 == '-' && c31399.f31403.length() == 0;
            }
        });
        c38392.f38395 = ((c31400, c31402) -> {
            if (c31402 >= '0' && c31402 <= '9') {
                return true;
            }
            else if (c31402 == '-' && c31400.f31403.length() == 0) {
                return true;
            }
            else {
                return c31402 == '.' && c31400.f31403.length() > 0 && !c31400.f31403.contains(".") && (c31400.f31403.charAt(0) != '-' || c31400.f31403.length() > 1);
            }
        });
    }
}
