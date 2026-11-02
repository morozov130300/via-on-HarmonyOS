package f2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a4 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final URL f5022e;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f5023j;

    /* renamed from: k, reason: collision with root package name */
    public final x3 f5024k;

    /* renamed from: l, reason: collision with root package name */
    public final String f5025l;

    /* renamed from: m, reason: collision with root package name */
    public final Map f5026m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b4 f5027n;

    public a4(b4 b4Var, String str, URL url, byte[] bArr, Map map, x3 x3Var) {
        this.f5027n = b4Var;
        t1.f.d(str);
        t1.f.h(url);
        t1.f.h(x3Var);
        this.f5022e = url;
        this.f5023j = bArr;
        this.f5024k = x3Var;
        this.f5025l = str;
        this.f5026m = map;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0108: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:52:0x0106 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x010b: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:53:0x010a */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        Map map2;
        int i10;
        int i11;
        int responseCode;
        Map map3;
        Map map4;
        InputStream inputStream;
        this.f5027n.g();
        OutputStream outputStream = null;
        try {
            b4 b4Var = this.f5027n;
            URLConnection uRLConnectionOpenConnection = this.f5022e.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            b4Var.f5030a.z();
            httpURLConnection.setConnectTimeout(60000);
            b4Var.f5030a.z();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map map5 = this.f5026m;
                if (map5 != null) {
                    for (Map.Entry entry : map5.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f5023j != null) {
                    byte[] bArrQ = this.f5027n.f5039b.g0().Q(this.f5023j);
                    t3 t3VarV = this.f5027n.f5030a.d().v();
                    int length = bArrQ.length;
                    t3VarV.b("Uploading data. size", Integer.valueOf(length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArrQ);
                        outputStream2.close();
                    } catch (IOException e10) {
                        iOException = e10;
                        map2 = null;
                        outputStream = outputStream2;
                        i11 = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, i11, iOException, null, map2, null));
                    } catch (Throwable th2) {
                        th = th2;
                        map = null;
                        outputStream = outputStream2;
                        i10 = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, i10, null, null, map, null));
                        throw th;
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
            } catch (IOException e11) {
                iOException = e11;
                map2 = null;
            } catch (Throwable th3) {
                th = th3;
                map = null;
            }
            try {
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i12 = inputStream.read(bArr);
                                if (i12 <= 0) {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    inputStream.close();
                                    httpURLConnection.disconnect();
                                    this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, responseCode, null, byteArray, headerFields, null));
                                    return;
                                }
                                byteArrayOutputStream.write(bArr, 0, i12);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                } catch (IOException e12) {
                    e = e12;
                    map2 = null;
                    i11 = responseCode;
                    iOException = e;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e13) {
                            this.f5027n.f5030a.d().r().c("Error closing HTTP compressed POST connection output stream. appId", v3.z(this.f5025l), e13);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, i11, iOException, null, map2, null));
                } catch (Throwable th6) {
                    th = th6;
                    map = null;
                    i10 = responseCode;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e14) {
                            this.f5027n.f5030a.d().r().c("Error closing HTTP compressed POST connection output stream. appId", v3.z(this.f5025l), e14);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, i10, null, null, map, null));
                    throw th;
                }
            } catch (IOException e15) {
                e = e15;
                i11 = responseCode;
                map2 = map4;
                iOException = e;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, i11, iOException, null, map2, null));
            } catch (Throwable th7) {
                th = th7;
                i10 = responseCode;
                map = map3;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.f5027n.f5030a.f().z(new z3(this.f5025l, this.f5024k, i10, null, null, map, null));
                throw th;
            }
        } catch (IOException e16) {
            iOException = e16;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
            map = null;
        }
    }
}
