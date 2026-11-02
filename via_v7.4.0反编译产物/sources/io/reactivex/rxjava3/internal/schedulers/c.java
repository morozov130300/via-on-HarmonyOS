package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends n {

    /* renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f7417e;

    /* renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f7418f;

    /* renamed from: i, reason: collision with root package name */
    public static final C0086c f7421i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f7422j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f7423k;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadFactory f7424c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f7425d;

    /* renamed from: h, reason: collision with root package name */
    public static final TimeUnit f7420h = TimeUnit.SECONDS;

    /* renamed from: g, reason: collision with root package name */
    public static final long f7419g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final long f7426e;

        /* renamed from: j, reason: collision with root package name */
        public final ConcurrentLinkedQueue f7427j;

        /* renamed from: k, reason: collision with root package name */
        public final y6.a f7428k;

        /* renamed from: l, reason: collision with root package name */
        public final ScheduledExecutorService f7429l;

        /* renamed from: m, reason: collision with root package name */
        public final Future f7430m;

        /* renamed from: n, reason: collision with root package name */
        public final ThreadFactory f7431n;

        public a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f7426e = nanos;
            this.f7427j = new ConcurrentLinkedQueue();
            this.f7428k = new y6.a();
            this.f7431n = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, c.f7418f);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.f7429l = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.f7430m = scheduledFutureScheduleWithFixedDelay;
        }

        public static void a(ConcurrentLinkedQueue concurrentLinkedQueue, y6.a aVar) {
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long jC = c();
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                C0086c c0086c = (C0086c) it.next();
                if (c0086c.g() > jC) {
                    return;
                }
                if (concurrentLinkedQueue.remove(c0086c)) {
                    aVar.c(c0086c);
                }
            }
        }

        public static long c() {
            return System.nanoTime();
        }

        public C0086c b() {
            if (this.f7428k.isDisposed()) {
                return c.f7421i;
            }
            while (!this.f7427j.isEmpty()) {
                C0086c c0086c = (C0086c) this.f7427j.poll();
                if (c0086c != null) {
                    return c0086c;
                }
            }
            C0086c c0086c2 = new C0086c(this.f7431n);
            this.f7428k.b(c0086c2);
            return c0086c2;
        }

        public void d(C0086c c0086c) {
            c0086c.h(c() + this.f7426e);
            this.f7427j.offer(c0086c);
        }

        public void e() {
            this.f7428k.dispose();
            Future future = this.f7430m;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f7429l;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.f7427j, this.f7428k);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends n.b implements Runnable {

        /* renamed from: j, reason: collision with root package name */
        public final a f7433j;

        /* renamed from: k, reason: collision with root package name */
        public final C0086c f7434k;

        /* renamed from: l, reason: collision with root package name */
        public final AtomicBoolean f7435l = new AtomicBoolean();

        /* renamed from: e, reason: collision with root package name */
        public final y6.a f7432e = new y6.a();

        public b(a aVar) {
            this.f7433j = aVar;
            this.f7434k = aVar.b();
        }

        @Override // x6.n.b
        public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f7432e.isDisposed() ? EmptyDisposable.INSTANCE : this.f7434k.d(runnable, j10, timeUnit, this.f7432e);
        }

        @Override // y6.b
        public void dispose() {
            if (this.f7435l.compareAndSet(false, true)) {
                this.f7432e.dispose();
                if (c.f7422j) {
                    this.f7434k.d(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f7433j.d(this.f7434k);
                }
            }
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7435l.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7433j.d(this.f7434k);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: io.reactivex.rxjava3.internal.schedulers.c$c, reason: collision with other inner class name */
    public static final class C0086c extends e {

        /* renamed from: k, reason: collision with root package name */
        public long f7436k;

        public C0086c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f7436k = 0L;
        }

        public long g() {
            return this.f7436k;
        }

        public void h(long j10) {
            this.f7436k = j10;
        }
    }

    static {
        C0086c c0086c = new C0086c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f7421i = c0086c;
        c0086c.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f7417e = rxThreadFactory;
        f7418f = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        f7422j = Boolean.getBoolean("rx3.io-scheduled-release");
        a aVar = new a(0L, null, rxThreadFactory);
        f7423k = aVar;
        aVar.e();
    }

    public c() {
        this(f7417e);
    }

    public c(ThreadFactory threadFactory) {
        this.f7424c = threadFactory;
        this.f7425d = new AtomicReference(f7423k);
        f();
    }

    @Override // x6.n
    public n.b c() {
        return new b((a) this.f7425d.get());
    }

    public void f() {
        a aVar = new a(f7419g, f7420h, this.f7424c);
        if (autodispose2.c.a(this.f7425d, f7423k, aVar)) {
            return;
        }
        aVar.e();
    }
}
