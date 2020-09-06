package meteorclient.modules;

import meteorclient.*;
import meteorclient.setting.*;
import java.util.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.*;
import net.minecraft.client.gui.screen.ingame.*;
import net.minecraft.item.*;
import net.minecraft.container.*;
import minegame159.meteorclient.*;
import java.io.*;

public class Bookbot extends Module
{
    private static final String[] f34756;
    private static final int f34757 = 113;
    private final Settings f34758;
    private final Value<c34755.Mode> f34759;
    private final Value<String> f34760;
    private final Value<String> f34761;
    private final Value<Integer> f34762;
    private final Value<Integer> f34763;
    private final Value<Integer> f34764;
    private static final Random f34765;
    private ListTag f34766;
    private int f34767;
    private int f34768;
    private boolean f34769;
    private PrimitiveIterator.OfInt f34770;
    private boolean f34771;
    private int f34772;
    private final StringBuilder f34773;
    private final StringBuilder f34774;
    private String f34775;
    @EventHandler
    private final Listener<c36575> f34776;
    
    public Bookbot() {
        super(Category.Misc, "book-bot", "Writes books full of characters or from a file.");
        this.f34758 = this.f38675.m34572();
        this.f34759 = this.f34758.addValue((Value<c34755.Mode>)new c36601.c36919<Enum>().m36926("mode").m36929("The mode of the book bot.").m36932((Enum)c34755.Mode.Ascii).m36941());
        this.f34760 = this.f34758.addValue((Value<String>)new c36225.c36674().m36681("name").m36684("The name you want to give the books").m36687("Meteor on Crack!").m36696());
        this.f34761 = this.f34758.addValue((Value<String>)new c36225.c36674().m36681("file-name").m36684("The name of the text file (.txt included)").m36687("book.txt").m36696());
        this.f34762 = this.f34758.addValue((Value<Integer>)new c32369.c32370().m32381("no-of-pages").m32384("The number of pages to write per book.").m32387(100).m32396(1).m32399(100).m32405(100).m32408());
        this.f34763 = this.f34758.addValue((Value<Integer>)new c32369.c32370().m32381("no-of-books").m32384("The number of books to make(or until the file runs out)").m32387(1).m32408());
        this.f34764 = this.f34758.addValue((Value<Integer>)new c32369.c32370().m32381("delay").m32384("The delay between writing books(in ms)").m32387(300).m32396(75).m32402(75).m32405(600).m32408());
        this.f34766 = new ListTag();
        this.f34768 = 0;
        this.f34773 = new StringBuilder();
        this.f34774 = new StringBuilder();
        this.f34776 = (Listener<c36575>)new Listener(this::m34787, new Predicate[0]);
    }
    
    @Override
    public void m35292() {
        this.f34767 = this.f34763.m33466();
        this.f34769 = true;
    }
    
    @Override
    public void m35294() {
        this.f34767 = 0;
        this.f34766 = new ListTag();
    }
    
    private void m34777() {
        this.f34766.clear();
        if (this.f34771) {
            this.m34785();
            this.f34771 = false;
        }
        for (int i = 0; i < this.f34762.m33466(); ++i) {
            this.f34773.setLength(0);
            boolean b = false;
            for (int j = 0; j < 13; ++j) {
                this.f34774.setLength(0);
                float n = 0.0f;
                boolean b2 = false;
                while (true) {
                    final float charWidth = this.mc.textRenderer.getCharWidth((char)this.f34772);
                    if (this.f34772 == 10) {
                        if (!this.m34785()) {
                            b2 = true;
                            break;
                        }
                        break;
                    }
                    else {
                        if (n + charWidth >= 113.0f) {
                            break;
                        }
                        this.f34774.appendCodePoint(this.f34772);
                        n += charWidth;
                        if (!this.m34785()) {
                            b2 = true;
                            break;
                        }
                        continue;
                    }
                }
                this.f34773.append((CharSequence)this.f34774).append('\n');
                if (b2) {
                    b = true;
                    break;
                }
            }
            this.f34766.add((Object)new StringTag(this.f34773.toString()));
            if (b) {
                break;
            }
        }
        this.mc.player.getMainHandStack().putSubTag("pages", (Tag)this.f34766);
        this.mc.player.getMainHandStack().putSubTag("author", (Tag)new StringTag("Meteor Client"));
        this.mc.player.getMainHandStack().putSubTag("title", (Tag)new StringTag((String)this.f34760.m33466()));
        this.mc.player.networkHandler.sendPacket((Packet)new BookUpdateC2SPacket(this.mc.player.getMainHandStack(), true, Hand.field_5808));
        --this.f34767;
    }
    
    private boolean m34785() {
        if (!this.f34770.hasNext()) {
            this.f34770 = null;
            return false;
        }
        this.f34772 = this.f34770.nextInt();
        return true;
    }
    
    private /* synthetic */ void m34787(final c36575 c36575) {
        if (this.mc.currentScreen instanceof ContainerScreen) {
            return;
        }
        if (this.f34767 <= 0) {
            this.m35300();
            return;
        }
        if (this.mc.player.getMainHandStack().getItem() != Items.field_8674) {
            final c31671.c32663 m31679 = c31671.m31679(Items.field_8674);
            if (m31679.f32664 <= 8 && m31679.f32664 != -1) {
                this.mc.player.inventory.selectedSlot = m31679.f32664;
                ((c39918)this.mc.interactionManager).m39919();
            }
            else {
                if (m31679.f32664 <= 8) {
                    return;
                }
                c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
                c31671.m31675(c31671.m31693(this.mc.player.inventory.selectedSlot), 0, SlotActionType.field_7790);
                c31671.m31675(c31671.m31693(m31679.f32664), 0, SlotActionType.field_7790);
            }
        }
        if (this.f34768 <= 0) {
            this.f34768 = this.f34764.m33466();
            if (this.f34759.m33466() == c34755.Mode.Random) {
                this.f34770 = Bookbot.f34765.ints(128, 1112063).map(c34755::m34798).limit(23000L).iterator();
                this.f34771 = true;
                this.m34777();
            }
            else if (this.f34759.m33466() == c34755.Mode.Ascii) {
                this.f34770 = Bookbot.f34765.ints(32, 127).limit(35000L).iterator();
                this.f34771 = true;
                this.m34777();
            }
            else if (this.f34759.m33466() == c34755.Mode.File) {
                if (this.f34769) {
                    final File file = new File(MeteorClient.dir, this.f34761.m33466());
                    if (!file.exists()) {
                        c31351.m31367(this, "The file you specified doesn't exist in the meteor folder.", new Object[0]);
                        return;
                    }
                    try {
                        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        final StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            sb.append(line).append('\n');
                        }
                        bufferedReader.close();
                        this.f34769 = false;
                        this.f34775 = sb.toString();
                        this.f34770 = this.f34775.chars().iterator();
                        this.f34771 = true;
                        this.m34777();
                    }
                    catch (IOException ex) {
                        c31351.m31367(this, "Failed to read the file.", new Object[0]);
                    }
                }
                else if (this.f34770 != null) {
                    this.m34777();
                }
                else if (this.f34767 > 0) {
                    this.f34770 = this.f34775.chars().iterator();
                    this.m34777();
                }
            }
            return;
        }
        this.f34768 -= 50;
    }
    
    private static /* synthetic */ int m34798(final int n) {
        return (n < 55296) ? n : (n + 2048);
    }
    
    static {
        f34756 = new String[] { "book-bot", "Writes books full of characters or from a file.", "mode", "The mode of the book bot.", "name", "The name you want to give the books", "Meteor on Crack!", "file-name", "The name of the text file (.txt included)", "book.txt", "no-of-pages", "The number of pages to write per book.", "no-of-books", "The number of books to make(or until the file runs out)", "delay", "The delay between writing books(in ms)", "pages", "author", "Meteor Client", "title", "The file you specified doesn't exist in the meteor folder.", "Failed to read the file." };
        f34765 = new Random();
    }
}
