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
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ExecutorScheduler extends n {

    /* renamed from: f, reason: collision with root package name */
    public static final n f7386f = g7.a.d();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7387c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7388d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f7389e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, y6.b {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // y6.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable != null ? runnable : c7.a.f2309b;
        }

        @Override // y6.b
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
                        SequentialDisposable sequentialDisposable = this.timed;
                        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                        sequentialDisposable.lazySet(disposableHelper);
                        this.direct.lazySet(disposableHelper);
                    } catch (Throwable th) {
                        lazySet(null);
                        this.timed.lazySet(DisposableHelper.DISPOSED);
                        this.direct.lazySet(DisposableHelper.DISPOSED);
                        throw th;
                    }
                } catch (Throwable th2) {
                    f7.a.o(th2);
                    throw th2;
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class ExecutorWorker extends n.b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final boolean f7390e;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f7391j;

        /* renamed from: k, reason: collision with root package name */
        public final Executor f7392k;

        /* renamed from: m, reason: collision with root package name */
        public volatile boolean f7394m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicInteger f7395n = new AtomicInteger();

        /* renamed from: o, reason: collision with root package name */
        public final y6.a f7396o = new y6.a();

        /* renamed from: l, reason: collision with root package name */
        public final MpscLinkedQueue f7393l = new MpscLinkedQueue();

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, y6.b {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // y6.b
            public void dispose() {
                lazySet(true);
            }

            @Override // y6.b
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
                } finally {
                }
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, y6.b {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final y6.c tasks;
            volatile Thread thread;

            public InterruptibleRunnable(Runnable runnable, y6.c cVar) {
                this.run = runnable;
                this.tasks = cVar;
            }

            public void cleanup() {
                y6.c cVar = this.tasks;
                if (cVar != null) {
                    cVar.a(this);
                }
            }

            @Override // y6.b
            public void dispose() {
                while (true) {
                    int i10 = get();
                    if (i10 >= 2) {
                        return;
                    }
                    if (i10 == 0) {
                        if (compareAndSet(0, INTERRUPTED)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(INTERRUPTED);
                        cleanup();
                        return;
                    }
                }
            }

            @Override // y6.b
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
                            f7.a.o(th);
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

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public final class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            public final SequentialDisposable f7397e;

            /* renamed from: j, reason: collision with root package name */
            public final Runnable f7398j;

            public a(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f7397e = sequentialDisposable;
                this.f7398j = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7397e.replace(ExecutorWorker.this.b(this.f7398j));
            }
        }

        public ExecutorWorker(Executor executor, boolean z10, boolean z11) {
            this.f7392k = executor;
            this.f7390e = z10;
            this.f7391j = z11;
        }

        @Override // x6.n.b
        public y6.b b(Runnable runnable) {
            y6.b booleanRunnable;
            if (this.f7394m) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable runnableQ = f7.a.q(runnable);
            if (this.f7390e) {
                booleanRunnable = new InterruptibleRunnable(runnableQ, this.f7396o);
                this.f7396o.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnableQ);
            }
            this.f7393l.offer(booleanRunnable);
            if (this.f7395n.getAndIncrement() != 0) {
                return booleanRunnable;
            }
            try {
                this.f7392k.execute(this);
                return booleanRunnable;
            } catch (RejectedExecutionException e10) {
                this.f7394m = true;
                this.f7393l.clear();
                f7.a.o(e10);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // x6.n.b
        public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (j10 <= 0) {
                return b(runnable);
            }
            if (this.f7394m) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new a(sequentialDisposable2, f7.a.q(runnable)), this.f7396o);
            this.f7396o.b(scheduledRunnable);
            Executor executor = this.f7392k;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j10, timeUnit));
                } catch (RejectedExecutionException e10) {
                    this.f7394m = true;
                    f7.a.o(e10);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new b(ExecutorScheduler.f7386f.e(scheduledRunnable, j10, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        public void d() {
            MpscLinkedQueue mpscLinkedQueue = this.f7393l;
            int iAddAndGet = 1;
            while (!this.f7394m) {
                do {
                    Runnable runnable = (Runnable) mpscLinkedQueue.poll();
                    if (runnable != null) {
                        runnable.run();
                    } else if (this.f7394m) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        iAddAndGet = this.f7395n.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f7394m);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        @Override // y6.b
        public void dispose() {
            if (this.f7394m) {
                return;
            }
            this.f7394m = true;
            this.f7396o.dispose();
            if (this.f7395n.getAndIncrement() == 0) {
                this.f7393l.clear();
            }
        }

        public void e() {
            MpscLinkedQueue mpscLinkedQueue = this.f7393l;
            if (this.f7394m) {
                mpscLinkedQueue.clear();
                return;
            }
            ((Runnable) mpscLinkedQueue.poll()).run();
            if (this.f7394m) {
                mpscLinkedQueue.clear();
            } else if (this.f7395n.decrementAndGet() != 0) {
                this.f7392k.execute(this);
            }
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f7394m;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7391j) {
                e();
            } else {
                d();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final DelayedRunnable f7400e;

        public a(DelayedRunnable delayedRunnable) {
            this.f7400e = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f7400e;
            delayedRunnable.direct.replace(ExecutorScheduler.this.d(delayedRunnable));
        }
    }

    public ExecutorScheduler(Executor executor, boolean z10, boolean z11) {
        this.f7389e = executor;
        this.f7387c = z10;
        this.f7388d = z11;
    }

    @Override // x6.n
    public n.b c() {
        return new ExecutorWorker(this.f7389e, this.f7387c, this.f7388d);
    }

    @Override // x6.n
    public y6.b d(Runnable runnable) {
        Runnable runnableQ = f7.a.q(runnable);
        try {
            if (this.f7389e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableQ, this.f7387c);
                scheduledDirectTask.setFuture(((ExecutorService) this.f7389e).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f7387c) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnableQ, null);
                this.f7389e.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnableQ);
            this.f7389e.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e10) {
            f7.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // x6.n
    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        Runnable runnableQ = f7.a.q(runnable);
        if (!(this.f7389e instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(runnableQ);
            delayedRunnable.timed.replace(f7386f.e(new a(delayedRunnable), j10, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableQ, this.f7387c);
            scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f7389e).schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            f7.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }
}
