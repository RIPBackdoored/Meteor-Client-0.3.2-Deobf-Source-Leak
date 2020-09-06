package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;

public class c32527 extends Value<List<class_1792>>
{
    private static final String[] f32528;
    
    public c32527(final String s, final String s2, final List<class_1792> list, final Consumer<List<class_1792>> consumer, final Consumer<Value<List<class_1792>>> consumer2) {
        super(s, s2, list, consumer, consumer2);
        this.f33462 = (T)new ArrayList((Collection<? extends E>)list);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c37958(this)));
    }
    
    protected List<class_1792> m32529(final String s) {
        final String[] split = s.split(",");
        final ArrayList<class_1792> list = new ArrayList<class_1792>(1);
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
                if (Registry.ITEM.containsId(identifier)) {
                    list.add((class_1792)Registry.ITEM.get(identifier));
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new ArrayList((Collection<? extends E>)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m32538(final List<class_1792> list) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)item id (default)(dirt, minecraft:stone, etc)";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final ListTag listTag = new ListTag();
        final Iterator<Item> iterator = ((Value<List<Item>>)this).m33466().iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)new StringTag(Registry.ITEM.getId((Object)iterator.next()).toString()));
        }
        m33490.put("value", (Tag)listTag);
        return m33490;
    }
    
    public List<class_1792> m32541(final class_2487 class_2487) {
        ((Value<List>)this).m33466().clear();
        final Iterator iterator = ((CompoundTag)class_2487).getList("value", 8).iterator();
        while (iterator.hasNext()) {
            ((Value<List<Object>>)this).m33466().add(Registry.ITEM.get(new Identifier(iterator.next().asString())));
        }
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m32538((List<class_1792>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m32529(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m32541(compoundTag);
    }
    
    private /* synthetic */ void m32546(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c37958(this));
    }
    
    static {
        f32528 = new String[] { "Select", ",", ":", "minecraft", "(highlight)item id (default)(dirt, minecraft:stone, etc)", "value", "value" };
    }
    
    public static class c37373
    {
        private static final String[] f37374;
        private String f37375;
        private String f37376;
        private List<class_1792> f37377;
        private Consumer<List<class_1792>> f37378;
        private Consumer<Value<List<class_1792>>> f37379;
        
        public c37373() {
            super();
            this.f37375 = "undefined";
            this.f37376 = "";
        }
        
        public c37373 m37380(final String f37375) {
            this.f37375 = f37375;
            return this;
        }
        
        public c37373 m37383(final String f37376) {
            this.f37376 = f37376;
            return this;
        }
        
        public c37373 m37386(final List<class_1792> f37377) {
            this.f37377 = f37377;
            return this;
        }
        
        public c37373 m37389(final Consumer<List<class_1792>> f37378) {
            this.f37378 = f37378;
            return this;
        }
        
        public c37373 m37392(final Consumer<Value<List<class_1792>>> f37379) {
            this.f37379 = f37379;
            return this;
        }
        
        public c32527 m37395() {
            return new c32527(this.f37375, this.f37376, this.f37377, this.f37378, this.f37379);
        }
        
        static {
            f37374 = new String[] { "undefined", "" };
        }
    }
}
