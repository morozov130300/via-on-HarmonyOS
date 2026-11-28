package t2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f12346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h2.f f12347b = h2.i.e(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12348c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal f12349d = new ThreadLocal();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f12349d.set(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements h2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f12351a;

        public b(Callable callable) {
            this.f12351a = callable;
        }

        @Override // h2.a
        public Object a(h2.f fVar) {
            return this.f12351a.call();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements h2.a {
        public c() {
        }

        @Override // h2.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(h2.f fVar) {
            return null;
        }
    }

    public h(Executor executor) {
        this.f12346a = executor;
        executor.execute(new a());
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.f12346a;
    }

    public final h2.f d(h2.f fVar) {
        return fVar.e(this.f12346a, new c());
    }

    public final boolean e() {
        return Boolean.TRUE.equals(this.f12349d.get());
    }

    public final h2.a f(Callable callable) {
        return new b(callable);
    }

    public h2.f g(Callable callable) {
        h2.f fVarE;
        synchronized (this.f12348c) {
            fVarE = this.f12347b.e(this.f12346a, f(callable));
            this.f12347b = d(fVarE);
        }
        return fVarE;
    }

    public h2.f h(Callable callable) {
        h2.f fVarF;
        synchronized (this.f12348c) {
            fVarF = this.f12347b.f(this.f12346a, f(callable));
            this.f12347b = d(fVarF);
        }
        return fVarF;
    }
}
