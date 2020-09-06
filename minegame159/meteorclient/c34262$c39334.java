package minegame159.meteorclient;

static class c39334
{
    static final /* synthetic */ int[] f39335;
    static final /* synthetic */ int[] f39336;
    
    static {
        c39334.f39336 = new int[c34262.Priority.values().length];
        try {
            c39334.f39336[c34262.Priority.LowestDistance.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            c39334.f39336[c34262.Priority.HighestDistance.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            c39334.f39336[c34262.Priority.LowestHealth.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            c39334.f39336[c34262.Priority.HighestHealth.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        c39334.f39335 = new int[c34262.Target.values().length];
        try {
            c39334.f39335[c34262.Target.Eyes.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            c39334.f39335[c34262.Target.Body.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            c39334.f39335[c34262.Target.Feet.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
    }
}
