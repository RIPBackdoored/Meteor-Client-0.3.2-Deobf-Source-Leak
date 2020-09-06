package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.item.*;
import minegame159.meteorclient.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.hit.*;
import meteorclient.util.*;
import net.minecraft.util.math.*;

public class EChestfarmer extends Module
{
    private static final String[] f40015;
    private final Settings f40016;
    private final Value<Integer> f40017;
    private final Value<Integer> f40018;
    private final Value<Boolean> f40019;
    private boolean f40020;
    private int f40021;
    @EventHandler
    private final Listener<c36575> f40022;
    
    public EChestfarmer() {
        super(Category.Misc, "EChest-farmer", "Places and mines EChests where you are looking.");
        this.f40016 = this.f38675.m34572();
        this.f40017 = this.f40016.addValue((Value<Integer>)new c32369.c32370().m32381("target-amount").m32384("The amount of obsidian to farm.").m32387(64).m32396(8).m32405(64).m32399(512).m32408());
        this.f40018 = this.f40016.addValue((Value<Integer>)new c32369.c32370().m32381("lower-amount").m32384("The amount before this turns on again.").m32387(8).m32396(0).m32399(64).m32405(32).m32408());
        this.f40019 = this.f40016.addValue((Value<Boolean>)new c34427.c34657().m34664("disable-on-completion").m34667("Whether to disable once you reach target stacks").m34670(true).m34679());
        this.f40020 = false;
        this.f40021 = Math.floorDiv(this.f40017.m33466(), 8);
        this.f40022 = (Listener<c36575>)new Listener(this::m40023, new Predicate[0]);
    }
    
    private /* synthetic */ void m40023(final c36575 c36575) {
        if (this.f40018.m33466() < c31671.m31679(Items.OBSIDIAN).f32665) {
            this.f40020 = false;
        }
        if (this.f40020 && !this.f40019.m33466()) {
            this.f40020 = false;
            this.f40021 = Math.floorDiv(this.f40017.m33466(), 8);
            return;
        }
        if (this.f40020 && this.f40019.m33466()) {
            this.m35300();
            return;
        }
        final c31671.c32663 m31679 = c31671.m31679(Items.ENDER_CHEST);
        int selectedSlot = -1;
        if (m31679.f32665 != 0 && m31679.f32664 < 9 && m31679.f32664 != -1) {
            for (int i = 0; i < 9; ++i) {
                if (c34030.f34033.m34042(Autotool.class).m32687(this.mc.player.inventory.getInvStack(i).getItem(), Blocks.field_10443) && EnchantmentHelper.getLevel(Enchantments.field_9099, this.mc.player.inventory.getInvStack(i)) == 0) {
                    selectedSlot = i;
                }
            }
            if (selectedSlot != -1 && m31679.f32664 != -1 && m31679.f32664 < 9) {
                final BlockPos blockPos = ((BlockHitResult)this.mc.crosshairTarget).getBlockPos();
                if (this.mc.world.getBlockState(blockPos).getBlock() == Blocks.field_10443) {
                    if (this.mc.player.inventory.selectedSlot != selectedSlot) {
                        this.mc.player.inventory.selectedSlot = selectedSlot;
                    }
                    this.mc.interactionManager.method_2902(blockPos, Direction.field_11036);
                    --this.f40021;
                    if (this.f40021 == 0) {
                        this.f40020 = true;
                    }
                }
                else if (this.mc.world.getBlockState(blockPos.up()).getBlock() == Blocks.field_10124) {
                    if (this.mc.player.inventory.selectedSlot != m31679.f32664) {
                        this.mc.player.inventory.selectedSlot = m31679.f32664;
                    }
                    EnchantUtil.m35595(Blocks.field_10443.getDefaultState(), blockPos.up());
                }
            }
        }
    }
    
    static {
        f40015 = new String[] { "EChest-farmer", "Places and mines EChests where you are looking.", "target-amount", "The amount of obsidian to farm.", "lower-amount", "The amount before this turns on again.", "disable-on-completion", "Whether to disable once you reach target stacks" };
    }
}
