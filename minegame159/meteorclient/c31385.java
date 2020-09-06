package minegame159.meteorclient;

import meteorclient.*;
import java.util.*;

public class c31385 extends c34014
{
    private static final String[] f31386;
    
    public c31385() {
        super("panic", "Disables all modules.");
    }
    
    @Override
    public void m34018(final String[] array) {
        final Iterator<Module> iterator = new ArrayList<Module>(c34030.f34033.m34057()).iterator();
        while (iterator.hasNext()) {
            iterator.next().m35300();
        }
    }
    
    static {
        f31386 = new String[] { "panic", "Disables all modules." };
    }
}
