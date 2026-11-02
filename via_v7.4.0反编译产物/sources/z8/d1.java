package z8;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d1 {
    public static String a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        g6.j.a(gZIPOutputStream);
        return new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0), m8.a.f8676a).trim();
    }

    public static String b(String str) throws Throwable {
        GZIPInputStream gZIPInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        Reader inputStreamReader;
        if (str == null || str.isEmpty()) {
            throw new IOException("Compressed string is empty");
        }
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
            bufferedReader = null;
        }
        try {
            inputStreamReader = new InputStreamReader(gZIPInputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            String strTrim = sb2.toString().trim();
                            g6.j.a(gZIPInputStream);
                            g6.j.a(inputStreamReader);
                            g6.j.a(bufferedReader);
                            return strTrim;
                        }
                        sb2.append(line);
                        sb2.append("\n");
                    }
                } catch (Throwable th3) {
                    th = th3;
                    g6.j.a(gZIPInputStream);
                    g6.j.a(inputStreamReader);
                    g6.j.a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            th = th;
            inputStreamReader = bufferedReader;
            g6.j.a(gZIPInputStream);
            g6.j.a(inputStreamReader);
            g6.j.a(bufferedReader);
            throw th;
        }
    }
}
