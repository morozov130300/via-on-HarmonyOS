package f;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f4402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f4403d = new Executor() { // from class: f.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().c(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f4404e = new Executor() { // from class: f.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().a(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f4405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4406b;

    public c() {
        d dVar = new d();
        this.f4406b = dVar;
        this.f4405a = dVar;
    }

    public static c f() {
        if (f4402c != null) {
            return f4402c;
        }
        synchronized (c.class) {
            try {
                if (f4402c == null) {
                    f4402c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4402c;
    }

    @Override // f.e
    public void a(Runnable runnable) {
        this.f4405a.a(runnable);
    }

    @Override // f.e
    public boolean b() {
        return this.f4405a.b();
    }

    @Override // f.e
    public void c(Runnable runnable) {
        this.f4405a.c(runnable);
    }
}
