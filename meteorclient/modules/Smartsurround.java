package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.hit.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraft.*;
import net.minecraft.entity.*;
import minegame159.meteorclient.*;
import net.minecraft.item.*;

public class Smartsurround extends Module
{
    private static final String[] f35859;
    private final Settings f35860;
    private final Value<Boolean> f35861;
    private final Value<Double> f35862;
    private int f35863;
    private int f35864;
    private int f35865;
    private int f35866;
    private Entity f35867;
    @EventHandler
    private final Listener<c34242> f35868;
    @EventHandler
    private final Listener<c36575> f35869;
    
    public Smartsurround() {
        super(Category.Combat, "smart-surround", "Tries to save you from crystals automatically.");
        this.f35860 = this.f38675.m34572();
        this.f35861 = this.f35860.addValue((Value<Boolean>)new c34427.c34657().m34664("only-obsidian").m34667("Only uses Obsidian").m34670(false).m34679());
        this.f35862 = this.f35860.addValue((Value<Double>)new c37033.c38947().m38959("min-damage").m38962("The minimum damage before this activates.").m38965(5.5).m38988());
        this.f35864 = -1;
        this.f35868 = (Listener<c34242>)new Listener(this::m35884, new Predicate[0]);
        this.f35869 = (Listener<c36575>)new Listener(this::m35881, new Predicate[0]);
    }
    
    private void m35870(final int n, final int n2, final Entity entity) {
        this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractBlockC2SPacket(Hand.field_5808, new BlockHitResult(this.mc.player.getPos(), Direction.field_11036, entity.getBlockPos().add(n, -1, n2), false)));
        this.mc.player.swingHand(Hand.field_5808);
    }
    
    private int m35876() {
        this.f35863 = this.mc.player.inventory.selectedSlot;
        int selectedSlot = -1;
        for (int i = 0; i < 9; ++i) {
            if (this.mc.player.inventory.getInvStack(i).getItem() == Items.OBSIDIAN) {
                selectedSlot = i;
                this.mc.player.inventory.selectedSlot = selectedSlot;
                break;
            }
        }
        return selectedSlot;
    }
    
    private /* synthetic */ void m35881(final c36575 c36575) {
        if (this.f35864 != -1) {
            if (this.f35865 >= 2 && this.f35866 == 0) {
                this.m35870(this.f35865 - 1, 0, this.f35867);
            }
            else if (this.f35865 > 1 && this.f35866 > 1) {
                this.m35870(this.f35865, this.f35866 - 1, this.f35867);
                this.m35870(this.f35865 - 1, this.f35866, this.f35867);
            }
            else if (this.f35865 == 0 && this.f35866 >= 2) {
                this.m35870(0, this.f35866 - 1, this.f35867);
            }
            else if (this.f35865 < -1 && this.f35866 < -1) {
                this.m35870(this.f35865, this.f35866 + 1, this.f35867);
                this.m35870(this.f35865 + 1, this.f35866, this.f35867);
            }
            else if (this.f35865 == 0 && this.f35866 <= -2) {
                this.m35870(0, this.f35866 + 1, this.f35867);
            }
            else if (this.f35865 > 1 && this.f35866 < -1) {
                this.m35870(this.f35865, this.f35866 + 1, this.f35867);
                this.m35870(this.f35865 - 1, this.f35866, this.f35867);
            }
            else if (this.f35865 <= -2 && this.f35866 == 0) {
                this.m35870(this.f35865 + 1, 0, this.f35867);
            }
            else if (this.f35865 < -1 && this.f35866 > 1) {
                this.m35870(this.f35865, this.f35866 - 1, this.f35867);
                this.m35870(this.f35865 + 1, this.f35866, this.f35867);
            }
            if (this.mc.world.rayTrace(new RayTraceContext(this.mc.player.getPos(), this.f35867.getPos(), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (Entity)this.mc.player)).getType() != class_239.class_240.field_1333) {
                this.f35864 = -1;
                this.mc.player.inventory.selectedSlot = this.f35863;
            }
        }
    }
    
    private /* synthetic */ void m35884(final c34242 c34242) {
        this.f35867 = c34242.f34243;
        if (c34242.f34243.getType() == EntityType.field_6110 && c36537.m36539((LivingEntity)this.mc.player, c34242.f34243.getPos()) > this.f35862.m33466()) {
            this.f35864 = this.m35876();
            if (this.f35864 == -1 && this.f35861.m33466()) {
                c31351.m31360(this, "No Obsidian in hotbar. Disabling!", new Object[0]);
                return;
            }
            for (int i = 0; i < 9; ++i) {
                if (this.mc.player.inventory.getInvStack(i).getItem() instanceof BlockItem) {
                    this.f35864 = i;
                    this.mc.player.inventory.selectedSlot = this.f35864;
                    break;
                }
            }
            if (this.f35864 == -1) {
                c31351.m31360(this, "No blocks in hotbar. Disabling!", new Object[0]);
                return;
            }
            this.f35865 = this.mc.player.getBlockPos().getX() - c34242.f34243.getBlockPos().getX();
            this.f35866 = this.mc.player.getBlockPos().getZ() - c34242.f34243.getBlockPos().getZ();
        }
    }
    
    static {
        f35859 = new String[] { "smart-surround", "Tries to save you from crystals automatically.", "only-obsidian", "Only uses Obsidian", "min-damage", "The minimum damage before this activates.", "No Obsidian in hotbar. Disabling!", "No blocks in hotbar. Disabling!" };
    }
}
