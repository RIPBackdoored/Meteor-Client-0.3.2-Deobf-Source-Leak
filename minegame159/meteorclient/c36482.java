package minegame159.meteorclient;

import meteorclient.setting.*;
import net.minecraft.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import net.minecraft.sound.*;
import java.util.function.*;
import java.util.*;
import org.apache.commons.lang3.*;
import meteorclient.util.*;

public class c36482 extends c39130
{
    private static final String[] f36483;
    private final Value<List<class_3414>> f36484;
    private final c31399 f36485;
    
    public c36482(final Value<List<class_3414>> f36484) {
        super("Select sounds", true);
        this.f36484 = f36484;
        (this.f36485 = new c31399("", 0.0)).m31416(true);
        this.f36485.f31401 = (p0 -> {
            this.clear();
            this.m36486();
            return;
        });
        this.m36486();
    }
    
    private void m36486() {
        this.add(this.f36485).m39587().m39583();
        this.m39132();
        final c36715 c36715 = this.add(new c36715()).m39595().m39632();
        final Consumer consumer = this::m36512;
        if (this.f36485.f31403.isEmpty()) {
            Registry.SOUND_EVENT.forEach(consumer);
        }
        else {
            final ArrayList<Pair> list = new ArrayList<Pair>();
            Registry.SOUND_EVENT.forEach(this::m36507);
            list.sort(Comparator.comparingInt((ToIntFunction<? super Object>)c36482::m36505));
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                consumer.accept(iterator.next().getLeft());
            }
        }
        if (c36715.m32007().size() > 0) {
            this.add(new c38091()).m39585();
        }
        final c36715 c36716 = this.add(new c36715()).m39595().m39632();
        for (final SoundEvent soundEvent : this.f36484.m33466()) {
            c36716.m31937(new c39081(this.m36495(soundEvent)));
            c36716.m31937(new c36419()).m39632().f36420 = this::m36501;
            c36716.m36739();
        }
    }
    
    private String m36495(final SoundEvent soundEvent) {
        return StringUtils.capitalize(soundEvent.getId().getPath());
    }
    
    private void m36498() {
        final double f36732 = this.f39131.f36732;
        this.f36484.m33480();
        this.clear();
        this.m36486();
        this.f39131.m32005().m31962();
        this.f39131.m36792(0.0, f36732);
    }
    
    private /* synthetic */ void m36501(final SoundEvent soundEvent, final c36419 c36419) {
        if (this.f36484.m33466().remove(soundEvent)) {
            this.m36498();
        }
    }
    
    private static /* synthetic */ int m36505(final Pair pair) {
        return -(int)pair.getRight();
    }
    
    private /* synthetic */ void m36507(final List list, final SoundEvent soundEvent) {
        final int m35551 = EnchantUtil.m35551(this.m36495(soundEvent), this.f36485.f31403);
        if (m35551 > 0) {
            list.add(new Pair((Object)soundEvent, (Object)m35551));
        }
    }
    
    private /* synthetic */ void m36512(final c36715 c36715, final SoundEvent soundEvent) {
        if (this.f36484.m33466().contains(soundEvent)) {
            return;
        }
        c36715.m31937(new c39081(this.m36495(soundEvent)));
        c36715.m31937(new c35036()).m39632().f35037 = this::m36517;
        c36715.m36739();
    }
    
    private /* synthetic */ void m36517(final SoundEvent soundEvent, final c35036 c35036) {
        if (!this.f36484.m33466().contains(soundEvent)) {
            this.f36484.m33466().add((class_3414)soundEvent);
            this.m36498();
        }
    }
    
    private /* synthetic */ void m36521(final c31399 c31399) {
        this.clear();
        this.m36486();
    }
    
    static {
        f36483 = new String[] { "Select sounds", "" };
    }
}
