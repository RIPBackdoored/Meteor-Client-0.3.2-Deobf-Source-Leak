package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import meteorclient.*;
import minegame159.meteorclient.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ class_128.class })
public class CrashReportMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    
    public CrashReportMixin() {
        super();
    }
    
    @Inject(method = { "addStackTrace" }, at = { @At("TAIL") })
    private void onAsString(final StringBuilder sb, final CallbackInfo callbackInfo) {
        if (c34030.f34033 != null) {
            sb.append("\n\n");
            sb.append("-- Meteor Client --\n");
            sb.append("Version: ").append(c33436.f34122.f34123).append("\n");
            for (final Category category : c34030.f34032) {
                final List<c38667> m34052 = c34030.f34033.m34052(category);
                boolean b = false;
                for (final c38667 c38667 : m34052) {
                    if (c38667 instanceof Module && ((Module)c38667).m35315()) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    sb.append("\n");
                    sb.append("[").append(category).append("]:").append("\n");
                    for (final c38667 c38668 : m34052) {
                        if (c38668 instanceof Module && ((Module)c38668).m35315()) {
                            sb.append(c38668.f38672).append(" (").append(c38668.f38671).append(")\n");
                        }
                    }
                }
            }
        }
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "\n\n", "-- Meteor Client --\n", "Version: ", "\n", "\n", "[", "]:", "\n", " (", ")\n" };
    }
}
