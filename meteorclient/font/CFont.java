package meteorclient.font;

import javax.imageio.*;
import java.io.*;
import org.lwjgl.*;
import net.minecraft.client.texture.*;
import java.awt.image.*;
import java.nio.*;
import java.awt.*;
import java.awt.geom.*;
import net.minecraft.client.render.*;
import minegame159.meteorclient.*;

public class CFont
{
    private static final String[] f33754;
    private static final int f33755 = 512;
    private static final c37042 f33756;
    private final c35197 f33757;
    private final Texture f33758;
    private final c35894[] f33759;
    private int f33760;
    public double f33761;
    
    public CFont(final Font font, final boolean b, final boolean b2) {
        super();
        this.f33757 = new c35197(16384);
        this.f33759 = new c35894[256];
        this.f33760 = -1;
        this.f33761 = 1.0;
        this.f33758 = this.m33762(font, b, b2, this.f33759);
    }
    
    private Texture m33762(final Font font, final boolean b, final boolean b2, final c35894[] array) {
        final BufferedImage m33773 = this.m33773(font, b, b2, array);
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(m33773, "png", byteArrayOutputStream);
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            final ByteBuffer put = BufferUtils.createByteBuffer(byteArray.length).put(byteArray);
            put.flip();
            return (Texture)new NativeImageBackedTexture(NativeImage.read(put));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private BufferedImage m33773(final Font font, final boolean b, final boolean b2, final c35894[] array) {
        final BufferedImage bufferedImage = new BufferedImage(512, 512, 2);
        final Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, 512, 512);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, b2 ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, b ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, b ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        final FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int f35898 = 0;
        int f35899 = 0;
        int f35900 = 1;
        for (int i = 0; i < array.length; ++i) {
            final char c = (char)i;
            final c35894 c2 = new c35894();
            final Rectangle2D stringBounds = fontMetrics.getStringBounds(String.valueOf(c), graphics2D);
            c2.f35897 = stringBounds.getBounds().width + 8;
            c2.f35898 = stringBounds.getBounds().height;
            if (f35899 + c2.f35897 >= 512) {
                f35899 = 0;
                f35900 += f35898;
                f35898 = 0;
            }
            if (c2.f35898 > f35898) {
                f35898 = c2.f35898;
            }
            c2.f35895 = f35899;
            c2.f35896 = f35900;
            if (c2.f35898 > this.f33760) {
                this.f33760 = c2.f35898;
            }
            array[i] = c2;
            graphics2D.drawString(String.valueOf(c), f35899 + 2, f35900 + fontMetrics.getAscent());
            f35899 += c2.f35897;
        }
        return bufferedImage;
    }
    
    public void m33789() {
        this.f33757.m35208(4, VertexFormats.POSITION_TEXTURE_COLOR);
    }
    
    public boolean m33791() {
        return this.f33757.m35229();
    }
    
    public void m33793() {
        this.f33758.bindTexture();
        this.f33757.m35226(true);
    }
    
    public double m33795(final String s, double n, double n2, final c37042 c37042) {
        final boolean m33791 = this.m33791();
        if (!this.m33791()) {
            this.m33789();
        }
        --n;
        --n2;
        n *= 2.0;
        n2 *= 2.0;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 < this.f33759.length) {
                this.f33759[char1].m35900(this.f33757, n, n2, c37042);
                n += (this.f33759[char1].f35897 - 8) * this.f33761;
            }
        }
        if (!m33791) {
            this.m33793();
        }
        return n / 2.0;
    }
    
    public double m33804(final String s, final double n, final double n2, final c37042 c37042) {
        final boolean m33791 = this.m33791();
        if (!this.m33791()) {
            this.m33789();
        }
        final double max = Math.max(this.m33795(s, n + 1.0 * this.f33761, n2 + 1.0 * this.f33761, CFont.f33756), this.m33795(s, n, n2, c37042));
        if (!m33791) {
            this.m33793();
        }
        return max;
    }
    
    public double m33813() {
        return Math.round((this.f33760 - 8.0) / 2.0 + 2.0) * this.f33761;
    }
    
    public double m33815(final String s) {
        int n = 0;
        for (final char c : s.toCharArray()) {
            if (c < this.f33759.length) {
                n += this.f33759[c].f35897 - 8;
            }
        }
        return Math.round(n / 2.0) * this.f33761;
    }
    
    static {
        f33754 = new String[] { "png" };
        f33756 = new c37042(60, 60, 60, 180);
    }
    
    public class c35894
    {
        public int f35895;
        public int f35896;
        public int f35897;
        public int f35898;
        final /* synthetic */ CFont f35899;
        
        public c35894(final CFont f35899) {
            this.f35899 = f35899;
            super();
        }
        
        public void m35900(final c35197 f39339, final double n, final double n2, final c37042 c37042) {
            final double n3 = this.f35895 / 512.0;
            final double n4 = this.f35896 / 512.0;
            final double n5 = this.f35897 / 512.0;
            final double n6 = this.f35898 / 512.0;
            final c35197 f39340 = c39337.f39339;
            c39337.f39339 = f39339;
            c39337.m39361(n / 2.0, n2 / 2.0, this.f35897 / 2.0 * this.f35899.f33761, this.f35898 / 2.0 * this.f35899.f33761, n3, n4, n5, n6, c37042, c37042, c37042, c37042);
            c39337.f39339 = f39340;
        }
    }
}
