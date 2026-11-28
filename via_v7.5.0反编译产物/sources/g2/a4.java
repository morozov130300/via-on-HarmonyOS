package g2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a4 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f4638c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f4639e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final x3 f4640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f4641n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f4642o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b4 f4643p;

    public a4(b4 b4Var, String str, URL url, byte[] bArr, Map map, x3 x3Var) {
        this.f4643p = b4Var;
        u1.f.d(str);
        u1.f.h(url);
        u1.f.h(x3Var);
        this.f4638c = url;
        this.f4639e = bArr;
        this.f4640m = x3Var;
        this.f4641n = str;
        this.f4642o = map;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x014c  */
    /* JADX WARN: Code duplicated, block: B:84:0x018a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0108: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:265), block:B:52:0x0106 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x010b: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:268), block:B:53:0x010a */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        Map map2;
        int i10;
        int responseCode;
        Map map3;
        Map map4;
        InputStream inputStream;
        this.f4643p.g();
        OutputStream outputStream = null;
        try {
            b4 b4Var = this.f4643p;
            URLConnection uRLConnectionOpenConnection = this.f4638c.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setDefaultUseCaches(false);
            b4Var.f4646a.z();
            httpURLConnection.setConnectTimeout(60000);
            b4Var.f4646a.z();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map map5 = this.f4642o;
                if (map5 != null) {
                    for (Map.Entry entry : map5.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f4639e != null) {
                    byte[] bArrQ = this.f4643p.f4655b.g0().Q(this.f4639e);
                    t3 t3VarV = this.f4643p.f4646a.d().v();
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
                        responseCode = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e11) {
                                this.f4643p.f4646a.d().r().c("Error closing HTTP compressed POST connection output stream. appId", v3.z(this.f4641n), e11);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, responseCode, iOException, null, map2, null));
                    } catch (Throwable th2) {
                        th = th2;
                        map = null;
                        outputStream = outputStream2;
                        i10 = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e12) {
                                this.f4643p.f4646a.d().r().c("Error closing HTTP compressed POST connection output stream. appId", v3.z(this.f4641n), e12);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, i10, null, null, map, null));
                        throw th;
                    }
                }
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
                                    int i11 = inputStream.read(bArr);
                                    if (i11 <= 0) {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        inputStream.close();
                                        httpURLConnection.disconnect();
                                        this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, responseCode, null, byteArray, headerFields, null));
                                        return;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i11);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                        }
                    } catch (IOException e13) {
                        e = e13;
                        map2 = null;
                        iOException = e;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, responseCode, iOException, null, map2, null));
                    } catch (Throwable th5) {
                        th = th5;
                        map = null;
                        i10 = responseCode;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, i10, null, null, map, null));
                        throw th;
                    }
                } catch (IOException e14) {
                    e = e14;
                    map2 = map4;
                    iOException = e;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, responseCode, iOException, null, map2, null));
                } catch (Throwable th6) {
                    th = th6;
                    i10 = responseCode;
                    map = map3;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f4643p.f4646a.f().z(new z3(this.f4641n, this.f4640m, i10, null, null, map, null));
                    throw th;
                }
            } catch (IOException e15) {
                iOException = e15;
                map2 = null;
            } catch (Throwable th7) {
                th = th7;
                map = null;
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
