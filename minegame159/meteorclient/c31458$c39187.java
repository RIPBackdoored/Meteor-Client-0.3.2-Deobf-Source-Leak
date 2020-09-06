package minegame159.meteorclient;

import net.minecraft.entity.*;

static class c39187
{
    static final /* synthetic */ int[] f39188;
    static final /* synthetic */ int[] f39189;
    
    static {
        c39187.f39189 = new int[EntityCategory.values().length];
        try {
            c39187.f39189[EntityCategory.field_6294.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            c39187.f39189[EntityCategory.field_6300.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            c39187.f39189[EntityCategory.field_6302.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            c39187.f39189[EntityCategory.field_6303.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            c39187.f39189[EntityCategory.field_17715.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        c39187.f39188 = new int[c31458.Mode.values().length];
        try {
            c39187.f39188[c31458.Mode.Lines.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            c39187.f39188[c31458.Mode.Sides.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            c39187.f39188[c31458.Mode.Both.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
    }
}
