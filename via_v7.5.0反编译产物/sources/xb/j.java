package xb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.a0;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.o;
import okhttp3.r;
import okhttp3.s;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile wb.f f14690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f14691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f14692e;

    public j(u uVar, boolean z10) {
        this.f14688a = uVar;
        this.f14689b = z10;
    }

    @Override // okhttp3.s
    public y a(s.a aVar) throws IOException {
        w wVarE = aVar.e();
        g gVar = (g) aVar;
        okhttp3.d dVarF = gVar.f();
        o oVarH = gVar.h();
        wb.f fVar = new wb.f(this.f14688a.i(), c(wVarE.h()), dVarF, oVarH, this.f14691d);
        this.f14690c = fVar;
        wb.f fVar2 = fVar;
        y yVar = null;
        int i10 = 0;
        w wVar = wVarE;
        while (!this.f14692e) {
            try {
                try {
                    y yVarJ = gVar.j(wVar, fVar2, null, null);
                    if (yVar != null) {
                        yVarJ = yVarJ.l().m(yVar.l().b(null).c()).c();
                    }
                    try {
                        w wVarD = d(yVarJ, fVar2.o());
                        if (wVarD == null) {
                            fVar2.k();
                            return yVarJ;
                        }
                        ub.c.g(yVarJ.a());
                        int i11 = i10 + 1;
                        if (i11 > 20) {
                            fVar2.k();
                            throw new ProtocolException("Too many follow-up requests: " + i11);
                        }
                        wVarD.a();
                        if (!h(yVarJ, wVarD.h())) {
                            fVar2.k();
                            wb.f fVar3 = new wb.f(this.f14688a.i(), c(wVarD.h()), dVarF, oVarH, this.f14691d);
                            this.f14690c = fVar3;
                            fVar2 = fVar3;
                        } else if (fVar2.c() != null) {
                            throw new IllegalStateException("Closing the body of " + yVarJ + " didn't close its backing stream. Bad interceptor?");
                        }
                        yVar = yVarJ;
                        wVar = wVarD;
                        i10 = i11;
                    } catch (IOException e10) {
                        fVar2.k();
                        throw e10;
                    }
                } catch (Throwable th) {
                    fVar2.q(null);
                    fVar2.k();
                    throw th;
                }
            } catch (IOException e11) {
                if (!f(e11, fVar2, !(e11 instanceof ConnectionShutdownException), wVar)) {
                    throw e11;
                }
            } catch (RouteException e12) {
                if (!f(e12.getLastConnectException(), fVar2, false, wVar)) {
                    throw e12.getFirstConnectException();
                }
            }
        }
        fVar2.k();
        throw new IOException("Canceled");
    }

    public void b() {
        this.f14692e = true;
        wb.f fVar = this.f14690c;
        if (fVar != null) {
            fVar.b();
        }
    }

    public final okhttp3.a c(r rVar) {
        SSLSocketFactory sSLSocketFactoryF;
        HostnameVerifier hostnameVerifierQ;
        okhttp3.e eVarD;
        if (rVar.m()) {
            sSLSocketFactoryF = this.f14688a.F();
            hostnameVerifierQ = this.f14688a.q();
            eVarD = this.f14688a.d();
        } else {
            sSLSocketFactoryF = null;
            hostnameVerifierQ = null;
            eVarD = null;
        }
        return new okhttp3.a(rVar.l(), rVar.x(), this.f14688a.m(), this.f14688a.E(), sSLSocketFactoryF, hostnameVerifierQ, eVarD, this.f14688a.A(), this.f14688a.z(), this.f14688a.y(), this.f14688a.j(), this.f14688a.B());
    }

    public final w d(y yVar, a0 a0Var) throws ProtocolException {
        String strF;
        r rVarA;
        if (yVar == null) {
            throw new IllegalStateException();
        }
        int iC = yVar.c();
        String strF2 = yVar.o().f();
        if (iC == 307 || iC == 308) {
            if (!strF2.equals("GET") && !strF2.equals("HEAD")) {
                return null;
            }
        } else {
            if (iC == 401) {
                return this.f14688a.a().a(a0Var, yVar);
            }
            if (iC == 503) {
                if ((yVar.m() == null || yVar.m().c() != 503) && g(yVar, Integer.MAX_VALUE) == 0) {
                    return yVar.o();
                }
                return null;
            }
            if (iC == 407) {
                if ((a0Var != null ? a0Var.b() : this.f14688a.z()).type() == Proxy.Type.HTTP) {
                    return this.f14688a.A().a(a0Var, yVar);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iC == 408) {
                if (!this.f14688a.D()) {
                    return null;
                }
                yVar.o().a();
                if ((yVar.m() == null || yVar.m().c() != 408) && g(yVar, 0) <= 0) {
                    return yVar.o();
                }
                return null;
            }
            switch (iC) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f14688a.o() || (strF = yVar.f("Location")) == null || (rVarA = yVar.o().h().A(strF)) == null) {
            return null;
        }
        if (!rVarA.B().equals(yVar.o().h().B()) && !this.f14688a.p()) {
            return null;
        }
        w.a aVarG = yVar.o().g();
        if (f.a(strF2)) {
            boolean zC = f.c(strF2);
            if (f.b(strF2)) {
                aVarG.f("GET", null);
            } else {
                aVarG.f(strF2, zC ? yVar.o().a() : null);
            }
            if (!zC) {
                aVarG.i("Transfer-Encoding");
                aVarG.i("Content-Length");
                aVarG.i("Content-Type");
            }
        }
        if (!h(yVar, rVarA)) {
            aVarG.i("Authorization");
        }
        return aVarG.k(rVarA).b();
    }

    public final boolean e(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z10;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean f(IOException iOException, wb.f fVar, boolean z10, w wVar) {
        fVar.q(iOException);
        if (!this.f14688a.D()) {
            return false;
        }
        if (z10) {
            wVar.a();
        }
        return e(iOException, z10) && fVar.h();
    }

    public final int g(y yVar, int i10) {
        String strF = yVar.f("Retry-After");
        if (strF == null) {
            return i10;
        }
        if (strF.matches("\\d+")) {
            return Integer.valueOf(strF).intValue();
        }
        return Integer.MAX_VALUE;
    }

    public final boolean h(y yVar, r rVar) {
        r rVarH = yVar.o().h();
        return rVarH.l().equals(rVar.l()) && rVarH.x() == rVar.x() && rVarH.B().equals(rVar.B());
    }

    public void i(Object obj) {
        this.f14691d = obj;
    }
}
