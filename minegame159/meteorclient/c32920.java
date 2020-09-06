package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.block.entity.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;

public class c32920 extends Value<List<class_2591<?>>>
{
    private static final String[] f35245;
    public static final class_2591<?>[] f35246;
    public static final String[] f35247;
    
    public c32920(final String s, final String s2, final List<class_2591<?>> list, final Consumer<List<class_2591<?>>> consumer, final Consumer<Value<List<class_2591<?>>>> consumer2) {
        super(s, s2, list, consumer, consumer2);
        this.f33462 = (T)new ArrayList((Collection<? extends E>)list);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c40072(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new ArrayList((Collection<? extends E>)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected List<class_2591<?>> m35250(final String s) {
        final String[] split = s.split(",");
        final ArrayList<class_2591<?>> list = new ArrayList<class_2591<?>>(1);
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
                if (Registry.BLOCK_ENTITY.containsId(identifier)) {
                    list.add((class_2591<?>)Registry.BLOCK_ENTITY.get(identifier));
                }
            }
        }
        catch (Exception ex) {}
        return list;
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m35260(final List<class_2591<?>> list) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)storage block id(default)(chest, minecraft:ender_chest, etc)";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final ListTag listTag = new ListTag();
        final Iterator<BlockEntityType> iterator = ((Value<List<BlockEntityType>>)this).m33466().iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)new StringTag(Registry.BLOCK_ENTITY.getId((Object)iterator.next()).toString()));
        }
        m33490.put("value", (Tag)listTag);
        return m33490;
    }
    
    public List<class_2591<?>> m35268(final class_2487 class_2487) {
        ((Value<List>)this).m33466().clear();
        final Iterator iterator = ((CompoundTag)class_2487).getList("value", 8).iterator();
        while (iterator.hasNext()) {
            ((Value<List<Object>>)this).m33466().add(Registry.BLOCK_ENTITY.get(new Identifier(iterator.next().asString())));
        }
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m35260((List<class_2591<?>>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m35250(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m35268(compoundTag);
    }
    
    private /* synthetic */ void m35276(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c40072(this));
    }
    
    static {
        f35245 = new String[] { "Select", ",", ":", "minecraft", "(highlight)storage block id(default)(chest, minecraft:ender_chest, etc)", "value", "value", "Furnace", "Chest", "Trapped Chest", "Ender Chest", "Dispenser", "Dropper", "Hopper", "Shulker Box", "Barrel", "Smoker", "Blast Furnace" };
        f35246 = (class_2591[])new BlockEntityType[] { BlockEntityType.field_11903, BlockEntityType.field_11914, BlockEntityType.field_11891, BlockEntityType.field_11901, BlockEntityType.field_11887, BlockEntityType.field_11899, BlockEntityType.field_11888, BlockEntityType.field_11896, BlockEntityType.field_16411, BlockEntityType.field_16414, BlockEntityType.field_16415 };
        f35247 = new String[] { "Furnace", "Chest", "Trapped Chest", "Ender Chest", "Dispenser", "Dropper", "Hopper", "Shulker Box", "Barrel", "Smoker", "Blast Furnace" };
    }
    
    public static class c32921
    {
        private static final String[] f32922;
        private String f32923;
        private String f32924;
        private List<class_2591<?>> f32925;
        private Consumer<List<class_2591<?>>> f32926;
        private Consumer<Value<List<class_2591<?>>>> f32927;
        
        public c32921() {
            super();
            this.f32923 = "undefined";
            this.f32924 = "";
        }
        
        public c32921 m32928(final String f32923) {
            this.f32923 = f32923;
            return this;
        }
        
        public c32921 m32931(final String f32924) {
            this.f32924 = f32924;
            return this;
        }
        
        public c32921 m32934(final List<class_2591<?>> f32925) {
            this.f32925 = f32925;
            return this;
        }
        
        public c32921 m32937(final Consumer<List<class_2591<?>>> f32926) {
            this.f32926 = f32926;
            return this;
        }
        
        public c32921 m32940(final Consumer<Value<List<class_2591<?>>>> f32927) {
            this.f32927 = f32927;
            return this;
        }
        
        public c32920 m32943() {
            return new c32920(this.f32923, this.f32924, this.f32925, this.f32926, this.f32927);
        }
        
        static {
            f32922 = new String[] { "undefined", "" };
        }
    }
}
