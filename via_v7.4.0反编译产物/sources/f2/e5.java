package f2;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e5 extends b6 {

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicLong f5111l = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c, reason: collision with root package name */
    public c5 f5112c;

    /* renamed from: d, reason: collision with root package name */
    public c5 f5113d;

    /* renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue f5114e;

    /* renamed from: f, reason: collision with root package name */
    public final BlockingQueue f5115f;

    /* renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f5116g;

    /* renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f5117h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f5118i;

    /* renamed from: j, reason: collision with root package name */
    public final Semaphore f5119j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f5120k;

    public e5(h5 h5Var) {
        super(h5Var);
        this.f5118i = new Object();
        this.f5119j = new Semaphore(2);
        this.f5114e = new PriorityBlockingQueue();
        this.f5115f = new LinkedBlockingQueue();
        this.f5116g = new a5(this, "Thread death: Uncaught exception on worker thread");
        this.f5117h = new a5(this, "Thread death: Uncaught exception on network thread");
    }

    public static /* bridge */ /* synthetic */ boolean B(e5 e5Var) {
        boolean z10 = e5Var.f5120k;
        return false;
    }

    public final void A(Runnable runnable) {
        k();
        t1.f.h(runnable);
        D(new b5(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean C() {
        return Thread.currentThread() == this.f5112c;
    }

    public final void D(b5 b5Var) {
        synchronized (this.f5118i) {
            try {
                this.f5114e.add(b5Var);
                c5 c5Var = this.f5112c;
                if (c5Var == null) {
                    c5 c5Var2 = new c5(this, "Measurement Worker", this.f5114e);
                    this.f5112c = c5Var2;
                    c5Var2.setUncaughtExceptionHandler(this.f5116g);
                    this.f5112c.start();
                } else {
                    c5Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f2.a6
    public final void g() {
        if (Thread.currentThread() != this.f5113d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // f2.a6
    public final void h() {
        if (Thread.currentThread() != this.f5112c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // f2.b6
    public final boolean j() {
        return false;
    }

    public final Object r(AtomicReference atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.f5030a.f().z(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                this.f5030a.d().w().a("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.f5030a.d().w().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final Future s(Callable callable) {
        k();
        t1.f.h(callable);
        b5 b5Var = new b5(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() != this.f5112c) {
            D(b5Var);
            return b5Var;
        }
        if (!this.f5114e.isEmpty()) {
            this.f5030a.d().w().a("Callable skipped the worker queue.");
        }
        b5Var.run();
        return b5Var;
    }

    public final Future t(Callable callable) {
        k();
        t1.f.h(callable);
        b5 b5Var = new b5(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5112c) {
            b5Var.run();
            return b5Var;
        }
        D(b5Var);
        return b5Var;
    }

    public final void y(Runnable runnable) {
        k();
        t1.f.h(runnable);
        b5 b5Var = new b5(this, runnable, false, "Task exception on network thread");
        synchronized (this.f5118i) {
            try {
                this.f5115f.add(b5Var);
                c5 c5Var = this.f5113d;
                if (c5Var == null) {
                    c5 c5Var2 = new c5(this, "Measurement Network", this.f5115f);
                    this.f5113d = c5Var2;
                    c5Var2.setUncaughtExceptionHandler(this.f5117h);
                    this.f5113d.start();
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
        t1.f.h(runnable);
        D(new b5(this, runnable, false, "Task exception on worker thread"));
    }
}
