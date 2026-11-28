package wb;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.a0;
import okhttp3.h;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.o;
import okhttp3.s;
import okhttp3.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.a f14440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e.a f14441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f14442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f14443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final okhttp3.d f14444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f14445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f14446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f14447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f14449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public xb.c f14453n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends WeakReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14454a;

        public a(f fVar, Object obj) {
            super(fVar);
            this.f14454a = obj;
        }
    }

    public f(h hVar, okhttp3.a aVar, okhttp3.d dVar, o oVar, Object obj) {
        this.f14443d = hVar;
        this.f14440a = aVar;
        this.f14444e = dVar;
        this.f14445f = oVar;
        this.f14447h = new e(aVar, p(), dVar, oVar);
        this.f14446g = obj;
    }

    public void a(c cVar, boolean z10) {
        if (this.f14449j != null) {
            throw new IllegalStateException();
        }
        this.f14449j = cVar;
        this.f14450k = z10;
        cVar.f14427n.add(new a(this, this.f14446g));
    }

    public void b() {
        xb.c cVar;
        c cVar2;
        synchronized (this.f14443d) {
            this.f14452m = true;
            cVar = this.f14453n;
            cVar2 = this.f14449j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public xb.c c() {
        xb.c cVar;
        synchronized (this.f14443d) {
            cVar = this.f14453n;
        }
        return cVar;
    }

    public synchronized c d() {
        return this.f14449j;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    public final Socket e(boolean z10, boolean z11, boolean z12) {
        Socket socketQ;
        if (z12) {
            this.f14453n = null;
        }
        if (z11) {
            this.f14451l = true;
        }
        c cVar = this.f14449j;
        if (cVar != null) {
            if (z10) {
                cVar.f14424k = true;
            }
            if (this.f14453n == null && (this.f14451l || cVar.f14424k)) {
                l(cVar);
                if (this.f14449j.f14427n.isEmpty()) {
                    this.f14449j.f14428o = System.nanoTime();
                    if (ub.a.f12943a.e(this.f14443d, this.f14449j)) {
                        socketQ = this.f14449j.q();
                    } else {
                        socketQ = null;
                    }
                } else {
                    socketQ = null;
                }
                this.f14449j = null;
                return socketQ;
            }
        }
        return null;
    }

    public final c f(int i10, int i11, int i12, int i13, boolean z10) throws Throwable {
        c cVar;
        Socket socketN;
        c cVar2;
        Socket socketF;
        a0 a0VarC;
        boolean z11;
        boolean z12;
        c cVar3;
        e.a aVar;
        synchronized (this.f14443d) {
            try {
                if (this.f14451l) {
                    throw new IllegalStateException("released");
                }
                if (this.f14453n != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.f14452m) {
                    throw new IOException("Canceled");
                }
                cVar = this.f14449j;
                socketN = n();
                cVar2 = this.f14449j;
                socketF = null;
                if (cVar2 != null) {
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.f14450k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    ub.a.f12943a.h(this.f14443d, this.f14440a, this, null);
                    c cVar4 = this.f14449j;
                    if (cVar4 != null) {
                        cVar2 = cVar4;
                        z11 = true;
                        a0VarC = null;
                    } else {
                        a0VarC = this.f14442c;
                    }
                } else {
                    a0VarC = null;
                }
                z11 = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        ub.c.h(socketN);
        if (cVar != null) {
            this.f14445f.h(this.f14444e, cVar);
        }
        if (z11) {
            this.f14445f.g(this.f14444e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (a0VarC != null || ((aVar = this.f14441b) != null && aVar.b())) {
            z12 = false;
        } else {
            this.f14441b = this.f14447h.e();
            z12 = true;
        }
        synchronized (this.f14443d) {
            try {
                if (this.f14452m) {
                    throw new IOException("Canceled");
                }
                if (z12) {
                    List listA = this.f14441b.a();
                    int size = listA.size();
                    for (int i14 = 0; i14 < size; i14++) {
                        a0 a0Var = (a0) listA.get(i14);
                        ub.a.f12943a.h(this.f14443d, this.f14440a, this, a0Var);
                        c cVar5 = this.f14449j;
                        if (cVar5 != null) {
                            this.f14442c = a0Var;
                            cVar2 = cVar5;
                            z11 = true;
                            break;
                        }
                    }
                }
                if (!z11) {
                    if (a0VarC == null) {
                        a0VarC = this.f14441b.c();
                    }
                    this.f14442c = a0VarC;
                    this.f14448i = 0;
                    cVar2 = new c(this.f14443d, a0VarC);
                    a(cVar2, false);
                }
                cVar3 = cVar2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            this.f14445f.g(this.f14444e, cVar3);
            return cVar3;
        }
        cVar3.d(i10, i11, i12, i13, z10, this.f14444e, this.f14445f);
        p().a(cVar3.p());
        synchronized (this.f14443d) {
            try {
                this.f14450k = true;
                ub.a.f12943a.i(this.f14443d, cVar3);
                if (cVar3.n()) {
                    socketF = ub.a.f12943a.f(this.f14443d, this.f14440a, this);
                    cVar3 = this.f14449j;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        ub.c.h(socketF);
        this.f14445f.g(this.f14444e, cVar3);
        return cVar3;
    }

    public final c g(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws Throwable {
        while (true) {
            c cVarF = f(i10, i11, i12, i13, z10);
            boolean z12 = z10;
            int i14 = i13;
            int i15 = i12;
            int i16 = i11;
            int i17 = i10;
            synchronized (this.f14443d) {
                try {
                    if (cVarF.f14425l == 0) {
                        return cVarF;
                    }
                    if (cVarF.m(z11)) {
                        return cVarF;
                    }
                    j();
                    i10 = i17;
                    i11 = i16;
                    i12 = i15;
                    i13 = i14;
                    z10 = z12;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public boolean h() {
        if (this.f14442c != null) {
            return true;
        }
        e.a aVar = this.f14441b;
        return (aVar != null && aVar.b()) || this.f14447h.c();
    }

    public xb.c i(u uVar, s.a aVar, boolean z10) {
        try {
            xb.c cVarO = g(aVar.d(), aVar.a(), aVar.b(), uVar.x(), uVar.D(), z10).o(uVar, aVar, this);
            synchronized (this.f14443d) {
                this.f14453n = cVarO;
            }
            return cVarO;
        } catch (IOException e10) {
            throw new RouteException(e10);
        }
    }

    public void j() {
        c cVar;
        Socket socketE;
        synchronized (this.f14443d) {
            cVar = this.f14449j;
            socketE = e(true, false, false);
            if (this.f14449j != null) {
                cVar = null;
            }
        }
        ub.c.h(socketE);
        if (cVar != null) {
            this.f14445f.h(this.f14444e, cVar);
        }
    }

    public void k() {
        c cVar;
        Socket socketE;
        synchronized (this.f14443d) {
            cVar = this.f14449j;
            socketE = e(false, true, false);
            if (this.f14449j != null) {
                cVar = null;
            }
        }
        ub.c.h(socketE);
        if (cVar != null) {
            ub.a.f12943a.k(this.f14444e, null);
            this.f14445f.h(this.f14444e, cVar);
            this.f14445f.a(this.f14444e);
        }
    }

    public final void l(c cVar) {
        int size = cVar.f14427n.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((Reference) cVar.f14427n.get(i10)).get() == this) {
                cVar.f14427n.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket m(c cVar) {
        if (this.f14453n != null || this.f14449j.f14427n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference reference = (Reference) this.f14449j.f14427n.get(0);
        Socket socketE = e(true, false, false);
        this.f14449j = cVar;
        cVar.f14427n.add(reference);
        return socketE;
    }

    public final Socket n() {
        c cVar = this.f14449j;
        if (cVar == null || !cVar.f14424k) {
            return null;
        }
        return e(false, false, true);
    }

    public a0 o() {
        return this.f14442c;
    }

    public final d p() {
        return ub.a.f12943a.j(this.f14443d);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0048  */
    public void q(IOException iOException) {
        c cVar;
        boolean z10;
        Socket socketE;
        synchronized (this.f14443d) {
            try {
                cVar = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i10 = this.f14448i + 1;
                        this.f14448i = i10;
                        if (i10 > 1) {
                            this.f14442c = null;
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } else if (errorCode != ErrorCode.CANCEL) {
                        this.f14442c = null;
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else {
                    c cVar2 = this.f14449j;
                    if (cVar2 == null || (cVar2.n() && !(iOException instanceof ConnectionShutdownException))) {
                        z10 = false;
                    } else {
                        if (this.f14449j.f14425l == 0) {
                            a0 a0Var = this.f14442c;
                            if (a0Var != null && iOException != null) {
                                this.f14447h.a(a0Var, iOException);
                            }
                            this.f14442c = null;
                        }
                        z10 = true;
                    }
                }
                c cVar3 = this.f14449j;
                socketE = e(z10, false, true);
                if (this.f14449j == null && this.f14450k) {
                    cVar = cVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ub.c.h(socketE);
        if (cVar != null) {
            this.f14445f.h(this.f14444e, cVar);
        }
    }

    public void r(boolean z10, xb.c cVar, long j10, IOException iOException) {
        c cVar2;
        Socket socketE;
        boolean z11;
        this.f14445f.p(this.f14444e, j10);
        synchronized (this.f14443d) {
            if (cVar != null) {
                try {
                    if (cVar == this.f14453n) {
                        if (!z10) {
                            this.f14449j.f14425l++;
                        }
                        cVar2 = this.f14449j;
                        socketE = e(z10, false, true);
                        if (this.f14449j != null) {
                            cVar2 = null;
                        }
                        z11 = this.f14451l;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.f14453n + " but was " + cVar);
        }
        ub.c.h(socketE);
        if (cVar2 != null) {
            this.f14445f.h(this.f14444e, cVar2);
        }
        if (iOException != null) {
            this.f14445f.b(this.f14444e, ub.a.f12943a.k(this.f14444e, iOException));
        } else if (z11) {
            ub.a.f12943a.k(this.f14444e, null);
            this.f14445f.a(this.f14444e);
        }
    }

    public String toString() {
        c cVarD = d();
        return cVarD != null ? cVarD.toString() : this.f14440a.toString();
    }
}
