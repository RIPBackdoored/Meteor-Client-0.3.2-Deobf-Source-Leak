package minegame159.meteorclient;

import java.io.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;

public class c39017 extends c37297<c39017> implements Iterable<c31543>
{
    private static final String[] f39018;
    public static final c39017 f39019;
    private static final c37042 f39020;
    private List<c31543> f39021;
    
    private c39017() {
        super(new File(MeteorClient.dir, "friends.nbt"));
        this.f39021 = new ArrayList<c31543>();
    }
    
    public boolean m39022(final c31543 c31543) {
        if (!this.f39021.contains(c31543)) {
            this.f39021.add(c31543);
            MeteorClient.eventBus.post((Object)c34429.m34504());
            this.m37303();
            return true;
        }
        return false;
    }
    
    public List<c31543> m39025() {
        return this.f39021;
    }
    
    public boolean m39027(final c31543 c31543) {
        return this.f39021.contains(c31543);
    }
    
    public c31543 m39030(final String s) {
        for (final c31543 c31543 : this.f39021) {
            if (c31543.f31545.equals(s)) {
                return c31543;
            }
        }
        return null;
    }
    
    public c31543 m39034(final PlayerEntity playerEntity) {
        return this.m39030(playerEntity.getGameProfile().getName());
    }
    
    public boolean m39037(final PlayerEntity playerEntity) {
        final c31543 m39030 = this.m39030(playerEntity.getGameProfile().getName());
        return m39030 != null && m39030.f31546;
    }
    
    public boolean m39041(final PlayerEntity playerEntity) {
        final c31543 m39030 = this.m39030(playerEntity.getGameProfile().getName());
        return m39030 == null || m39030.f31548;
    }
    
    public c37042 m39045(final PlayerEntity playerEntity, final c37042 c37042) {
        final c31543 m39030 = this.m39030(playerEntity.getGameProfile().getName());
        return (m39030 == null) ? c37042 : m39030.f31547;
    }
    
    public void m39050(final c31543 c31543) {
        if (this.f39021.contains(c31543)) {
            this.m39053(c31543);
        }
        else {
            this.m39022(c31543);
        }
    }
    
    public boolean m39053(final c31543 c31543) {
        if (this.f39021.remove(c31543)) {
            MeteorClient.eventBus.post((Object)c34429.m34504());
            this.m37303();
            return true;
        }
        return false;
    }
    
    public int m39056() {
        return this.f39021.size();
    }
    
    @Override
    public Iterator<c31543> iterator() {
        return this.f39021.iterator();
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        final ListTag listTag = new ListTag();
        final Iterator<c31543> iterator = this.f39021.iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)iterator.next().m34682());
        }
        compoundTag.put("friends", (Tag)listTag);
        return compoundTag;
    }
    
    public c39017 m39062(final CompoundTag compoundTag) {
        this.f39021 = (List<c31543>)c33633.m39903(compoundTag.getList("friends", 10), (c33633.c33634)c39017::m39066);
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m39062(compoundTag);
    }
    
    private static /* synthetic */ c31543 m39066(final Tag tag) {
        return new c31543((CompoundTag)tag);
    }
    
    static {
        f39018 = new String[] { "friends.nbt", "friends", "friends" };
        f39019 = new c39017();
        f39020 = new c37042(255, 255, 255);
    }
}
