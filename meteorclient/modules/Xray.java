package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import java.util.*;
import minegame159.meteorclient.*;
import net.minecraft.block.*;

public class Xray extends Module
{
    private static final String[] f38223;
    private final Settings f38224;
    private final Value<List<class_2248>> f38225;
    private boolean f38226;
    
    public Xray() {
        super(Category.Render, "xray", "See only specified blocks.");
        this.f38224 = this.f38675.m34572();
        this.f38225 = this.f38224.addValue((Value<List<class_2248>>)new c31769.c36992().m36999("blocks").m37002("Blocks.").m37005(new ArrayList<class_2248>(0)).m37008(this::m38234).m37014());
        this.f38226 = false;
    }
    
    @Override
    public void m35292() {
        final Fullbright fullbright = c34030.f34033.m34042(Fullbright.class);
        this.f38226 = fullbright.m35315();
        if (!fullbright.m35315()) {
            fullbright.m35300();
        }
        this.mc.worldRenderer.reload();
    }
    
    @Override
    public void m35294() {
        final Fullbright fullbright = c34030.f34033.m34042(Fullbright.class);
        if (!this.f38226 && fullbright.m35315()) {
            fullbright.m35300();
        }
        if (!MeteorClient.f32301) {
            this.mc.worldRenderer.reload();
        }
    }
    
    public boolean m38231(final Block block) {
        return this.m35315() && !this.f38225.m33466().contains(block);
    }
    
    private /* synthetic */ void m38234(final List list) {
        if (this.m35315()) {
            this.mc.worldRenderer.reload();
        }
    }
    
    static {
        f38223 = new String[] { "xray", "See only specified blocks.", "blocks", "Blocks." };
    }
}
