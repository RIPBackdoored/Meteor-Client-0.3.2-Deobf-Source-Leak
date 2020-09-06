package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.container.*;
import net.minecraft.item.*;
import net.minecraft.*;
import net.minecraft.util.*;
import net.minecraft.util.hit.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.screen.ingame.*;
import minegame159.meteorclient.*;

public class Offhandextra extends Module
{
    private static final String[] f31420;
    private final Settings f31421;
    private final Value<c31419.Mode> f31422;
    private final Value<Boolean> f31423;
    private final Value<Boolean> f31424;
    private final Value<Integer> f31425;
    private final Value<Boolean> f31426;
    private boolean f31427;
    private boolean f31428;
    private boolean f31429;
    @EventHandler
    private final Listener<c36575> f31430;
    @EventHandler
    private final Listener<c33735> f31431;
    
    public Offhandextra() {
        super(Category.Combat, "offhand-extra", "Allows you to use items in your offhand. Requires AutoTotem to be on smart mode.");
        this.f31421 = this.f38675.m34572();
        this.f31422 = this.f31421.addValue((Value<c31419.Mode>)new c36601.c36919<Enum>().m36926("Mode").m36929("Changes which item goes in your offhand").m36932((Enum)c31419.Mode.Enchanted_Golden_Apple).m36941());
        this.f31423 = this.f31421.addValue((Value<Boolean>)new c34427.c34657().m34664("replace").m34667("Replace your offhand or wait for it to be empty").m34670(true).m34679());
        this.f31424 = this.f31421.addValue((Value<Boolean>)new c34427.c34657().m34664("Asimov").m34667("Always holds the item in your offhand").m34670(false).m34679());
        this.f31425 = this.f31421.addValue((Value<Integer>)new c32369.c32370().m32381("health").m32384("The health this stops working.").m32387(10).m32396(0).m32405(20).m32408());
        this.f31426 = this.f31421.addValue((Value<Boolean>)new c34427.c34657().m34664("self-toggle").m34667("Toggles when you run out of the item you chose").m34670(true).m34679());
        this.f31427 = false;
        this.f31428 = false;
        this.f31429 = false;
        this.f31430 = (Listener<c36575>)new Listener(this::m31450, new Predicate[0]);
        this.f31431 = (Listener<c33735>)new Listener(this::m31444, new Predicate[0]);
    }
    
    @Override
    public void m35294() {
        if (c34030.f34033.m34042(Autototem.class).m35315()) {
            final c31671.c32663 m31679 = c31671.m31679(Items.field_8288);
            final boolean empty = this.mc.player.getOffHandStack().isEmpty();
            if (m31679.f32664 != -1) {
                c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
                c31671.m31675(45, 0, SlotActionType.field_7790);
                if (!empty) {
                    c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
                }
            }
        }
    }
    
    private Item m31432() {
        Item item = Items.field_8288;
        if (this.f31422.m33466() == c31419.Mode.Enchanted_Golden_Apple) {
            item = Items.field_8367;
        }
        else if (this.f31422.m33466() == c31419.Mode.Golden_Apple) {
            item = Items.field_8463;
        }
        else if (this.f31422.m33466() == c31419.Mode.End_Crystal) {
            item = Items.field_8301;
        }
        else if (this.f31422.m33466() == c31419.Mode.Exp_Bottle) {
            item = Items.field_8287;
        }
        return item;
    }
    
    public void m31435(final boolean f31429) {
        this.f31429 = f31429;
    }
    
    public boolean m31438() {
        return this.f31428;
    }
    
    private boolean m31440() {
        if (this.mc.crosshairTarget.getType().equals((Object)class_239.class_240.field_1333)) {
            return true;
        }
        if (this.mc.crosshairTarget.getType().equals((Object)class_239.class_240.field_1331)) {
            return this.mc.player.interact(((EntityHitResult)this.mc.crosshairTarget).getEntity(), Hand.field_5808) == ActionResult.field_5811;
        }
        if (this.mc.crosshairTarget.getType().equals((Object)class_239.class_240.field_1332)) {
            final BlockHitResult blockHitResult = (BlockHitResult)this.mc.crosshairTarget;
            return !this.mc.world.getBlockState(blockHitResult.getBlockPos()).activate((World)this.mc.world, (PlayerEntity)this.mc.player, Hand.field_5808, blockHitResult);
        }
        return false;
    }
    
    private /* synthetic */ void m31444(final c33735 c33735) {
        if (c34030.f34033.m34042(Autototem.class).m33340() || !this.m31440()) {
            return;
        }
        if (this.mc.player.getOffHandStack().getItem() != Items.field_8288 || (this.mc.player.getHealth() + this.mc.player.getAbsorptionAmount() > this.f31425.m33466() && this.mc.player.getOffHandStack().getItem() != this.m31432() && !(this.mc.currentScreen instanceof ContainerScreen))) {
            this.f31427 = true;
            final Item m31432 = this.m31432();
            final c31671.c32663 m31433 = c31671.m31679(m31432);
            if (m31433.f32664 == -1 && this.mc.player.getOffHandStack().getItem() != this.m31432()) {
                if (!this.f31428) {
                    c31351.m31360(this, "None of the chosen item found.", new Object[0]);
                    this.f31428 = true;
                }
                if (this.f31426.m33466()) {
                    this.m35300();
                }
                return;
            }
            final boolean empty = this.mc.player.getOffHandStack().isEmpty();
            if (this.mc.player.getOffHandStack().getItem() != m31432 && this.f31423.m33466()) {
                c31671.m31675(c31671.m31693(m31433.f32664), 0, SlotActionType.field_7790);
                c31671.m31675(45, 0, SlotActionType.field_7790);
                if (!empty) {
                    c31671.m31675(c31671.m31693(m31433.f32664), 0, SlotActionType.field_7790);
                }
                this.f31428 = false;
            }
        }
    }
    
    private /* synthetic */ void m31450(final c36575 c36575) {
        if (!this.mc.player.isUsingItem()) {
            this.f31427 = false;
        }
        if (c34030.f34033.m34042(Autototem.class).m33340()) {
            return;
        }
        if ((this.f31424.m33466() || this.f31429) && !(this.mc.currentScreen instanceof ContainerScreen)) {
            final Item m31432 = this.m31432();
            final c31671.c32663 m31433 = c31671.m31679(m31432);
            if (m31433.f32664 == -1 && this.mc.player.getOffHandStack().getItem() != this.m31432()) {
                if (!this.f31428) {
                    c31351.m31360(this, "None of the chosen item found.", new Object[0]);
                    this.f31428 = true;
                }
                if (this.f31426.m33466()) {
                    this.m35300();
                }
                return;
            }
            final boolean empty = this.mc.player.getOffHandStack().isEmpty();
            if (this.mc.player.getOffHandStack().getItem() != m31432 && this.f31423.m33466()) {
                c31671.m31675(c31671.m31693(m31433.f32664), 0, SlotActionType.field_7790);
                c31671.m31675(45, 0, SlotActionType.field_7790);
                if (!empty) {
                    c31671.m31675(c31671.m31693(m31433.f32664), 0, SlotActionType.field_7790);
                }
                this.f31428 = false;
            }
        }
        else if (!this.f31424.m33466() && !this.f31427 && this.mc.player.getOffHandStack().getItem() != Items.field_8288) {
            final c31671.c32663 m31434 = c31671.m31679(Items.field_8288);
            final boolean empty2 = this.mc.player.getOffHandStack().isEmpty();
            if (m31434.f32664 != -1) {
                c31671.m31675(c31671.m31693(m31434.f32664), 0, SlotActionType.field_7790);
                c31671.m31675(45, 0, SlotActionType.field_7790);
                if (!empty2) {
                    c31671.m31675(c31671.m31693(m31434.f32664), 0, SlotActionType.field_7790);
                }
            }
        }
    }
    
    static {
        f31420 = new String[] { "offhand-extra", "Allows you to use items in your offhand. Requires AutoTotem to be on smart mode.", "Mode", "Changes which item goes in your offhand", "replace", "Replace your offhand or wait for it to be empty", "Asimov", "Always holds the item in your offhand", "health", "The health this stops working.", "self-toggle", "Toggles when you run out of the item you chose", "None of the chosen item found.", "None of the chosen item found." };
    }
}
