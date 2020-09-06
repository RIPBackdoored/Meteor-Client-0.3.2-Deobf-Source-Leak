package minegame159.meteorclient;

import net.minecraft.nbt.*;
import java.io.*;

public abstract class c37297<T> implements c34681<T>
{
    private final File f37298;
    
    public c37297(final File f37298) {
        super();
        this.f37298 = f37298;
    }
    
    public void m37299(final File file) {
        try {
            file.getParentFile().mkdirs();
            NbtIo.write(this.m34682(), file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void m37303() {
        this.m37299(this.m37311());
    }
    
    public boolean m37305(final File file) {
        try {
            if (file.exists()) {
                this.m34683(NbtIo.read(file));
                return true;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean m37309() {
        return this.m37305(this.m37311());
    }
    
    public File m37311() {
        return this.f37298;
    }
}
