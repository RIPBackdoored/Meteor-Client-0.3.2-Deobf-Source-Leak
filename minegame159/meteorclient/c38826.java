package minegame159.meteorclient;

import java.io.*;

public class c38826 implements DataOutput
{
    public static final c38826 f38827;
    private int f38828;
    
    public c38826() {
        super();
    }
    
    public int m38829() {
        return this.f38828;
    }
    
    public void m38831() {
        this.f38828 = 0;
    }
    
    @Override
    public void write(final int n) throws IOException {
        ++this.f38828;
    }
    
    @Override
    public void write(final byte[] array) throws IOException {
        this.f38828 += array.length;
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) throws IOException {
        this.f38828 += n2;
    }
    
    @Override
    public void writeBoolean(final boolean b) throws IOException {
        ++this.f38828;
    }
    
    @Override
    public void writeByte(final int n) throws IOException {
        ++this.f38828;
    }
    
    @Override
    public void writeShort(final int n) throws IOException {
        this.f38828 += 2;
    }
    
    @Override
    public void writeChar(final int n) throws IOException {
        this.f38828 += 2;
    }
    
    @Override
    public void writeInt(final int n) throws IOException {
        this.f38828 += 4;
    }
    
    @Override
    public void writeLong(final long n) throws IOException {
        this.f38828 += 8;
    }
    
    @Override
    public void writeFloat(final float n) throws IOException {
        this.f38828 += 4;
    }
    
    @Override
    public void writeDouble(final double n) throws IOException {
        this.f38828 += 8;
    }
    
    @Override
    public void writeBytes(final String s) throws IOException {
        this.f38828 += s.length();
    }
    
    @Override
    public void writeChars(final String s) throws IOException {
        this.f38828 += s.length() * 2;
    }
    
    @Override
    public void writeUTF(final String s) throws IOException {
        this.f38828 += (int)(2L + this.m38833(s));
    }
    
    long m38833(final String s) {
        long n = 0L;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 >= '\u0001' && char1 <= '\u007f') {
                ++n;
            }
            else if (char1 > '\u07ff') {
                n += 3L;
            }
            else {
                n += 2L;
            }
        }
        return n;
    }
    
    static {
        f38827 = new c38826();
    }
}
