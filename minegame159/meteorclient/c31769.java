package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;

public class c31769 extends Value<List<class_2248>>
{
    private static final String[] f31770;
    
    public c31769(final String s, final String s2, final List<class_2248> list, final Consumer<List<class_2248>> consumer, final Consumer<Value<List<class_2248>>> consumer2) {
        super(s, s2, list, consumer, consumer2);
        this.f33462 = (T)new ArrayList((Collection<? extends E>)list);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c39230(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new ArrayList((Collection<? extends E>)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected List<class_2248> m31771(final String s) {
        final String[] split = s.split(",");
        final ArrayList<class_2248> list = new ArrayList<class_2248>(1);
        try {
            final String[] array = split;
            for (int length = array.length, i = 0; i < length; ++i) {
                final String trim = array[i].trim();
                Identifier identifier;
                if (trim.contains(":")) {
                    identifier = new Identifier(trim);
                }
                else {
                    identifier = new Identifier("minecraft", trim);
                }
                if (Registry.BLOCK.containsId(identifier)) {
                    list.add((class_2248)Registry.BLOCK.get(identifier));
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m31780(final List<class_2248> list) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)block id (default)(dirt, minecraft:stone, etc)";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final ListTag listTag = new ListTag();
        final Iterator<Block> iterator = ((Value<List<Block>>)this).m33466().iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)new StringTag(Registry.BLOCK.getId((Object)iterator.next()).toString()));
        }
        m33490.put("value", (Tag)listTag);
        return m33490;
    }
    
    public List<class_2248> m31783(final class_2487 class_2487) {
        ((Value<List>)this).m33466().clear();
        final Iterator iterator = ((CompoundTag)class_2487).getList("value", 8).iterator();
        while (iterator.hasNext()) {
            ((Value<List<Object>>)this).m33466().add(Registry.BLOCK.get(new Identifier(iterator.next().asString())));
        }
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m31780((List<class_2248>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m31771(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m31783(compoundTag);
    }
    
    private /* synthetic */ void m31788(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c39230(this));
    }
    
    static {
        f31770 = new String[] { "Select", ",", ":", "minecraft", "(highlight)block id (default)(dirt, minecraft:stone, etc)", "value", "value" };
    }
    
    public static class c36992
    {
        private static final String[] f36993;
        private String f36994;
        private String f36995;
        private List<class_2248> f36996;
        private Consumer<List<class_2248>> f36997;
        private Consumer<Value<List<class_2248>>> f36998;
        
        public c36992() {
            super();
            this.f36994 = "undefined";
            this.f36995 = "";
        }
        
        public c36992 m36999(final String f36994) {
            this.f36994 = f36994;
            return this;
        }
        
        public c36992 m37002(final String f36995) {
            this.f36995 = f36995;
            return this;
        }
        
        public c36992 m37005(final List<class_2248> f36996) {
            this.f36996 = f36996;
            return this;
        }
        
        public c36992 m37008(final Consumer<List<class_2248>> f36997) {
            this.f36997 = f36997;
            return this;
        }
        
        public c36992 m37011(final Consumer<Value<List<class_2248>>> f36998) {
            this.f36998 = f36998;
            return this;
        }
        
        public c31769 m37014() {
            return new c31769(this.f36994, this.f36995, this.f36996, this.f36997, this.f36998);
        }
        
        static {
            f36993 = new String[] { "undefined", "" };
        }
    }
}
