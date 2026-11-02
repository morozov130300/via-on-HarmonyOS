package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g extends n {

    /* renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f7445e;

    /* renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f7446f;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadFactory f7447c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f7448d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends n.b {

        /* renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f7449e;

        /* renamed from: j, reason: collision with root package name */
        public final y6.a f7450j = new y6.a();

        /* renamed from: k, reason: collision with root package name */
        public volatile boolean f7451k;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f7449e = scheduledExecutorService;
        }

        @Override // x6.n.b
        public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f7451k) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(f7.a.q(runnable), this.f7450j);
            this.f7450j.b(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j10 <= 0 ? this.f7449e.submit((Callable) scheduledRunnable) : this.f7449e.schedule((Callable) scheduledRunnable, j10, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e10) {
                dispose();
                f7.a.o(e10);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // y6.b
        public void dispose() {
            if (this.f7451k) {
                return;
            }
            this.f7451k = true;
            this.f7450j.dispose();
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7451k;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f7446f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f7445e = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public g() {
        this(f7445e);
    }

    public g(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f7448d = atomicReference;
        this.f7447c = threadFactory;
        atomicReference.lazySet(f(threadFactory));
    }

    public static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return f.a(threadFactory);
    }

    @Override // x6.n
    public n.b c() {
        return new a((ScheduledExecutorService) this.f7448d.get());
    }

    @Override // x6.n
    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(f7.a.q(runnable), true);
        try {
            scheduledDirectTask.setFuture(j10 <= 0 ? ((ScheduledExecutorService) this.f7448d.get()).submit(scheduledDirectTask) : ((ScheduledExecutorService) this.f7448d.get()).schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            f7.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }
}
