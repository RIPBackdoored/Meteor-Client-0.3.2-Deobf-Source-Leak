package minegame159.meteorclient.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.gui.hud.*;
import meteorclient.modules.*;
import meteorclient.util.*;
import java.util.*;
import org.spongepowered.asm.mixin.injection.*;
import minegame159.meteorclient.*;
import net.minecraft.util.*;
import net.minecraft.text.*;
import java.util.regex.*;

@Mixin({ class_338.class })
public abstract class ChatHudMixin
{
    private static final String[] ENCRYPTED_STRINGS;
    @Shadow
    @Final
    private List<class_303> field_2064;
    @Shadow
    @Final
    private List<class_303> field_2061;
    private String lastMessage;
    
    public ChatHudMixin() {
        super();
        this.lastMessage = null;
    }
    
    @Shadow
    public abstract int method_1811();
    
    @Inject(at = { @At("HEAD") }, method = { "addMessage(Lnet/minecraft/text/Text;IIZ)V" }, cancellable = true)
    private void onAddMessage(final Text text, final int n, final int n2, final boolean b, final CallbackInfo callbackInfo) {
        final Iterator<String> iterator = c35919.f35921.iterator();
        while (iterator.hasNext()) {
            if (text.toString().contains("<" + iterator.next() + ">")) {
                callbackInfo.cancel();
                return;
            }
        }
        final Antispam antispam = c34030.f34033.m34042(Antispam.class);
        for (int i = 0; i < antispam.m33583(); ++i) {
            if (this.checkMsg(text.asFormattedString(), n2, n, i)) {
                if (antispam.m33585() && i != 0) {
                    final ChatHudLine chatHudLine = this.visibleMessages.remove(i);
                    this.visibleMessages.add(0, chatHudLine);
                    this.messages.add(0, chatHudLine);
                }
                callbackInfo.cancel();
                return;
            }
        }
        if (c34030.f34033.m34042(Friendcolor.class).m35315() && !text.asString().equals(this.lastMessage)) {
            String lastMessage = text.asString();
            for (final c31543 c31543 : c39017.f39019.m39025()) {
                if (lastMessage.contains(c31543.f31545)) {
                    lastMessage = lastMessage.replaceAll(c31543.f31545, "§d" + c31543.f31545 + "§r");
                }
            }
            EnchantUtil.m35620(this.lastMessage = lastMessage, new Object[0]);
            this.lastMessage = null;
            callbackInfo.cancel();
        }
    }
    
    private boolean checkMsg(final String s, final int n, final int n2, final int n3) {
        final ChatHudLine chatHudLine = (this.visibleMessages.size() > n3) ? this.visibleMessages.get(n3) : null;
        if (chatHudLine == null) {
            return false;
        }
        final String formattedString = chatHudLine.getText().asFormattedString();
        if (formattedString.equals(s)) {
            ((c32714)chatHudLine).m32715((Text)new LiteralText(formattedString + Formatting.field_1080 + " (2)"));
            ((c32714)chatHudLine).m32716(n);
            ((c32714)chatHudLine).m32717(n2);
            return true;
        }
        final Matcher matcher = Pattern.compile(".*(\\([0-9]+\\)$)").matcher(formattedString);
        if (matcher.matches()) {
            final String group = matcher.group(1);
            final int int1 = Integer.parseInt(group.substring(1, group.length() - 1));
            final String substring = formattedString.substring(0, formattedString.lastIndexOf(group) - Formatting.field_1080.toString().length() - 1);
            if (substring.equals(s)) {
                ((c32714)chatHudLine).m32715((Text)new LiteralText(substring + Formatting.field_1080 + " (" + (int1 + 1) + ")"));
                ((c32714)chatHudLine).m32716(n);
                ((c32714)chatHudLine).m32717(n2);
                return true;
            }
        }
        return false;
    }
    
    static {
        ENCRYPTED_STRINGS = new String[] { "<", ">", "§d", "§r", " (2)", ".*(\\([0-9]+\\)$)", " (", ")" };
    }
}
