package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.client.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.decoration.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.dimension.*;
import net.minecraft.block.entity.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.container.*;

public class Autototem extends Module
{
    private static final String[] f33323;
    private final Settings f33324;
    private final Value<Boolean> f33325;
    private final Value<Boolean> f33326;
    private final Value<Boolean> f33327;
    private final Value<Integer> f33328;
    private int f33329;
    private String f33330;
    private final MinecraftClient f33331;
    private boolean f33332;
    @EventHandler
    private final Listener<c36575> f33333;
    
    public Autototem() {
        super(Category.Combat, "auto-totem", "Automatically equips totems.");
        this.f33324 = this.f38675.m34572();
        this.f33325 = this.f33324.addValue((Value<Boolean>)new c34427.c34657().m34664("smart").m34667("Only switches to totem when in danger of dying").m34670(false).m34679());
        this.f33326 = this.f33324.addValue((Value<Boolean>)new c34427.c34657().m34664("fallback").m34667("Enables offhand extra when you are out of totems.").m34670(true).m34679());
        this.f33327 = this.f33324.addValue((Value<Boolean>)new c34427.c34657().m34664("inventory").m34667("Switches totems while you are in your inventory").m34670(true).m34679());
        this.f33328 = this.f33324.addValue((Value<Integer>)new c32369.c32370().m32381("health").m32384("The health smart totem activates").m32387(10).m32396(0).m32405(20).m32408());
        this.f33330 = "0";
        this.f33331 = MinecraftClient.getInstance();
        this.f33332 = false;
        this.f33333 = (Listener<c36575>)new Listener(this::m33342, new Predicate[0]);
    }
    
    @Override
    public String m35302() {
        return this.f33330;
    }
    
    private double m33334() {
        double n = 0.0;
        for (final Entity entity : this.f33331.world.getEntities()) {
            if (entity instanceof EnderCrystalEntity && n < c36537.m36539((LivingEntity)this.f33331.player, entity.getPos())) {
                n = c36537.m36539((LivingEntity)this.f33331.player, entity.getPos());
            }
            else {
                if (!(entity instanceof PlayerEntity) || n >= c36537.m36553((PlayerEntity)entity, true) || c39017.f39019.m39037((PlayerEntity)entity) || this.f33331.player.getPos().distanceTo(entity.getPos()) >= 5.0 || !(((PlayerEntity)entity).getActiveItem().getItem() instanceof SwordItem)) {
                    continue;
                }
                n = c36537.m36553((PlayerEntity)entity, true);
            }
        }
        if (!c34030.f34033.m34042(Nofall.class).m35315() && this.f33331.player.fallDistance > 3.0f) {
            final double n2 = this.f33331.player.fallDistance * 0.5;
            if (n2 > n) {
                n = n2;
            }
        }
        if (this.f33331.world.dimension.getType() != DimensionType.field_13072) {
            for (final BlockEntity blockEntity : this.f33331.world.blockEntities) {
                if (blockEntity instanceof BedBlockEntity && n < c36537.m36546((LivingEntity)this.f33331.player, new Vec3d((double)blockEntity.getPos().getX(), (double)blockEntity.getPos().getY(), (double)blockEntity.getPos().getZ()))) {
                    n = c36537.m36546((LivingEntity)this.f33331.player, new Vec3d((double)blockEntity.getPos().getX(), (double)blockEntity.getPos().getY(), (double)blockEntity.getPos().getZ()));
                }
            }
        }
        return n;
    }
    
    public boolean m33340() {
        return this.f33332;
    }
    
    private /* synthetic */ void m33342(final c36575 c36575) {
        if (this.f33331.currentScreen instanceof ContainerScreen && (!(this.f33331.currentScreen instanceof InventoryScreen) || !this.f33327.m33466())) {
            return;
        }
        final int f33329 = this.f33329;
        final c31671.c32663 m31679 = c31671.m31679(Items.field_8288);
        if (m31679.f32665 <= 0 && this.f33331.player.inventory.getCursorStack().getItem() != Items.field_8288 && this.f33331.player.getOffHandStack().getItem() != Items.field_8288 && this.f33326.m33466()) {
            if (!c34030.f34033.m34042(Offhandextra.class).m35315() && !c34030.f34033.m34042(Offhandextra.class).m31438()) {
                c34030.f34033.m34042(Offhandextra.class).m35300();
            }
            c34030.f34033.m34042(Offhandextra.class).m31435(true);
            return;
        }
        if (m31679.f32665 > 0 && c34030.f34033.m34042(Offhandextra.class).m35315()) {
            c34030.f34033.m34042(Offhandextra.class).m31435(false);
        }
        if (m31679.m32666() && this.f33331.player.getOffHandStack().getItem() != Items.field_8288 && !this.f33325.m33466()) {
            this.f33332 = true;
            if (this.f33331.player.inventory.getCursorStack().getItem() != Items.field_8288) {
                c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
            }
            c31671.m31675(45, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
        }
        else if (m31679.m32666() && this.f33331.player.getOffHandStack().getItem() != Items.field_8288 && this.f33325.m33466() && (this.f33331.player.getHealth() + this.f33331.player.getAbsorptionAmount() < this.f33328.m33466() || this.f33331.player.getHealth() + this.f33331.player.getAbsorptionAmount() - this.m33334() < this.f33328.m33466())) {
            this.f33332 = true;
            if (this.f33331.player.inventory.getCursorStack().getItem() != Items.field_8288) {
                c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
            }
            c31671.m31675(45, 0, SlotActionType.field_7790);
            c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
        }
        if (this.f33325.m33466() && this.f33331.player.getHealth() + this.f33331.player.getAbsorptionAmount() > this.f33328.m33466() && this.f33331.player.getHealth() + this.f33331.player.getAbsorptionAmount() - this.m33334() > this.f33328.m33466()) {
            this.f33332 = false;
        }
        if (m31679.f32665 != f33329) {
            this.f33330 = Integer.toString(m31679.f32665);
            this.f33329 = m31679.f32665;
        }
    }
    
    static {
        f33323 = new String[] { "auto-totem", "Automatically equips totems.", "smart", "Only switches to totem when in danger of dying", "fallback", "Enables offhand extra when you are out of totems.", "inventory", "Switches totems while you are in your inventory", "health", "The health smart totem activates", "0" };
    }
}
