package minegame159.meteorclient;

import net.minecraft.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import java.util.*;
import java.util.function.*;
import meteorclient.util.*;
import net.minecraft.entity.*;
import meteorclient.setting.*;

public class c34707 extends c39130
{
    private static final String[] f39762;
    private final c33686 f39763;
    private final c31399 f39764;
    private c32718 f39765;
    private c32718 f39766;
    private c32718 f39767;
    private c32718 f39768;
    private c32718 f39769;
    int f39770;
    int f39771;
    int f39772;
    int f39773;
    int f39774;
    
    public c34707(final c33686 f39763) {
        super("Select entities", true);
        this.f39770 = 0;
        this.f39771 = 0;
        this.f39772 = 0;
        this.f39773 = 0;
        this.f39774 = 0;
        this.f39763 = f39763;
        (this.f39764 = new c31399("", 0.0)).m31416(true);
        this.f39764.f31401 = (p0 -> {
            this.clear();
            this.m39775();
            return;
        });
        this.m39775();
    }
    
    private void m39775() {
        final int f39770 = 0;
        this.f39774 = f39770;
        this.f39773 = f39770;
        this.f39772 = f39770;
        this.f39771 = f39770;
        this.f39770 = f39770;
        for (final EntityType entityType : ((Value<List<EntityType>>)this.f39763).m33466()) {
            if (!this.f39763.f33688 || EntityUtil.m33631(entityType)) {
                switch (c34708.f34709[entityType.getCategory().ordinal()]) {
                    case 1: {
                        ++this.f39770;
                        continue;
                    }
                    case 2: {
                        ++this.f39771;
                        continue;
                    }
                    case 3: {
                        ++this.f39772;
                        continue;
                    }
                    case 4: {
                        ++this.f39773;
                        continue;
                    }
                    case 5: {
                        ++this.f39774;
                        continue;
                    }
                }
            }
        }
        this.add(this.f39764).m39587().m39583();
        this.m39132();
        final ArrayList<class_1299<?>> list = new ArrayList<class_1299<?>>();
        final boolean b = this.f39765 != null && this.f39765.f32722;
        this.f39765 = new c32718("Animals");
        if (this.f39765.f32722 != b) {
            this.f39765.m32754(b);
        }
        this.f39765.f36733 = false;
        final c38264 c38269 = this.f39765.f32720.m31937(new c38264(this.f39770 > 0)).m39632();
        c38269.f38265 = (c38264 -> this.m39792(list, c38264.f38266));
        this.m39132();
        final ArrayList<class_1299<?>> list2 = new ArrayList<class_1299<?>>();
        final boolean b2 = this.f39766 != null && this.f39766.f32722;
        this.f39766 = new c32718("Water Animals");
        if (this.f39766.f32722 != b2) {
            this.f39766.m32754(b2);
        }
        this.f39766.f36733 = false;
        final c38264 c38270 = this.f39766.f32720.m31937(new c38264(this.f39771 > 0)).m39632();
        c38270.f38265 = (c38265 -> this.m39792(list2, c38265.f38266));
        this.m39132();
        final ArrayList<class_1299<?>> list3 = new ArrayList<class_1299<?>>();
        final boolean b3 = this.f39767 != null && this.f39767.f32722;
        this.f39767 = new c32718("Monsters");
        if (this.f39767.f32722 != b3) {
            this.f39767.m32754(b3);
        }
        this.f39767.f36733 = false;
        final c38264 c38271 = this.f39767.f32720.m31937(new c38264(this.f39772 > 0)).m39632();
        c38271.f38265 = (c38266 -> this.m39792(list3, c38266.f38266));
        this.m39132();
        final ArrayList<class_1299<?>> list4 = new ArrayList<class_1299<?>>();
        final boolean b4 = this.f39768 != null && this.f39768.f32722;
        this.f39768 = new c32718("Ambient");
        if (this.f39768.f32722 != b4) {
            this.f39768.m32754(b4);
        }
        this.f39768.f36733 = false;
        final c38264 c38272 = this.f39768.f32720.m31937(new c38264(this.f39773 > 0)).m39632();
        c38272.f38265 = (c38267 -> this.m39792(list4, c38267.f38266));
        this.m39132();
        final ArrayList<class_1299<?>> list5 = new ArrayList<class_1299<?>>();
        final boolean b5 = this.f39769 != null && this.f39769.f32722;
        this.f39769 = new c32718("Misc");
        if (this.f39769.f32722 != b5) {
            this.f39769.m32754(b5);
        }
        this.f39769.f36733 = false;
        final c38264 c38273 = this.f39769.f32720.m31937(new c38264(this.f39774 > 0)).m39632();
        c38273.f38265 = (c38268 -> this.m39792(list5, c38268.f38266));
        this.m39132();
        final Consumer consumer = this::m39815;
        if (this.f39764.f31403.isEmpty()) {
            Registry.ENTITY_TYPE.forEach(consumer);
        }
        else {
            final ArrayList<Pair> list6 = new ArrayList<Pair>();
            Registry.ENTITY_TYPE.forEach(this::m39810);
            list6.sort(Comparator.comparingInt((ToIntFunction<? super Object>)c34707::m39808));
            final Iterator<Object> iterator2 = list6.iterator();
            while (iterator2.hasNext()) {
                consumer.accept(iterator2.next().getLeft());
            }
        }
        if (this.f39765.f32721.m32007().size() > 0) {
            this.add(this.f39765).m39587().m39583();
        }
        if (this.f39766.f32721.m32007().size() > 0) {
            this.add(this.f39766).m39587().m39583();
        }
        if (this.f39767.f32721.m32007().size() > 0) {
            this.add(this.f39767).m39587().m39583();
        }
        if (this.f39768.f32721.m32007().size() > 0) {
            this.add(this.f39768).m39587().m39583();
        }
        if (this.f39769.f32721.m32007().size() > 0) {
            this.add(this.f39769).m39587().m39583();
        }
    }
    
    private void m39792(final List<class_1299<?>> list, final boolean b) {
        boolean b2 = false;
        for (final EntityType entityType : list) {
            if (b) {
                if (((Value<List>)this.f39763).m33466().contains(entityType)) {
                    continue;
                }
                ((Value<List<EntityType>>)this.f39763).m33466().add(entityType);
                b2 = true;
            }
            else {
                if (!((Value<List>)this.f39763).m33466().contains(entityType)) {
                    continue;
                }
                ((Value<List>)this.f39763).m33466().remove(entityType);
                b2 = true;
            }
        }
        if (b2) {
            this.clear();
            this.m39775();
            this.f39763.m33480();
        }
    }
    
    private void m39798(final c36715 c36715, final c38264 c36716, final class_1299<?> class_1299) {
        c36715.m31937(new c39081(((EntityType)class_1299).getName().asString()));
        c36715.m31937(new c38264(((Value<List>)this.f39763).m33466().contains(class_1299))).m39587().m39589().m39632().f38265 = this::m39803;
        c36715.m36739();
    }
    
    private /* synthetic */ void m39803(final EntityType entityType, final c38264 c38264, final c38264 c38265) {
        if (c38265.f38266) {
            if (!((Value<List>)this.f39763).m33466().contains(entityType)) {
                ((Value<List<EntityType>>)this.f39763).m33466().add(entityType);
                switch (c34708.f34709[entityType.getCategory().ordinal()]) {
                    case 1: {
                        if (this.f39770 == 0) {
                            c38264.f38266 = true;
                        }
                        ++this.f39770;
                        break;
                    }
                    case 2: {
                        if (this.f39771 == 0) {
                            c38264.f38266 = true;
                        }
                        ++this.f39771;
                        break;
                    }
                    case 3: {
                        if (this.f39772 == 0) {
                            c38264.f38266 = true;
                        }
                        ++this.f39772;
                        break;
                    }
                    case 4: {
                        if (this.f39773 == 0) {
                            c38264.f38266 = true;
                        }
                        ++this.f39773;
                        break;
                    }
                    case 5: {
                        if (this.f39774 == 0) {
                            c38264.f38266 = true;
                        }
                        ++this.f39774;
                        break;
                    }
                }
            }
        }
        else if (((Value<List>)this.f39763).m33466().remove(entityType)) {
            switch (c34708.f34709[entityType.getCategory().ordinal()]) {
                case 1: {
                    --this.f39770;
                    if (this.f39770 == 0) {
                        c38264.f38266 = false;
                        break;
                    }
                    break;
                }
                case 2: {
                    --this.f39771;
                    if (this.f39771 == 0) {
                        c38264.f38266 = false;
                        break;
                    }
                    break;
                }
                case 3: {
                    --this.f39772;
                    if (this.f39772 == 0) {
                        c38264.f38266 = false;
                        break;
                    }
                    break;
                }
                case 4: {
                    --this.f39773;
                    if (this.f39773 == 0) {
                        c38264.f38266 = false;
                        break;
                    }
                    break;
                }
                case 5: {
                    --this.f39774;
                    if (this.f39774 == 0) {
                        c38264.f38266 = false;
                        break;
                    }
                    break;
                }
            }
        }
        this.f39763.m33480();
    }
    
    private static /* synthetic */ int m39808(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private /* synthetic */ void m39810(final List list, final EntityType entityType) {
        final int m35551 = EnchantUtil.m35551(entityType.getName().asFormattedString(), this.f39764.f31403);
        if (m35551 > 0) {
            list.add(new Pair((Object)entityType, (Object)m35551));
        }
    }
    
    private /* synthetic */ void m39815(final List list, final c38264 c38264, final List list2, final c38264 c38265, final List list3, final c38264 c38266, final List list4, final c38264 c38267, final List list5, final c38264 c38268, final EntityType entityType) {
        if (!this.f39763.f33688 || EntityUtil.m33631(entityType)) {
            switch (c34708.f34709[entityType.getCategory().ordinal()]) {
                case 1: {
                    list.add(entityType);
                    this.m39798((c36715)this.f39765, c38264, entityType);
                    break;
                }
                case 2: {
                    list2.add(entityType);
                    this.m39798((c36715)this.f39766, c38265, entityType);
                    break;
                }
                case 3: {
                    list3.add(entityType);
                    this.m39798((c36715)this.f39767, c38266, entityType);
                    break;
                }
                case 4: {
                    list4.add(entityType);
                    this.m39798((c36715)this.f39768, c38267, entityType);
                    break;
                }
                case 5: {
                    list5.add(entityType);
                    this.m39798((c36715)this.f39769, c38268, entityType);
                    break;
                }
            }
        }
    }
    
    private /* bridge */ void m39828(final List list, final c38264 c38264) {
        this.m39792(list, c38264.f38266);
    }
    
    private /* bridge */ void m39832(final List list, final c38264 c38264) {
        this.m39792(list, c38264.f38266);
    }
    
    private /* bridge */ void m39836(final List list, final c38264 c38264) {
        this.m39792(list, c38264.f38266);
    }
    
    private /* bridge */ void m39840(final List list, final c38264 c38264) {
        this.m39792(list, c38264.f38266);
    }
    
    private /* bridge */ void m39844(final List list, final c38264 c38264) {
        this.m39792(list, c38264.f38266);
    }
    
    private /* synthetic */ void m39848(final c31399 c31399) {
        this.clear();
        this.m39775();
    }
    
    static {
        f39762 = new String[] { "Select entities", "", "Animals", "Water Animals", "Monsters", "Ambient", "Misc" };
    }
    
    static class c34708
    {
        static final /* synthetic */ int[] f34709;
        
        static {
            f34709 = new int[EntityCategory.values().length];
            try {
                c34708.f34709[EntityCategory.field_6294.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                c34708.f34709[EntityCategory.field_6300.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                c34708.f34709[EntityCategory.field_6302.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                c34708.f34709[EntityCategory.field_6303.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                c34708.f34709[EntityCategory.field_17715.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
        }
    }
}
