package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends p.c implements s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f6674c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f6675e;

    public f(ThreadFactory threadFactory) {
        this.f6674c = g.a(threadFactory);
    }

    @Override // r6.p.c
    public s6.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // r6.p.c
    public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f6675e ? EmptyDisposable.INSTANCE : e(runnable, j10, timeUnit, null);
    }

    @Override // s6.b
    public void dispose() {
        if (this.f6675e) {
            return;
        }
        this.f6675e = true;
        this.f6674c.shutdownNow();
    }

    public ScheduledRunnable e(Runnable runnable, long j10, TimeUnit timeUnit, s6.c cVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(z6.a.q(runnable), cVar);
        if (cVar != null && !cVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.setFuture(j10 <= 0 ? this.f6674c.submit((Callable) scheduledRunnable) : this.f6674c.schedule((Callable) scheduledRunnable, j10, timeUnit));
            return scheduledRunnable;
        } catch (RejectedExecutionException e10) {
            if (cVar != null) {
                cVar.c(scheduledRunnable);
            }
            z6.a.o(e10);
            return scheduledRunnable;
        }
    }

    public s6.b f(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(z6.a.q(runnable), true);
        try {
            scheduledDirectTask.setFuture(j10 <= 0 ? this.f6674c.submit(scheduledDirectTask) : this.f6674c.schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            z6.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    public s6.b g(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableQ = z6.a.q(runnable);
        if (j11 <= 0) {
            c cVar = new c(runnableQ, this.f6674c);
            try {
                cVar.c(j10 <= 0 ? this.f6674c.submit(cVar) : this.f6674c.schedule(cVar, j10, timeUnit));
                return cVar;
            } catch (RejectedExecutionException e10) {
                z6.a.o(e10);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableQ, true);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f6674c.scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            z6.a.o(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void h() {
        if (this.f6675e) {
            return;
        }
        this.f6675e = true;
        this.f6674c.shutdown();
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f6675e;
    }
}
