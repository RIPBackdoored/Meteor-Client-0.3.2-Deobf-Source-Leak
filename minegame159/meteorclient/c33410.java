package minegame159.meteorclient;

import java.io.*;
import me.zero.alpine.listener.*;
import net.minecraft.nbt.*;
import java.util.*;

public class c33410 extends c37297<c33410>
{
    private static final String[] f33411;
    public static final c33410 f33412;
    private List<c37831> f33413;
    
    private c33410() {
        super(new File(MeteorClient.dir, "macros.nbt"));
        this.f33413 = new ArrayList<c37831>();
    }
    
    public void m33414(final c37831 c37831) {
        this.f33413.add(c37831);
        MeteorClient.eventBus.subscribe((Listenable)c37831);
        MeteorClient.eventBus.post((Object)c34429.m34505());
        this.m37303();
    }
    
    public List<c37831> m33417() {
        return this.f33413;
    }
    
    public void m33419(final c37831 c37831) {
        if (this.f33413.remove(c37831)) {
            MeteorClient.eventBus.unsubscribe((Listenable)c37831);
            MeteorClient.eventBus.post((Object)c34429.m34505());
            this.m37303();
        }
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("macros", (Tag)c33633.m39899((Iterable)this.f33413));
        return compoundTag;
    }
    
    public c33410 m33422(final CompoundTag compoundTag) {
        this.f33413 = (List<c37831>)c33633.m39903(compoundTag.getList("macros", 10), (c33633.c33634)c33410::m33426);
        final Iterator<c37831> iterator = this.f33413.iterator();
        while (iterator.hasNext()) {
            MeteorClient.eventBus.subscribe((Listenable)iterator.next());
        }
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m33422(compoundTag);
    }
    
    private static /* synthetic */ c37831 m33426(final Tag tag) {
        return new c37831().m37847((CompoundTag)tag);
    }
    
    static {
        f33411 = new String[] { "macros.nbt", "macros", "macros" };
        f33412 = new c33410();
    }
}
