package minegame159.meteorclient;

import java.io.*;
import java.util.*;
import net.minecraft.client.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import net.minecraft.nbt.*;

public class c34371 extends c37297<c34371>
{
    private static final String[] f34372;
    public static final c34371 f34373;
    static YggdrasilUserAuthentication f34374;
    private List<c34353> f34375;
    
    private c34371() {
        super(new File(MeteorClient.dir, "accounts.nbt"));
        this.f34375 = new ArrayList<c34353>();
    }
    
    public void m34376(final c34353 c34353) {
        if (!this.f34375.contains(c34353)) {
            this.f34375.add(c34353);
            this.m37303();
            MeteorClient.eventBus.post((Object)c34429.m34511());
        }
    }
    
    public void m34379(final c34353 c34353) {
        if (this.f34375.remove(c34353)) {
            this.m37303();
            MeteorClient.eventBus.post((Object)c34429.m34511());
        }
    }
    
    public List<c34353> m34382() {
        return this.f34375;
    }
    
    public static void m34384() {
        c34371.f34374 = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(((c37135)MinecraftClient.getInstance()).m37139(), "48c1eb24-b218-4e50-844e-0a34975441da").createUserAuthentication(Agent.MINECRAFT);
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("accounts", (Tag)c33633.m39899((Iterable)this.f34375));
        return compoundTag;
    }
    
    public c34371 m34385(final CompoundTag compoundTag) {
        this.f34375 = (List<c34353>)c33633.m39903(compoundTag.getList("accounts", 10), (c33633.c33634)c34371::m34389);
        for (int i = 0; i < this.f34375.size(); ++i) {
            if (!this.f34375.get(i).m34364()) {
                this.f34375.remove(i);
                --i;
            }
        }
        return this;
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m34385(compoundTag);
    }
    
    private static /* synthetic */ c34353 m34389(final Tag tag) {
        return new c34353().m34366((CompoundTag)tag);
    }
    
    static {
        f34372 = new String[] { "accounts.nbt", "48c1eb24-b218-4e50-844e-0a34975441da", "accounts", "accounts" };
        f34373 = new c34371();
    }
}
