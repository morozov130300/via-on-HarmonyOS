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
import wb.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f13437a;

    /* renamed from: b, reason: collision with root package name */
    public e.a f13438b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f13439c;

    /* renamed from: d, reason: collision with root package name */
    public final h f13440d;

    /* renamed from: e, reason: collision with root package name */
    public final okhttp3.d f13441e;

    /* renamed from: f, reason: collision with root package name */
    public final o f13442f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f13443g;

    /* renamed from: h, reason: collision with root package name */
    public final e f13444h;

    /* renamed from: i, reason: collision with root package name */
    public int f13445i;

    /* renamed from: j, reason: collision with root package name */
    public c f13446j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13447k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13448l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13449m;

    /* renamed from: n, reason: collision with root package name */
    public xb.c f13450n;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends WeakReference {

        /* renamed from: a, reason: collision with root package name */
        public final Object f13451a;

        public a(f fVar, Object obj) {
            super(fVar);
            this.f13451a = obj;
        }
    }

    public f(h hVar, okhttp3.a aVar, okhttp3.d dVar, o oVar, Object obj) {
        this.f13440d = hVar;
        this.f13437a = aVar;
        this.f13441e = dVar;
        this.f13442f = oVar;
        this.f13444h = new e(aVar, p(), dVar, oVar);
        this.f13443g = obj;
    }

    public void a(c cVar, boolean z10) {
        if (this.f13446j != null) {
            throw new IllegalStateException();
        }
        this.f13446j = cVar;
        this.f13447k = z10;
        cVar.f13424n.add(new a(this, this.f13443g));
    }

    public void b() throws IOException {
        xb.c cVar;
        c cVar2;
        synchronized (this.f13440d) {
            this.f13449m = true;
            cVar = this.f13450n;
            cVar2 = this.f13446j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public xb.c c() {
        xb.c cVar;
        synchronized (this.f13440d) {
            cVar = this.f13450n;
        }
        return cVar;
    }

    public synchronized c d() {
        return this.f13446j;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket e(boolean z10, boolean z11, boolean z12) {
        Socket socketQ;
        if (z12) {
            this.f13450n = null;
        }
        if (z11) {
            this.f13448l = true;
        }
        c cVar = this.f13446j;
        if (cVar != null) {
            if (z10) {
                cVar.f13421k = true;
            }
            if (this.f13450n == null && (this.f13448l || cVar.f13421k)) {
                l(cVar);
                if (this.f13446j.f13424n.isEmpty()) {
                    this.f13446j.f13425o = System.nanoTime();
                    socketQ = ub.a.f12933a.e(this.f13440d, this.f13446j) ? this.f13446j.q() : null;
                }
                this.f13446j = null;
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
        synchronized (this.f13440d) {
            try {
                if (this.f13448l) {
                    throw new IllegalStateException("released");
                }
                if (this.f13450n != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.f13449m) {
                    throw new IOException("Canceled");
                }
                cVar = this.f13446j;
                socketN = n();
                cVar2 = this.f13446j;
                socketF = null;
                if (cVar2 != null) {
                    cVar = null;
                } else {
                    cVar2 = null;
                }
                if (!this.f13447k) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    ub.a.f12933a.h(this.f13440d, this.f13437a, this, null);
                    c cVar4 = this.f13446j;
                    if (cVar4 != null) {
                        cVar2 = cVar4;
                        z11 = true;
                        a0VarC = null;
                    } else {
                        a0VarC = this.f13439c;
                    }
                } else {
                    a0VarC = null;
                }
                z11 = false;
            } finally {
            }
        }
        ub.c.h(socketN);
        if (cVar != null) {
            this.f13442f.h(this.f13441e, cVar);
        }
        if (z11) {
            this.f13442f.g(this.f13441e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (a0VarC != null || ((aVar = this.f13438b) != null && aVar.b())) {
            z12 = false;
        } else {
            this.f13438b = this.f13444h.e();
            z12 = true;
        }
        synchronized (this.f13440d) {
            try {
                if (this.f13449m) {
                    throw new IOException("Canceled");
                }
                if (z12) {
                    List listA = this.f13438b.a();
                    int size = listA.size();
                    int i14 = 0;
                    while (true) {
                        if (i14 >= size) {
                            break;
                        }
                        a0 a0Var = (a0) listA.get(i14);
                        ub.a.f12933a.h(this.f13440d, this.f13437a, this, a0Var);
                        c cVar5 = this.f13446j;
                        if (cVar5 != null) {
                            this.f13439c = a0Var;
                            cVar2 = cVar5;
                            z11 = true;
                            break;
                        }
                        i14++;
                    }
                }
                if (!z11) {
                    if (a0VarC == null) {
                        a0VarC = this.f13438b.c();
                    }
                    this.f13439c = a0VarC;
                    this.f13445i = 0;
                    cVar2 = new c(this.f13440d, a0VarC);
                    a(cVar2, false);
                }
                cVar3 = cVar2;
            } finally {
            }
        }
        if (z11) {
            this.f13442f.g(this.f13441e, cVar3);
            return cVar3;
        }
        cVar3.d(i10, i11, i12, i13, z10, this.f13441e, this.f13442f);
        p().a(cVar3.p());
        synchronized (this.f13440d) {
            try {
                this.f13447k = true;
                ub.a.f12933a.i(this.f13440d, cVar3);
                if (cVar3.n()) {
                    socketF = ub.a.f12933a.f(this.f13440d, this.f13437a, this);
                    cVar3 = this.f13446j;
                }
            } finally {
            }
        }
        ub.c.h(socketF);
        this.f13442f.g(this.f13441e, cVar3);
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
            synchronized (this.f13440d) {
                try {
                    if (cVarF.f13422l == 0) {
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
        if (this.f13439c != null) {
            return true;
        }
        e.a aVar = this.f13438b;
        return (aVar != null && aVar.b()) || this.f13444h.c();
    }

    public xb.c i(u uVar, s.a aVar, boolean z10) {
        try {
            xb.c cVarO = g(aVar.d(), aVar.a(), aVar.b(), uVar.x(), uVar.D(), z10).o(uVar, aVar, this);
            synchronized (this.f13440d) {
                this.f13450n = cVarO;
            }
            return cVarO;
        } catch (IOException e10) {
            throw new RouteException(e10);
        }
    }

    public void j() throws IOException {
        c cVar;
        Socket socketE;
        synchronized (this.f13440d) {
            cVar = this.f13446j;
            socketE = e(true, false, false);
            if (this.f13446j != null) {
                cVar = null;
            }
        }
        ub.c.h(socketE);
        if (cVar != null) {
            this.f13442f.h(this.f13441e, cVar);
        }
    }

    public void k() throws IOException {
        c cVar;
        Socket socketE;
        synchronized (this.f13440d) {
            cVar = this.f13446j;
            socketE = e(false, true, false);
            if (this.f13446j != null) {
                cVar = null;
            }
        }
        ub.c.h(socketE);
        if (cVar != null) {
            ub.a.f12933a.k(this.f13441e, null);
            this.f13442f.h(this.f13441e, cVar);
            this.f13442f.a(this.f13441e);
        }
    }

    public final void l(c cVar) {
        int size = cVar.f13424n.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((Reference) cVar.f13424n.get(i10)).get() == this) {
                cVar.f13424n.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket m(c cVar) {
        if (this.f13450n != null || this.f13446j.f13424n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference reference = (Reference) this.f13446j.f13424n.get(0);
        Socket socketE = e(true, false, false);
        this.f13446j = cVar;
        cVar.f13424n.add(reference);
        return socketE;
    }

    public final Socket n() {
        c cVar = this.f13446j;
        if (cVar == null || !cVar.f13421k) {
            return null;
        }
        return e(false, false, true);
    }

    public a0 o() {
        return this.f13439c;
    }

    public final d p() {
        return ub.a.f12933a.j(this.f13440d);
    }

    public void q(IOException iOException) throws IOException {
        c cVar;
        boolean z10;
        Socket socketE;
        synchronized (this.f13440d) {
            try {
                cVar = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i10 = this.f13445i + 1;
                        this.f13445i = i10;
                        if (i10 > 1) {
                            this.f13439c = null;
                            z10 = true;
                        }
                        z10 = false;
                    } else {
                        if (errorCode != ErrorCode.CANCEL) {
                            this.f13439c = null;
                            z10 = true;
                        }
                        z10 = false;
                    }
                } else {
                    c cVar2 = this.f13446j;
                    if (cVar2 != null && (!cVar2.n() || (iOException instanceof ConnectionShutdownException))) {
                        if (this.f13446j.f13422l == 0) {
                            a0 a0Var = this.f13439c;
                            if (a0Var != null && iOException != null) {
                                this.f13444h.a(a0Var, iOException);
                            }
                            this.f13439c = null;
                        }
                        z10 = true;
                    }
                    z10 = false;
                }
                c cVar3 = this.f13446j;
                socketE = e(z10, false, true);
                if (this.f13446j == null && this.f13447k) {
                    cVar = cVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ub.c.h(socketE);
        if (cVar != null) {
            this.f13442f.h(this.f13441e, cVar);
        }
    }

    public void r(boolean z10, xb.c cVar, long j10, IOException iOException) throws IOException {
        c cVar2;
        Socket socketE;
        boolean z11;
        this.f13442f.p(this.f13441e, j10);
        synchronized (this.f13440d) {
            if (cVar != null) {
                try {
                    if (cVar == this.f13450n) {
                        if (!z10) {
                            this.f13446j.f13422l++;
                        }
                        cVar2 = this.f13446j;
                        socketE = e(z10, false, true);
                        if (this.f13446j != null) {
                            cVar2 = null;
                        }
                        z11 = this.f13448l;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.f13450n + " but was " + cVar);
        }
        ub.c.h(socketE);
        if (cVar2 != null) {
            this.f13442f.h(this.f13441e, cVar2);
        }
        if (iOException != null) {
            this.f13442f.b(this.f13441e, ub.a.f12933a.k(this.f13441e, iOException));
        } else if (z11) {
            ub.a.f12933a.k(this.f13441e, null);
            this.f13442f.a(this.f13441e);
        }
    }

    public String toString() {
        c cVarD = d();
        return cVarD != null ? cVarD.toString() : this.f13437a.toString();
    }
}
