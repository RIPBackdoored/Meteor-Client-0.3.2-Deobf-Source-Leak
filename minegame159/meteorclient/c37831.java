package minegame159.meteorclient;

import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.nbt.*;
import net.minecraft.*;
import java.util.*;
import net.minecraft.client.*;

public class c37831 implements Listenable, c34681<c37831>
{
    private static final String[] f37832;
    public String f37833;
    public List<String> f37834;
    public int f37835;
    @EventHandler
    private transient Listener<c38944> f37836;
    
    public c37831() {
        super();
        this.f37834 = new ArrayList<String>(1);
        this.f37835 = -1;
        this.f37836 = (Listener<c38944>)new Listener(c38944 -> {
            if (c38944.f38946 && c38944.f38945 == this.f37835 && MinecraftClient.getInstance().currentScreen == null) {
                final Iterator<String> iterator = this.f37834.iterator();
                while (iterator.hasNext()) {
                    MinecraftClient.getInstance().player.sendChatMessage((String)iterator.next());
                }
                c38944.m32674();
            }
        }, new Predicate[0]);
    }
    
    public void m37837(final String s) {
        this.f37834.add(s);
    }
    
    public void m37840(final int n) {
        this.f37834.remove(n);
    }
    
    public CompoundTag m34682() {
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("name", this.f37833);
        compoundTag.putInt("key", this.f37835);
        final ListTag listTag = new ListTag();
        final Iterator<String> iterator = this.f37834.iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)new StringTag((String)iterator.next()));
        }
        compoundTag.put("messages", (Tag)listTag);
        return compoundTag;
    }
    
    public c37831 m37847(final CompoundTag compoundTag) {
        this.f37833 = compoundTag.getString("name");
        this.f37835 = compoundTag.getInt("key");
        this.f37834 = (List<String>)c33633.m39903(compoundTag.getList("messages", 8), (c33633.c33634)class_2520::method_10714);
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f37833, ((c37831)o).f37833));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f37833);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m37847(compoundTag);
    }
    
    private /* synthetic */ void m37851(final c38944 c38944) {
        if (c38944.f38946 && c38944.f38945 == this.f37835 && MinecraftClient.getInstance().currentScreen == null) {
            final Iterator<String> iterator = this.f37834.iterator();
            while (iterator.hasNext()) {
                MinecraftClient.getInstance().player.sendChatMessage((String)iterator.next());
            }
            c38944.m32674();
        }
    }
    
    static {
        f37832 = new String[] { "name", "key", "messages", "name", "key", "messages" };
    }
}
