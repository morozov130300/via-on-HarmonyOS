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
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f6652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RxThreadFactory f6653f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f6656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f6657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f6658k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f6659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f6660d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TimeUnit f6655h = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f6654g = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f6661c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ConcurrentLinkedQueue f6662e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final s6.a f6663m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final ScheduledExecutorService f6664n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Future f6665o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final ThreadFactory f6666p;

        public a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            a aVar;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f6661c = nanos;
            this.f6662e = new ConcurrentLinkedQueue();
            this.f6663m = new s6.a();
            this.f6666p = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, d.f6653f);
                aVar = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(aVar, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                aVar = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            aVar.f6664n = scheduledExecutorServiceNewScheduledThreadPool;
            aVar.f6665o = scheduledFutureScheduleWithFixedDelay;
        }

        public static void a(ConcurrentLinkedQueue concurrentLinkedQueue, s6.a aVar) {
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long jC = c();
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.i() > jC) {
                    return;
                }
                if (concurrentLinkedQueue.remove(cVar)) {
                    aVar.c(cVar);
                }
            }
        }

        public static long c() {
            return System.nanoTime();
        }

        public c b() {
            if (this.f6663m.isDisposed()) {
                return d.f6656i;
            }
            while (!this.f6662e.isEmpty()) {
                c cVar = (c) this.f6662e.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            c cVar2 = new c(this.f6666p);
            this.f6663m.b(cVar2);
            return cVar2;
        }

        public void d(c cVar) {
            cVar.j(c() + this.f6661c);
            this.f6662e.offer(cVar);
        }

        public void e() {
            this.f6663m.dispose();
            Future future = this.f6665o;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f6664n;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.f6662e, this.f6663m);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends p.c implements Runnable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f6668e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final c f6669m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final AtomicBoolean f6670n = new AtomicBoolean();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s6.a f6667c = new s6.a();

        public b(a aVar) {
            this.f6668e = aVar;
            this.f6669m = aVar.b();
        }

        @Override // r6.p.c
        public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f6667c.isDisposed() ? EmptyDisposable.INSTANCE : this.f6669m.e(runnable, j10, timeUnit, this.f6667c);
        }

        @Override // s6.b
        public void dispose() {
            if (this.f6670n.compareAndSet(false, true)) {
                this.f6667c.dispose();
                if (d.f6657j) {
                    this.f6669m.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f6668e.d(this.f6669m);
                }
            }
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6670n.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6668e.d(this.f6669m);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c extends f {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f6671m;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f6671m = 0L;
        }

        public long i() {
            return this.f6671m;
        }

        public void j(long j10) {
            this.f6671m = j10;
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f6656i = cVar;
        cVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f6652e = rxThreadFactory;
        f6653f = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        f6657j = Boolean.getBoolean("rx3.io-scheduled-release");
        a aVar = new a(0L, null, rxThreadFactory);
        f6658k = aVar;
        aVar.e();
    }

    public d() {
        this(f6652e);
    }

    @Override // r6.p
    public p.c c() {
        return new b((a) this.f6660d.get());
    }

    public void g() {
        a aVar = new a(f6654g, f6655h, this.f6659c);
        if (autodispose2.c.a(this.f6660d, f6658k, aVar)) {
            return;
        }
        aVar.e();
    }

    public d(ThreadFactory threadFactory) {
        this.f6659c = threadFactory;
        this.f6660d = new AtomicReference(f6658k);
        g();
    }
}
