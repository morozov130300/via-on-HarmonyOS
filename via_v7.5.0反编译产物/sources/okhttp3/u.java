package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u implements Cloneable {
    public static final List K = ub.c.u(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List L = ub.c.u(i.f11262h, i.f11264j);
    public final h A;
    public final n B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f11336c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Proxy f11337e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f11338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f11339n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f11340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f11341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o.c f11342q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ProxySelector f11343r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f11344s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SocketFactory f11345t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SSLSocketFactory f11346u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final cc.c f11347v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HostnameVerifier f11348w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f11349x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final okhttp3.b f11350y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final okhttp3.b f11351z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends ub.a {
        @Override // ub.a
        public void a(q.a aVar, String str) {
            aVar.b(str);
        }

        @Override // ub.a
        public void b(q.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        @Override // ub.a
        public void c(i iVar, SSLSocket sSLSocket, boolean z10) {
            iVar.a(sSLSocket, z10);
        }

        @Override // ub.a
        public int d(y.a aVar) {
            return aVar.f11418c;
        }

        @Override // ub.a
        public boolean e(h hVar, wb.c cVar) {
            return hVar.b(cVar);
        }

        @Override // ub.a
        public Socket f(h hVar, okhttp3.a aVar, wb.f fVar) {
            return hVar.c(aVar, fVar);
        }

        @Override // ub.a
        public boolean g(okhttp3.a aVar, okhttp3.a aVar2) {
            return aVar.d(aVar2);
        }

        @Override // ub.a
        public wb.c h(h hVar, okhttp3.a aVar, wb.f fVar, a0 a0Var) {
            return hVar.e(aVar, fVar, a0Var);
        }

        @Override // ub.a
        public void i(h hVar, wb.c cVar) {
            hVar.g(cVar);
        }

        @Override // ub.a
        public wb.d j(h hVar) {
            return hVar.f11256e;
        }

        @Override // ub.a
        public IOException k(d dVar, IOException iOException) {
            return ((v) dVar).i(iOException);
        }
    }

    static {
        ub.a.f12943a = new a();
    }

    public u(b bVar) {
        boolean z10;
        this.f11336c = bVar.f11352a;
        this.f11337e = bVar.f11353b;
        this.f11338m = bVar.f11354c;
        List list = bVar.f11355d;
        this.f11339n = list;
        this.f11340o = ub.c.t(bVar.f11356e);
        this.f11341p = ub.c.t(bVar.f11357f);
        this.f11342q = bVar.f11358g;
        this.f11343r = bVar.f11359h;
        this.f11344s = bVar.f11360i;
        this.f11345t = bVar.f11361j;
        Iterator it = list.iterator();
        loop0: while (true) {
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z10 = z10 || ((i) it.next()).d();
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f11362k;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager x509TrustManagerC = ub.c.C();
            this.f11346u = w(x509TrustManagerC);
            this.f11347v = cc.c.b(x509TrustManagerC);
        } else {
            this.f11346u = sSLSocketFactory;
            this.f11347v = bVar.f11363l;
        }
        if (this.f11346u != null) {
            ac.f.j().f(this.f11346u);
        }
        this.f11348w = bVar.f11364m;
        this.f11349x = bVar.f11365n.e(this.f11347v);
        this.f11350y = bVar.f11366o;
        this.f11351z = bVar.f11367p;
        this.A = bVar.f11368q;
        this.B = bVar.f11369r;
        this.C = bVar.f11370s;
        this.D = bVar.f11371t;
        this.E = bVar.f11372u;
        this.F = bVar.f11373v;
        this.G = bVar.f11374w;
        this.H = bVar.f11375x;
        this.I = bVar.f11376y;
        this.J = bVar.f11377z;
        if (this.f11340o.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f11340o);
        }
        if (this.f11341p.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f11341p);
        }
    }

    public static SSLSocketFactory w(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextK = ac.f.j().k();
            sSLContextK.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextK.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw ub.c.b("No System TLS", e10);
        }
    }

    public okhttp3.b A() {
        return this.f11350y;
    }

    public ProxySelector B() {
        return this.f11343r;
    }

    public int C() {
        return this.H;
    }

    public boolean D() {
        return this.E;
    }

    public SocketFactory E() {
        return this.f11345t;
    }

    public SSLSocketFactory F() {
        return this.f11346u;
    }

    public int G() {
        return this.I;
    }

    public okhttp3.b a() {
        return this.f11351z;
    }

    public int b() {
        return this.F;
    }

    public e d() {
        return this.f11349x;
    }

    public int e() {
        return this.G;
    }

    public h i() {
        return this.A;
    }

    public List j() {
        return this.f11339n;
    }

    public k k() {
        return this.f11344s;
    }

    public m l() {
        return this.f11336c;
    }

    public n m() {
        return this.B;
    }

    public o.c n() {
        return this.f11342q;
    }

    public boolean o() {
        return this.D;
    }

    public boolean p() {
        return this.C;
    }

    public HostnameVerifier q() {
        return this.f11348w;
    }

    public List r() {
        return this.f11340o;
    }

    public vb.c s() {
        return null;
    }

    public List t() {
        return this.f11341p;
    }

    public b u() {
        return new b(this);
    }

    public d v(w wVar) {
        return v.e(this, wVar, false);
    }

    public int x() {
        return this.J;
    }

    public List y() {
        return this.f11338m;
    }

    public Proxy z() {
        return this.f11337e;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f11352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Proxy f11353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f11354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f11355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f11356e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f11357f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o.c f11358g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ProxySelector f11359h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public k f11360i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public SocketFactory f11361j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public SSLSocketFactory f11362k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public cc.c f11363l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public HostnameVerifier f11364m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public e f11365n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public okhttp3.b f11366o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public okhttp3.b f11367p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public h f11368q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public n f11369r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f11370s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f11371t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f11372u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11373v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f11374w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11375x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f11376y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f11377z;

        public b() {
            this.f11356e = new ArrayList();
            this.f11357f = new ArrayList();
            this.f11352a = new m();
            this.f11354c = u.K;
            this.f11355d = u.L;
            this.f11358g = o.k(o.f11304a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f11359h = proxySelector;
            if (proxySelector == null) {
                this.f11359h = new bc.a();
            }
            this.f11360i = k.f11295a;
            this.f11361j = SocketFactory.getDefault();
            this.f11364m = cc.d.f2492a;
            this.f11365n = e.f11177c;
            okhttp3.b bVar = okhttp3.b.f11153a;
            this.f11366o = bVar;
            this.f11367p = bVar;
            this.f11368q = new h();
            this.f11369r = n.f11303a;
            this.f11370s = true;
            this.f11371t = true;
            this.f11372u = true;
            this.f11373v = 0;
            this.f11374w = 10000;
            this.f11375x = 10000;
            this.f11376y = 10000;
            this.f11377z = 0;
        }

        public b a(okhttp3.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.f11367p = bVar;
            return this;
        }

        public u b() {
            return new u(this);
        }

        public b c(long j10, TimeUnit timeUnit) {
            this.f11374w = ub.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b d(Duration duration) {
            this.f11374w = ub.c.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b e(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f11368q = hVar;
            return this;
        }

        public b f(Proxy proxy) {
            this.f11353b = proxy;
            return this;
        }

        public b g(okhttp3.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f11366o = bVar;
            return this;
        }

        public b h(long j10, TimeUnit timeUnit) {
            this.f11375x = ub.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b i(Duration duration) {
            this.f11375x = ub.c.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b j(boolean z10) {
            this.f11372u = z10;
            return this;
        }

        public b k(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f11362k = sSLSocketFactory;
            this.f11363l = cc.c.b(x509TrustManager);
            return this;
        }

        public b l(long j10, TimeUnit timeUnit) {
            this.f11376y = ub.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b m(Duration duration) {
            this.f11376y = ub.c.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b(u uVar) {
            ArrayList arrayList = new ArrayList();
            this.f11356e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f11357f = arrayList2;
            this.f11352a = uVar.f11336c;
            this.f11353b = uVar.f11337e;
            this.f11354c = uVar.f11338m;
            this.f11355d = uVar.f11339n;
            arrayList.addAll(uVar.f11340o);
            arrayList2.addAll(uVar.f11341p);
            this.f11358g = uVar.f11342q;
            this.f11359h = uVar.f11343r;
            this.f11360i = uVar.f11344s;
            this.f11361j = uVar.f11345t;
            this.f11362k = uVar.f11346u;
            this.f11363l = uVar.f11347v;
            this.f11364m = uVar.f11348w;
            this.f11365n = uVar.f11349x;
            this.f11366o = uVar.f11350y;
            this.f11367p = uVar.f11351z;
            this.f11368q = uVar.A;
            this.f11369r = uVar.B;
            this.f11370s = uVar.C;
            this.f11371t = uVar.D;
            this.f11372u = uVar.E;
            this.f11373v = uVar.F;
            this.f11374w = uVar.G;
            this.f11375x = uVar.H;
            this.f11376y = uVar.I;
            this.f11377z = uVar.J;
        }
    }
}
