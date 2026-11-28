package m5;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.concurrent.Executor;
import k5.o;
import k5.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements m5.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7879x = "d";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f7880c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g5.c f7881e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g5.a f7882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h5.c f7883n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o f7884o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p f7885p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile i5.b f7887r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f7889t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f7890u;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f7886q = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HttpURLConnection f7888s = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f7891v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f7892w = 0;

    public d(Executor executor, g5.c cVar, g5.a aVar, o oVar, p pVar, h5.c cVar2) {
        this.f7880c = executor;
        this.f7881e = cVar;
        this.f7882m = aVar;
        this.f7884o = oVar;
        this.f7885p = pVar;
        this.f7883n = cVar2;
    }

    @Override // m5.a
    public void a() {
        this.f7886q = true;
        i5.b bVar = this.f7887r;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void g(HttpURLConnection httpURLConnection, boolean z10) {
        String str = null;
        if (this.f7881e.i() != null && this.f7881e.i().size() > 0) {
            for (Map.Entry entry : this.f7881e.i().entrySet()) {
                if ("ETag".equalsIgnoreCase((String) entry.getKey())) {
                    str = (String) entry.getValue();
                } else if (!"Referer".equalsIgnoreCase((String) entry.getKey()) || entry.getValue() == null) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                } else {
                    httpURLConnection.setRequestProperty("Referer", (String) entry.getValue());
                }
            }
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (z10 && str != null) {
            httpURLConnection.addRequestProperty("If-Match", str);
        }
        if (this.f7882m.e() > 0) {
            httpURLConnection.addRequestProperty("Range", "bytes=" + this.f7882m.a() + "-" + this.f7882m.c());
        }
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public g call() throws Throwable {
        h hVarI;
        if (this.f7882m.e() > 0 && this.f7882m.b() == this.f7882m.e()) {
            return g.e(this.f7882m);
        }
        this.f7882m.m(0L);
        if (!this.f7881e.v()) {
            this.f7882m.i(0L);
        }
        this.f7892w = SystemClock.elapsedRealtime();
        this.f7891v = this.f7882m.b();
        this.f7889t = SystemClock.elapsedRealtime();
        this.f7890u = this.f7882m.b();
        HttpURLConnection httpURLConnection = this.f7888s;
        if (httpURLConnection != null) {
            hVarI = n(httpURLConnection);
            this.f7888s = null;
        } else {
            hVarI = i();
        }
        return hVarI != null ? g.d(this.f7882m, hVarI) : g.e(this.f7882m);
    }

    public final h i() {
        if (!this.f7885p.a()) {
            return h.f(32);
        }
        try {
            i5.b bVar = new i5.b(this.f7881e.t(), this.f7880c);
            h[] hVarArr = new h[1];
            bVar.c(new a(this.f7882m.b() > 0, hVarArr));
            this.f7887r = bVar;
            try {
                if (l()) {
                    bVar.a();
                }
                bVar.run();
                return hVarArr[0];
            } finally {
                this.f7887r = null;
            }
        } catch (MalformedURLException e10) {
            return h.h(21, e10);
        } catch (GeneralSecurityException e11) {
            return h.h(22, e11);
        }
    }

    public final h j(IOException iOException) {
        d5.a.c(f7879x, iOException.getMessage(), iOException);
        if (l()) {
            return h.h(1, iOException);
        }
        if (iOException instanceof SocketTimeoutException) {
            return h.h(23, iOException);
        }
        return iOException instanceof InterruptedIOException ? h.h(1, iOException) : h.h(20, iOException);
    }

    public final boolean k(String str) {
        char cCharAt;
        if (str != null && str.regionMatches(true, 0, "bytes ", 0, 6)) {
            int iIndexOf = str.indexOf(45, 6);
            int i10 = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(47, i10);
            if (iIndexOf > 6 && iIndexOf2 > i10 && iIndexOf2 != str.length() - 1) {
                int i11 = iIndexOf2 + 1;
                boolean zEquals = "*".equals(str.substring(i11));
                for (int i12 = 6; i12 < str.length(); i12++) {
                    if (i12 != iIndexOf && i12 != iIndexOf2 && ((!zEquals || i12 != i11) && ((cCharAt = str.charAt(i12)) < '0' || cCharAt > '9'))) {
                        return false;
                    }
                }
                try {
                    long j10 = Long.parseLong(str.substring(6, iIndexOf));
                    long j11 = Long.parseLong(str.substring(i10, iIndexOf2));
                    if (j10 == this.f7882m.a() && j11 >= j10 && ((this.f7882m.e() <= 0 || j11 <= this.f7882m.c()) && (zEquals || Long.parseLong(str.substring(i11)) > j11))) {
                        return true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    public final boolean l() {
        return this.f7886q || Thread.currentThread().isInterrupted();
    }

    public final h m(InputStream inputStream, k5.c cVar) {
        byte[] bArr = new byte[4096];
        try {
            cVar.c(this.f7882m.f() + this.f7882m.b());
            while (!l()) {
                try {
                    int i10 = inputStream.read(bArr, 0, 4096);
                    if (i10 != -1) {
                        try {
                            cVar.write(bArr, 0, i10);
                            g5.a aVar = this.f7882m;
                            aVar.i(aVar.b() + ((long) i10));
                            h hVarO = o(cVar, false);
                            if (hVarO != null) {
                                return hVarO;
                            }
                            if (this.f7882m.e() <= 0 || this.f7882m.b() < this.f7882m.e()) {
                            }
                        } catch (IOException e10) {
                            d5.a.c(f7879x, e10.getMessage(), e10);
                            return h.h(12, e10);
                        }
                    }
                    try {
                        o(cVar, true);
                        if (this.f7882m.e() <= 0 || Math.abs(this.f7882m.b() - this.f7882m.e()) <= 1) {
                            return null;
                        }
                        return h.f(31);
                    } catch (IOException e11) {
                        d5.a.c(f7879x, e11.getMessage(), e11);
                        return h.h(12, e11);
                    }
                } catch (IOException e12) {
                    return j(e12);
                }
            }
            return h.f(1);
        } catch (IOException | IllegalAccessException e13) {
            d5.a.c(f7879x, e13.getMessage(), e13);
            return h.f(12);
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    public final h n(HttpURLConnection httpURLConnection) throws Throwable {
        k5.c cVar;
        if (l()) {
            return h.f(1);
        }
        boolean z10 = (((this.f7882m.e() > 0L ? 1 : (this.f7882m.e() == 0L ? 0 : -1)) > 0) || "close".equalsIgnoreCase(httpURLConnection.getHeaderField("Connection")) || "chunked".equalsIgnoreCase(httpURLConnection.getHeaderField("Transfer-Encoding"))) ? false : true;
        try {
            long j10 = Long.parseLong(httpURLConnection.getHeaderField("Content-Length"));
            if (this.f7882m.e() > 0 && j10 > this.f7882m.e()) {
                return h.f(24);
            }
            if (z10 && j10 > 0 && this.f7882m.f() == 0) {
                this.f7882m.k(j10);
            } else if (z10) {
                d5.a.d(f7879x, "Can not get content length");
                return h.f(24);
            }
            ?? r10 = 0;
            try {
                try {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            k5.c cVarA = this.f7884o.a(this.f7881e.g());
                            h hVarM = m(inputStream, cVarA);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e10) {
                                    d5.a.c(f7879x, e10.getMessage(), e10);
                                }
                            }
                            if (cVarA != null) {
                                try {
                                    cVarA.close();
                                } catch (IOException e11) {
                                    d5.a.c(f7879x, e11.getMessage(), e11);
                                }
                            }
                            return hVarM;
                        } catch (IOException | IllegalArgumentException e12) {
                            d5.a.c(f7879x, e12.getMessage(), e12);
                            h hVarH = h.h(12, e12);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e13) {
                                    d5.a.c(f7879x, e13.getMessage(), e13);
                                }
                            }
                            return hVarH;
                        }
                    } catch (IOException e14) {
                        return j(e14);
                    }
                } catch (Throwable th) {
                    th = th;
                    cVar = null;
                    if (r10 != 0) {
                        try {
                            r10.close();
                        } catch (IOException e15) {
                            d5.a.c(f7879x, e15.getMessage(), e15);
                        }
                    }
                    if (cVar != null) {
                        throw th;
                    }
                    try {
                        cVar.close();
                        throw th;
                    } catch (IOException e16) {
                        d5.a.c(f7879x, e16.getMessage(), e16);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r10 = httpURLConnection;
                cVar = null;
                if (r10 != 0) {
                    r10.close();
                }
                if (cVar != null) {
                    throw th;
                }
                cVar.close();
                throw th;
            }
        } catch (NumberFormatException e17) {
            if (z10) {
                d5.a.c(f7879x, e17.getMessage(), e17);
                return h.f(24);
            }
        }
    }

    public final h o(k5.c cVar, boolean z10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jB = this.f7882m.b();
        long j10 = jElapsedRealtime - this.f7889t;
        if (j10 > 500) {
            long jG = ((jB - this.f7890u) * 1000) / j10;
            g5.a aVar = this.f7882m;
            if (aVar.g() != 0) {
                jG = ((this.f7882m.g() * 3) + jG) / 4;
            }
            aVar.m(jG);
            this.f7889t = jElapsedRealtime;
            this.f7890u = jB;
        }
        if (jElapsedRealtime - this.f7892w <= 1000 && !z10) {
            return null;
        }
        if (jB != this.f7891v) {
            cVar.b();
        }
        this.f7891v = jB;
        this.f7892w = jElapsedRealtime;
        h5.c cVar2 = this.f7883n;
        g5.c cVar3 = this.f7881e;
        g5.a aVar2 = this.f7882m;
        cVar2.a(cVar3, aVar2, aVar2.b(), this.f7882m.e());
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements i5.b.InterfaceC0075b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h[] f7894b;

        public a(boolean z10, h[] hVarArr) {
            this.f7893a = z10;
            this.f7894b = hVarArr;
        }

        @Override // i5.b.InterfaceC0075b
        public void a() {
            this.f7894b[0] = h.f(25);
        }

        @Override // i5.b.InterfaceC0075b
        public void c(HttpURLConnection httpURLConnection, int i10, String str) {
            if (i10 == 200) {
                if (!this.f7893a) {
                    this.f7894b[0] = d.this.n(httpURLConnection);
                    return;
                } else {
                    d5.a.d(d.f7879x, "Can not resume");
                    this.f7894b[0] = h.f(24);
                    return;
                }
            }
            if (i10 != 206) {
                this.f7894b[0] = h.i(i10, str);
            } else if (d.this.k(httpURLConnection.getHeaderField("Content-Range"))) {
                this.f7894b[0] = d.this.n(httpURLConnection);
            } else {
                this.f7894b[0] = h.f(24);
            }
        }

        @Override // i5.b.InterfaceC0075b
        public void d(HttpURLConnection httpURLConnection) {
            d.this.g(httpURLConnection, this.f7893a);
        }

        @Override // i5.b.InterfaceC0075b
        public void e(IOException iOException) {
            d5.a.c(d.f7879x, iOException.getMessage(), iOException);
            if (d.this.l()) {
                this.f7894b[0] = h.h(1, iOException);
                return;
            }
            if (iOException instanceof SocketTimeoutException) {
                this.f7894b[0] = h.h(23, iOException);
                return;
            }
            if (iOException instanceof InterruptedIOException) {
                this.f7894b[0] = h.h(1, iOException);
            } else if (iOException instanceof UnknownHostException) {
                this.f7894b[0] = h.h(21, iOException);
            } else {
                this.f7894b[0] = h.h(20, iOException);
            }
        }

        @Override // i5.b.InterfaceC0075b
        public void b(String str, boolean z10) {
        }
    }
}
