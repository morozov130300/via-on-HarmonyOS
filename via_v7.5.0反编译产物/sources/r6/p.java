package r6;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12043a = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f12044b = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements s6.b, Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f12045c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f12046e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Thread f12047m;

        public a(Runnable runnable, c cVar) {
            this.f12045c = runnable;
            this.f12046e = cVar;
        }

        @Override // s6.b
        public void dispose() {
            if (this.f12047m == Thread.currentThread()) {
                c cVar = this.f12046e;
                if (cVar instanceof io.reactivex.rxjava3.internal.schedulers.f) {
                    ((io.reactivex.rxjava3.internal.schedulers.f) cVar).h();
                    return;
                }
            }
            this.f12046e.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f12046e.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12047m = Thread.currentThread();
            try {
                this.f12045c.run();
                dispose();
                this.f12047m = null;
            } catch (Throwable th) {
                try {
                    z6.a.o(th);
                    throw th;
                } catch (Throwable th2) {
                    dispose();
                    this.f12047m = null;
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements s6.b, Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f12048c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f12049e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile boolean f12050m;

        public b(Runnable runnable, c cVar) {
            this.f12048c = runnable;
            this.f12049e = cVar;
        }

        @Override // s6.b
        public void dispose() {
            this.f12050m = true;
            this.f12049e.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f12050m;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12050m) {
                return;
            }
            try {
                this.f12048c.run();
            } catch (Throwable th) {
                dispose();
                z6.a.o(th);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class c implements s6.b {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Runnable f12051c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final SequentialDisposable f12052e;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final long f12053m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public long f12054n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public long f12055o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public long f12056p;

            public a(long j10, Runnable runnable, long j11, SequentialDisposable sequentialDisposable, long j12) {
                this.f12051c = runnable;
                this.f12052e = sequentialDisposable;
                this.f12053m = j12;
                this.f12055o = j11;
                this.f12056p = j10;
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0035  */
            @Override // java.lang.Runnable
            public void run() {
                long j10;
                this.f12051c.run();
                if (this.f12052e.isDisposed()) {
                    return;
                }
                c cVar = c.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jA = cVar.a(timeUnit);
                long j11 = p.f12044b;
                long j12 = jA + j11;
                long j13 = this.f12055o;
                if (j12 >= j13) {
                    long j14 = this.f12053m;
                    if (jA >= j13 + j14 + j11) {
                        long j15 = this.f12053m;
                        long j16 = jA + j15;
                        long j17 = this.f12054n + 1;
                        this.f12054n = j17;
                        this.f12056p = j16 - (j15 * j17);
                        j10 = j16;
                    } else {
                        long j18 = this.f12056p;
                        long j19 = this.f12054n + 1;
                        this.f12054n = j19;
                        j10 = j18 + (j19 * j14);
                    }
                } else {
                    long j110 = this.f12053m;
                    long j111 = jA + j110;
                    long j112 = this.f12054n + 1;
                    this.f12054n = j112;
                    this.f12056p = j111 - (j110 * j112);
                    j10 = j111;
                }
                this.f12055o = jA;
                this.f12052e.replace(c.this.c(this, j10 - jA, timeUnit));
            }
        }

        public long a(TimeUnit timeUnit) {
            return p.b(timeUnit);
        }

        public s6.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract s6.b c(Runnable runnable, long j10, TimeUnit timeUnit);

        public s6.b d(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableQ = z6.a.q(runnable);
            long nanos = timeUnit.toNanos(j11);
            long jA = a(TimeUnit.NANOSECONDS);
            s6.b bVarC = c(new a(jA + timeUnit.toNanos(j10), runnableQ, jA, sequentialDisposable2, nanos), j10, timeUnit);
            if (bVarC == EmptyDisposable.INSTANCE) {
                return bVarC;
            }
            sequentialDisposable.replace(bVarC);
            return sequentialDisposable2;
        }
    }

    public static long a(long j10, String str) {
        if ("seconds".equalsIgnoreCase(str)) {
            return TimeUnit.SECONDS.toNanos(j10);
        }
        return "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j10) : TimeUnit.MINUTES.toNanos(j10);
    }

    public static long b(TimeUnit timeUnit) {
        return !f12043a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract c c();

    public s6.b d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public s6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        c cVarC = c();
        a aVar = new a(z6.a.q(runnable), cVarC);
        cVarC.c(aVar, j10, timeUnit);
        return aVar;
    }

    public s6.b f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        c cVarC = c();
        b bVar = new b(z6.a.q(runnable), cVarC);
        s6.b bVarD = cVarC.d(bVar, j10, j11, timeUnit);
        return bVarD == EmptyDisposable.INSTANCE ? bVarD : bVar;
    }
}
