package minegame159.meteorclient;

import java.nio.charset.*;
import javax.crypto.spec.*;
import javax.crypto.*;
import java.security.*;
import java.util.*;

public class c40144
{
    public c40144() {
        super();
    }
    
    public static String m40145(final String s, final String s2) {
        try {
            final SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-256").digest(s2.getBytes(StandardCharsets.UTF_8)), 16), "AES");
            final Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
