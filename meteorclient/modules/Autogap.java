package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import minegame159.meteorclient.*;
import net.minecraft.item.*;
import net.minecraft.entity.effect.*;

public class Autogap extends Module
{
    private static final String[] f32227;
    private final Settings f32228;
    private final Value<c32226.Mode> f32229;
    private final Value<Boolean> f32230;
    private final Value<Boolean> f32231;
    private final Value<Boolean> f32232;
    private int f32233;
    private boolean f32234;
    private boolean f32235;
    private boolean f32236;
    private boolean f32237;
    @EventHandler
    private final Listener<c36575> f32238;
    
    public Autogap() {
        super(Category.Player, "auto-gap", "Automatically eats gapples and egaps if their effects run out.");
        this.f32228 = this.f38675.m34572();
        this.f32229 = this.f32228.addValue((Value<c32226.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("Determines when you eat the gapple.").m36932((Enum)c32226.Mode.Regeneration).m36941());
        this.f32230 = this.f32228.addValue((Value<Boolean>)new c34427.c34657().m34664("prefer-egap").m34667("Prefers to eat egapps over regular gapples").m34670(false).m34679());
        this.f32231 = this.f32228.addValue((Value<Boolean>)new c34427.c34657().m34664("prefer-auto-eat").m34667("Whether to use auto-eat or this in the event of a conflict").m34670(true).m34679());
        this.f32232 = this.f32228.addValue((Value<Boolean>)new c34427.c34657().m34664("disable-auras").m34667("disable all auras").m34670(false).m34679());
        this.f32234 = false;
        this.f32235 = false;
        this.f32236 = false;
        this.f32237 = false;
        this.f32238 = (Listener<c36575>)new Listener(this::m32241, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        if (this.f32236) {
            ((c39520)this.mc.options.keyUse).m39521(false);
            this.f32236 = false;
        }
    }
    
    public boolean m32239() {
        return !this.m35315() || !this.f32236;
    }
    
    private /* synthetic */ void m32241(final c36575 c36575) {
        if (this.mc.options.keyUse.isPressed() && !this.f32236 && c34030.f34033.m34042(Autoeat.class).m35315() && this.f32231.m33466()) {
            return;
        }
        if (this.mc.options.keyUse.isPressed() && this.f32236 && c34030.f34033.m34042(Autoeat.class).m35315() && !this.f32231.m33466()) {
            c34030.f34033.m34042(Autoeat.class).m35300();
            this.f32237 = true;
        }
        if (this.f32229.m33466() == c32226.Mode.Constant && (this.mc.player.getMainHandStack().getItem() == Items.field_8463 || this.mc.player.getMainHandStack().getItem() == Items.field_8367)) {
            this.f32236 = true;
            ((c39520)this.mc.options.keyUse).m39521(true);
            return;
        }
        if (this.f32229.m33466() == c32226.Mode.Constant && this.mc.player.getMainHandStack().getItem() != Items.field_8463 && this.mc.player.getMainHandStack().getItem() != Items.field_8367) {
            this.f32236 = false;
            ((c39520)this.mc.options.keyUse).m39521(false);
            return;
        }
        if (this.mc.player.getActiveStatusEffects().containsKey(StatusEffects.field_5898) && this.mc.player.getActiveStatusEffects().containsKey(StatusEffects.field_5924)) {
            if (this.mc.options.keyUse.isPressed()) {
                ((c39520)this.mc.options.keyUse).m39521(false);
                this.f32236 = false;
                if (this.f32237) {
                    c34030.f34033.m34042(Autoeat.class).m35300();
                    this.f32237 = false;
                }
                if (this.f32234) {
                    c34030.f34033.m34042(Killaura.class).m35300();
                    this.f32234 = false;
                }
                if (this.f32235) {
                    c34030.f34033.m34042(Crystalaura.class).m35300();
                    this.f32235 = false;
                }
                this.mc.player.inventory.selectedSlot = this.f32233;
            }
        }
        else {
            if (this.f32229.m33466() == c32226.Mode.Fire_Resistance && this.mc.player.getActiveStatusEffects().containsKey(StatusEffects.field_5918)) {
                return;
            }
            int n = -1;
            int n2 = -1;
            for (int i = 0; i < 9; ++i) {
                if (this.mc.player.inventory.getInvStack(i).getItem() == Items.field_8463 && n == -1) {
                    n = i;
                }
                else if (this.mc.player.inventory.getInvStack(i).getItem() == Items.field_8367 && n2 == -1) {
                    n2 = i;
                }
            }
            if (this.f32236) {
                if ((this.f32229.m33466() == c32226.Mode.Fire_Resistance || this.f32230.m33466()) && n2 != -1) {
                    this.mc.player.inventory.selectedSlot = n2;
                }
                else if (n != -1) {
                    this.mc.player.inventory.selectedSlot = n;
                }
                else if (n2 != -1) {
                    this.mc.player.inventory.selectedSlot = n2;
                }
                ((c39520)this.mc.options.keyUse).m39521(true);
            }
            else {
                if ((this.f32229.m33466() == c32226.Mode.Fire_Resistance || this.f32230.m33466()) && n2 != -1) {
                    this.f32233 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = n2;
                }
                else if (n != -1) {
                    this.f32233 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = n;
                }
                else if (n2 != -1) {
                    this.f32233 = this.mc.player.inventory.selectedSlot;
                    this.mc.player.inventory.selectedSlot = n2;
                }
                if (this.f32232.m33466()) {
                    if (c34030.f34033.m34042(Killaura.class).m35315()) {
                        this.f32234 = true;
                        c34030.f34033.m34042(Killaura.class).m35300();
                    }
                    if (c34030.f34033.m34042(Crystalaura.class).m35315()) {
                        this.f32235 = true;
                    }
                }
                ((c39520)this.mc.options.keyUse).m39521(true);
                this.f32236 = true;
            }
        }
    }
    
    static {
        f32227 = new String[] { "auto-gap", "Automatically eats gapples and egaps if their effects run out.", "mode", "Determines when you eat the gapple.", "prefer-egap", "Prefers to eat egapps over regular gapples", "prefer-auto-eat", "Whether to use auto-eat or this in the event of a conflict", "disable-auras", "disable all auras" };
    }
}
