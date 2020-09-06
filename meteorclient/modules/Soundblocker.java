package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import net.minecraft.sound.*;
import java.util.*;

public class Soundblocker extends Module
{
    private static final String[] f33101;
    private final Settings f33102;
    private final Value<List<class_3414>> f33103;
    @EventHandler
    private final Listener<c38846> f33104;
    
    public Soundblocker() {
        super(Category.Misc, "sound-blocker", "Blocks selected sounds.");
        this.f33102 = this.f38675.m34572();
        this.f33103 = this.f33102.addValue((Value<List<class_3414>>)new c36391.c36392().m36399("sounds").m36402("Sounds to block.").m36405(new ArrayList<class_3414>(0)).m36414());
        this.f33104 = (Listener<c38846>)new Listener(this::m33105, new Predicate[0]);
    }
    
    private /* synthetic */ void m33105(final c38846 c38846) {
        final Iterator<class_3414> iterator = this.f33103.m33466().iterator();
        while (iterator.hasNext()) {
            if (((SoundEvent)iterator.next()).getId().equals((Object)c38846.f38847.getId())) {
                c38846.m32674();
                break;
            }
        }
    }
    
    static {
        f33101 = new String[] { "sound-blocker", "Blocks selected sounds.", "sounds", "Sounds to block." };
    }
}
