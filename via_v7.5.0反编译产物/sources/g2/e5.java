package g2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e5 extends b6 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicLong f4727l = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c5 f4728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c5 f4729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue f4730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f4731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f4732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f4733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f4734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Semaphore f4735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4736k;

    public e5(h5 h5Var) {
        super(h5Var);
        this.f4734i = new Object();
        this.f4735j = new Semaphore(2);
        this.f4730e = new PriorityBlockingQueue();
        this.f4731f = new LinkedBlockingQueue();
        this.f4732g = new a5(this, "Thread death: Uncaught exception on worker thread");
        this.f4733h = new a5(this, "Thread death: Uncaught exception on network thread");
    }

    public static /* bridge */ /* synthetic */ boolean B(e5 e5Var) {
        boolean z10 = e5Var.f4736k;
        return false;
    }

    public final void A(Runnable runnable) {
        k();
        u1.f.h(runnable);
        D(new b5(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean C() {
        return Thread.currentThread() == this.f4728c;
    }

    public final void D(b5 b5Var) {
        synchronized (this.f4734i) {
            try {
                this.f4730e.add(b5Var);
                c5 c5Var = this.f4728c;
                if (c5Var == null) {
                    c5 c5Var2 = new c5(this, "Measurement Worker", this.f4730e);
                    this.f4728c = c5Var2;
                    c5Var2.setUncaughtExceptionHandler(this.f4732g);
                    this.f4728c.start();
                } else {
                    c5Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g2.a6
    public final void g() {
        if (Thread.currentThread() != this.f4729d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // g2.a6
    public final void h() {
        if (Thread.currentThread() != this.f4728c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // g2.b6
    public final boolean j() {
        return false;
    }

    public final Object r(AtomicReference atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.f4646a.f().z(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                this.f4646a.d().w().a("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.f4646a.d().w().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final Future s(Callable callable) {
        k();
        u1.f.h(callable);
        b5 b5Var = new b5(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() != this.f4728c) {
            D(b5Var);
            return b5Var;
        }
        if (!this.f4730e.isEmpty()) {
            this.f4646a.d().w().a("Callable skipped the worker queue.");
        }
        b5Var.run();
        return b5Var;
    }

    public final Future t(Callable callable) {
        k();
        u1.f.h(callable);
        b5 b5Var = new b5(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f4728c) {
            b5Var.run();
            return b5Var;
        }
        D(b5Var);
        return b5Var;
    }

    public final void y(Runnable runnable) {
        k();
        u1.f.h(runnable);
        b5 b5Var = new b5(this, runnable, false, "Task exception on network thread");
        synchronized (this.f4734i) {
            try {
                this.f4731f.add(b5Var);
                c5 c5Var = this.f4729d;
                if (c5Var == null) {
                    c5 c5Var2 = new c5(this, "Measurement Network", this.f4731f);
                    this.f4729d = c5Var2;
                    c5Var2.setUncaughtExceptionHandler(this.f4733h);
                    this.f4729d.start();
                } else {
                    c5Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(Runnable runnable) {
        k();
        u1.f.h(runnable);
        D(new b5(this, runnable, false, "Task exception on worker thread"));
    }
}
