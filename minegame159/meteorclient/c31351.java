package minegame159.meteorclient;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.text.*;

public class c31351
{
    private static final String[] f31352;
    
    public c31351() {
        super();
    }
    
    public static void m31353(final c38667 c38667, final String s, final Object... array) {
        m31374(c38667, m31378(s, Formatting.field_1080, array), Formatting.field_1080);
    }
    
    public static void m31357(final String s, final Object... array) {
        m31353(null, s, array);
    }
    
    public static void m31360(final c38667 c38667, final String s, final Object... array) {
        m31374(c38667, m31378(s, Formatting.field_1054, array), Formatting.field_1054);
    }
    
    public static void m31364(final String s, final Object... array) {
        m31360(null, s, array);
    }
    
    public static void m31367(final c38667 c38667, final String s, final Object... array) {
        m31374(c38667, m31378(s, Formatting.field_1061, array), Formatting.field_1061);
    }
    
    public static void m31371(final String s, final Object... array) {
        m31367(null, s, array);
    }
    
    private static void m31374(final c38667 c38667, final String s, final Formatting formatting) {
        if (MinecraftClient.getInstance().world == null) {
            return;
        }
        if (c38667 != null) {
            MinecraftClient.getInstance().player.sendMessage((Text)new LiteralText(String.format("%s[Meteor] %s[%s]: %s%s", Formatting.field_1078, Formatting.field_1075, c38667.f38672, formatting, s)));
        }
        else {
            MinecraftClient.getInstance().player.sendMessage((Text)new LiteralText(String.format("%s[Meteor]: %s%s", Formatting.field_1078, formatting, s)));
        }
    }
    
    private static String m31378(final String s, final Formatting formatting, final Object... array) {
        return String.format(s, array).replaceAll("\\(default\\)", formatting.toString()).replaceAll("\\(highlight\\)", Formatting.field_1068.toString());
    }
    
    static {
        f31352 = new String[] { "%s[Meteor] %s[%s]: %s%s", "%s[Meteor]: %s%s", "\\(default\\)", "\\(highlight\\)" };
    }
}
