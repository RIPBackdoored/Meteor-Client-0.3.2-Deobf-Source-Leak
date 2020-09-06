package minegame159.meteorclient;

import java.util.*;
import java.io.*;

public class c35919 extends c34014
{
    private static final String[] f35920;
    public static List<String> f35921;
    
    public c35919() {
        super("ignore", "Lets you ignore messages from specific players.");
    }
    
    @Override
    public void m34018(final String[] array) {
        if (array.length == 0) {
            c31351.m31357("Ignoring (highlight)%d (default)people:", c35919.f35921.size());
            final Iterator<String> iterator = c35919.f35921.iterator();
            while (iterator.hasNext()) {
                c31351.m31357("- (highlight)%s", iterator.next());
            }
        }
        else if (c35919.f35921.remove(array[0])) {
            c31351.m31357("Removed (highlight)%s (default)from list of ignored people.", array[0]);
        }
        else {
            c35919.f35921.add(array[0]);
            c31351.m31357("Added (highlight)%s (default) to list of ignored people.", array[0]);
        }
    }
    
    public static void m35925() {
        final File file = new File(MeteorClient.dir, "ignored_players.txt");
        if (file.exists()) {
            try {
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    c35919.f35921.add(line.split(" ")[0]);
                }
                bufferedReader.close();
            }
            catch (IOException ex) {
                c35919.f35921 = new ArrayList<String>();
            }
        }
    }
    
    public static void m35930() {
        try {
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(MeteorClient.dir, "ignored_players.txt")));
            final Iterator<String> iterator = c35919.f35921.iterator();
            while (iterator.hasNext()) {
                bufferedWriter.write(iterator.next());
                bufferedWriter.write(" OwO\n");
            }
            bufferedWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        f35920 = new String[] { "ignore", "Lets you ignore messages from specific players.", "Ignoring (highlight)%d (default)people:", "- (highlight)%s", "Removed (highlight)%s (default)from list of ignored people.", "Added (highlight)%s (default) to list of ignored people.", "ignored_players.txt", " ", "ignored_players.txt", " OwO\n" };
        c35919.f35921 = new ArrayList<String>();
    }
}
