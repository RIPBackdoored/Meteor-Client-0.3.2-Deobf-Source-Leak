package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import minegame159.meteorclient.*;
import java.util.*;
import net.minecraft.entity.*;

public class Chams extends Module
{
    private static final String[] f32474;
    private final Settings f32475;
    private final Value<List<class_1299<?>>> f32476;
    
    public Chams() {
        super(Category.Render, "chams", "Renders entities through blocks.");
        this.f32475 = this.f38675.m34572();
        this.f32476 = this.f32475.addValue((Value<List<class_1299<?>>>)new c33686.c38917().m38925("entities").m38928("Select entities to show through walls.").m38931(new ArrayList<class_1299<?>>(0)).m38942());
    }
    
    public boolean m32477(final LivingEntity livingEntity) {
        return this.m35315() && this.f32476.m33466().contains(livingEntity.getType());
    }
    
    static {
        f32474 = new String[] { "chams", "Renders entities through blocks.", "entities", "Select entities to show through walls." };
    }
}
