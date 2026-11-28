package yb;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.u;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import okio.h;
import okio.k;
import okio.p;
import okio.q;
import okio.r;
import xb.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements xb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f15053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wb.f f15054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final okio.e f15055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final okio.d f15056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15057e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15058f = 262144;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public abstract class b implements q {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f15059c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15060e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f15061m;

        public b() {
            this.f15059c = new h(a.this.f15055c.i());
            this.f15061m = 0L;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            try {
                long jU = a.this.f15055c.U(cVar, j10);
                if (jU <= 0) {
                    return jU;
                }
                this.f15061m += jU;
                return jU;
            } catch (IOException e10) {
                a(false, e10);
                throw e10;
            }
        }

        public final void a(boolean z10, IOException iOException) {
            a aVar = a.this;
            int i10 = aVar.f15057e;
            if (i10 == 6) {
                return;
            }
            if (i10 != 5) {
                throw new IllegalStateException("state: " + a.this.f15057e);
            }
            aVar.g(this.f15059c);
            a aVar2 = a.this;
            aVar2.f15057e = 6;
            wb.f fVar = aVar2.f15054b;
            if (fVar != null) {
                fVar.r(!z10, aVar2, this.f15061m, iOException);
            }
        }

        @Override // okio.q
        public r i() {
            return this.f15059c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class c implements p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f15063c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15064e;

        public c() {
            this.f15063c = new h(a.this.f15056d.i());
        }

        @Override // okio.p
        public void L(okio.c cVar, long j10) {
            if (this.f15064e) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            a.this.f15056d.N(j10);
            a.this.f15056d.H("\r\n");
            a.this.f15056d.L(cVar, j10);
            a.this.f15056d.H("\r\n");
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f15064e) {
                return;
            }
            this.f15064e = true;
            a.this.f15056d.H("0\r\n\r\n");
            a.this.g(this.f15063c);
            a.this.f15057e = 3;
        }

        @Override // okio.p, java.io.Flushable
        public synchronized void flush() {
            if (this.f15064e) {
                return;
            }
            a.this.f15056d.flush();
        }

        @Override // okio.p
        public r i() {
            return this.f15063c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends b {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final okhttp3.r f15066o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f15067p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f15068q;

        public d(okhttp3.r rVar) {
            super();
            this.f15067p = -1L;
            this.f15068q = true;
            this.f15066o = rVar;
        }

        @Override // yb.a.b, okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f15060e) {
                throw new IllegalStateException("closed");
            }
            if (!this.f15068q) {
                return -1L;
            }
            long j11 = this.f15067p;
            if (j11 == 0 || j11 == -1) {
                b();
                if (!this.f15068q) {
                    return -1L;
                }
            }
            long jU = super.U(cVar, Math.min(j10, this.f15067p));
            if (jU != -1) {
                this.f15067p -= jU;
                return jU;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }

        public final void b() throws ProtocolException {
            if (this.f15067p != -1) {
                a.this.f15055c.O();
            }
            try {
                this.f15067p = a.this.f15055c.Z();
                String strTrim = a.this.f15055c.O().trim();
                if (this.f15067p < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f15067p + strTrim + "\"");
                }
                if (this.f15067p == 0) {
                    this.f15068q = false;
                    xb.e.e(a.this.f15053a.k(), this.f15066o, a.this.n());
                    a(true, null);
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15060e) {
                return;
            }
            if (this.f15068q && !ub.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f15060e = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class e implements p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h f15070c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15071e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f15072m;

        public e(long j10) {
            this.f15070c = new h(a.this.f15056d.i());
            this.f15072m = j10;
        }

        @Override // okio.p
        public void L(okio.c cVar, long j10) throws ProtocolException {
            if (this.f15071e) {
                throw new IllegalStateException("closed");
            }
            ub.c.f(cVar.size(), 0L, j10);
            if (j10 <= this.f15072m) {
                a.this.f15056d.L(cVar, j10);
                this.f15072m -= j10;
                return;
            }
            throw new ProtocolException("expected " + this.f15072m + " bytes but received " + j10);
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws ProtocolException {
            if (this.f15071e) {
                return;
            }
            this.f15071e = true;
            if (this.f15072m > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.g(this.f15070c);
            a.this.f15057e = 3;
        }

        @Override // okio.p, java.io.Flushable
        public void flush() {
            if (this.f15071e) {
                return;
            }
            a.this.f15056d.flush();
        }

        @Override // okio.p
        public r i() {
            return this.f15070c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f extends b {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f15074o;

        public f(long j10) {
            super();
            this.f15074o = j10;
            if (j10 == 0) {
                a(true, null);
            }
        }

        @Override // yb.a.b, okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f15060e) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f15074o;
            if (j11 == 0) {
                return -1L;
            }
            long jU = super.U(cVar, Math.min(j11, j10));
            if (jU == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            long j12 = this.f15074o - jU;
            this.f15074o = j12;
            if (j12 == 0) {
                a(true, null);
            }
            return jU;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15060e) {
                return;
            }
            if (this.f15074o != 0 && !ub.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f15060e = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g extends b {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f15076o;

        public g() {
            super();
        }

        @Override // yb.a.b, okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f15060e) {
                throw new IllegalStateException("closed");
            }
            if (this.f15076o) {
                return -1L;
            }
            long jU = super.U(cVar, j10);
            if (jU != -1) {
                return jU;
            }
            this.f15076o = true;
            a(true, null);
            return -1L;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f15060e) {
                return;
            }
            if (!this.f15076o) {
                a(false, null);
            }
            this.f15060e = true;
        }
    }

    public a(u uVar, wb.f fVar, okio.e eVar, okio.d dVar) {
        this.f15053a = uVar;
        this.f15054b = fVar;
        this.f15055c = eVar;
        this.f15056d = dVar;
    }

    @Override // xb.c
    public void a() {
        this.f15056d.flush();
    }

    @Override // xb.c
    public void b(w wVar) {
        o(wVar.d(), i.a(wVar, this.f15054b.d().p().b().type()));
    }

    @Override // xb.c
    public z c(y yVar) {
        wb.f fVar = this.f15054b;
        fVar.f14445f.q(fVar.f14444e);
        String strF = yVar.f("Content-Type");
        if (!xb.e.c(yVar)) {
            return new xb.h(strF, 0L, k.b(k(0L)));
        }
        if ("chunked".equalsIgnoreCase(yVar.f("Transfer-Encoding"))) {
            return new xb.h(strF, -1L, k.b(i(yVar.o().h())));
        }
        long jB = xb.e.b(yVar);
        return jB != -1 ? new xb.h(strF, jB, k.b(k(jB))) : new xb.h(strF, -1L, k.b(l()));
    }

    @Override // xb.c
    public void cancel() {
        wb.c cVarD = this.f15054b.d();
        if (cVarD != null) {
            cVarD.c();
        }
    }

    @Override // xb.c
    public y.a d(boolean z10) throws IOException {
        int i10 = this.f15057e;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f15057e);
        }
        try {
            xb.k kVarA = xb.k.a(m());
            y.a aVarJ = new y.a().n(kVarA.f14693a).g(kVarA.f14694b).k(kVarA.f14695c).j(n());
            if (z10 && kVarA.f14694b == 100) {
                return null;
            }
            if (kVarA.f14694b == 100) {
                this.f15057e = 3;
                return aVarJ;
            }
            this.f15057e = 4;
            return aVarJ;
        } catch (EOFException e10) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f15054b);
            iOException.initCause(e10);
            throw iOException;
        }
    }

    @Override // xb.c
    public void e() {
        this.f15056d.flush();
    }

    @Override // xb.c
    public p f(w wVar, long j10) {
        if ("chunked".equalsIgnoreCase(wVar.c("Transfer-Encoding"))) {
            return h();
        }
        if (j10 != -1) {
            return j(j10);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void g(h hVar) {
        r rVarI = hVar.i();
        hVar.j(r.f11481d);
        rVarI.a();
        rVarI.b();
    }

    public p h() {
        if (this.f15057e == 1) {
            this.f15057e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f15057e);
    }

    public q i(okhttp3.r rVar) {
        if (this.f15057e == 4) {
            this.f15057e = 5;
            return new d(rVar);
        }
        throw new IllegalStateException("state: " + this.f15057e);
    }

    public p j(long j10) {
        if (this.f15057e == 1) {
            this.f15057e = 2;
            return new e(j10);
        }
        throw new IllegalStateException("state: " + this.f15057e);
    }

    public q k(long j10) {
        if (this.f15057e == 4) {
            this.f15057e = 5;
            return new f(j10);
        }
        throw new IllegalStateException("state: " + this.f15057e);
    }

    public q l() {
        if (this.f15057e != 4) {
            throw new IllegalStateException("state: " + this.f15057e);
        }
        wb.f fVar = this.f15054b;
        if (fVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f15057e = 5;
        fVar.j();
        return new g();
    }

    public final String m() {
        String strF = this.f15055c.F(this.f15058f);
        this.f15058f -= (long) strF.length();
        return strF;
    }

    public okhttp3.q n() {
        okhttp3.q.a aVar = new okhttp3.q.a();
        while (true) {
            String strM = m();
            if (strM.length() == 0) {
                return aVar.d();
            }
            ub.a.f12943a.a(aVar, strM);
        }
    }

    public void o(okhttp3.q qVar, String str) {
        if (this.f15057e != 0) {
            throw new IllegalStateException("state: " + this.f15057e);
        }
        this.f15056d.H(str).H("\r\n");
        int iJ = qVar.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            this.f15056d.H(qVar.e(i10)).H(": ").H(qVar.k(i10)).H("\r\n");
        }
        this.f15056d.H("\r\n");
        this.f15057e = 1;
    }
}
