package minegame159.meteorclient;

import meteorclient.setting.*;
import java.util.function.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.sound.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;

public class c36391 extends Value<List<class_3414>>
{
    private static final String[] f36812;
    
    public c36391(final String s, final String s2, final List<class_3414> list, final Consumer<List<class_3414>> consumer, final Consumer<Value<List<class_3414>>> consumer2) {
        super(s, s2, list, consumer, consumer2);
        this.f33462 = (T)new ArrayList((Collection<? extends E>)list);
        this.f33465 = new c38616("Select");
        ((c38616)this.f33465).f38618 = (p0 -> MinecraftClient.getInstance().openScreen((Screen)new c36482(this)));
    }
    
    @Override
    public void m33471(final boolean b) {
        this.f33462 = (T)new ArrayList((Collection<? extends E>)this.f33461);
        if (b) {
            this.m33485();
            this.m33480();
        }
    }
    
    protected List<class_3414> m36815(final String s) {
        final String[] split = s.split(",");
        final ArrayList<class_3414> list = new ArrayList<class_3414>(1);
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
            list.add((class_3414)Registry.SOUND_EVENT.get(identifier));
        }
        return list;
    }
    
    @Override
    public void m33485() {
    }
    
    protected boolean m36825(final List<class_3414> list) {
        return true;
    }
    
    @Override
    protected String m33489() {
        return "(highlight)sound id (default)(block_anvil_hit, minecraft:entity_bat_hurt, etc)";
    }
    
    @Override
    public CompoundTag m34682() {
        final CompoundTag m33490 = this.m33490();
        final ListTag listTag = new ListTag();
        final Iterator<SoundEvent> iterator = ((Value<List<SoundEvent>>)this).m33466().iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)new StringTag(Registry.SOUND_EVENT.getId((Object)iterator.next()).toString()));
        }
        m33490.put("value", (Tag)listTag);
        return m33490;
    }
    
    public List<class_3414> m36833(final class_2487 class_2487) {
        ((Value<List>)this).m33466().clear();
        final Iterator iterator = ((CompoundTag)class_2487).getList("value", 8).iterator();
        while (iterator.hasNext()) {
            ((Value<List<Object>>)this).m33466().add(Registry.SOUND_EVENT.get(new Identifier(iterator.next().asString())));
        }
        this.m33480();
        return this.m33466();
    }
    
    @Override
    protected /* bridge */ boolean m33486(final Object o) {
        return this.m36825((List<class_3414>)o);
    }
    
    @Override
    protected /* bridge */ Object m33484(final String s) {
        return this.m36815(s);
    }
    
    public /* bridge */ Object m34683(final CompoundTag compoundTag) {
        return this.m36833(compoundTag);
    }
    
    private /* synthetic */ void m36841(final c38616 c38616) {
        MinecraftClient.getInstance().openScreen((Screen)new c36482(this));
    }
    
    static {
        f36812 = new String[] { "Select", ",", ":", "minecraft", "(highlight)sound id (default)(block_anvil_hit, minecraft:entity_bat_hurt, etc)", "value", "value" };
    }
    
    public static class c36392
    {
        private static final String[] f36393;
        private String f36394;
        private String f36395;
        private List<class_3414> f36396;
        private Consumer<List<class_3414>> f36397;
        private Consumer<Value<List<class_3414>>> f36398;
        
        public c36392() {
            super();
            this.f36394 = "undefined";
            this.f36395 = "";
        }
        
        public c36392 m36399(final String f36394) {
            this.f36394 = f36394;
            return this;
        }
        
        public c36392 m36402(final String f36395) {
            this.f36395 = f36395;
            return this;
        }
        
        public c36392 m36405(final List<class_3414> f36396) {
            this.f36396 = f36396;
            return this;
        }
        
        public c36392 m36408(final Consumer<List<class_3414>> f36397) {
            this.f36397 = f36397;
            return this;
        }
        
        public c36392 m36411(final Consumer<Value<List<class_3414>>> f36398) {
            this.f36398 = f36398;
            return this;
        }
        
        public c36391 m36414() {
            return new c36391(this.f36394, this.f36395, this.f36396, this.f36397, this.f36398);
        }
        
        static {
            f36393 = new String[] { "undefined", "" };
        }
    }
}
