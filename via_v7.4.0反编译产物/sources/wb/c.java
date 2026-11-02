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
import zb.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends e.h implements g {

    /* renamed from: b, reason: collision with root package name */
    public final h f13412b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f13413c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f13414d;

    /* renamed from: e, reason: collision with root package name */
    public Socket f13415e;

    /* renamed from: f, reason: collision with root package name */
    public p f13416f;

    /* renamed from: g, reason: collision with root package name */
    public Protocol f13417g;

    /* renamed from: h, reason: collision with root package name */
    public zb.e f13418h;

    /* renamed from: i, reason: collision with root package name */
    public okio.e f13419i;

    /* renamed from: j, reason: collision with root package name */
    public okio.d f13420j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13421k;

    /* renamed from: l, reason: collision with root package name */
    public int f13422l;

    /* renamed from: m, reason: collision with root package name */
    public int f13423m = 1;

    /* renamed from: n, reason: collision with root package name */
    public final List f13424n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public long f13425o = Long.MAX_VALUE;

    public c(h hVar, a0 a0Var) {
        this.f13412b = hVar;
        this.f13413c = a0Var;
    }

    @Override // zb.e.h
    public void a(zb.e eVar) {
        synchronized (this.f13412b) {
            this.f13423m = eVar.j();
        }
    }

    @Override // zb.e.h
    public void b(zb.g gVar) {
        gVar.f(ErrorCode.REFUSED_STREAM);
    }

    public void c() throws IOException {
        ub.c.h(this.f13414d);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0140 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i10, int i11, int i12, int i13, boolean z10, okhttp3.d dVar, o oVar) throws Throwable {
        okhttp3.d dVar2;
        o oVar2;
        IOException iOException;
        if (this.f13417g != null) {
            throw new IllegalStateException("already connected");
        }
        List listB = this.f13413c.a().b();
        b bVar = new b(listB);
        if (this.f13413c.a().k() == null) {
            if (!listB.contains(i.f10649j)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strL = this.f13413c.a().l().l();
            if (!ac.f.j().n(strL)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + strL + " not permitted by network security policy"));
            }
        } else if (this.f13413c.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        do {
            try {
            } catch (IOException e10) {
                e = e10;
                dVar2 = dVar;
                oVar2 = oVar;
            }
            try {
                if (this.f13413c.c()) {
                    try {
                        g(i10, i11, i12, dVar, oVar);
                        dVar2 = dVar;
                        oVar2 = oVar;
                    } catch (IOException e11) {
                        e = e11;
                        dVar2 = dVar;
                        oVar2 = oVar;
                    }
                    try {
                        if (this.f13414d == null) {
                        }
                        if (!this.f13413c.c() && this.f13414d == null) {
                            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        if (this.f13418h == null) {
                            synchronized (this.f13412b) {
                                this.f13423m = this.f13418h.j();
                            }
                            return;
                        }
                        return;
                    } catch (IOException e12) {
                        e = e12;
                        iOException = e;
                        ub.c.h(this.f13415e);
                        ub.c.h(this.f13414d);
                        this.f13415e = null;
                        this.f13414d = null;
                        this.f13419i = null;
                        this.f13420j = null;
                        this.f13416f = null;
                        this.f13417g = null;
                        this.f13418h = null;
                        oVar2.e(dVar2, this.f13413c.d(), this.f13413c.b(), null, iOException);
                        if (routeException != null) {
                        }
                        if (z10) {
                        }
                    }
                } else {
                    dVar2 = dVar;
                    oVar2 = oVar;
                    e(i10, i11, dVar2, oVar2);
                }
                j(bVar, i13, dVar2, oVar2);
                oVar2.d(dVar2, this.f13413c.d(), this.f13413c.b(), this.f13417g);
                if (!this.f13413c.c()) {
                }
                if (this.f13418h == null) {
                }
            } catch (IOException e13) {
                e = e13;
                iOException = e;
                ub.c.h(this.f13415e);
                ub.c.h(this.f13414d);
                this.f13415e = null;
                this.f13414d = null;
                this.f13419i = null;
                this.f13420j = null;
                this.f13416f = null;
                this.f13417g = null;
                this.f13418h = null;
                oVar2.e(dVar2, this.f13413c.d(), this.f13413c.b(), null, iOException);
                if (routeException != null) {
                    routeException = new RouteException(iOException);
                } else {
                    routeException.addConnectException(iOException);
                }
                if (z10) {
                    throw routeException;
                }
            }
        } while (bVar.b(iOException));
        throw routeException;
    }

    public final void e(int i10, int i11, okhttp3.d dVar, o oVar) throws IOException {
        Proxy proxyB = this.f13413c.b();
        this.f13414d = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.f13413c.a().j().createSocket() : new Socket(proxyB);
        oVar.f(dVar, this.f13413c.d(), proxyB);
        this.f13414d.setSoTimeout(i11);
        try {
            ac.f.j().h(this.f13414d, this.f13413c.d(), i10);
            try {
                this.f13419i = k.b(k.i(this.f13414d));
                this.f13420j = k.a(k.e(this.f13414d));
            } catch (NullPointerException e10) {
                if ("throw with null exception".equals(e10.getMessage())) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f13413c.d());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void f(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        okhttp3.a aVarA = this.f13413c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) aVarA.k().createSocket(this.f13414d, aVarA.l().l(), aVarA.l().w(), true);
            } catch (AssertionError e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            i iVarA = bVar.a(sSLSocket);
            if (iVarA.f()) {
                ac.f.j().g(sSLSocket, aVarA.l().l(), aVarA.f());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            p pVarB = p.b(session);
            if (aVarA.e().verify(aVarA.l().l(), session)) {
                aVarA.a().a(aVarA.l().l(), pVarB.c());
                String strL = iVarA.f() ? ac.f.j().l(sSLSocket) : null;
                this.f13415e = sSLSocket;
                this.f13419i = k.b(k.i(sSLSocket));
                this.f13420j = k.a(k.e(this.f13415e));
                this.f13416f = pVarB;
                this.f13417g = strL != null ? Protocol.get(strL) : Protocol.HTTP_1_1;
                ac.f.j().a(sSLSocket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) pVarB.c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + aVarA.l().l() + " not verified:\n    certificate: " + okhttp3.e.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + cc.d.a(x509Certificate));
        } catch (AssertionError e11) {
            e = e11;
            if (!ub.c.A(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                ac.f.j().a(sSLSocket2);
            }
            ub.c.h(sSLSocket2);
            throw th;
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
            ub.c.h(this.f13414d);
            this.f13414d = null;
            this.f13420j = null;
            this.f13419i = null;
            oVar.d(dVar, this.f13413c.d(), this.f13413c.b(), null);
        }
    }

    public final w h(int i10, int i11, w wVar, r rVar) throws IOException {
        String str = "CONNECT " + ub.c.s(rVar, true) + " HTTP/1.1";
        while (true) {
            yb.a aVar = new yb.a(null, null, this.f13419i, this.f13420j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f13419i.e().g(i10, timeUnit);
            this.f13420j.e().g(i11, timeUnit);
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
            int iD = yVarC.d();
            if (iD == 200) {
                if (this.f13419i.c().C() && this.f13420j.c().C()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iD != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + yVarC.d());
            }
            w wVarA = this.f13413c.a().h().a(this.f13413c, yVarC);
            if (wVarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(yVarC.g("Connection"))) {
                return wVarA;
            }
            wVar = wVarA;
        }
    }

    public final w i() {
        w wVarB = new w.a().k(this.f13413c.a().l()).f("CONNECT", null).d("Host", ub.c.s(this.f13413c.a().l(), true)).d("Proxy-Connection", "Keep-Alive").d("User-Agent", ub.d.a()).b();
        w wVarA = this.f13413c.a().h().a(this.f13413c, new y.a().p(wVarB).n(Protocol.HTTP_1_1).g(407).k("Preemptive Authenticate").b(ub.c.f12937c).q(-1L).o(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return wVarA != null ? wVarA : wVarB;
    }

    public final void j(b bVar, int i10, okhttp3.d dVar, o oVar) throws Throwable {
        if (this.f13413c.a().k() != null) {
            oVar.u(dVar);
            f(bVar);
            oVar.t(dVar, this.f13416f);
            if (this.f13417g == Protocol.HTTP_2) {
                r(i10);
                return;
            }
            return;
        }
        List listF = this.f13413c.a().f();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(protocol)) {
            this.f13415e = this.f13414d;
            this.f13417g = Protocol.HTTP_1_1;
        } else {
            this.f13415e = this.f13414d;
            this.f13417g = protocol;
            r(i10);
        }
    }

    public p k() {
        return this.f13416f;
    }

    public boolean l(okhttp3.a aVar, a0 a0Var) {
        if (this.f13424n.size() >= this.f13423m || this.f13421k || !ub.a.f12933a.g(this.f13413c.a(), aVar)) {
            return false;
        }
        if (aVar.l().l().equals(p().a().l().l())) {
            return true;
        }
        if (this.f13418h == null || a0Var == null) {
            return false;
        }
        Proxy.Type type = a0Var.b().type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || this.f13413c.b().type() != type2 || !this.f13413c.d().equals(a0Var.d()) || a0Var.a().e() != cc.d.f3193a || !s(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().l(), k().c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean m(boolean z10) throws SocketException {
        if (this.f13415e.isClosed() || this.f13415e.isInputShutdown() || this.f13415e.isOutputShutdown()) {
            return false;
        }
        if (this.f13418h != null) {
            return !r0.isShutdown();
        }
        if (z10) {
            try {
                int soTimeout = this.f13415e.getSoTimeout();
                try {
                    this.f13415e.setSoTimeout(1);
                    return !this.f13419i.C();
                } finally {
                    this.f13415e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        return this.f13418h != null;
    }

    public xb.c o(u uVar, s.a aVar, f fVar) throws SocketException {
        if (this.f13418h != null) {
            return new zb.d(uVar, aVar, fVar, this.f13418h);
        }
        this.f13415e.setSoTimeout(aVar.a());
        okio.r rVarE = this.f13419i.e();
        long jA = aVar.a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        rVarE.g(jA, timeUnit);
        this.f13420j.e().g(aVar.b(), timeUnit);
        return new yb.a(uVar, fVar, this.f13419i, this.f13420j);
    }

    public a0 p() {
        return this.f13413c;
    }

    public Socket q() {
        return this.f13415e;
    }

    public final void r(int i10) throws SocketException {
        this.f13415e.setSoTimeout(0);
        zb.e eVarA = new e.g(true).d(this.f13415e, this.f13413c.a().l().l(), this.f13419i, this.f13420j).b(this).c(i10).a();
        this.f13418h = eVarA;
        eVarA.u();
    }

    public boolean s(r rVar) {
        if (rVar.w() != this.f13413c.a().l().w()) {
            return false;
        }
        if (rVar.l().equals(this.f13413c.a().l().l())) {
            return true;
        }
        return this.f13416f != null && cc.d.f3193a.c(rVar.l(), (X509Certificate) this.f13416f.c().get(0));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f13413c.a().l().l());
        sb2.append(":");
        sb2.append(this.f13413c.a().l().w());
        sb2.append(", proxy=");
        sb2.append(this.f13413c.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f13413c.d());
        sb2.append(" cipherSuite=");
        p pVar = this.f13416f;
        sb2.append(pVar != null ? pVar.a() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f13417g);
        sb2.append('}');
        return sb2.toString();
    }
}
