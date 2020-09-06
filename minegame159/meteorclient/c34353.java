package minegame159.meteorclient;

import net.minecraft.client.*;
import net.minecraft.client.util.*;
import com.mojang.authlib.*;
import net.minecraft.nbt.*;
import java.util.*;

public class c34353 implements c34681<c34353>
{
    private static final String[] f34354;
    private String f34355;
    private String f34356;
    private String f34357;
    
    c34353() {
        super();
    }
    
    public c34353(final String f34355, final String s) {
        super();
        this.f34355 = f34355;
        this.f34357 = c39853.m39855(s, "Lps98faSD6ASD8fe");
    }
    
    public boolean m34358() {
        try {
            if (c34371.f34374.isLoggedIn()) {
                c34371.f34374.logOut();
            }
            c34371.f34374.setUsername(this.f34355);
            c34371.f34374.setPassword(c39853.m39862(this.f34357, "Lps98faSD6ASD8fe"));
            c34371.f34374.logIn();
            final GameProfile selectedProfile = c34371.f34374.getSelectedProfile();
            ((c37135)MinecraftClient.getInstance()).m37140(new Session(selectedProfile.getName(), selectedProfile.getId().toString(), c34371.f34374.getAuthenticatedToken(), c34371.f34374.getUserType().getName()));
            this.f34356 = c34371.f34374.getSelectedProfile().getName();
            c34371.f34373.m37303();
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public String m34362() {
        return (this.f34356 == null || this.f34356.isEmpty()) ? this.f34355 : this.f34356;
    }
    
    public boolean m34364() {
        return this.f34355 != null && this.f34357 != null;
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("email", this.f34355);
        if (this.f34356 != null) {
            compoundTag.putString("username", this.f34356);
        }
        compoundTag.putString("password", this.f34357);
        return compoundTag;
    }
    
    public c34353 m34366(final CompoundTag compoundTag) {
        this.f34355 = compoundTag.getString("email");
        if (compoundTag.contains("username")) {
            this.f34356 = compoundTag.getString("username");
        }
        this.f34357 = compoundTag.getString("password");
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final c34353 c34353 = (c34353)o;
        return Objects.equals(this.f34355, c34353.f34355) && Objects.equals(this.f34357, c34353.f34357);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f34355, this.f34357);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m34366(compoundTag);
    }
    
    static {
        f34354 = new String[] { "Lps98faSD6ASD8fe", "Lps98faSD6ASD8fe", "email", "username", "password", "email", "username", "username", "password" };
    }
}
