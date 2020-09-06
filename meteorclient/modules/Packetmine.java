package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import minegame159.meteorclient.*;
import java.util.function.*;
import java.util.*;
import net.minecraft.client.*;

public class Packetmine extends Module
{
    private static final String[] f37252;
    private final Settings f37253;
    private final Value<Boolean> f37254;
    private final c32900<c33676.c35013> f37255;
    private final List<c33676.c35013> f37256;
    @EventHandler
    private final Listener<c32772> f37257;
    @EventHandler
    private final Listener<c36575> f37258;
    
    public Packetmine() {
        super(Category.Player, "packet-mine", "Sends packet to mine blocks without mining animation.");
        this.f37253 = this.f38675.m34572();
        this.f37254 = this.f37253.addValue((Value<Boolean>)new c34427.c34657().m34664("one-by-one").m34667("Mines blocks one by one.").m34670(true).m34679());
        this.f37255 = new c32900<c33676.c35013>(this::m37268);
        this.f37256 = new ArrayList<c33676.c35013>();
        this.f37257 = (Listener<c32772>)new Listener(this::m37264, new Predicate[0]);
        this.f37258 = (Listener<c36575>)new Listener(this::m37261, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        final Iterator<c33676.c35013> iterator = this.f37256.iterator();
        while (iterator.hasNext()) {
            this.f37255.m32905(iterator.next());
        }
        this.f37256.clear();
    }
    
    private /* synthetic */ void m37261(final c36575 c36575) {
        if (this.f37254.m33466()) {
            if (this.f37256.size() > 0 && this.f37256.get(this.f37256.size() - 1).m35017()) {
                this.f37256.remove(this.f37256.size() - 1);
            }
        }
        else {
            this.f37256.removeIf(c33676.c35013::m35017);
        }
    }
    
    private /* synthetic */ void m37264(final c32772 c32772) {
        final c33676.c35013 c32773 = this.f37255.m32903();
        c32773.f35014 = c32772.f32773;
        c32773.f35015 = c32772.f32774;
        this.f37256.add(c32773);
        c32772.m32674();
    }
    
    private /* synthetic */ c33676.c35013 m37268() {
        return new c33676.c35013(this, (c33676.c33677)null);
    }
    
    static /* synthetic */ MinecraftClient m37270(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37272(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37274(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37276(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37278(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37280(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37282(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37284(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static /* synthetic */ MinecraftClient m37286(final Packetmine packetmine) {
        return packetmine.mc;
    }
    
    static {
        f37252 = new String[] { "packet-mine", "Sends packet to mine blocks without mining animation.", "one-by-one", "Mines blocks one by one." };
    }
}
