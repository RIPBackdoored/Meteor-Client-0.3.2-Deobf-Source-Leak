package minegame159.meteorclient.mixin;

import net.minecraft.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import meteorclient.modules.*;
import java.util.function.*;
import net.minecraft.text.*;
import net.minecraft.util.*;
import minegame159.meteorclient.*;
import meteorclient.util.*;
import net.minecraft.nbt.*;
import java.util.*;
import org.spongepowered.asm.mixin.*;
import net.fabricmc.api.*;

@Mixin({ class_2480.class })
public class ShulkerBoxBlockMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    
    public ShulkerBoxBlockMixin() {
        super();
    }
    
    @Overwrite
    @Environment(EnvType.CLIENT)
    public void method_9568(final class_1799 class_1799, final class_1922 class_1800, final List<class_2561> list, final class_1836 class_1801) {
        final CompoundTag subTag = ((ItemStack)class_1799).getSubTag("BlockEntityTag");
        if (subTag != null) {
            if (subTag.contains("LootTable", 8)) {
                list.add((class_2561)new LiteralText("???????"));
            }
            if (subTag.contains("Items", 9)) {
                final DefaultedList ofSize = DefaultedList.ofSize(27, (Object)ItemStack.EMPTY);
                Inventories.fromTag(subTag, ofSize);
                int size = 0;
                int n = 0;
                if (c34030.f34033.m34042(Shulkertooltip.class).m35315()) {
                    final HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
                    for (final ItemStack itemStack : ofSize) {
                        if (!itemStack.isEmpty()) {
                            final Text name = itemStack.getName();
                            hashMap.put(name, hashMap.computeIfAbsent(name, (Function<? super Text, ? extends Integer>)ShulkerBoxBlockMixin::lambda$buildTooltip$0) + itemStack.getCount());
                        }
                    }
                    size = hashMap.size();
                    final ArrayList<Pair> list2 = new ArrayList<Pair>(5);
                    for (int n2 = 0; n2 < c34030.f34033.m34042(Shulkertooltip.class).m37827() && hashMap.size() != 0; ++n2) {
                        Object o = null;
                        int n3 = 0;
                        for (final Text text : hashMap.keySet()) {
                            final int intValue = hashMap.get(text);
                            if (intValue > n3) {
                                n3 = intValue;
                                o = text;
                            }
                        }
                        list2.add(new Pair(o, (Object)n3));
                        hashMap.remove(o);
                    }
                    for (final Pair pair : list2) {
                        ++n;
                        final Text deepCopy = ((Text)pair.getLeft()).deepCopy();
                        deepCopy.append(" x").append(String.valueOf(pair.getRight()));
                        list.add((class_2561)deepCopy);
                    }
                }
                else {
                    for (final ItemStack itemStack2 : ofSize) {
                        if (!itemStack2.isEmpty()) {
                            ++size;
                            if (n > 4) {
                                continue;
                            }
                            ++n;
                            final Text deepCopy2 = itemStack2.getName().deepCopy();
                            deepCopy2.append(" x").append(String.valueOf(itemStack2.getCount()));
                            list.add((class_2561)deepCopy2);
                        }
                    }
                }
                if (size - n > 0) {
                    list.add((class_2561)new TranslatableText("container.shulkerBox.more", new Object[] { size - n }).formatted(Formatting.field_1056));
                }
                list.add((class_2561)new LiteralText(""));
                list.add((class_2561)new LiteralText("Press " + Formatting.field_1054 + EnchantUtil.m35582(MeteorClient.INSTANCE.shulkerPeek.getBoundKey().method_1444()) + Formatting.field_1070 + " to peek"));
            }
        }
    }
    
    private static /* bridge */ Integer lambda$buildTooltip$0(final Text text) {
        return 0;
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "BlockEntityTag", "LootTable", "???????", "Items", " x", " x", "container.shulkerBox.more", "", "Press ", " to peek" };
    }
}
