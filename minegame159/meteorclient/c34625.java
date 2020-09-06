package minegame159.meteorclient;

import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.entity.effect.*;
import java.util.*;

public class c34625 extends c36715
{
    private static final String[] f34626;
    private ItemStack f34627;
    private c38636 f34628;
    private c39081 f34629;
    
    public c34625(final ItemStack f34627, final String s) {
        super();
        this.f34627 = f34627;
        this.f34628 = this.m31937(new c38636(f34627)).m39632();
        this.f34629 = this.m31937(new c39081(s + this.m34630())).m39632();
    }
    
    public c34625(final ItemStack itemStack) {
        this(itemStack, itemStack.getName().asString());
    }
    
    private String m34630() {
        String string = "";
        if (this.f34627.getItem() == Items.field_8574) {
            final List effects = PotionUtil.getPotion(this.f34627).getEffects();
            if (effects.size() > 0) {
                String s = string + " ";
                final StatusEffectInstance statusEffectInstance = effects.get(0);
                if (statusEffectInstance.getAmplifier() > 0) {
                    s = s + (statusEffectInstance.getAmplifier() + 1) + " ";
                }
                string = s + "(" + StatusEffectUtil.durationToString(statusEffectInstance, 1.0f) + ")";
            }
        }
        return string;
    }
    
    public void m34635(final ItemStack itemStack) {
        this.f34627 = itemStack;
        this.f34628.f38637 = itemStack;
        this.f34629.m39087(itemStack.getName().asString() + this.m34630());
    }
    
    public String m34638() {
        return this.f34629.m39085();
    }
    
    static {
        f34626 = new String[] { "", " ", " ", "(", ")" };
    }
}
