package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
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
import okhttp3.o;
import okhttp3.q;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u implements Cloneable {
    public static final List I = ub.c.u(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List J = ub.c.u(i.f10647h, i.f10649j);
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;

    /* renamed from: e, reason: collision with root package name */
    public final m f10721e;

    /* renamed from: j, reason: collision with root package name */
    public final Proxy f10722j;

    /* renamed from: k, reason: collision with root package name */
    public final List f10723k;

    /* renamed from: l, reason: collision with root package name */
    public final List f10724l;

    /* renamed from: m, reason: collision with root package name */
    public final List f10725m;

    /* renamed from: n, reason: collision with root package name */
    public final List f10726n;

    /* renamed from: o, reason: collision with root package name */
    public final o.c f10727o;

    /* renamed from: p, reason: collision with root package name */
    public final ProxySelector f10728p;

    /* renamed from: q, reason: collision with root package name */
    public final k f10729q;

    /* renamed from: r, reason: collision with root package name */
    public final SocketFactory f10730r;

    /* renamed from: s, reason: collision with root package name */
    public final SSLSocketFactory f10731s;

    /* renamed from: t, reason: collision with root package name */
    public final cc.c f10732t;

    /* renamed from: u, reason: collision with root package name */
    public final HostnameVerifier f10733u;

    /* renamed from: v, reason: collision with root package name */
    public final e f10734v;

    /* renamed from: w, reason: collision with root package name */
    public final okhttp3.b f10735w;

    /* renamed from: x, reason: collision with root package name */
    public final okhttp3.b f10736x;

    /* renamed from: y, reason: collision with root package name */
    public final h f10737y;

    /* renamed from: z, reason: collision with root package name */
    public final n f10738z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            return aVar.f10805c;
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
            return hVar.f10641e;
        }

        @Override // ub.a
        public IOException k(d dVar, IOException iOException) {
            return ((v) dVar).e(iOException);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public m f10739a;

        /* renamed from: b, reason: collision with root package name */
        public Proxy f10740b;

        /* renamed from: c, reason: collision with root package name */
        public List f10741c;

        /* renamed from: d, reason: collision with root package name */
        public List f10742d;

        /* renamed from: e, reason: collision with root package name */
        public final List f10743e;

        /* renamed from: f, reason: collision with root package name */
        public final List f10744f;

        /* renamed from: g, reason: collision with root package name */
        public o.c f10745g;

        /* renamed from: h, reason: collision with root package name */
        public ProxySelector f10746h;

        /* renamed from: i, reason: collision with root package name */
        public k f10747i;

        /* renamed from: j, reason: collision with root package name */
        public SocketFactory f10748j;

        /* renamed from: k, reason: collision with root package name */
        public SSLSocketFactory f10749k;

        /* renamed from: l, reason: collision with root package name */
        public cc.c f10750l;

        /* renamed from: m, reason: collision with root package name */
        public HostnameVerifier f10751m;

        /* renamed from: n, reason: collision with root package name */
        public e f10752n;

        /* renamed from: o, reason: collision with root package name */
        public okhttp3.b f10753o;

        /* renamed from: p, reason: collision with root package name */
        public okhttp3.b f10754p;

        /* renamed from: q, reason: collision with root package name */
        public h f10755q;

        /* renamed from: r, reason: collision with root package name */
        public n f10756r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f10757s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f10758t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f10759u;

        /* renamed from: v, reason: collision with root package name */
        public int f10760v;

        /* renamed from: w, reason: collision with root package name */
        public int f10761w;

        /* renamed from: x, reason: collision with root package name */
        public int f10762x;

        /* renamed from: y, reason: collision with root package name */
        public int f10763y;

        /* renamed from: z, reason: collision with root package name */
        public int f10764z;

        public b() {
            this.f10743e = new ArrayList();
            this.f10744f = new ArrayList();
            this.f10739a = new m();
            this.f10741c = u.I;
            this.f10742d = u.J;
            this.f10745g = o.k(o.f10689a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f10746h = proxySelector;
            if (proxySelector == null) {
                this.f10746h = new bc.a();
            }
            this.f10747i = k.f10680a;
            this.f10748j = SocketFactory.getDefault();
            this.f10751m = cc.d.f3193a;
            this.f10752n = e.f10562c;
            okhttp3.b bVar = okhttp3.b.f10538a;
            this.f10753o = bVar;
            this.f10754p = bVar;
            this.f10755q = new h();
            this.f10756r = n.f10688a;
            this.f10757s = true;
            this.f10758t = true;
            this.f10759u = true;
            this.f10760v = 0;
            this.f10761w = 10000;
            this.f10762x = 10000;
            this.f10763y = 10000;
            this.f10764z = 0;
        }

        public b(u uVar) {
            ArrayList arrayList = new ArrayList();
            this.f10743e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f10744f = arrayList2;
            this.f10739a = uVar.f10721e;
            this.f10740b = uVar.f10722j;
            this.f10741c = uVar.f10723k;
            this.f10742d = uVar.f10724l;
            arrayList.addAll(uVar.f10725m);
            arrayList2.addAll(uVar.f10726n);
            this.f10745g = uVar.f10727o;
            this.f10746h = uVar.f10728p;
            this.f10747i = uVar.f10729q;
            this.f10748j = uVar.f10730r;
            this.f10749k = uVar.f10731s;
            this.f10750l = uVar.f10732t;
            this.f10751m = uVar.f10733u;
            this.f10752n = uVar.f10734v;
            this.f10753o = uVar.f10735w;
            this.f10754p = uVar.f10736x;
            this.f10755q = uVar.f10737y;
            this.f10756r = uVar.f10738z;
            this.f10757s = uVar.A;
            this.f10758t = uVar.B;
            this.f10759u = uVar.C;
            this.f10760v = uVar.D;
            this.f10761w = uVar.E;
            this.f10762x = uVar.F;
            this.f10763y = uVar.G;
            this.f10764z = uVar.H;
        }

        public b a(okhttp3.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.f10754p = bVar;
            return this;
        }

        public u b() {
            return new u(this);
        }

        public b c(long j10, TimeUnit timeUnit) {
            this.f10761w = ub.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b d(Duration duration) {
            this.f10761w = ub.c.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b e(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f10755q = hVar;
            return this;
        }

        public b f(Proxy proxy) {
            this.f10740b = proxy;
            return this;
        }

        public b g(okhttp3.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f10753o = bVar;
            return this;
        }

        public b h(long j10, TimeUnit timeUnit) {
            this.f10762x = ub.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b i(Duration duration) {
            this.f10762x = ub.c.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public b j(boolean z10) {
            this.f10759u = z10;
            return this;
        }

        public b k(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f10749k = sSLSocketFactory;
            this.f10750l = cc.c.b(x509TrustManager);
            return this;
        }

        public b l(long j10, TimeUnit timeUnit) {
            this.f10763y = ub.c.e("timeout", j10, timeUnit);
            return this;
        }

        public b m(Duration duration) {
            this.f10763y = ub.c.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    static {
        ub.a.f12933a = new a();
    }

    public u(b bVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z10;
        this.f10721e = bVar.f10739a;
        this.f10722j = bVar.f10740b;
        this.f10723k = bVar.f10741c;
        List list = bVar.f10742d;
        this.f10724l = list;
        this.f10725m = ub.c.t(bVar.f10743e);
        this.f10726n = ub.c.t(bVar.f10744f);
        this.f10727o = bVar.f10745g;
        this.f10728p = bVar.f10746h;
        this.f10729q = bVar.f10747i;
        this.f10730r = bVar.f10748j;
        Iterator it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z10 = z10 || ((i) it.next()).d();
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f10749k;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager x509TrustManagerC = ub.c.C();
            this.f10731s = w(x509TrustManagerC);
            this.f10732t = cc.c.b(x509TrustManagerC);
        } else {
            this.f10731s = sSLSocketFactory;
            this.f10732t = bVar.f10750l;
        }
        if (this.f10731s != null) {
            ac.f.j().f(this.f10731s);
        }
        this.f10733u = bVar.f10751m;
        this.f10734v = bVar.f10752n.e(this.f10732t);
        this.f10735w = bVar.f10753o;
        this.f10736x = bVar.f10754p;
        this.f10737y = bVar.f10755q;
        this.f10738z = bVar.f10756r;
        this.A = bVar.f10757s;
        this.B = bVar.f10758t;
        this.C = bVar.f10759u;
        this.D = bVar.f10760v;
        this.E = bVar.f10761w;
        this.F = bVar.f10762x;
        this.G = bVar.f10763y;
        this.H = bVar.f10764z;
        if (this.f10725m.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f10725m);
        }
        if (this.f10726n.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f10726n);
        }
    }

    public static SSLSocketFactory w(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextK = ac.f.j().k();
            sSLContextK.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextK.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw ub.c.b("No System TLS", e10);
        }
    }

    public okhttp3.b A() {
        return this.f10735w;
    }

    public ProxySelector B() {
        return this.f10728p;
    }

    public int C() {
        return this.F;
    }

    public boolean D() {
        return this.C;
    }

    public SocketFactory E() {
        return this.f10730r;
    }

    public SSLSocketFactory F() {
        return this.f10731s;
    }

    public int G() {
        return this.G;
    }

    public okhttp3.b a() {
        return this.f10736x;
    }

    public int b() {
        return this.D;
    }

    public e c() {
        return this.f10734v;
    }

    public int d() {
        return this.E;
    }

    public h e() {
        return this.f10737y;
    }

    public List i() {
        return this.f10724l;
    }

    public k j() {
        return this.f10729q;
    }

    public m l() {
        return this.f10721e;
    }

    public n m() {
        return this.f10738z;
    }

    public o.c n() {
        return this.f10727o;
    }

    public boolean o() {
        return this.B;
    }

    public boolean p() {
        return this.A;
    }

    public HostnameVerifier q() {
        return this.f10733u;
    }

    public List r() {
        return this.f10725m;
    }

    public vb.c s() {
        return null;
    }

    public List t() {
        return this.f10726n;
    }

    public b u() {
        return new b(this);
    }

    public d v(w wVar) {
        return v.d(this, wVar, false);
    }

    public int x() {
        return this.H;
    }

    public List y() {
        return this.f10723k;
    }

    public Proxy z() {
        return this.f10722j;
    }
}
