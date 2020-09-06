package minegame159.meteorclient;

import java.util.concurrent.*;
import java.util.*;

public class c31516
{
    private static ExecutorService f31517;
    private static int f31518;
    private static final List<Runnable> f31519;
    
    public c31516() {
        super();
    }
    
    public static void m31520() {
        synchronized (c31516.f31519) {
            if (c31516.f31518 == 0) {
                c31516.f31517 = Executors.newSingleThreadExecutor();
                final Iterator<Runnable> iterator = c31516.f31519.iterator();
                while (iterator.hasNext()) {
                    c31516.f31517.execute(iterator.next());
                }
                c31516.f31519.clear();
            }
            ++c31516.f31518;
        }
    }
    
    public static void m31522() {
        synchronized (c31516.f31519) {
            if (c31516.f31518 > 0) {
                --c31516.f31518;
                if (c31516.f31518 == 0) {
                    try {
                        c31516.f31517.shutdown();
                        c31516.f31517.awaitTermination(5L, TimeUnit.SECONDS);
                        c31516.f31517 = null;
                    }
                    catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    
    public static void m31524(final Runnable runnable) {
        synchronized (c31516.f31519) {
            if (c31516.f31517 == null) {
                c31516.f31519.add(runnable);
            }
            else {
                c31516.f31517.execute(runnable);
            }
        }
    }
    
    static {
        c31516.f31518 = 0;
        f31519 = new ArrayList<Runnable>();
    }
}
