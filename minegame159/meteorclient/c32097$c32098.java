package minegame159.meteorclient;

import net.minecraft.util.math.*;
import java.io.*;
import java.util.*;

public static class c32098
{
    private static final StringBuilder f32099;
    public ChunkPos f32100;
    public transient int f32101;
    public transient int f32102;
    public int f32103;
    public int f32104;
    public int f32105;
    public int f32106;
    public int f32107;
    public int f32108;
    public int f32109;
    
    public c32098(final ChunkPos f32100) {
        super();
        this.f32100 = f32100;
        this.m32110();
    }
    
    public void m32110() {
        this.f32101 = this.f32100.x * 16 + 8;
        this.f32102 = this.f32100.z * 16 + 8;
    }
    
    public int m32112() {
        return this.f32103 + this.f32104 + this.f32105 + this.f32106 + this.f32107 + this.f32108 + this.f32109;
    }
    
    public void m32114(final Writer writer) throws IOException {
        c32098.f32099.setLength(0);
        c32098.f32099.append(this.f32101).append(',').append(this.f32102).append(',');
        c32098.f32099.append(this.f32103).append(',').append(this.f32104).append(',').append(this.f32105).append(',').append(this.f32106).append(',').append(this.f32107).append(',').append(this.f32108).append(',').append(this.f32109).append('\n');
        writer.write(c32098.f32099.toString());
    }
    
    public boolean m32117(final c32098 c32098) {
        return c32098 != null && (this.f32103 != c32098.f32103 || this.f32104 != c32098.f32104 || this.f32105 != c32098.f32105 || this.f32106 != c32098.f32106 || this.f32107 != c32098.f32107 || this.f32108 != c32098.f32108 || this.f32109 != c32098.f32109);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && this.getClass() == o.getClass() && Objects.equals(this.f32100, ((c32098)o).f32100));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.f32100);
    }
    
    static {
        c32098.f32099 = new StringBuilder();
    }
}
