package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.block.*;
import minegame159.meteorclient.*;
import net.minecraft.container.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class Autotool extends Module
{
    private static final String[] f32679;
    private final Settings f32680;
    private final Value<c32678.Prefer> f32681;
    private final Value<Boolean> f32682;
    private final Value<Boolean> f32683;
    private final Value<Boolean> f32684;
    private final Value<c32678.materialPreference> f32685;
    @EventHandler
    private final Listener<c32772> f32686;
    
    public Autotool() {
        super(Category.Player, "auto-tool", "Automatically switches to the most effective tool when breaking blocks.");
        this.f32680 = this.f38675.m34572();
        this.f32681 = this.f32680.addValue((Value<c32678.Prefer>)new c36601.c36919<Enum>().m36926("prefer").m36929("Prefer silk touch, fortune or none.").m36932((Enum)c32678.Prefer.Fortune).m36941());
        this.f32682 = this.f32680.addValue((Value<Boolean>)new c34427.c34657().m34664("prefer-mending").m34667("Prefers mending.").m34670(true).m34679());
        this.f32683 = this.f32680.addValue((Value<Boolean>)new c34427.c34657().m34664("ender-chest-only-with-silk-touch").m34667("Mine ender chest only with silk touch.").m34670(true).m34679());
        this.f32684 = this.f32680.addValue((Value<Boolean>)new c34427.c34657().m34664("anti-break").m34667("Stops you from breaking your weapon.").m34670(false).m34679());
        this.f32685 = this.f32680.addValue((Value<c32678.materialPreference>)new c36601.c36919<Enum>().m36926("material-preference").m36929("How the AntiBreak decides what to replace your tool with").m36932((Enum)c32678.materialPreference.Best).m36941());
        this.f32686 = (Listener<c32772>)new Listener(this::m32692, 100, new Predicate[0]);
    }
    
    public boolean m32687(final Item item, final Block block) {
        final Material material = block.getMaterial((BlockState)null);
        return (item instanceof SwordItem && material == Material.COBWEB) || (item instanceof AxeItem && (block == Blocks.field_16492 || material == Material.WOOD || material == Material.BAMBOO || material == Material.BAMBOO_SAPLING || material == Material.PLANT || material == Material.PUMPKIN)) || (item instanceof PickaxeItem && (material == Material.SHULKER_BOX || material == Material.ANVIL || material == Material.CLAY || material == Material.ICE || material == Material.PACKED_ICE || material == Material.METAL || material == Material.PISTON || material == Material.STONE || material == Material.PART)) || (item instanceof ShovelItem && (block == Blocks.field_10219 || block == Blocks.field_10402 || material == Material.EARTH || material == Material.SNOW || material == Material.SNOW_BLOCK || material == Material.SAND)) || (item instanceof ShearsItem && (material == Material.WOOL || material == Material.CARPET)) || (item instanceof HoeItem && material == Material.ORGANIC);
    }
    
    private /* synthetic */ void m32692(final c32772 c32772) {
        final BlockState blockState = this.mc.world.getBlockState(c32772.f32773);
        if (this.mc.player.getMainHandStack().getItem() instanceof ToolItem && this.f32684.m33466() && this.mc.player.getMainHandStack().getItem().getMaxDamage() - this.mc.player.getMainHandStack().getDamage() <= 11) {
            int n = -1;
            int round = 0;
            for (int i = 9; i < 36; ++i) {
                if (this.f32685.m33466() == c32678.materialPreference.None && this.mc.player.inventory.getInvStack(i).getItem().getClass() == this.mc.player.getMainHandStack().getItem().getClass() && this.mc.player.inventory.getInvStack(i).getMaxDamage() - this.mc.player.inventory.getInvStack(i).getDamage() > 11) {
                    n = i;
                    break;
                }
                if (this.f32685.m33466() == c32678.materialPreference.Same && this.mc.player.inventory.getInvStack(i).getItem() == this.mc.player.getMainHandStack().getItem()) {
                    n = i;
                    break;
                }
                if (this.f32685.m33466() == c32678.materialPreference.Best && this.mc.player.inventory.getInvStack(i).getItem().getClass() == this.mc.player.getMainHandStack().getItem().getClass() && this.mc.player.inventory.getInvStack(i).getMaxDamage() - this.mc.player.inventory.getInvStack(i).getDamage() > 11 && round < Math.round(this.mc.player.inventory.getInvStack(i).getMiningSpeed(blockState))) {
                    round = Math.round(this.mc.player.inventory.getInvStack(i).getMiningSpeed(blockState));
                    n = i;
                }
            }
            if (n == -1 && this.f32685.m33466() != c32678.materialPreference.None) {
                for (int j = 9; j < 36; ++j) {
                    if (this.mc.player.inventory.getInvStack(j).getItem().getClass() == this.mc.player.getMainHandStack().getItem().getClass() && this.mc.player.inventory.getInvStack(j).getMaxDamage() - this.mc.player.inventory.getInvStack(j).getDamage() > 11) {
                        n = j;
                        break;
                    }
                }
            }
            if (n != -1) {
                c31671.m31675(c31671.m31693(this.mc.player.inventory.selectedSlot), 0, SlotActionType.field_7790);
                c31671.m31675(c31671.m31693(n), 0, SlotActionType.field_7790);
                c31671.m31675(c31671.m31693(this.mc.player.inventory.selectedSlot), 0, SlotActionType.field_7790);
            }
            else if (this.mc.player.inventory.getEmptySlot() != -1) {
                c31671.m31675(c31671.m31693(this.mc.player.inventory.selectedSlot), 0, SlotActionType.field_7790);
                c31671.m31675(c31671.m31693(this.mc.player.inventory.getEmptySlot()), 0, SlotActionType.field_7790);
            }
        }
        int n2 = -1;
        int selectedSlot = -1;
        for (int k = 0; k < 9; ++k) {
            final ItemStack invStack = this.mc.player.inventory.getInvStack(k);
            if (this.m32687(invStack.getItem(), blockState.getBlock())) {
                final int n3 = 0;
                if (!this.f32683.m33466() || blockState.getBlock() != Blocks.field_10443 || EnchantmentHelper.getLevel(Enchantments.field_9099, invStack) != 0) {
                    int n4 = n3 + Math.round(invStack.getMiningSpeed(blockState)) + EnchantmentHelper.getLevel(Enchantments.field_9119, invStack) + EnchantmentHelper.getLevel(Enchantments.field_9131, invStack);
                    if (this.f32682.m33466()) {
                        n4 += EnchantmentHelper.getLevel(Enchantments.field_9101, invStack);
                    }
                    if (this.f32681.m33466() == c32678.Prefer.Fortune) {
                        n4 += EnchantmentHelper.getLevel(Enchantments.field_9130, invStack);
                    }
                    if (this.f32681.m33466() == c32678.Prefer.SilkTouch) {
                        n4 += EnchantmentHelper.getLevel(Enchantments.field_9099, invStack);
                    }
                    if (n4 > n2) {
                        n2 = n4;
                        selectedSlot = k;
                    }
                }
            }
        }
        if (selectedSlot != -1) {
            this.mc.player.inventory.selectedSlot = selectedSlot;
        }
    }
    
    static {
        f32679 = new String[] { "auto-tool", "Automatically switches to the most effective tool when breaking blocks.", "prefer", "Prefer silk touch, fortune or none.", "prefer-mending", "Prefers mending.", "ender-chest-only-with-silk-touch", "Mine ender chest only with silk touch.", "anti-break", "Stops you from breaking your weapon.", "material-preference", "How the AntiBreak decides what to replace your tool with" };
    }
}
