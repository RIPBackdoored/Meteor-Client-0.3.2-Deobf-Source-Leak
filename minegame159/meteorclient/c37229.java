package minegame159.meteorclient;

import com.google.gson.*;
import java.net.*;
import java.util.function.*;
import java.io.*;
import java.lang.reflect.*;

public class c37229
{
    private static final String[] f37230;
    private static final Gson f37231;
    
    public c37229() {
        super();
    }
    
    public static InputStream m37232(final String s) {
        try {
            final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(s).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(2500);
            httpURLConnection.setReadTimeout(2500);
            return httpURLConnection.getInputStream();
        }
        catch (SocketTimeoutException ex2) {
            return null;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void m37237(final String s, final Consumer<String> consumer) {
        try {
            final InputStream m37232 = m37232(s);
            if (m37232 == null) {
                return;
            }
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(m37232));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                consumer.accept(line);
            }
            bufferedReader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static <T> T m37244(final String s, final Type typeOfT) {
        try {
            final InputStream m37232 = m37232(s);
            if (m37232 == null) {
                return null;
            }
            final BufferedReader json = new BufferedReader(new InputStreamReader(m37232));
            final Object fromJson = c37229.f37231.fromJson(json, typeOfT);
            json.close();
            return (T)fromJson;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    static {
        f37230 = new String[] { "GET" };
        f37231 = new Gson();
    }
}
