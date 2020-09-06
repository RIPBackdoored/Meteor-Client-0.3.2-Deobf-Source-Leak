package minegame159.meteorclient;

import java.util.*;
import org.apache.commons.io.*;
import java.io.*;

public class c35019
{
    private static final String[] f35020;
    private static final File f35021;
    
    public c35019() {
        super();
    }
    
    public static List<String> m35022() {
        final String[] list = c35019.f35021.list();
        final ArrayList<String> list2 = new ArrayList<String>(0);
        if (list != null) {
            for (final String s : list) {
                final File file = new File(s);
                if (!s.contains(".")) {
                    list2.add(file.getName());
                }
            }
        }
        return list2;
    }
    
    public static boolean m35027(final String s) {
        if (s.isEmpty() || s.contains(".")) {
            return false;
        }
        final File file = new File(c35019.f35021, s);
        c33436.f34122.m37299(new File(file, c33436.f34122.m37311().getName()));
        c34030.f34033.m37299(new File(file, c34030.f34033.m37311().getName()));
        c39017.f39019.m37299(new File(file, c39017.f39019.m37311().getName()));
        c33410.f33412.m37299(new File(file, c33410.f33412.m37311().getName()));
        c34371.f34373.m37299(new File(file, c34371.f34373.m37311().getName()));
        return true;
    }
    
    public static void m35030(final String s) {
        final File file = new File(c35019.f35021, s);
        c33436.f34122.m37305(new File(file, c33436.f34122.m37311().getName()));
        c34030.f34033.m37305(new File(file, c34030.f34033.m37311().getName()));
        c39017.f39019.m37305(new File(file, c39017.f39019.m37311().getName()));
        c33410.f33412.m37305(new File(file, c33410.f33412.m37311().getName()));
        c34371.f34373.m37305(new File(file, c34371.f34373.m37311().getName()));
    }
    
    public static void m35033(final String s) {
        try {
            FileUtils.deleteDirectory(new File(c35019.f35021, s));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        f35020 = new String[] { ".", ".", "profiles" };
        f35021 = new File(MeteorClient.dir, "profiles");
    }
}
