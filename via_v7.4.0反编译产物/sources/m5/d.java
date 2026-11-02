package m5;

import android.os.SystemClock;
import i5.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.Map;
import k5.o;
import k5.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements m5.a {

    /* renamed from: t, reason: collision with root package name */
    public static final String f8629t = "d";

    /* renamed from: e, reason: collision with root package name */
    public final g5.c f8630e;

    /* renamed from: j, reason: collision with root package name */
    public final g5.a f8631j;

    /* renamed from: k, reason: collision with root package name */
    public final h5.c f8632k;

    /* renamed from: l, reason: collision with root package name */
    public final o f8633l;

    /* renamed from: m, reason: collision with root package name */
    public final p f8634m;

    /* renamed from: p, reason: collision with root package name */
    public long f8637p;

    /* renamed from: q, reason: collision with root package name */
    public long f8638q;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8635n = false;

    /* renamed from: o, reason: collision with root package name */
    public HttpURLConnection f8636o = null;

    /* renamed from: r, reason: collision with root package name */
    public long f8639r = 0;

    /* renamed from: s, reason: collision with root package name */
    public long f8640s = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f8641a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h[] f8642b;

        public a(boolean z10, h[] hVarArr) {
            this.f8641a = z10;
            this.f8642b = hVarArr;
        }

        @Override // i5.b.a
        public void a() {
            this.f8642b[0] = h.f(25);
        }

        @Override // i5.b.a
        public void b(String str, boolean z10) {
        }

        @Override // i5.b.a
        public void c(HttpURLConnection httpURLConnection, int i10, String str) {
            if (i10 != 200) {
                if (i10 != 206) {
                    this.f8642b[0] = h.i(i10, str);
                    return;
                } else {
                    this.f8642b[0] = d.this.j(httpURLConnection);
                    return;
                }
            }
            if (!this.f8641a) {
                this.f8642b[0] = d.this.j(httpURLConnection);
            } else {
                d5.a.d(d.f8629t, "Can not resume");
                this.f8642b[0] = h.f(24);
            }
        }

        @Override // i5.b.a
        public void d(HttpURLConnection httpURLConnection) {
            d.this.e(httpURLConnection, this.f8641a);
        }

        @Override // i5.b.a
        public void e(IOException iOException) {
            d5.a.c(d.f8629t, iOException.getMessage(), iOException);
            if (iOException instanceof InterruptedIOException) {
                this.f8642b[0] = h.h(1, iOException);
            } else if (iOException instanceof UnknownHostException) {
                this.f8642b[0] = h.h(21, iOException);
            } else {
                this.f8642b[0] = h.h(20, iOException);
            }
        }
    }

    public d(g5.c cVar, g5.a aVar, o oVar, p pVar, h5.c cVar2) {
        this.f8630e = cVar;
        this.f8631j = aVar;
        this.f8633l = oVar;
        this.f8634m = pVar;
        this.f8632k = cVar2;
    }

    @Override // m5.a
    public void a() {
        this.f8635n = true;
    }

    public final void e(HttpURLConnection httpURLConnection, boolean z10) {
        String str = null;
        if (this.f8630e.i() != null && this.f8630e.i().size() > 0) {
            for (Map.Entry entry : this.f8630e.i().entrySet()) {
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
        if (this.f8631j.e() > 0) {
            httpURLConnection.addRequestProperty("Range", "bytes=" + this.f8631j.a() + "-" + this.f8631j.c());
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public g call() throws Throwable {
        h hVarG;
        if (this.f8631j.e() > 0 && this.f8631j.b() == this.f8631j.e()) {
            return g.e(this.f8631j);
        }
        this.f8631j.m(0L);
        if (!this.f8630e.v()) {
            this.f8631j.i(0L);
        }
        this.f8640s = SystemClock.elapsedRealtime();
        this.f8639r = this.f8631j.b();
        this.f8637p = SystemClock.elapsedRealtime();
        this.f8638q = this.f8631j.b();
        HttpURLConnection httpURLConnection = this.f8636o;
        if (httpURLConnection != null) {
            hVarG = j(httpURLConnection);
            this.f8636o = null;
        } else {
            hVarG = g();
        }
        return hVarG != null ? g.d(this.f8631j, hVarG) : g.e(this.f8631j);
    }

    public final h g() throws Throwable {
        if (!this.f8634m.a()) {
            return h.f(32);
        }
        try {
            i5.b bVar = new i5.b(this.f8630e.t());
            h[] hVarArr = new h[1];
            bVar.b(new a(this.f8631j.b() > 0, hVarArr));
            bVar.run();
            return hVarArr[0];
        } catch (MalformedURLException e10) {
            return h.h(21, e10);
        } catch (GeneralSecurityException e11) {
            return h.h(22, e11);
        }
    }

    public final boolean h() {
        return this.f8635n || Thread.currentThread().isInterrupted();
    }

    public final h i(InputStream inputStream, k5.c cVar) throws IOException {
        byte[] bArr = new byte[4096];
        try {
            cVar.c(this.f8631j.f() + this.f8631j.b());
            while (!h()) {
                try {
                    int i10 = inputStream.read(bArr, 0, 4096);
                    if (i10 != -1) {
                        try {
                            cVar.write(bArr, 0, i10);
                            g5.a aVar = this.f8631j;
                            aVar.i(aVar.b() + i10);
                            h hVarK = k(cVar, false);
                            if (hVarK != null) {
                                return hVarK;
                            }
                            if (this.f8631j.e() <= 0 || this.f8631j.b() < this.f8631j.e()) {
                            }
                        } catch (IOException e10) {
                            d5.a.c(f8629t, e10.getMessage(), e10);
                            return h.h(12, e10);
                        }
                    }
                    try {
                        k(cVar, true);
                        if (this.f8631j.e() <= 0 || Math.abs(this.f8631j.b() - this.f8631j.e()) <= 1) {
                            return null;
                        }
                        return h.f(31);
                    } catch (IOException e11) {
                        d5.a.c(f8629t, e11.getMessage(), e11);
                        return h.h(12, e11);
                    }
                } catch (IOException e12) {
                    d5.a.c(f8629t, e12.getMessage(), e12);
                    return h.h(20, e12);
                }
            }
            return h.f(1);
        } catch (IOException | IllegalAccessException e13) {
            d5.a.c(f8629t, e13.getMessage(), e13);
            return h.f(12);
        }
    }

    public final h j(HttpURLConnection httpURLConnection) throws Throwable {
        k5.c cVar;
        long j10;
        if (h()) {
            return h.f(1);
        }
        boolean z10 = (((this.f8631j.e() > 0L ? 1 : (this.f8631j.e() == 0L ? 0 : -1)) > 0) || "close".equalsIgnoreCase(httpURLConnection.getHeaderField("Connection")) || "chunked".equalsIgnoreCase(httpURLConnection.getHeaderField("Transfer-Encoding"))) ? false : true;
        try {
            j10 = Long.parseLong(httpURLConnection.getHeaderField("Content-Length"));
        } catch (NumberFormatException e10) {
            if (z10) {
                d5.a.c(f8629t, e10.getMessage(), e10);
                return h.f(24);
            }
        }
        if (this.f8631j.e() > 0 && j10 > this.f8631j.e()) {
            return h.f(24);
        }
        if (z10 && j10 > 0 && this.f8631j.f() == 0) {
            this.f8631j.k(j10);
        } else if (z10) {
            d5.a.d(f8629t, "Can not get content length");
            return h.f(24);
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    try {
                        k5.c cVarA = this.f8633l.a(this.f8630e.g());
                        h hVarI = i(inputStream2, cVarA);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (cVarA != null) {
                            cVarA.close();
                        }
                        return hVarI;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        cVar = null;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                                throw th;
                            }
                        }
                        if (cVar != null) {
                            cVar.close();
                        }
                        throw th;
                    }
                } catch (IOException | IllegalArgumentException e11) {
                    d5.a.c(f8629t, e11.getMessage(), e11);
                    h hVarH = h.h(12, e11);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return hVarH;
                }
            } catch (Throwable th2) {
                th = th2;
                cVar = null;
            }
        } catch (SocketTimeoutException e12) {
            d5.a.c(f8629t, e12.getMessage(), e12);
            return h.f(23);
        } catch (IOException e13) {
            d5.a.c(f8629t, e13.getMessage(), e13);
            return h.h(20, e13);
        }
    }

    public final h k(k5.c cVar, boolean z10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jB = this.f8631j.b();
        long j10 = jElapsedRealtime - this.f8637p;
        if (j10 > 500) {
            long jG = ((jB - this.f8638q) * 1000) / j10;
            g5.a aVar = this.f8631j;
            if (aVar.g() != 0) {
                jG = ((this.f8631j.g() * 3) + jG) / 4;
            }
            aVar.m(jG);
            this.f8637p = jElapsedRealtime;
            this.f8638q = jB;
        }
        if (jElapsedRealtime - this.f8640s <= 1000 && !z10) {
            return null;
        }
        if (jB != this.f8639r) {
            cVar.b();
        }
        this.f8639r = jB;
        this.f8640s = jElapsedRealtime;
        h5.c cVar2 = this.f8632k;
        g5.c cVar3 = this.f8630e;
        g5.a aVar2 = this.f8631j;
        cVar2.a(cVar3, aVar2, aVar2.b(), this.f8631j.e());
        return null;
    }
}
