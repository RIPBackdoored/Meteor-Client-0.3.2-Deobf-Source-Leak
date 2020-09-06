package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import net.minecraft.*;
import me.zero.alpine.listener.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.client.gui.screen.ingame.*;
import minegame159.meteorclient.*;
import net.minecraft.container.*;

public class Autodrop extends Module
{
    private static final String[] f39642;
    private final Settings f39643;
    private final Value<List<class_1792>> f39644;
    private final Value<Boolean> f39645;
    @EventHandler
    private Listener<c36575> f39646;
    
    public Autodrop() {
        super(Category.Player, "auto-drop", "Automatically drops selected items.");
        this.f39643 = this.f38675.m34572();
        this.f39644 = this.f39643.addValue((Value<List<class_1792>>)new c32527.c37373().m37380("items").m37383("Items to drop.").m37386(new ArrayList<class_1792>(0)).m37395());
        this.f39645 = this.f39643.addValue((Value<Boolean>)new c34427.c34657().m34664("exclude-hotbar").m34667("Doesn't drop items from hotbar.").m34670(false).m34679());
        this.f39646 = (Listener<c36575>)new Listener(this::m39647, new Predicate[0]);
    }
    
    private /* synthetic */ void m39647(final c36575 c36575) {
        if (this.mc.currentScreen instanceof ContainerScreen) {
            return;
        }
        for (int i = this.f39645.m33466() ? 9 : 0; i < this.mc.player.inventory.getInvSize(); ++i) {
            if (this.f39644.m33466().contains(this.mc.player.inventory.getInvStack(i).getItem())) {
                c31671.m31675(c31671.m31693(i), 1, SlotActionType.field_7795);
            }
        }
    }
    
    static {
        f39642 = new String[] { "auto-drop", "Automatically drops selected items.", "items", "Items to drop.", "exclude-hotbar", "Doesn't drop items from hotbar." };
    }
}
