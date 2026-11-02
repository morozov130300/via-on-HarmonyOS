package s2;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f11798a = t.c("awaitEvenIfOnMainThread task continuation executor");

    public static /* synthetic */ Object a(g2.g gVar, g2.f fVar) {
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

    public static /* synthetic */ Object b(CountDownLatch countDownLatch, g2.f fVar) {
        countDownLatch.countDown();
        return null;
    }

    public static /* synthetic */ Void c(g2.g gVar, g2.f fVar) {
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

    public static /* synthetic */ Void d(g2.g gVar, g2.f fVar) {
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

    public static /* synthetic */ void e(Callable callable, Executor executor, final g2.g gVar) {
        try {
            ((g2.f) callable.call()).e(executor, new g2.a() { // from class: s2.t0
                @Override // g2.a
                public final Object a(g2.f fVar) {
                    return u0.a(gVar, fVar);
                }
            });
        } catch (Exception e10) {
            gVar.b(e10);
        }
    }

    public static Object f(g2.f fVar) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        fVar.e(f11798a, new g2.a() { // from class: s2.p0
            @Override // g2.a
            public final Object a(g2.f fVar2) {
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
        boolean z10 = false;
        try {
            long nanos = timeUnit.toNanos(j10);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static g2.f h(final Executor executor, final Callable callable) {
        final g2.g gVar = new g2.g();
        executor.execute(new Runnable() { // from class: s2.q0
            @Override // java.lang.Runnable
            public final void run() {
                u0.e(callable, executor, gVar);
            }
        });
        return gVar.a();
    }

    public static g2.f i(g2.f fVar, g2.f fVar2) {
        final g2.g gVar = new g2.g();
        g2.a aVar = new g2.a() { // from class: s2.s0
            @Override // g2.a
            public final Object a(g2.f fVar3) {
                return u0.d(gVar, fVar3);
            }
        };
        fVar.d(aVar);
        fVar2.d(aVar);
        return gVar.a();
    }

    public static g2.f j(Executor executor, g2.f fVar, g2.f fVar2) {
        final g2.g gVar = new g2.g();
        g2.a aVar = new g2.a() { // from class: s2.r0
            @Override // g2.a
            public final Object a(g2.f fVar3) {
                return u0.c(gVar, fVar3);
            }
        };
        fVar.e(executor, aVar);
        fVar2.e(executor, aVar);
        return gVar.a();
    }
}
