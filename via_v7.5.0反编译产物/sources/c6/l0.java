package c6;

import com.tuyafeng.wormhole.HttpTextEncoding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f2064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile HttpURLConnection f2065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j0 f2066c;

        public a(j0 j0Var) {
            this.f2066c = j0Var;
        }

        @Override // c6.i0
        public k0 c() {
            String strC;
            if (this.f2064a) {
                return null;
            }
            try {
                URLConnection uRLConnectionOpenConnection = new URL(this.f2066c.f()).openConnection();
                HttpURLConnection httpURLConnection = uRLConnectionOpenConnection instanceof HttpURLConnection ? (HttpURLConnection) uRLConnectionOpenConnection : null;
                if (httpURLConnection == null) {
                    HttpURLConnection httpURLConnection2 = this.f2065b;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    this.f2065b = null;
                    return null;
                }
                this.f2065b = httpURLConnection;
                if (this.f2064a) {
                    HttpURLConnection httpURLConnection3 = this.f2065b;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    this.f2065b = null;
                    return null;
                }
                httpURLConnection.setConnectTimeout(this.f2066c.e());
                httpURLConnection.setReadTimeout(this.f2066c.e());
                httpURLConnection.setRequestMethod(this.f2066c.c());
                for (Map.Entry entry : this.f2066c.b().entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                String strG = this.f2066c.g();
                if (strG != null) {
                    httpURLConnection.setRequestProperty("User-Agent", strG);
                }
                String strA = this.f2066c.a();
                if (strA != null) {
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        byte[] bytes = strA.getBytes(kotlin.text.c.f7329b);
                        kotlin.jvm.internal.h.e(bytes, "getBytes(...)");
                        outputStream.write(bytes);
                        d7.h hVar = d7.h.f3935a;
                        n7.a.a(outputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            n7.a.a(outputStream, th);
                            throw th2;
                        }
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                InputStream errorStream = responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                Charset charsetForName = this.f2066c.d() == HttpTextEncoding.GB2312 ? Charset.forName("GB2312") : kotlin.text.c.f7329b;
                if (errorStream != null) {
                    kotlin.jvm.internal.h.c(charsetForName);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, charsetForName), 8192);
                    try {
                        strC = n7.b.c(bufferedReader);
                        n7.a.a(bufferedReader, null);
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            n7.a.a(bufferedReader, th3);
                            throw th4;
                        }
                    }
                } else {
                    strC = null;
                }
                k0 k0Var = this.f2064a ? null : new k0(responseCode, strC);
                HttpURLConnection httpURLConnection4 = this.f2065b;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
                this.f2065b = null;
                return k0Var;
            } catch (IOException unused) {
                HttpURLConnection httpURLConnection5 = this.f2065b;
                if (httpURLConnection5 != null) {
                    httpURLConnection5.disconnect();
                }
                this.f2065b = null;
                return null;
            } catch (Throwable th5) {
                HttpURLConnection httpURLConnection6 = this.f2065b;
                if (httpURLConnection6 != null) {
                    httpURLConnection6.disconnect();
                }
                this.f2065b = null;
                throw th5;
            }
        }
    }

    public static final i0 a(j0 request) {
        kotlin.jvm.internal.h.f(request, "request");
        return new a(request);
    }
}
