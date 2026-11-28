package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f6680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f6681f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f6682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f6683d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScheduledExecutorService f6684c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s6.a f6685e = new s6.a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile boolean f6686m;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f6684c = scheduledExecutorService;
        }

        @Override // r6.p.c
        public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f6686m) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(z6.a.q(runnable), this.f6685e);
            this.f6685e.b(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j10 <= 0 ? this.f6684c.submit((Callable) scheduledRunnable) : this.f6684c.schedule((Callable) scheduledRunnable, j10, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e10) {
                dispose();
                z6.a.o(e10);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // s6.b
        public void dispose() {
            if (this.f6686m) {
                return;
            }
            this.f6686m = true;
            this.f6685e.dispose();
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6686m;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f6681f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f6680e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public h() {
        this(f6680e);
    }

    public static ScheduledExecutorService g(ThreadFactory threadFactory) {
        return g.a(threadFactory);
    }

    @Override // r6.p
    public p.c c() {
        return new a((ScheduledExecutorService) this.f6683d.get());
    }

    @Override // r6.p
    public s6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(z6.a.q(runnable), true);
        try {
            scheduledDirectTask.setFuture(j10 <= 0 ? ((ScheduledExecutorService) this.f6683d.get()).submit(scheduledDirectTask) : ((ScheduledExecutorService) this.f6683d.get()).schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            z6.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // r6.p
    public s6.b f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableQ = z6.a.q(runnable);
        if (j11 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableQ, true);
            try {
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f6683d.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e10) {
                z6.a.o(e10);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f6683d.get();
        c cVar = new c(runnableQ, scheduledExecutorService);
        try {
            cVar.c(j10 <= 0 ? scheduledExecutorService.submit(cVar) : scheduledExecutorService.schedule(cVar, j10, timeUnit));
            return cVar;
        } catch (RejectedExecutionException e11) {
            z6.a.o(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public h(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f6683d = atomicReference;
        this.f6682c = threadFactory;
        atomicReference.lazySet(g(threadFactory));
    }
}
