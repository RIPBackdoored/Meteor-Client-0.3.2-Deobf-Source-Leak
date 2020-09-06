package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.enchantment.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;

public class c38020 extends Value<List<class_1887>>
{
    private static final String[] f38021;
    
    public c38020(final String s, final String s2, final List<class_1887> list, final Consumer<List<class_1887>> consumer, final Consumer<Value<List<class_1887>>> consumer2) {
        super(s, s2, list, consumer, consumer2);
        this.f33462 = (T)new ArrayList((Collection<? extends E>)list);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c37855(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new ArrayList((Collection<? extends E>)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected List<class_1887> m38024(final String s) {
        final String[] split = s.split(",");
        final ArrayList<class_1887> list = new ArrayList<class_1887>(1);
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
                if (Registry.ENCHANTMENT.containsId(identifier)) {
                    list.add((class_1887)Registry.ENCHANTMENT.get(identifier));
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m38034(final List<class_1887> list) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)enchantment id (default)(sharpness, minecraft:protection, etc)";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final ListTag listTag = new ListTag();
        for (final Enchantment enchantment : ((Value<List<Enchantment>>)this).m33466()) {
            try {
                listTag.add((Object)new StringTag(Registry.ENCHANTMENT.getId((Object)enchantment).toString()));
            }
            catch (NullPointerException ex) {}
        }
        m33490.put("value", (Tag)listTag);
        return m33490;
    }
    
    public List<class_1887> m38042(final class_2487 class_2487) {
        ((Value<List>)this).m33466().clear();
        final Iterator iterator = ((CompoundTag)class_2487).getList("value", 8).iterator();
        while (iterator.hasNext()) {
            ((Value<List<Object>>)this).m33466().add(Registry.ENCHANTMENT.get(new Identifier(iterator.next().asString())));
        }
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m38034((List<class_1887>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m38024(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m38042(compoundTag);
    }
    
    private /* synthetic */ void m38050(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c37855(this));
    }
    
    static {
        f38021 = new String[] { "Select", ",", ":", "minecraft", "(highlight)enchantment id (default)(sharpness, minecraft:protection, etc)", "value", "value" };
    }
    
    public static class c38993
    {
        private static final String[] f38994;
        private String f38995;
        private String f38996;
        private List<class_1887> f38997;
        private Consumer<List<class_1887>> f38998;
        private Consumer<Value<List<class_1887>>> f38999;
        
        public c38993() {
            super();
            this.f38995 = "undefined";
            this.f38996 = "";
        }
        
        public c38993 m39000(final String f38995) {
            this.f38995 = f38995;
            return this;
        }
        
        public c38993 m39003(final String f38996) {
            this.f38996 = f38996;
            return this;
        }
        
        public c38993 m39006(final List<class_1887> f38997) {
            this.f38997 = f38997;
            return this;
        }
        
        public c38993 m39009(final Consumer<List<class_1887>> f38998) {
            this.f38998 = f38998;
            return this;
        }
        
        public c38993 m39012(final Consumer<Value<List<class_1887>>> f38999) {
            this.f38999 = f38999;
            return this;
        }
        
        public c38020 m39015() {
            return new c38020(this.f38995, this.f38996, this.f38997, this.f38998, this.f38999);
        }
        
        static {
            f38994 = new String[] { "undefined", "" };
        }
    }
}
