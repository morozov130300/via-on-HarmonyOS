package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorScheduler extends p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f6615f = a7.a.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f6618e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, s6.b {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // s6.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable != null ? runnable : w6.a.f13675b;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    try {
                        runnable.run();
                        lazySet(null);
                        this.timed.lazySet(DisposableHelper.DISPOSED);
                        SequentialDisposable sequentialDisposable = this.direct;
                    } finally {
                        lazySet(null);
                        this.timed.lazySet(DisposableHelper.DISPOSED);
                        this.direct.lazySet(DisposableHelper.DISPOSED);
                    }
                } catch (Throwable th) {
                    z6.a.o(th);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class ExecutorWorker extends p.c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f6619c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f6620e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Executor f6621m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public volatile boolean f6623o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final AtomicInteger f6624p = new AtomicInteger();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final s6.a f6625q = new s6.a();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final MpscLinkedQueue f6622n = new MpscLinkedQueue();

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, s6.b {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // s6.b
            public void dispose() {
                lazySet(true);
            }

            @Override // s6.b
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                    lazySet(true);
                } catch (Throwable th) {
                    try {
                        z6.a.o(th);
                        throw th;
                    } catch (Throwable th2) {
                        lazySet(true);
                        throw th2;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, s6.b {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final s6.c tasks;
            volatile Thread thread;

            public InterruptibleRunnable(Runnable runnable, s6.c cVar) {
                this.run = runnable;
                this.tasks = cVar;
            }

            public void cleanup() {
                s6.c cVar = this.tasks;
                if (cVar != null) {
                    cVar.a(this);
                }
            }

            @Override // s6.b
            public void dispose() {
                while (true) {
                    int i10 = get();
                    if (i10 >= 2) {
                        return;
                    }
                    if (i10 == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            @Override // s6.b
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.thread = null;
                        return;
                    }
                    try {
                        this.run.run();
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            cleanup();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th) {
                        try {
                            z6.a.o(th);
                            throw th;
                        } catch (Throwable th2) {
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                cleanup();
                            } else {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            }
                            throw th2;
                        }
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public final class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final SequentialDisposable f6626c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Runnable f6627e;

            public a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f6626c = sequentialDisposable;
                this.f6627e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6626c.replace(ExecutorWorker.this.b(this.f6627e));
            }
        }

        public ExecutorWorker(Executor executor, boolean z10, boolean z11) {
            this.f6621m = executor;
            this.f6619c = z10;
            this.f6620e = z11;
        }

        @Override // r6.p.c
        public s6.b b(Runnable runnable) {
            s6.b booleanRunnable;
            if (this.f6623o) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable runnableQ = z6.a.q(runnable);
            if (this.f6619c) {
                booleanRunnable = new InterruptibleRunnable(runnableQ, this.f6625q);
                this.f6625q.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnableQ);
            }
            this.f6622n.offer(booleanRunnable);
            if (this.f6624p.getAndIncrement() != 0) {
                return booleanRunnable;
            }
            try {
                this.f6621m.execute(this);
                return booleanRunnable;
            } catch (RejectedExecutionException e10) {
                this.f6623o = true;
                this.f6622n.clear();
                z6.a.o(e10);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // r6.p.c
        public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (j10 <= 0) {
                return b(runnable);
            }
            if (this.f6623o) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, z6.a.q(runnable)), this.f6625q);
            this.f6625q.b(scheduledRunnable);
            Executor executor = this.f6621m;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j10, timeUnit));
                } catch (RejectedExecutionException e10) {
                    this.f6623o = true;
                    z6.a.o(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new b(ExecutorScheduler.f6615f.e(scheduledRunnable, j10, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // s6.b
        public void dispose() {
            if (this.f6623o) {
                return;
            }
            this.f6623o = true;
            this.f6625q.dispose();
            if (this.f6624p.getAndIncrement() == 0) {
                this.f6622n.clear();
            }
        }

        public void e() {
            MpscLinkedQueue mpscLinkedQueue = this.f6622n;
            int iAddAndGet = 1;
            while (!this.f6623o) {
                while (true) {
                    Runnable runnable = (Runnable) mpscLinkedQueue.poll();
                    if (runnable == null) {
                        break;
                    }
                    runnable.run();
                    if (this.f6623o) {
                        mpscLinkedQueue.clear();
                        return;
                    }
                }
                if (this.f6623o) {
                    mpscLinkedQueue.clear();
                    return;
                } else {
                    iAddAndGet = this.f6624p.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            mpscLinkedQueue.clear();
        }

        public void f() {
            MpscLinkedQueue mpscLinkedQueue = this.f6622n;
            if (this.f6623o) {
                mpscLinkedQueue.clear();
                return;
            }
            ((Runnable) mpscLinkedQueue.poll()).run();
            if (this.f6623o) {
                mpscLinkedQueue.clear();
            } else if (this.f6624p.decrementAndGet() != 0) {
                this.f6621m.execute(this);
            }
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f6623o;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6620e) {
                f();
            } else {
                e();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DelayedRunnable f6629c;

        public a(DelayedRunnable delayedRunnable) {
            this.f6629c = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f6629c;
            delayedRunnable.direct.replace(ExecutorScheduler.this.d(delayedRunnable));
        }
    }

    public ExecutorScheduler(Executor executor, boolean z10, boolean z11) {
        this.f6618e = executor;
        this.f6616c = z10;
        this.f6617d = z11;
    }

    @Override // r6.p
    public p.c c() {
        return new ExecutorWorker(this.f6618e, this.f6616c, this.f6617d);
    }

    @Override // r6.p
    public s6.b d(Runnable runnable) {
        Runnable runnableQ = z6.a.q(runnable);
        try {
            if (this.f6618e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableQ, this.f6616c);
                scheduledDirectTask.setFuture(((ExecutorService) this.f6618e).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f6616c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnableQ, null);
                this.f6618e.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnableQ);
            this.f6618e.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e10) {
            z6.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // r6.p
    public s6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        Runnable runnableQ = z6.a.q(runnable);
        if (!(this.f6618e instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(runnableQ);
            delayedRunnable.timed.replace(f6615f.e(new a(delayedRunnable), j10, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableQ, this.f6616c);
            scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f6618e).schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            z6.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // r6.p
    public s6.b f(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        if (!(this.f6618e instanceof ScheduledExecutorService)) {
            return super.f(runnable, j10, j11, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(z6.a.q(runnable), this.f6616c);
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f6618e).scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e10) {
            z6.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }
}
