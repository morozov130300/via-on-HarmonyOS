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
import zb.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public long f14923a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f14924b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14925c;

    /* renamed from: d, reason: collision with root package name */
    public final e f14926d;

    /* renamed from: e, reason: collision with root package name */
    public final Deque f14927e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14928f;

    /* renamed from: g, reason: collision with root package name */
    public final b f14929g;

    /* renamed from: h, reason: collision with root package name */
    public final a f14930h;

    /* renamed from: i, reason: collision with root package name */
    public final c f14931i;

    /* renamed from: j, reason: collision with root package name */
    public final c f14932j;

    /* renamed from: k, reason: collision with root package name */
    public ErrorCode f14933k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class a implements p {

        /* renamed from: e, reason: collision with root package name */
        public final okio.c f14934e = new okio.c();

        /* renamed from: j, reason: collision with root package name */
        public boolean f14935j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f14936k;

        public a() {
        }

        @Override // okio.p
        public void I(okio.c cVar, long j10) throws IOException {
            this.f14934e.I(cVar, j10);
            while (this.f14934e.size() >= 16384) {
                a(false);
            }
        }

        public final void a(boolean z10) throws IOException {
            g gVar;
            long jMin;
            g gVar2;
            synchronized (g.this) {
                g.this.f14932j.k();
                while (true) {
                    try {
                        gVar = g.this;
                        if (gVar.f14924b > 0 || this.f14936k || this.f14935j || gVar.f14933k != null) {
                            break;
                        } else {
                            gVar.t();
                        }
                    } finally {
                        g.this.f14932j.u();
                    }
                }
                gVar.f14932j.u();
                g.this.e();
                jMin = Math.min(g.this.f14924b, this.f14934e.size());
                gVar2 = g.this;
                gVar2.f14924b -= jMin;
            }
            gVar2.f14932j.k();
            try {
                g gVar3 = g.this;
                gVar3.f14926d.x(gVar3.f14925c, z10 && jMin == this.f14934e.size(), this.f14934e, jMin);
                g.this.f14932j.u();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (g.this) {
                try {
                    if (this.f14935j) {
                        return;
                    }
                    if (!g.this.f14930h.f14936k) {
                        if (this.f14934e.size() > 0) {
                            while (this.f14934e.size() > 0) {
                                a(true);
                            }
                        } else {
                            g gVar = g.this;
                            gVar.f14926d.x(gVar.f14925c, true, null, 0L);
                        }
                    }
                    synchronized (g.this) {
                        this.f14935j = true;
                    }
                    g.this.f14926d.flush();
                    g.this.d();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.p
        public r e() {
            return g.this.f14932j;
        }

        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            synchronized (g.this) {
                g.this.e();
            }
            while (this.f14934e.size() > 0) {
                a(false);
                g.this.f14926d.flush();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class b implements q {

        /* renamed from: e, reason: collision with root package name */
        public final okio.c f14938e = new okio.c();

        /* renamed from: j, reason: collision with root package name */
        public final okio.c f14939j = new okio.c();

        /* renamed from: k, reason: collision with root package name */
        public final long f14940k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f14941l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f14942m;

        public b(long j10) {
            this.f14940k = j10;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
        @Override // okio.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long U(okio.c cVar, long j10) throws StreamResetException {
            ErrorCode errorCode;
            long jU;
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            while (true) {
                synchronized (g.this) {
                    try {
                        g.this.f14931i.k();
                        try {
                            g gVar = g.this;
                            errorCode = gVar.f14933k;
                            if (errorCode == null) {
                                errorCode = null;
                            }
                            if (this.f14941l) {
                                throw new IOException("stream closed");
                            }
                            if (!gVar.f14927e.isEmpty()) {
                                g.b(g.this);
                            }
                            if (this.f14939j.size() > 0) {
                                okio.c cVar2 = this.f14939j;
                                jU = cVar2.U(cVar, Math.min(j10, cVar2.size()));
                                g gVar2 = g.this;
                                long j11 = gVar2.f14923a + jU;
                                gVar2.f14923a = j11;
                                if (errorCode == null && j11 >= gVar2.f14926d.f14866v.d() / 2) {
                                    g gVar3 = g.this;
                                    gVar3.f14926d.c0(gVar3.f14925c, gVar3.f14923a);
                                    g.this.f14923a = 0L;
                                }
                            } else {
                                if (this.f14942m || errorCode != null) {
                                    break;
                                }
                                g.this.t();
                                g.this.f14931i.u();
                            }
                        } finally {
                            g.this.f14931i.u();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (jU == -1) {
                    b(jU);
                    return jU;
                }
                if (errorCode == null) {
                    return -1L;
                }
                throw new StreamResetException(errorCode);
            }
            jU = -1;
            g.this.f14931i.u();
            if (jU == -1) {
            }
        }

        public void a(okio.e eVar, long j10) throws EOFException {
            boolean z10;
            boolean z11;
            while (j10 > 0) {
                synchronized (g.this) {
                    z10 = this.f14942m;
                    z11 = this.f14939j.size() + j10 > this.f14940k;
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
                long jU = eVar.U(this.f14938e, j10);
                if (jU == -1) {
                    throw new EOFException();
                }
                j10 -= jU;
                synchronized (g.this) {
                    try {
                        boolean z12 = this.f14939j.size() == 0;
                        this.f14939j.K(this.f14938e);
                        if (z12) {
                            g.this.notifyAll();
                        }
                    } finally {
                    }
                }
            }
        }

        public final void b(long j10) {
            g.this.f14926d.w(j10);
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (g.this) {
                try {
                    this.f14941l = true;
                    size = this.f14939j.size();
                    this.f14939j.a();
                    if (!g.this.f14927e.isEmpty()) {
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
        public r e() {
            return g.this.f14931i;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
        this.f14927e = arrayDeque;
        this.f14931i = new c();
        this.f14932j = new c();
        this.f14933k = null;
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f14925c = i10;
        this.f14926d = eVar;
        this.f14924b = eVar.f14867w.d();
        b bVar = new b(eVar.f14866v.d());
        this.f14929g = bVar;
        a aVar = new a();
        this.f14930h = aVar;
        bVar.f14942m = z11;
        aVar.f14936k = z10;
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

    public static /* synthetic */ a.InterfaceC0161a b(g gVar) {
        gVar.getClass();
        return null;
    }

    public void c(long j10) {
        this.f14924b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        boolean z10;
        boolean zM;
        synchronized (this) {
            try {
                b bVar = this.f14929g;
                if (bVar.f14942m || !bVar.f14941l) {
                    z10 = false;
                } else {
                    a aVar = this.f14930h;
                    if (aVar.f14936k || aVar.f14935j) {
                        z10 = true;
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
            this.f14926d.s(this.f14925c);
        }
    }

    public void e() throws IOException {
        a aVar = this.f14930h;
        if (aVar.f14935j) {
            throw new IOException("stream closed");
        }
        if (aVar.f14936k) {
            throw new IOException("stream finished");
        }
        if (this.f14933k != null) {
            throw new StreamResetException(this.f14933k);
        }
    }

    public void f(ErrorCode errorCode) {
        if (g(errorCode)) {
            this.f14926d.W(this.f14925c, errorCode);
        }
    }

    public final boolean g(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.f14933k != null) {
                    return false;
                }
                if (this.f14929g.f14942m && this.f14930h.f14936k) {
                    return false;
                }
                this.f14933k = errorCode;
                notifyAll();
                this.f14926d.s(this.f14925c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(ErrorCode errorCode) {
        if (g(errorCode)) {
            this.f14926d.b0(this.f14925c, errorCode);
        }
    }

    public int i() {
        return this.f14925c;
    }

    public p j() {
        synchronized (this) {
            try {
                if (!this.f14928f && !l()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f14930h;
    }

    public q k() {
        return this.f14929g;
    }

    public boolean l() {
        return this.f14926d.f14853e == ((this.f14925c & 1) == 1);
    }

    public synchronized boolean m() {
        try {
            if (this.f14933k != null) {
                return false;
            }
            b bVar = this.f14929g;
            if (bVar.f14942m || bVar.f14941l) {
                a aVar = this.f14930h;
                if (aVar.f14936k || aVar.f14935j) {
                    if (this.f14928f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public r n() {
        return this.f14931i;
    }

    public void o(okio.e eVar, int i10) throws EOFException {
        this.f14929g.a(eVar, i10);
    }

    public void p() {
        boolean zM;
        synchronized (this) {
            this.f14929g.f14942m = true;
            zM = m();
            notifyAll();
        }
        if (zM) {
            return;
        }
        this.f14926d.s(this.f14925c);
    }

    public void q(List list) {
        boolean zM;
        synchronized (this) {
            this.f14928f = true;
            this.f14927e.add(ub.c.H(list));
            zM = m();
            notifyAll();
        }
        if (zM) {
            return;
        }
        this.f14926d.s(this.f14925c);
    }

    public synchronized void r(ErrorCode errorCode) {
        if (this.f14933k == null) {
            this.f14933k = errorCode;
            notifyAll();
        }
    }

    public synchronized okhttp3.q s() {
        this.f14931i.k();
        while (this.f14927e.isEmpty() && this.f14933k == null) {
            try {
                t();
            } catch (Throwable th) {
                this.f14931i.u();
                throw th;
            }
        }
        this.f14931i.u();
        if (this.f14927e.isEmpty()) {
            throw new StreamResetException(this.f14933k);
        }
        return (okhttp3.q) this.f14927e.removeFirst();
    }

    public void t() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public r u() {
        return this.f14932j;
    }
}
