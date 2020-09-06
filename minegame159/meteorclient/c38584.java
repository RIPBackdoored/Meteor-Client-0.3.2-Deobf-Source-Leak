package minegame159.meteorclient;

import java.util.*;
import meteorclient.setting.*;

public class c38584 extends c39130
{
    private static final String[] f38585;
    private c31543 f38586;
    public final Map<String, List<Value<?>>> f38587;
    public final List<Value<?>> f38588;
    
    public c38584(final c31543 f38586) {
        super(f38586.f31545, true);
        this.f38587 = new LinkedHashMap<String, List<Value<?>>>(1);
        this.f38588 = new ArrayList<Value<?>>(1);
        this.f38586 = f38586;
        final c34561 c34561 = new c34561();
        final Settings m34572 = c34561.m34572();
        m34572.addValue((Value<Object>)new c34427.c34657().m34664("trusted").m34667("Do you trust this person?").m34670(true).m34673(b -> f38586.f31546 = b).m34676(value -> f38586.f31546 = value.m33466()).m34679());
        m34572.addValue((Value<Object>)new c33179.c33180().m33187("color").m33190("Color.").m33193(new c37042(0, 255, 180)).m33196(f38587 -> f38586.f31547 = f38587).m33199(value2 -> f38586.f31547 = value2.m33466()).m33202());
        m34572.addValue((Value<Object>)new c34427.c34657().m34664("attack").m34667("Should modules attack this person?").m34670(false).m34673(b2 -> f38586.f31548 = b2).m34676(value3 -> f38586.f31548 = value3.m33466()).m34679());
        m34572.addValue((Value<Object>)new c34427.c34657().m34664("show-in-tracers").m34667("Show in tracers.").m34670(true).m34673(b3 -> f38586.f31549 = b3).m34676(value4 -> f38586.f31549 = value4.m33466()).m34679());
        this.add(c34561.m34596()).m39587().m39583();
        this.m39132();
        this.add(new c38616("Back")).m39587().m39583().m39632().f38618 = (p0 -> this.onClose());
    }
    
    private /* synthetic */ void m38589(final c38616 c38616) {
        this.onClose();
    }
    
    private static /* synthetic */ void m38592(final c31543 c31543, final Value value) {
        c31543.f31549 = value.m33466();
    }
    
    private static /* bridge */ void m38595(final c31543 c31543, final Boolean b) {
        c31543.f31549 = b;
    }
    
    private static /* synthetic */ void m38598(final c31543 c31543, final Value value) {
        c31543.f31548 = value.m33466();
    }
    
    private static /* bridge */ void m38601(final c31543 c31543, final Boolean b) {
        c31543.f31548 = b;
    }
    
    private static /* synthetic */ void m38604(final c31543 c31543, final Value value) {
        c31543.f31547 = value.m33466();
    }
    
    private static /* synthetic */ void m38607(final c31543 c31543, final c37042 f31547) {
        c31543.f31547 = f31547;
    }
    
    private static /* synthetic */ void m38610(final c31543 c31543, final Value value) {
        c31543.f31546 = value.m33466();
    }
    
    private static /* bridge */ void m38613(final c31543 c31543, final Boolean b) {
        c31543.f31546 = b;
    }
    
    static {
        f38585 = new String[] { "trusted", "Do you trust this person?", "color", "Color.", "attack", "Should modules attack this person?", "show-in-tracers", "Show in tracers.", "Back" };
    }
}
