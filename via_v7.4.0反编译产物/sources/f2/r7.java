package f2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final URL f5655e;

    /* renamed from: j, reason: collision with root package name */
    public final String f5656j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ s7 f5657k;

    /* renamed from: l, reason: collision with root package name */
    public final f5 f5658l;

    public r7(s7 s7Var, String str, URL url, byte[] bArr, Map map, f5 f5Var) {
        this.f5657k = s7Var;
        t1.f.d(str);
        t1.f.h(url);
        t1.f.h(f5Var);
        this.f5655e = url;
        this.f5658l = f5Var;
        this.f5656j = str;
    }

    public final /* synthetic */ void a(int i10, Exception exc, byte[] bArr, Map map) {
        f5 f5Var = this.f5658l;
        f5Var.f5177a.h(this.f5656j, i10, exc, bArr, map);
    }

    public final void b(final int i10, final Exception exc, final byte[] bArr, final Map map) {
        this.f5657k.f5030a.f().z(new Runnable() { // from class: f2.q7
            @Override // java.lang.Runnable
            public final void run() {
                this.f5635e.a(i10, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
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
    /* JADX WARN: Type inference failed for: r9v0, types: [f2.r7] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        ?? r42;
        ?? r43;
        Throwable th;
        int responseCode;
        IOException e10;
        InputStream inputStream;
        this.f5657k.g();
        try {
            s7 s7Var = this.f5657k;
            URLConnection uRLConnectionOpenConnection = this.f5655e.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            s7Var.f5030a.z();
            r42 = 60000;
            r43 = 60000;
            httpURLConnection.setConnectTimeout(60000);
            s7Var.f5030a.z();
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
                        r43 = 0;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        b(responseCode, e10, null, r43);
                    } catch (Throwable th4) {
                        th = th4;
                        r42 = 0;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        b(responseCode, null, null, r42);
                        throw th;
                    }
                } catch (IOException e12) {
                    e10 = e12;
                    if (httpURLConnection != null) {
                    }
                    b(responseCode, e10, null, r43);
                } catch (Throwable th5) {
                    th = th5;
                    if (httpURLConnection != null) {
                    }
                    b(responseCode, null, null, r42);
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
                r43 = 0;
                e10 = e;
                responseCode = 0;
                if (httpURLConnection != null) {
                }
                b(responseCode, e10, null, r43);
            } catch (Throwable th6) {
                th = th6;
                r42 = 0;
                th = th;
                responseCode = 0;
                if (httpURLConnection != null) {
                }
                b(responseCode, null, null, r42);
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            httpURLConnection = null;
            r43 = 0;
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
            r42 = 0;
        }
    }
}
