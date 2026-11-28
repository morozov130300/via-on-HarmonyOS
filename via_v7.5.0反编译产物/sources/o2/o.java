package o2;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o implements ScheduledExecutorService, AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f10909c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScheduledExecutorService f10910e;

    public o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f10909c = executorService;
        this.f10910e = scheduledExecutorService;
    }

    public static /* synthetic */ void g(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    public static /* synthetic */ void h(Runnable runnable, p.b bVar) throws Exception {
        try {
            runnable.run();
        } catch (Exception e10) {
            bVar.a(e10);
            throw e10;
        }
    }

    public static /* synthetic */ void l(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    public static /* synthetic */ void n(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e10) {
            bVar.a(e10);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return this.f10909c.awaitTermination(j10, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        c0.e.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f10909c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f10909c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f10909c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f10909c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f10909c.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j10, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: o2.c
            @Override // o2.p.c
            public final ScheduledFuture a(p.b bVar) {
                o oVar = this.f10871a;
                return oVar.f10910e.schedule(new Runnable() { // from class: o2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        oVar.f10909c.execute(new Runnable() { // from class: o2.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                o.n(runnable, bVar);
                            }
                        });
                    }
                }, j10, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j10, final long j11, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: o2.f
            @Override // o2.p.c
            public final ScheduledFuture a(p.b bVar) {
                o oVar = this.f10879a;
                return oVar.f10910e.scheduleAtFixedRate(new Runnable() { // from class: o2.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        oVar.f10909c.execute(new Runnable() { // from class: o2.d
                            @Override // java.lang.Runnable
                            public final void run() throws Exception {
                                o.h(runnable, bVar);
                            }
                        });
                    }
                }, j10, j11, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j10, final long j11, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: o2.g
            @Override // o2.p.c
            public final ScheduledFuture a(p.b bVar) {
                o oVar = this.f10884a;
                return oVar.f10910e.scheduleWithFixedDelay(new Runnable() { // from class: o2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        oVar.f10909c.execute(new Runnable() { // from class: o2.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                o.l(runnable, bVar);
                            }
                        });
                    }
                }, j10, j11, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.f10909c.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f10909c.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j10, TimeUnit timeUnit) {
        return this.f10909c.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j10, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: o2.h
            @Override // o2.p.c
            public final ScheduledFuture a(p.b bVar) {
                o oVar = this.f10889a;
                return oVar.f10910e.schedule(new Callable() { // from class: o2.k
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return oVar.f10909c.submit(new Runnable() { // from class: o2.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                o.g(callable, bVar);
                            }
                        });
                    }
                }, j10, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f10909c.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f10909c.submit(runnable);
    }
}
