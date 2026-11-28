package g2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f5271c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5272e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ s7 f5273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f5 f5274n;

    public r7(s7 s7Var, String str, URL url, byte[] bArr, Map map, f5 f5Var) {
        this.f5273m = s7Var;
        u1.f.d(str);
        u1.f.h(url);
        u1.f.h(f5Var);
        this.f5271c = url;
        this.f5274n = f5Var;
        this.f5272e = str;
    }

    public final /* synthetic */ void a(int i10, Exception exc, byte[] bArr, Map map) {
        f5 f5Var = this.f5274n;
        f5Var.f4793a.h(this.f5272e, i10, exc, bArr, map);
    }

    public final void b(final int i10, final Exception exc, final byte[] bArr, final Map map) {
        this.f5273m.f4646a.f().z(new Runnable() { // from class: g2.q7
            @Override // java.lang.Runnable
            public final void run() {
                this.f5251c.a(i10, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [g2.r7] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        ?? r10;
        ?? r11;
        Throwable th;
        int responseCode;
        IOException e10;
        InputStream inputStream;
        this.f5273m.g();
        try {
            s7 s7Var = this.f5273m;
            URLConnection uRLConnectionOpenConnection = this.f5271c.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            s7Var.f4646a.z();
            r10 = 60000;
            r11 = 60000;
            httpURLConnection.setConnectTimeout(60000);
            s7Var.f4646a.z();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                responseCode = httpURLConnection.getResponseCode();
                try {
                    try {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i10 = inputStream.read(bArr);
                                    if (i10 <= 0) {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        inputStream.close();
                                        httpURLConnection.disconnect();
                                        b(responseCode, null, byteArray, headerFields);
                                        return;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i10);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                    } catch (IOException e11) {
                        e10 = e11;
                        r11 = 0;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        b(responseCode, e10, null, r11);
                    } catch (Throwable th4) {
                        th = th4;
                        r10 = 0;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        b(responseCode, null, null, r10);
                        throw th;
                    }
                } catch (IOException e12) {
                    e10 = e12;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(responseCode, e10, null, r11);
                } catch (Throwable th5) {
                    th = th5;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    b(responseCode, null, null, r10);
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
                r11 = 0;
                e10 = e;
                responseCode = 0;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                b(responseCode, e10, null, r11);
            } catch (Throwable th6) {
                th = th6;
                r10 = 0;
                th = th;
                responseCode = 0;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                b(responseCode, null, null, r10);
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            httpURLConnection = null;
            r11 = 0;
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
            r10 = 0;
        }
    }
}
