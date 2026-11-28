package t2;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f12466a = t.c("awaitEvenIfOnMainThread task continuation executor");

    public static /* synthetic */ Object a(h2.g gVar, h2.f fVar) {
        if (fVar.k()) {
            gVar.c(fVar.h());
            return null;
        }
        if (fVar.g() == null) {
            return null;
        }
        gVar.b(fVar.g());
        return null;
    }

    public static /* synthetic */ Object b(CountDownLatch countDownLatch, h2.f fVar) {
        countDownLatch.countDown();
        return null;
    }

    public static /* synthetic */ Void c(h2.g gVar, h2.f fVar) {
        if (fVar.k()) {
            gVar.e(fVar.h());
            return null;
        }
        if (fVar.g() == null) {
            return null;
        }
        gVar.d(fVar.g());
        return null;
    }

    public static /* synthetic */ Void d(h2.g gVar, h2.f fVar) {
        if (fVar.k()) {
            gVar.e(fVar.h());
            return null;
        }
        if (fVar.g() == null) {
            return null;
        }
        gVar.d(fVar.g());
        return null;
    }

    public static /* synthetic */ void e(Callable callable, Executor executor, final h2.g gVar) {
        try {
            ((h2.f) callable.call()).e(executor, new h2.a() { // from class: t2.t0
                @Override // h2.a
                public final Object a(h2.f fVar) {
                    return u0.a(gVar, fVar);
                }
            });
        } catch (Exception e10) {
            gVar.b(e10);
        }
    }

    public static Object f(h2.f fVar) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        fVar.e(f12466a, new h2.a() { // from class: t2.p0
            @Override // h2.a
            public final Object a(h2.f fVar2) {
                return u0.b(countDownLatch, fVar2);
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        }
        if (fVar.k()) {
            return fVar.h();
        }
        if (fVar.i()) {
            throw new CancellationException("Task is already canceled");
        }
        if (fVar.j()) {
            throw new IllegalStateException(fVar.g());
        }
        throw new TimeoutException();
    }

    public static boolean g(CountDownLatch countDownLatch, long j10, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z10 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th) {
            if (z10) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static h2.f h(final Executor executor, final Callable callable) {
        final h2.g gVar = new h2.g();
        executor.execute(new Runnable() { // from class: t2.q0
            @Override // java.lang.Runnable
            public final void run() {
                u0.e(callable, executor, gVar);
            }
        });
        return gVar.a();
    }

    public static h2.f i(h2.f fVar, h2.f fVar2) {
        final h2.g gVar = new h2.g();
        h2.a aVar = new h2.a() { // from class: t2.s0
            @Override // h2.a
            public final Object a(h2.f fVar3) {
                return u0.d(gVar, fVar3);
            }
        };
        fVar.d(aVar);
        fVar2.d(aVar);
        return gVar.a();
    }

    public static h2.f j(Executor executor, h2.f fVar, h2.f fVar2) {
        final h2.g gVar = new h2.g();
        h2.a aVar = new h2.a() { // from class: t2.r0
            @Override // h2.a
            public final Object a(h2.f fVar3) {
                return u0.c(gVar, fVar3);
            }
        };
        fVar.e(executor, aVar);
        fVar2.e(executor, aVar);
        return gVar.a();
    }
}
