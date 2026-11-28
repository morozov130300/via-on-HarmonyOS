package h2;

import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5638a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f5639b = new a0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f5641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f5642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Exception f5643f;

    @Override // h2.f
    public final f a(Executor executor, b bVar) {
        this.f5639b.a(new s(executor, bVar));
        v();
        return this;
    }

    @Override // h2.f
    public final f b(Executor executor, c cVar) {
        this.f5639b.a(new u(executor, cVar));
        v();
        return this;
    }

    @Override // h2.f
    public final f c(Executor executor, d dVar) {
        this.f5639b.a(new w(executor, dVar));
        v();
        return this;
    }

    @Override // h2.f
    public final f d(a aVar) {
        return e(h.f5647a, aVar);
    }

    @Override // h2.f
    public final f e(Executor executor, a aVar) {
        d0 d0Var = new d0();
        this.f5639b.a(new o(executor, aVar, d0Var));
        v();
        return d0Var;
    }

    @Override // h2.f
    public final f f(Executor executor, a aVar) {
        d0 d0Var = new d0();
        this.f5639b.a(new q(executor, aVar, d0Var));
        v();
        return d0Var;
    }

    @Override // h2.f
    public final Exception g() {
        Exception exc;
        synchronized (this.f5638a) {
            exc = this.f5643f;
        }
        return exc;
    }

    @Override // h2.f
    public final Object h() {
        Object obj;
        synchronized (this.f5638a) {
            try {
                s();
                t();
                Exception exc = this.f5643f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.f5642e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // h2.f
    public final boolean i() {
        return this.f5641d;
    }

    @Override // h2.f
    public final boolean j() {
        boolean z10;
        synchronized (this.f5638a) {
            z10 = this.f5640c;
        }
        return z10;
    }

    @Override // h2.f
    public final boolean k() {
        boolean z10;
        synchronized (this.f5638a) {
            try {
                z10 = false;
                if (this.f5640c && !this.f5641d && this.f5643f == null) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // h2.f
    public final f l(e eVar) {
        Executor executor = h.f5647a;
        d0 d0Var = new d0();
        this.f5639b.a(new y(executor, eVar, d0Var));
        v();
        return d0Var;
    }

    @Override // h2.f
    public final f m(Executor executor, e eVar) {
        d0 d0Var = new d0();
        this.f5639b.a(new y(executor, eVar, d0Var));
        v();
        return d0Var;
    }

    public final void n(Exception exc) {
        u1.f.i(exc, "Exception must not be null");
        synchronized (this.f5638a) {
            u();
            this.f5640c = true;
            this.f5643f = exc;
        }
        this.f5639b.b(this);
    }

    public final void o(Object obj) {
        synchronized (this.f5638a) {
            u();
            this.f5640c = true;
            this.f5642e = obj;
        }
        this.f5639b.b(this);
    }

    public final boolean p() {
        synchronized (this.f5638a) {
            try {
                if (this.f5640c) {
                    return false;
                }
                this.f5640c = true;
                this.f5641d = true;
                this.f5639b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean q(Exception exc) {
        u1.f.i(exc, "Exception must not be null");
        synchronized (this.f5638a) {
            try {
                if (this.f5640c) {
                    return false;
                }
                this.f5640c = true;
                this.f5643f = exc;
                this.f5639b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean r(Object obj) {
        synchronized (this.f5638a) {
            try {
                if (this.f5640c) {
                    return false;
                }
                this.f5640c = true;
                this.f5642e = obj;
                this.f5639b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        u1.f.l(this.f5640c, "Task is not yet complete");
    }

    public final void t() {
        if (this.f5641d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void u() {
        if (this.f5640c) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    public final void v() {
        synchronized (this.f5638a) {
            try {
                if (this.f5640c) {
                    this.f5639b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
