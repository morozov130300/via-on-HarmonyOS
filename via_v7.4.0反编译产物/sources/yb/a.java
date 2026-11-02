package yb;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.q;
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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements xb.c {

    /* renamed from: a, reason: collision with root package name */
    public final u f14520a;

    /* renamed from: b, reason: collision with root package name */
    public final wb.f f14521b;

    /* renamed from: c, reason: collision with root package name */
    public final okio.e f14522c;

    /* renamed from: d, reason: collision with root package name */
    public final okio.d f14523d;

    /* renamed from: e, reason: collision with root package name */
    public int f14524e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f14525f = 262144;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public abstract class b implements q {

        /* renamed from: e, reason: collision with root package name */
        public final h f14526e;

        /* renamed from: j, reason: collision with root package name */
        public boolean f14527j;

        /* renamed from: k, reason: collision with root package name */
        public long f14528k;

        public b() {
            this.f14526e = new h(a.this.f14522c.e());
            this.f14528k = 0L;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            try {
                long jU = a.this.f14522c.U(cVar, j10);
                if (jU <= 0) {
                    return jU;
                }
                this.f14528k += jU;
                return jU;
            } catch (IOException e10) {
                a(false, e10);
                throw e10;
            }
        }

        public final void a(boolean z10, IOException iOException) throws IOException {
            a aVar = a.this;
            int i10 = aVar.f14524e;
            if (i10 == 6) {
                return;
            }
            if (i10 != 5) {
                throw new IllegalStateException("state: " + a.this.f14524e);
            }
            aVar.g(this.f14526e);
            a aVar2 = a.this;
            aVar2.f14524e = 6;
            wb.f fVar = aVar2.f14521b;
            if (fVar != null) {
                fVar.r(!z10, aVar2, this.f14528k, iOException);
            }
        }

        @Override // okio.q
        public r e() {
            return this.f14526e;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class c implements p {

        /* renamed from: e, reason: collision with root package name */
        public final h f14530e;

        /* renamed from: j, reason: collision with root package name */
        public boolean f14531j;

        public c() {
            this.f14530e = new h(a.this.f14523d.e());
        }

        @Override // okio.p
        public void I(okio.c cVar, long j10) {
            if (this.f14531j) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            a.this.f14523d.L(j10);
            a.this.f14523d.F("\r\n");
            a.this.f14523d.I(cVar, j10);
            a.this.f14523d.F("\r\n");
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f14531j) {
                return;
            }
            this.f14531j = true;
            a.this.f14523d.F("0\r\n\r\n");
            a.this.g(this.f14530e);
            a.this.f14524e = 3;
        }

        @Override // okio.p
        public r e() {
            return this.f14530e;
        }

        @Override // okio.p, java.io.Flushable
        public synchronized void flush() {
            if (this.f14531j) {
                return;
            }
            a.this.f14523d.flush();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends b {

        /* renamed from: m, reason: collision with root package name */
        public final okhttp3.r f14533m;

        /* renamed from: n, reason: collision with root package name */
        public long f14534n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f14535o;

        public d(okhttp3.r rVar) {
            super();
            this.f14534n = -1L;
            this.f14535o = true;
            this.f14533m = rVar;
        }

        @Override // yb.a.b, okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f14527j) {
                throw new IllegalStateException("closed");
            }
            if (!this.f14535o) {
                return -1L;
            }
            long j11 = this.f14534n;
            if (j11 == 0 || j11 == -1) {
                b();
                if (!this.f14535o) {
                    return -1L;
                }
            }
            long jU = super.U(cVar, Math.min(j10, this.f14534n));
            if (jU != -1) {
                this.f14534n -= jU;
                return jU;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }

        public final void b() throws IOException {
            if (this.f14534n != -1) {
                a.this.f14522c.N();
            }
            try {
                this.f14534n = a.this.f14522c.Z();
                String strTrim = a.this.f14522c.N().trim();
                if (this.f14534n < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f14534n + strTrim + "\"");
                }
                if (this.f14534n == 0) {
                    this.f14535o = false;
                    xb.e.e(a.this.f14520a.j(), this.f14533m, a.this.n());
                    a(true, null);
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f14527j) {
                return;
            }
            if (this.f14535o && !ub.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f14527j = true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class e implements p {

        /* renamed from: e, reason: collision with root package name */
        public final h f14537e;

        /* renamed from: j, reason: collision with root package name */
        public boolean f14538j;

        /* renamed from: k, reason: collision with root package name */
        public long f14539k;

        public e(long j10) {
            this.f14537e = new h(a.this.f14523d.e());
            this.f14539k = j10;
        }

        @Override // okio.p
        public void I(okio.c cVar, long j10) throws ProtocolException {
            if (this.f14538j) {
                throw new IllegalStateException("closed");
            }
            ub.c.f(cVar.size(), 0L, j10);
            if (j10 <= this.f14539k) {
                a.this.f14523d.I(cVar, j10);
                this.f14539k -= j10;
                return;
            }
            throw new ProtocolException("expected " + this.f14539k + " bytes but received " + j10);
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws ProtocolException {
            if (this.f14538j) {
                return;
            }
            this.f14538j = true;
            if (this.f14539k > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.g(this.f14537e);
            a.this.f14524e = 3;
        }

        @Override // okio.p
        public r e() {
            return this.f14537e;
        }

        @Override // okio.p, java.io.Flushable
        public void flush() {
            if (this.f14538j) {
                return;
            }
            a.this.f14523d.flush();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f extends b {

        /* renamed from: m, reason: collision with root package name */
        public long f14541m;

        public f(long j10) throws IOException {
            super();
            this.f14541m = j10;
            if (j10 == 0) {
                a(true, null);
            }
        }

        @Override // yb.a.b, okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f14527j) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f14541m;
            if (j11 == 0) {
                return -1L;
            }
            long jU = super.U(cVar, Math.min(j11, j10));
            if (jU == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            long j12 = this.f14541m - jU;
            this.f14541m = j12;
            if (j12 == 0) {
                a(true, null);
            }
            return jU;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f14527j) {
                return;
            }
            if (this.f14541m != 0 && !ub.c.p(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f14527j = true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g extends b {

        /* renamed from: m, reason: collision with root package name */
        public boolean f14543m;

        public g() {
            super();
        }

        @Override // yb.a.b, okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f14527j) {
                throw new IllegalStateException("closed");
            }
            if (this.f14543m) {
                return -1L;
            }
            long jU = super.U(cVar, j10);
            if (jU != -1) {
                return jU;
            }
            this.f14543m = true;
            a(true, null);
            return -1L;
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f14527j) {
                return;
            }
            if (!this.f14543m) {
                a(false, null);
            }
            this.f14527j = true;
        }
    }

    public a(u uVar, wb.f fVar, okio.e eVar, okio.d dVar) {
        this.f14520a = uVar;
        this.f14521b = fVar;
        this.f14522c = eVar;
        this.f14523d = dVar;
    }

    @Override // xb.c
    public void a() {
        this.f14523d.flush();
    }

    @Override // xb.c
    public void b(w wVar) {
        o(wVar.d(), i.a(wVar, this.f14521b.d().p().b().type()));
    }

    @Override // xb.c
    public z c(y yVar) {
        wb.f fVar = this.f14521b;
        fVar.f13442f.q(fVar.f13441e);
        String strG = yVar.g("Content-Type");
        if (!xb.e.c(yVar)) {
            return new xb.h(strG, 0L, k.b(k(0L)));
        }
        if ("chunked".equalsIgnoreCase(yVar.g("Transfer-Encoding"))) {
            return new xb.h(strG, -1L, k.b(i(yVar.o().h())));
        }
        long jB = xb.e.b(yVar);
        return jB != -1 ? new xb.h(strG, jB, k.b(k(jB))) : new xb.h(strG, -1L, k.b(l()));
    }

    @Override // xb.c
    public void cancel() throws IOException {
        wb.c cVarD = this.f14521b.d();
        if (cVarD != null) {
            cVarD.c();
        }
    }

    @Override // xb.c
    public y.a d(boolean z10) throws NumberFormatException, IOException {
        int i10 = this.f14524e;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f14524e);
        }
        try {
            xb.k kVarA = xb.k.a(m());
            y.a aVarJ = new y.a().n(kVarA.f14347a).g(kVarA.f14348b).k(kVarA.f14349c).j(n());
            if (z10 && kVarA.f14348b == 100) {
                return null;
            }
            if (kVarA.f14348b == 100) {
                this.f14524e = 3;
                return aVarJ;
            }
            this.f14524e = 4;
            return aVarJ;
        } catch (EOFException e10) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f14521b);
            iOException.initCause(e10);
            throw iOException;
        }
    }

    @Override // xb.c
    public void e() {
        this.f14523d.flush();
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
        hVar.j(r.f10868d);
        rVarI.a();
        rVarI.b();
    }

    public p h() {
        if (this.f14524e == 1) {
            this.f14524e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f14524e);
    }

    public q i(okhttp3.r rVar) {
        if (this.f14524e == 4) {
            this.f14524e = 5;
            return new d(rVar);
        }
        throw new IllegalStateException("state: " + this.f14524e);
    }

    public p j(long j10) {
        if (this.f14524e == 1) {
            this.f14524e = 2;
            return new e(j10);
        }
        throw new IllegalStateException("state: " + this.f14524e);
    }

    public q k(long j10) {
        if (this.f14524e == 4) {
            this.f14524e = 5;
            return new f(j10);
        }
        throw new IllegalStateException("state: " + this.f14524e);
    }

    public q l() throws IOException {
        if (this.f14524e != 4) {
            throw new IllegalStateException("state: " + this.f14524e);
        }
        wb.f fVar = this.f14521b;
        if (fVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f14524e = 5;
        fVar.j();
        return new g();
    }

    public final String m() {
        String strE = this.f14522c.E(this.f14525f);
        this.f14525f -= strE.length();
        return strE;
    }

    public okhttp3.q n() {
        q.a aVar = new q.a();
        while (true) {
            String strM = m();
            if (strM.length() == 0) {
                return aVar.d();
            }
            ub.a.f12933a.a(aVar, strM);
        }
    }

    public void o(okhttp3.q qVar, String str) {
        if (this.f14524e != 0) {
            throw new IllegalStateException("state: " + this.f14524e);
        }
        this.f14523d.F(str).F("\r\n");
        int iJ = qVar.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            this.f14523d.F(qVar.e(i10)).F(": ").F(qVar.k(i10)).F("\r\n");
        }
        this.f14523d.F("\r\n");
        this.f14524e = 1;
    }
}
