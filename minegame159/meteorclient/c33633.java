package minegame159.meteorclient;

import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.*;

public class c33633
{
    public c33633() {
        super();
    }
    
    public static <T extends java.lang.Object> class_2499 m39899(final Iterable<T> iterable) {
        final ListTag listTag = new ListTag();
        final Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            listTag.add((Object)((c34681)iterator.next()).m34682());
        }
        return (class_2499)listTag;
    }
    
    public static <T> List<T> m39903(final class_2499 class_2499, final c33634<T> c33634) {
        final ArrayList<T> list = new ArrayList<T>(((ListTag)class_2499).size());
        final Iterator iterator = ((ListTag)class_2499).iterator();
        while (iterator.hasNext()) {
            list.add((T)c33634.m33635((Tag)iterator.next()));
        }
        return list;
    }
    
    public static <K, V extends java.lang.Object> class_2487 m39908(final Map<K, V> map) {
        final CompoundTag compoundTag = new CompoundTag();
        for (final K next : map.keySet()) {
            compoundTag.put(next.toString(), (Tag)((c34681)map.get(next)).m34682());
        }
        return (class_2487)compoundTag;
    }
    
    public static <K, V> Map<K, V> m39912(final class_2487 class_2487, final c38062<K> c38062, final c33634<V> c38063) {
        final HashMap<K, Object> hashMap = (HashMap<K, Object>)new HashMap<K, V>(((CompoundTag)class_2487).getSize());
        for (final String s : ((CompoundTag)class_2487).getKeys()) {
            hashMap.put(c38062.m38063(s), c38063.m33635(((CompoundTag)class_2487).get(s)));
        }
        return (Map<K, V>)hashMap;
    }
    
    public interface c33634<T>
    {
        T m33635(final class_2520 p0);
    }
    
    public interface c38062<T>
    {
        T m38063(final String p0);
    }
}
