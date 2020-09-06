package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.entity.*;
import java.util.*;
import minegame159.meteorclient.*;

public class Tracers extends Module
{
    private static final String[] f39190;
    private final Settings f39191;
    private final Settings f39192;
    private final Settings f39193;
    private final Value<List<class_1299<?>>> f39194;
    private final Value<Boolean> f39195;
    private final Value<c32247.Target> f39196;
    private final Value<c32247.Mode> f39197;
    private final Value<c37042> f39198;
    private final Value<c37042> f39199;
    private final Value<c37042> f39200;
    private final Value<c37042> f39201;
    private final Value<c37042> f39202;
    private final Value<c37042> f39203;
    private final Value<c37042> f39204;
    private Vec3d f39205;
    private int f39206;
    @EventHandler
    private final Listener<c36846> f39207;
    
    public Tracers() {
        super(Category.Render, "tracers", "Displays lines to entities.");
        this.f39191 = this.f38675.m34572();
        this.f39192 = this.f38675.m34588("Appearance");
        this.f39193 = this.f38675.m34588("Colors");
        this.f39194 = this.f39191.addValue((Value<List<class_1299<?>>>)new c33686.c38917().m38925("entites").m38928("Select specific entities.").m38931(new ArrayList<class_1299<?>>(0)).m38942());
        this.f39195 = this.f39191.addValue((Value<Boolean>)new c34427.c34657().m34664("storage").m34667("Display storage blocks.").m34670(false).m34679());
        this.f39196 = this.f39192.addValue((Value<c32247.Target>)new c36601.c36919<Enum>().m36926("target").m36929("Which body part to target.").m36932((Enum)c32247.Target.Body).m36941());
        this.f39197 = this.f39192.addValue((Value<c32247.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Rendering mode.").m36932((Enum)c32247.Mode.Simple).m36941());
        this.f39198 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("players-colors").m33190("Players color.").m33193(new c37042(205, 205, 205)).m33202());
        this.f39199 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("animals-color").m33190("Animals color.").m33193(new c37042(145, 255, 145, 255)).m33202());
        this.f39200 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("water-animals-color").m33190("Water animals color.").m33193(new c37042(145, 145, 255, 255)).m33202());
        this.f39201 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("monsters-color").m33190("Monsters color.").m33193(new c37042(255, 145, 145, 255)).m33202());
        this.f39202 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("ambient-color").m33190("Ambient color.").m33193(new c37042(75, 75, 75, 255)).m33202());
        this.f39203 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("misc-color").m33190("Misc color.").m33193(new c37042(145, 145, 145, 255)).m33202());
        this.f39204 = this.f39193.addValue((Value<c37042>)new c33179.c33180().m33187("storage-color").m33190("Storage color.").m33193(new c37042(255, 160, 0)).m33202());
        this.f39207 = (Listener<c36846>)new Listener(this::m39223, new Predicate[0]);
    }
    
    private void m39208(final Entity entity, final c37042 c37042, final c36846 c37043) {
        final double n = entity.prevX + (entity.x - entity.prevX) * c37043.f36847;
        double n2 = entity.prevY + (entity.y - entity.prevY) * c37043.f36847;
        final double n3 = entity.prevZ + (entity.z - entity.prevZ) * c37043.f36847;
        final double n4 = entity.getBoundingBox().y2 - entity.getBoundingBox().y1;
        if (this.f39196.m33466() == c32247.Target.Head) {
            n2 += n4;
        }
        else if (this.f39196.m33466() == c32247.Target.Body) {
            n2 += n4 / 2.0;
        }
        c39337.m39404(this.f39205.x - (this.mc.cameraEntity.x - c37043.f36848), this.f39205.y - (this.mc.cameraEntity.y - c37043.f36849), this.f39205.z - (this.mc.cameraEntity.z - c37043.f36850), n, n2, n3, c37042);
        if (this.f39197.m33466() == c32247.Mode.Stem) {
            c39337.m39404(n, entity.y, n3, n, entity.y + n4, n3, c37042);
        }
        ++this.f39206;
    }
    
    private void m39217(final BlockEntity blockEntity, final c36846 c36846) {
        final BlockPos pos = blockEntity.getPos();
        c39337.m39404(this.f39205.x - (this.mc.cameraEntity.x - c36846.f36848), this.f39205.y - (this.mc.cameraEntity.y - c36846.f36849), this.f39205.z - (this.mc.cameraEntity.z - c36846.f36850), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5f, this.f39204.m33466());
        ++this.f39206;
    }
    
    @Override
    public String m35302() {
        return Integer.toString(this.f39206);
    }
    
    private /* synthetic */ void m39223(final c36846 c36846) {
        this.f39206 = 0;
        this.f39205 = new Vec3d(0.0, 0.0, 1.0).rotateX(-(float)Math.toRadians(this.mc.cameraEntity.pitch)).rotateY(-(float)Math.toRadians(this.mc.cameraEntity.yaw)).add(this.mc.cameraEntity.getPos());
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity != this.mc.cameraEntity) {
                if (!this.f39194.m33466().contains(entity.getType())) {
                    continue;
                }
                if (entity instanceof PlayerEntity) {
                    c37042 f31547 = this.f39198.m33466();
                    final c31543 m39030 = c39017.f39019.m39030(((PlayerEntity)entity).getGameProfile().getName());
                    if (m39030 != null) {
                        f31547 = m39030.f31547;
                    }
                    if (m39030 != null && !m39030.f31549) {
                        continue;
                    }
                    this.m39208(entity, f31547, c36846);
                }
                else {
                    switch (c32247.c32248.f32249[entity.getType().getCategory().ordinal()]) {
                        case 1: {
                            this.m39208(entity, this.f39199.m33466(), c36846);
                            continue;
                        }
                        case 2: {
                            this.m39208(entity, this.f39200.m33466(), c36846);
                            continue;
                        }
                        case 3: {
                            this.m39208(entity, this.f39201.m33466(), c36846);
                            continue;
                        }
                        case 4: {
                            this.m39208(entity, this.f39202.m33466(), c36846);
                            continue;
                        }
                        case 5: {
                            this.m39208(entity, this.f39203.m33466(), c36846);
                            continue;
                        }
                    }
                }
            }
        }
        if (this.f39195.m33466()) {
            for (final BlockEntity blockEntity : this.mc.world.blockEntities) {
                if (blockEntity instanceof ChestBlockEntity || blockEntity instanceof BarrelBlockEntity || blockEntity instanceof ShulkerBoxBlockEntity) {
                    this.m39217(blockEntity, c36846);
                }
            }
        }
    }
    
    static {
        f39190 = new String[] { "tracers", "Displays lines to entities.", "Appearance", "Colors", "entites", "Select specific entities.", "storage", "Display storage blocks.", "target", "Which body part to target.", "mode", "Rendering mode.", "players-colors", "Players color.", "animals-color", "Animals color.", "water-animals-color", "Water animals color.", "monsters-color", "Monsters color.", "ambient-color", "Ambient color.", "misc-color", "Misc color.", "storage-color", "Storage color." };
    }
}
