package z8;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h2 {
    public static void a(String str, String str2, int i10, String str3) throws Throwable {
        String string;
        HttpURLConnection httpURLConnection;
        if (str == null || str.isEmpty()) {
            return;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("reason", i10);
                if (str2 != null && !str2.isEmpty()) {
                    jSONObject.put("title", str2);
                }
                if (str3 != null && !str3.isEmpty()) {
                    jSONObject.put("note", str3);
                }
                jSONObject.put("locale", t1.g());
                string = jSONObject.toString();
                httpURLConnection = (HttpURLConnection) new URL("https://ra.viayoo.com/report_abuse").openConnection();
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Authorization", "Bearer tk_o4s4ghe1tqu60mj0ljy5im762ebrr");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(string.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    pc.a.h("send report failed: %d, message: %s", Integer.valueOf(responseCode), httpURLConnection.getResponseMessage());
                }
                httpURLConnection.disconnect();
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (Exception e11) {
            e = e11;
            httpURLConnection2 = httpURLConnection;
            pc.a.b(e);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
