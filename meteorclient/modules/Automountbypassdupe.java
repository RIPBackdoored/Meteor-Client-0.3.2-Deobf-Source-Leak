package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import org.lwjgl.glfw.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.*;
import net.minecraft.container.*;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import java.util.*;
import minegame159.meteorclient.*;

public class Automountbypassdupe extends Module
{
    private static final String[] f35476;
    private final Settings f35477;
    private final Value<Boolean> f35478;
    private final Value<Boolean> f35479;
    private final Value<Integer> f35480;
    private final List<Integer> f35481;
    private final List<Integer> f35482;
    private boolean f35483;
    private AbstractDonkeyEntity f35484;
    private boolean f35485;
    private int f35486;
    @EventHandler
    private final Listener<c32410> f35487;
    @EventHandler
    private final Listener<c36575> f35488;
    
    public Automountbypassdupe() {
        super(Category.Misc, "auto-mount-bypass-dupe", "Does the mount bypass dupe for you. Disable with esc.");
        this.f35477 = this.f38675.m34572();
        this.f35478 = this.f35477.addValue((Value<Boolean>)new c34427.c34657().m34664("shulker-only").m34667("Only moves shulker boxes into the inventory").m34670(true).m34679());
        this.f35479 = this.f35477.addValue((Value<Boolean>)new c34427.c34657().m34664("face-down").m34667("Faces down when dropping items.").m34670(true).m34679());
        this.f35480 = this.f35477.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("Time in ticks between actions. 20 ticks = 1 second.").m32387(4).m32396(0).m32408());
        this.f35481 = new ArrayList<Integer>();
        this.f35482 = new ArrayList<Integer>();
        this.f35483 = false;
        this.f35485 = false;
        this.f35487 = (Listener<c32410>)new Listener(this::m35510, new Predicate[0]);
        this.f35488 = (Listener<c36575>)new Listener(this::m35498, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f35486 = 0;
    }
    
    private int m35490(final Entity entity) {
        if (!(entity instanceof AbstractDonkeyEntity)) {
            return -1;
        }
        if (!((AbstractDonkeyEntity)entity).hasChest()) {
            return 0;
        }
        if (entity instanceof LlamaEntity) {
            return 3 * ((LlamaEntity)entity).getStrength();
        }
        return 15;
    }
    
    private boolean m35493() {
        if (this.mc.player.getVehicle() != this.f35484 || this.f35484.hasChest() || this.mc.player.container.getStacks().size() == 46) {
            return false;
        }
        if (this.mc.player.container.getStacks().size() > 38) {
            for (int i = 2; i < this.m35496() + 1; ++i) {
                if (this.mc.player.container.getSlot(i).hasStack()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int m35496() {
        if (this.mc.player.getVehicle() != this.f35484 || this.f35484.hasChest() || this.mc.player.container.getStacks().size() == 46) {
            return 0;
        }
        return this.mc.player.container.getStacks().size() - 38;
    }
    
    private /* synthetic */ void m35498(final c36575 c36575) {
        if (GLFW.glfwGetKey(this.mc.window.getHandle(), 256) == 1) {
            this.m35300();
            this.mc.player.closeContainer();
            return;
        }
        if (this.f35486 > 0) {
            --this.f35486;
            return;
        }
        this.f35486 = this.f35480.m33466();
        final int m35490 = this.m35490(this.mc.player.getVehicle());
        for (final Entity entity : this.mc.world.getEntities()) {
            if (entity.distanceTo((Entity)this.mc.player) < 5.0f && entity instanceof AbstractDonkeyEntity && ((AbstractDonkeyEntity)entity).isTame()) {
                this.f35484 = (AbstractDonkeyEntity)entity;
            }
        }
        if (this.f35484 == null) {
            return;
        }
        if (this.f35485) {
            this.mc.player.networkHandler.sendPacket((Packet)new ClientCommandC2SPacket((Entity)this.mc.player, class_2848.class_2849.field_12984));
            this.mc.player.setSneaking(false);
            this.f35485 = false;
            return;
        }
        if (m35490 == -1) {
            if (this.f35484.hasChest() || this.mc.player.getMainHandStack().getItem() == Items.CHEST) {
                this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket((Entity)this.f35484, Hand.field_5808));
            }
            else {
                final int f32664 = c31671.m31679(Items.CHEST).f32664;
                if (f32664 != -1 && f32664 < 9) {
                    this.mc.player.inventory.selectedSlot = f32664;
                }
                else {
                    c31351.m31360(this, "Cannot find chest in your hotbar. Disabling!", new Object[0]);
                    this.m35300();
                }
            }
        }
        else if (m35490 == 0) {
            if (this.m35493()) {
                if (!this.f35482.isEmpty()) {
                    if (this.f35479.m33466()) {
                        this.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(this.mc.player.yaw, 90.0f, this.mc.player.onGround));
                    }
                    final Iterator<Integer> iterator2 = this.f35482.iterator();
                    while (iterator2.hasNext()) {
                        c31671.m31675(iterator2.next(), 1, SlotActionType.field_7795);
                    }
                    this.f35482.clear();
                }
                else {
                    for (int i = 2; i < this.m35496() + 1; ++i) {
                        this.f35482.add(i);
                    }
                }
            }
            else {
                this.mc.player.closeContainer();
                this.mc.player.networkHandler.sendPacket((Packet)new ClientCommandC2SPacket((Entity)this.mc.player, class_2848.class_2849.field_12979));
                this.mc.player.setSneaking(true);
                this.f35485 = true;
            }
        }
        else if (!(this.mc.currentScreen instanceof HorseScreen)) {
            this.mc.player.openRidingInventory();
        }
        else if (m35490 > 0) {
            if (this.f35481.isEmpty()) {
                boolean b = true;
                for (int j = 2; j <= m35490; ++j) {
                    if (!((ItemStack)this.mc.player.container.getStacks().get(j)).isEmpty()) {
                        b = false;
                        break;
                    }
                }
                if (!b) {
                    this.f35483 = true;
                    this.mc.player.networkHandler.sendPacket((Packet)new PlayerInteractEntityC2SPacket((Entity)this.f35484, Hand.field_5808, this.f35484.getPos().add((double)(this.f35484.getWidth() / 2.0f), (double)(this.f35484.getHeight() / 2.0f), (double)(this.f35484.getWidth() / 2.0f))));
                    this.f35483 = false;
                    return;
                }
                for (int k = m35490 + 2; k < this.mc.player.container.getStacks().size(); ++k) {
                    if (!((ItemStack)this.mc.player.container.getStacks().get(k)).isEmpty()) {
                        if (this.mc.player.container.getSlot(k).getStack().getItem() != Items.CHEST) {
                            if ((this.mc.player.container.getSlot(k).getStack().getItem() instanceof BlockItem && ((BlockItem)this.mc.player.container.getSlot(k).getStack().getItem()).getBlock() instanceof ShulkerBoxBlock) || !this.f35478.m33466()) {
                                this.f35481.add(k);
                                if (this.f35481.size() >= m35490) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (!this.f35481.isEmpty()) {
                final Iterator<Integer> iterator3 = this.f35481.iterator();
                while (iterator3.hasNext()) {
                    c31671.m31675(iterator3.next(), 0, SlotActionType.field_7794);
                }
                this.f35481.clear();
            }
        }
    }
    
    private /* synthetic */ void m35510(final c32410 c32410) {
        if (this.f35483) {
            return;
        }
        c34030.f34033.m34042(Mountbypass.class).m35000(c32410);
    }
    
    static {
        f35476 = new String[] { "auto-mount-bypass-dupe", "Does the mount bypass dupe for you. Disable with esc.", "shulker-only", "Only moves shulker boxes into the inventory", "face-down", "Faces down when dropping items.", "delay", "Time in ticks between actions. 20 ticks = 1 second.", "Cannot find chest in your hotbar. Disabling!" };
    }
}
