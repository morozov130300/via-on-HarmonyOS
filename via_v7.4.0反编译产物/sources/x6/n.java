package x6;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f13615a = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* renamed from: b, reason: collision with root package name */
    public static final long f13616b = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements y6.b, Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final Runnable f13617e;

        /* renamed from: j, reason: collision with root package name */
        public final b f13618j;

        /* renamed from: k, reason: collision with root package name */
        public Thread f13619k;

        public a(Runnable runnable, b bVar) {
            this.f13617e = runnable;
            this.f13618j = bVar;
        }

        @Override // y6.b
        public void dispose() {
            if (this.f13619k == Thread.currentThread()) {
                b bVar = this.f13618j;
                if (bVar instanceof io.reactivex.rxjava3.internal.schedulers.e) {
                    ((io.reactivex.rxjava3.internal.schedulers.e) bVar).f();
                    return;
                }
            }
            this.f13618j.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f13618j.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13619k = Thread.currentThread();
            try {
                this.f13617e.run();
            } finally {
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class b implements y6.b {
        public long a(TimeUnit timeUnit) {
            return n.b(timeUnit);
        }

        public y6.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract y6.b c(Runnable runnable, long j10, TimeUnit timeUnit);
    }

    public static long a(long j10, String str) {
        return "seconds".equalsIgnoreCase(str) ? TimeUnit.SECONDS.toNanos(j10) : "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j10) : TimeUnit.MINUTES.toNanos(j10);
    }

    public static long b(TimeUnit timeUnit) {
        return !f13615a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract b c();

    public y6.b d(Runnable runnable) {
        return e(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        b bVarC = c();
        a aVar = new a(f7.a.q(runnable), bVarC);
        bVarC.c(aVar, j10, timeUnit);
        return aVar;
    }
}
