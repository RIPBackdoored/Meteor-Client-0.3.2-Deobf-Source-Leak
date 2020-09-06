package minegame159.meteorclient;

import java.nio.charset.*;
import javax.crypto.spec.*;
import javax.crypto.*;
import java.security.*;
import java.util.*;

public class c39853
{
    private static final String[] f39854;
    
    public c39853() {
        super();
    }
    
    public static String m39855(final String s, final String s2) {
        try {
            final SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-256").digest(s2.getBytes(StandardCharsets.UTF_8)), 16), "AES");
            final Cipher instance = Cipher.getInstance("AES");
            instance.init(1, secretKeySpec);
            return new String(Base64.getEncoder().encode(instance.doFinal(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String m39862(final String s, final String s2) throws Exception {
        final SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-256").digest(s2.getBytes(StandardCharsets.UTF_8)), 16), "AES");
        final Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
    }
    
    static {
        f39854 = new String[] { "SHA-256", "AES", "AES", "SHA-256", "AES", "AES" };
    }
}
