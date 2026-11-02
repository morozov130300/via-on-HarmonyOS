package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends n.b implements y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final ScheduledExecutorService f7439e;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f7440j;

    public e(ThreadFactory threadFactory) {
        this.f7439e = f.a(threadFactory);
    }

    @Override // x6.n.b
    public y6.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // x6.n.b
    public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f7440j ? EmptyDisposable.INSTANCE : d(runnable, j10, timeUnit, null);
    }

    public ScheduledRunnable d(Runnable runnable, long j10, TimeUnit timeUnit, y6.c cVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(f7.a.q(runnable), cVar);
        if (cVar != null && !cVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.setFuture(j10 <= 0 ? this.f7439e.submit((Callable) scheduledRunnable) : this.f7439e.schedule((Callable) scheduledRunnable, j10, timeUnit));
            return scheduledRunnable;
        } catch (RejectedExecutionException e10) {
            if (cVar != null) {
                cVar.c(scheduledRunnable);
            }
            f7.a.o(e10);
            return scheduledRunnable;
        }
    }

    @Override // y6.b
    public void dispose() {
        if (this.f7440j) {
            return;
        }
        this.f7440j = true;
        this.f7439e.shutdownNow();
    }

    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(f7.a.q(runnable), true);
        try {
            scheduledDirectTask.setFuture(j10 <= 0 ? this.f7439e.submit(scheduledDirectTask) : this.f7439e.schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            f7.a.o(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void f() {
        if (this.f7440j) {
            return;
        }
        this.f7440j = true;
        this.f7439e.shutdown();
    }

    @Override // y6.b
    public boolean isDisposed() {
        return this.f7440j;
    }
}
