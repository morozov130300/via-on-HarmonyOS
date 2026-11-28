package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Callable, s6.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final FutureTask f6646p = new FutureTask(w6.a.f13675b, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f6647c;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ExecutorService f6650n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Thread f6651o;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f6649m = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f6648e = new AtomicReference();

    public c(Runnable runnable, ExecutorService executorService) {
        this.f6647c = runnable;
        this.f6650n = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f6651o = Thread.currentThread();
        try {
            this.f6647c.run();
            this.f6651o = null;
            d(this.f6650n.submit(this));
            return null;
        } catch (Throwable th) {
            this.f6651o = null;
            z6.a.o(th);
            throw th;
        }
    }

    public void c(Future future) {
        Future future2;
        do {
            future2 = (Future) this.f6649m.get();
            if (future2 == f6646p) {
                future.cancel(this.f6651o != Thread.currentThread());
                return;
            }
        } while (!autodispose2.c.a(this.f6649m, future2, future));
    }

    public void d(Future future) {
        Future future2;
        do {
            future2 = (Future) this.f6648e.get();
            if (future2 == f6646p) {
                future.cancel(this.f6651o != Thread.currentThread());
                return;
            }
        } while (!autodispose2.c.a(this.f6648e, future2, future));
    }

    @Override // s6.b
    public void dispose() {
        AtomicReference atomicReference = this.f6649m;
        FutureTask futureTask = f6646p;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.f6651o != Thread.currentThread());
        }
        Future future2 = (Future) this.f6648e.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.f6651o != Thread.currentThread());
    }

    @Override // s6.b
    public boolean isDisposed() {
        return this.f6649m.get() == f6646p;
    }
}
