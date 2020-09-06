package minegame159.meteorclient;

import meteorclient.modules.*;
import net.minecraft.util.math.*;
import java.util.*;

private class c34844
{
    private final int f34845;
    private final int f34846;
    private final List<c34640.c38708> f34847;
    final /* synthetic */ Search f34848;
    
    public c34844(final Search f34848, final int f34849, final int f34850) {
        this.f34848 = f34848;
        super();
        this.f34847 = new ArrayList();
        this.f34845 = f34849;
        this.f34846 = f34850;
    }
    
    public void m34849(final BlockPos blockPos, final boolean b) {
        if (b) {
            final Iterator<c34640.c38708> iterator = this.f34847.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().m38754(blockPos)) {
                    return;
                }
            }
        }
        final c34640.c38708 c38708 = Search.m38181(this.f34848).m32903();
        c38708.m38733(blockPos);
        this.f34847.add(c38708);
        this.m34860(blockPos);
    }
    
    public void m34855(final BlockPos blockPos) {
        for (int i = 0; i < this.f34847.size(); ++i) {
            if (((c34640.c38708)this.f34847.get(i)).m38754(blockPos)) {
                this.f34847.remove(i);
                return;
            }
        }
        this.m34860(blockPos);
    }
    
    private void m34860(final BlockPos blockPos) {
        Search.m38183(this.f34848, this.f34845, this.f34846);
        final double n = Math.abs(blockPos.getX() + ((blockPos.getX() < 0) ? 1 : 0)) % 16;
        final double n2 = Math.abs(blockPos.getZ() + ((blockPos.getZ() < 0) ? 1 : 0)) % 16;
        if (n == 15.0) {
            Search.m38183(this.f34848, this.f34845 + ((blockPos.getX() < 0) ? -1 : 1), this.f34846);
        }
        else if (n == 0.0) {
            Search.m38183(this.f34848, this.f34845 - ((blockPos.getX() < 0) ? -1 : 1), this.f34846);
        }
        if (n2 == 15.0) {
            Search.m38183(this.f34848, this.f34845, this.f34846 + ((blockPos.getZ() < 0) ? -1 : 1));
        }
        else if (n2 == 0.0) {
            Search.m38183(this.f34848, this.f34845, this.f34846 - ((blockPos.getZ() < 0) ? -1 : 1));
        }
    }
    
    public boolean m34865() {
        final int n = Search.m38187(this.f34848).options.viewDistance + 1;
        return this.f34845 > Search.m38189(this.f34848).player.chunkX + n || this.f34845 < Search.m38191(this.f34848).player.chunkX - n || this.f34846 > Search.m38193(this.f34848).player.chunkZ + n || this.f34846 < Search.m38195(this.f34848).player.chunkZ - n;
    }
    
    public void m34868() {
        final Iterator<c34640.c38708> iterator = this.f34847.iterator();
        while (iterator.hasNext()) {
            iterator.next().m38736();
        }
    }
    
    public void m34871(final c36846 c36846) {
        final Iterator<c34640.c38708> iterator = this.f34847.iterator();
        while (iterator.hasNext()) {
            iterator.next().m38743(c36846);
        }
    }
    
    public void m34875() {
        final Iterator<c34640.c38708> iterator = this.f34847.iterator();
        while (iterator.hasNext()) {
            Search.m38181(this.f34848).m32905(iterator.next());
        }
        this.f34847.clear();
    }
    
    static /* synthetic */ List m34878(final c34844 c34844) {
        return c34844.f34847;
    }
}
