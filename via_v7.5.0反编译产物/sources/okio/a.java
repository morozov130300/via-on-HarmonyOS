package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f11431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f11432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static a f11433j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f11435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11436g;

    /* JADX INFO: renamed from: okio.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0108a implements p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f11437c;

        public C0108a(p pVar) {
            this.f11437c = pVar;
        }

        @Override // okio.p
        public void L(okio.c cVar, long j10) throws IOException {
            s.b(cVar.f11445e, 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                n nVar = cVar.f11444c;
                while (j11 < 65536) {
                    j11 += (long) (nVar.f11474c - nVar.f11473b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    }
                    nVar = nVar.f11477f;
                }
                a.this.k();
                try {
                    try {
                        this.f11437c.L(cVar, j11);
                        j10 -= j11;
                        a.this.m(true);
                    } catch (IOException e10) {
                        throw a.this.l(e10);
                    }
                } catch (Throwable th) {
                    a.this.m(false);
                    throw th;
                }
            }
        }

        @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.k();
            try {
                try {
                    this.f11437c.close();
                    a.this.m(true);
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // okio.p, java.io.Flushable
        public void flush() throws IOException {
            a.this.k();
            try {
                try {
                    this.f11437c.flush();
                    a.this.m(true);
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // okio.p
        public r i() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f11437c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements q {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f11439c;

        public b(q qVar) {
            this.f11439c = qVar;
        }

        @Override // okio.q
        public long U(okio.c cVar, long j10) throws IOException {
            a.this.k();
            try {
                try {
                    long jU = this.f11439c.U(cVar, j10);
                    a.this.m(true);
                    return jU;
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f11439c.close();
                    a.this.m(true);
                } catch (IOException e10) {
                    throw a.this.l(e10);
                }
            } catch (Throwable th) {
                a.this.m(false);
                throw th;
            }
        }

        @Override // okio.q
        public r i() {
            return a.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f11439c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0017, code lost:
        
            r1.t();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<okio.a> r0 = okio.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                okio.a r1 = okio.a.i()     // Catch: java.lang.Throwable -> Lb
                if (r1 != 0) goto Ld
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r1 = move-exception
                goto L1b
            Ld:
                okio.a r2 = okio.a.f11433j     // Catch: java.lang.Throwable -> Lb
                if (r1 != r2) goto L16
                r1 = 0
                okio.a.f11433j = r1     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                r1.t()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L1b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L1e
            L1d:
                throw r1
            L1e:
                goto L1d
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f11431h = millis;
        f11432i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static a i() throws InterruptedException {
        a aVar = f11433j.f11435f;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(f11431h);
            if (f11433j.f11435f != null || System.nanoTime() - jNanoTime < f11432i) {
                return null;
            }
            return f11433j;
        }
        long jP = aVar.p(System.nanoTime());
        if (jP > 0) {
            long j10 = jP / 1000000;
            a.class.wait(j10, (int) (jP - (1000000 * j10)));
            return null;
        }
        f11433j.f11435f = aVar.f11435f;
        aVar.f11435f = null;
        return aVar;
    }

    public static synchronized boolean j(a aVar) {
        a aVar2 = f11433j;
        while (aVar2 != null) {
            a aVar3 = aVar2.f11435f;
            if (aVar3 == aVar) {
                aVar2.f11435f = aVar.f11435f;
                aVar.f11435f = null;
                return false;
            }
            aVar2 = aVar3;
        }
        return true;
    }

    public static synchronized void q(a aVar, long j10, boolean z10) {
        try {
            if (f11433j == null) {
                f11433j = new a();
                new c().start();
            }
            long jNanoTime = System.nanoTime();
            if (j10 != 0 && z10) {
                aVar.f11436g = Math.min(j10, aVar.c() - jNanoTime) + jNanoTime;
            } else if (j10 != 0) {
                aVar.f11436g = j10 + jNanoTime;
            } else {
                if (!z10) {
                    throw new AssertionError();
                }
                aVar.f11436g = aVar.c();
            }
            long jP = aVar.p(jNanoTime);
            a aVar2 = f11433j;
            while (true) {
                a aVar3 = aVar2.f11435f;
                if (aVar3 == null || jP < aVar3.p(jNanoTime)) {
                    break;
                    break;
                }
                aVar2 = aVar2.f11435f;
            }
            aVar.f11435f = aVar2.f11435f;
            aVar2.f11435f = aVar;
            if (aVar2 == f11433j) {
                a.class.notify();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void k() {
        if (this.f11434e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            this.f11434e = true;
            q(this, jH, zE);
        }
    }

    public final IOException l(IOException iOException) {
        return !n() ? iOException : o(iOException);
    }

    public final void m(boolean z10) throws IOException {
        if (n() && z10) {
            throw o(null);
        }
    }

    public final boolean n() {
        if (!this.f11434e) {
            return false;
        }
        this.f11434e = false;
        return j(this);
    }

    public IOException o(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long p(long j10) {
        return this.f11436g - j10;
    }

    public final p r(p pVar) {
        return new C0108a(pVar);
    }

    public final q s(q qVar) {
        return new b(qVar);
    }

    public void t() {
    }
}
