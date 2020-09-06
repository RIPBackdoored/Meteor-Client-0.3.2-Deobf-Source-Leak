package meteorclient.util;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.registry.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.enchantment.*;
import org.apache.commons.lang3.*;
import java.io.*;
import java.util.function.*;
import java.util.stream.*;
import org.lwjgl.glfw.*;
import net.minecraft.block.*;
import net.minecraft.util.shape.*;
import net.minecraft.network.*;
import net.minecraft.util.hit.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.text.*;
import minegame159.meteorclient.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.effect.*;
import java.text.*;

public class EnchantUtil
{
    private static final String[] f35529;
    public static MinecraftClient mc;
    public static boolean f35531;
    public static boolean f35532;
    private static final Random rand;
    private static final Vec3d f35534;
    private static final Vec3d f35535;
    private static final Vec3d f35536;
    private static final DecimalFormat f35537;
    
    public EnchantUtil() {
        super();
    }
    
    public static void m35538(final ItemStack itemStack, final ItemStack[] array) {
        Arrays.fill(array, ItemStack.EMPTY);
        final CompoundTag tag = itemStack.getTag();
        if (tag != null && tag.contains("BlockEntityTag")) {
            final CompoundTag compound = tag.getCompound("BlockEntityTag");
            if (compound.contains("Items")) {
                final ListTag listTag = (ListTag)compound.get("Items");
                for (int i = 0; i < listTag.size(); ++i) {
                    array[listTag.getCompound(i).getByte("Slot")] = ItemStack.fromTag(listTag.getCompound(i));
                }
            }
        }
    }
    
    public static double m35545() {
        return EnchantUtil.mc.window.getFramebufferWidth() / c31870.f37895.f37896;
    }
    
    public static double m35546() {
        return EnchantUtil.mc.window.getFramebufferHeight() / c31870.f37895.f37896;
    }
    
    public static Object2IntMap<class_1291> m35547() {
        final Object2IntArrayMap object2IntArrayMap = new Object2IntArrayMap(Registry.STATUS_EFFECT.getIds().size());
        Registry.STATUS_EFFECT.forEach(EnchantUtil::m35654);
        return (Object2IntMap<class_1291>)object2IntArrayMap;
    }
    
    public static String m35549(final Enchantment enchantment) {
        if (enchantment == Enchantments.field_9095) {
            return "F Prot";
        }
        if (enchantment == Enchantments.field_9129) {
            return "Fea Fa";
        }
        if (enchantment == Enchantments.field_9107) {
            return "B Prot";
        }
        if (enchantment == Enchantments.field_9096) {
            return "P Prot";
        }
        if (enchantment == Enchantments.field_9105) {
            return "Aqua A";
        }
        if (enchantment == Enchantments.field_9097) {
            return "Thorns";
        }
        if (enchantment == Enchantments.field_9128) {
            return "Depth S";
        }
        if (enchantment == Enchantments.field_9122) {
            return "Frost W";
        }
        if (enchantment == Enchantments.field_9113) {
            return "Curse B";
        }
        if (enchantment == Enchantments.field_9123) {
            return "Smite";
        }
        if (enchantment == Enchantments.field_9112) {
            return "Bane A";
        }
        if (enchantment == Enchantments.field_9124) {
            return "Fire A";
        }
        if (enchantment == Enchantments.field_9099) {
            return "Silk T";
        }
        if (enchantment == Enchantments.field_9103) {
            return "Power";
        }
        if (enchantment == Enchantments.field_9116) {
            return "Punch";
        }
        if (enchantment == Enchantments.field_9126) {
            return "Flame";
        }
        if (enchantment == Enchantments.field_9114) {
            return "Luck S";
        }
        if (enchantment == Enchantments.field_9098) {
            return "Quick C";
        }
        if (enchantment == Enchantments.field_9109) {
            return "Curse V";
        }
        return enchantment.getName(0).asString().substring(0, 4);
    }
    
    public static int m35551(final String str, final String s) {
        int n = 0;
        final String[] split = s.split(" ");
        for (int length = split.length, i = 0; i < length; ++i) {
            if (StringUtils.containsIgnoreCase(str, split[i])) {
                ++n;
            }
        }
        return n;
    }
    
    public static double m35557(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n4 - n;
        final double n8 = n5 - n2;
        final double n9 = n6 - n3;
        return n7 * n7 + n8 * n8 + n9 * n9;
    }
    
    public static double m35567(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n4 - n;
        final double n8 = n5 - n2;
        final double n9 = n6 - n3;
        return Math.sqrt(n7 * n7 + n8 * n8 + n9 * n9);
    }
    
    public static String m35577() {
        if (EnchantUtil.mc.isInSingleplayer()) {
            File file = EnchantUtil.mc.getServer().getWorld(EnchantUtil.mc.world.dimension.getType()).getSaveHandler().getWorldDir();
            if (file.toPath().relativize(EnchantUtil.mc.runDirectory.toPath()).getNameCount() != 2) {
                file = file.getParentFile();
            }
            return file.getName();
        }
        String replace = EnchantUtil.mc.isConnectedToRealms() ? "realms" : EnchantUtil.mc.getCurrentServerEntry().address;
        if (SystemUtils.IS_OS_WINDOWS) {
            replace = replace.replace(":", "_");
        }
        return replace;
    }
    
    public static String m35580(final String s) {
        return Arrays.stream(s.split("-")).map((Function<? super String, ?>)StringUtils::capitalize).collect((Collector<? super Object, ?, String>)Collectors.joining(" "));
    }
    
    public static String m35582(final int n) {
        switch (n) {
            case -1: {
                return "Unknown";
            }
            case 256: {
                return "Esc";
            }
            case 283: {
                return "Print Screen";
            }
            case 284: {
                return "Pause";
            }
            case 260: {
                return "Insert";
            }
            case 261: {
                return "Delete";
            }
            case 268: {
                return "Home";
            }
            case 266: {
                return "Page Up";
            }
            case 267: {
                return "Page Down";
            }
            case 269: {
                return "End";
            }
            case 258: {
                return "Tab";
            }
            case 341: {
                return "Left Control";
            }
            case 345: {
                return "Right Control";
            }
            case 342: {
                return "Left Alt";
            }
            case 346: {
                return "Right Alt";
            }
            case 340: {
                return "Left Shift";
            }
            case 344: {
                return "Right Shift";
            }
            case 265: {
                return "Arrow Up";
            }
            case 264: {
                return "Arrow Down";
            }
            case 263: {
                return "Arrow Left";
            }
            case 262: {
                return "Arrow Right";
            }
            case 39: {
                return "Apostrophe";
            }
            case 259: {
                return "Backspace";
            }
            case 280: {
                return "Caps Lock";
            }
            case 348: {
                return "Menu";
            }
            case 343: {
                return "Left Super";
            }
            case 347: {
                return "Right Super";
            }
            case 257: {
                return "Enter";
            }
            case 282: {
                return "Num Lock";
            }
            case 32: {
                return "Space";
            }
            default: {
                final String glfwGetKeyName = GLFW.glfwGetKeyName(n, 0);
                if (glfwGetKeyName == null) {
                    return "Unknown";
                }
                return glfwGetKeyName;
            }
        }
    }
    
    public static boolean m35585(final BlockState blockState, final BlockPos blockPos, final boolean b, final boolean b2, final boolean b3) {
        ((c37143)EnchantUtil.f35534).m37144(EnchantUtil.mc.player.x, EnchantUtil.mc.player.y + EnchantUtil.mc.player.getEyeHeight(EnchantUtil.mc.player.getPose()), EnchantUtil.mc.player.z);
        if (!EnchantUtil.mc.world.getBlockState(blockPos).getMaterial().isReplaceable()) {
            return false;
        }
        for (final class_2350 class_2350 : Direction.values()) {
            final BlockPos offset = blockPos.offset((Direction)class_2350);
            final Direction opposite = ((Direction)class_2350).getOpposite();
            Label_0535: {
                if (b2) {
                    ((c37143)EnchantUtil.f35535).m37144(blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5);
                    ((c37143)EnchantUtil.f35536).m37144(offset.getX() + 0.5, offset.getY() + 0.5, offset.getZ() + 0.5);
                    if (EnchantUtil.f35534.squaredDistanceTo(EnchantUtil.f35535) >= EnchantUtil.f35534.squaredDistanceTo(EnchantUtil.f35536)) {
                        break Label_0535;
                    }
                }
                if (EnchantUtil.mc.world.getBlockState(offset).getOutlineShape((BlockView)EnchantUtil.mc.world, blockPos) != VoxelShapes.empty()) {
                    ((c37143)EnchantUtil.f35535).m37144(offset.getX() + 0.5 + opposite.getVector().getX() * 0.5, offset.getY() + 0.5 + opposite.getVector().getY() * 0.5, offset.getZ() + 0.5 + opposite.getVector().getZ() * 0.5);
                    if (EnchantUtil.f35534.squaredDistanceTo(EnchantUtil.f35535) <= 18.0625) {
                        if (!b3 || EnchantUtil.mc.world.canPlace(blockState, blockPos, EntityContext.absent())) {
                            EnchantUtil.mc.player.networkHandler.sendPacket((Packet)new class_2828.class_2831(m35598(EnchantUtil.f35535), m35600(EnchantUtil.f35535), EnchantUtil.mc.player.onGround));
                            EnchantUtil.mc.interactionManager.interactBlock(EnchantUtil.mc.player, EnchantUtil.mc.world, Hand.field_5808, new BlockHitResult(EnchantUtil.f35535, opposite, offset, false));
                            EnchantUtil.mc.interactionManager.interactItem((PlayerEntity)EnchantUtil.mc.player, (World)EnchantUtil.mc.world, Hand.field_5808);
                            if (b) {
                                EnchantUtil.mc.player.swingHand(Hand.field_5808);
                            }
                            else {
                                EnchantUtil.mc.getNetworkHandler().sendPacket((Packet)new HandSwingC2SPacket(Hand.field_5808));
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean m35595(final BlockState blockState, final BlockPos blockPos) {
        return m35585(blockState, blockPos, true, true, true);
    }
    
    public static float m35598(final Vec3d vec3d) {
        return EnchantUtil.mc.player.yaw + MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(vec3d.z - EnchantUtil.mc.player.z, vec3d.x - EnchantUtil.mc.player.x)) - 90.0f - EnchantUtil.mc.player.yaw);
    }
    
    public static float m35600(final Vec3d vec3d) {
        final double n = vec3d.x - EnchantUtil.mc.player.x;
        final double n2 = vec3d.y - (EnchantUtil.mc.player.y + EnchantUtil.mc.player.getEyeHeight(EnchantUtil.mc.player.getPose()));
        final double n3 = vec3d.z - EnchantUtil.mc.player.z;
        return EnchantUtil.mc.player.pitch + MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(n2, Math.sqrt(n * n + n3 * n3)))) - EnchantUtil.mc.player.pitch);
    }
    
    public static double m35606(final double n, final double n2, final double n3) {
        return Math.sqrt(EnchantUtil.mc.gameRenderer.getCamera().getPos().squaredDistanceTo(n, n2, n3));
    }
    
    public static double m35611(final Entity entity) {
        return m35606(entity.x, entity.y, entity.z);
    }
    
    public static boolean m35613() {
        return EnchantUtil.mc.world != null || EnchantUtil.mc.player != null;
    }
    
    public static int m35614(final int n, final int n2) {
        return EnchantUtil.rand.nextInt(n2 - n) + n;
    }
    
    public static double m35617(final double n, final double n2) {
        return n + (n2 - n) * EnchantUtil.rand.nextDouble();
    }
    
    public static void m35620(String s, final Object... array) {
        if (EnchantUtil.mc.player == null) {
            return;
        }
        s = String.format(s, array);
        s = s.replaceAll("#yellow", Formatting.field_1054.toString());
        s = s.replaceAll("#white", Formatting.field_1068.toString());
        s = s.replaceAll("#red", Formatting.field_1061.toString());
        s = s.replaceAll("#blue", Formatting.field_1078.toString());
        s = s.replaceAll("#pink", Formatting.field_1076.toString());
        s = s.replaceAll("#gray", Formatting.field_1080.toString());
        EnchantUtil.mc.player.sendMessage((Text)new LiteralText(s));
    }
    
    public static void m35623() {
        ((c37135)EnchantUtil.mc).m37136();
    }
    
    public static void m35624() {
        ((c37135)EnchantUtil.mc).m37137();
    }
    
    public static c38667 m35625(final String[] array) {
        if (array.length < 1) {
            c31351.m31371("You must specify module name.", new Object[0]);
            return null;
        }
        final c38667 m34045 = c34030.f34033.m34045(array[0]);
        if (m34045 == null) {
            c31351.m31371("Module with name (highlight)%s (default)doesn't exist.", array[0]);
            return null;
        }
        return m34045;
    }
    
    public static boolean m35628(final Item item) {
        return item == Items.SHULKER_BOX || item == Items.WHITE_SHULKER_BOX || item == Items.ORANGE_SHULKER_BOX || item == Items.MAGENTA_SHULKER_BOX || item == Items.LIGHT_BLUE_SHULKER_BOX || item == Items.YELLOW_SHULKER_BOX || item == Items.LIME_SHULKER_BOX || item == Items.PINK_SHULKER_BOX || item == Items.GRAY_SHULKER_BOX || item == Items.LIGHT_GRAY_SHULKER_BOX || item == Items.CYAN_SHULKER_BOX || item == Items.PURPLE_SHULKER_BOX || item == Items.BLUE_SHULKER_BOX || item == Items.BROWN_SHULKER_BOX || item == Items.GREEN_SHULKER_BOX || item == Items.RED_SHULKER_BOX || item == Items.BLACK_SHULKER_BOX;
    }
    
    public static boolean m35630(final Item item) {
        return item instanceof BowItem || item instanceof CrossbowItem || item instanceof SnowballItem || item instanceof EggItem || item instanceof EnderPearlItem || item instanceof SplashPotionItem || item instanceof LingeringPotionItem || item instanceof FishingRodItem || item instanceof TridentItem;
    }
    
    public static String m35632(final float n) {
        if (n % 1.0f == 0.0f) {
            return Integer.toString((int)n);
        }
        return Float.toString(n);
    }
    
    public static String m35634(final double n) {
        if (n % 1.0 == 0.0) {
            return Integer.toString((int)n);
        }
        return EnchantUtil.f35537.format(n);
    }
    
    public static int m35636(final int n, final int n2, final int n3) {
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }
    
    public static float m35640(final float n, final float n2, final float n3) {
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }
    
    public static double m35644(final double n, final double n2, final double n3) {
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }
    
    public static void m35648(final ItemStack itemStack, final Enchantment enchantment, final int n) {
        itemStack.getOrCreateTag();
        if (!itemStack.getTag().contains("Enchantments", 9)) {
            itemStack.getTag().put("Enchantments", (Tag)new ListTag());
        }
        final ListTag list = itemStack.getTag().getList("Enchantments", 10);
        final CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("id", String.valueOf(Registry.ENCHANTMENT.getId((Object)enchantment)));
        compoundTag.putShort("lvl", (short)n);
        list.add((Object)compoundTag);
    }
    
    private static /* synthetic */ void m35654(final Object2IntMap object2IntMap, final StatusEffect statusEffect) {
        object2IntMap.put((Object)statusEffect, 0);
    }
    
    static {
        f35529 = new String[] { "BlockEntityTag", "BlockEntityTag", "Items", "Items", "Slot", "F Prot", "Fea Fa", "B Prot", "P Prot", "Aqua A", "Thorns", "Depth S", "Frost W", "Curse B", "Smite", "Bane A", "Fire A", "Silk T", "Power", "Punch", "Flame", "Luck S", "Quick C", "Curse V", " ", "realms", ":", "_", "-", " ", "Unknown", "Esc", "Print Screen", "Pause", "Insert", "Delete", "Home", "Page Up", "Page Down", "End", "Tab", "Left Control", "Right Control", "Left Alt", "Right Alt", "Left Shift", "Right Shift", "Arrow Up", "Arrow Down", "Arrow Left", "Arrow Right", "Apostrophe", "Backspace", "Caps Lock", "Menu", "Left Super", "Right Super", "Enter", "Num Lock", "Space", "Unknown", "#yellow", "#white", "#red", "#blue", "#pink", "#gray", "You must specify module name.", "Module with name (highlight)%s (default)doesn't exist.", "Enchantments", "Enchantments", "Enchantments", "id", "lvl", "0" };
        EnchantUtil.f35532 = true;
        rand = new Random();
        f35534 = new Vec3d(0.0, 0.0, 0.0);
        f35535 = new Vec3d(0.0, 0.0, 0.0);
        f35536 = new Vec3d(0.0, 0.0, 0.0);
        (f35537 = new DecimalFormat("0")).setMaximumFractionDigits(340);
        final DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        EnchantUtil.f35537.setDecimalFormatSymbols(decimalFormatSymbols);
    }
}
