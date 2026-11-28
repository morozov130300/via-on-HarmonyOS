package wb;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.g;
import okhttp3.h;
import okhttp3.i;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.o;
import okhttp3.p;
import okhttp3.r;
import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;
import okio.k;
import okio.q;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends zb.e.h implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f14415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f14416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Socket f14417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Socket f14418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f14419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Protocol f14420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zb.e f14421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public okio.e f14422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public okio.d f14423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14426m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f14427n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f14428o = Long.MAX_VALUE;

    public c(h hVar, a0 a0Var) {
        this.f14415b = hVar;
        this.f14416c = a0Var;
    }

    @Override // zb.e.h
    public void a(zb.e eVar) {
        synchronized (this.f14415b) {
            this.f14426m = eVar.j();
        }
    }

    @Override // zb.e.h
    public void b(zb.g gVar) {
        gVar.f(ErrorCode.REFUSED_STREAM);
    }

    public void c() {
        ub.c.h(this.f14417d);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x012d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0133  */
    /* JADX WARN: Code duplicated, block: B:63:0x0138  */
    /* JADX WARN: Code duplicated, block: B:82:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[LOOP:0: B:72:0x0082->B:86:?, LOOP_END, SYNTHETIC] */
    public void d(int i10, int i11, int i12, int i13, boolean z10, okhttp3.d dVar, o oVar) throws Throwable {
        okhttp3.d dVar2;
        o oVar2;
        IOException iOException;
        if (this.f14420g != null) {
            throw new IllegalStateException("already connected");
        }
        List listB = this.f14416c.a().b();
        b bVar = new b(listB);
        if (this.f14416c.a().k() == null) {
            if (!listB.contains(i.f11264j)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strL = this.f14416c.a().l().l();
            if (!ac.f.j().n(strL)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + strL + " not permitted by network security policy"));
            }
        } else if (this.f14416c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                if (this.f14416c.c()) {
                    try {
                        g(i10, i11, i12, dVar, oVar);
                        dVar2 = dVar;
                        oVar2 = oVar;
                        try {
                            if (this.f14417d != null) {
                                break;
                            } else {
                                break;
                            }
                        } catch (IOException e10) {
                            e = e10;
                            iOException = e;
                            ub.c.h(this.f14418e);
                            ub.c.h(this.f14417d);
                            this.f14418e = null;
                            this.f14417d = null;
                            this.f14422i = null;
                            this.f14423j = null;
                            this.f14419f = null;
                            this.f14420g = null;
                            this.f14421h = null;
                            oVar2.e(dVar2, this.f14416c.d(), this.f14416c.b(), null, iOException);
                            if (routeException == null) {
                                routeException = new RouteException(iOException);
                            } else {
                                routeException.addConnectException(iOException);
                            }
                            if (z10) {
                                throw routeException;
                            }
                            if (bVar.b(iOException)) {
                                throw routeException;
                            }
                        }
                    } catch (IOException e11) {
                        e = e11;
                        dVar2 = dVar;
                        oVar2 = oVar;
                    }
                } else {
                    dVar2 = dVar;
                    oVar2 = oVar;
                    e(i10, i11, dVar2, oVar2);
                }
                try {
                    j(bVar, i13, dVar2, oVar2);
                    oVar2.d(dVar2, this.f14416c.d(), this.f14416c.b(), this.f14420g);
                    break;
                } catch (IOException e12) {
                    e = e12;
                    iOException = e;
                    ub.c.h(this.f14418e);
                    ub.c.h(this.f14417d);
                    this.f14418e = null;
                    this.f14417d = null;
                    this.f14422i = null;
                    this.f14423j = null;
                    this.f14419f = null;
                    this.f14420g = null;
                    this.f14421h = null;
                    oVar2.e(dVar2, this.f14416c.d(), this.f14416c.b(), null, iOException);
                    if (routeException == null) {
                        routeException = new RouteException(iOException);
                    } else {
                        routeException.addConnectException(iOException);
                    }
                    if (z10) {
                        throw routeException;
                    }
                    if (bVar.b(iOException)) {
                        throw routeException;
                    }
                }
            } catch (IOException e13) {
                e = e13;
                dVar2 = dVar;
                oVar2 = oVar;
            }
        }
        if (this.f14416c.c() && this.f14417d == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.f14421h != null) {
            synchronized (this.f14415b) {
                this.f14426m = this.f14421h.j();
            }
        }
    }

    public final void e(int i10, int i11, okhttp3.d dVar, o oVar) throws IOException {
        Proxy proxyB = this.f14416c.b();
        this.f14417d = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.f14416c.a().j().createSocket() : new Socket(proxyB);
        oVar.f(dVar, this.f14416c.d(), proxyB);
        this.f14417d.setSoTimeout(i11);
        try {
            ac.f.j().h(this.f14417d, this.f14416c.d(), i10);
            try {
                this.f14422i = k.b(k.i(this.f14417d));
                this.f14423j = k.a(k.e(this.f14417d));
            } catch (NullPointerException e10) {
                if ("throw with null exception".equals(e10.getMessage())) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f14416c.d());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void f(b bVar) throws Throwable {
        okhttp3.a aVarA = this.f14416c.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) aVarA.k().createSocket(this.f14417d, aVarA.l().l(), aVarA.l().x(), true);
                try {
                    i iVarA = bVar.a(sSLSocket2);
                    if (iVarA.f()) {
                        ac.f.j().g(sSLSocket2, aVarA.l().l(), aVarA.f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    p pVarB = p.b(session);
                    if (aVarA.e().verify(aVarA.l().l(), session)) {
                        aVarA.a().a(aVarA.l().l(), pVarB.c());
                        String strL = iVarA.f() ? ac.f.j().l(sSLSocket2) : null;
                        this.f14418e = sSLSocket2;
                        this.f14422i = k.b(k.i(sSLSocket2));
                        this.f14423j = k.a(k.e(this.f14418e));
                        this.f14419f = pVarB;
                        this.f14420g = strL != null ? Protocol.get(strL) : Protocol.HTTP_1_1;
                        ac.f.j().a(sSLSocket2);
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) pVarB.c().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + aVarA.l().l() + " not verified:\n    certificate: " + okhttp3.e.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + cc.d.a(x509Certificate));
                } catch (AssertionError e10) {
                    e = e10;
                    if (!ub.c.A(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        ac.f.j().a(sSLSocket);
                    }
                    ub.c.h(sSLSocket);
                    throw th;
                }
            } catch (AssertionError e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void g(int i10, int i11, int i12, okhttp3.d dVar, o oVar) throws IOException {
        w wVarI = i();
        r rVarH = wVarI.h();
        for (int i13 = 0; i13 < 21; i13++) {
            e(i10, i11, dVar, oVar);
            wVarI = h(i11, i12, wVarI, rVarH);
            if (wVarI == null) {
                return;
            }
            ub.c.h(this.f14417d);
            this.f14417d = null;
            this.f14423j = null;
            this.f14422i = null;
            oVar.d(dVar, this.f14416c.d(), this.f14416c.b(), null);
        }
    }

    public final w h(int i10, int i11, w wVar, r rVar) throws IOException {
        String str = "CONNECT " + ub.c.s(rVar, true) + " HTTP/1.1";
        while (true) {
            yb.a aVar = new yb.a(null, null, this.f14422i, this.f14423j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f14422i.i().g(i10, timeUnit);
            this.f14423j.i().g(i11, timeUnit);
            aVar.o(wVar.d(), str);
            aVar.a();
            y yVarC = aVar.d(false).p(wVar).c();
            long jB = xb.e.b(yVarC);
            if (jB == -1) {
                jB = 0;
            }
            q qVarK = aVar.k(jB);
            ub.c.D(qVarK, Integer.MAX_VALUE, timeUnit);
            qVarK.close();
            int iC = yVarC.c();
            if (iC == 200) {
                if (this.f14422i.d().C() && this.f14423j.d().C()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iC != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + yVarC.c());
            }
            w wVarA = this.f14416c.a().h().a(this.f14416c, yVarC);
            if (wVarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(yVarC.f("Connection"))) {
                return wVarA;
            }
            wVar = wVarA;
        }
    }

    public final w i() {
        w wVarB = new w.a().k(this.f14416c.a().l()).f("CONNECT", null).d("Host", ub.c.s(this.f14416c.a().l(), true)).d("Proxy-Connection", "Keep-Alive").d("User-Agent", ub.d.a()).b();
        w wVarA = this.f14416c.a().h().a(this.f14416c, new y.a().p(wVarB).n(Protocol.HTTP_1_1).g(407).k("Preemptive Authenticate").b(ub.c.f12947c).q(-1L).o(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return wVarA != null ? wVarA : wVarB;
    }

    public final void j(b bVar, int i10, okhttp3.d dVar, o oVar) throws Throwable {
        if (this.f14416c.a().k() != null) {
            oVar.u(dVar);
            f(bVar);
            oVar.t(dVar, this.f14419f);
            if (this.f14420g == Protocol.HTTP_2) {
                r(i10);
                return;
            }
            return;
        }
        List listF = this.f14416c.a().f();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(protocol)) {
            this.f14418e = this.f14417d;
            this.f14420g = Protocol.HTTP_1_1;
        } else {
            this.f14418e = this.f14417d;
            this.f14420g = protocol;
            r(i10);
        }
    }

    public p k() {
        return this.f14419f;
    }

    public boolean l(okhttp3.a aVar, a0 a0Var) {
        if (this.f14427n.size() >= this.f14426m || this.f14424k || !ub.a.f12943a.g(this.f14416c.a(), aVar)) {
            return false;
        }
        if (aVar.l().l().equals(p().a().l().l())) {
            return true;
        }
        if (this.f14421h == null || a0Var == null) {
            return false;
        }
        Proxy.Type type = a0Var.b().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.f14416c.b().type() != type2 || !this.f14416c.d().equals(a0Var.d()) || a0Var.a().e() != cc.d.f2492a || !s(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().l(), k().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean m(boolean z10) {
        if (this.f14418e.isClosed() || this.f14418e.isInputShutdown() || this.f14418e.isOutputShutdown()) {
            return false;
        }
        zb.e eVar = this.f14421h;
        if (eVar != null) {
            return !eVar.isShutdown();
        }
        if (z10) {
            try {
                int soTimeout = this.f14418e.getSoTimeout();
                try {
                    this.f14418e.setSoTimeout(1);
                    if (this.f14422i.C()) {
                        this.f14418e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.f14418e.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.f14418e.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        return this.f14421h != null;
    }

    public xb.c o(u uVar, s.a aVar, f fVar) throws SocketException {
        if (this.f14421h != null) {
            return new zb.d(uVar, aVar, fVar, this.f14421h);
        }
        this.f14418e.setSoTimeout(aVar.a());
        okio.r rVarI = this.f14422i.i();
        long jA = aVar.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        rVarI.g(jA, timeUnit);
        this.f14423j.i().g(aVar.b(), timeUnit);
        return new yb.a(uVar, fVar, this.f14422i, this.f14423j);
    }

    public a0 p() {
        return this.f14416c;
    }

    public Socket q() {
        return this.f14418e;
    }

    public final void r(int i10) throws SocketException {
        this.f14418e.setSoTimeout(0);
        zb.e eVarA = new zb.e.g(true).d(this.f14418e, this.f14416c.a().l().l(), this.f14422i, this.f14423j).b(this).c(i10).a();
        this.f14421h = eVarA;
        eVarA.u();
    }

    public boolean s(r rVar) {
        if (rVar.x() != this.f14416c.a().l().x()) {
            return false;
        }
        if (rVar.l().equals(this.f14416c.a().l().l())) {
            return true;
        }
        return this.f14419f != null && cc.d.f2492a.c(rVar.l(), (X509Certificate) this.f14419f.c().get(0));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f14416c.a().l().l());
        sb2.append(":");
        sb2.append(this.f14416c.a().l().x());
        sb2.append(", proxy=");
        sb2.append(this.f14416c.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f14416c.d());
        sb2.append(" cipherSuite=");
        p pVar = this.f14419f;
        sb2.append(pVar != null ? pVar.a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f14420g);
        sb2.append('}');
        return sb2.toString();
    }
}
