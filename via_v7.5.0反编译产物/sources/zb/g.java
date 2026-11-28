package zb;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okio.p;
import okio.q;
import okio.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15658a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f15661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque f15662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f15664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f15665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f15666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f15667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ErrorCode f15668k;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class a implements p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final okio.c f15669c = new okio.c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15670e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f15671m;

        public a() {
        }

        @Override // okio.p
        public void L(okio.c cVar, long j10) throws IOException {
            this.f15669c.L(cVar, j10);
            while (this.f15669c.size() >= 16384) {
                a(false);
            }
        }

        public final void a(boolean z10) throws IOException {
            g gVar;
            long jMin;
            g gVar2;
            synchronized (g.this) {
                g.this.f15667j.k();
                while (true) {
                    try {
                        gVar = g.this;
                        if (gVar.f15659b > 0 || this.f15671m || this.f15670e || gVar.f15668k != null) {
                            break;
                        } else {
                            gVar.t();
                        }
                    } catch (Throwable th) {
                        g.this.f15667j.u();
                        throw th;
                    }
                }
                gVar.f15667j.u();
                g.this.e();
                jMin = Math.min(g.this.f15659b, this.f15669c.size());
                gVar2 = g.this;
                gVar2.f15659b -= jMin;
            }
            gVar2.f15667j.k();
            try {
                g gVar3 = g.this;
                gVar3.f15661d.x(gVar3.f15660c, z10 && jMin == this.f15669c.size(), this.f15669c, jMin);
            } finally {
                g.this.f15667j.u();
            }
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (g.this) {
                try {
                    if (this.f15670e) {
                        return;
                    }
                    if (!g.this.f15665h.f15671m) {
                        if (this.f15669c.size() > 0) {
                            while (this.f15669c.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = g.this;
                            gVar.f15661d.x(gVar.f15660c, true, null, 0L);
                        }
                    }
                    synchronized (g.this) {
                        this.f15670e = true;
                    }
                    g.this.f15661d.flush();
                    g.this.d();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            synchronized (g.this) {
                g.this.e();
            }
            while (this.f15669c.size() > 0) {
                a(false);
                g.this.f15661d.flush();
            }
        }

        @Override // okio.p
        public r i() {
            return g.this.f15667j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class b implements q {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final okio.c f15673c = new okio.c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final okio.c f15674e = new okio.c();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f15675m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f15676n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f15677o;

        public b(long j10) {
            this.f15675m = j10;
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0094  */
        /* JADX WARN: Code duplicated, block: B:41:0x0098 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:42:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:43:0x009b  */
        @Override // okio.q
        public long U(okio.c cVar, long j10) throws StreamResetException {
            ErrorCode errorCode;
            long jU;
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            while (true) {
                synchronized (g.this) {
                    try {
                        g.this.f15666i.k();
                        try {
                            g gVar = g.this;
                            errorCode = gVar.f15668k;
                            if (errorCode == null) {
                                errorCode = null;
                            }
                            if (this.f15676n) {
                                throw new IOException("stream closed");
                            }
                            if (!gVar.f15662e.isEmpty()) {
                                g.b(g.this);
                            }
                            if (this.f15674e.size() > 0) {
                                okio.c cVar2 = this.f15674e;
                                jU = cVar2.U(cVar, Math.min(j10, cVar2.size()));
                                g gVar2 = g.this;
                                long j11 = gVar2.f15658a + jU;
                                gVar2.f15658a = j11;
                                if (errorCode != null || j11 < gVar2.f15661d.f15603x.d() / 2) {
                                    break;
                                    break;
                                }
                                g gVar3 = g.this;
                                gVar3.f15661d.c0(gVar3.f15660c, gVar3.f15658a);
                                g.this.f15658a = 0L;
                                break;
                            }
                            if (this.f15677o || errorCode != null) {
                                jU = -1;
                                break;
                            }
                            g.this.t();
                            g.this.f15666i.u();
                        } catch (Throwable th) {
                            g.this.f15666i.u();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (jU != -1) {
                    b(jU);
                    return jU;
                }
                if (errorCode == null) {
                    return -1L;
                }
                throw new StreamResetException(errorCode);
            }
            g.this.f15666i.u();
            if (jU != -1) {
                b(jU);
                return jU;
            }
            if (errorCode == null) {
                return -1L;
            }
            throw new StreamResetException(errorCode);
        }

        public void a(okio.e eVar, long j10) throws EOFException {
            boolean z10;
            boolean z11;
            while (j10 > 0) {
                synchronized (g.this) {
                    z10 = this.f15677o;
                    z11 = this.f15674e.size() + j10 > this.f15675m;
                }
                if (z11) {
                    eVar.skip(j10);
                    g.this.h(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    eVar.skip(j10);
                    return;
                }
                long jU = eVar.U(this.f15673c, j10);
                if (jU == -1) {
                    throw new EOFException();
                }
                j10 -= jU;
                synchronized (g.this) {
                    try {
                        boolean z12 = this.f15674e.size() == 0;
                        this.f15674e.M(this.f15673c);
                        if (z12) {
                            g.this.notifyAll();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final void b(long j10) {
            g.this.f15661d.w(j10);
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (g.this) {
                try {
                    this.f15676n = true;
                    size = this.f15674e.size();
                    this.f15674e.a();
                    if (!g.this.f15662e.isEmpty()) {
                        g.b(g.this);
                    }
                    g.this.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (size > 0) {
                b(size);
            }
            g.this.d();
        }

        @Override // okio.q
        public r i() {
            return g.this.f15666i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends okio.a {
        public c() {
        }

        @Override // okio.a
        public IOException o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.a
        public void t() {
            g.this.h(ErrorCode.CANCEL);
        }

        public void u() throws IOException {
            if (n()) {
                throw o(null);
            }
        }
    }

    public g(int i10, e eVar, boolean z10, boolean z11, okhttp3.q qVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f15662e = arrayDeque;
        this.f15666i = new c();
        this.f15667j = new c();
        this.f15668k = null;
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f15660c = i10;
        this.f15661d = eVar;
        this.f15659b = eVar.f15604y.d();
        b bVar = new b(eVar.f15603x.d());
        this.f15664g = bVar;
        a aVar = new a();
        this.f15665h = aVar;
        bVar.f15677o = z11;
        aVar.f15671m = z10;
        if (qVar != null) {
            arrayDeque.add(qVar);
        }
        if (l() && qVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!l() && qVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public static /* synthetic */ zb.a.InterfaceC0166a b(g gVar) {
        gVar.getClass();
        return null;
    }

    public void c(long j10) {
        this.f15659b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001a  */
    public void d() {
        boolean z10;
        boolean zM;
        synchronized (this) {
            try {
                b bVar = this.f15664g;
                if (bVar.f15677o || !bVar.f15676n) {
                    z10 = false;
                } else {
                    a aVar = this.f15665h;
                    if (aVar.f15671m || aVar.f15670e) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
                zM = m();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            f(ErrorCode.CANCEL);
        } else {
            if (zM) {
                return;
            }
            this.f15661d.s(this.f15660c);
        }
    }

    public void e() throws IOException {
        a aVar = this.f15665h;
        if (aVar.f15670e) {
            throw new IOException("stream closed");
        }
        if (aVar.f15671m) {
            throw new IOException("stream finished");
        }
        if (this.f15668k != null) {
            throw new StreamResetException(this.f15668k);
        }
    }

    public void f(ErrorCode errorCode) {
        if (g(errorCode)) {
            this.f15661d.W(this.f15660c, errorCode);
        }
    }

    public final boolean g(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.f15668k != null) {
                    return false;
                }
                if (this.f15664g.f15677o && this.f15665h.f15671m) {
                    return false;
                }
                this.f15668k = errorCode;
                notifyAll();
                this.f15661d.s(this.f15660c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(ErrorCode errorCode) {
        if (g(errorCode)) {
            this.f15661d.b0(this.f15660c, errorCode);
        }
    }

    public int i() {
        return this.f15660c;
    }

    public p j() {
        synchronized (this) {
            try {
                if (!this.f15663f && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f15665h;
    }

    public q k() {
        return this.f15664g;
    }

    public boolean l() {
        return this.f15661d.f15590c == ((this.f15660c & 1) == 1);
    }

    public synchronized boolean m() {
        try {
            if (this.f15668k != null) {
                return false;
            }
            b bVar = this.f15664g;
            if (bVar.f15677o || bVar.f15676n) {
                a aVar = this.f15665h;
                if ((aVar.f15671m || aVar.f15670e) && this.f15663f) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public r n() {
        return this.f15666i;
    }

    public void o(okio.e eVar, int i10) throws EOFException {
        this.f15664g.a(eVar, i10);
    }

    public void p() {
        boolean zM;
        synchronized (this) {
            this.f15664g.f15677o = true;
            zM = m();
            notifyAll();
        }
        if (zM) {
            return;
        }
        this.f15661d.s(this.f15660c);
    }

    public void q(List list) {
        boolean zM;
        synchronized (this) {
            this.f15663f = true;
            this.f15662e.add(ub.c.H(list));
            zM = m();
            notifyAll();
        }
        if (zM) {
            return;
        }
        this.f15661d.s(this.f15660c);
    }

    public synchronized void r(ErrorCode errorCode) {
        if (this.f15668k == null) {
            this.f15668k = errorCode;
            notifyAll();
        }
    }

    public synchronized okhttp3.q s() {
        this.f15666i.k();
        while (this.f15662e.isEmpty() && this.f15668k == null) {
            try {
                t();
            } catch (Throwable th) {
                this.f15666i.u();
                throw th;
            }
        }
        this.f15666i.u();
        if (this.f15662e.isEmpty()) {
            throw new StreamResetException(this.f15668k);
        }
        return (okhttp3.q) this.f15662e.removeFirst();
    }

    public void t() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public r u() {
        return this.f15667j;
    }
}
