package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import minegame159.meteorclient.*;
import net.minecraft.*;
import java.util.*;

public class Esp extends Module
{
    private static final String[] f31459;
    private static final c37042 f31460;
    private final Settings f31461;
    private final Settings f31462;
    private final Value<c31458.Mode> f31463;
    private final Value<List<class_1299<?>>> f31464;
    private final Value<c37042> f31465;
    private final Value<c37042> f31466;
    private final Value<c37042> f31467;
    private final Value<c37042> f31468;
    private final Value<c37042> f31469;
    private final Value<c37042> f31470;
    private final Value<Double> f31471;
    private final c37042 f31472;
    private int f31473;
    @EventHandler
    private final Listener<c36846> f31474;
    
    public Esp() {
        super(Category.Render, "esp", "See entities through walls.");
        this.f31461 = this.f38675.m34572();
        this.f31462 = this.f38675.m34588("Colors");
        this.f31463 = this.f31461.addValue((Value<c31458.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Rendering mode.").m36932((Enum)c31458.Mode.Outline).m36941());
        this.f31464 = this.f31461.addValue((Value<List<class_1299<?>>>)new c33686.c38917().m38925("entites").m38928("Select specific entities.").m38931(new ArrayList<class_1299<?>>(0)).m38942());
        this.f31465 = this.f31462.addValue((Value<c37042>)new c33179.c33180().m33187("players-color").m33190("Players color.").m33193(new c37042(255, 255, 255)).m33202());
        this.f31466 = this.f31462.addValue((Value<c37042>)new c33179.c33180().m33187("animals-color").m33190("Animals color.").m33193(new c37042(25, 255, 25, 255)).m33202());
        this.f31467 = this.f31462.addValue((Value<c37042>)new c33179.c33180().m33187("water-animals-color").m33190("Water animals color.").m33193(new c37042(25, 25, 255, 255)).m33202());
        this.f31468 = this.f31462.addValue((Value<c37042>)new c33179.c33180().m33187("monsters-color").m33190("Monsters color.").m33193(new c37042(255, 25, 25, 255)).m33202());
        this.f31469 = this.f31462.addValue((Value<c37042>)new c33179.c33180().m33187("ambient-color").m33190("Ambient color.").m33193(new c37042(25, 25, 25, 255)).m33202());
        this.f31470 = this.f31462.addValue((Value<c37042>)new c33179.c33180().m33187("misc-color").m33190("Misc color.").m33193(new c37042(125, 125, 125, 255)).m33202());
        this.f31471 = this.f31461.addValue((Value<Double>)new c37033.c38947().m38959("fade-distance").m38962("At which distance the color will fade out.").m38965(6.0).m38974(0.0).m38983(12.0).m38988());
        this.f31472 = new c37042();
        this.f31474 = (Listener<c36846>)new Listener(this::m31496, new Predicate[0]);
    }
    
    private void m31475(final c37042 c37042) {
        this.f31472.m37049(c37042);
        this.f31472.f37048 = 25;
    }
    
    private void m31478(final c36846 c36846, final Entity entity, final c37042 c36847) {
        this.m31475(c36847);
        final double squaredDistanceTo = this.mc.cameraEntity.squaredDistanceTo(entity.x + entity.getWidth() / 2.0f, entity.y + entity.getHeight() / 2.0f, entity.z + entity.getWidth() / 2.0f);
        double n = 1.0;
        if (squaredDistanceTo <= this.f31471.m33466() * this.f31471.m33466()) {
            n = squaredDistanceTo / (this.f31471.m33466() * this.f31471.m33466());
        }
        final int f37048 = c36847.f37048;
        final int f37049 = this.f31472.f37048;
        c36847.f37048 *= (int)n;
        final c37042 f37050 = this.f31472;
        f37050.f37048 *= (int)n;
        if (n >= 0.075) {
            final double n2 = (entity.x - entity.prevX) * c36846.f36847;
            final double n3 = (entity.y - entity.prevY) * c36846.f36847;
            final double n4 = (entity.z - entity.prevZ) * c36846.f36847;
            switch (c31458.c39187.f39188[this.f31463.m33466().ordinal()]) {
                case 1: {
                    final Box boundingBox = entity.getBoundingBox();
                    c39337.m39427(n2 + boundingBox.x1, n3 + boundingBox.y1, n4 + boundingBox.z1, n2 + boundingBox.x2, n3 + boundingBox.y2, n4 + boundingBox.z2, c36847);
                    break;
                }
                case 2: {
                    final Box boundingBox2 = entity.getBoundingBox();
                    c39337.m39453(n2 + boundingBox2.x1, n3 + boundingBox2.y1, n4 + boundingBox2.z1, n2 + boundingBox2.x2, n3 + boundingBox2.y2, n4 + boundingBox2.z2, this.f31472);
                    break;
                }
                case 3: {
                    final Box boundingBox3 = entity.getBoundingBox();
                    c39337.m39427(n2 + boundingBox3.x1, n3 + boundingBox3.y1, n4 + boundingBox3.z1, n2 + boundingBox3.x2, n3 + boundingBox3.y2, n4 + boundingBox3.z2, c36847);
                    c39337.m39453(n2 + boundingBox3.x1, n3 + boundingBox3.y1, n4 + boundingBox3.z1, n2 + boundingBox3.x2, n3 + boundingBox3.y2, n4 + boundingBox3.z2, this.f31472);
                    break;
                }
            }
        }
        c36847.f37048 = f37048;
        this.f31472.f37048 = f37049;
    }
    
    @Override
    public String m35302() {
        return Integer.toString(this.f31473);
    }
    
    public c37042 m31493(final Entity entity) {
        if (entity instanceof PlayerEntity) {
            return c39017.f39019.m39045((PlayerEntity)entity, this.f31465.m33466());
        }
        switch (c31458.c39187.f39189[entity.getType().getCategory().ordinal()]) {
            case 1: {
                return this.f31466.m33466();
            }
            case 2: {
                return this.f31467.m33466();
            }
            case 3: {
                return this.f31468.m33466();
            }
            case 4: {
                return this.f31469.m33466();
            }
            case 5: {
                return this.f31470.m33466();
            }
            default: {
                return Esp.f31460;
            }
        }
    }
    
    private /* synthetic */ void m31496(final c36846 c36846) {
        this.f31473 = 0;
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity != this.mc.cameraEntity) {
                if (!this.f31464.m33466().contains(entity.getType())) {
                    continue;
                }
                ++this.f31473;
                if (this.f31463.m33466() == c31458.Mode.Outline) {
                    c38335.f38337.add((class_1297)entity);
                }
                else {
                    this.m31478(c36846, entity, this.m31493(entity));
                }
            }
        }
    }
    
    static {
        f31459 = new String[] { "esp", "See entities through walls.", "Colors", "mode", "Rendering mode.", "entites", "Select specific entities.", "players-color", "Players color.", "animals-color", "Animals color.", "water-animals-color", "Water animals color.", "monsters-color", "Monsters color.", "ambient-color", "Ambient color.", "misc-color", "Misc color.", "fade-distance", "At which distance the color will fade out." };
        f31460 = new c37042(255, 255, 255);
    }
}
