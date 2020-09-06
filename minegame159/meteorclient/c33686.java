package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;
import meteorclient.util.*;

public class c33686 extends Value<List<class_1299<?>>>
{
    private static final String[] f33687;
    public final boolean f33688;
    
    public c33686(final String s, final String s2, final List<class_1299<?>> list, final Consumer<List<class_1299<?>>> consumer, final Consumer<Value<List<class_1299<?>>>> consumer2, final boolean f33688) {
        super(s, s2, list, consumer, consumer2);
        this.f33688 = f33688;
        this.f33462 = (T)new ArrayList((Collection<? extends E>)list);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c34707(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new ArrayList((Collection<? extends E>)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected List<class_1299<?>> m33691(final String s) {
        final String[] split = s.split(",");
        final ArrayList<class_1299<?>> list = new ArrayList<class_1299<?>>(1);
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
                if (Registry.ENTITY_TYPE.containsId(identifier)) {
                    list.add((class_1299<?>)Registry.ENTITY_TYPE.get(identifier));
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m33701(final List<class_1299<?>> list) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)entity type (default)(pig, minecraft:zombie, etc)";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final ListTag listTag = new ListTag();
        final Iterator<EntityType> iterator = ((Value<List<EntityType>>)this).m33466().iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)new StringTag(Registry.ENTITY_TYPE.getId((Object)iterator.next()).toString()));
        }
        m33490.put("value", (Tag)listTag);
        return m33490;
    }
    
    public List<class_1299<?>> m33705(final class_2487 class_2487) {
        ((Value<List>)this).m33466().clear();
        final Iterator iterator = ((CompoundTag)class_2487).getList("value", 8).iterator();
        while (iterator.hasNext()) {
            final EntityType entityType = (EntityType)Registry.ENTITY_TYPE.get(new Identifier(iterator.next().asString()));
            if (!this.f33688 || EntityUtil.m33631(entityType)) {
                ((Value<List<EntityType>>)this).m33466().add(entityType);
            }
        }
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m33701((List<class_1299<?>>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m33691(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m33705(compoundTag);
    }
    
    private /* synthetic */ void m33713(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c34707(this));
    }
    
    static {
        f33687 = new String[] { "Select", ",", ":", "minecraft", "(highlight)entity type (default)(pig, minecraft:zombie, etc)", "value", "value" };
    }
    
    public static class c38917
    {
        private static final String[] f38918;
        private String f38919;
        private String f38920;
        private List<class_1299<?>> f38921;
        private Consumer<List<class_1299<?>>> f38922;
        private Consumer<Value<List<class_1299<?>>>> f38923;
        private boolean f38924;
        
        public c38917() {
            super();
            this.f38919 = "undefined";
            this.f38920 = "";
            this.f38924 = false;
        }
        
        public c38917 m38925(final String f38919) {
            this.f38919 = f38919;
            return this;
        }
        
        public c38917 m38928(final String f38920) {
            this.f38920 = f38920;
            return this;
        }
        
        public c38917 m38931(final List<class_1299<?>> f38921) {
            this.f38921 = f38921;
            return this;
        }
        
        public c38917 m38934(final Consumer<List<class_1299<?>>> f38922) {
            this.f38922 = f38922;
            return this;
        }
        
        public c38917 m38937(final Consumer<Value<List<class_1299<?>>>> f38923) {
            this.f38923 = f38923;
            return this;
        }
        
        public c38917 m38940() {
            this.f38924 = true;
            return this;
        }
        
        public c33686 m38942() {
            return new c33686(this.f38919, this.f38920, this.f38921, this.f38922, this.f38923, this.f38924);
        }
        
        static {
            f38918 = new String[] { "undefined", "" };
        }
    }
}
