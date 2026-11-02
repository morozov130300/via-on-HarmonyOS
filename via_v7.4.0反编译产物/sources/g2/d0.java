package g2;

import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d0 extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6141a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final a0 f6142b = new a0();

    /* renamed from: c, reason: collision with root package name */
    public boolean f6143c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f6144d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6145e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f6146f;

    @Override // g2.f
    public final f a(Executor executor, b bVar) {
        this.f6142b.a(new s(executor, bVar));
        v();
        return this;
    }

    @Override // g2.f
    public final f b(Executor executor, c cVar) {
        this.f6142b.a(new u(executor, cVar));
        v();
        return this;
    }

    @Override // g2.f
    public final f c(Executor executor, d dVar) {
        this.f6142b.a(new w(executor, dVar));
        v();
        return this;
    }

    @Override // g2.f
    public final f d(a aVar) {
        return e(h.f6150a, aVar);
    }

    @Override // g2.f
    public final f e(Executor executor, a aVar) {
        d0 d0Var = new d0();
        this.f6142b.a(new o(executor, aVar, d0Var));
        v();
        return d0Var;
    }

    @Override // g2.f
    public final f f(Executor executor, a aVar) {
        d0 d0Var = new d0();
        this.f6142b.a(new q(executor, aVar, d0Var));
        v();
        return d0Var;
    }

    @Override // g2.f
    public final Exception g() {
        Exception exc;
        synchronized (this.f6141a) {
            exc = this.f6146f;
        }
        return exc;
    }

    @Override // g2.f
    public final Object h() {
        Object obj;
        synchronized (this.f6141a) {
            try {
                s();
                t();
                Exception exc = this.f6146f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.f6145e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // g2.f
    public final boolean i() {
        return this.f6144d;
    }

    @Override // g2.f
    public final boolean j() {
        boolean z10;
        synchronized (this.f6141a) {
            z10 = this.f6143c;
        }
        return z10;
    }

    @Override // g2.f
    public final boolean k() {
        boolean z10;
        synchronized (this.f6141a) {
            try {
                z10 = false;
                if (this.f6143c && !this.f6144d && this.f6146f == null) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // g2.f
    public final f l(e eVar) {
        Executor executor = h.f6150a;
        d0 d0Var = new d0();
        this.f6142b.a(new y(executor, eVar, d0Var));
        v();
        return d0Var;
    }

    @Override // g2.f
    public final f m(Executor executor, e eVar) {
        d0 d0Var = new d0();
        this.f6142b.a(new y(executor, eVar, d0Var));
        v();
        return d0Var;
    }

    public final void n(Exception exc) {
        t1.f.i(exc, "Exception must not be null");
        synchronized (this.f6141a) {
            u();
            this.f6143c = true;
            this.f6146f = exc;
        }
        this.f6142b.b(this);
    }

    public final void o(Object obj) {
        synchronized (this.f6141a) {
            u();
            this.f6143c = true;
            this.f6145e = obj;
        }
        this.f6142b.b(this);
    }

    public final boolean p() {
        synchronized (this.f6141a) {
            try {
                if (this.f6143c) {
                    return false;
                }
                this.f6143c = true;
                this.f6144d = true;
                this.f6142b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean q(Exception exc) {
        t1.f.i(exc, "Exception must not be null");
        synchronized (this.f6141a) {
            try {
                if (this.f6143c) {
                    return false;
                }
                this.f6143c = true;
                this.f6146f = exc;
                this.f6142b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean r(Object obj) {
        synchronized (this.f6141a) {
            try {
                if (this.f6143c) {
                    return false;
                }
                this.f6143c = true;
                this.f6145e = obj;
                this.f6142b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        t1.f.l(this.f6143c, "Task is not yet complete");
    }

    public final void t() {
        if (this.f6144d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void u() {
        if (this.f6143c) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    public final void v() {
        synchronized (this.f6141a) {
            try {
                if (this.f6143c) {
                    this.f6142b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
